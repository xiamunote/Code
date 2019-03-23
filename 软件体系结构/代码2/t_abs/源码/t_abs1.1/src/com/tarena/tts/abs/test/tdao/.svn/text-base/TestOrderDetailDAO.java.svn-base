package com.tarena.tts.abs.test.tdao;

import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.OrderdetailDAO;
import com.tarena.tts.abs.dao.impl.OrderdetailDAOImpl;
import com.tarena.tts.abs.entity.Orderdetail;

/**
 * @ file_name TestOrderDetailDAO.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date Jun 4, 20113:49:24 PM
 * @ description
 * @ reviewed_by 
 */
public class TestOrderDetailDAO {
	
	@Test
	public void testfindOrderdetail() throws Exception{
		
		OrderdetailDAO dao = new OrderdetailDAOImpl();
		List<Object[]> list = dao.findOrderdetail(1L);
		
		System.out.println(list.get(0));;
	}
}
