package edu.uc.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.uc.bean.BookCategory;
import edu.uc.dto.BookCategoryHandle;
import edu.uc.service.BookCategoryService;

@Component("BookCategoryAction")
@Scope("prototype")
public class BookCategoryAction extends CrudAction {

	@Autowired
	private BookCategoryService bookCategoryService;
	
	private String categoryName;
	private List<BookCategoryHandle> vHDataList = new ArrayList<BookCategoryHandle>();
	private String selectedCategoryName;
	private String id;
	private String categoryParentIdName;
	

	public String getCategoryParentIdName() {
		return categoryParentIdName;
	}

	public void setCategoryParentIdName(String categoryParentIdName) {
		this.categoryParentIdName = categoryParentIdName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelectedCategoryName() {
		return selectedCategoryName;
	}

	public void setSelectedCategoryName(String selectedCategoryName) {
		this.selectedCategoryName = selectedCategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 809977724696999091L;

	@Override
	public String list() {
		List<BookCategory> vDataList = null;
		
		//分页步骤，创建分页对象，老师已经包装
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(pageSize);
		pagerItem.parsePageNum(pageNum);
		
		//分页步骤 1定义总量 初始化为0
		Long rowCount=0L;
		//2.查询记录总数
		rowCount = bookCategoryService.count();
		//3.将记录赋给pagerItem,以便进行分页的各项计算
		pagerItem.changeRowCount(rowCount);
		//4.根据指定分页数 获取数据
		vDataList = bookCategoryService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		//5.设置跳转页面
		pagerItem.changeUrl(SysFun.generalUrl(requestURI,queryString));
		getVHDataList(vDataList);
		request.put("pagerItem", pagerItem);
		request.put("DataList", vHDataList);
		return "list";
	}

	private void getVHDataList(List<BookCategory> vDataList) {
		//vHDataList.clear();
		for(BookCategory bookCategory:vDataList)
		{
			BookCategoryHandle bookCategoryHandle = new BookCategoryHandle();
			bookCategoryHandle.setCategoryId(bookCategory.getCategoryId());
			bookCategoryHandle.setCategoryName(bookCategory.getCategoryName());
			bookCategoryHandle.setCategoryParentId(bookCategory.getCategoryParentId());
			if(bookCategory.getCategoryParentId()!=null)
			{
				bookCategory = bookCategoryService.load(bookCategory.getCategoryParentId());
				if(bookCategory!=null)
				bookCategoryHandle.setCategoryParentIdName(bookCategory.getCategoryName());
				else
				{
					bookCategoryHandle.setCategoryParentIdName("待分配二级菜单");
				}
			}
			else
			{
				bookCategoryHandle.setCategoryParentIdName(null);
			}
			vHDataList.add(bookCategoryHandle);
		}
	}

	@Override
	public String listDeal() {
		request.put("categoryName", categoryName);
		List<BookCategory> vDataList =null;
		
		//创建分页对象
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageNum(pageNum);
		pagerItem.parsePageSize(pageSize);
		
		//定义记录变量数
		Long rowCount = 0L;
		if(!SysFun.isNullOrEmpty(categoryName))
		{
			rowCount = bookCategoryService.countByName(categoryName);
			pagerItem.changeRowCount(rowCount);
			vDataList = bookCategoryService.pagerByName(categoryName, pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		else
		{
			rowCount = bookCategoryService.count();
			pagerItem.changeRowCount(rowCount);
			vDataList = bookCategoryService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		pagerItem.changeUrl(SysFun.generalUrl(requestURI,queryString));
		getVHDataList(vDataList);
		request.put("pagerItem", pagerItem);
		request.put("DataList", vHDataList);
		return "list";
	}

	@Override
	public String insert() {
		return "insert";
	}

	@Override
	public String insertDeal() {
		request.put("categoryName",categoryName);
		request.put("selectedCategoryName",selectedCategoryName);
		//System.out.println(selectedCategoryName);
		String vMsg="";
		if(SysFun.isNullOrEmpty(categoryName))
		{
			vMsg+="类别名称不能为空";
		}
		
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "insert";
		}
		
		BookCategory bean = new BookCategory();
		bean.setCategoryName(categoryName);
		if(selectedCategoryName!=null && !selectedCategoryName.equals("0"))
		{
			bean.setCategoryParentId(Long.valueOf(selectedCategoryName));
		}
		Long result = 0l;
		try
		{
			result = bookCategoryService.insert(bean);
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
			List<BookCategory> parentIdList = bookCategoryService.getParentIdList(vId);
			if(parentIdList!=null)
			{
				for(BookCategory bc:parentIdList)
				{
					bc.setCategoryParentId(0L);
					bookCategoryService.update(bc);
				}
			}
			Long result = bookCategoryService.delete(vId);
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
			BookCategory bean = bookCategoryService.load(vId);
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
		request.put("id", id);
		request.put("categoryName",categoryName);
		request.put("selectedCategoryName", selectedCategoryName);
		String vMsg="";
		if(SysFun.isNullOrEmpty(id))
		{
			vMsg+="书籍类别主键不能为空";
		}
		if(SysFun.isNullOrEmpty(categoryName))
		{
			vMsg+="书籍类别名称不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "update";
		}
		
		Long vId = SysFun.parseLong(id);
		BookCategory bean = bookCategoryService.load(vId);
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
		bean.setCategoryName(categoryName);
		if(selectedCategoryName!=null&&!selectedCategoryName.equals("0"))
		{
			bean.setCategoryParentId(Long.valueOf(selectedCategoryName));
		}else
		{
			bean.setCategoryParentId(null);
		}
		Long result = 0l;
		try
		{
			result = bookCategoryService.update(bean);
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
			BookCategory bean = bookCategoryService.load(vId);
			BookCategoryHandle HBean = new BookCategoryHandle();
			if(bean!=null)
			{
				HBean.setCategoryId(bean.getCategoryId());
				HBean.setCategoryName(bean.getCategoryName());
				HBean.setCategoryParentId(bean.getCategoryParentId());
				HBean.setCategoryParentIdName(categoryParentIdName);
				request.put("bean", HBean);
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
