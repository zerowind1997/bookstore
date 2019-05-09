package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.Customer;
import edu.uc.dao.CustomerDao;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		List<Customer> CustomerList = new ArrayList<Customer>();
		String hql = "from Customer";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			CustomerList = getTmpl().execute(this.getCallbackList(Customer.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return CustomerList;
	}

	@Override
	public Long insert(Customer bean) {
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
			Customer admin = getTmpl().get(Customer.class, id);
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
	public Long update(Customer bean) {
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
	public Customer load(Long id) {
		Customer Customer = null;
		try {
			// get load方法是通过主键获取对象
			Customer = getTmpl().get(Customer.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return Customer;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from Customer";
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
	public List<Customer> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Customer> CustomerList = new ArrayList<Customer>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from Customer";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			CustomerList = getTmpl().execute(this.getCallbackPager(Customer.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return CustomerList;
	}

	@Override
	public Customer loadByName(String name) {

		Customer Customer = null;
		String hql = "from Customer where userNick=?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			Customer = getTmpl().execute(this.getCallbackBean(Customer.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return Customer;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from Customer where userNick like ?0";
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
	public List<Customer> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Customer> CustomerList = new ArrayList<Customer>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from Customer where userNick like ?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			CustomerList = getTmpl().execute(this.getCallbackPager(Customer.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return CustomerList;
	}

}
