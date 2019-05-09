package edu.uc.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.BookCategory;
import edu.uc.service.BookCategoryService;
import edu.uc.test.BaseTest;

public class BookCategoryDaoImplTest extends BaseTest {

	@Autowired
	private BookCategoryService bookCategoryDao;
	//private BookCategoryDao bookCategoryDao;
	
	private BookCategory bookCategory;
	@Before
	public void setUp() throws Exception {
		bookCategory = new BookCategory();
		bookCategory.setCategoryId(2L);
		bookCategory.setCategoryName("书本teste");
		bookCategory.setCategoryParentId(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testList() {
		List<BookCategory> BookCategoryList = bookCategoryDao.list();
		for(BookCategory BookCategory:BookCategoryList)
		{
			System.out.println(BookCategory.getCategoryName());
		}
	}

	@Test
	@Ignore
	public void testInsert() {
		Long result = bookCategoryDao.insert(bookCategory);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		Long result = bookCategoryDao.delete(1L);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testUpdate() {
		Long result = bookCategoryDao.update(bookCategory);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("======load======");
		BookCategory bookCategory = bookCategoryDao.load(2L);
		System.out.println(bookCategory.getCategoryName());
	}

	@Test
	//@Ignore
	public void testCount() {
		System.out.println("======count======");
		Long result = bookCategoryDao.count();
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPager() {
		System.out.println("======Pager======");
		List<BookCategory> BookCategoryList = bookCategoryDao.pager(1L, 1L);
		for(BookCategory BookCategory:BookCategoryList)
		{
			System.out.println(BookCategory.getCategoryId());
		}
		
	}

	@Test
	//@Ignore
	public void testLoadByName() {
		System.out.println("======LoadByName======");
		BookCategory BookCategory = bookCategoryDao.loadByName("书本teste");
		System.out.println(BookCategory.getCategoryId());
	}

	@Test
	//@Ignore
	public void testCountByName() {
		System.out.println("======CountByName======");
		Long result = bookCategoryDao.countByName("书本");
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testPagerByName() {
		System.out.println("======CountByName======");
		List<BookCategory> BookCategoryList = bookCategoryDao.pagerByName("书本",1L, 1L);
		for(BookCategory BookCategory:BookCategoryList)
		{
			System.out.println(BookCategory.getCategoryId());
		}
	}

}
