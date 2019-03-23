package com.tarena.tts.abs.action;

import java.util.List;

import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.vo.Flight01;

/**
 * @ file_name Flight02Action.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 23, 201211:23:34 AM
 * @ description
 * @ reviewed_by 
 */
public class FlightAllAction extends BaseAction{
	
	//output
	private List<Flight01> Flight01List ;
	
	
	@Override
	public String execute() throws Exception {
		FlightBiz biz = new FlightBizImpl();
		
		Flight01List = biz.findFlight01();
		
		return "success";
	}

	public List<Flight01> getFlight01List() {
		return Flight01List;
	}
	public void setFlight01List(List<Flight01> flight01List) {
		Flight01List = flight01List;
	}
}
