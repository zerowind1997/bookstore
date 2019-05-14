package edu.uc.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uc.bean.Book;
import edu.uc.bean.BookCategory;
import edu.uc.service.BookService;
import edu.uc.test.BaseTest;

public class BookDaoImplTest extends BaseTest {

	@Autowired 
	private BookService bookDao;
	//private BookDao bookDao;
	private Book book;
	@Before
	public void setUp() throws Exception {
		book = new Book();
		book.setBookId(1L);
		book.setBookAuthor("林邵");
		BookCategory bookCategory = new BookCategory();
		bookCategory.setCategoryId(1L);
		book.setBookCategory(bookCategory);
		book.setBookCbs("1231");
		book.setBookNum(12);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testList() {
		System.out.println("=============list============");
		List<Book> BookList = bookDao.list();
		for(Book Book:BookList)
		{
			System.out.println(Book.getBookCategory().getCategoryId());
		}
	}

	@Test
	@Ignore
	public void testInsert() {
		System.out.println("=============insert============");
		Long result = bookDao.insert(book);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testDelete() {
		System.out.println("=============delete============");
		Long result = bookDao.delete(2L);
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testUpdate() {
		//先读，在覆盖新的数据，再改
		System.out.println("=============update============");
		Long result = bookDao.update(book);
		System.out.println(result);
	}

	@Test
	//@Ignore
	public void testLoad() {
		System.out.println("======load======");
		Book book = bookDao.load(1L);
		try
		{
		System.out.println(book.getBookCategory());
		if(book.getBookCategory()!=null)
		{
			System.out.println(book.getBookCategory().getCategoryName());
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+"123123");
		}
	}

	@Test
	@Ignore
	public void testCount() {
		System.out.println("======count======");
		Long result = bookDao.count();
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testPager() {
		System.out.println("======pager======");
		List<Book> BookList = bookDao.pager(1L, 1L);
		for(Book Book:BookList)
		{
			System.out.println(Book.getBookId());
		}
		
	}

	@Test
	@Ignore
	public void testLoadByName() {
		System.out.println("======testLoadByName======");
		Book Book = bookDao.loadByName("lny");
		System.out.println(Book.getBookId());
	}

	@Test
	@Ignore
	public void testCountByName() {
		System.out.println("======testCountByName======");
		Long result = bookDao.countByName("lny");
		System.out.println(result);
	}

	@Test
	@Ignore
	public void testPagerByName() {
		System.out.println("======testPagerByName======");
		List<Book> BookList = bookDao.pagerByName("lny",1L, 1L);
	
		for(Book Book:BookList)
		{
			System.out.println(Book.getBookId());
		}
	}

}
