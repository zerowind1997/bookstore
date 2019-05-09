package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.OrderComment;
import edu.uc.dao.OrderCommentDao;

@Repository("orderCommentDao")
public class OrderCommentDaoImpl extends BaseDaoImpl<OrderComment> implements OrderCommentDao {

	@Override
	public List<OrderComment> list() {
		// TODO Auto-generated method stub
		List<OrderComment> OrderCommentList = new ArrayList<OrderComment>();
		String hql = "from OrderComment";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			OrderCommentList = getTmpl().execute(this.getCallbackList(OrderComment.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return OrderCommentList;
	}

	@Override
	public Long insert(OrderComment bean) {
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
			OrderComment admin = getTmpl().get(OrderComment.class, id);
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
	public Long update(OrderComment bean) {
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
	public OrderComment load(Long id) {
		OrderComment OrderComment = null;
		try {
			// get load方法是通过主键获取对象
			OrderComment = getTmpl().get(OrderComment.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return OrderComment;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from OrderComment";
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
	public List<OrderComment> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<OrderComment> OrderCommentList = new ArrayList<OrderComment>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from OrderComment";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			OrderCommentList = getTmpl().execute(this.getCallbackPager(OrderComment.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return OrderCommentList;
	}

	@Override
	public OrderComment loadByName(String name) {

		OrderComment OrderComment = null;
		String hql = "from OrderComment where userNick=?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			OrderComment = getTmpl().execute(this.getCallbackBean(OrderComment.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return OrderComment;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from OrderComment where userNick like ?0";
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
	public List<OrderComment> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<OrderComment> OrderCommentList = new ArrayList<OrderComment>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from OrderComment where userNick like ?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			OrderCommentList = getTmpl().execute(this.getCallbackPager(OrderComment.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return OrderCommentList;
	}

}
