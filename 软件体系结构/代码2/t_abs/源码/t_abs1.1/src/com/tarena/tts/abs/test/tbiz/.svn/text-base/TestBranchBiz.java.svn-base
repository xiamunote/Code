package com.tarena.tts.abs.test.tbiz;

import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.biz.BranchBiz;
import com.tarena.tts.abs.biz.impl.BranchBizImpl;
import com.tarena.tts.abs.vo.Branch01;

/**
 * @ file_name TestBranchBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20122:57:29 PM
 * @ description
 * @ reviewed_by 
 */
public class TestBranchBiz {
	
	@Test
	public void testfindBranch() throws Exception{
		BranchBiz biz = new BranchBizImpl();
		List<Branch01> list = biz.findBranch();
		for(Branch01 b : list){
			System.out.println(b.getBranchName());
		}
	}
}
