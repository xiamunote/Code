package com.tarena.tts.abs.biz;

import java.util.List;

import com.tarena.tts.abs.entity.Orderdetail;
import com.tarena.tts.abs.entity.TicketOrder;
import com.tarena.tts.abs.vo.Orderdetail02;

public interface OrderdetailBiz {

	public List<Orderdetail> getOrderView(Long orderId) throws Exception;

	public Orderdetail02 getTicketOrder(Long orderId) throws Exception;

}
