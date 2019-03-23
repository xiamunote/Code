package view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import system.SqlOperation;
import system.SqlUtil;

public class QueryResult extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int r;
	public  static int allPrice;
	public static JTable table=null;
	private JScrollPane jsp=null;
	private ResultSet rst = null;
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	public static  Vector list =null,	flightInfo =null;
	private ImageIcon buyTicket = new ImageIcon("pic_login\\��Ʊ.png");
	public static String date1,date2,jichang,p;
	public static MyTableModel tableModel;
	public void init()
	{
		date1=null;
		date2=null;
		jichang=null;
		p=null;
		conn=null;
		jsp=null;
		table=null;
		allPrice=0;
		list=null;
		flightInfo=null;
	}
	class MyTableModel extends DefaultTableModel{
		 public MyTableModel(Vector cells,Vector columnNames){
		  super(cells,columnNames);
		 }
		 public Class getColumnClass(int col){//�Զ�����
		  Vector v = (Vector) super.dataVector.elementAt(0);
		  if(v.elementAt(col)!=null){
		   return v.elementAt(col).getClass();
		  }else{
		   return "".getClass();
		  }
		 }
		
		}
	@SuppressWarnings("unchecked")
	public void query() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException {
		

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//���ô������
		conn= SqlUtil.open();
		String kind = Passenger.tickitQueryPanel.c3.getSelectedItem().toString();
		String sql=null;
		flightInfo= new Vector();
		if(Passenger.tickitQueryPanel.c1.getSelectedItem().toString().equals("����")&&kind.equals("ͷ�Ȳ�"))
		{
			sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
					+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, TickitQuery.t3.getText()+"������");
			pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
			pstmt.setString(3, TickitQuery.t2.getText());
		
            rst=pstmt.executeQuery();     
           
			while(rst.next())
			{
			list=new Vector();//����ArrayList���ڴ洢������Ϣ
			list.add(rst.getString("flightID"));
			list.add(rst.getString("fromAddr"));
			list.add(rst.getString("fromTime"));
			list.add(rst.getString("toTime"));
			list.add(rst.getString("firm"));
			list.add(rst.getString("ontimeRate"));
			list.add(rst.getString("toudengNum"));
			list.add(rst.getString("toudengPrice"));
			list.add(buyTicket);
			flightInfo.add(list);
			}
		
		}else if(Passenger.tickitQueryPanel.c1.getSelectedItem().toString().equals("����")&&kind.equals("���ò�")) {
			sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
					+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, TickitQuery.t3.getText()+"������");
			pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
			pstmt.setString(3, TickitQuery.t2.getText());
		
            rst=pstmt.executeQuery();     
           
			while(rst.next())
			{
			list=new Vector();//����ArrayList���ڴ洢������Ϣ
			list.add(rst.getString("flightID"));
			list.add(rst.getString("fromAddr"));
			list.add(rst.getString("fromTime"));
			list.add(rst.getString("toTime"));
			list.add(rst.getString("firm"));
			list.add(rst.getString("ontimeRate"));
			list.add(rst.getString("jingjiNum"));
			list.add(rst.getString("jingjiPrice"));
			list.add(buyTicket);
			flightInfo.add(list);
			}
		}
		else {
			if(kind.equals("ͷ�Ȳ�"))
			{
				sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
						+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ? and firm = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, TickitQuery.t3.getText()+"������");
				pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
				pstmt.setString(3, TickitQuery.t2.getText());
				pstmt.setString(4, (String)TickitQuery.c1.getSelectedItem());
	            rst=pstmt.executeQuery();                
				while(rst.next())
				{
				list=new Vector();//����ArrayList���ڴ洢������Ϣ
				list.add(rst.getString("flightID"));
				list.add(rst.getString("fromAddr"));
				list.add(rst.getString("fromTime"));
				list.add(rst.getString("toTime"));
				list.add(rst.getString("firm"));
				list.add(rst.getString("ontimeRate"));
				list.add(rst.getString("toudengNum"));
				list.add(rst.getString("toudengPrice"));
				list.add(buyTicket);
				flightInfo.add(list);
				}
			
				
			
			}
			else if(kind.equals("���ò�")){
				sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
						+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ? and firm = ? ";//sql��ѯ���
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, TickitQuery.t3.getText()+"������");
				pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
				pstmt.setString(3, TickitQuery.t2.getText());
				pstmt.setString(4, (String)TickitQuery.c1.getSelectedItem());
	            rst=pstmt.executeQuery();                
				while(rst.next())
				{
				list=new Vector();//ÿ�ҵ�һ����¼����newһ��vectorװ����Ϣ
				list.add(rst.getString("flightID"));
				list.add(rst.getString("fromAddr"));
				list.add(rst.getString("fromTime"));
				list.add(rst.getString("toTime"));
				list.add(rst.getString("firm"));
				list.add(rst.getString("ontimeRate"));
				list.add(rst.getString("jingjiNum"));
				list.add(rst.getString("jingjiPrice"));
				list.add(buyTicket);//list���ÿ����¼��������Ϣ
				flightInfo.add(list);//flightInfo���ÿ��list������flightInfo�Ͱ������в�ѯ�����Ϣ
				
			}
		}
		}
		 Vector s = new Vector();//װ��ͷ
		  s.add("�����");
		  s.add("��ɻ���");
		  s.add("���ʱ��");
		  s.add("Ԥ�Ƶ���");
		  s.add("���չ�˾");
		  s.add("׼����");
		  s.add("ʣ��Ʊ��");
		  s.add("�۸�/��");
		  s.add("��Ʊ");//��ӱ�ͷԪ��
	
		tableModel = new MyTableModel(flightInfo,s);//���������ֱ��Ǻ�����Ϣvector�ͱ�ͷvector
		table = new JTable();
		table.setModel(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(690,440));//���ı��Ĭ�ϴ�С
		table.getColumn( "��ɻ���").setMinWidth(120);//�޸���С�п�����ʾȫ��
	 	table.setRowHeight(35);//�����и�
	 	 table.addMouseListener(new MouseAdapter(){
             public void mouseClicked(MouseEvent e) {//������굥��ʱ��Ӧ
                //�õ�ѡ�е����е�����ֵ
              r= table.getSelectedRow();
               int c= table.getSelectedColumn();
               if(c==8)//��Ʊ��һ��
               {
            	   //�õ�ѡ�еĵ�Ԫ���ֵ������ж����ַ���
                   p= (String)table.getValueAt(r, 7);//����
                   int price = Integer.parseInt(p);
                   int num = Integer.parseInt((String)TickitQuery.c2.getSelectedItem());
                   allPrice =price*num;
                   date1=(String)table.getValueAt(r, 2);
                   date2=(String)table.getValueAt(r, 2);
                   jichang=(String)table.getValueAt(r, 1);
                   int m = JOptionPane.showConfirmDialog(null, "����"+allPrice+"Ԫ"+"  �Ƿ�֧��?");
                  
   					if(m==JOptionPane.YES_OPTION){//ȷ��֧��
   					//�˳�ϵͳ
   						String n = JOptionPane.showInputDialog(null,"����������");//����֧������
   						if(n.equals(Login.passPwd))
   						{
   							int leftMoney =SqlOperation.moneySearch(Login.userPassenger);//ʣ�µ�Ǯ
   							
   							if(leftMoney-allPrice>=0)
   							{
   								SqlOperation.moneyUpdata(Login.userPassenger,leftMoney-allPrice);
   								Passenger.personInfo.removeAll();//���������������
   	   							Passenger.personInfo.currentInfo();//ˢ�������˵�
   	   	   						Passenger.ifBuy=true;//�ѹ���״̬
   	   	   						int leftTickit =SqlOperation.tickitNumSearch((String)table.getValueAt(r, 0));//ʣ�µ�Ǯ
   	   	   						if(leftTickit==0)
   	   	   						{
   	   	 							JOptionPane.showMessageDialog(null, "��Ʊ����");
   	   	   						}if(leftTickit==-1)
   	   	   						{
   	   	   							JOptionPane.showMessageDialog(null, "���ݿ��쳣");
   	   	   								System.exit(1);
   	   	   						}
   	   	   						int mm =Integer.parseInt(Passenger.tickitQueryPanel.c2.getSelectedItem().toString());//�����Ʊ��
   	   	   						SqlOperation.tickitNumUpdata((String)table.getValueAt(r, 0),leftTickit-mm);
   	   	   						Passenger.card.show(Passenger.mainPanel, "p3");
   							}else//Ǯ����
   							{
   								JOptionPane.showMessageDialog(null, "����");
   							}
   							
   						}else {
   							JOptionPane.showMessageDialog(null, "�������(Ĭ���ǵ�¼����)");
   						}
  				}
               }
             }
         }); 
		table.getColumn( "���չ�˾").setMinWidth(120);
		jsp = new JScrollPane(); 
		jsp.setViewportView(table);//Ϊ����ʾ��ͷ  ����ֱ��JScrollPane jsp = new JScrollPane(table); 
		add(jsp);//jspװ��table,��jsp��ӵ������
	}
}
