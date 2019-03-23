package com.tarena.tts.abs.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.entity.TicketOrder;

/**
 * 机票订单操作的DAO组件
 * @author Administrator
 *
 */
public interface TicketOrderDAO {

	public void update(TicketOrder ticketOrder) throws SQLException;

	public void save(TicketOrder ticketOrder) throws SQLException;
	
	public void delete(TicketOrder ticketOrder) throws SQLException;
	
	public TicketOrder findById(long id) throws SQLException;
	
	public List<TicketOrder> findAll() throws SQLException;
	
	/**
	 * 通过乘客信息查找机票订单
	 * @ List<TickerOrder> findByPassenger(TicketOrderDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20125:24:49 PM
	 * @ description 
	 * @param passengerName 旅客姓名
	 * @ reviewed_by
	 */
	public List<TicketOrder> findByPassenger(String passengerName)
	throws Exception;
	
	/**
	 * 通过id更新机票订单
	 * @ void updateOrderState(TicketOrderDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 17, 20126:40:33 PM
	 * @ description
	 * @param orderState 订单状态
	 * @param id 订单ID
	 * @ reviewed_by
	 */
	public void updateOrderState(
			String orderState,long id)throws Exception;
	
	/**
	 * 通过联合条件查询出订单，用于"我的订单"模块
	 * @ List<Object[]> findMyOrders(TicketOrderDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 24, 20123:01:03 PM
	 * @ description 
	 * 	orderId 订单号
	 *  OrderDate1 订单日期
	 *  OrderDate2 订单日期
	 *  orderState 订单状态
	 *  fromCity 出发城市
	 *  toCity 到达城市
	 * @ reviewed_by
	 */
	public List<Object[]> findMyOrders(
			Long orderId , 
			Date orderDate1 ,
			Date orderDate2 , 
			String orderState , 
			String fromCity ,
			String toCity , 
			int userId) throws SQLException;
}
