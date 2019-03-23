package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.tts.abs.biz.BranchBiz;
import com.tarena.tts.abs.dao.BranchDAO;
import com.tarena.tts.abs.dao.impl.BranchDAOImpl;
import com.tarena.tts.abs.entity.Branch;
import com.tarena.tts.abs.vo.Branch01;

/**
 * @ file_name BranchBizImpl.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20122:50:07 PM
 * @ description
 * @ reviewed_by 
 */
public class BranchBizImpl implements BranchBiz{
	private BranchDAO dao = new BranchDAOImpl();
	
	public List<Branch01>  findBranch() throws SQLException{
		List<Object[]> list = dao.findBranch();
		List<Branch01> list1 = new ArrayList<Branch01>();
		
		for(Object[] o : list){
			Branch01 b = new Branch01();
			b.setBranchId(Integer.parseInt(o[0].toString()));
			b.setBranchName(o[1].toString());
			b.setCity(o[2].toString());
			b.setBranchAddress(o[3].toString());
			b.setBranchTelephone1(o[4].toString());
			list1.add(b);
		}
		
		return list1;
	}
}
