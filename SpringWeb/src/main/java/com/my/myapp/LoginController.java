package com.my.myapp;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.model.NotUserException;
import com.user.model.UserVO;
import com.user.service.UserService;

@Controller
public class LoginController {

	@Resource(name="userService")
	//	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login/login";
		// WEB-INF/views/login/login.jsp
	}
	
	@PostMapping("/login")
	public String loginProcess(HttpSession session,
			HttpServletResponse response,
			@ModelAttribute("user") UserVO user,
			@RequestParam(defaultValue="off") String saveId) throws NotUserException {
		System.out.println("saveId: "+saveId);
//		System.out.println("id: "+user.getUserid()+", pwd : "+user.getPwd());
		if(user.getUserid()==null || user.getPwd()==null || user.getUserid().trim().isEmpty()||user.getPwd().trim().isEmpty()) {
			return "redirect:login";
		}
		
		UserVO loginUser = userService.loginCheck(user.getUserid(), user.getPwd());
		// userId와 pwd 가 일치하지 않으면 NotUserException 발생
		// 				  일치하면 회원 정보를 담은 UserVO 객체 반환 => session에 저장 
		
		
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			Cookie ck = new Cookie("uid",loginUser.getUserid());
			if(saveId.equals("on")) {
				ck.setMaxAge(7*24*60*60);
			}else {
				ck.setMaxAge(0);
			}
			ck.setPath("/");
			response.addCookie(ck);
		}
		return "redirect:index";
		
	}// ---------------------------------------------------------------------
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
	// 예외처리하는 메서드 앞에 @ExceptionHandler를 붙이고 구체적인 예외 클래스를 지정한다.
	/*
	 * @ExceptionHandler(NotUserException.class) public String
	 * exceptionHandler(Exception ex, Model m) { ex.printStackTrace();
	 * m.addAttribute("exception",ex); return "login/errorAlert"; }
	 */
	
}
