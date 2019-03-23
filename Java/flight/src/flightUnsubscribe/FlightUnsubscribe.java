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
		Frame f = new Frame("��ƱԤ��ϵͳ");
		f.setLocation(500,200);
		f.setSize(400,400);
		f.setLayout(new GridLayout(5,1));
		JPanel jp1= new JPanel();
		f.add(jp1);
	    JTextField jTextField1 = new JTextField();
	    jTextField1.addFocusListener(new JTextFieldHintListener(jTextField1,"�����붩����"));
	    jTextField1.setBounds(45,80, 80, 30);
	    f.add(jTextField1);
	    
		JPanel jp2= new JPanel();
		f.add(jp2);
	    JTextField jTextField2 = new JTextField();
	    jTextField2.addFocusListener(new JTextFieldHintListener(jTextField2, "�����붩Ʊ�Ŷ�Ӧ�����֤��"));
	    jTextField2.setBounds(95,130, 80, 30);
	    f.add(jTextField2);
	   
		JPanel jp3= new JPanel();
		JButton jb = new JButton("ȷ��");
		jb.setSize(40, 20);
		jb.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ResultSet rs = null;
		        	String number = jTextField1.getText();
		    		String id = jTextField2.getText();
	            	String sqlString ;
	            	sqlString = "select count(���֤��) from ��Ʊ��Ϣ��  where ���֤��  = '" + id +"' ";
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
	            	sqlString = "select �����,��λ�� from ��Ʊ��Ϣ��  where ������  = '" 
            				+ number + "' " + "and ���֤��  = '" + id +"' ";
	            	rs = DataBaseManager.executeQuery(sqlString);
//		            	System.out.println(sqlString);
	            	String flightNumber = null;
	            	String seat = null;
	            	try
	            	{
	            		if(rs.next())
	            		{
			            	flightNumber = rs.getString("�����");
			            	seat = rs.getString("��λ��");
	            		}
	            		else
	            		{
	            			JOptionPane.showMessageDialog(null, "��Ʊʧ�ܣ���˶���Ϣ��","��ʾ��",JOptionPane.INFORMATION_MESSAGE);
	            			System.exit(0);
	            		}
	       
	            	}
	            	catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
	            	sqlString =("delete from ��Ʊ��Ϣ��  where ������  = '" 
            				+ number + "' " + "and ���֤��  = '" + id +"' "); 
//		            	System.out.println(sqlString);
	            	int m = DataBaseManager.executeDelete(sqlString);
	            	sqlString = ("update ������Ϣ�� set ��Ʊ�� = ��Ʊ�� + 1 where �����  = '" 
            				+ flightNumber + "' ");
	            	int n = DataBaseManager.executeUpdate(sqlString);
	            	sqlString = ("update ��λ��Ϣ�� set ��λ�Ƿ�Ԥ�� = '��'  where �����  = '" 
            				+ flightNumber + "' and ��λ�� = '" + seat + "'");
	            	if(num == 1)
	            	{
	            		sqlString =("delete from �ÿ���Ϣ��  where ���֤��  = '" + id +"' ");
	            		int k = DataBaseManager.executeDelete(sqlString);
	            	}
	            	int h = DataBaseManager.executeUpdate(sqlString);
	            	if(m == n&&n == h&&m>0)
	            	{
	            		JOptionPane.showMessageDialog(null, "���Ķ�����Ϊ:"+ number +"�����Ϊ:"+ flightNumber 
	            				+ "��λ��Ϊ:"+ seat +"�Ļ�Ʊ��Ʊ�ɹ���","��ʾ��",JOptionPane.INFORMATION_MESSAGE);
	            		System.exit(0);
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null, "��Ʊʧ�ܣ���˶���Ϣ��","��ʾ��",JOptionPane.INFORMATION_MESSAGE);
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
