package otcyan.java.model;

import java.util.Vector;

import otcyan.java.bean.Bank;
import otcyan.java.bean.FlightAddr;
import otcyan.java.bean.FlightInfo;
import otcyan.java.bean.Seat;
import otcyan.java.bean.User;
import otcyan.java.dao.DbHandle;

public class DataHandle {
	
	DbHandle dbHandle = null ;
	
	public DataHandle(){
		dbHandle = new DbHandle() ;
	}
	
	/**
	 * ��ѯһ�������ص�queryOneFlightAddr
	 */
	public FlightAddr queryOneFlightAddr(String sql,String[] paras){
		System.out.println("ssss:"+paras[0]);
		return dbHandle.queryOneFlightAddr(sql, paras) ;
	}
	
	/**
	 * ͨ������id��ѯ�ɻ���Ϣ
	 */
	public FlightInfo queryFlightById(String sql,String[] paras ,FlightAddr startAddr,FlightAddr endAddr){
		
		return dbHandle.queryFlightById(sql, paras, startAddr, endAddr) ;
	}
	
	/**
	 * ͨ��id��ѯ��λ
	 */
	public Vector<Seat> querySeatById(String sql, String[] paras,FlightInfo fInfo , FlightAddr fAddr){
		
		return dbHandle.querySeatById(sql, paras, fInfo, fAddr) ;
	}
	

	public boolean update(String sql , String[] paras){

		return dbHandle.update(sql, paras) ;
	}
	/**
	 * ����booleanֵ ��֤�ɹ�����boolean
	 * 
	 * sql ���ǲ�ѯ���  paras�ǲ�ѯ����  items�ǵ�¼�ж�����
	 * @return
	 */
	public User getUser(String sql,String[] paras){
		return (User) dbHandle.loginQuery(sql, paras) ;
	}
	/**
	 * ��ѯ���� ���� ��������˾ 
	 *
	 */
	public Vector<String> queryAllInfo(String sql,String[]paras){
		Vector<String> vv = new Vector<String>() ;
		vv.add("-------��ѡ��-------") ;
		//ȥ���ظ���
		Vector<String> v = this.queryStringVector(sql, paras) ;
		//ȥ����������� 
		for(String s : v ){
			if(!vv.contains(s)){
				//û����� ��˾
				vv.add(s) ;
			}
		}
		return vv ;
	}
	/**
	 * ������� �ĺ���ص� ��id��
	 * @param sql
	 * @param paras
	 * @return
	 */
	public Vector<FlightAddr> quertyMulInfo(String sql,String[] paras){
		return dbHandle.queryMulInfo(sql, paras) ;
	}
	public Bank queryOneBank(String sql , String[] paras ,User user){
		
		return dbHandle.queryOneBank(sql, paras, user) ;
	}
	/**
	 * 
	 * @param startCityIds ���� �������е�FlightAddr
	 * @param endCityIds ���� ������е�FlightAddr
	 * @param str  ����ĳ��ʱ�� �εĶ���ʱ��
	 * @return
	 */
	public Vector<FlightInfo> queryMulFlightInfo(Vector<FlightAddr> startCityIds , Vector<FlightAddr> endCityIds,String[] str){
		
		//��� �� ��㵽 Ŀ�ĵصĻ������ص� ������ô �ͼ��뵽vector��
		Vector<FlightInfo> vector = new Vector<FlightInfo>() ;
		String sql = (str.length==1?"select * from flight_info where f_start=? and f_end=?":"select * from flight_info where f_start=? and f_end=? and f_start_time>=? and f_start_time<=?") ;
		//��ʼ�ص�
		for (FlightAddr startCityId : startCityIds) {
			for (FlightAddr endCityId : endCityIds) {
				//�����ݿ��в���
				FlightInfo fInfo = dbHandle.queryFlightInfo(sql, startCityId, endCityId,str) ;
				if(fInfo!=null){
					//��ʾ ���������
					vector.add(fInfo) ;
				}
			}
		}
		
		return vector ;
	}
	
	public Vector<Seat> querySeatsInfo(String sql,String[] paras,FlightInfo fInfo){
		
		Vector<Seat> seats = dbHandle.querySeat(sql, paras,fInfo) ;
		return seats ;
	}
	
	public Vector<String> queryStringVector(String sql , String[] paras ){
		
		return dbHandle.queryStringVector(sql, paras) ;
	}
	
	public String queryOneString(String sql,String[] paras){
		return dbHandle.queryOneString(sql, paras) ;
	}
	
	
}
