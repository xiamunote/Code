package com.tarena.tts.abs.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.biz.SubmitorderBiz;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.biz.impl.PassengerBizImpl;
import com.tarena.tts.abs.biz.impl.SubmitorderBizImpl;
import com.tarena.tts.abs.dao.TicketDAO;
import com.tarena.tts.abs.dao.TicketOrderDAO;
import com.tarena.tts.abs.dao.impl.TicketDAOImpl;
import com.tarena.tts.abs.dao.impl.TicketOrderDAOImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.entity.Ticket;
import com.tarena.tts.abs.entity.TicketOrder;
import com.tarena.tts.abs.entity.User;
import com.tarena.tts.abs.util.DateUtil;
import com.tarena.tts.abs.vo.Flight01;

/**
 * @ file_name SubmitorderAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 30, 20129:29:09 AM
 * @ description
 * @ reviewed_by 
 */
public class SubmitorderAction extends BaseAction{
	
	//input
	private List<Passenger> listAdult ;
	private List<Passenger> listChild ;
	private List<Passenger> listInfaint ;
	private String fid ;
	
	//output
	private Flight01 fl;
	private double orderMoney;	//订单总价
	private String cabinClass;	//舱位
	private long orderId;//订单号
	
	
	@Override
	public String execute() throws Exception {
		
		//获得登录用户信息
		User user  = (User)session.get("user");	

		try{
		//2 通过页面传入的fid查询航班信息显示到页面
		FlightBiz fbiz = new FlightBizImpl();
		fl = fbiz.findFlById(fid);
		
		//3 生成订单ticket_order和机票ticket
		//3.1 生成订单(插入数据库ticket_order表中)
		
		//3.1.1 构建TicketOrder对象
		TicketOrder order = new TicketOrder();
		orderId = new Date().getTime();//订单编号的规则:当前系统时间
		order.setOrderId(orderId);	
		order.setUserId(user.getUserId());
		order.setOrderMoney(orderMoney);
		order.setOrderDate(new Date());
		/*订单状态 
		‘等待支付（E）’，
		‘取消（C）’，
		‘失效（D）’，
		‘已支付（P）’*/
		order.setOrderState("E");	//此处已写死，一律是"等待支付"状态
		order.setFlightId(fid);
		order.setCabinClass(cabinClass);
		
		//3.1.2 插入数据
		TicketOrderDAO todao = new TicketOrderDAOImpl();
		todao.save(order);
		
		//3.2 根据Passenger人数循环生成机票(插入数据库ticket_order表中)	
		//3.2.1 为Passenger(成年人)生成机票Ticket
		saveTicket(listAdult, order);
		saveTicket(listChild, order);
		saveTicket(listInfaint, order);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "success";
	}

	private void saveTicket(List<Passenger> list, TicketOrder order) throws Exception {
		if(list != null){
			TicketDAO tdao = new TicketDAOImpl();
			for(Passenger p : list){
				//3.2.1.1 构建Ticket对象
				Ticket t = new Ticket();
				t.setOrderId(order.getOrderId());
				t.setFlightNum(fl.getFlightNum());
				t.setRouteId(fl.getRouteId());
				
				t.setDepartureDatetime(
						getDepartureTimeMethod());
				t.setArrivalDatatime(
						getArrivalTimeMethod());
				setThePsgId(t, p);
				String tid = 
					System.currentTimeMillis()+""+p.getPsgId();
				t.setTicketId(Long.valueOf(tid));
				setTheCabinClass(t, order.getCabinClass());

				t.setTicketDate(order.getOrderDate());
				t.setTicketPrice(fl.getPrice());
				t.setTax1Price(fl.getTax1Price());
				t.setTax2Price(fl.getTax2Price());
				t.setTotalPrice(order.getOrderMoney());
				
				//TOLO航班小个儿左前，大个儿坐后
				t.setSeatsOrder(0);

				//3.2.1.2 插入数据
				System.out.println("----"+t.getTicketId());
				tdao.save(t);
			}
		}
	}

	private void setThePsgId(Ticket t, Passenger p) throws SQLException {
		if (p.getPsgId() != null) {
			t.setPsgId(p.getPsgId());
		} else {
			PassengerBiz passengerBiz = new PassengerBizImpl();
			//获得登录用户信息
			User user  = (User)session.get("user");	
			p.setRefUserId(user.getUserId());
			passengerBiz.saveOrUpdatePassenger(p);
			t.setPsgId(p.getPsgId());
		}
	}


	private void setTheCabinClass(Ticket t, String cabinClass2) {
		if (cabinClass.equals("头等舱")) {
			t.setCabinClass("F");
		} else if (cabinClass.equals("公务舱")) {
			t.setCabinClass("C");
		} else {
			t.setCabinClass("Y");
		}
	}

	private Date getArrivalTimeMethod() {
		String time  = fl.getFlArrivalTime();
		String date = fl.getFlDate();	
		return DateUtil.parse(date + " " + time + ":00");
	}


	private Date getDepartureTimeMethod() {
		String time  = fl.getFlDepartureTime();
		String date = fl.getFlDate();
		return DateUtil.parse(date + " " + time + ":00");
	}


	public List<Passenger> getListAdult() {
		return listAdult;
	}
	public void setListAdult(List<Passenger> listAdult) {
		this.listAdult = listAdult;
	}
	public List<Passenger> getListChild() {
		return listChild;
	}
	public void setListChild(List<Passenger> listChild) {
		this.listChild = listChild;
	}
	public List<Passenger> getListInfaint() {
		return listInfaint;
	}
	public void setListInfaint(List<Passenger> listInfaint) {
		this.listInfaint = listInfaint;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public Flight01 getFl() {
		return fl;
	}
	public void setFl(Flight01 fl) {
		this.fl = fl;
	}
	public double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getCabinClass() {
		return cabinClass;
	}
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
}
