package com.tarena.tts.abs.action;

import java.util.List;
import com.tarena.tts.abs.action.BaseAction;
import com.tarena.tts.abs.biz.CityBiz;
import com.tarena.tts.abs.biz.impl.CityBizImpl;
import com.tarena.tts.abs.entity.City;

public class CityAction extends BaseAction {
	private static final long serialVersionUID = -3257787994223197085L;
	
	//input
	private int page = 1;
	private int rowsPerPage = 10;
	//output
	private List<City> cityList;
	
	
	public int getPage() {return page;}
	public void setPage(int page) {this.page = page;}
	public int getRowsPerPage() {
		return rowsPerPage;}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;}
	public List<City> getCityList() {return cityList;}
	public void setCityList(List<City> cityList) {this.cityList = cityList;}
	
	@Override
	public String execute() throws Exception {
		CityBiz citybiz = new CityBizImpl();
		cityList = citybiz.getCityList(page , rowsPerPage);
		return SUCCESS;
	}
}
