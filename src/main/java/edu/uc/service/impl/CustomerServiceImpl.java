package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.Customer;
import edu.uc.dao.CustomerDao;
import edu.uc.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

	@Autowired 
	private CustomerDao customerDao;
	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return customerDao.list();
	}

	@Override
	public Long insert(Customer bean) {
		// TODO Auto-generated method stub
		return customerDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return customerDao.delete(id);
	}

	@Override
	public Long update(Customer bean) {
		// TODO Auto-generated method stub
		return customerDao.update(bean);
	}

	@Override
	public Customer load(Long id) {
		// TODO Auto-generated method stub
		return customerDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return customerDao.count();
	}

	@Override
	public List<Customer> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return customerDao.pager(pageNum, pageSize);
	}

	@Override
	public Customer loadByName(String name) {
		// TODO Auto-generated method stub
		return customerDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return customerDao.countByName(name);
	}

	@Override
	public List<Customer> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return customerDao.pagerByName(name, pageNum, pageSize);
	}

}
