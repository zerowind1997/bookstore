package edu.uc.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.OrderCart;
import edu.uc.service.OrderCartService;
import edu.uc.test.BaseTest;

public class OrderCartDaoImplTest extends BaseTest {

	@Autowired
	private OrderCartService orderCartDao;
	//private OrderCartDao orderCartDao;
	private OrderCart orderCart;
	@Before
	public void setUp() throws Exception {
		orderCart = new OrderCart();
		orderCart.setId(1L);
		orderCart.setBookName("lny3");
		orderCart.setBookId(12);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//@Ignore
	public void testList() {
		System.out.println("=============list==========");
		List<OrderCart> OrderCartList = orderCartDao.list();
		for(OrderCart OrderCart:OrderCartList)
		{
			System.out.println(OrderCart.getBookName());
		}
	}

	@Test
	//@Ignore
	public void testInsert() {
		System.out.println("=============insert==========");
		Long result = orderCartDao.insert(orderCart);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = orderCartDao.delete(1L);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testUpdate() {
		orderCart.setId(2L);
		orderCart.setBookName("update");
		Long result = orderCartDao.update(orderCart);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("=============load==========");
		OrderCart OrderCart = orderCartDao.load(2L);
		System.out.println(OrderCart.getBookName());
	}

	@Test
	//@Ignore
	public void testCount() {
		System.out.println("=============count==========");
		Long result = orderCartDao.count();
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPager() {
		System.out.println("=============pager==========");
		List<OrderCart> OrderCartList = orderCartDao.pager(1L, 1L);
		for(OrderCart OrderCart:OrderCartList)
		{
			System.out.println(OrderCart.getBookName());
		}
		
	}

	@Test
	//@Ignore
	public void testLoadByName() {
		System.out.println("=============loadbyname==========");
		OrderCart OrderCart = orderCartDao.loadByName("lny2");
		System.out.println(OrderCart.getBookName());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		System.out.println("=============countByName==========");
		Long result = orderCartDao.countByName("lny2");
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPagerByName() {
		System.out.println("=============loadbyname==========");
		List<OrderCart> OrderCartList = orderCartDao.pagerByName("lny",1L, 1L);
		for(OrderCart OrderCart:OrderCartList)
		{
			System.out.println(OrderCart.getBookName());
		}
	}

}
