package com.tarena.tts.abs.test.tdao;

import java.util.List;

import org.junit.Test;

import com.tarena.tts.abs.dao.BranchDAO;
import com.tarena.tts.abs.dao.impl.BranchDAOImpl;
import com.tarena.tts.abs.entity.Branch;

public class TestBranchDAO {
	
//	@Test
	public void delete() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		
		Branch b = dao.findById(1);
		System.out.println(b);
		dao.delete(b);
	}
	
//	@Test
	public void findAll() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		List<Branch> list = dao.findAll();
		for(Branch b : list){
			System.out.println(b.getBranchName());
		}
	}
	
//	@Test
	public void save() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		Branch b = new Branch();
		b.setBranchName("月营业厅");
		b.setProvinceId(3);
		b.setCityId(3);
		b.setBranchTelephone1("5555555");
		b.setBranchFax("5555555");
		b.setBranchAddress("那个山沟里");
		b.setBranchType("Z");
		b.setBranchState("O");
		dao.save(b);
	}
	
//	@Test
	public void update() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		Branch b = dao.findById(43);
		b.setBranchAddress("还在山沟里");
		b.setBranchType("Z");
		b.setBranchState("O");
		dao.update(b);
	}
	
//	@Test
	public void findByProvinceId() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		List<Branch> list= dao.findByProvinceId(1);
		
		for(Branch b : list){
			System.out.println(b);
		}
	}
	
//	@Test
	public void findByCityId() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		List<Branch> list= dao.findByCityId(1);
		for(Branch b : list){
			System.out.println(b);
		}
	}
	
	@Test
	public void findByName() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		List<Branch> list= dao.findByName("石家庄营业部");
		for(Branch b : list){
			System.out.println(b);
		}
	}
	
	@Test
	public void findBranch() throws Exception{
		BranchDAO dao = new BranchDAOImpl();
		List<Object[]> list= dao.findBranch();
		
		for(Object[] o : list){
			System.out.println(o[0] + " " + 
					o[1] + " " + 
					o[2] + " " + 
					o[3] + " " +
					o[4]);
		}
	}
}


