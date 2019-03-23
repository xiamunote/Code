package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import pojo.Userinfo;
import dao.FlightDAO;
import dao.ReserveflightDAO;

public class CommUserAction extends DispatchAction{

	
	public ActionForward listflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FlightDAO dao=new FlightDAO();
		
		HttpSession session=request.getSession();
		session.setAttribute("listFlight", dao.findAll());
		
		return mapping.findForward("reserflight");
	}
	
	public ActionForward reserflight1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String id=request.getParameter("fid");
		
		request.getSession().setAttribute("flightid",id);
	
		return mapping.findForward("destine");
	}
		
	public ActionForward reserflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("预定机票");		
		HttpSession session=request.getSession();
		
		String id=(String)request.getSession().getAttribute("flightid");
		Long flightid=Long.parseLong(id);
	
		String softnumber=request.getParameter("softnumber");		
		
		String hardnumber=request.getParameter("hardnumber");			
		
		Userinfo user=(Userinfo)session.getAttribute("user");
		Long userid=user.getUserid();	
		
		FlightDAO dao=new FlightDAO();
		dao.reserveflight(userid, flightid,Long.parseLong(softnumber),Long.parseLong(hardnumber));		
				
		return mapping.findForward("listall");
	}
	
	public ActionForward listall(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=request.getSession();

		Userinfo user=(Userinfo)request.getSession().getAttribute("user");
		
		ReserveflightDAO dao=new ReserveflightDAO();
		session.setAttribute("listall", dao.findAll1(user.getUsername()));
	
		
		return mapping.findForward("resersucc");
	}

	
	public ActionForward usercheckflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo user=(Userinfo)request.getSession().getAttribute("user");
		
		ReserveflightDAO dao=new ReserveflightDAO();
		session.setAttribute("reserveflight", dao.findAll1(user.getUsername()));
		
		return mapping.findForward("usercheckflight");
	}

	
	public ActionForward selectuserFM(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//普通用户立即查询
		HttpSession session=request.getSession();
		String flightno=request.getParameter("flightno");
		
		Userinfo user=(Userinfo)session.getAttribute("user");
		String username=user.getUsername();
		
		FlightDAO dao=new FlightDAO();
		
		session.setAttribute("selectLflight",dao.showDestine(flightno,username));
		
		return mapping.findForward("selectLMess");
	}
	
	public ActionForward boucetine(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {	

		HttpSession session=request.getSession();
		
		Userinfo user=(Userinfo)request.getSession().getAttribute("user");
		
		ReserveflightDAO dao=new ReserveflightDAO();
		session.setAttribute("listall", dao.findAll1(user.getUsername()));
	
		
		return mapping.findForward("bouncetine");
	}
	
	public ActionForward boucetine1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {			
		
		String hardnumber=request.getParameter("hardnumber");
		String softnumber=request.getParameter("softnumber");
		String reservid=request.getParameter("reservid");
		
		ReserveflightDAO dao1=new ReserveflightDAO();
		
		dao1.boucetine(Long.parseLong(softnumber),Long.parseLong(hardnumber),Long.parseLong(reservid));
			
		return mapping.findForward("listall");
		
	}

}
