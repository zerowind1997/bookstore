package edu.uc.dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.Order;
import edu.uc.service.OrderService;
import edu.uc.test.BaseTest;

public class OrderDaoImplTest extends BaseTest {

	@Autowired
	private OrderService orderDao;
	//private OrderDao orderDao;
	private Order order;
	@Before
	public void setUp() throws Exception {
		order = new Order();
		order.setBookId(12);
		order.setUserId(123);
		order.setOrderDate(new Date());
		order.setAddress("lny3");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//@Ignore
	public void testList() {
		System.out.println("=============list==========");
		List<Order> OrderList = orderDao.list();
		for(Order Order:OrderList)
		{
			System.out.println(Order.getAddress());
		}
	}

	@Test
	//@Ignore
	public void testInsert() {
		System.out.println("=============insert==========");
		Long result = orderDao.insert(order);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = orderDao.delete(1L);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testUpdate() {
		order.setId(2L);
		order.setAddress("update");
		Long result = orderDao.update(order);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("=============load==========");
		Order Order = orderDao.load(2L);
		System.out.println(Order.getAddress());
	}

	@Test
	//@Ignore
	public void testCount() {
		System.out.println("=============count==========");
		Long result = orderDao.count();
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPager() {
		System.out.println("=============pager==========");
		List<Order> OrderList = orderDao.pager(1L, 1L);
		for(Order Order:OrderList)
		{
			System.out.println(Order.getAddress());
		}
		
	}

	@Test
	@Ignore
	public void testLoadByName() {
		System.out.println("=============loadbyname==========");
		Order Order = orderDao.loadByName("lny2");
		System.out.println(Order.getAddress());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		System.out.println("=============countByName==========");
		Long result = orderDao.countByName("lny2");
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPagerByName() {
		System.out.println("=============loadbyname==========");
		List<Order> OrderList = orderDao.pagerByName("lny",1L, 1L);
		for(Order Order:OrderList)
		{
			System.out.println(Order.getAddress());
		}
	}

}
