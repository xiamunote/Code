package flightTicket;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.color.ICC_ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import org.omg.CORBA.PUBLIC_MEMBER;

import DB.DataBaseManager;
import flightMain.Main;
import flightSeat.SeatView;
import flightView.JTextFieldHintListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class WriteInformation
{
	public String seat;
	public WriteInformation(String seat1,String flightNumber)
	{
		String seat = seat1;
		Frame f = new Frame("机票预订系统");
		f.setLocation(610,80);
		f.setSize(400,400);
		f.setLayout(new GridLayout(11,1));
		JPanel jp1= new JPanel();
		f.add(jp1);
	    JTextField jTextField1 = new JTextField();
	    jTextField1.addFocusListener(new JTextFieldHintListener(jTextField1,seat));
	    jTextField1.setBounds(45,80, 80, 30);
	    f.add(jTextField1);
	    
		JPanel jp2= new JPanel();
		f.add(jp2);
	    JTextField jTextField2 = new JTextField();
	    jTextField2.addFocusListener(new JTextFieldHintListener(jTextField2, "请输入姓名"));
	    jTextField2.setBounds(95,130, 80, 30);
	    f.add(jTextField2);
	    
		JPanel jp3= new JPanel();
		f.add(jp3);
	    JTextField jTextField3 = new JTextField();
	    jTextField3.addFocusListener(new JTextFieldHintListener(jTextField3, "请输入性别"));
	    jTextField3.setBounds(45,180, 80, 30);
	    f.add(jTextField3);
	    
		JPanel jp4= new JPanel();
		f.add(jp4);
	    JTextField jTextField4 = new JTextField();
	    jTextField4.addFocusListener(new JTextFieldHintListener(jTextField4, "请输入18位身份证号"));
	    jTextField4.setBounds(45,230, 80, 30);
	    f.add(jTextField4);
	    
		JPanel jp5= new JPanel();
		f.add(jp5);
	    JTextField jTextField5 = new JTextField();
	    jTextField5.addFocusListener(new JTextFieldHintListener(jTextField5, "请输入11位手机号"));
	    jTextField5.setBounds(45,280, 80, 30);
	    f.add(jTextField5);
	    
		JPanel jp6= new JPanel();
		JButton jb = new JButton("确定");
		jb.setSize(40, 20);
		

	    jb.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String seat = jTextField1.getText();
	            String name = jTextField2.getText();
	            String sex = jTextField3.getText();
	            String id = jTextField4.getText();
	            String telephone = jTextField5.getText();
	            String sqlString;
	            ResultSet rs = null; 
	            sqlString = "select count(身份证号) from 旅客信息表  where 身份证号  = '" + id +"' ";
            	rs = DataBaseManager.executeQuery(sqlString);
            	int num = 0;
            	try{
            		if(rs.next())
            		{
		            	num = rs.getInt(1);
		            	System.out.println(num);
            		}
            	}
            	catch (Exception e1) {
					e1.printStackTrace();
				}
//	            System.out.println(flightNumber);
	            sqlString = ("update 航班信息表  set 余票数 = 余票数 - 1 where 航班号  = '" 
	            			+ flightNumber + "' ");
//	            System.out.println(sqlString);
	            int m = DataBaseManager.executeUpdate(sqlString);
	            
	            int n = 0;
	            if(num < 1)
	            {
		            sqlString = "insert into 旅客信息表(身份证号,姓名,性别,电话)" + 
	        			"values(" + id +",'" + name + "','" + sex + "',"+ telephone + ")" ;
	//	            System.out.println(sqlString);
		             n = DataBaseManager.executeInsert(sqlString);
	            }
	            else
	            {
	            	n = 1;
	            }
	            sqlString = "update 座位信息表  set 座位是否被预订 = '是' where 航班号  = '" 
     				+ flightNumber + "' and 座位号 = '" + seat +"'";
//	            System.out.println(sqlString);
	            int j = DataBaseManager.executeUpdate(sqlString);
	            
	            int k = 0;
	            int i = 0;
	            try
	            {
	            	rs = DataBaseManager.executeQuery("select max(订单号) from 订票信息表  ");
		            if(rs.next())
	            	{
		            	i = rs.getInt(1);
		            	i = i + 1;
	            	}
//	            	System.out.println(i);
	            }
	            catch (Exception e4) {
	            	System.out.println("订单信息表修改不成功！");
				}
            	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	String time = df.format(new Date());
            	sqlString ="insert into 订票信息表(订单号,身份证号,航班号,座位号,订票时间)" + 
            			"values(" + i +"," + id + "," + flightNumber + ",'"
            			+ seat + "','" + time + "')";
//            	System.out.println(sqlString);
            	k = DataBaseManager.executeInsert(sqlString);
	            if(m == n && n == j && j == k && m > 0)
	            {
	            	int h = JOptionPane.showConfirmDialog(null, 
	            			"购票成功，您的订单号是："+ i +"！\n"+"点击确定继续订票,点击否退出","提示",JOptionPane.YES_NO_OPTION);
	            	m = n = j = k =0;
	            	if(h == 0)
	            	{
	            		SeatView st = new SeatView(flightNumber);
	            	}
	            	else
	            	{
	            		System.exit(0);
	            	}
	            }
	            else
	            {
	            	int l = JOptionPane.showConfirmDialog(null, "购票不成功,请核对信息！"
	            			+ "点击确定继续订票,点击否退出","提示",JOptionPane.YES_NO_OPTION);
	            	if(l == 0)
	            	{
	            		
	            	}
	            	else
	            	{
	            		System.exit(0);
	            	}
	            }

	        }
	    });
	    jp6.add(jb);
		f.add(jp6);
		
		f.setResizable(false);
		f.setVisible(true);
	    f.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
	    });
	}
}
