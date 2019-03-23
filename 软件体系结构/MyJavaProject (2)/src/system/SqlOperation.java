package system;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.Passenger;

public class SqlOperation {
	//查找有无该乘客
	public static boolean checkPassenger(String name)
	{
		Connection db = SqlUtil.open();
		String sql = "select * from register where username = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
			while(result.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			SqlUtil.close(db);//关闭数据库连接
		}
		
		return false;
	}
	 //乘客登录信息匹配
	public static boolean login_check(String name,String pwd)
	{
		Connection db = SqlUtil.open();
		String sql = "select * from register where username = ?";//sql语句查找
		PreparedStatement pstmt = null;
		ResultSet result = null;//定义结果集
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();//执行查询，返回结果集
			//当存在记录且用户名密码都相同时才返回登陆匹配
			while(result.next() && result.getString("username").equals(name) && result.getString("password").equals(pwd)) {
				 
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			SqlUtil.close(db);//关闭数据库连接
		}
		
		return false;
	}
	
	
	
	//管理员登录信息匹配
	public static boolean login_check2(String name,String pwd) 
	{
		Connection db = SqlUtil.open();
		String sql = "select * from register2 where username = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
			while(result.next() && result.getString("username").equals(name) && result.getString("password").equals(pwd)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			SqlUtil.close(db);//关闭数据库连接
		}
		
		return false;
	}

	//身份证查找，参数用户手机,登录类别
	public static String IDsearch(String user,String kind) 
	{
		if(kind.equals("passenger"))
		{
			Connection db = SqlUtil.open();
			String sql = "select idcard from register where username = ?";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			try {
				pstmt = db.prepareStatement(sql);
				pstmt.setString(1, user);
				
				result = pstmt.executeQuery();
				while(result.next())
				{
					return result.getString("idcard");
				}
				return null;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				SqlUtil.close(db);//关闭数据库连接
			}
			return null;
		}
	
		return null;
		
	}
	
