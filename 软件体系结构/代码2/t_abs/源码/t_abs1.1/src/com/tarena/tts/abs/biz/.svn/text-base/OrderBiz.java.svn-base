package com.tarena.tts.abs.biz;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.tarena.tts.abs.vo.TicketOrder01;

/**
 * @ file_name OrderBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 24, 20125:46:04 PM
 * @ description
 * @ reviewed_by 
 */
public interface OrderBiz {
	
	/**
	 * 查询订单，查询的结果封装为TicketOrder01
	 * @ List<TicketOrder01> findMyOrders(OrderBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 24, 20125:48:22 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public List<TicketOrder01> findMyOrders(
			Long orderId, 
			Date orderDate1,
			Date orderDate2, 
			String orderState, 
			String fromCity,
			String toCity , 
			int userId)throws SQLException;
	
}
