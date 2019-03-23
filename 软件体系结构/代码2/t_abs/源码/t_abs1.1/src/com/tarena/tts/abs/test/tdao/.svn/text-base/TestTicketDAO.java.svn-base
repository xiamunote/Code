package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import org.junit.Test;
import com.tarena.tts.abs.dao.TicketDAO;
import com.tarena.tts.abs.dao.impl.TicketDAOImpl;
import com.tarena.tts.abs.entity.Ticket;

public class TestTicketDAO {
	
//	@Test
	public void delete() throws Exception{
		TicketDAO dao = new TicketDAOImpl();
//		Ticket t =
	}
	
//	@Test
	public void findAll() throws Exception{
		
	}
	
	@Test
	public void save() throws Exception{
		TicketDAO dao = new TicketDAOImpl();
		Ticket t = new Ticket();
		t.setTicketId(System.currentTimeMillis());
		t.setFlightNum("TL1212");
		t.setRouteId(3);
		t.setDepartureDatetime(new Date());
		t.setArrivalDatatime(new Date());
		t.setCabinClass("A");
		t.setTicketDate(new Date());
		t.setTicketPrice(12.5d);
		t.setTax1Price(12.5);
		t.setTax2Price(11.5);
		//#####
		t.setTotalPrice(t.getTicketPrice()
						+ t.getTax1Price()
						+ t.getTax2Price());
		t.setSeatsOrder(111);
		t.setChangeState("A");
		t.setRefundTicketCharge(11.11);
		t.setRestrictions("hold on , little girl");
		t.setAgentInfo("let it be");
		t.setPaymentType("Cash");
		t.setPaymentRef("aaaa");
		t.setBusinessRecordId(12580L);
		t.setTerminalIp("www.tarena.com.cn");
		t.setTerminalType("Agent");
		
		dao.save(t);

	}
	
	@Test
	public void update() throws Exception{
		TicketDAO dao = new TicketDAOImpl();
		Ticket t = dao.findById(1334140793046L);
		
		dao.update(t);
	}
}
