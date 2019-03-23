package system;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class SqlUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	public static int headkind = -1;//记录头像类型,-1默认无头像
	public static String userState = "离线";//记录头像类型,-1默认无头像
	public static boolean hasselect= false;//标记头像已选否
	public static boolean hasOpen= false;//标记头像窗是否打开
	
	public SqlUtil() {
		
	}
	public static Connection open()//数据库连接方法
	{
		
		Properties p = new Properties() ;//属性文件记录mysql的驱动类，url，数据库名密码等信息
		
		try {
			Reader r =  new FileReader("src\\Mysql.properties");//代开文件
			p.load(r);//加载
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = p.getProperty("driver");//通过属性参数获得相应字符串
		url = p.getProperty("url");
		password = p.getProperty("password");
		username = p.getProperty("username");
		try {
			Class.forName(driver);
			//验证乘客用户名,或邮箱，身份证是否存在
			Connection db =DriverManager.getConnection(url,username,password);//获得连接对象
			return db;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection db)
	{
		try {
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



