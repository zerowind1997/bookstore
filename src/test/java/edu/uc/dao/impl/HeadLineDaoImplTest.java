package edu.uc.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.HeadLine;
import edu.uc.service.HeadLineService;
import edu.uc.test.BaseTest;

public class HeadLineDaoImplTest extends BaseTest {

	@Autowired
	private HeadLineService headLineDao;
	//private HeadLineDao headLineDao;
	private HeadLine headLine;
	@Before
	public void setUp() throws Exception {
		headLine = new HeadLine();
		headLine.setLineName("lny");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	//@Ignore
	public void testList() {
		System.out.println("=============list==========");
		List<HeadLine> HeadLineList = headLineDao.list();
		for(HeadLine HeadLine:HeadLineList)
		{
			System.out.println(HeadLine.getLineName());
		}
	}

	@Test
	//@Ignore
	public void testInsert() {
		System.out.println("=============insert==========");
		Long result = headLineDao.insert(headLine);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = headLineDao.delete(1L);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testUpdate() {
		headLine.setId(2L);
		headLine.setLineName("update");
		Long result = headLineDao.update(headLine);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("=============load==========");
		HeadLine HeadLine = headLineDao.load(2L);
		System.out.println(HeadLine.getLineName());
	}

	@Test
	//@Ignore
	public void testCount() {
		System.out.println("=============count==========");
		Long result = headLineDao.count();
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPager() {
		System.out.println("=============pager==========");
		List<HeadLine> HeadLineList = headLineDao.pager(1L, 1L);
		for(HeadLine HeadLine:HeadLineList)
		{
			System.out.println(HeadLine.getLineName());
		}
		
	}

	@Test
	//@Ignore
	public void testLoadByName() {
		System.out.println("=============loadbyname==========");
		HeadLine HeadLine = headLineDao.loadByName("update");
		System.out.println(HeadLine.getLineName());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		System.out.println("=============countByName==========");
		Long result = headLineDao.countByName("lny2");
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPagerByName() {
		System.out.println("=============loadbyname==========");
		List<HeadLine> HeadLineList = headLineDao.pagerByName("lny",1L, 1L);
		for(HeadLine HeadLine:HeadLineList)
		{
			System.out.println(HeadLine.getLineName());
		}
	}

}
