package edu.uc.dao;

import java.util.List;

import edu.uc.bean.BookCategory;

public interface BookCategoryDao extends BaseDao<BookCategory>{
	List<BookCategory> getParentIdList(Long id);
}
