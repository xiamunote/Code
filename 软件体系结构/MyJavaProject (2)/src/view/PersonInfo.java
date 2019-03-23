package view;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import system.MyTool;
import system.SqlOperation;

public class PersonInfo extends JPanel{
	public static JLabel l0;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,title=null;
	public PersonInfo()
	{
		
	}
	public void currentInfo()//刷新当前订单状态
	{
		setLayout(null);
		l0=new JLabel();
		l0.setLayout(null);
		l0.setOpaque(true);
		l0.setBounds(170,50,300,400);
		l0.setBorder(BorderFactory.createLineBorder(Color.gray));
		title = new JLabel("我的订单");
		title.setFont(MyTool.getFontB(15));
		title.setOpaque(true);
		title.setForeground(Color.BLUE);
		l1=new JLabel("出发城市               " + Passenger.tickitQueryPanel.t1.getText());//出发
		l1.setBounds(10,40,280,30);
		l2=new JLabel("目的地                  " +Passenger.tickitQueryPanel.t2.getText());//目的地
		l2.setBounds(10,80,280,30);
		l3=new JLabel("乘车时间               " +Passenger.tickitQueryPanel.t3.getText()+"星期三"+QueryResult.date1);
		l3.setBounds(10,120,280,30);
		l4=new JLabel("乘坐机场               " + QueryResult.jichang);
		l4.setBounds(10,160,300,30);
		l5=new JLabel("证件号                   "+ Login.passengerID);
		l5.setBounds(10,200,280,30);
		int num=Integer.parseInt((String)Passenger.tickitQueryPanel.c2.getSelectedItem());
		l6=new JLabel("票价                      " +num+"*"+QueryResult.p +"元");
		l6.setBounds(10,240,280,30);
		String pattern = "yyyyMMddHHmmss";//自定义日期模板
		SimpleDateFormat sdf = new SimpleDateFormat() ;
		sdf.applyPattern(pattern);
		String buyNum=sdf.format(new java.util.Date());//当前Date格式化
		String str="";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
		char c =0;
		c = (char) (random.nextInt(10) + 48);//获取0-9，a-z A-Z任意字符
		str+=c;
		}
		l7=new JLabel("订单号                  "+str+buyNum);
		l7.setBounds(10,280,280,30);
		int myMoney = SqlOperation.moneySearch(Login.userPassenger);
		l8=new JLabel("余额                      " +myMoney + "元");
		l8.setBounds(10,320,280,30);
		title.setBounds(110,10,180,30);
		
	
		add(l0);
		l0.add(title);
		l0.add(l1);
		l0.add(l2);
		l0.add(l3);
		l0.add(l4);
		l0.add(l5);
		l0.add(l6);
		l0.add(l7);
		l0.add(l8);
		
		
		
		
	}
}
