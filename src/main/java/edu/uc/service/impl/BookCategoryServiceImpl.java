package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.BookCategory;
import edu.uc.dao.BookCategoryDao;
import edu.uc.service.BookCategoryService;

@Service("bookCategoryService")
@Transactional
public class BookCategoryServiceImpl extends BaseServiceImpl<BookCategory> implements BookCategoryService {

	@Autowired
	private BookCategoryDao bookCategoryDao;
	@Override
	public List<BookCategory> list() {
		// TODO Auto-generated method stub
		return bookCategoryDao.list();
	}

	@Override
	public Long insert(BookCategory bean) {
		// TODO Auto-generated method stub
		return bookCategoryDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return bookCategoryDao.delete(id);
	}

	@Override
	public Long update(BookCategory bean) {
		// TODO Auto-generated method stub
		return bookCategoryDao.update(bean);
	}

	@Override
	public BookCategory load(Long id) {
		// TODO Auto-generated method stub
		return bookCategoryDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return bookCategoryDao.count();
	}

	@Override
	public List<BookCategory> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return bookCategoryDao.pager(pageNum, pageSize);
	}

	@Override
	public BookCategory loadByName(String name) {
		// TODO Auto-generated method stub
		return bookCategoryDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return bookCategoryDao.countByName(name);
	}

	@Override
	public List<BookCategory> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return bookCategoryDao.pagerByName(name, pageNum, pageSize);
	}

	@Override
	public List<BookCategory> getParentIdList(Long id) {
		// TODO Auto-generated method stub
		return bookCategoryDao.getParentIdList(id);
	}
	
}
