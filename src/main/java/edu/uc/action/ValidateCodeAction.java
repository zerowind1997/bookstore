package edu.uc.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liuvei.common.RandFun;
import com.liuvei.common.ValidateCodeFun;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

@Component("ValidateCodeAction")
@Scope("prototype")
public class ValidateCodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3937897301588331070L;
	
	public String execute() throws Exception
	{
		//1.生成4位随机数字组成的字符串
		String strCode = RandFun.rand4Num().toString();
		//2.将随机数字放入session会话中
		ActionContext.getContext().getSession().put(UIConst.BG_VALIDATE_CODE_KEY, strCode);
		//3.随机字符串转成图片
		BufferedImage image = ValidateCodeFun.generalImage(strCode);
		//4.图片转为字节数组输入流，作为响应管道的输入流
		rspStream = ValidateCodeFun.toByteArrayInputStream(image);
		
		return Action.SUCCESS;
	}
	
	//响应管道的输出流
	private ByteArrayInputStream rspStream;
	public ByteArrayInputStream getRspStream() {
		return rspStream;
	}
	public void setRspStream(ByteArrayInputStream rspStream) {
		this.rspStream = rspStream;
	}
	
}
