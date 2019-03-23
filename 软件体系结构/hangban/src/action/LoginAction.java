package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;

import dao.LoginDao;
import dao.UserinfoDAO;
import factory.HibernateSessionFactory;


import pojo.Userinfo;

public class LoginAction extends DispatchAction{

	
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm df=(DynaActionForm)form;
		
		Userinfo user=new Userinfo();
		
		BeanUtils.copyProperties(user,df);
		
		
		LoginDao dao=new LoginDao();
		Userinfo user1=dao.selectidinfo(user);
		if(dao.checkLogin(user)){
			if(df.get("ismanager").equals("1")){
				System.out.println("普通用户登录成功");
				
				HttpSession session=request.getSession();
				session.setAttribute("user",user1);
				return mapping.findForward("ushowallTiles");
			}else{
				
				HttpSession session=request.getSession();
				session.setAttribute("user",user1);				
				return mapping.findForward("ushowallTiles1");
			}
			
		}else{
			System.out.println("登录失败");
			ActionErrors errors=new ActionErrors();
			errors.add("errors1", new ActionMessage("错误的用户名或密码",false));
			this.saveErrors(request, errors);
			
			return mapping.findForward("index");
		}
		
	}

	
	public ActionForward regist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm df=(DynaActionForm)form;
		
		Userinfo user=new Userinfo();
		
		BeanUtils.copyProperties(user,df);
		
		UserinfoDAO dao=new UserinfoDAO();
		dao.save(user);
		
		return mapping.findForward("index");
	}
	
	
	
}
