package com.tarena.tts.abs.action;

import com.tarena.tts.abs.biz.InfoBiz;
import com.tarena.tts.abs.biz.impl.InfoBizImpl;
import com.tarena.tts.abs.entity.Information;

public class NewDetailAction {
	private Information info;

	public String execute() throws Exception{
		InfoBiz biz = new InfoBizImpl();		
		info = biz.findInfoById(info.getInfoId());
		return "success";
	}
	
	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}
	
}
