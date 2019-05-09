package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.Book;
import edu.uc.dao.BookDao;
import edu.uc.service.BookService;
@Service("bookService")
@Transactional
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {

	@Autowired 
	private BookDao bookDao;
	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return bookDao.list();
	}

	@Override
	public Long insert(Book bean) {
		// TODO Auto-generated method stub
		return bookDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return bookDao.delete(id);
	}

	@Override
	public Long update(Book bean) {
		// TODO Auto-generated method stub
		return bookDao.update(bean);
	}

	@Override
	public Book load(Long id) {
		// TODO Auto-generated method stub
		return bookDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return bookDao.count();
	}

	@Override
	public List<Book> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return bookDao.pager(pageNum, pageSize);
	}

	@Override
	public Book loadByName(String name) {
		// TODO Auto-generated method stub
		return bookDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return bookDao.countByName(name);
	}

	@Override
	public List<Book> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return bookDao.pagerByName(name, pageNum, pageSize);
	}

}
