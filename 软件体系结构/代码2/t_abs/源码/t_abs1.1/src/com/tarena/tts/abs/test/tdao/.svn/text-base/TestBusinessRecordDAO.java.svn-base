package com.tarena.tts.abs.test.tdao;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.BusinessRecordDAO;
import com.tarena.tts.abs.dao.impl.BusinessRecordDAOImpl;
import com.tarena.tts.abs.entity.BusinessRecord;

public class TestBusinessRecordDAO {
	
//	@Test
	public void delete() throws Exception{
		BusinessRecordDAO dao = new BusinessRecordDAOImpl();
		BusinessRecord br = dao.findById(1001L);
		dao.delete(br);
	}
	
//	@Test
	public void findAll() throws Exception{
		BusinessRecordDAO dao = new BusinessRecordDAOImpl();
		List<BusinessRecord> list = dao.findAll();
		for(BusinessRecord br : list){
			System.out.println(br.getBusRecId());
		}
	}
	
//	@Test
	public void save() throws Exception{
		BusinessRecordDAO dao = new BusinessRecordDAOImpl();
		BusinessRecord br = new BusinessRecord();
		br.setBusRecId(1001L);
		br.setBusRecType("C");
		br.setBusRecDate(new Date());
		br.setBusRecMoney(11.11);
		br.setRefUser(3);
		br.setRefTicketId(1001L);
		br.setRecState(3);
		br.setTerminalType("111");
		br.setTerminalIp("111");
		
		dao.save(br);
	}
	
	@Test
	public void update() throws Exception{
		BusinessRecordDAO dao = new BusinessRecordDAOImpl();
		BusinessRecord br = dao.findById(1001L);
		br.setBusRecMoney(99999999999999L);
		dao.update(br);
	}
}
