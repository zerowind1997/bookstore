package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.HeadLine;
import edu.uc.dao.HeadLineDao;

@Repository("headLineDao")
public class HeadLineDaoImpl extends BaseDaoImpl<HeadLine> implements HeadLineDao {

	@Override
	public List<HeadLine> list() {
		// TODO Auto-generated method stub
		List<HeadLine> HeadLineList = new ArrayList<HeadLine>();
		String hql = "from HeadLine";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			HeadLineList = getTmpl().execute(this.getCallbackList(HeadLine.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return HeadLineList;
	}

	@Override
	public Long insert(HeadLine bean) {
		Long result = 0L;
		try {
			getTmpl().save(bean);
			result = bean.getId();
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
			HeadLine admin = getTmpl().get(HeadLine.class, id);
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
	public Long update(HeadLine bean) {
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
	public HeadLine load(Long id) {
		HeadLine HeadLine = null;
		try {
			// get load方法是通过主键获取对象
			HeadLine = getTmpl().get(HeadLine.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return HeadLine;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from HeadLine";
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
	public List<HeadLine> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<HeadLine> HeadLineList = new ArrayList<HeadLine>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from HeadLine";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			HeadLineList = getTmpl().execute(this.getCallbackPager(HeadLine.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return HeadLineList;
	}

	@Override
	public HeadLine loadByName(String name) {

		HeadLine HeadLine = null;
		String hql = "from HeadLine where lineName=?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			HeadLine = getTmpl().execute(this.getCallbackBean(HeadLine.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return HeadLine;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from HeadLine where lineName like ?0";
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
	public List<HeadLine> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<HeadLine> HeadLineList = new ArrayList<HeadLine>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from HeadLine where lineName like ?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			HeadLineList = getTmpl().execute(this.getCallbackPager(HeadLine.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return HeadLineList;
	}

}
