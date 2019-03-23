package com.tarena.tts.abs.biz.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tarena.tts.abs.biz.OrderdetailBiz;
import com.tarena.tts.abs.dao.OrderdetailDAO;
import com.tarena.tts.abs.dao.impl.OrderdetailDAOImpl;
import com.tarena.tts.abs.entity.Orderdetail;
import com.tarena.tts.abs.entity.TicketOrder;
import com.tarena.tts.abs.vo.Orderdetail02;
import com.tarena.tts.abs.util.ChangeTypeUtil;
import com.tarena.tts.abs.util.DateUtil;

public class OrderdetailBizImpl implements OrderdetailBiz {

	public List<Orderdetail> getOrderView(Long orderId) throws Exception {
		OrderdetailDAO orderdetailDAO = new OrderdetailDAOImpl();
		List<Orderdetail> orderdetailList = new ArrayList<Orderdetail>();
		List<Object[]> objectList = orderdetailDAO.findOrderdetail(orderId);
		for (Object[] objects : objectList) {
			Orderdetail orderdetail = new Orderdetail();
			orderdetail.setPsgName(objects[0].toString());
			String psgCertifType = ChangeTypeUtil.changeUserCertifTypeToWord(objects[1].toString());
			orderdetail.setPsgCertifType(psgCertifType);
//			orderdetail.setPsgCertifType(objects[1].toString());
			orderdetail.setPsgCertifNum(objects[2].toString());
			String psgType = ChangeTypeUtil.changePsgTypeToWord(objects[3].toString());
			orderdetail.setPsgType(psgType);
//			orderdetail.setPsgType(objects[3].toString());
			orderdetail.setFlightNum(objects[4].toString());
			orderdetail.setDepartureDate(objects[5].toString());
			orderdetail.setDeparturetime(objects[6].toString());
			orderdetail.setCabinClass(objects[7].toString());
			orderdetail.setTicketId(Long.valueOf(objects[8].toString()));
			orderdetail.setPrice(doubleFormat(Double.valueOf(objects[9].toString())));
			orderdetail.setTicketPrice(doubleFormat(Double.valueOf(objects[10].toString())));
			orderdetail.setTax1Price(doubleFormat(Double.valueOf(objects[11].toString())));
			orderdetail.setTax2Price(doubleFormat(Double.valueOf(objects[12].toString())));
			orderdetail.setTotalPrice(doubleFormat(Double.valueOf(objects[13].toString())));
			
			orderdetailList.add(orderdetail);
		}
		return orderdetailList;
	}

	public Orderdetail02 getTicketOrder(Long orderId) throws Exception {
		Orderdetail02 orderdetail02 = new Orderdetail02();
		OrderdetailDAO orderdetailDAO = new OrderdetailDAOImpl();
		List<TicketOrder> ticketOrderList = orderdetailDAO.findTicketOrder(orderId);
		TicketOrder ticketOrder = ticketOrderList.get(0);
		orderdetail02.setOrderId(ticketOrder.getOrderId());
		orderdetail02.setOrderDate(DateUtil.format(ticketOrder.getOrderDate()));
		Calendar orderCalendar = Calendar.getInstance();
		orderCalendar.setTime(ticketOrder.getOrderDate());
		orderCalendar.add(Calendar.MINUTE, +30);
		String dateLimit = DateUtil.format(orderCalendar.getTime());
		System.out.println("OrderDateLimit="+dateLimit);
		orderdetail02.setOrderDateLimit(dateLimit);
		double totalMoney = 0;
		for (int i = 0; i < ticketOrderList.size(); i++) {
			TicketOrder ticketOrder2 = ticketOrderList.get(i);
			totalMoney = totalMoney + ticketOrder2.getOrderMoney();
		}
		orderdetail02.setOrderMoney(doubleFormat(totalMoney));
		return orderdetail02;
	}

	private String doubleFormat(double money) {
		String result = null;
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(money);
	}

}
