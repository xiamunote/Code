package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.biz.OrderBiz;
import com.tarena.tts.abs.dao.TicketOrderDAO;
import com.tarena.tts.abs.dao.impl.TicketOrderDAOImpl;
import com.tarena.tts.abs.vo.TicketOrder01;
import com.tarena.tts.abs.util.DateUtil;
/**
 * @ file_name OrderBizImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 24, 20125:51:12 PM
 * @ description
 * @ reviewed_by 
 */
public class OrderBizImpl implements OrderBiz{
	
	TicketOrderDAO dao = new TicketOrderDAOImpl();
	
	@Override
	public List<TicketOrder01> findMyOrders(
			Long orderId, 
			Date orderDate1,
			Date orderDate2, 
			String orderState, 
			String fromCity,
			String toCity , 
			int userId) 
			throws SQLException {
		
		List<Object[]> list = dao.findMyOrders(
									orderId, 
									orderDate1, 
									orderDate2, 
									orderState,  
									fromCity, 
									toCity , 
									userId);
		
		List<TicketOrder01> list1 = new ArrayList<TicketOrder01>();
		
		for(Object[] oo : list){
			TicketOrder01 t = new TicketOrder01();
			t.setOrderId(Long.parseLong(oo[0].toString()));			//private long orderId;			//订单号
			t.setFlightNum(oo[1].toString());						//private String flightNum;		//航班编号
			t.setFlDate(oo[2].toString());							//private String flDate;		//航班日期
			t.setFlTime(oo[3].toString());							//private String flTime;		//起飞时间
			t.setTotalPrice(Double.parseDouble(oo[4].toString()));	//private double totalPrice;	//订单总额(机票价格+燃油税+机场建设税)
			t.setOrderState(oo[5].toString());						//private String orderState;	//订单状态
			t.setOrderDate(DateUtil.parse(oo[6].toString()));		//private Date orderDate;		//订票时间
			
			list1.add(t);
		}
		
		return list1;
	}
}
