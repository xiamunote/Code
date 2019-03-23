package com.tarena.tts.abs.action;

import java.util.List;
import com.tarena.tts.abs.biz.BranchBiz;
import com.tarena.tts.abs.biz.impl.BranchBizImpl;
import com.tarena.tts.abs.vo.Branch01;

/**
 * @ file_name BranchAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20122:45:13 PM
 * @ description
 * @ reviewed_by 
 */
public class BranchAction extends BaseAction{
	
	//output
	private List<Branch01> branchList;
	
	@Override
	public String execute() throws Exception {
		
		BranchBiz biz = new BranchBizImpl();
		branchList = biz.findBranch();
		
		return "success";
	}

	public List<Branch01> getBranchList() {
		return branchList;
	}
	public void setBranchList(List<Branch01> branchList) {
		this.branchList = branchList;
	}
}
