package com.javapp.ch18;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.*;
import java.sql.*;
/**
 * Description:����򵥲�ѯ��

 */
public class CommonQuery extends JPanel implements ActionListener,ItemListener
{
    DataBaseManager DbBean = new DataBaseManager();
	private JTextField flightField = new JTextField(10);;	
	private static DefaultComboBoxModel modelFlight = new DefaultComboBoxModel();
	private static JComboBox jcbFlight = new JComboBox(modelFlight);
	private JButton jbFlightQuery = new JButton("��ѯ");
	private static DefaultComboBoxModel modelAirFirm = new DefaultComboBoxModel();
	private static JComboBox jcbAirFirm = new JComboBox(modelAirFirm);
	private JButton jbAirFirmQuery = new JButton("��ѯ");
	private static DefaultComboBoxModel model_1 = new DefaultComboBoxModel();
	private static DefaultComboBoxModel modelStart = new DefaultComboBoxModel();
	private static DefaultComboBoxModel modelArrive = new DefaultComboBoxModel();
	private static JComboBox jcb1 = new JComboBox(model_1),
	                         jcbStart = new JComboBox(modelStart),
	                         jcbArrive = new JComboBox(modelArrive);
    private JButton jbPlaceQuery1 = new JButton("��ѯ"),
                    jbPlaceQuery2 = new JButton("��ѯ"); 
	private String flightNumber;//�����
	private String airfirm;//��������
    private String destination,start,arrive;//Ŀ�ĵء��������С��ִ����                 
    private JLabel jLabel_IL;
    private JLabel jLabel_IL3;
    private JLabel jLabel_IL2;
    private JLabel jLabel_IL1;
    public CommonQuery()
    {
    	JPanel jpFlight = new JPanel();
    	jpFlight.setBorder(new TitledBorder("������Ų�ѯ"));
    	flightField.setPreferredSize(new java.awt.Dimension(63, 20));
    	jcbFlight.setPreferredSize(new java.awt.Dimension(88, 23));
    	JPanel jpAirFirm = new JPanel();
    	jpAirFirm.setBorder(new TitledBorder("�����չ�˾��ѯ"));
    	jcbAirFirm.setPreferredSize(new java.awt.Dimension(161, 23));
    	{
    		jLabel_IL1 = new JLabel("��ѡ��Ҫ��ѯ�ĺ��չ�˾����:");
    		jpAirFirm.add(jLabel_IL1);
    		jLabel_IL1.setPreferredSize(new java.awt.Dimension(194, 15));
    		jLabel_IL1.setName("jLabel_IL1");
    		jpAirFirm.add(jcbAirFirm);
    		jpAirFirm.add(jbAirFirmQuery);
    	}
    	JPanel jp1 = new JPanel();
    	jcb1.setPreferredSize(new java.awt.Dimension(168, 23));
    	{
    		jLabel_IL2 = new JLabel("��ѡ����Ҫ�����Ŀ�ĵ�:");
    		jp1.add(jLabel_IL2);
    		jLabel_IL2.setPreferredSize(new java.awt.Dimension(190, 14));
    		jLabel_IL2.setName("jLabel_IL2");
    		jp1.add(jcb1);
    		jp1.add(jbPlaceQuery1);
    	}
    	JPanel jpPlace1 = new JPanel();
    	jpPlace1.setLayout(new BorderLayout());
    	jpPlace1.add(jp1,BorderLayout.CENTER);
    	JPanel jp2 = new JPanel(); 
    	jp2.add(new JLabel("��������:"));
    	jp2.add(jcbStart);
    	jp2.add(new JLabel("�ִ����:"));
    	jp2.add(jcbArrive);
    	jp2.add(jbPlaceQuery2);
    	JPanel jpPlace2 = new JPanel();
    	jpPlace2.setLayout(new BorderLayout());
    	jpPlace2.add(new JLabel("��ѡ����ʼ���к͵ִ���н��в�ѯ:"),BorderLayout.CENTER);
    	JPanel jpDestin = new JPanel();
    	jpDestin.setBorder(new TitledBorder("��Ŀ�ĵز�ѯ"));
    	jpDestin.setLayout(new BorderLayout());
    	jpDestin.add(jpPlace1,BorderLayout.NORTH);	
    	this.setLayout(new BorderLayout());
    	this.setPreferredSize(new java.awt.Dimension(499, 254));
    	this.add(jpFlight,BorderLayout.NORTH);
    	jpFlight.setPreferredSize(new java.awt.Dimension(499, 90));
    	{
    		jLabel_IL = new JLabel("�����뺽��Ż���б�ѡ��:");
    		jpFlight.add(jLabel_IL);
    		jLabel_IL.setPreferredSize(new java.awt.Dimension(166, 15));
    		jLabel_IL.setName("jLabel_IL");
    		jpFlight.add(flightField);
    		jpFlight.add(jcbFlight);
    		jpFlight.add(jbFlightQuery);
    	}
    	this.add(jpAirFirm,BorderLayout.CENTER);
    	jpAirFirm.setPreferredSize(new java.awt.Dimension(499, 68));
    	this.add(jpDestin,BorderLayout.SOUTH);
    	jpDestin.setPreferredSize(new java.awt.Dimension(499, 91));
    	jcbFlight.addItemListener(this);
    	jbFlightQuery.addActionListener(this);
    	jbAirFirmQuery.addActionListener(this);
    	jbPlaceQuery1.addActionListener(this);
    	jbPlaceQuery2.addActionListener(this);
    	
    }
    //���������б����Ϣ
    public static void updateFlightComboBox(String newFlightNum,int insertOrDelete)
	{
		if (insertOrDelete == 1)
		{
			if (modelFlight.getIndexOf(newFlightNum) == -1)
			   modelFlight.addElement(newFlightNum);
		}  
		else if (insertOrDelete == 2)
		{
			if (modelFlight.getIndexOf(newFlightNum) != -1)
			   modelFlight.removeElement(newFlightNum);			
		}		   
	}
	public static void updateAirFirmComboBox(String newPlace,int insertOrDelete)
	{
		if (insertOrDelete == 1)
		{
			if (modelAirFirm.getIndexOf(newPlace) == -1)
			   jcbAirFirm.addItem(newPlace);
		}
		   
		else if (insertOrDelete == 2)
		{
			if (modelAirFirm.getIndexOf(newPlace) != -1)
			   jcbAirFirm.removeItem(newPlace);
		}		   
	}
	
