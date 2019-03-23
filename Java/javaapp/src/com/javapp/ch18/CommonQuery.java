package com.javapp.ch18;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.*;
import java.sql.*;
/**
 * Description:航班简单查询类

 */
public class CommonQuery extends JPanel implements ActionListener,ItemListener
{
    DataBaseManager DbBean = new DataBaseManager();
	private JTextField flightField = new JTextField(10);;	
	private static DefaultComboBoxModel modelFlight = new DefaultComboBoxModel();
	private static JComboBox jcbFlight = new JComboBox(modelFlight);
	private JButton jbFlightQuery = new JButton("查询");
	private static DefaultComboBoxModel modelAirFirm = new DefaultComboBoxModel();
	private static JComboBox jcbAirFirm = new JComboBox(modelAirFirm);
	private JButton jbAirFirmQuery = new JButton("查询");
	private static DefaultComboBoxModel model_1 = new DefaultComboBoxModel();
	private static DefaultComboBoxModel modelStart = new DefaultComboBoxModel();
	private static DefaultComboBoxModel modelArrive = new DefaultComboBoxModel();
	private static JComboBox jcb1 = new JComboBox(model_1),
	                         jcbStart = new JComboBox(modelStart),
	                         jcbArrive = new JComboBox(modelArrive);
    private JButton jbPlaceQuery1 = new JButton("查询"),
                    jbPlaceQuery2 = new JButton("查询"); 
	private String flightNumber;//航班号
	private String airfirm;//航班名称
    private String destination,start,arrive;//目的地、出发城市、抵达城市                 
    private JLabel jLabel_IL;
    private JLabel jLabel_IL3;
    private JLabel jLabel_IL2;
    private JLabel jLabel_IL1;
    public CommonQuery()
    {
    	JPanel jpFlight = new JPanel();
    	jpFlight.setBorder(new TitledBorder("按航班号查询"));
    	flightField.setPreferredSize(new java.awt.Dimension(63, 20));
    	jcbFlight.setPreferredSize(new java.awt.Dimension(88, 23));
    	JPanel jpAirFirm = new JPanel();
    	jpAirFirm.setBorder(new TitledBorder("按航空公司查询"));
    	jcbAirFirm.setPreferredSize(new java.awt.Dimension(161, 23));
    	{
    		jLabel_IL1 = new JLabel("请选择要查询的航空公司名称:");
    		jpAirFirm.add(jLabel_IL1);
    		jLabel_IL1.setPreferredSize(new java.awt.Dimension(194, 15));
    		jLabel_IL1.setName("jLabel_IL1");
    		jpAirFirm.add(jcbAirFirm);
    		jpAirFirm.add(jbAirFirmQuery);
    	}
    	JPanel jp1 = new JPanel();
    	jcb1.setPreferredSize(new java.awt.Dimension(168, 23));
    	{
    		jLabel_IL2 = new JLabel("请选择想要到达的目的地:");
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
    	jp2.add(new JLabel("出发城市:"));
    	jp2.add(jcbStart);
    	jp2.add(new JLabel("抵达城市:"));
    	jp2.add(jcbArrive);
    	jp2.add(jbPlaceQuery2);
    	JPanel jpPlace2 = new JPanel();
    	jpPlace2.setLayout(new BorderLayout());
    	jpPlace2.add(new JLabel("请选择起始城市和抵达城市进行查询:"),BorderLayout.CENTER);
    	JPanel jpDestin = new JPanel();
    	jpDestin.setBorder(new TitledBorder("按目的地查询"));
    	jpDestin.setLayout(new BorderLayout());
    	jpDestin.add(jpPlace1,BorderLayout.NORTH);	
    	this.setLayout(new BorderLayout());
    	this.setPreferredSize(new java.awt.Dimension(499, 254));
    	this.add(jpFlight,BorderLayout.NORTH);
    	jpFlight.setPreferredSize(new java.awt.Dimension(499, 90));
    	{
    		jLabel_IL = new JLabel("请输入航班号或从列表选择:");
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
    //更新下拉列表框信息
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
    	if (e.getSource() == jbFlightQuery)//按航班号查询
    	{
    		this.flightNumber = flightField.getText().trim();	
			if (flightNumber.length() == 0)
			{
				JOptionPane.showMessageDialog(null,"请输入航班号或者从列表中选择",
				                              "错误信息",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			executeFlightQuery();
    	}
    	
    	else if (e.getSource() == jbAirFirmQuery)//按航空公司名称查询
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
    		   //得到起始地
    		start = (String)jcbStart.getSelectedItem();
    		start = start.trim();
    		   //得到目的地
    		arrive = (String)jcbArrive.getSelectedItem();
    		arrive = arrive.trim();
    		executeDestinQuery(2);//按目的地查询
    	}    	
    }
    public void executeFlightQuery()//按航班号查询
	{
		String sqlString = "SELECT DISTINCT * FROM " +
		                   "flightTick " +
		                   "WHERE flight=" + "\'" + flightNumber + "\'";
	    ResultSet rs = DbBean.executeQuery(sqlString);		        
	    if (rs != null)
	    {
	        String result = "                                                    " + 
			                "航班号查询"; 
			result += "查询的航班号:" + flightNumber + "\n";      
	        result += formResult(rs);    	
	        
	           //显示结果
	        showResult(result);
	    }	
	    else 
	       JOptionPane.showMessageDialog(null,"未查询到数据!",
	                                    "错误信息",JOptionPane.ERROR_MESSAGE);
	    try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
  //按航空公司名称查询
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
			                "航空公司查询"; 
			result += "查询的航空公司:" + airfirm + "\n";     
	        result += formResult(rs);    	
	        
	           //显示查询结果
	        showResult(result);
        }	       
	    else 
	       JOptionPane.showMessageDialog(null,"未查询到数据!",
	                                    "错误信息",JOptionPane.ERROR_MESSAGE);
	    try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executeDestinQuery(int flag)//按目的地查询
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
		                "目的地查询 " + "\n";
        	   //区分两种类型的查询
			if (flag == 1)
			   result += "到达 " + destination + " 的所有航班:" + "\n";
			else
			   result += "始发地: " + start + "---" + "目的地: " + arrive + "\n";
			   
			result += formResult(rs);
			   
			showResult(result);
        }
	       
	    else 
	       JOptionPane.showMessageDialog(null,"未查到数据!",
	                                    "错误信息",JOptionPane.ERROR_MESSAGE);  
        try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	public String formResult(ResultSet rs)
	{
		String result = "航班号    航空公司       起飞地点  抵达地点  起飞时间  抵达时间  " + 
		                "儿童票价   成人票价   折扣    班期 " + "\n";
		   
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
			          "未找到航班信息!" + "\n";
		}	
		
		return result;
	}
	
	//显示对话框
    public void showResult(String result)
    {
    	JOptionPane.showMessageDialog(null,result,"查询结果",JOptionPane.PLAIN_MESSAGE);
    }          
	
	//更改时间格式
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