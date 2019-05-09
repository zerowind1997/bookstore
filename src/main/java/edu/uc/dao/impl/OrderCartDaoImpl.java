package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.OrderCart;
import edu.uc.dao.OrderCartDao;

@Repository("orderCartDao")
public class OrderCartDaoImpl extends BaseDaoImpl<OrderCart> implements OrderCartDao {

	@Override
	public List<OrderCart> list() {
		// TODO Auto-generated method stub
		List<OrderCart> OrderCartList = new ArrayList<OrderCart>();
		String hql = "from OrderCart";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			OrderCartList = getTmpl().execute(this.getCallbackList(OrderCart.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return OrderCartList;
	}

	@Override
	public Long insert(OrderCart bean) {
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
			OrderCart admin = getTmpl().get(OrderCart.class, id);
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
	public Long update(OrderCart bean) {
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
	public OrderCart load(Long id) {
		OrderCart OrderCart = null;
		try {
			// get load方法是通过主键获取对象
			OrderCart = getTmpl().get(OrderCart.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return OrderCart;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from OrderCart";
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
	public List<OrderCart> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<OrderCart> OrderCartList = new ArrayList<OrderCart>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from OrderCart";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			OrderCartList = getTmpl().execute(this.getCallbackPager(OrderCart.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return OrderCartList;
	}

	@Override
	public OrderCart loadByName(String name) {

		OrderCart OrderCart = null;
		String hql = "from OrderCart where bookName=?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			OrderCart = getTmpl().execute(this.getCallbackBean(OrderCart.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return OrderCart;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from OrderCart where bookName like ?0";
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
	public List<OrderCart> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<OrderCart> OrderCartList = new ArrayList<OrderCart>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from OrderCart where bookName like ?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			OrderCartList = getTmpl().execute(this.getCallbackPager(OrderCart.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return OrderCartList;
	}

}
