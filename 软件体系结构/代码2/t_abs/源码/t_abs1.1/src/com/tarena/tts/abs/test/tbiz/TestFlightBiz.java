package com.tarena.tts.abs.test.tbiz;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.vo.Flight01;
import com.tarena.tts.abs.vo.Flight02;

/**
 * @ file_name TestFlightBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 26, 20126:07:18 PM
 * @ description
 * @ reviewed_by 
 */
public class TestFlightBiz {
	
	@Test
	public void findFlight01() throws Exception{
		FlightBiz fb = new FlightBizImpl();
		List<Flight01> list = 
			fb.findFlight01("北京", "上海", null, null);
		for(Flight01 f01 : list){
			System.out.println(f01);
		}
	}
	
	@Test
	public void findHotFlight() throws Exception{
		FlightBiz fb = new FlightBizImpl();
		List<Flight02> list = fb.findHotFlight();
		
		for(Flight02 f : list){
			System.out.println(f.getFlDate() + " " + f.getFromCity());
		}
	}
	
	@Test
	public void findFlight01_() throws Exception{
		FlightBiz fb = new FlightBizImpl();
		List<Flight01> list = fb.findFlight01();
		
		for(Flight01 f : list){
			System.out.println(f);
		}
	}
	
	@Test
	public void findFlById() throws Exception{
		FlightBiz fb = new FlightBizImpl();
		Flight01 f =  fb.findFlById("N201010251201");
		System.out.println(f);
	}
	
	@Test
	public void tfindFlightDetail() throws Exception{
		FlightBiz fb = new FlightBizImpl();
		List<Flight01> list =  
			fb.findFlightDetail("N201010251201");
		
		for(Flight01 f : list){
			System.out.println(f);
		}
	}
}
