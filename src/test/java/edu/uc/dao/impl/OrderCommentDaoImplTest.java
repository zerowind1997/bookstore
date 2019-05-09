package edu.uc.dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.OrderComment;
import edu.uc.service.OrderCommentService;
import edu.uc.test.BaseTest;

public class OrderCommentDaoImplTest extends BaseTest {
	
	@Autowired
	private OrderCommentService orderCommentDao;
	//private OrderCommentDao orderCommentDao;
	private OrderComment orderComment;
	@Before
	public void setUp() throws Exception {
		orderComment = new OrderComment();
		orderComment.setUserNick("lny3");
		orderComment.setCommentDate(new Date());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//@Ignore
	public void testList() {
		System.out.println("=============list==========");
		List<OrderComment> OrderCommentList = orderCommentDao.list();
		for(OrderComment OrderComment:OrderCommentList)
		{
			System.out.println(OrderComment.getUserNick());
		}
	}

	@Test
	//@Ignore
	public void testInsert() {
		System.out.println("=============insert==========");
		Long result = orderCommentDao.insert(orderComment);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = orderCommentDao.delete(1L);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testUpdate() {
		orderComment.setId(2L);
		orderComment.setUserNick("update");
		Long result = orderCommentDao.update(orderComment);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("=============load==========");
		OrderComment OrderComment = orderCommentDao.load(2L);
		System.out.println(OrderComment.getUserNick());
	}

	@Test
	//@Ignore
	public void testCount() {
		System.out.println("=============count==========");
		Long result = orderCommentDao.count();
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPager() {
		System.out.println("=============pager==========");
		List<OrderComment> OrderCommentList = orderCommentDao.pager(1L, 1L);
		for(OrderComment OrderComment:OrderCommentList)
		{
			System.out.println(OrderComment.getUserNick());
		}
		
	}

	@Test
	//@Ignore
	public void testLoadByName() {
		System.out.println("=============loadbyname==========");
		OrderComment OrderComment = orderCommentDao.loadByName("lny2");
		System.out.println(OrderComment.getUserNick());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		System.out.println("=============countByName==========");
		Long result = orderCommentDao.countByName("lny2");
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPagerByName() {
		System.out.println("=============loadbyname==========");
		List<OrderComment> OrderCommentList = orderCommentDao.pagerByName("lny",1L, 1L);
		for(OrderComment OrderComment:OrderCommentList)
		{
			System.out.println(OrderComment.getUserNick());
		}
	}
}
