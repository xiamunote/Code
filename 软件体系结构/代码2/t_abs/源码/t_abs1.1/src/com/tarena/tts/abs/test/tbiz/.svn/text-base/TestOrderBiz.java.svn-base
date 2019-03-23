package com.tarena.tts.abs.test.tbiz;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.biz.impl.OrderBizImpl;
import com.tarena.tts.abs.biz.OrderBiz;
import com.tarena.tts.abs.vo.TicketOrder01;

/**
 * @ file_name TestOrderBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 24, 20126:11:09 PM
 * @ description
 * @ reviewed_by 
 */
public class TestOrderBiz {
	
	@Test
	public void findMyOrder() throws Exception{
		OrderBiz biz = new OrderBizImpl();
		List<TicketOrder01> list = 
			biz.findMyOrders(null, null, null, null, null, null ,1);
		
		for(TicketOrder01 t : list){
			System.out.println(t);
		}
		
	}
}
