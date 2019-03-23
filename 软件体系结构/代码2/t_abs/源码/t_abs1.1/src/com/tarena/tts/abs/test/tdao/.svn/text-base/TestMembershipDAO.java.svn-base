package com.tarena.tts.abs.test.tdao;


import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.tarena.tts.abs.dao.MembershipDAO;
import com.tarena.tts.abs.dao.impl.MembershipDAOImpl;
import com.tarena.tts.abs.entity.Membership;
import com.tarena.tts.abs.util.SecurityUtil;

public class TestMembershipDAO {
	
//	@Test
	public void delete() throws Exception{
		MembershipDAO dao = new MembershipDAOImpl();
		Membership m = dao.findById(1);
		System.out.println(m.getMembFirstnameCh());
		dao.delete(m);
	}
	
//	@Test
	public void findAll() throws Exception{
		MembershipDAO dao = new MembershipDAOImpl();
		List<Membership> list = dao.findAll();
		for(Membership m : list){
			System.out.println(m.getMembFirstnameCh());
		}
	}

//	@Test
	public void save() throws Exception{
		Membership m = new Membership();
		m.setMembCardNum("TL00000002");
		m.setMembPassword(SecurityUtil.md5("1234"));
		m.setMembLastnameCh("李");
		m.setMembFirstnameCh("翊");
		m.setMembLastnameSp("LI");
		m.setMembFirstnameSp("YI");
		m.setMembGender("M");
		m.setMembBirthday(new Date());
		m.setMembCertifType("身份证");
		m.setMembCertifNum("151921198001010001");
		m.setMembTelephone1("13888888888");
		m.setMembAddress("海淀区，北三环西路甲18号中鼎大厦B座7层");
		m.setMembRegDate(new Date());
		m.setMembEmail("bjliyi@tarena.com.cn");
		m.setMembRank("普卡会员");
		
		MembershipDAO dao = new MembershipDAOImpl();
		dao.save(m);
	}
	
	@Test
	public void update() throws Exception{
		MembershipDAO dao = new MembershipDAOImpl(); 
		Membership m = dao.findById(7);
		m.setMembAddress("海淀区，西直门外大街137号");
		
		dao.update(m);
	}
}
