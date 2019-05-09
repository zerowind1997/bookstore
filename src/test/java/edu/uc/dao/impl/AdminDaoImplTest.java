package edu.uc.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.Manager;
import edu.uc.service.AdminService;
import edu.uc.test.BaseTest;
import edu.uc.util.MD5util;

public class AdminDaoImplTest extends BaseTest{

	@Autowired
	private AdminService adminService;
	//private adminService adminService;
	private Manager admin;
	@Before
	public void setUp() throws Exception {
		admin = new Manager();
		admin.setId(2L);
		admin.setPriority(3);
		admin.setUserId("admin");
		admin.setUserName("林伟明");
		admin.setUserPass("123456");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testList() {
		List<Manager> managerList = adminService.list();
		for(Manager manager:managerList)
		{
			System.out.println(manager.getUserId());
		}
	}

	@Test
	//@Ignore
	public void testInsert() {
		admin.setUserPass(MD5util.getMD5BySalt(admin.getUserId(), admin.getUserPass()));
		Long result = adminService.insert(admin);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = adminService.delete(1L);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testLoad() {
		Long result = adminService.update(admin);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testCount() {
		Long result = adminService.count();
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testPager() {
		List<Manager> managerList = adminService.pager(1L, 1L);
		for(Manager manager:managerList)
		{
			System.out.println(manager.getUserId());
		}
		
	}

	@Test
	@Ignore
	public void testLoadByName() {
		Manager manager = adminService.loadByName("admin1");
		System.out.println(manager.getUserId());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		Long result = adminService.countByName("admin");
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testPagerByName() {
		List<Manager> managerList = adminService.pagerByName("lny",1L, 1L);
		for(Manager manager:managerList)
		{
			System.out.println(manager.getUserId());
		}
	}

}
