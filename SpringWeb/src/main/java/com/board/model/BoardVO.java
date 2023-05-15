package com.board.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	// 글쓰기, 글 수정하기, 답변 글쓰기
	
	private String mode;
	/* 
	 * 글쓰기 : write
	 * 답변 글쓰기 : rewrite
	 * 글 수정 : edit
	 * 
	 * */
	
	
	private int num;
	private String userid;
	private String passwd;
	private String subject;
	private String content;
	
	private Date wdate; 
	private int readnum;
	
	private String filename; // 물리적 파일명 => uuid_파일명
	private String originFilename; // 원본 파일명
	private long filesize; // 파일 크기 
	
	private String old_filename; // 예전에 첨부한 파일명 - 글 수정시 사용
	
	// 답변형 게시판에서 필요한 property
	private int refer; // 글그룹 번호 
	private int lev; // 답변 레벨
	private int sunbun; // 같은 글 그룹 내의 순서	
}
