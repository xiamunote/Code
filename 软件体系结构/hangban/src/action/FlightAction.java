package action;

import java.util.List;

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

import pojo.Flight;
import pojo.Userinfo;
import service.FlightInterface;
import serviceImp.FlightImp;

import dao.FlightDAO;
import dao.ReserveflightDAO;
import factory.HibernateSessionFactory;

public class FlightAction extends DispatchAction{

	
	public ActionForward listFlight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		
	String currentpage=request.getParameter("curr");	
		if(currentpage==null){
			
			currentpage="1";
		}
		
		FlightDAO dao=new FlightDAO();
		
		List list=dao.findAllFlight(Integer.parseInt(currentpage));	
		
		int page=dao.pageSize();
		
		request.setAttribute("currentpage", currentpage);
		
		request.setAttribute("page",page);
		
		request.setAttribute("listFlight",list);
		
		return mapping.findForward("flightManager");
	}	
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.saveToken(request);
		return mapping.findForward("addflight");
	}

	public ActionForward addflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(this.isTokenValid(request)){
			DynaActionForm df=(DynaActionForm)form;
			
			Flight flight=new Flight();
			
			BeanUtils.copyProperties(flight,df);
			
			System.out.println("hardsoft"+df.get("softtotal"));
			
			System.out.println("hardsoft"+flight.getSofttotal());

			
			FlightDAO dao=new FlightDAO();
			
			FlightInterface ff=new FlightImp();
			ff.save(flight);
			//dao.save(flight);
			resetToken(request);			
		
			return mapping.findForward("flightManager1");
			
			
		}else{
			return mapping.findForward("flightManager");
		}
		
	}
	
	public ActionForward deleteflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] flightid=request.getParameterValues("flightid");

		FlightDAO dao=new FlightDAO();
		for(int i=0;i<flightid.length ;i++){
			String fid=flightid[i];
			Long tid=Long.parseLong(fid);
			
			dao.delete(tid);
		}		
		return mapping.findForward("flightManager1");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fid=request.getParameter("id");
		
		if(fid!=null&&!"".equals(fid)){			
			FlightDAO dao=new FlightDAO();
			HttpSession session=request.getSession();
			session.setAttribute("updateFlight",dao.findById(Long.parseLong(fid)));
			
			this.saveToken(request);
			return mapping.findForward("updateflight");
		}else{
			return null;
		}
		
	}	
	public ActionForward updateflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm df=(DynaActionForm)form;
		
		Flight f=new Flight();
		BeanUtils.copyProperties(f,df);
		
		FlightDAO dao=new FlightDAO();
		
		dao.update(f);
		
		return mapping.findForward("flightManager1");
	}	
	public ActionForward managercheckflight(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		
		ReserveflightDAO dao=new ReserveflightDAO();
		session.setAttribute("reserveflight", dao.findAll());
		
		return mapping.findForward("checkflight");
	}
	
	public ActionForward managerselect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 管理员立即查询
	System.out.println("*************************************");
		HttpSession session=request.getSession();
		
		String username=request.getParameter("username");
			
		String flightno=request.getParameter("flightno");	
	System.out.println("username===="+username+"   flightno======"+flightno);
		FlightDAO dao=new FlightDAO();		
		List list=dao.selectDestine(flightno, username);
		session.setAttribute("selectLflight",list);	
//		request.setAttribute("selectLflight", list);
		System.out.println("###############"+list.size());
		return mapping.findForward("managerLMess");
	}
	
	public ActionForward reserSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 管理员立即查询
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		HttpSession session=request.getSession();
		
		String qdzhan=request.getParameter("qdzhan");			
		String zhdzhan=request.getParameter("zhdzhan");
	System.out.println("qdzhan======"+qdzhan);
	System.out.println("zhdzhan======"+zhdzhan);
		FlightDAO dao=new FlightDAO();		
		List list=dao.reserSelect(qdzhan, zhdzhan);
			
		session.setAttribute("reserselect",list);	
//		request.setAttribute("selectLflight", list);
		System.out.println("###############"+list.size());
		return mapping.findForward("treserselect");
	}
	
}
