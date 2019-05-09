package edu.uc.action;

import com.opensymphony.xwork2.ActionContext;

public abstract class BaseAction extends com.opensymphony.xwork2.ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2509226703864561709L;

	private final String AREANAME_KEY = "areaName";
	protected String areaName = UIConst.AREANAME; // 当前区域的名称

	protected String requestURI;
	protected String queryString;

	protected java.util.Map<String, Object> request;
	protected java.util.Map<String, Object> session;
	protected java.util.Map<String, Object> application;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		if (ActionContext.getContext().getSession().get(AREANAME_KEY) == null) {
			ActionContext.getContext().getSession().put(AREANAME_KEY, areaName);
		}
		
		requestURI = org.apache.struts2.ServletActionContext.getRequest().getRequestURI();
		queryString = org.apache.struts2.ServletActionContext.getRequest().getQueryString();

		request = (java.util.Map<String, Object>) ActionContext.getContext().get("request");
		session = com.opensymphony.xwork2.ActionContext.getContext().getSession();
		application = com.opensymphony.xwork2.ActionContext.getContext().getApplication();

		/*
		 * System.out.println(requestURI); System.out.println(queryString);
		 * System.out.println(pageNum); System.out.println(pageSize);
		 */
	}

	/**
	 * 操作类型: 用于获取url中的oper参数
	 */
	protected String oper;

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	/**
	 * 检测是否登录，未登录，则返回login；否则，返回login。
	 * 
	 * @return
	 */
	public String checkLogin() {
		//System.out.println("checkLogin()");
		if (ActionContext.getContext().getSession().get(UIConst.BG_LOGINUSER_KEY) == null) {
			return "login";
		}
		return "view";
	}

	/**
	 * 清空登录信息：清空会话的所有数据
	 */
	public void clearLogin() {
		ActionContext.getContext().getSession().clear();
	}

	/**
	 * 检测是否有权限
	 * 
	 * @return
	 */
	public String checkRight() {
		System.out.println("checkRight");

		if (ActionContext.getContext().getSession().get(UIConst.BG_LOGINUSER_KEY) == null) {
			System.out.println("checkLogin:no");
			return "login";
		}

		if (ActionContext.getContext().getSession().get(UIConst.BG_ISADMIN_KEY) == null) {
			System.out.println("checkRight:no");
			return "go_noright";
		}
		return "";
	}

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
}
