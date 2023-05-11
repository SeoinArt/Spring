package com.shop.service;

import java.util.List;

import com.shop.model.CategoryVO;
import com.shop.model.ProductVO;

public interface AdminService {
	
	public List<CategoryVO> getUpcategory();
	
	public List<CategoryVO> getDowncategory(int upCg_code);
	
	public int categoryAdd(CategoryVO cvo);
	
	public int categoryDelete(int cg_code);
	


	/** [관리자 모드]- 상품 정보 등록하기 */
	public int productInsert(ProductVO prod);
	
	// 상위 카테고리에 해당하는 하위 카테고리 목록 가져오기
	public List<ProductVO> productList();

}
