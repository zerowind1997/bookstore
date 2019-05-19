package edu.uc.action.front;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uc.action.BaseAction;
@Component("IndexAction")
@Scope("prototype")
public class IndexAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4037563422444612101L;
	public String view()
	{
		return "view";
	}
	public String login()
	{
		return "login";
	}
	public String register()
	{
		return "register";
	}
	
}
