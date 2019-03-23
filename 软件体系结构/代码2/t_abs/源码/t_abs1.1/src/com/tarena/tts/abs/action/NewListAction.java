package com.tarena.tts.abs.action;

import java.util.List;

import com.tarena.tts.abs.dao.InformationDAO;
import com.tarena.tts.abs.dao.impl.InformationDAOImpl;
import com.tarena.tts.abs.entity.Information;

/**
 * @ file_name NewListAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 3, 20123:47:46 PM
 * @ description
 * @ reviewed_by 
 */
public class NewListAction extends BaseAction {
	private List<Information> news;
	
	private int newsNum = 8;
	
	public String execute(){
		InformationDAO informationDAO = new InformationDAOImpl();
		news = informationDAO.findNewInfo(newsNum);	//查找到最新的8条数据
		return "success";
	}
	
	public List<Information> getNews() {
		return news;
	}

	public void setNews(List<Information> news) {
		this.news = news;
	}


}
