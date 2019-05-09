package edu.uc.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("MainAction")
@Scope("prototype")
public class MainAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9072851201756578429L;

	public String view()
	{
		String result="view";
		return result;
	}
	public String welcome()
	{
		String result="welcome";
		return result;
	}
}
