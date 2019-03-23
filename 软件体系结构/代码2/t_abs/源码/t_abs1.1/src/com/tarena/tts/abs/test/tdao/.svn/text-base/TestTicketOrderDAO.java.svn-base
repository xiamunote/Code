package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.TicketOrderDAO;
import com.tarena.tts.abs.dao.impl.TicketOrderDAOImpl;
import com.tarena.tts.abs.entity.TicketOrder;
import com.tarena.tts.abs.util.DateUtil;

public class TestTicketOrderDAO {
	
//	@Test
	public void delete() throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		TicketOrder to = dao.findById(1001L);
		dao.delete(to);
	}
	
//	@Test
	public void findAll() throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		List<TicketOrder> list = dao.findAll();
		
		for(TicketOrder to : list){
			System.out.println(to.getFlightId());
		}
	}
	
	@Test
	public void save() throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		TicketOrder to = new TicketOrder();
		to.setOrderId(1001L);
		to.setUserId(1);
		to.setOrderMoney(10.5);
		to.setOrderDate(new Date());
		to.setOrderState("O");
		to.setPaymentRecord("世界如此美妙，我却如此暴躁，这样不好，不好");
		to.setFlightId("A201010251201");
		to.setCabinClass("f");
		
		dao.save(to);
		
	}
	
//	@Test
	public void update() throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		TicketOrder to = dao.findById(1001L);
		to.setPaymentRecord(
				"小新快跑");
		
		dao.update(to);
	}
	
//	@Test
	public void findByPassenger()throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		List<TicketOrder> list = dao.findByPassenger("唐亮");
		for(TicketOrder to : list){
			System.out.println(to);
		}
	}
	
	@Test
	public void updateOrderState() throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		dao.updateOrderState("B", 1);
	}
	
	/**
	 * @ void findMyOrders(TestTicketOrderDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 24, 20125:28:57 PM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void findMyOrders() throws Exception{
		TicketOrderDAO dao = new TicketOrderDAOImpl();
		List<Object[]> list = 
			dao.findMyOrders(null, null,  null, null , null ,"上海" ,6);
		
		for(Object[] o : list){
			System.out.println(o[0]);
		}
		
	}
}