	public static void updatePlaceComboBox(String newPlace,int insertOrDelete)
    {
    	if (insertOrDelete == 1)
    	{
    		if (model_1.getIndexOf(newPlace) == -1)
	    	   jcb1.addItem(newPlace);
	    	 
	    	if (modelStart.getIndexOf(newPlace) == -1)
	    	   jcbStart.addItem(newPlace);
	    	   
	    	if (modelArrive.getIndexOf(newPlace) == -1)
	    	   jcbArrive.addItem(newPlace);	
    	}
    	else if (insertOrDelete == 2)
    	{
    		if (model_1.getIndexOf(newPlace) != -1)
    		   jcb1.removeItem(newPlace);
    		
    		if (modelStart.getIndexOf(newPlace) != -1)
    	       jcbStart.removeItem(newPlace);
    		
    		if (modelArrive.getIndexOf(newPlace) != -1)
    		   jcbArrive.removeItem(newPlace);
    	}    	
    }    
    
    public void itemStateChanged(ItemEvent e)
    {
    	if (e.getSource() == jcbFlight)
    	{
    		flightField.setText( (String)jcbFlight.getSelectedItem() );
    	}
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource() == jbFlightQuery)//������Ų�ѯ
    	{
    		this.flightNumber = flightField.getText().trim();	
			if (flightNumber.length() == 0)
			{
				JOptionPane.showMessageDialog(null,"�����뺽��Ż��ߴ��б���ѡ��",
				                              "������Ϣ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			executeFlightQuery();
    	}
    	
    	else if (e.getSource() == jbAirFirmQuery)//�����չ�˾���Ʋ�ѯ
    	{
    		this.airfirm = (String)jcbAirFirm.getSelectedItem();
			executeAirFirmQuery();
    	}
    	
    	else if (e.getSource() == jbPlaceQuery1)
    	{
    		destination = (String)jcb1.getSelectedItem();
    		destination = destination.trim();
    		executeDestinQuery(1);
    	}
    	else if (e.getSource() == jbPlaceQuery2)
    	{
    		   //�õ���ʼ��
    		start = (String)jcbStart.getSelectedItem();
    		start = start.trim();
    		   //�õ�Ŀ�ĵ�
    		arrive = (String)jcbArrive.getSelectedItem();
    		arrive = arrive.trim();
    		executeDestinQuery(2);//��Ŀ�ĵز�ѯ
    	}    	
    }
    public void executeFlightQuery()//������Ų�ѯ
	{
		String sqlString = "SELECT DISTINCT * FROM " +
		                   "flightTick " +
		                   "WHERE flight=" + "\'" + flightNumber + "\'";
	    ResultSet rs = DbBean.executeQuery(sqlString);		        
	    if (rs != null)
	    {
	        String result = "                                                    " + 
			                "����Ų�ѯ"; 
			result += "��ѯ�ĺ����:" + flightNumber + "\n";      
	        result += formResult(rs);    	
	        
	           //��ʾ���
	        showResult(result);
	    }	
	    else 
	       JOptionPane.showMessageDialog(null,"δ��ѯ������!",
	                                    "������Ϣ",JOptionPane.ERROR_MESSAGE);
	    try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
  //�����չ�˾���Ʋ�ѯ
	public void executeAirFirmQuery()
	{
		   //Form the sqlString
		String sqlString = "SELECT DISTINCT * FROM " +
		                   "flightTick  " +
		                   "WHERE airfirm=" + "\'" + airfirm + "\'";    
	    ResultSet rs = DbBean.executeQuery(sqlString);
	     
	    if (rs != null)
        {
	        String result = "                                                    " + 
			                "���չ�˾��ѯ"; 
			result += "��ѯ�ĺ��չ�˾:" + airfirm + "\n";     
	        result += formResult(rs);    	
	        
	           //��ʾ��ѯ���
	        showResult(result);
        }	       
	    else 
	       JOptionPane.showMessageDialog(null,"δ��ѯ������!",
	                                    "������Ϣ",JOptionPane.ERROR_MESSAGE);
	    try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executeDestinQuery(int flag)//��Ŀ�ĵز�ѯ
    {
    	String sqlString = "SELECT DISTINCT * FROM " + "flightTick  ";
    	if (flag == 1)
    	   sqlString += "WHERE destination=" + "\'" + destination + "\'";
    	else 
    	   sqlString += "WHERE start=" + "\'" + start + "\'" + " AND " +
    	                "destination=" + "\'" + arrive + "\'";
        ResultSet rs =DbBean.executeQuery(sqlString);
        
        if (rs != null)
        {
        	String result = "                                                    " + 
		                "Ŀ�ĵز�ѯ " + "\n";
        	   //�����������͵Ĳ�ѯ
			if (flag == 1)
			   result += "���� " + destination + " �����к���:" + "\n";
			else
			   result += "ʼ����: " + start + "---" + "Ŀ�ĵ�: " + arrive + "\n";
			   
			result += formResult(rs);
			   
			showResult(result);
        }
	       
	    else 
	       JOptionPane.showMessageDialog(null,"δ�鵽����!",
	                                    "������Ϣ",JOptionPane.ERROR_MESSAGE);  
        try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	public String formResult(ResultSet rs)
	{
		String result = "�����    ���չ�˾       ��ɵص�  �ִ�ص�  ���ʱ��  �ִ�ʱ��  " + 
		                "��ͯƱ��   ����Ʊ��   �ۿ�    ���� " + "\n";
		   
		int originLength = result.length();
		String time1,time2;
		String childFare,adultFare,discount1,discount2,seat;	
		try
		{
			while(rs.next())
			{
				result += rs.getString("flight") + rs.getString("airfirm") + rs.getString("start") + 
				          rs.getString("destination");
				time1 = rs.getString("leaveTime");
				time2 = rs.getString("arriveTime");
				time1 = getTime(time1);
				time2 = getTime(time2);
				result += time1 + "     " + time2  + "     ";
				childFare = String.valueOf(rs.getFloat("childFare"));
				adultFare = String.valueOf(rs.getFloat("adultFare"));
				discount1 = String.valueOf(rs.getFloat("discount1"));
				discount2 = String.valueOf(rs.getFloat("discount2"));
				seat = String.valueOf(rs.getInt("seat"));
				while(childFare.length() != 11)
				   childFare += " ";
				while(adultFare.length() != 11)
				   adultFare += " ";
				while(discount1.length() != 8)
				   discount1 += " ";					
				   
				result += childFare + adultFare + discount1 +
				          rs.getString("week");
				result += "\n";
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if (result.length() == originLength)
		{
			result += "                                                    " +
			          "δ�ҵ�������Ϣ!" + "\n";
		}	
		
		return result;
	}
	
	//��ʾ�Ի���
    public void showResult(String result)
    {
    	JOptionPane.showMessageDialog(null,result,"��ѯ���",JOptionPane.PLAIN_MESSAGE);
    }          
	
	//����ʱ���ʽ
	private String getTime(String time)
	{
		String time1,time2;
		time1 = time.substring(0,2);
		time2 = time.substring(2,4);
		time1 = time1.concat(":");
		time1 = time1.concat(time2);
		return time1;
	}            
}