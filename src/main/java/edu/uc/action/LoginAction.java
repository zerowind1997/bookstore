package edu.uc.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.SysFun;

import edu.uc.bean.Manager;
import edu.uc.service.AdminService;
import edu.uc.util.MD5util;



@Component("LoginAction")
@Scope("prototype")
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2518242461148959930L;
	
	private String userName;
	private String userPass ;
	private String ValidateCode;
	
	
	public String getValidateCode() {
		return ValidateCode;
	}
	public void setValidateCode(String validateCode) {
		ValidateCode = validateCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public LoginAction()
	{
		System.out.println(this);
	}
	@Autowired
	private AdminService adminService;
	public String view() {
		String result="view";
		return result;
	}
	public String loginDeal() {
		// TODO Auto-generated method stub
		String result = "view";
		String validate=ValidateCode;
		String msg="";
		if(SysFun.isNullOrEmpty(userName))
		{
			msg+="账号不能为空";
		}
		if(SysFun.isNullOrEmpty(userPass))
		{
			msg+="密码不能为空";
		}
		if(SysFun.isNullOrEmpty(validate))
		{
			msg+="验证码不能为空";
		}
		if(!SysFun.isNullOrEmpty(msg))
		{
			request.put("msg", msg);
			return result;
		}
		//先验证验证码是否正确
		if(!validate.equals(session.get(UIConst.BG_VALIDATE_CODE_KEY)))
		{
			msg+="验证码错误";
		}
		if(!SysFun.isNullOrEmpty(msg))
		{
			request.put("msg", msg);
			return result;
		}
		//验证码要是正确，判断账号密码是否正确
		
		Manager manger = adminService.loadByName(userName);
		if(manger == null)
		{
			request.put("msg", "账号不存在");
			return result;
		}
		userPass = MD5util.getMD5BySalt(userName, userPass);
		//若是账号存在，判断密码
		if(!manger.getUserPass().equals(userPass))
		{
			request.put("msg", "密码错误");
			return result;
		}
		//登入成功，将用户存在session里
		session.put(UIConst.BG_LOGINUSER_KEY, manger);
		//登入成功后 就将是否管理员的标识保存在session里
		if(!manger.getUserName().equals("admin"))
		{
			session.put(UIConst.BG_ISADMIN_KEY, true);
		}
		//登入成功，进入主界面
		result="main";
		return result;
	}
	public String logoutDeal() {
		String result="view";
		clearLogin();
		result="login";
		return result;
	}
}
