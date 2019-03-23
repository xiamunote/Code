package com.tarena.tts.abs.action;

import java.util.Date;
import java.util.List;
import com.tarena.tts.abs.biz.FlightBiz;
import com.tarena.tts.abs.biz.impl.FlightBizImpl;
import com.tarena.tts.abs.vo.Flight01;
import com.tarena.tts.abs.util.DateUtil;

/**
 * @ file_name Flight01Action.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 27, 201210:20:16 AM
 * @ description
 * @ reviewed_by 
 */
public class FlightAction extends BaseAction{
	
	private FlightBiz fbiz = new FlightBizImpl();
	//input
	private String startAirport;
	private String endAirport;
	private String startDate;
	private String flightId;
	//output
	private List<Flight01> flight01_list;

	private String fromAirportFullName;
	private String toAirportFullName;
	//set&get
	public String getStartAirport() {
		return startAirport;}
	public void setStartAirport(String startAirport) {
		this.startAirport = startAirport;}
	public String getEndAirport() {
		return endAirport;}
	public void setEndAirport(String endAirport) {
		this.endAirport = endAirport;}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFromAirportFullName() {
		return fromAirportFullName;
	}
	public void setFromAirportFullName(String fromAirportFullName) {
		this.fromAirportFullName = fromAirportFullName;
	}
	public String getToAirportFullName() {
		return toAirportFullName;
	}
	public void setToAirportFullName(String toAirportFullName) {
		this.toAirportFullName = toAirportFullName;
	}
	/**
	 * 起飞时间(注意格式为：yyyy-MM-dd HH:mm:ss)
	 * @ String getStartDate(Flight01Action)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 27, 20122:52:42 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getStartDate() {
		return startDate;}
	
	/**
	 * 起飞时间(注意格式为：yyyy-MM-dd HH:mm:ss)
	 * @ void setStartDate(Flight01Action)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 27, 20122:53:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;}
	public List<Flight01> getFlight01_list() {
		return flight01_list;}
	public void setFlight01_list(List<Flight01> flight01_list) {
		this.flight01_list = flight01_list;}

	/**
	 * 查询出起飞日期startDate当日所有的航班
	 * @ List<Flight01> findAll(Flight01Action)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 27, 201211:35:09 AM
	 * @ description 
	 * @ reviewed_by
	 */
	public String execute() throws Exception{
		
		// TODO  增加业务，如果用户查询当日航班，从当前服务器端系统时间开始
		
		//起飞日期(日期格式为yyyy-MM-dd HH:mm:ss)
		Date dstartDate = null;
		Date dstartDate01 = null;
		
		System.out.println(startDate);	//从页面传入的是空字符串，而非null
		
		if(!"".equals(startDate)){
			dstartDate = DateUtil.parse(startDate+" 00:00:00");
			//起飞日期当日结束时间
			dstartDate01 =new Date(dstartDate.getTime()+1*24*3600*1000);
		}
		
		flight01_list = fbiz.findFlight01(
				startAirport, endAirport, dstartDate, dstartDate01);
		if (flight01_list.size() != 0) {
			fromAirportFullName = flight01_list.get(0).getFromAirportFullName();
			toAirportFullName = flight01_list.get(0).getToAirportFullName();
		}
		
		return "success";
	}
	
	public String getFlight() throws Exception {
		System.out.println("flightId=" + flightId);
		flight01_list = fbiz.findFlightDetail(flightId);
		if (flight01_list.size() != 0) {
			fromAirportFullName = flight01_list.get(0).getFromAirportFullName();
			toAirportFullName = flight01_list.get(0).getToAirportFullName();
		}
		return "success";
	}
}	
