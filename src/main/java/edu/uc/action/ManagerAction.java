package edu.uc.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;

import edu.uc.bean.Manager;
import edu.uc.service.AdminService;
import edu.uc.util.MD5util;

@Component("ManagerAction")
@Scope("prototype")
public class ManagerAction extends CrudAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1011748844560817334L;
	@Autowired
	private AdminService adminService;
	
	private String userName;
	private String userId;
	private String id;
	//判断是修改密码还是重置密码
	private String status;
	private String newPass;
	private String checkPass;
	
	
	
	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getCheckPass() {
		return checkPass;
	}

	public void setCheckPass(String checkPass) {
		this.checkPass = checkPass;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String list() {
		List<Manager> vDataList = null;
		//分页步骤，创建分页对象，老师已经包装
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageSize(pageSize);
		pagerItem.parsePageNum(pageNum);
		//分页步骤 1定义总量 初始化为0
		Long rowCount=0L;
		//2.查询记录总数
		rowCount = adminService.count();
		//3.将记录赋给pagerItem,以便进行分页的各项计算
		pagerItem.changeRowCount(rowCount);
		//4.根据指定分页数 获取数据
		vDataList = adminService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		//5.设置跳转页面
		pagerItem.changeUrl(SysFun.generalUrl(requestURI,queryString));
		request.put("pagerItem", pagerItem);
		request.put("DataList", vDataList);
		return "list";
	}

	@Override
	public String listDeal() {
		request.put("userName", userName);
		List<Manager> vDataList =null;
		
		//创建分页对象
		PagerItem pagerItem = new PagerItem();
		pagerItem.parsePageNum(pageNum);
		pagerItem.parsePageSize(pageSize);
		
		//定义记录变量数
		Long rowCount = 0L;
		if(!SysFun.isNullOrEmpty(userName))
		{
			rowCount = adminService.countByName(userName);
			pagerItem.changeRowCount(rowCount);
			vDataList = adminService.pagerByName(userName, pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		else
		{
			rowCount = adminService.count();
			pagerItem.changeRowCount(rowCount);
			vDataList = adminService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
		}
		pagerItem.changeUrl(SysFun.generalUrl(requestURI,queryString));
		request.put("pagerItem", pagerItem);
		request.put("DataList", vDataList);
		return "list";
	}

	@Override
	public String insert() {
		return "insert";
	}

	@Override
	public String insertDeal() {
		request.put("userName",userName);
		request.put("userId",userId);
		//System.out.println(selectedCategoryName);
		String vMsg="";
		if(SysFun.isNullOrEmpty(userId))
		{
			vMsg+="管理员账号不能为空";
		}
		if(SysFun.isNullOrEmpty(userName))
		{
			vMsg+="管理员姓名不能为空";
		}
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "insert";
		}
		Manager bean = new Manager();
		bean.setUserId(userId);
		bean.setUserName(userName);
		bean.setPriority(2);
		bean.setUserPass(MD5util.getMD5BySalt(userId, "123456"));
		Long result = 0l;
		try
		{
			result = adminService.insert(bean);
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
			Long result = adminService.delete(vId);
			if(result>0)
			{
				return "go_ok";
			}
		}
		return "go_no";
	}

	@Override
	public String update() {
		request.put("id", id);
		request.put("status",status);
		Long vId = SysFun.parseLong(id);
		if(status.equals("0"))
		{
			Manager bean  = adminService.load(vId);
			bean.setUserPass(MD5util.getMD5BySalt(bean.getUserId(), "123456"));
			adminService.update(bean);
			return "go_reload";
		}
		else
		{
			return "update";
		}
	}

	@Override
	public String updateDeal() {
		request.put("id", id);
		request.put("newPass",newPass);
		request.put("checkPass", checkPass);
		String vMsg="";
		if(SysFun.isNullOrEmpty(id))
		{
			vMsg+="用户主键不能为空";
		}
		if(SysFun.isNullOrEmpty(newPass))
		{
			vMsg+="新密码不能为空";
		}
		if(SysFun.isNullOrEmpty(checkPass))
		{
			vMsg+="确认密码不能为空";
		}
		if(!newPass.equals(checkPass))
		{
			vMsg+="两次输入不一致";
		}
		if(!SysFun.isNullOrEmpty(vMsg))
		{
			request.put("msg", vMsg);
			System.out.println(vMsg);
			return "update";
		}
		
		Long vId = SysFun.parseLong(id);
		Manager bean = adminService.load(vId);
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
		bean.setUserPass(MD5util.getMD5BySalt(bean.getUserId(), newPass));
		Long result = 0l;
		try
		{
			result = adminService.update(bean);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detailDeal() {
		// TODO Auto-generated method stub
		return null;
	}

}
