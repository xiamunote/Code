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
	public static int headkind = -1;//��¼ͷ������,-1Ĭ����ͷ��
	public static String userState = "����";//��¼ͷ������,-1Ĭ����ͷ��
	public static boolean hasselect= false;//���ͷ����ѡ��
	public static boolean hasOpen= false;//���ͷ���Ƿ��
	
	public SqlUtil() {
		
	}
	public static Connection open()//���ݿ����ӷ���
	{
		
		Properties p = new Properties() ;//�����ļ���¼mysql�������࣬url�����ݿ����������Ϣ
		
		try {
			Reader r =  new FileReader("src\\Mysql.properties");//�����ļ�
			p.load(r);//����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = p.getProperty("driver");//ͨ�����Բ��������Ӧ�ַ���
		url = p.getProperty("url");
		password = p.getProperty("password");
		username = p.getProperty("username");
		try {
			Class.forName(driver);
			//��֤�˿��û���,�����䣬���֤�Ƿ����
			Connection db =DriverManager.getConnection(url,username,password);//������Ӷ���
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



