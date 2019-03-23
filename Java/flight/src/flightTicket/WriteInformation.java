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
		Frame f = new Frame("��ƱԤ��ϵͳ");
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
	    jTextField2.addFocusListener(new JTextFieldHintListener(jTextField2, "����������"));
	    jTextField2.setBounds(95,130, 80, 30);
	    f.add(jTextField2);
	    
		JPanel jp3= new JPanel();
		f.add(jp3);
	    JTextField jTextField3 = new JTextField();
	    jTextField3.addFocusListener(new JTextFieldHintListener(jTextField3, "�������Ա�"));
	    jTextField3.setBounds(45,180, 80, 30);
	    f.add(jTextField3);
	    
		JPanel jp4= new JPanel();
		f.add(jp4);
	    JTextField jTextField4 = new JTextField();
	    jTextField4.addFocusListener(new JTextFieldHintListener(jTextField4, "������18λ���֤��"));
	    jTextField4.setBounds(45,230, 80, 30);
	    f.add(jTextField4);
	    
		JPanel jp5= new JPanel();
		f.add(jp5);
	    JTextField jTextField5 = new JTextField();
	    jTextField5.addFocusListener(new JTextFieldHintListener(jTextField5, "������11λ�ֻ���"));
	    jTextField5.setBounds(45,280, 80, 30);
	    f.add(jTextField5);
	    
		JPanel jp6= new JPanel();
		JButton jb = new JButton("ȷ��");
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
	            sqlString = "select count(���֤��) from �ÿ���Ϣ��  where ���֤��  = '" + id +"' ";
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
	            sqlString = ("update ������Ϣ��  set ��Ʊ�� = ��Ʊ�� - 1 where �����  = '" 
	            			+ flightNumber + "' ");
//	            System.out.println(sqlString);
	            int m = DataBaseManager.executeUpdate(sqlString);
	            
	            int n = 0;
	            if(num < 1)
	            {
		            sqlString = "insert into �ÿ���Ϣ��(���֤��,����,�Ա�,�绰)" + 
	        			"values(" + id +",'" + name + "','" + sex + "',"+ telephone + ")" ;
	//	            System.out.println(sqlString);
		             n = DataBaseManager.executeInsert(sqlString);
	            }
	            else
	            {
	            	n = 1;
	            }
	            sqlString = "update ��λ��Ϣ��  set ��λ�Ƿ�Ԥ�� = '��' where �����  = '" 
     				+ flightNumber + "' and ��λ�� = '" + seat +"'";
//	            System.out.println(sqlString);
	            int j = DataBaseManager.executeUpdate(sqlString);
	            
	            int k = 0;
	            int i = 0;
	            try
	            {
	            	rs = DataBaseManager.executeQuery("select max(������) from ��Ʊ��Ϣ��  ");
		            if(rs.next())
	            	{
		            	i = rs.getInt(1);
		            	i = i + 1;
	            	}
//	            	System.out.println(i);
	            }
	            catch (Exception e4) {
	            	System.out.println("������Ϣ���޸Ĳ��ɹ���");
				}
            	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	String time = df.format(new Date());
            	sqlString ="insert into ��Ʊ��Ϣ��(������,���֤��,�����,��λ��,��Ʊʱ��)" + 
            			"values(" + i +"," + id + "," + flightNumber + ",'"
            			+ seat + "','" + time + "')";
//            	System.out.println(sqlString);
            	k = DataBaseManager.executeInsert(sqlString);
	            if(m == n && n == j && j == k && m > 0)
	            {
	            	int h = JOptionPane.showConfirmDialog(null, 
	            			"��Ʊ�ɹ������Ķ������ǣ�"+ i +"��\n"+"���ȷ��������Ʊ,������˳�","��ʾ",JOptionPane.YES_NO_OPTION);
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
	            	int l = JOptionPane.showConfirmDialog(null, "��Ʊ���ɹ�,��˶���Ϣ��"
	            			+ "���ȷ��������Ʊ,������˳�","��ʾ",JOptionPane.YES_NO_OPTION);
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
