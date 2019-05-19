package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.OrderComment;
import edu.uc.dao.OrderCommentDao;
import edu.uc.service.OrderCommentService;
@Service("orderCommentService")
@Transactional
public class OrderCommentServiceImpl extends BaseServiceImpl<OrderComment> implements OrderCommentService {

	@Autowired
	private OrderCommentDao orderCommentDao;
	@Override
	public List<OrderComment> list() {
		// TODO Auto-generated method stub
		return orderCommentDao.list();
	}

	@Override
	public Long insert(OrderComment bean) {
		// TODO Auto-generated method stub
		return orderCommentDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return orderCommentDao.delete(id);
	}

	@Override
	public Long update(OrderComment bean) {
		// TODO Auto-generated method stub
		return orderCommentDao.update(bean);
	}

	@Override
	public OrderComment load(Long id) {
		// TODO Auto-generated method stub
		return orderCommentDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return orderCommentDao.count();
	}

	@Override
	public List<OrderComment> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderCommentDao.pager(pageNum, pageSize);
	}

	@Override
	public OrderComment loadByName(String name) {
		// TODO Auto-generated method stub
		return orderCommentDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return orderCommentDao.countByName(name);
	}

	@Override
	public List<OrderComment> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderCommentDao.pagerByName(name, pageNum, pageSize);
	}

	@Override
	public Long countById(Long bookId) {
		// TODO Auto-generated method stub
		return orderCommentDao.countById(bookId);
	}

	@Override
	public Long countByPraise(String praise, Long bookId) {
		// TODO Auto-generated method stub
		return orderCommentDao.countByPraise(praise, bookId);
	}

	@Override
	public List<OrderComment> pagerById(Long bookId, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return orderCommentDao.pagerById(bookId, pageNum, pageSize);
	}

}
