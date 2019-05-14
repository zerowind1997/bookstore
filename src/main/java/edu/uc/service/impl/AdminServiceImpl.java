package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.Manager;
import edu.uc.dao.AdminDao;

@Service("adminService")
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Manager> implements edu.uc.service.AdminService {

	@Autowired
	private AdminDao adminDao;
	@Override
	public List<Manager> list() {
		// TODO Auto-generated method stub
		return adminDao.list();
	}

	@Override
	public Long insert(Manager bean) {
		// TODO Auto-generated method stub
		return adminDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return adminDao.delete(id);
	}

	@Override
	public Long update(Manager bean) {
		// TODO Auto-generated method stub
		return adminDao.update(bean);
	}

	@Override
	public Manager load(Long id) {
		// TODO Auto-generated method stub
		return adminDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return adminDao.count();
	}

	@Override
	public List<Manager> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return adminDao.pager(pageNum, pageSize);
	}

	@Override
	public Manager loadByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.countByName(name);
	}

	@Override
	public List<Manager> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return adminDao.pagerByName(name, pageNum, pageSize);
	}
	
}
