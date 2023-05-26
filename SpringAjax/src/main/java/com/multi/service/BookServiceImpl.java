package com.multi.service;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.multi.domain.BookVO;
import com.multi.mapper.BookMapper;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Inject
	private BookMapper bMapper;
	
	@Override
	public List<BookVO> getAllBook() {
		return bMapper.getAllBook();
	}

	@Override
	public BookVO getBookInfo(String isbn) {
		return bMapper.getBookInfo(isbn);
	}

	@Override
	public int insertBook(BookVO book) {
		return 0;
	}

	@Override
	public int deleteBook(String isbn) {
		return 0;
	}
	
}
