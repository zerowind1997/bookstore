package edu.uc.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.apache.struts2.components.Head;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.uc.bean.Customer;
import edu.uc.bean.HeadLine;
import edu.uc.service.HeadLineService;

@Component("HeadLineAction")
@Scope("prototype")
public class HeadLineAction extends CrudAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5728095598250038085L;
	
	private HeadLineService headLineService;
	
	private String id;
	private String lineName;
	private String lineLink;
	private String lineImg;
	private String vId;
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineLink() {
		return lineLink;
	}

	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}
	
	
	public String getLineImg() {
		return lineImg;
	}

	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		List<HeadLine> dataList=new ArrayList<HeadLine>();
		PagerItem pagerItem=new PagerItem();
		pagerItem.parsePageSize(pageSize);
		pagerItem.parsePageNum(pageNum);
		
		Long count=headLineService.count();
		pagerItem.changeRowCount(count);
		
		dataList=headLineService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(requestURI, queryString));
		
		request.put("DataList", dataList);
		request.put("pagerItem", pagerItem);
		
		
		return "list";
	}

	@Override
	public String listDeal() {
		// TODO Auto-generated method stub
		request.put("lineName",lineName);
		
		List<HeadLine> dataList=null;
		PagerItem pagerItem=new PagerItem();
		pagerItem.parsePageNum(pageNum);
		pagerItem.parsePageSize(pageSize);
		Long count=0L;
		if(!SysFun.isNullOrEmpty(lineName))
		{
			count=headLineService.countByName(lineName);
			pagerItem.changeRowCount(count);
			dataList=headLineService.pagerByName(lineName, pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		else
		{
			count=headLineService.count();
			pagerItem.changeRowCount(count);
			dataList=headLineService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		pagerItem.changeUrl(SysFun.generalUrl(requestURI, queryString));
		
		request.put("DataList", dataList);
		request.put("pagerItem", pagerItem);
		
		return "list";
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "list";
	}

	@Override
	public String insertDeal() {
		// TODO Auto-generated method stub
		request.put("lineName", lineName);
		request.put("lineLink", lineLink);
		request.put("lineImg", lineImg);
		
		String vMSg="";
		if(SysFun.isNullOrEmpty(lineName)) {
			vMSg+="头条名不能为空";
		}
		if(SysFun.isNullOrEmpty(lineLink)) {
			vMSg+="头条链接不能为空";
		}
		if(SysFun.isNullOrEmpty(lineImg)) {
			vMSg+="头条图片不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMSg)) {
			request.put("msg", vMSg);
			System.out.println(vMSg);
			return "insert";
		}
		
		HeadLine bean=new HeadLine();
		bean.setLineName(lineName);
		bean.setLineLink(lineLink);
		bean.setLineImg(lineImg);
		Long result=0L;
		try {
			result=headLineService.insert(bean);
			System.out.println(result);
		}
		catch(Exception e) {
			vMSg+="添加失败，原因："+e.getMessage();
		}
		if(result>0) {
			return "go_preload";
		}
		else {
			request.put("msg", vMSg);
			return "insert";
		}
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDeal() {
		// TODO Auto-generated method stub
		if(!SysFun.isNullOrEmpty(vId)) {
			Long iId=SysFun.parseLong(vId);
			Long result=headLineService.delete(iId);
			if(result>0) {
				return "go_ok";
			}
		}
		
		return "go_ok";
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		System.out.println("updateView.");
		
		//javax.servlet.http.HttpSession session=request.getSession();
		//javax.servlet.ServletContext application=request.getServletContext();
		
		//String vId=request.getParameter("id");
		if(!SysFun.isNullOrEmpty(vId)) {
			Long iId=SysFun.parseLong(vId);
			HeadLine bean=headLineService.load(iId);
			
			if(bean!=null) {
				
				request.put("Id", bean.getId());
				request.put("lineName", bean.getLineName());
				request.put("lineLink", bean.getLineLink());
				request.put("lineImg", bean.getLineImg());
				return "update";
				
			}
			
		}
		
		return "go_preload";
	}

	@Override
	public String updateDeal() {
		// TODO Auto-generated method stub
		request.put("lineName", lineName);
		request.put("lineLink", lineLink);
		request.put("lineImg", lineImg);
		
		String vMsg="";
		if(SysFun.isNullOrEmpty(lineName)) {
			vMsg+="头条名不能为空";
		}
		if(SysFun.isNullOrEmpty(lineLink)) {
			vMsg+="头条链接不能为空";
		}
		if(SysFun.isNullOrEmpty(lineImg)) {
			vMsg+="头条图片不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMsg)) {
			request.put("msg", vMsg);
			return "update";
		}
		
		Long iId=SysFun.parseLong(id);
		HeadLine bean=headLineService.load(iId);
		if(bean==null) {
			vMsg+="记录不存在";
		}
		if(!SysFun.isNullOrEmpty(vMsg)) {
			
			request.put("msg", vMsg);
			return "update";
		}
		
		bean.setLineName(lineName);
		bean.setLineLink(lineLink);
		bean.setLineImg(lineImg);
		
		Long result=0L;
		try {
			result=headLineService.update(bean);
			System.out.println("111");
		}
		catch (Exception e) {
			// TODO: handle exception
			vMsg+="修改失败，原因："+e.getMessage();
		}
		
		if(result>0) {
			return "go_preload";
		}
		else {
			request.put("msg", vMsg);
			return "update";
		}
	}

	@Override
	public String detail() {
		// TODO Auto-generated method stub
		System.out.println("detailView.");
		//javax.servlet.http.HttpSession session=request.getSession();
		//javax.servlet.ServletContext application=request.getServletContext();
		
		//String vId=request.getParameter("id");
		if(!SysFun.isNullOrEmpty(vId)) {
			Long iId=SysFun.parseLong(vId);
			HeadLine bean=headLineService.load(iId);
			if(bean!=null) {
				request.put("bean", bean);
				return "detail";
				
			}
		}
		return "detail";
	}

	@Override
	public String detailDeal() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
