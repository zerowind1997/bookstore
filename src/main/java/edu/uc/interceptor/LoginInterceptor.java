package edu.uc.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.uc.action.UIConst;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2879856516386272140L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String,Object> session=null;
		session=arg0.getInvocationContext().getSession();
		if(session.get(UIConst.BG_LOGINUSER_KEY)==null)
		{
			return "login";
		}
		else
		{
			return arg0.invoke();
		}
		
	}

}
