package com.multi.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.multi.domain.BookVO;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Override
	public List<BookVO> getAllBook() {
		return null;
	}

	@Override
	public BookVO getBookInfo(String isbn) {
		return null;
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
