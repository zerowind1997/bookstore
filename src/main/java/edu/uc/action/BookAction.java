package edu.uc.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.uc.bean.Book;
import edu.uc.bean.BookCategory;
import edu.uc.service.BookCategoryService;
import edu.uc.service.BookService;

@Component("BookAction")
@Scope("prototype")
public class BookAction extends CrudAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8168298155398369626L;
	//书名称
	private String bookName;
	private String bookCategoryId;
	private String selectedCategoryName;
	private String bookAuthor;
	private String bookNum;
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;
	private String bookCbs;
	private String bookNote;
	private String ISBN;
	private String bookPrice;
	private String id;
	private String discountRate;
	
	private String type;
	
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(String bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public String getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSelectedCategoryName() {
		return selectedCategoryName;
	}

	public void setSelectedCategoryName(String selectedCategoryName) {
		this.selectedCategoryName = selectedCategoryName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getBookCbs() {
		return bookCbs;
	}

	public void setBookCbs(String bookCbs) {
		this.bookCbs = bookCbs;
	}

	public String getBookNote() {
		return bookNote;
	}

	public void setBookNote(String bookNote) {
		this.bookNote = bookNote;
	}

	@Autowired
	private BookService bookService;
	@Autowired
	private BookCategoryService bookCategoryService;
	@Override
	public String list() {
		List<Book> vDataList = null;
		
		//分页步骤，创建分页对象，老师已经包装
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(pageSize);
		pagerItem.parsePageNum(pageNum);
		
		//分页步骤 1定义总量 初始化为0
		Long rowCount=0L;
		//2.查询记录总数
		rowCount = bookService.count();
		//3.将记录赋给pagerItem,以便进行分页的各项计算
		pagerItem.changeRowCount(rowCount);
		//4.根据指定分页数 获取数据
		vDataList = bookService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		//5.设置跳转页面
		pagerItem.changeUrl(SysFun.generalUrl(requestURI,queryString));
		request.put("pagerItem", pagerItem);
		request.put("DataList", vDataList);
		return "list";
	}
	
	public String search() {
		// TODO Auto-generated method stub
		
		return "search";
	}
	
	@Override
	public String listDeal() {
		request.put("bookName",bookName);
		request.put("bookCategoryId", bookCategoryId);
		List<Book> dataList=null;
		PagerItem pagerItem=new PagerItem();
		pagerItem.parsePageNum(pageNum);
		pagerItem.parsePageSize(pageSize);
		String result="";
		Long count=0L;
		if(!SysFun.isNullOrEmpty(bookName))
		{
			count=bookService.countByName(bookName);
			pagerItem.changeRowCount(count);
			dataList=bookService.pagerByName(bookName, pagerItem.getPageNum(), pagerItem.getPageSize());
			if((!SysFun.isNullOrEmpty(type))&&type.equals("foreground")) {
				List<Book> CategoryList=new ArrayList<Book>();
				for(int i=0;i<dataList.size();i++) {
					Book book=dataList.get(i);
					if(i==0)
						CategoryList.add(book);
					else
					{
						int j=0;
						for(;j<CategoryList.size();j++) {
							Long id=CategoryList.get(j).getBookCategory().getCategoryId();
							if(id==book.getBookCategory().getCategoryId())
								break;
						}
						if(j==CategoryList.size())
							CategoryList.add(book);
					}
					
				}
				request.put("CategoryList", CategoryList);
				result="search";
			}
			else 
				result="list";	
		}
		else
		{
			count=bookService.count();
			pagerItem.changeRowCount(count);
			dataList=bookService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
			result="list";
		}
		
		pagerItem.changeUrl(SysFun.generalUrl(requestURI, queryString));
		request.put("DataList", dataList);
		request.put("pagerItem", pagerItem);
		System.out.println(result);
		return result;
	}

	@Override
	public String insert() {
		return "insert";
	}

	@Override
	public String insertDeal() {
		request.put("bookName",bookName);
		request.put("selectedCategoryName",selectedCategoryName);
		request.put("bookAuthor",bookAuthor);
		request.put("bookNum",bookNum);
		request.put("headImg",headImg);
		request.put("bookCbs",bookCbs);
		request.put("bookNote",bookNote);
		request.put("bookPrice", bookPrice);
		String vMsg="";
		if(SysFun.isNullOrEmpty(bookPrice))
		{
			vMsg+="图书价格不能为空";
		}
		if(SysFun.isNullOrEmpty(selectedCategoryName))
		{
			vMsg+="图书类别不能为空";
		}
		if(SysFun.isNullOrEmpty(bookName))
		{
			vMsg+="图书名称不能为空";
		}
		if(SysFun.isNullOrEmpty(bookAuthor))
		{
			vMsg+="图书作者不能为空";
		}
		if(SysFun.isNullOrEmpty(bookNum))
		{
			vMsg+="图书数量不能为空";
		}
		if(headImg==null)
		{
			vMsg+="图书图片不能为空";
		}
		if(SysFun.isNullOrEmpty(bookCbs))
		{
			vMsg+="图书出版社不能为空";
		}
		if(SysFun.isNullOrEmpty(bookNote))
		{
			vMsg+="图书简介不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "insert";
		}
		 
        //1、保存头像文件到服务器中
         String filePath = ServletActionContext.getServletContext().getRealPath("/upload/book/");
         String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
         try {
        	 FileUtils.copyFile(headImg, new File(filePath, fileName));
			//System.out.println("filePath"+filePath+"\\"+fileName);
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String bookPicPath = "/upload/book/"+fileName;
        Book bean = new Book();
 		if(selectedCategoryName!=null && !selectedCategoryName.equals("0"))
 		{
 			BookCategory bookCategory = new BookCategory();
 			bookCategory=bookCategoryService.load(Long.valueOf(selectedCategoryName));
 			bean.setBookCategory(bookCategory);
 		}
 		bean.setBookAuthor(bookAuthor);
 		bean.setBookCbs(bookCbs);
 		bean.setBookName(bookName);
 		bean.setBookNum(Integer.valueOf(bookNum));
 		bean.setBookNote(bookNote);
 		bean.setBookPicPath(bookPicPath);
 		bean.setDiscountRate(1.0);
 		bean.setEnableStatus(0);
 		bean.setISBN(ISBN);
 		bean.setBookPrice(Double.valueOf(bookPrice));
 		System.out.println("bookPrice"+Double.valueOf(bookPrice));
 		Long result = 0l;
 		try
 		{
 			result = bookService.insert(bean);
 		}
 		catch(Exception e)
 		{
 			vMsg+="添加失败，原因"+e.getMessage();
 		}
 		if(result>0)
 		{
 			return "go_preload";
 		}
 		else
 		{
 			request.put("msg", vMsg);
 			return "insert";
 		}
//		 System.out.println("headImg"+headImg);
//		 System.out.println("bookName"+bookName);
//		 System.out.println("selectedCategoryName"+selectedCategoryName);
//		 System.out.println("bookAuthor"+bookAuthor);
//		 System.out.println("bookNote"+bookNote);
//		 System.out.println("bookCbs"+bookCbs);
	}

	@Override
	public String delete() {
		return "delete";
	}

	@Override
	public String deleteDeal() {
		if(!SysFun.isNullOrEmpty(id))
		{
			Long vId = SysFun.parseLong(id);
			Book book = bookService.load(vId);
			String filePath = ServletActionContext.getServletContext().getRealPath("/");
			new File(filePath+book.getBookPicPath()).delete();
			//System.out.println(filePath+book.getBookPicPath());
			Long result = bookService.delete(vId);//删除图片
			if(result>0)
			{
				return "go_ok";
			}
		}
		return "go_no";
	}

	@Override
	public String update() {
		if(!SysFun.isNullOrEmpty(id))
		{
			Long vId = SysFun.parseLong(id);
			Book bean = bookService.load(vId);
			if(bean!=null)
			{
				request.put("bean",bean);
				return "update";
			}
		}
		return "go_preload";
	}

	@Override
	public String updateDeal() {
		request.put("bookName",bookName);
		request.put("selectedCategoryName",selectedCategoryName);
		request.put("bookAuthor",bookAuthor);
		request.put("bookNum",bookNum);
		request.put("headImg",headImg);
		request.put("bookCbs",bookCbs);
		request.put("bookNote",bookNote);
		request.put("bookPrice", bookPrice);
		String vMsg="";
		if(SysFun.isNullOrEmpty(bookPrice))
		{
			vMsg+="图书价格不能为空";
		}
		if(SysFun.isNullOrEmpty(selectedCategoryName))
		{
			vMsg+="图书类别不能为空";
		}
		if(SysFun.isNullOrEmpty(bookName))
		{
			vMsg+="图书名称不能为空";
		}
		if(SysFun.isNullOrEmpty(bookAuthor))
		{
			vMsg+="图书作者不能为空";
		}
		if(SysFun.isNullOrEmpty(bookNum))
		{
			vMsg+="图书数量不能为空";
		}
		if(SysFun.isNullOrEmpty(bookCbs))
		{
			vMsg+="图书出版社不能为空";
		}
		if(SysFun.isNullOrEmpty(bookNote))
		{
			vMsg+="图书简介不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "update";
		}
		Long vId = SysFun.parseLong(id);
		Book bean = bookService.load(vId);
		if(bean==null)
		{
			vMsg+="记录不存在";
		}
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "update";
		}
		if(selectedCategoryName!=null&&!selectedCategoryName.equals("0"))
		{
			BookCategory bc = bookCategoryService.load(Long.valueOf(selectedCategoryName));
			bean.setBookCategory(bc);
		}
		bean.setBookAuthor(bookAuthor);
		bean.setBookCbs(bookCbs);
		bean.setBookName(bookName);
		bean.setBookNote(bookNote);
		bean.setBookNum(Integer.valueOf(bookNum));
		bean.setBookPrice(Double.valueOf(bookPrice));
		bean.setDiscountRate(Double.valueOf(discountRate));
		bean.setEnableStatus(bean.getEnableStatus());
		bean.setISBN(ISBN);
		if(headImg!=null)
		{
			 //先删除图片
			 String filePath2 = ServletActionContext.getServletContext().getRealPath("/");
			 new File(filePath2+bean.getBookPicPath()).delete();
			 //在重新新增图片
			 String filePath = ServletActionContext.getServletContext().getRealPath("/upload/book/");
	         String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
	         try {
	        	 FileUtils.copyFile(headImg, new File(filePath, fileName));
			} catch (IOException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String bookPicPath = "/upload/book/"+fileName;
	        bean.setBookPicPath(bookPicPath);
	       
		}
		else
		{
			bean.setBookPicPath(bean.getBookPicPath());
		}
		Long result = 0l;
		try
		{
			result = bookService.update(bean);
		}
		catch(Exception e)
		{
			vMsg+="修改失败，原因"+e.getMessage();
		}
		if(result>0)
		{
			return "go_preload";
		}
		else
		{
			request.put("msg", vMsg);
			return "update";
		}
	}

	@Override
	public String detail() {

		
		if(!SysFun.isNullOrEmpty(id))
		{
			Long vId = SysFun.parseLong(id);
			Book bean = bookService.load(vId);
			if(bean!=null)
			{
				request.put("bean", bean);
				return "detail";
			}
		}
		return "go_preload";
	}

	@Override
	public String detailDeal() {
		// TODO Auto-generated method stub
		return null;
	}

}
