package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.BookCategory;
import edu.uc.dao.BookCategoryDao;

@Repository("bookCategoryDao")
public class BookCategoryDaoImpl extends BaseDaoImpl<BookCategory> implements BookCategoryDao {


	@Override
	public List<BookCategory> list() {
		// TODO Auto-generated method stub
		List<BookCategory> BookCategoryList = new ArrayList<BookCategory>();
		String hql = "from BookCategory";
		hql += " order by categoryId desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			BookCategoryList = getTmpl().execute(this.getCallbackList(BookCategory.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return BookCategoryList;
	}

	@Override
	public Long insert(BookCategory bean) {
		Long result = 0L;
		try {
			getTmpl().save(bean);
			result = bean.getCategoryId();
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
			BookCategory admin = getTmpl().get(BookCategory.class, id);
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
	public Long update(BookCategory bean) {
		Long result = 0L;
		try {
			getTmpl().update(bean);
			result = 1L;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

		}
		return result;
	}

	@Override
	public BookCategory load(Long id) {
		BookCategory BookCategory = null;
		try {
			// get load方法是通过主键获取对象
			BookCategory = getTmpl().get(BookCategory.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return BookCategory;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from BookCategory";
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
	public List<BookCategory> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<BookCategory> BookCategoryList = new ArrayList<BookCategory>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from BookCategory";
		hql += " order by categoryId desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			BookCategoryList = getTmpl().execute(this.getCallbackPager(BookCategory.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return BookCategoryList;
	}

	@Override
	public BookCategory loadByName(String name) {

		BookCategory BookCategory = null;
		String hql = "from BookCategory where categoryName=?0";
		hql += " order by categoryId desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			BookCategory = getTmpl().execute(this.getCallbackBean(BookCategory.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return BookCategory;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from BookCategory where categoryName like ?0";
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
	public List<BookCategory> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<BookCategory> BookCategoryList = new ArrayList<BookCategory>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from BookCategory where categoryName like ?0";
		hql += " order by categoryId desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			BookCategoryList = getTmpl().execute(this.getCallbackPager(BookCategory.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return BookCategoryList;
	}


}
