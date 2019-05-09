package edu.uc.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.Customer;
import edu.uc.service.CustomerService;
import edu.uc.test.BaseTest;

public class CustomerDaoImplTest extends BaseTest {
	@Autowired
	private CustomerService customerDao;
	//private CustomerDao customerDao;
	private Customer customer;
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
		customer.setUserId("231321");
		customer.setUserPass("12312");
		customer.setUserNick("lny");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//@Ignore
	public void testList() {
		System.out.println("=============list==========");
		List<Customer> CustomerList = customerDao.list();
		for(Customer Customer:CustomerList)
		{
			System.out.println(Customer.getUserId());
		}
	}

	@Test
	@Ignore
	public void testInsert() {
		System.out.println("=============insert==========");
		Long result = customerDao.insert(customer);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = customerDao.delete(1L);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testUpdate() {
		customer.setId(2L);
		customer.setUserNick("lny2");
		Long result = customerDao.update(customer);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("=============load==========");
		Customer customer = customerDao.load(2L);
		System.out.println(customer.getUserNick());
	}

	@Test
	//@Ignore
	public void testCount() {
		System.out.println("=============count==========");
		Long result = customerDao.count();
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPager() {
		System.out.println("=============pager==========");
		List<Customer> CustomerList = customerDao.pager(1L, 1L);
		for(Customer Customer:CustomerList)
		{
			System.out.println(Customer.getUserId());
		}
		
	}

	@Test
	//@Ignore
	public void testLoadByName() {
		System.out.println("=============loadbyname==========");
		Customer Customer = customerDao.loadByName("lny2");
		System.out.println(Customer.getUserId());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		System.out.println("=============countByName==========");
		Long result = customerDao.countByName("lny2");
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPagerByName() {
		System.out.println("=============loadbyname==========");
		List<Customer> CustomerList = customerDao.pagerByName("lny",1L, 1L);
		for(Customer Customer:CustomerList)
		{
			System.out.println(Customer.getUserId());
		}
	}

}
