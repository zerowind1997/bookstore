package edu.uc.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.uc.bean.Customer;
import edu.uc.service.CustomerService;
import edu.uc.util.MD5util;

@Component("CustomerAction")
@Scope("prototype")
public class CustomerAction extends CrudAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9006687705891861561L;
	
	@Autowired
	private CustomerService customerService;
	private String id;
	private String userId;
	private String userNick;
	private String email;
	private String userPass;
	private String phone;
	private String address;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	

	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		List<Customer> dataList=new ArrayList<Customer>();
		PagerItem pagerItem=new PagerItem();
		pagerItem.parsePageSize(pageSize);
		pagerItem.parsePageNum(pageNum);
		
		Long count=customerService.count();
		pagerItem.changeRowCount(count);
		
		dataList=customerService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		pagerItem.changeUrl(SysFun.generalUrl(requestURI, queryString));
		
		request.put("DataList", dataList);
		request.put("pagerItem", pagerItem);
		
		
		return "list";
	}

	@Override
	public String listDeal() {
		// TODO Auto-generated method stub
		request.put("userNick",userNick);
		
		List<Customer> dataList=null;
		PagerItem pagerItem=new PagerItem();
		pagerItem.parsePageNum(pageNum);
		pagerItem.parsePageSize(pageSize);
		Long count=0L;
		if(!SysFun.isNullOrEmpty(userNick))
		{
			count=customerService.countByName(userNick);
			pagerItem.changeRowCount(count);
			dataList=customerService.pagerByName(userNick, pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		else
		{
			count=customerService.count();
			pagerItem.changeRowCount(count);
			dataList=customerService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		pagerItem.changeUrl(SysFun.generalUrl(requestURI, queryString));
		
		request.put("DataList", dataList);
		request.put("pagerItem", pagerItem);
		
		return "list";
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "insert";
	}

	@Override
	public String insertDeal() {
		// TODO Auto-generated method stub 注册有点问题
		request.put("userId", userId);
		request.put("userNick",userNick);
		request.put("email",email);
		userPass=MD5util.getMD5BySalt(userId, userPass);
		request.put("userPass", userPass);
		request.put("phone",phone);
		request.put("address", address);
		
		String vMSg="";
		if(SysFun.isNullOrEmpty(userNick)) {
			vMSg+="用户名不能为空";
		}
		if(SysFun.isNullOrEmpty(userPass)) {
			vMSg+="密码不能为空";
		}
		if(SysFun.isNullOrEmpty(email)) {
			vMSg+="邮箱不能为空";
		}
		if(SysFun.isNullOrEmpty(phone)) {
			vMSg+="联系方式不能为空";
		}
		if(SysFun.isNullOrEmpty(address)) {
			vMSg+="地址不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMSg)) {
			request.put("msg", vMSg);
			System.out.println(vMSg);
			return "insert";
		}
		Customer bean=new Customer();
		bean.setUserId(userId);
		bean.setUserNick(userNick);
		bean.setUserPass(userPass);
		bean.setEmail(email);
		bean.setPhone(phone);
		bean.setAddress(address);
		Long result=0L;
		try {
			result=customerService.insert(bean);
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
		if(!SysFun.isNullOrEmpty(id)) {
			Long iId=SysFun.parseLong(id);
			Long result=customerService.delete(iId);
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
		
		//String id=request.getParameter("id");
		if(!SysFun.isNullOrEmpty(id)) {
			Long iId=SysFun.parseLong(id);
			Customer bean=customerService.load(iId);
			
			if(bean!=null) {
				
				request.put("userId", bean.getUserId());
				request.put("userNick", bean.getUserNick());
				request.put("userPass", bean.getUserPass());
				request.put("email", bean.getEmail());
				request.put("address", bean.getAddress());
				request.put("phone", bean.getPhone());
				return "update";
				
			}
			
		}
		
		return "go_preload";
	}

	@Override
	public String updateDeal() {
		// TODO Auto-generated method stub
		request.put("userNick",userNick);
		request.put("email",email);
		userPass=MD5util.getMD5BySalt(userNick, userPass);
		request.put("userPass", userPass);
		request.put("phone",phone);
		request.put("address", address);
		
		String vMsg="";
		if(SysFun.isNullOrEmpty(userNick)) {
			vMsg+="用户名不能为空";
		}
		if(SysFun.isNullOrEmpty(userPass)) {
			vMsg+="密码不能为空";
		}
		if(SysFun.isNullOrEmpty(email)) {
			vMsg+="邮箱不能为空";
		}
		if(SysFun.isNullOrEmpty(phone)) {
			vMsg+="联系方式不能为空";
		}
		if(SysFun.isNullOrEmpty(address)) {
			vMsg+="地址不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMsg)) {
			request.put("msg", vMsg);
			return "update";
		}
		
		
		Long iId=SysFun.parseLong(id);
		Customer bean=customerService.load(iId);
		if(bean==null) {
			vMsg+="记录不存在";
		}
		
		if(!SysFun.isNullOrEmpty(vMsg)) {
			
			request.put("msg", vMsg);
			return "update";
		}
		bean.setUserNick(userNick);
		bean.setUserPass(userPass);
		bean.setEmail(email);
		bean.setPhone(phone);
		bean.setAddress(address);
		Long result=0L;
		try {
			result=customerService.update(bean);
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
		
		//String id=request.getParameter("id");
		if(!SysFun.isNullOrEmpty(id)) {
			Long iId=SysFun.parseLong(id);
			Customer bean=customerService.load(iId);
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
