package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.Order;
import edu.uc.dao.OrderDao;
import edu.uc.service.OrderService;
@Service("orderService")
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Override
	public List<Order> list() {
		// TODO Auto-generated method stub
		return orderDao.list();
	}

	@Override
	public Long insert(Order bean) {
		// TODO Auto-generated method stub
		return orderDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return orderDao.delete(id);
	}

	@Override
	public Long update(Order bean) {
		// TODO Auto-generated method stub
		return orderDao.update(bean);
	}

	@Override
	public Order load(Long id) {
		// TODO Auto-generated method stub
		return orderDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return orderDao.count();
	}

	@Override
	public List<Order> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderDao.pager(pageNum, pageSize);
	}

	@Override
	public Order loadByName(String name) {
		// TODO Auto-generated method stub
		return orderDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return orderDao.countByName(name);
	}

	@Override
	public List<Order> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderDao.pagerByName(name, pageNum, pageSize);
	}


}
