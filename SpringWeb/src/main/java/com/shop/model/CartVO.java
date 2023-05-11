package com.shop.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CartVO {

	private int cartNum; // 장바구니 번호
	private int idx_fk; // 회원번호
	private int pnum_fk; // 상품 번호
	private int pqty; // 장바구니 상품 수량
	private Date indate; // 날짜
	
	// 장바구니 상품 정보
	private String pname;
	private String pimage1;
	private int price;
	private int saleprice;
	private int point;
	private int totalPrice; // saleprice*pqty => 개별 상품의 총액
	private int totalPoint; // point*pqty => 개별 포인트의 총액
	private int cartTotalPrice; // 장바구니에 담은 모든 상품의 총액
	private int cartTotalPoint; // 장바구니에 담은 모든 상품 포인트의 총액
	
	
	
	
}
