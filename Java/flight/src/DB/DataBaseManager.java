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
		//��������������ݿ�����
    private final static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=��ƱԤ��ϵͳ���ݿ�";
    private static final String USER="user";
    private static final String PASSWORD="421181";
    private static Connection conn=null;
    //��̬����飨�������������������ݿ���뾲̬���У�
    static{
        try {
            //1.������������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.������ݿ������
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
    
    public static Connection getConnection()	//�����ṩһ����������ȡ���ݿ�����
    {
        return conn;
    }
  
    public static ResultSet executeQuery(String sql)	//��ѯ���ݣ����ؽ����
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
    
    public static int executeInsert(String sql)		//�������ݣ����ز��������
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
    
    public static int executeDelete(String sql)		//ɾ������,����ɾ��������
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
    
    public static int executeUpdate(String sql)	//�������ݣ����ظ��µ�����
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
