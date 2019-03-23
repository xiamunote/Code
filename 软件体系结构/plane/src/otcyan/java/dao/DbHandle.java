package otcyan.java.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import otcyan.java.bean.Bank;
import otcyan.java.bean.FlightAddr;
import otcyan.java.bean.FlightInfo;
import otcyan.java.bean.Seat;
import otcyan.java.bean.User;
import otcyan.java.tools.DBHelp;
import otcyan.java.view.TicketSearchPanel;

public class DbHandle {
	
	DBHelp dbHelp = null ;
	ResultSet rs = null ;
	
	public DbHandle(){
		dbHelp = new DBHelp() ;
	}
	/**
	 * ��¼ʱ���ݿ�Ĳ�ѯ
	 * @param sql  ��ѯ���ݿ����
	 * @param paras ��ѯ����
	 * @return Object ���ص�����
	 */
	public Object loginQuery(String sql,String[] paras){
		
		rs = dbHelp.query(sql, paras) ;
		User user = null ;
		if(rs==null){
			return null ;
		}
		try {
			if(rs.next()){
				//��������� �Ļ������ʹ���һ��User��
				user = new User(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close() ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			dbHelp.close() ;
		}
		System.out.println(user);
		return user ;
		
	}
	/**
	 * ���ݿ����ɾ��
	 * @param sql
	 * @param paras
	 * @return
	 */
	public boolean update(String sql , String[] paras){

		return dbHelp.update(sql, paras) ;
	}
	
	/**
	 * ��ѯһ�������ص�
	 */
	public FlightAddr queryOneFlightAddr(String sql,String[] paras){
		
		rs = dbHelp.query(sql,paras) ;
		FlightAddr fAddr = null ;
		try {
			if(rs.next()){
				 fAddr = new FlightAddr(rs.getString(1), rs.getString(2), rs.getString(3)) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fAddr ;
	}
	
	/**
	 * ͨ������id��ѯ�ɻ���Ϣ
	 * @param sql
	 * @param paras
	 * @param startAddr
	 * @param endAddr
	 * @return
	 */
	public FlightInfo queryFlightById(String sql,String[] paras ,FlightAddr startAddr,FlightAddr endAddr){
		
		rs = dbHelp.query(sql,paras) ;
		FlightInfo fInfo = null ;
		try {
			if(rs.next()){
				 fInfo = new FlightInfo(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),startAddr,endAddr,rs.getString(7)) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fInfo ;
	}
	
	/**
	 * ͨ��id��ѯ��λ
	 * select * from seat where f_number='CZ3809'
	 * seats.get(0).getfInfo().getf_type();
	 */
	public Vector<Seat> querySeatById(String sql, String[] paras,FlightInfo fInfo , FlightAddr fAddr){
		
		rs = dbHelp.query(sql,paras) ;
		Vector<Seat> seats = new Vector<Seat>() ;
		try {
			while(rs.next()){
				Seat s = new Seat(fInfo, rs.getString(2), rs.getString(3),rs.getDouble(4)) ;
				seats.add(s) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			
		return seats ;
	}

	/**
	 * ��ѯ���� �ĺ���ص�id��
	 * @param sql
	 * @param paras
	 * @return
	 */
	public Vector<FlightAddr> queryMulInfo(String sql,String[] paras){
		rs = dbHelp.query(sql,paras) ;
		Vector<FlightAddr> vector = new Vector<FlightAddr>() ;
		try {
			while(rs.next()){
				System.out.println(rs.getMetaData().getColumnCount() );
				FlightAddr fAddr = new FlightAddr(rs.getString(1), rs.getString(2), rs.getString(3)) ;
				vector.add(fAddr) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vector ;
	}
	
	public Bank queryOneBank(String sql , String[] paras ,User user){
		
		rs = dbHelp.query(sql, paras) ;
		Bank bank= null ;
		if(rs==null){
			return null ;
		}
		try {
			if(rs.next()){
				//��������� �Ļ������ʹ���һ��User��
				bank = new Bank(rs.getInt(1), rs.getString(2), user.getU_name(), user.getU_idcard(), rs.getString(5), rs.getString(6)) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close() ;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			dbHelp.close() ;
		}
		System.out.println(user);
		return bank ;
	}
	/**
	 * ���ݵص�õ� �ɻ���Ϣ
	 * @param sql
	 * @param paras
	 * @return
	 */
	public FlightInfo queryFlightInfo(String sql,FlightAddr startCityId,FlightAddr endCityId,String str[]){
		
		System.out.println(str.length);
		String[] paras = null ;
		paras = (str.length==1?new String[]{startCityId.getA_id(),endCityId.getA_id()}:new String[]{startCityId.getA_id(),endCityId.getA_id(),str[0],str[1]});
		rs = dbHelp.query(sql, paras) ;
		FlightInfo fInfo = null ;
		if(rs==null){
			return null ;
		}
		try {
			if(rs.next()){
				//������   ��ô����һ�� FlightInfo
				fInfo = new FlightInfo(rs.getString(1), rs.getString(2), rs
						.getString(3), rs.getString(4), startCityId, endCityId,
						rs.getString(7));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbHelp.close() ;
		}
		return fInfo;
	}
	/**
	 * �õ� һ����ϸ��λ��Ϣ
	 * @param sql
	 * @param paras
	 * @return
	 */
	public Vector<Seat> querySeat(String sql ,String[] paras ,FlightInfo fInfo){
		
		Vector<Seat> seats = new Vector<Seat>() ;
		rs = dbHelp.query(sql, paras) ;
		//ResultSetMetaData rsmdData = rs.getMetaData() ;
		Vector<String> types = new Vector<String>();//�������
		try {
			while(rs.next()){
					Seat seat = new Seat(fInfo, rs.getString(2), rs.getString(3), rs.getDouble(4)) ;
						types.add(seat.getS_type()) ;
					seats.add(seat) ;
					System.out.println("***********"+seats.size());
			}
			//����û�������յ���� 
			if(seats.size()<3){
				if(types.contains("���ò�")){
					Seat seat = new Seat(fInfo, "���ò�", "--", 0) ;
					seats.add(seat) ;
				}
				if(types.contains("�����")){
					Seat seat = new Seat(fInfo, "�����", "--", 0) ;
					seats.add(seat) ;
				}
				if(types.contains("ͷ�Ȳ�")){
					Seat seat = new Seat(fInfo, "ͷ�Ȳ�", "--", 0) ;
					seats.add(seat) ;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				dbHelp.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seats ;
	}
	/**
	 * ��ѯ���ݼ��Ϸ�������Vector<Stirng>
	 * @param sql
	 * @param paras
	 * @return
	 */
	public Vector<String> queryStringVector(String sql,String[] paras){
		System.out.println(sql);
		System.out.println(paras);
		rs = dbHelp.query(sql,paras) ;
		Vector<String> vector = new Vector<String>() ;
		try {
			while(rs.next()){
				String s = rs.getString(1) ;
				vector.add(s) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vector ;
	}
	
	public String queryOneString(String sql,String[] paras){
		
		rs = dbHelp.query(sql, paras) ;
		
		try {
			if(rs.next()){
				return rs.getString(1) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbHelp.close() ;
		}
		return null ;
	}
	
	public Vector<Vector<String>>  getState(String sql,String[] paras){
		
		//��DB ��
		
		Vector<Vector<String>>  rows=new Vector<Vector<String>>();
//		for(int i=1;i<=2;i++){
//		Vector<String>  row=new Vector<String>();
//		row.add(i+"-"+(i+1));
//		row.add(i+"-"+(i+2));
//		rows.add(row);
//		}
		rs=dbHelp.query(sql,paras);
//		//���и�ֵ
		try {
			while(rs.next()){
				Vector<String> row = new Vector<String>()  ;
				row.add(rs.getString(1)) ;
				row.add(rs.getString(2)) ;
				row.add(rs.getString(3)) ;
				row.add(rs.getString(4)) ;
				row.add(rs.getString(5)) ;
				rows.add(row) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbHelp.close() ;
			
		}
//		try {
//			rows.set=rs.getString(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return rows;
		
		
	} 
}
