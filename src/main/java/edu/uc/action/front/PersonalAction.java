package edu.uc.action.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.SysFun;

import edu.uc.action.BaseAction;
import edu.uc.bean.Customer;
import edu.uc.service.CustomerService;
import edu.uc.util.MD5util;

@Component("PersonalAction")
@Scope("prototype")
public class PersonalAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7968581547148379227L;
	@Autowired
	private CustomerService customerService;
	private String id;
	private String address;
	private String province1;
	private String city1;
	private String district1;
	private String userId;
	private String userNick;
	private String email;
	private String phone;
	private String oldPass;
	private String newPass;
	private String checkPass;
	
	
	

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince1() {
		return province1;
	}

	public void setProvince1(String province1) {
		this.province1 = province1;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getDistrict1() {
		return district1;
	}

	public void setDistrict1(String district1) {
		this.district1 = district1;
	}

	public String personal() {
		return "personal";
	}

	public String address() {
		return "address";
	}

	public String updateAddress() {
		request.put("address", address);
		String vMsg = "";
		if (SysFun.isNullOrEmpty(address)) {
			vMsg += "地址不能为空";
		}
		Long iId = SysFun.parseLong(id);
		System.out.println(id+"====");
		Customer bean = customerService.load(iId);
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.put("msg", vMsg);
			return "address";
		}
		bean.setAddress(province1+city1+district1+address);
		Long result=0L;
		try {
			result=customerService.update(bean);
			session.put("loginCustomer", bean);
			//System.out.println("111");
		}
		catch (Exception e) {
			// TODO: handle exception
			vMsg+="修改失败，原因："+e.getMessage();
		}
		
		if(result>0) {
			return "address";
		}
		else {
			request.put("msg", vMsg);
			return "address";
		}
	}
	public String information()
	{
		return "information";
	}
	public String informationUpdate()
	{
		request.put("userId", userId);
		request.put("userNick", userNick);
		request.put("email", email);
		request.put("phone", phone);
		String vMsg = "";
		if (SysFun.isNullOrEmpty(userId)) {
			vMsg += "账号不能为空";
		}
		if (SysFun.isNullOrEmpty(userNick)) {
			vMsg += "昵称不能为空";
		}
		if (SysFun.isNullOrEmpty(email)) {
			vMsg += "邮箱不能为空";
		}
		if (SysFun.isNullOrEmpty(phone)) {
			vMsg += "电话不能为空";
		}
		Long iId = SysFun.parseLong(id);
		Customer bean = customerService.load(iId);
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.put("msg", vMsg);
			return "information";
		}
		bean.setEmail(email);
		bean.setPhone(phone);
		bean.setUserId(userId);
		bean.setUserNick(userNick);
		Long result=0L;
		try {
			result=customerService.update(bean);
			session.put("loginCustomer", bean);
			//System.out.println("111");
		}
		catch (Exception e) {
			// TODO: handle exception
			vMsg+="修改失败，原因："+e.getMessage();
		}
		
		if(result>0) {
			return "information";
		}
		else {
			request.put("msg", vMsg);
			return "information";
		}
		
	}
	public String password()
	{
		return "password";
	}
	public String passwordUpdate()
	{
		request.put("oldPass", oldPass);
		request.put("newPass", newPass);
		request.put("checkPass", checkPass);
		String vMsg = "";
		if (SysFun.isNullOrEmpty(oldPass)) {
			vMsg += "旧密码不能为空";
		}
		if (SysFun.isNullOrEmpty(newPass)) {
			vMsg += "新密码不能为空";
		}
		if (SysFun.isNullOrEmpty(checkPass)) {
			vMsg += "再次确认不能为空";
		}
		Long iId = SysFun.parseLong(id);
		System.out.println(iId);
		Customer bean = customerService.load(iId);
		if(!bean.getUserPass().equals(MD5util.getMD5BySalt("lcc", oldPass)))
		{
			vMsg += "旧密码输入错误";
		}
		if(!newPass.equals(checkPass))
		{
			vMsg += "两次输入密码不一致";
		}
		if (!SysFun.isNullOrEmpty(vMsg)) {
			request.put("msg", vMsg);
			return "password";
		}
		bean.setUserPass(MD5util.getMD5BySalt(bean.getUserId(), newPass));
		Long result=0L;
		try {
			result=customerService.update(bean);
			session.put("loginCustomer", bean);
			request.put("msg", "修改成功");
			request.put("oldPass", "");
			request.put("newPass", "");
			request.put("checkPass", "");
			//System.out.println("111");
		}
		catch (Exception e) {
			// TODO: handle exception
			vMsg+="修改失败，原因："+e.getMessage();
		}
		
		if(result>0) {
			return "password";
		}
		else {
			request.put("msg", vMsg);
			return "password";
		}
	}
}
