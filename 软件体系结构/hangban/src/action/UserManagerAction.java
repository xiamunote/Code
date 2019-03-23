package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;

import pojo.Userinfo;

import dao.UserinfoDAO;
import factory.HibernateSessionFactory;

public class UserManagerAction extends DispatchAction{

	
	public ActionForward listuser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserinfoDAO dao=new UserinfoDAO();
		
		HttpSession session1=request.getSession();
		session1.setAttribute("listuser", dao.findAll());
		return mapping.findForward("listuser");
	}

	
	public ActionForward modifyUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userid=request.getParameter("userid");
		
		if(userid!=null&&!"".equals(userid)){
			UserinfoDAO dao=new UserinfoDAO();
			
			HttpSession session1=request.getSession();
			session1.setAttribute("updateUser", dao.findById(Long.parseLong(userid)));
			
			this.saveToken(request);
			return mapping.findForward("updateuser");
		}
		
		return super.execute(mapping, form, request, response);
	}


	
	public ActionForward updateuser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Session session=HibernateSessionFactory.getSession();
		
		String userid=request.getParameter("userid");
		Userinfo user=(Userinfo)session.get(Userinfo.class, Long.parseLong(userid));
		DynaActionForm df=(DynaActionForm)form;
				
		
		BeanUtils.copyProperties(user,df);
				
		UserinfoDAO dao=new UserinfoDAO();
		dao.update(user);
		
		HttpSession session1=request.getSession();
		session1.setAttribute("listuser", dao.findAll());
		return mapping.findForward("listuser");
		
	}


	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.saveToken(request);
		return mapping.findForward("adduser");
	}


	
	public ActionForward adduser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(this.isTokenValid(request)){
			DynaActionForm df=(DynaActionForm)form;
			Userinfo u=new Userinfo();
			
			BeanUtils.copyProperties(u,df);
			
			UserinfoDAO dao=new UserinfoDAO();
			dao.save(u);
			resetToken(request);
			
			HttpSession session1=request.getSession();
			session1.setAttribute("listuser", dao.findAll());
			return mapping.findForward("listuser");
			
		}else{
			return mapping.findForward("listuser");
		}
		
	}


	
	public ActionForward deleteuser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Session session=HibernateSessionFactory.getSession();
		String[] box=request.getParameterValues("userid");
		UserinfoDAO dao=new UserinfoDAO();
		
		for(int i=0;i<box.length;i++){
			String id=box[i];
			Long useid=Long.parseLong(id);
			
			Userinfo u=(Userinfo)session.get(Userinfo.class, useid);
			
			dao.delete(u);
			
		}
		session.close();
		HttpSession session1=request.getSession();
		session1.setAttribute("listuser", dao.findAll());
		return mapping.findForward("listuser");
	}
	
	
}