	//查找机票数量
	public static int tickitNumSearch(String flightID)
	{
		Connection db = SqlUtil.open();
		if(Passenger.tickitQueryPanel.c3.getSelectedItem().toString().equals("头等舱"))
		{
			
			String sql = "select  toudengNum from flight where flightID = ?";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			
				try {
					pstmt = db.prepareStatement(sql);
					pstmt.setString(1, flightID);
			
					// TODO Auto-generated catch block
				
				result = pstmt.executeQuery();
				while(result.next())
				{
					return result.getInt("toudengNum");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					SqlUtil.close(db);
				}
				return -1;
		}else if(Passenger.tickitQueryPanel.c3.getSelectedItem().toString().equals("经济舱"))
		{
			String sql = "select  jingjiNum from flight where flightID = ?";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			
				try {
					pstmt = db.prepareStatement(sql);
					pstmt.setString(1, flightID);
			
					// TODO Auto-generated catch block
				
				result = pstmt.executeQuery();
				while(result.next())
				{
					return result.getInt("jingjiNum");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					SqlUtil.close(db);
				}
				return -1;
		}
		
			return -1;
	}
	//根据用户查找余额
	public static int moneySearch(String user) 
	{
		
			Connection db = SqlUtil.open();
			String sql = "select money from register where username = ?";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			
				try {
					pstmt = db.prepareStatement(sql);
					pstmt.setString(1, user);
			
					// TODO Auto-generated catch block
				
				result = pstmt.executeQuery();
				while(result.next())
				{
					return result.getInt("money");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					SqlUtil.close(db);
				}
				return 0;
		
	}
	//根据用户修改余额
	public static boolean moneyUpdata(String user,int newMoney)  
	{
		
		Connection db = SqlUtil.open();
		PreparedStatement ps;
		try {
			ps = db.prepareStatement("update register set money = ? where username = ?");
			 ps.setInt(1,newMoney);
		        ps.setString(2,user);
		        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
       return true;
	}
	
	//根据用户修改密码
	public static boolean pwdUpdata(String user,String newPwd) 
	{
		
		Connection db = SqlUtil.open();
		
		PreparedStatement ps;
		try {
			ps = db.prepareStatement("update register set password = ? where username = ?");
			ps.setString(1,newPwd);
			ps.setString(2,user);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		 return true;
	}
	
	//机票数量更改
	public static boolean tickitNumUpdata(String flightID,int tictitNum)
	{
		Connection db = SqlUtil.open();
		if(Passenger.tickitQueryPanel.c3.getSelectedItem().toString().equals("头等舱"))
		{
			String sql = "update flight set toudengNum = ? where flightID = ?";
			PreparedStatement pstmt = null;
				try {
					pstmt = db.prepareStatement(sql);
					pstmt.setInt(1, tictitNum);
					pstmt.setString(2, flightID);
					// TODO Auto-generated catch block
					
					pstmt.executeUpdate();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					SqlUtil.close(db);
				}
				return true;
		}else if(Passenger.tickitQueryPanel.c3.getSelectedItem().toString().equals("经济舱"))
		{
			String sql = "update flight set jingjiNum = ? where flightID = ?";
			PreparedStatement pstmt = null;
			
				try {
					pstmt = db.prepareStatement(sql);
					pstmt.setInt(1, tictitNum);
					pstmt.setString(2, flightID);
					
					// TODO Auto-generated catch block
				
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}finally {
					SqlUtil.close(db);
				}
				return true;
		}
		
			return false;
	}
	
	
	
	
	//验证乘客用户名,或邮箱，身份证是否存在
	public static String passenger_exist(String username,String email,String idcard) 
	{
		String str1 = "该手机号已被注册";
		String str2 = "该邮箱号已被注册";
		String str3 = "该身份证号已被注册";
		Connection db = SqlUtil.open();
		String sql1 = "select * from register where username = ? ";
		String sql2 = "select * from register where email = ? ";
		String sql3 = "select * from register where idcard = ? ";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = db.prepareStatement(sql1);
			pstmt.setString(1, username);
			result = pstmt.executeQuery();
			while(result.next()) {
				SqlUtil.close(db);
				return str1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return str1;
		}
		try {
			pstmt = db.prepareStatement(sql2);
			pstmt.setString(1, email);
			result = pstmt.executeQuery();
			while(result.next()) {
				SqlUtil.close(db);
				return str2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return str2;
		}
		try {
			pstmt = db.prepareStatement(sql3);
			pstmt.setString(1, idcard);
			result = pstmt.executeQuery();
			while(result.next()) {
				SqlUtil.close(db);
				return str3;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return str3;
		}
		SqlUtil.close(db);
		return null;//"信息未重名，可以注册"
	}
	
	
	
	
	//验证管理用户名,或邮箱，身份证是否存在
	public static String admi_exist(String username,String email,String idcard) 
	{
		String str1 = "该手机号已被注册";
		String str2 = "该邮箱号已被注册";
		String str3 = "该身份证号已被注册";
		Connection db = SqlUtil.open();
		String sql1 = "select * from register2 where username = ? ";
		String sql2 = "select * from register2 where email = ? ";
		String sql3 = "select * from register2 where idcard = ? ";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = db.prepareStatement(sql1);
			pstmt.setString(1, username);
			result = pstmt.executeQuery();
			while(result.next()) {
				SqlUtil.close(db);
				return str1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return str1;
		}
		try {
			pstmt = db.prepareStatement(sql2);
			pstmt.setString(1, email);
			result = pstmt.executeQuery();
			while(result.next()) {
				SqlUtil.close(db);
				return str2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return str2;
		}
		try {
			pstmt = db.prepareStatement(sql3);
			pstmt.setString(1, idcard);
			result = pstmt.executeQuery();
			while(result.next()) {
				SqlUtil.close(db);
				return str3;
			}
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return str3;
		}
		SqlUtil.close(db);
		return null;//"信息未重名，可以注册"
	}
	
	
	
	
	//新增乘客注册信息  
	public static String addUser(String username,String password,String email,String nickname,String idcard,
			Date submission_date,String head,String state)																	 
	{
		if(passenger_exist(username,email,idcard)!=null) {
			String str = passenger_exist(username,email,idcard);
			return str;
		}
		else {
		Connection db = SqlUtil.open();
		String sql = "insert into register (username,password,email,nickname,idcard,submission_date,head,state) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, nickname);
			pstmt.setString(5, idcard);
			pstmt.setDate(6, submission_date);
			pstmt.setString(7, head);
			pstmt.setString(8, state);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			SqlUtil.close(db);
		}
		return "恭喜你!注册成功";
		}
	}
	
	
	
	 //新增管理注册信息 
	public static String addAdmi(String username,String password,String email,String nickname,String idcard,
			Date submission_date,String head,String state)                                                                        
	{
		if(admi_exist(username,email,idcard)!=null) {
			String str = admi_exist(username,email,idcard);
			return str;
		}
		else {
		Connection db = SqlUtil.open();
		String sql = "insert into register2 (username,password,email,nickname,idcard,submission_date,head,state) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, nickname);
			pstmt.setString(5, idcard);
			pstmt.setDate(6,submission_date);
			pstmt.setString(7, head);
			pstmt.setString(8, state);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			SqlUtil.close(db);
		}
		return "恭喜你!注册成功";
		}
	}
//根据航班号航班查询
	public static boolean searchFlight(String flightID)
	{
		Connection db = SqlUtil.open();
		String sql = "select * from flight where flightID = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, flightID);
			result = pstmt.executeQuery();
			while(result.next()) {
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			SqlUtil.close(db);//关闭数据库连接
		}
		
		return false;
	}
	
	//新增航班
	public static boolean addFlight(String flightID,String fromTime,String toTime,String date,String fromAddr,
			String toAddr, String firm,String jingjiPrice,String toudengPrice,int jingjiNum,int toudengNum,
			String ontimeRate,String beginPlace,String destePlace)																	 
	{
		
			Connection db = SqlUtil.open();
			String sql = "insert into flight (flightID,fromTime,toTime,date,fromAddr,"
					+ "toAddr,firm,jingjiPrice,toudengPrice,jingjiNum,toudengNum,ontimeRate,beginPlace,destePlace,count) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = db.prepareStatement(sql);
				pstmt.setString(1, flightID);
				pstmt.setString(2, fromTime);
				pstmt.setString(3, toTime);
				pstmt.setString(4, date);
				pstmt.setString(5, fromAddr);
				pstmt.setString(6, toAddr);
				pstmt.setString(7, firm);
				pstmt.setString(8, jingjiPrice);
				pstmt.setString(9, toudengPrice);
				pstmt.setInt(10, jingjiNum);
				pstmt.setInt(11, toudengNum);
				pstmt.setString(12, ontimeRate);
				pstmt.setString(13, beginPlace);
				pstmt.setString(14, destePlace);
				pstmt.setInt(15, 1);
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return false;
			}
			finally {
				SqlUtil.close(db);
			}
			return true;
		
	}
	//修改航班
	public static boolean updateFlight(String flightID,String fromTime,String toTime,String date,String fromAddr,
			String toAddr, String firm,String jingjiPrice,String toudengPrice,int jingjiNum,int toudengNum,
			String ontimeRate,String beginPlace,String destePlace)																	 
	{
		
		Connection db = SqlUtil.open();
		String sql = "update flight set fromTime = ? ,toTime = ? ,date = ? ,fromAddr = ?,toAddr = ?,"
				+ "firm = ?,jingjiPrice = ?, toudengPrice = ?,jingjiNum = ?,toudengNum = ? ,ontimeRate = ?,beginPlace = ?,destePlace = ?,count = ? where flightID = ?";
		PreparedStatement pstmt = null;
			try {
				pstmt = db.prepareStatement(sql);
				pstmt.setString(1, fromTime);
				pstmt.setString(2, toTime);
				pstmt.setString(3, date);
				pstmt.setString(4, fromAddr);
				pstmt.setString(5, toAddr);
				pstmt.setString(6, firm);
				pstmt.setString(7, jingjiPrice);
				pstmt.setString(8, toudengPrice);
				pstmt.setInt(9,jingjiNum);
				pstmt.setInt(10, toudengNum);
				pstmt.setString(11, ontimeRate);
				pstmt.setString(12, beginPlace);
				pstmt.setString(13, destePlace);
				pstmt.setInt(14, 1);
				pstmt.setString(15, flightID);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}finally {
				SqlUtil.close(db);
			}
			return true;
	}
	//删除航班
	public static boolean delFlight(String flightID)
	{
		Connection db = SqlUtil.open();
		String sql = "delete from flight where flightID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, flightID);
			 pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			SqlUtil.close(db);
			return false;
		}finally {
			SqlUtil.close(db);
		}
	}
	//查看有无该航班
	public static boolean flight_check(String flightID,String fromTime,String toTime,String date,String fromAddr,
			String toAddr, String firm,String jingjiPrice,String toudengPrice,int jingjiNum,int toudengNum,
			String ontimeRate,String beginPlace,String destePlace)
	{
		Connection db = SqlUtil.open();
		String sql = "select * from flight where flightID = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = db.prepareStatement(sql);
			pstmt.setString(1, flightID);
			result = pstmt.executeQuery();
			while(result.next() && result.getString("fromTime").equals(fromTime) && result.getString("toTime").equals(toTime) &&
					result.getString("date").equals(date) &&result.getString("fromAddr").equals(fromAddr) &&
					result.getString("toAddr").equals(toAddr) &&result.getString("firm").equals(firm) &&
					result.getString("jingjiPrice").equals(jingjiPrice) &&result.getString("toudengPrice").equals(toudengPrice) &&
					result.getInt("jingjiNum")==jingjiNum &&result.getInt("toudengNum")==toudengNum &&
					result.getString("ontimeRate").equals(ontimeRate) &&result.getString("beginPlace").equals(beginPlace) &&
					result.getString("destePlace").equals(destePlace) &&result.getString("flightID").equals(flightID) ) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			SqlUtil.close(db);//关闭数据库连接
		}
		
		return false;
	}
	
	
	//查看在线状态
		public static String onlineState(String username) 
		{
			Connection db = SqlUtil.open();
			String sql = "select * from register where username = ? ";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			try {
				pstmt = db.prepareStatement(sql);
				pstmt.setString(1, username);
				result = pstmt.executeQuery();
				while(result.next()) {
					SqlUtil.close(db);
					return result.getString("state");
				}
			} catch (Exception e) {
				e.printStackTrace();
				SqlUtil.close(db);
				return null;
			}
			
			SqlUtil.close(db);
			return null;//"信息未重名，可以注册"
		}
		//查看乘客头像kind
		public static String head(String username) 
		{
			Connection db = SqlUtil.open();
			String sql = "select * from register where username = ? ";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			try {
				pstmt = db.prepareStatement(sql);
				pstmt.setString(1, username);
				result = pstmt.executeQuery();
				while(result.next()) {
					return result.getString("head");
				}
			} catch (Exception e) {
				e.printStackTrace();
				SqlUtil.close(db);
				return null;
			}finally {
				SqlUtil.close(db);
			}
			return null;//"信息未重名，可以注册"
		}
		//返回管理员头像
		public static String head2(String username) 
		{
			Connection db = SqlUtil.open();
			String sql = "select * from register2 where username = ? ";
			PreparedStatement pstmt = null;
			ResultSet result = null;
			try {
				pstmt = db.prepareStatement(sql);
				pstmt.setString(1, username);
				result = pstmt.executeQuery();
				while(result.next()) {
					return result.getString("head");
				}
			} catch (Exception e) {
				e.printStackTrace();
				SqlUtil.close(db);
				return null;
			}finally {
				SqlUtil.close(db);
			}
			return null;//"信息未重名，可以注册"
		}
		
}
