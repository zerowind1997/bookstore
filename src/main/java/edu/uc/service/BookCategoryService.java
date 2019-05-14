package edu.uc.service;

import java.util.List;

import edu.uc.bean.BookCategory;

public interface BookCategoryService extends BaseService<BookCategory> {
	List<BookCategory> getParentIdList(Long id);
}
