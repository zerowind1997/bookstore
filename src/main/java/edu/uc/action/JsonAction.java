package edu.uc.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;
import com.opensymphony.xwork2.ActionSupport;

import edu.uc.bean.Book;
import edu.uc.bean.BookCategory;
import edu.uc.bean.Customer;
import edu.uc.service.BookCategoryService;
import edu.uc.service.BookService;
import edu.uc.service.CustomerService;
import edu.uc.util.MD5util;

@Component("JsonAction")
@Scope("prototype")
public class JsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5967103792551330406L;
	@Autowired
	private BookCategoryService bookCategoryService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerService customerService;
	private InputStream rspStream;
	private String id;
	private String bookName;
	
	protected String pageNum;
	protected String pageSize;

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public InputStream getRspStream() {
		return rspStream;
	}
	public void setRspStream(InputStream rspStream) {
		this.rspStream = rspStream;
	}
	
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public InputStream toStream(String pStr)
	{
		if(pStr==null)
		{
			pStr="";
		}
		byte[] arr = null;
		try
		{
			arr = pStr.getBytes("UTF-8");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ByteArrayInputStream(arr);	
	}
	public String getCategoryNameList()
	{
		String strResult="";
		List<BookCategory> bookCategoryList = bookCategoryService.list();
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 1L);
		map.put("desc", "ok");
		map.put("data",bookCategoryList);
		try
		{
			strResult = mapper.writeValueAsString(map);
			System.out.println(strResult);		
		}
		catch(Exception e)
		{
			map.put("code", -1L);
			map.put("desc", "no");
			map.put("data",e.getMessage());
		}
		rspStream = toStream(strResult);
		return SUCCESS;
	}
	public String updateEnableStatus()
	{
		String strResult="";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!SysFun.isNullOrEmpty(id))
		{
			Long vId = SysFun.parseLong(id.substring(0,id.length()-2));
			String statusId = id.substring(id.length()-1,id.length());
			
			Book book = bookService.load(vId);
			if(statusId.equals("a"))
			{
				book.setEnableStatus(2);
			}
			else if(statusId.equals("c"))
			{
				book.setEnableStatus(1);
				System.out.println(book.getEnableStatus());
			}
			else
			{
				book.setEnableStatus(2);
			}
			
			vId = bookService.update(book);
			
			book = bookService.load(vId);
			System.out.println(book.getEnableStatus());
			//System.out.println();
			map.put("success", true);
			map.put("status", book.getEnableStatus());
			//map.put("status", book.getEnableStatus());
			try {
				strResult = mapper.writeValueAsString(map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				map.put("success", false);
				map.put("msg", e.getMessage());
			}
		}
		rspStream = toStream(strResult);
		return SUCCESS;
	}
	public String updateUserPassword()
	{
		String strResult="";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!SysFun.isNullOrEmpty(id))
		{
			Long vId = SysFun.parseLong(id);
			Customer bean = customerService.load(vId);
			bean.setUserPass(MD5util.getMD5BySalt(bean.getUserId(), "123456"));
			customerService.update(bean);
			map.put("success", true);
			map.put("bean", bean);
			//map.put("status", book.getEnableStatus());
			try {
				strResult = mapper.writeValueAsString(map);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				map.put("success", false);
				map.put("msg", e.getMessage());
			}
		}
		rspStream = toStream(strResult);
		return SUCCESS;
	}
	
	public String selectcCategoryName()
	{
		String strResult="";
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!SysFun.isNullOrEmpty(id))
		{
			Long vId = SysFun.parseLong(id);
			Book bean = bookService.load(vId);
			List<Book> dataList=null;
			PagerItem pagerItem=new PagerItem();
			pagerItem.parsePageNum(pageNum);
			pagerItem.parsePageSize(pageSize);
			Long count=0L;
			count=bookService.countById(bookName, vId);
			pagerItem.changeRowCount(count);
			dataList=bookService.pagerById(bookName, vId, pagerItem.getPageNum(), pagerItem.getPageSize());
			map.put("success", true);
			map.put("DataList", dataList);
			map.put("pagerItem", pagerItem);
			//map.put("status", book.getEnableStatus());
			try {
				strResult = mapper.writeValueAsString(map);
				System.out.println(strResult);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				map.put("success", false);
				map.put("msg", e.getMessage());
			}
		}
		rspStream = toStream(strResult);
		return SUCCESS;
	}
	
}
