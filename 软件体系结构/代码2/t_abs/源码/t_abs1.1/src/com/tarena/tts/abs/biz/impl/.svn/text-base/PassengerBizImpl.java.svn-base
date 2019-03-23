package com.tarena.tts.abs.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.biz.PassengerBiz;
import com.tarena.tts.abs.dao.PassengerDAO;
import com.tarena.tts.abs.dao.impl.PassengerDAOImpl;
import com.tarena.tts.abs.entity.Passenger;
import com.tarena.tts.abs.util.ChangeTypeUtil;

public class PassengerBizImpl implements PassengerBiz {
	PassengerDAO passengerDao = new PassengerDAOImpl();
	
	@Override
	public List<Passenger> getPassengersByLoginUser(int userId,int page,int size) throws SQLException {
		int begin = (page-1)*size;
		
		List<Passenger> list = 
			passengerDao.findByUserId(userId,begin,size);
		
		for(Passenger p : list){
			
			//将psg_type中的字符转换为汉字
			p.setPsgType(ChangeTypeUtil.changePsgTypeToWord(
					p.getPsgType()));
			
			//将psg_certify_type中的字符转换为汉字
			p.setPsgCertifType(
					ChangeTypeUtil.changeUserCertifTypeToWord(
							p.getPsgCertifType()));
		}
		
		return list;
	}

	@Override
	public void saveOrUpdatePassenger(Passenger passenger) throws SQLException {
		if(passenger.getPsgId() == null){
			passengerDao.save(passenger);
		}else{
			passengerDao.update(passenger);
		}
		
	}

	@Override
	public void deletePassenger(int id) throws SQLException {
		passengerDao.deleteById(id);
	}

	

	@Override
	public Passenger getPassengerById(int id) throws SQLException {
		return passengerDao.findById(id);
	}

	@Override
	public int countTotalPage(int userId, int pageSize) throws SQLException {
		int totalSize = passengerDao.countByUserId(userId);
		if(totalSize == 0){
			return 1;
		}else if(totalSize%pageSize == 0){
			return totalSize/pageSize;
		}else{
			return totalSize/pageSize+1;
		}
	}
	
	
	@Override
	public List<Passenger> getPassengersByLoginUser(Integer userId) {
		return passengerDao.findByUserId(userId);
	}

	@Override
	public Passenger findPassengerByName(Passenger p) {
		return passengerDao.findPassengerByName(p);
	}
	
}
