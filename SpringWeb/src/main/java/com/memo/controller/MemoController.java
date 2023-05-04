package com.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.memo.model.MemoDAO;
import com.memo.model.MemoVO;

@Controller
public class MemoController {
	
	// @Autowired: MemoDAO 타입의 객체가 있으면 해당 객체를 주입해준다.
	@Autowired
	private MemoDAO memoDao;

	@RequestMapping(value="/memo", method=RequestMethod.GET)
	public String memoForm() {
		return "memo/input";	// 뷰 네임
		// /WEB-INF/views/memo/input.jsp
	}
	
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String memoInsert(Model model, @ModelAttribute MemoVO memo) {
		
		// @ModelAttribute를 붙이면 html의 input name하고 VO 객체의 property 명이 같을 경우 
		// 자동으로 입력값을 VO에 setting 해준다
		// System.out.println(memo.getName() + "/" + memo.getMsg());
		
		int n = memoDao.insertMemo(memo);
		String str = (n > 0) ? "메모 등록 완료" : "등록 실패";
		String loc = (n > 0) ? "memoList" : "javascript:history.back()";
		
		model.addAttribute("msg", str);
		model.addAttribute("loc", loc);
		
		return "message";	// 뷰 네임
		// /WEB-INF/views/message.jsp
	}
	
	@RequestMapping(value="/memoList")
	public String memoList(Model model, @RequestParam(defaultValue="1") int cpage) {
//		System.out.println("cpage: " + cpage);

		if(cpage <= 0) {
			cpage = 1;
		}
		
		// 총 게시글 수 가져오기
		int totalCount = memoDao.getTotalCount();
		
		int pageSize = 10;
		int pageCount = (totalCount - 1) / pageSize + 1;
		
		if(cpage > pageCount) {
			cpage = pageCount;
		}
		
		int end = cpage * pageSize;
		int start = end - pageSize;
		
		
		model.addAttribute("totalCount", totalCount);
		
		// 전체글 가져오기
		List<MemoVO> memoArr = memoDao.listMemo(start, end);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("memoArr", memoArr);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("cpage", cpage);
		
		return "memo/list";	// 뷰 네임
	}
	
	@RequestMapping(value="/memoEdit", method=RequestMethod.GET)
	public String memoEditForm(Model model, @RequestParam(defaultValue="0") int no) {
		// 1. 글번호 유효성 체크 => memoList로 redirect 이동 
		if(no == 0) {
			return "redirect: memoList";
		}
		
		// 2. memoDao.getMemo(글번호) ==> MemoVO 객체를 model에 저장
		MemoVO vo = memoDao.getMemo(no);
		model.addAttribute("memo", vo);
		
		return "memo/edit";
	}
	
	@RequestMapping(value="/memoEdit", method=RequestMethod.POST)
	public String memoEditEnd(Model model, @ModelAttribute("memo") MemoVO memo) {
		
		// memoDao의 updateMemo(memo)
		int n = memoDao.updateMemo(memo);
		String str = (n > 0) ? "수정 성공" : "수정 실패";
		String loc = (n > 0) ? "memoList" : "javascript:history.back()";
		
		
		model.addAttribute("msg", str);
		model.addAttribute("loc", loc);
		
		return "message";
	}
	
	@RequestMapping(value="/memoDel")
	public String memoDelete(Model model, @RequestParam(defaultValue="0") int no) {
		
		// no 파라미터 값이 넘어오지 않으면 디폴트 값을 0으로 준다
		// System.out.println("no: " + no);
		if(no == 0) {
			// 유효성 체크
			return "redirect: memoList";
			// "redirect: 뷰이름" 접두어 redirect: 을 붙이면 redirect 방식으로 이동한다
			// 브라우저의 URL을 memoList로 바꾸고 새로운 요청
		}
		
		int n = memoDao.deleteMemo(no);
		
		String str = (n > 0) ? "삭제 성공" : "삭제 실패";
		String loc = "memoList";
		
		model.addAttribute("msg", str);
		model.addAttribute("loc", loc);
		return "message";	// 뷰 네임
	}
	
}
