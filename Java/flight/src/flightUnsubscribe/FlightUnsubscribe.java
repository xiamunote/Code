package flightUnsubscribe;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.DataBaseManager;
import flightSeat.SeatView;
import flightView.JTextFieldHintListener;

public class FlightUnsubscribe
{
	public FlightUnsubscribe()
	{
		Frame f = new Frame("机票预订系统");
		f.setLocation(500,200);
		f.setSize(400,400);
		f.setLayout(new GridLayout(5,1));
		JPanel jp1= new JPanel();
		f.add(jp1);
	    JTextField jTextField1 = new JTextField();
	    jTextField1.addFocusListener(new JTextFieldHintListener(jTextField1,"请输入订单号"));
	    jTextField1.setBounds(45,80, 80, 30);
	    f.add(jTextField1);
	    
		JPanel jp2= new JPanel();
		f.add(jp2);
	    JTextField jTextField2 = new JTextField();
	    jTextField2.addFocusListener(new JTextFieldHintListener(jTextField2, "请输入订票号对应的身份证号"));
	    jTextField2.setBounds(95,130, 80, 30);
	    f.add(jTextField2);
	   
		JPanel jp3= new JPanel();
		JButton jb = new JButton("确定");
		jb.setSize(40, 20);
		jb.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ResultSet rs = null;
		        	String number = jTextField1.getText();
		    		String id = jTextField2.getText();
	            	String sqlString ;
	            	sqlString = "select count(身份证号) from 订票信息表  where 身份证号  = '" + id +"' ";
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
	            	sqlString = "select 航班号,座位号 from 订票信息表  where 订单号  = '" 
            				+ number + "' " + "and 身份证号  = '" + id +"' ";
	            	rs = DataBaseManager.executeQuery(sqlString);
//		            	System.out.println(sqlString);
	            	String flightNumber = null;
	            	String seat = null;
	            	try
	            	{
	            		if(rs.next())
	            		{
			            	flightNumber = rs.getString("航班号");
			            	seat = rs.getString("座位号");
	            		}
	            		else
	            		{
	            			JOptionPane.showMessageDialog(null, "退票失败，请核对信息！","提示！",JOptionPane.INFORMATION_MESSAGE);
	            			System.exit(0);
	            		}
	       
	            	}
	            	catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
	            	sqlString =("delete from 订票信息表  where 订单号  = '" 
            				+ number + "' " + "and 身份证号  = '" + id +"' "); 
//		            	System.out.println(sqlString);
	            	int m = DataBaseManager.executeDelete(sqlString);
	            	sqlString = ("update 航班信息表 set 余票数 = 余票数 + 1 where 航班号  = '" 
            				+ flightNumber + "' ");
	            	int n = DataBaseManager.executeUpdate(sqlString);
	            	sqlString = ("update 座位信息表 set 座位是否被预订 = '否'  where 航班号  = '" 
            				+ flightNumber + "' and 座位号 = '" + seat + "'");
	            	if(num == 1)
	            	{
	            		sqlString =("delete from 旅客信息表  where 身份证号  = '" + id +"' ");
	            		int k = DataBaseManager.executeDelete(sqlString);
	            	}
	            	int h = DataBaseManager.executeUpdate(sqlString);
	            	if(m == n&&n == h&&m>0)
	            	{
	            		JOptionPane.showMessageDialog(null, "您的订单号为:"+ number +"航班号为:"+ flightNumber 
	            				+ "座位号为:"+ seat +"的机票退票成功！","提示！",JOptionPane.INFORMATION_MESSAGE);
	            		System.exit(0);
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null, "退票失败，请核对信息！","提示！",JOptionPane.INFORMATION_MESSAGE);
	            		System.exit(0);
	            	}
		        }
		    });
		jp3.add(jb);
		f.add(jp3);		
		f.setResizable(false);
		f.setVisible(true);
	    f.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
	    });
	}

}
