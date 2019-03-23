package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import java.util.List;

import com.tarena.tts.abs.dao.InformationDAO;
import com.tarena.tts.abs.dao.impl.InformationDAOImpl;
import com.tarena.tts.abs.entity.Information;
import org.junit.Test;

/**
 * @ file_name TestInformationDAO.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Apr 20, 201210:58:14 AM
 * @ description
 * @ reviewed_by 
 */
public class TestInformationDAO {
	
//	@Test
	public void t_delete() throws Exception{
		InformationDAO dao = new InformationDAOImpl();
		Information info = dao.findById(1);
		dao.delete(info);
	}
	
//	@Test
	public void t_findAll() throws Exception{
		InformationDAO dao = new InformationDAOImpl();
		List<Information> list = dao.findAll();
		
		for(Information info : list){
			System.out.println(info);
		}
	}
	
//	@Test
	public void t_save() throws Exception{
		InformationDAO dao = new InformationDAOImpl();
		
		Information info = new Information();
		info.setInfoTitle("最新的");
		info.setInfoContent("E1线");
		info.setInfoTime(new Date());
		info.setInfoTop("Y");
		
		dao.save(info);
	}
	
//	@Test
	public void t_update() throws Exception{
		InformationDAO dao = new InformationDAOImpl();
		
		Information info = dao.findById(2);
		info.setInfoTitle("风动草");
		dao.update(info);
	}
	
	/**
	 * 查询出最新资讯（按照资讯日期查询，同时将置顶资讯放在最前）
	 * @ void t_findNewInfo(TestInformationDAO)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 20, 201211:50:03 AM
	 * @ description 
	 * @ reviewed_by
	 */
	@Test
	public void t_findNewInfo() throws Exception{
		InformationDAO dao = new InformationDAOImpl();
		List<Information> list = dao.findNewInfo(4);
		
		for(Information info : list){
			System.out.println(info);
		}
		
	}
}
