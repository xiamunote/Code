package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.biz.SubmitorderBiz;
import com.tarena.tts.abs.dao.PassengerDAO;
import com.tarena.tts.abs.dao.impl.PassengerDAOImpl;
import com.tarena.tts.abs.entity.Passenger;

/**
 * @ file_name SubmitorderBizImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 30, 20129:42:35 AM
 * @ description
 * @ reviewed_by 
 */
public class SubmitorderBizImpl implements SubmitorderBiz {

	@Override
	public void savePassenger(Passenger p) throws SQLException {
		
		PassengerDAO dao = new PassengerDAOImpl();
		
		dao.save(p);
	}
}
