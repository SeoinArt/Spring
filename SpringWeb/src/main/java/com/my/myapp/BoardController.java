package com.my.myapp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.model.BoardVO;
import com.board.service.BoardService;
import com.common.CommonUtil;

import lombok.extern.log4j.Log4j;


   @Controller
   @RequestMapping("/board")
   @Log4j
   public class BoardController {
      
      @Resource(name="boardService")
      private BoardService boardService;
      
      @Autowired
      private CommonUtil util;
      
      @GetMapping("/write")
      public String boardForm() {
         
         return "board/boardWrite";
         //WEB-INF/views/board/boardWrite.jsp
      }
      
      @PostMapping("/write")
      public String boardInsert(Model m, @ModelAttribute BoardVO board) {
         log.info("board="+board);
         //1. 파일 업로드 처리

         //2. 유효성 체크 (제목,작성자,비번)=> write로 redirect 이동
         if(board.getSubject()==null||board.getUserid()==null||board.getPasswd()==null||
            board.getSubject().trim().isEmpty()||board.getUserid().trim().isEmpty()||board.getPasswd().trim().isEmpty()){
               
               return "redirect:write";
            }
         
         //3. boardService의 insertBoard()호출
         int n=0;
         String str="";
         if("write".equals(board.getMode())) {
            n=boardService.insertBoard(board);
            str="글쓰기";
         }else if("edit".equals(board.getMode())) {
            //수정처리
            str="글수정";
            
         }else if("rewrite".equals(board.getMode())) {
            //답변 글쓰기
            str="답변 글쓰기";
         }
         str+=(n>0)?"성공":"실패";
         String loc=(n>0)?"list":"javascript:history.back()";
         //4. 그 결과 메시지,이동경로처리
         
         return util.addMsgLoc(m, str, loc);
      }
      
      @GetMapping("/list")
      public String boardList(Model m) {
    	  //1. 총 게시글 수 가져오기
    	  int totalCount = boardService.getTotalCount();
    	  //2. 게시목록 가져오기
    	  List<BoardVO> boardArr = this.boardService.selectBoardAll(null);
    	  
    	  m.addAttribute("boardArr", boardArr);
    	  m.addAttribute("totalCount",totalCount);
    	  //3. board Model에 저장
    	  return "board/boardList";
      }
      
      
      
      
      
}