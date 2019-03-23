package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;

import com.tarena.tts.abs.biz.InfoBiz;
import com.tarena.tts.abs.dao.InformationDAO;
import com.tarena.tts.abs.dao.impl.InformationDAOImpl;
import com.tarena.tts.abs.entity.Information;

/**
 * @ file_name InfoBizImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 28, 201210:57:32 AM
 * @ description
 * @ reviewed_by 
 */
public class InfoBizImpl implements InfoBiz{

	@Override
	public Information findInfoById(int id) throws SQLException {
		
		InformationDAO dao = new InformationDAOImpl();
		
		Information info = dao.findById(id);
		
		return info;
	}
}
