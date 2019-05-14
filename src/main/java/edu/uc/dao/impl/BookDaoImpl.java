package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.Book;
import edu.uc.dao.BookDao;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {


	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		List<Book> BookList = new ArrayList<Book>();
		String hql = "from Book";
		hql += " order by bookId desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			BookList = getTmpl().execute(this.getCallbackList(Book.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return BookList;
	}

	@Override
	public Long insert(Book bean) {
		Long result = 0L;
		try {
			getTmpl().save(bean);
			result = bean.getBookId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();

		} finally {

		}
		return result;
	}

	@Override
	public Long delete(Long id) {
		Long result = 0L;
		try {
			// get load方法是通过主键获取对象
			Book admin = getTmpl().get(Book.class, id);
			if (admin != null) {
				getTmpl().delete(admin);
			}
			if (admin != null) {
				result = 1L;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
		}
		return result;
	}

	@Override
	public Long update(Book bean) {
		Long result = 0L;
		try {
			getTmpl().update(bean);
			result = bean.getBookId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

		}
		return result;
	}

	@Override
	public Book load(Long id) {
		Book Book = null;
		try {
			// get load方法是通过主键获取对象
			Book = getTmpl().get(Book.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return Book;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from Book";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			result = getTmpl().execute(this.getCallbackScalarLong(hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return result;
	}

	@SuppressWarnings("static-access")
	@Override
	public List<Book> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Book> BookList = new ArrayList<Book>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from Book";
		hql += " order by bookId desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			BookList = getTmpl().execute(this.getCallbackPager(Book.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return BookList;
	}

	@Override
	public Book loadByName(String name) {

		Book Book = null;
		String hql = "from Book where bookName=?0";
		hql += " order by bookId desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			Book = getTmpl().execute(this.getCallbackBean(Book.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return Book;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from Book where bookName like ?0";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			result = getTmpl().execute(this.getCallbackScalarLong(hql, params));

		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return result;
	}

	@SuppressWarnings("static-access")
	@Override
	public List<Book> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Book> BookList = new ArrayList<Book>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from Book where bookName like ?0";
		hql += " order by bookId desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			BookList = getTmpl().execute(this.getCallbackPager(Book.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return BookList;
	}


}
