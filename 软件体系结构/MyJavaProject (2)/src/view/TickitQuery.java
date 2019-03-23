package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import system.MyTool;

public class TickitQuery extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel l1,l2,l3,l4,l5,l6,l7=null;
	public static JTextField t1,t2,t3,t4 = null;
	public static ImageIcon wangfan = new ImageIcon("pic_login\\往返.png");
	public static JButton btn = new JButton("一键查询");
	public static JPanel panel1,panel2,panel3,panel4,panel5=null;
	public static ResultSet searchResult=null;
	public static GridLayout g = new GridLayout(7,7);
	int num;
	public static JLabel[] labels= new JLabel[49];
	@SuppressWarnings("rawtypes")
	public static JComboBox c1,c2,c3=null;
	@SuppressWarnings("unchecked")
	public TickitQuery() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		setLayout(null);
		l1=new JLabel("*出发城市");
		l1.setOpaque(true);
		l1.setBounds(50,50,70,30);
		add(l1);
		t1=new JTextField();
		t1.setBounds(130,50,150,30);
		add(t1);
		
		l7=new JLabel("*出发城市");
		l7.setOpaque(true);
		l7.setBounds(295,53,25,25);
		l7.setIcon(wangfan);
		add(l7);
		l7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(t1.getText().length()!=0&&(t2.getText().length()!=0))//当两个框有字才交换
				{
					String temp=t1.getText();
					t1.setText(t2.getText());
					t2.setText(temp);
				}
			}
		});
		
		l2=new JLabel("*到达城市");
		l2.setOpaque(true);
		l2.setBounds(330,50,70,30);
		add(l2);
		t2=new JTextField();
		t2.setBounds(400,50,150,30);
		add(t2);
		
		l3=new JLabel("*出发日期");
		l3.setOpaque(true);
		l3.setBounds(50,200,70,30);
		add(l3);
		t3=new JTextField();
		t3.setBounds(130,200,150,30);
		add(t3);
		t3.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {//获得focus
				panel1.setVisible(true);
			}
			public void focusLost(FocusEvent e) {//失去focus
				// TODO Auto-generated method stub
				panel1.setVisible(false);
			}
			
		});
		l4=new JLabel("*航空公司");
		l4.setOpaque(true);
		l4.setBounds(330,130,70,30);
		add(l4);
		Vector v=new Vector();//可传给ComboBox构造器
		v.addElement("不限");
		v.addElement("中国国航");
		v.addElement("东方航空");
		v.addElement("南方航空");
		v.addElement("吉祥航空公司");
		
		c1=new JComboBox(v);
		c1.setBounds(400,130,150,30);
		add(c1);
		
		l5=new JLabel("*乘客人数");
		l5.setOpaque(true);
		l5.setBounds(50,130,70,30);
		add(l5);
		String[] s = {"1","2","3","4","5","6","7","8","9","10"};
		c2=new JComboBox(s);
		c2.setBounds(130,130,150,30);
		add(c2);
		
		l6=new JLabel("*舱       位");
		l6.setOpaque(true);
		l6.setBounds(330,200,70,30);
		add(l6);
		String[] s2 = {"经济舱","头等舱"};
		c3=new JComboBox(s2);
		c3.setBounds(400,200,150,30);
		add(c3);
		
		btn.setBounds(240, 280, 150, 35);
		add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
						try {
							try {
								Passenger.a.removeAll();//先清除面板所有组件，然后刷新
								Passenger.a.query();//刷新
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				
				Passenger.card.show(Passenger.mainPanel, "p2");
			}
			
		});
		
		panel1 =new JPanel();	
		panel1.setLayout(g);		
		
		labels[0]= new JLabel("一");
		labels[1]= new JLabel("二");
		labels[2]= new JLabel("三");
		labels[3]= new JLabel("四");
		labels[4]= new JLabel("五");
		labels[5]= new JLabel("六");
		labels[6]= new JLabel("日");
		
		panel1.setBounds(20,240,200,200);
		panel1.setBackground(Color.gray);
		for(int i=0;i<7;i++)
		{
			labels[i].setForeground(Color.blue);
			labels[i].setFont(MyTool.getFontB(12));
			panel1.add(labels[i]);
		}		
		 String a[] = new String[42]; //定义一个以字符串数组
		 Calendar calendar = Calendar.getInstance();
		 int year = calendar.get(Calendar.YEAR);
		 int month = calendar.get(Calendar.MONTH )+1;
		  int week = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
		  int dayNum =0;
		  if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			  dayNum = 31;
		  } 
		  if (month == 4 || month == 6 || month == 9 || month == 11) {
			  dayNum = 30;
		  }
		  if (month == 2) {
		   if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			   dayNum = 29;
		   } else {
			   dayNum = 28;
		   }
		  }
		  for (int i = week, n = 1; i < week + dayNum; i++) {
		   a[i] = String.valueOf(n);
		   n++;
		  }
		  
		  if(dayNum==31)
		  {
			  
			  for(num=7;num<38;num++)
				{
				  	String str = String.valueOf(num-6);
					labels[num] = new JLabel(str); 
					labels[num].setOpaque(true);
					labels[num].setCursor(new Cursor(Cursor.HAND_CURSOR)) ;//鼠标指针变为手
					labels[num].addMouseListener(new MouseAdapter() {

						@Override
						public void mouseClicked(MouseEvent arg0) {
							if(arg0.getSource()==labels[7])
							{
								t3.setText(year+"-"+month+"-"+labels[7].getText());
							}else if(arg0.getSource()==labels[8])
							{
								t3.setText(year+"-"+month+"-"+labels[8].getText());
							}
							else if(arg0.getSource()==labels[9])
							{
								t3.setText(year+"-"+month+"-"+labels[9].getText());
							}
							else if(arg0.getSource()==labels[10])
							{
								t3.setText(year+"-"+month+"-"+labels[10].getText());
							}
							else if(arg0.getSource()==labels[11])
							{
								t3.setText(year+"-"+month+"-"+labels[11].getText());
							}
							else if(arg0.getSource()==labels[12])
							{
								t3.setText(year+"-"+month+"-"+labels[12].getText());
							}
							else if(arg0.getSource()==labels[13])
							{
								t3.setText(year+"-"+month+"-"+labels[13].getText());
							}
							else if(arg0.getSource()==labels[14])
							{
								t3.setText(year+"-"+month+"-"+labels[14].getText());
							}
							else if(arg0.getSource()==labels[15])
							{
								t3.setText(year+"-"+month+"-"+labels[15].getText());
							}
							else if(arg0.getSource()==labels[16])
							{
								t3.setText(year+"-"+month+"-"+labels[16].getText());
							}
							else if(arg0.getSource()==labels[17])
							{
								t3.setText(year+"-"+month+"-"+labels[17].getText());
							}
							else if(arg0.getSource()==labels[18])
							{
								t3.setText(year+"-"+month+"-"+labels[18].getText());
							}
							else if(arg0.getSource()==labels[19])
							{
								t3.setText(year+"-"+month+"-"+labels[19].getText());
							}
							else if(arg0.getSource()==labels[20])
							{
								t3.setText(year+"-"+month+"-"+labels[20].getText());
							}
							else if(arg0.getSource()==labels[21])
							{
								t3.setText(year+"-"+month+"-"+labels[21].getText());
							}
							else if(arg0.getSource()==labels[22])
							{
								t3.setText(year+"-"+month+"-"+labels[22].getText());
							}
							else if(arg0.getSource()==labels[23])
							{
								t3.setText(year+"-"+month+"-"+labels[23].getText());
							}
							else if(arg0.getSource()==labels[24])
							{
								t3.setText(year+"-"+month+"-"+labels[24].getText());
							}
							else if(arg0.getSource()==labels[25])
							{
								t3.setText(year+"-"+month+"-"+labels[25].getText());
							}
							else if(arg0.getSource()==labels[26])
							{
								t3.setText(year+"-"+month+"-"+labels[26].getText());
							}
							else if(arg0.getSource()==labels[27])
							{
								t3.setText(year+"-"+month+"-"+labels[27].getText());
							}
							else if(arg0.getSource()==labels[28])
							{
								t3.setText(year+"-"+month+"-"+labels[28].getText());
							}
							else if(arg0.getSource()==labels[29])
							{
								t3.setText(year+"-"+month+"-"+labels[29].getText());
							}
							else if(arg0.getSource()==labels[30])
							{
								t3.setText(year+"-"+month+"-"+labels[30].getText());
							}
							else if(arg0.getSource()==labels[31])
							{
								t3.setText(year+"-"+month+"-"+labels[31].getText());
							}
							else if(arg0.getSource()==labels[32])
							{
								t3.setText(year+"-"+month+"-"+labels[32].getText());
							}
							else if(arg0.getSource()==labels[33])
							{
								t3.setText(year+"-"+month+"-"+labels[33].getText());
							}
							else if(arg0.getSource()==labels[34])
							{
								t3.setText(year+"-"+month+"-"+labels[34].getText());
							}
							else if(arg0.getSource()==labels[35])
							{
								t3.setText(year+"-"+month+"-"+labels[35].getText());
							}
							else if(arg0.getSource()==labels[36])
							{
								t3.setText(year+"-"+month+"-"+labels[36].getText());
							}
							else if(arg0.getSource()==labels[37])
							{
								t3.setText(year+"-"+month+"-"+labels[37].getText());
							}
							
							
							
						}

						
						
					});
					panel1.add(labels[num]);
				}
			  for(int i=38;i<49;i++)
			  {
				  labels[i]=new JLabel();
				  labels[i].setOpaque(true);
				  panel1.add(labels[i]);
			  }
		  }
		  labels[45].setText(year+"");
		  labels[46].setText("  年");
		  labels[47].setText(" "+month);
		  labels[48].setText("月");
		  for(int j=45;j<=48;j++)
		  {
			  labels[j].setFont(MyTool.getFontP(10));
		  }
		 
		add(panel1);
		panel1.setVisible(false);
		
	}
	
}

