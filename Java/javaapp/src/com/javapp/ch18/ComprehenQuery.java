package com.javapp.ch18;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

/**
 * Description:�ۺ���Ϣ��ѯ��
 * 

 */
public class ComprehenQuery extends JPanel implements ActionListener,ItemListener
{
	   //���ݿ������
	static DataBaseManager DbBean = new DataBaseManager();

	   //����ص� comboboxģ��
    private static DefaultComboBoxModel modelPlace = new DefaultComboBoxModel();   
       //���庽�չ�˾comboboxģ��
    private static DefaultComboBoxModel modelAirFirm = new DefaultComboBoxModel();
    private static Object[] year = {"2008","2009","2010"};
 	private static Object[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
 	private static Object[] day = {"1","2","3","4","5","6","7","8","9","10","11","12",
 	                               "13","14","15","16","17","18","19","20","21","22",
 	                               "23","24","25","26","27","28","29","30","31"}; 	                        
 	                         	
 	private  static JComboBox jcbStart = new JComboBox(),jcbFirstArrive = new JComboBox(),
 	                          jcbArrive = new JComboBox(),jcbAirFirm = new JComboBox(modelAirFirm),
 	                          jcbYear1 = new JComboBox(year),jcbYear2 = new JComboBox(year),
 	                          jcbMonth2 = new JComboBox(month),jcbMonth1 = new JComboBox(month),
 	                          jcbDay1 = new JComboBox(day),jcbDay2 = new JComboBox(day);
 	                   
 	private JRadioButton jrbSingle = new JRadioButton("����",true),
 	                     jrbDouble = new JRadioButton("����",false),
 	                     jrbMutiple = new JRadioButton("����",false);
 	   //���嶯̬��ʾ��ǩ
 	private JLabel jlStart,jlFirstArrive,jlArrive,
 	               jlTime1,jlTime2,jlAirFirm,
 	               jlReplaceArrive,jlReplaceTime;
    private JPanel jpFirstArriveBox,jpTime2Box,jpReplaceArrive,jpArrive1,jpReplaceTime,jpTime2; 
    private JButton jbQuery = new JButton("��ѯ");
    
       //�� combobox��ֵ�ı�ʱ��Ҫˢ��ֵ
    private String start,firstArrive,arrive,leaveWeek,leaveWeek2,backWeek,airFirm,
                   leaveYear,leaveMonth,leaveDay,backYear,backMonth,backDay,
                   leaveYear2,leaveMonth2,leaveDay2;
      
    public ComprehenQuery()
    {   
        jcbAirFirm.addItem("����");
        jcbAirFirm.setSelectedItem("����");

    	setDisplayPresentTime();
    	JPanel jp1 = new JPanel();
    	jp1.add(jrbSingle);
    	JPanel jp2 = new JPanel();
    	jp2.add(jrbDouble);
    	JPanel jp3 = new JPanel();
    	jp3.add(jrbMutiple);    	
    	JPanel jpRadioButton = new JPanel();
    	jpRadioButton.setLayout(new GridLayout(5,1)); 
    	jpRadioButton.add(new JLabel(" "));   	
    	jpRadioButton.add(jp1);
    	jpRadioButton.add(jp2);
    	jpRadioButton.add(jp3);
    	jpRadioButton.add(new JLabel(" "));
    	ButtonGroup bg = new ButtonGroup();
    	bg.add(jrbSingle);
    	bg.add(jrbDouble);
    	bg.add(jrbMutiple);
    	JPanel jpStart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	jpStart.add(jlStart = new JLabel("��������:"));    	
    	JPanel jpFirstArrive = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	jpFirstArrive.add(jlFirstArrive = new JLabel("                "));
    	JPanel jpArrive = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	jpArrive.add(jlArrive = new JLabel("�������:"));
    	
    	JPanel jpTime1Tip = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	jpTime1Tip.add(jlTime1 = new JLabel("��������:"));
    	
    	JPanel jpTime2Tip = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	jpTime2Tip.add(jlTime2 = new JLabel(""));
    	
    	JPanel jpAirFirm = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	jpAirFirm.add(jlAirFirm = new JLabel("���չ�˾:"));
    	JPanel jpLabels = new JPanel();
    	jpLabels.setLayout(new GridLayout(7,1));    	
    	jpLabels.add(jpStart);
    	jpStart.setPreferredSize(new java.awt.Dimension(72, 27));
    	jpLabels.add(jpFirstArrive);
    	jpLabels.add(jpArrive);
    	jpLabels.add(jpTime1Tip);
    	jpLabels.add(jpTime2Tip);
    	jpLabels.add(jpAirFirm);
    	jpLabels.add(new JLabel(" "));           
        JPanel jpStartBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpStartBox.add(jcbStart);
        jcbStart.setPreferredSize(new java.awt.Dimension(92, 22));
        jpReplaceArrive = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpReplaceArrive.add(jlReplaceArrive = new JLabel("            "));
    	
    	jpArrive1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpArrive1.add(jcbFirstArrive);
    	jcbFirstArrive.setPreferredSize(new java.awt.Dimension(94, 22));

        jpFirstArriveBox = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
    	jpFirstArriveBox.add(jpReplaceArrive); 	   
    	  
    	JPanel jpArriveBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpArriveBox.add(jcbArrive);
    	jcbArrive.setPreferredSize(new java.awt.Dimension(96, 22));

    	JPanel jpTime1Box = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpTime1Box.add(jcbYear1);
    	jpTime1Box.add(jcbMonth1);
    	jpTime1Box.add(jcbDay1);
    	
    	jpReplaceTime = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpReplaceTime.add(jlReplaceTime = new JLabel("  ")); 
    	
    	jpTime2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpTime2.add(jcbYear2);
    	jpTime2.add(jcbMonth2);
    	jpTime2.add(jcbDay2);
    	
    	jpTime2Box = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
    	jpTime2Box.add(jpReplaceTime);  	  	 	
    	    
    	JPanel jpAirFirmBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpAirFirmBox.add(jcbAirFirm);
    	jcbAirFirm.setPreferredSize(new java.awt.Dimension(101, 22));

    	JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	jpButton.add(jbQuery);
    	
    	JPanel jpComboBox = new JPanel();
    	jpComboBox.setLayout(new GridLayout(7,1));    
    	jpComboBox.add(jpStartBox);
    	jpComboBox.add(jpFirstArriveBox);
    	jpComboBox.add(jpArriveBox);
    	jpComboBox.add(jpTime1Box);
    	jpComboBox.add(jpTime2Box);
    	jpComboBox.add(jpAirFirmBox);
    	jpComboBox.add(jpButton);
        
        JPanel jpQuery = new JPanel();
        jpQuery.setLayout(new BorderLayout());
        jpQuery.add(jpLabels,BorderLayout.WEST);
        jpQuery.add(jpComboBox,BorderLayout.CENTER);
        
        JPanel jpDown = new JPanel();
        jpDown.setLayout(new BorderLayout());
        jpDown.add(jpRadioButton,BorderLayout.WEST);
        jpRadioButton.setPreferredSize(new java.awt.Dimension(59, 224));
        jpDown.add(jpQuery,BorderLayout.CENTER);
        
        this.setLayout(new BorderLayout());
        this.add(jpDown,BorderLayout.CENTER);;
        jrbSingle.addActionListener(new RadioListener());
        jrbDouble.addActionListener(new RadioListener());
        jrbMutiple.addActionListener(new RadioListener());
           //�������б������¼�
        jcbYear1.addItemListener(this);
        jcbYear2.addItemListener(this);
        jcbMonth1.addItemListener(this);
        jcbMonth2.addItemListener(this);
           //���ھ�����¼�
        jbQuery.addActionListener(this);    	
    }
    
    public static void updatePlaceComboBox(String newPlace,int insertOrDelete)
    {
    	if (insertOrDelete == 1)
    	{
    		if (modelPlace.getIndexOf(newPlace) == -1)
    		{
	    		modelPlace.addElement(newPlace);
	    		jcbStart.addItem(newPlace);	
	    		jcbFirstArrive.addItem(newPlace);	
	    		jcbArrive.addItem(newPlace);	
    		}
	    	
    	}
    	else if (insertOrDelete == 2)
    	{
    		if (modelPlace.getIndexOf(newPlace) != -1)
    		{
	    		modelPlace.removeElement(newPlace);
	    		jcbStart.removeItem(newPlace);
	    		jcbFirstArrive.removeItem(newPlace);
	    		jcbArrive.removeItem(newPlace);	
    		}    		
    	}   	
    }
    
    public static void updateAirFirmComboBox(String newAirFirm,int insertOrDelete)
    {
    	if (insertOrDelete == 1)
    	{
    		if (modelAirFirm.getIndexOf(newAirFirm) == -1)
    		   jcbAirFirm.addItem(newAirFirm);
    	}
    	   
    	else if (insertOrDelete == 2)
    	{
    		if (modelAirFirm.getIndexOf(newAirFirm) != -1)
	    	   jcbAirFirm.removeItem(newAirFirm);
    	}
    	   
    }
     //��ʾ��ǰʱ��
    public void setDisplayPresentTime()
    {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new java.util.Date());
    	String year = String.valueOf(cal.get(Calendar.YEAR));
    	String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
    	String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    	jcbYear1.setSelectedItem(year);
    	jcbYear2.setSelectedItem(year);
    	jcbMonth1.setSelectedItem(month);
    	jcbMonth2.setSelectedItem(month);
    	updateDay(year,month,jcbDay1);
    	updateDay(year,month,jcbDay2);    	
    	jcbDay1.setSelectedItem(day);
    	jcbDay2.setSelectedItem(day);    	
    }
    private void updateDay(String year,String month,JComboBox jcb)
    {
    	 
    	if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11"))    	   
    	{
    		if (jcb.getItemCount() == 31)
    		   jcb.removeItem("31");	
    		else if(jcb.getItemCount() == 29)    		
    		   jcb.addItem("30");    	
    		else if (jcb.getItemCount() == 28)
    		{
    			jcb.addItem("29");
    			jcb.addItem("30");
    		}    	
    	}
    	   //2��
    	else if (month.equals("2"))
    	{
    		int years = Integer.parseInt(year);
    		   //�Ƿ�����
    		if ( (years % 400 == 0) || (years %4 == 0 && years % 100 != 0))
    		{
    			if (jcb.getItemCount() == 31)
    			{
    				jcb.removeItem("30");
    			    jcb.removeItem("31");    		    			
    			}
    			else if (jcb.getItemCount() == 30)
    			{
    				jcb.removeItem("30");
    			}
    			else if (jcb.getItemCount() == 28)
    			{
    				jcb.addItem("29");
    			}
    		}
    		else 
    		{
    			if (jcb.getItemCount() == 29)
    			{
    				jcb.removeItem("29");
    			}
    			else if (jcb.getItemCount() == 30)
    			{
    				jcb.removeItem("29");
    				jcb.removeItem("30");
    			}
    			else if (jcb.getItemCount() == 31)
    			{
    				jcb.removeItem("29");
    				jcb.removeItem("30");
    				jcb.removeItem("31");
    			}
    		}
    	}	
    	else 
    	{
    		if (jcb.getItemCount() == 28)
    		{
    		    jcb.addItem("29");
    		    jcb.addItem("30");
    		    jcb.addItem("31");	
    		}
    		else if (jcb.getItemCount() == 29)
    		{
    			jcb.addItem("30");
    			jcb.addItem("31");    			
    		}
    		else if (jcb.getItemCount() == 30)
    		{
    			jcb.addItem("31");
    		}    		
    	}
    }
    
