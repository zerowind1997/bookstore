package edu.uc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uc.bean.Manager;
import edu.uc.dao.AdminDao;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Manager> implements AdminDao {

	@Override
	public List<Manager> list() {
		// TODO Auto-generated method stub
		List<Manager> managerList = new ArrayList<Manager>();
		String hql = "from Manager";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {
			managerList = getTmpl().execute(this.getCallbackList(Manager.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return managerList;
	}

	@Override
	public Long insert(Manager bean) {
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
			Manager admin = getTmpl().get(Manager.class, id);
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
	public Long update(Manager bean) {
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
	public Manager load(Long id) {
		Manager manager = null;
		try {
			// get load方法是通过主键获取对象
			manager = getTmpl().get(Manager.class, id);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
		}
		return manager;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		Long result = 0L;
		String hql = "select count(1) from Manager";
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
	public List<Manager> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Manager> managerList = new ArrayList<Manager>();
		Long vStart = 0L;
		vStart = (pageNum - 1) * pageSize;
		String hql = "from Manager";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		Object[] params = arrParams.toArray();
		try {

			managerList = getTmpl().execute(this.getCallbackPager(Manager.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return managerList;
	}

	@Override
	public Manager loadByName(String name) {

		Manager manager = null;
		String hql = "from Manager where userId=?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {
			manager = getTmpl().execute(this.getCallbackBean(Manager.class, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return manager;
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		Long result = 0L;
		name = "%" + name + "%";
		String hql = "select count(1) from Manager where userId like ?0";
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
	public List<Manager> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		List<Manager> managerList = new ArrayList<Manager>();
		Long vStart = 0L;
		name = "%" + name + "%";
		vStart = (pageNum - 1) * pageSize;
		String hql = "from Manager where userId like ?0";
		hql += " order by id desc";
		List<Object> arrParams = new ArrayList<Object>();
		arrParams.add(name);
		Object[] params = arrParams.toArray();
		try {

			managerList = getTmpl().execute(this.getCallbackPager(Manager.class, vStart, pageSize, hql, params));
		} catch (Exception e) {
			throw new RuntimeException();

		} finally {

		}
		return managerList;
	}

}
