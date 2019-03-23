package flightView;

import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import DB.DataBaseManager;
import flightMain.BackgroundPanel;
import flightMain.Main;

public class FlightViews extends Frame
{
	public FlightViews()
	{
		Frame f = new Frame("��ƱԤ��ϵͳ");
		f.setLocation(300,80);
		f.setSize(800, 600);
		BackgroundPanel bgp=new BackgroundPanel((new ImageIcon("D:/�ļ�/���/Java/flight/image/��ҳ.jpg")).getImage()); //������һ��Image����,
	    bgp.setBounds(0,0,400,300);  
	    JPanel jp= new JPanel(null);	
	    jp.setBounds(100, 60, 600, 180);
	  
	    String[] s = {"�人","����","�Ϻ�","����"};
	    JComboBox<String> combol1 = new JComboBox<String>(s);
	    combol1.setBorder(BorderFactory.createTitledBorder("������"));
	    combol1.setBounds(40,20, 150, 50);
	    
	    JComboBox<String> combol2 = new JComboBox<String>(s);
	    combol2.setBorder(BorderFactory.createTitledBorder("Ŀ�ĵ�"));
	    combol2.setBounds(410,20, 150, 50);
	    
	    JTextField jTextField1 = new JTextField();
	    jTextField1.addFocusListener(new JTextFieldHintListener(jTextField1, "�������"));
	    jTextField1.setBounds(45,80, 80, 30);
	    
	    JTextField jTextField2 = new JTextField();
	    jTextField2.addFocusListener(new JTextFieldHintListener(jTextField2, "�����·�"));
	    jTextField2.setBounds(180, 80, 80, 30);
	    
	    JTextField jTextField3 = new JTextField();
	    jTextField3.addFocusListener(new JTextFieldHintListener(jTextField3, "��������"));
	    jTextField3.setBounds(330, 80, 80, 30);
	    
	    JTextField jTextField4 = new JTextField();
	    jTextField4.addFocusListener(new JTextFieldHintListener(jTextField4, "��������"));
	    jTextField4.setBounds(475, 80, 80, 30);
	    
	    
	    JButton jb1=new JButton("��ʱ�������ѯ");  
	    jb1.setBounds(45,130,200,30);
	    jb1.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
	        {
	        	String start = (String)combol1.getSelectedItem();
	        	String end = (String)combol2.getSelectedItem();
	        	String year = jTextField1.getText();
	        	String mouth = jTextField2.getText();
	        	String day = jTextField3.getText();
	        	String number = jTextField4.getText();
	        	String time = (year + "-" + mouth + "-" + day);
	        	String sqlString = ("select �����,��˾ID,��ɵ�,Ŀ�ĵ�,�������,���ʱ��,Ʊ��,��Ʊ�� from ������Ϣ�� "
	        			+ "where ��ɵ�  = '" + start + "' and Ŀ�ĵ� = '" + end + "' and ��Ʊ��  >= '" + number
	        			+"' and �������  = '" + time + "' order by ���ʱ�� ");
//	        	System.out.println(sqlString);
	        	MyFlightTable myTable2 = new MyFlightTable(1,sqlString);
	        }
	    });
	    
	    JButton jb2=new JButton("���۸������ѯ");  
	    jb2.setBounds(360,130,200,30);
	    jb2.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
	        {
	        	String start = (String)combol1.getSelectedItem();
	        	String end = (String)combol2.getSelectedItem();
	        	String year = jTextField1.getText();
	        	String mouth = jTextField2.getText();
	        	String day = jTextField3.getText();
	        	String number = jTextField4.getText();
	        	String time = (year + "-" + mouth + "-" + day);
	        	String sqlString = ("select �����,��˾ID,��ɵ�,Ŀ�ĵ�,�������,���ʱ��,Ʊ��,��Ʊ�� from ������Ϣ�� "
	        			+ "where ��ɵ�  = '" + start + "' and Ŀ�ĵ� = '" + end + "' and ��Ʊ��  > '" + number
	        			+"' and �������  = '" + time + "' order by Ʊ�� ");
	        	MyFlightTable myTable2 = new MyFlightTable(2,sqlString);
	        }
	    });
	   
	    jp.add(combol1);
	    jp.add(combol2);
	    jp.add(jTextField1);
	    jp.add(jTextField2);
	    jp.add(jTextField3);
	    jp.add(jTextField4);
	    jp.add(jb1);
	    jp.add(jb2);
	    f.add(jp);
	    f.add(bgp);
		f.setResizable(false);
		f.setVisible(true);
	    f.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
	    });
	}
}
