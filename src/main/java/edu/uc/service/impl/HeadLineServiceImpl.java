package edu.uc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uc.bean.HeadLine;
import edu.uc.dao.HeadLineDao;
import edu.uc.service.HeadLineService;

@Service("headLineService")
@Transactional
public class HeadLineServiceImpl extends BaseServiceImpl<HeadLine> implements HeadLineService {

	@Autowired
	private HeadLineDao headLineDao;
	@Override
	public List<HeadLine> list() {
		// TODO Auto-generated method stub
		return headLineDao.list();
	}

	@Override
	public Long insert(HeadLine bean) {
		// TODO Auto-generated method stub
		return headLineDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return headLineDao.delete(id);
	}

	@Override
	public Long update(HeadLine bean) {
		// TODO Auto-generated method stub
		return headLineDao.update(bean);
	}

	@Override
	public HeadLine load(Long id) {
		// TODO Auto-generated method stub
		return headLineDao.load(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return headLineDao.count();
	}

	@Override
	public List<HeadLine> pager(Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return headLineDao.pager(pageNum, pageSize);
	}

	@Override
	public HeadLine loadByName(String name) {
		// TODO Auto-generated method stub
		return headLineDao.loadByName(name);
	}

	@Override
	public Long countByName(String name) {
		// TODO Auto-generated method stub
		return headLineDao.countByName(name);
	}

	@Override
	public List<HeadLine> pagerByName(String name, Long pageNum, Long pageSize) {
		// TODO Auto-generated method stub
		return headLineDao.pagerByName(name, pageNum, pageSize);
	}


}