       //�����б��״̬�ı��¼�
    public void itemStateChanged(ItemEvent e)
    {
    	if (e.getSource() == jcbYear1 || e.getSource() == jcbMonth1)
    	{
    		String year = (String)jcbYear1.getSelectedItem();
    		String month = (String)jcbMonth1.getSelectedItem();    		
    		   
    		updateDay(year,month,jcbDay1);
    	}
    	if (e.getSource() == jcbYear2 || e.getSource() == jcbMonth2)
    	{
    		String year = (String)jcbYear2.getSelectedItem();
    		String month = (String)jcbMonth2.getSelectedItem();
    		updateDay(year,month,jcbDay2);
    	}
    }
    
    class RadioListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{	  
    		if (jrbSingle.isSelected())//ѡ�񵥳�
    		{
    			jlFirstArrive.setText(" ");
    			jpFirstArriveBox.removeAll(); 
    			jpFirstArriveBox.add(jpReplaceArrive);
    			jpFirstArriveBox.repaint();
    			jlArrive.setText("�������:");
    			jlTime1.setText("��������:");
    			jlTime2.setText("");
    			
    			jpTime2Box.removeAll();
    			jpTime2Box.add(jpReplaceTime); 
    			jpTime2Box.repaint();  			
    		}
    
    		else if(jrbDouble.isSelected())//ѡ������
    		{
    			jlFirstArrive.setText("");
    			jpFirstArriveBox.removeAll();
    			jpFirstArriveBox.add(jpReplaceArrive);
    			jpFirstArriveBox.repaint();
    			
    			jlArrive.setText("�������:");    			
    			jlTime1.setText("��������:");
    			jlTime2.setText("��������:");
    			
    			jpTime2Box.removeAll();
    			jpTime2Box.add(jpTime2);
    			jpTime2Box.repaint();
    		}
    		   //ѡ������
    		else if (jrbMutiple.isSelected())
    		{
    			jlFirstArrive.setText("��һ�������:");
    			jpFirstArriveBox.removeAll();
    			jpFirstArriveBox.add(jpArrive1);
    			jpFirstArriveBox.repaint();
    			
    			jlArrive.setText("�ڶ��������:");
    			jlTime1.setText("��һ��������:");
    			jlTime2.setText("�ڶ���������:");
    			
    			jpTime2Box.removeAll();
    			jpTime2Box.add(jpTime2);
    			jpTime2Box.repaint();
    		}    		
    	}
    }
    
       //��ѯ
    public void actionPerformed(ActionEvent e)
    {
    
        if (jrbSingle.isSelected())
        {
        	start = (String)jcbStart.getSelectedItem();//�õ���ɵ�
        	start = start.trim();
        	arrive = (String)jcbArrive.getSelectedItem();   //�õ�Ŀ�ĵ�
        	arrive = arrive.trim();
        	leaveYear = (String)jcbYear1.getSelectedItem();//�õ����ʱ��
        	leaveMonth = (String)jcbMonth1.getSelectedItem();
        	leaveDay = (String)jcbDay1.getSelectedItem();
        	
        	   //�ж�ʱ����Ч��
        	if (!isTimeValid(leaveYear,leaveMonth,leaveDay))
        	{
        		JOptionPane.showMessageDialog(null,"�Ѿ����˳���ʱ��,�������趨����ѯ",
        		                              "������Ϣ",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	
        	  
        	   // �õ���ǰ���������ڼ�,��"2008,12,24" ת����ֵ��3(������)
        	leaveWeek = timeToWeek(leaveYear,leaveMonth,leaveDay);
        	airFirm = (String)jcbAirFirm.getSelectedItem();   //�õ����չ�˾
        	airFirm = airFirm.trim();
        	executeSingleQuery();   //���в�ѯ
        }
           //ѡ������
        else if(jrbDouble.isSelected())
        {
        	start = (String)jcbStart.getSelectedItem();
        	start = start.trim();        	   
        	
        	arrive = (String)jcbArrive.getSelectedItem();
        	arrive = arrive.trim();
        	leaveYear = (String)jcbYear1.getSelectedItem();
        	leaveMonth = (String)jcbMonth1.getSelectedItem();
        	leaveDay = (String)jcbDay1.getSelectedItem();
        	backYear = (String)jcbYear2.getSelectedItem();
        	backMonth = (String)jcbMonth2.getSelectedItem();
            backDay = (String)jcbDay2.getSelectedItem();
        	if (!isTimeValid(leaveYear,leaveMonth,leaveDay))
        	{
        		JOptionPane.showMessageDialog(null,"�Ѿ����˳���ʱ��,�������趨����ѯ",
        		                              "������Ϣ",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	
        	if (!isTimeValid(leaveYear,leaveMonth,leaveDay,backYear,backMonth,backDay))
        	{
        		JOptionPane.showMessageDialog(null,"�������ڲ��ܱȳ���������,�������趨����ѯ",
        		                              "������Ϣ",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	leaveWeek = timeToWeek(leaveYear,leaveMonth,leaveDay);
        	backWeek = timeToWeek(backYear,backMonth,backDay);
        	
        	airFirm = (String)jcbAirFirm.getSelectedItem();
        	airFirm = airFirm.trim();
        	executeDoubleQuery();
        }
           //���̲�ѯ
        else if (jrbMutiple.isSelected())
        {
        	start = (String)jcbStart.getSelectedItem();
        	start = start.trim();
        	firstArrive = (String)jcbFirstArrive.getSelectedItem();
        	firstArrive = firstArrive.trim();
        	arrive = (String)jcbArrive.getSelectedItem();
        	arrive = arrive.trim();
        	leaveYear = (String)jcbYear1.getSelectedItem();
        	leaveMonth = (String)jcbMonth1.getSelectedItem();
        	leaveDay = (String)jcbDay1.getSelectedItem();
        	leaveYear2 = (String)jcbYear2.getSelectedItem();
        	leaveMonth2 = (String)jcbMonth2.getSelectedItem();
        	leaveDay2 = (String)jcbDay2.getSelectedItem();
        	if (!isTimeValid(leaveYear,leaveMonth,leaveDay))
        	{
        		JOptionPane.showMessageDialog(null,"�Ѿ����˳���ʱ��,�������趨����ѯ",
        		                              "������Ϣ",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	
        	if (!isTimeValid(leaveYear,leaveMonth,leaveDay,leaveYear2,leaveMonth2,leaveDay2))
        	{
        		JOptionPane.showMessageDialog(null,"�������ڲ��ܱȳ���������,�������趨����ѯ",
        		                              "������Ϣ",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	
        	leaveWeek = timeToWeek(leaveYear,leaveMonth,leaveDay);
        	leaveWeek2 = timeToWeek(leaveYear2,leaveMonth2,leaveDay2);
        	airFirm = (String)jcbAirFirm.getSelectedItem();
        	airFirm = airFirm.trim();
        	executeMutipleQuery();
        }        	
    }  
    
    private boolean isTimeValid(String year,String month,String day)
    {
    	int y = Integer.parseInt(year);
    	int m = Integer.parseInt(month);
    	int d = Integer.parseInt(day);
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new java.util.Date());
    	int py = cal.get(Calendar.YEAR);
    	int pm = cal.get(Calendar.MONTH) + 1;
    	int pd = cal.get(Calendar.DAY_OF_MONTH);
    	
    	if (y == py)
    	{
    		if (m < pm)
    		   return false;
    		else if(d < pd)
    		   return false;
    	}
    	
    	return true;
    }  
    
    private boolean isTimeValid(String year1,String month1,String day1,
                                String year2,String month2,String day2)
    {
    	int y1 = Integer.parseInt(year1);
    	int m1 = Integer.parseInt(month1);
    	int d1 = Integer.parseInt(day1);
    	
    	int y2 = Integer.parseInt(year2);
    	int m2 = Integer.parseInt(month2);
    	int d2 = Integer.parseInt(day2);
    	
    	if (y1 < y2)
    	   return true;
    	else if (y1 == y2)
    	{
    		if (m1 < m2)
    		   return true;
    		else if (m1 == m2)
    		{
    			if (d1 < d2)
    			   return true;
    			else if (d1 == d2)
    			   return true;
    			else 
    			   return false;
    		}
    		else 
    		   return false;
    	}
    	else 
    	   return false;
    }    
    
    // �õ���ǰ���������ڼ�,��"2008,12,24" ת����ֵ��3(������)
    private String timeToWeek(String year,String month,String day)
    {
    	java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(java.sql.Date.valueOf(year + "-" + month + "-" + day));
		int week = cal.get(java.util.Calendar.DAY_OF_WEEK_IN_MONTH);
       return String.valueOf(week);                  	    
    }
       //The query method for the one way query mode
    public void executeSingleQuery()
    {
    	String sqlString = formSQLString(start,arrive);    	   
        ResultSet rs = DbBean.executeQuery(sqlString);
        if (rs != null)
	    {
	        String result = "" + 
			                "�ۺϲ�ѯ"; 
	        result += formResult(rs,leaveYear,leaveMonth,leaveDay,leaveWeek,start,arrive);    	
	        showResult(result);
	    }	       
	    else 
	       JOptionPane.showMessageDialog(null,"û�����������ݿ�!",
	                                    "������Ϣ",JOptionPane.ERROR_MESSAGE);           
        try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }

    public void executeDoubleQuery()
    {
    	String sqlString1 = formSQLString(start,arrive);        
        ResultSet rs1 = DbBean.executeQuery(sqlString1);
        String sqlString2 = formSQLString(arrive,start);    	         
        ResultSet rs2 = DbBean.executeQuery(sqlString2);
        
        if ( (rs1 != null) || (rs2 != null))
	    {
	    	String result = "   " + 
		                    "�ۺϲ�ѯ ";
			
	        result += formDoubleResult(rs1,rs2);    	
	        
	        showResult(result);
	    }
	    else 
	       JOptionPane.showMessageDialog(null,"û�����������ݿ�!",
	                                    "������Ϣ",JOptionPane.ERROR_MESSAGE);       
        try {
			rs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
       //���̲�ѯ
    public void executeMutipleQuery()
    {

    	String sqlString1 = formSQLString(start,firstArrive);  	         
        ResultSet rs1 = DbBean.executeQuery(sqlString1);
        String sqlString2 = formSQLString(firstArrive,arrive); 	         
        ResultSet rs2 = DbBean.executeQuery(sqlString2);
        
        if ((rs1 != null) || (rs2 != null))
	    {
	    	String result = "   " + 
		                    "�ۺϲ�ѯ                                                 ";
			
	        result += formMutipleResult(rs1,rs2);    	
	        showResult(result);
	    }
	    else 
	       JOptionPane.showMessageDialog(null,"û�����������ݿ�!",
	                                    "������Ϣ",JOptionPane.ERROR_MESSAGE);        
        try {
			rs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public String formSQLString(String begin,String end)
    {
    	String sqlString = "SELECT DISTINCT * FROM " + "flightTick " +    	
						   "WHERE start=" + "\'" + begin + "\'" + " AND " +
			               "destination=" + "\'" + end + "\'";			           	
    	                
    	if (!airFirm.equals("����"))
    	   sqlString += " AND " + "airFirm=" + "\'" + airFirm + "\'";
    	   
    	return sqlString;
    }
    
       //��ʽ����ѯ���
    public String formResult(ResultSet rs,String year,String month,String day,
                                          String week,String begin,String end)
    {		
		String result = "";
		String weekDay = dayOfWeek(week);
		result += "\n" + "����:" + year + "��" + month + "��" + day + "��" +	
		          "(����" + weekDay + ")  " + begin + "----" + end + "\n"; 
		                  
		result += "�����    ���չ�˾            ��ɵص�  �ִ�ص�  ���ʱ��  �ִ�ʱ��  " + 
		          "��ͯƱ��   ����Ʊ��   �ۿ�   ���� " + "\n";
		int originLength = result.length();
		String time1,time2;
		String childFare,adultFare,discount1,discount2,seat;
		
		try
		{	
		    String tempResult = "";
		    String tempWeek;
			while(rs.next())
			{			
				tempResult = rs.getString("flight") + rs.getString("airfirm") + rs.getString("start") + 
				             rs.getString("destination");
				time1 = rs.getString("leaveTime");
				time2 = rs.getString("arriveTime");
				time1 = getTime(time1);
				time2 = getTime(time2);
				tempResult += time1 + "     " + time2  + "     ";
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
				tempWeek = rs.getString("week");
		        tempResult += childFare + adultFare + discount1 +
				              tempWeek;
				tempResult += "\n";

				if (tempWeek.indexOf(week) != -1)
				   result += tempResult;							
			}
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		if (result.length() == originLength)
		{
			result += "  " +
			          "δ�ҵ�����Ҫ�ĺ�����Ϣ!" + "\n";
		}	
		
		return result;
    } 
    
       //ת��ʱ���ʽ
    private String getTime(String time)
	{
		String time1,time2;
		time1 = time.substring(0,2);
		time2 = time.substring(2,4);
		
		time1 = time1.concat(":");
		time1 = time1.concat(time2);
		
		return time1;
	}
	 //�õ��ܵ���������
    private String dayOfWeek(String weekNum)
    {
    	String week = "";
    	int num = Integer.parseInt(weekNum);
		switch(num)
		{
			case 1:
             week = "һ";
             break;            
          case 2:
             week = "��";
             break;
          case 3:
             week = "��";
             break;
          case 4:
             week = "��";
             break;
          case 5:
             week = "��";
             break;
          case 6:
             week = "��";
             break;
          case 7:
             week = "��";
             break;
		}
		
		return week;
    }   
    //��ʽ���������
    public String formDoubleResult(ResultSet rs1,ResultSet rs2)
    {
    	String result1 = formResult(rs1,leaveYear,leaveMonth,leaveDay,leaveWeek,start,arrive);
    	String result2 = formResult(rs2,backYear,backMonth,backDay,backWeek,arrive,start);
    	
    	String result = result1 + result2;
    	return result;
    }
    
       //��ʽ�����̽��
    public String formMutipleResult(ResultSet rs1,ResultSet rs2)
    {
    	String result1 = formResult(rs1,leaveYear,leaveMonth,leaveDay,leaveWeek,start,firstArrive);
    	String result2 = formResult(rs2,leaveYear2,leaveMonth2,leaveDay2,leaveWeek2,firstArrive,arrive);
    	
    	String result = result1 + result2;
    	return result;
    }
    
       //��ʾ��ѯ�Ի���
    public void showResult(String result)
    {
    	JOptionPane.showMessageDialog(null,result,"��ѯ���",JOptionPane.PLAIN_MESSAGE);
    }         
}