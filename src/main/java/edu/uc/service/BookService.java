package edu.uc.service;

import java.util.List;

import edu.uc.bean.Book;

public interface BookService extends BaseService<Book> {

	public Long countById(String name,Long bookCategoryId);
	public List<Book> pagerById(String name,Long bookCategoryId,Long pageNum, Long pageSize);
}
