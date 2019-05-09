package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.OrderCart;
import edu.uc.dao.OrderCartDao;
import edu.uc.service.OrderCartService;
@Service("orderCartService")
@Transactional
public class OrderCartServiceImpl extends BaseServiceImpl<OrderCart> implements OrderCartService {

	@Autowired
	private OrderCartDao orderCartDao;
	@Override
	public List<OrderCart> list() {
		// TODO Auto-generated method stub
		return orderCartDao.list();
	}

	@Override
	public Long insert(OrderCart bean) {
		// TODO Auto-generated method stub
		return orderCartDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return orderCartDao.delete(id);
	}

	@Override
	public Long update(OrderCart bean) {
		// TODO Auto-generated method stub
		return orderCartDao.update(bean);
	}

	@Override
	public OrderCart load(Long id) {
		// TODO Auto-generated method stub
		return orderCartDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return orderCartDao.count();
	}

	@Override
	public List<OrderCart> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderCartDao.pager(pageNum, pageSize);
	}

	@Override
	public OrderCart loadByName(String name) {
		// TODO Auto-generated method stub
		return orderCartDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return orderCartDao.countByName(name);
	}

	@Override
	public List<OrderCart> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderCartDao.pagerByName(name, pageNum, pageSize);
	}

}
