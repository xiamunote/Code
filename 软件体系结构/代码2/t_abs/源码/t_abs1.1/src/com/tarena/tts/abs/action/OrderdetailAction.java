package com.tarena.tts.abs.action;

import java.util.ArrayList;
import java.util.List;
import com.tarena.tts.abs.biz.OrderdetailBiz;
import com.tarena.tts.abs.biz.impl.OrderdetailBizImpl;
import com.tarena.tts.abs.entity.Orderdetail;
import com.tarena.tts.abs.vo.Orderdetail02;

public class OrderdetailAction extends BaseAction {
	private static final long serialVersionUID = 8234957537269067720L;
	
	//input
	private Long orderId;
	
	//output
	private List<Orderdetail> orderList = new ArrayList<Orderdetail>();
	private Orderdetail02 orderdetail02;
	
	public Orderdetail02 getOrderdetail02() {
		return orderdetail02;
	}
	public void setOrderdetail02(Orderdetail02 orderdetail02) {
		this.orderdetail02 = orderdetail02;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<Orderdetail> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orderdetail> orderList) {
		this.orderList = orderList;
	}
	
	@Override
	public String execute() throws Exception {
		OrderdetailBiz orderdetailBiz = new OrderdetailBizImpl(); 
		orderList = orderdetailBiz.getOrderView(orderId);
		orderdetail02 = orderdetailBiz.getTicketOrder(orderId);
		return super.execute();
	}
}
