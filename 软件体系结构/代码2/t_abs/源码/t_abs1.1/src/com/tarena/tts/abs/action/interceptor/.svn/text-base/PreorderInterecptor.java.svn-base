package com.tarena.tts.abs.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.tarena.tts.abs.entity.User;

/**
 * @ file_name PreorderInterecptor.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 31, 20129:11:12 AM
 * @ description
 * @ reviewed_by 
 */
public class PreorderInterecptor implements Interceptor{
	
	public void destroy() {}
	public void init() {}

	public String intercept(ActionInvocation actionInvocation) 
	throws Exception {
		System.out.println("进入拦截器");
		ValueStack stack = actionInvocation.getStack();
		User user  = (User)stack.findValue("#session.user");
		
		//如果用户为null ，则进行拦截
		if(user == null){		
			System.out.println("拦截器进行了拦截...");			
			return "intercept";
		
		}else{
			//否则继续Action
			actionInvocation.invoke();
			return null;
		}
	}
}
