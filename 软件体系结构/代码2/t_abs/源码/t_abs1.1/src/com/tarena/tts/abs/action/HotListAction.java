package com.tarena.tts.abs.action;

import java.util.List;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.vo.Flight02;

/**
 * 查询出 推荐航线
 * @ file_name Flight02Action.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 3, 20122:43:28 PM
 * @ description
 * @ reviewed_by 
 */
public class HotListAction extends BaseAction{
	
	private FlightBiz fbiz = new FlightBizImpl();
	
	//output
	private List<Flight02> hots;
	
	public List<Flight02> getHots() {
		return hots;}
	public void setHots(List<Flight02> hots) {
		this.hots = hots;}

	@Override
	public String execute() throws Exception {
		hots = fbiz.findHotFlight();		
		return "success";
	}
}
