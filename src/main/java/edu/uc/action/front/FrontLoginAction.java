package edu.uc.action.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.SysFun;

import edu.uc.action.BaseAction;
import edu.uc.bean.Customer;
import edu.uc.service.CustomerService;
import edu.uc.util.MD5util;
@Component("FrontLoginAction")
@Scope("prototype")
public class FrontLoginAction extends BaseAction {
	
	@Autowired
	private CustomerService customerService;
	private String userId;
	private String userPass;
	private String userNick;
	private String email;
	private String phone;
	private String checkPass;
	
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCheckPass() {
		return checkPass;
	}
	public void setCheckPass(String checkPass) {
		this.checkPass = checkPass;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4786684627612539697L;
	
	/**
	 * 登入处理
	 * @return
	 */
	public String loginDeal()
	{
		String result = "login";
		String msg="";
		if(SysFun.isNullOrEmpty(userId))
		{
			msg+="账号不能为空";
		}
		if(SysFun.isNullOrEmpty(userPass))
		{
			msg+="密码不能为空";
		}
		if(!SysFun.isNullOrEmpty(msg))
		{
			request.put("msg", msg);
			return result;
		}
		
		Customer loginCustomer = customerService.loadByUserId(userId);
		if(loginCustomer == null)
		{
			request.put("msg", "账号不存在");
			return result;
		}
		userPass = MD5util.getMD5BySalt(userId, userPass);
		//若是账号存在，判断密码
		if(!loginCustomer.getUserPass().equals(userPass))
		{
			request.put("msg", "密码错误");
			return result;
		}
		//登入成功，将用户存在session里
		session.put("loginCustomer", loginCustomer);
		//登入成功，进入主界面
		result="index";
		return result;
	}
	/**
	 * 注销用户
	 * @return
	 */
	public String logoutDeal() {
		clearLogin();
		return "index";
	}
	/**
	 * 添加用户
	 * @return
	 */
	public String registerDeal()
	{
		request.put("userId",userId);
		request.put("userNick",userNick);
		request.put("email",email);
		request.put("phone",phone);
		request.put("userPass",userPass);
		request.put("checkPass",checkPass);
		String vMSg="";
		if(SysFun.isNullOrEmpty(userId)) {
			vMSg+="用户账号不能为空";
		}
		if(SysFun.isNullOrEmpty(userNick)) {
			vMSg+="用户昵称不能为空";
		}
	
		if(SysFun.isNullOrEmpty(email)) {
			vMSg+="邮箱不能为空";
		}
		if(SysFun.isNullOrEmpty(phone)) {
			vMSg+="联系方式不能为空";
		}
		if(SysFun.isNullOrEmpty(userPass)) {
			vMSg+="密码不能为空";
		}
		if(SysFun.isNullOrEmpty(checkPass)) {
			vMSg+="确认密码不能为空";
		}
		if(!userPass.equals(checkPass))
		{
			vMSg+="两次密码输入不一致";
		}
		if(!SysFun.isNullOrEmpty(vMSg)) {
			request.put("msg", vMSg);
			System.out.println(vMSg);
			return "register";
		}
		Customer bean=new Customer();
		bean.setUserId(userId);
		bean.setUserNick(userNick);
		bean.setUserPass(MD5util.getMD5BySalt(userId, userPass));
		bean.setEmail(email);
		bean.setPhone(phone);
		bean.setStatus(0);
		Long result=0L;
		try {
			result=customerService.insert(bean);
			System.out.println(result);
		}
		catch(Exception e) {
			vMSg+="添加失败，原因："+e.getMessage();
		}
		if(result>0) {
			return "login";
		}
		else {
			request.put("msg", vMSg);
			return "register";
		}
	}
}
