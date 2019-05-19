package edu.uc.dao;

import java.util.List;

import edu.uc.bean.Book;

public interface BookDao extends BaseDao<Book> {
	
	public Long countById(String name,Long bookCategoryId);
	public List<Book> pagerById(String name,Long bookCategoryId,Long pageNum, Long pageSize);

}
