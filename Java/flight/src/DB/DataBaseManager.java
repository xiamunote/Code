package DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager
{
		//这里可以设置数据库名称
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=机票预订系统数据库";
    private static final String USER="user";
    private static final String PASSWORD="421181";
    private static Connection conn=null;
    //静态代码块（将加载驱动、连接数据库放入静态块中）
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.获得数据库的连接
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
            } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection()	//对外提供一个方法来获取数据库连接
    {
        return conn;
    }
  
    public static ResultSet executeQuery(String sql)	//查询数据，返回结果集
    {
    	ResultSet rs = null;
    	try
    	{
    		Statement stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    	}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return rs;
    }
    
    public static int executeInsert(String sql)		//插入数据，返回插入的数量
    {
    	int rs = 0;
    	try
    	{
    		Statement stmt = conn.createStatement();
    		rs = stmt.executeUpdate(sql);
    	}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return rs;
    }
    
    public static int executeDelete(String sql)		//删除数据,返回删除的数量
    {
    	int rs = 0;
    	try
    	{
    		Statement stmt = conn.createStatement();
    		rs = stmt.executeUpdate(sql);
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
		}
    	return rs;
    }
    
    public static int executeUpdate(String sql)	//更新数据，返回更新的数量
    {
    	int rs = 0;
    	try 
    	{
    		Statement stmt = conn.createStatement();
    		rs = stmt.executeUpdate(sql);
    	}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return rs;
    }
    
}
