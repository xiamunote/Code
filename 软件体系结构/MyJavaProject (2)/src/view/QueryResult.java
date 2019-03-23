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
	private ImageIcon buyTicket = new ImageIcon("pic_login\\订票.png");
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
		 public Class getColumnClass(int col){//自动调用
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
		

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//设置窗口外观
		conn= SqlUtil.open();
		String kind = Passenger.tickitQueryPanel.c3.getSelectedItem().toString();
		String sql=null;
		flightInfo= new Vector();
		if(Passenger.tickitQueryPanel.c1.getSelectedItem().toString().equals("不限")&&kind.equals("头等舱"))
		{
			sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
					+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, TickitQuery.t3.getText()+"星期三");
			pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
			pstmt.setString(3, TickitQuery.t2.getText());
		
            rst=pstmt.executeQuery();     
           
			while(rst.next())
			{
			list=new Vector();//创建ArrayList用于存储航盘信息
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
		
		}else if(Passenger.tickitQueryPanel.c1.getSelectedItem().toString().equals("不限")&&kind.equals("经济舱")) {
			sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
					+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, TickitQuery.t3.getText()+"星期三");
			pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
			pstmt.setString(3, TickitQuery.t2.getText());
		
            rst=pstmt.executeQuery();     
           
			while(rst.next())
			{
			list=new Vector();//创建ArrayList用于存储航盘信息
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
			if(kind.equals("头等舱"))
			{
				sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
						+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ? and firm = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, TickitQuery.t3.getText()+"星期三");
				pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
				pstmt.setString(3, TickitQuery.t2.getText());
				pstmt.setString(4, (String)TickitQuery.c1.getSelectedItem());
	            rst=pstmt.executeQuery();                
				while(rst.next())
				{
				list=new Vector();//创建ArrayList用于存储航盘信息
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
			else if(kind.equals("经济舱")){
				sql = "select flightID,fromAddr,fromTime,toTime,firm,jingjiPrice,toudengPrice,"
						+ "jingjiNum,toudengNum,ontimeRate  from flight where date = ? and beginPlace = ? and destePlace = ? and firm = ? ";//sql查询语句
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, TickitQuery.t3.getText()+"星期三");
				pstmt.setString(2, Passenger.tickitQueryPanel.t1.getText());
				pstmt.setString(3, TickitQuery.t2.getText());
				pstmt.setString(4, (String)TickitQuery.c1.getSelectedItem());
	            rst=pstmt.executeQuery();                
				while(rst.next())
				{
				list=new Vector();//每找到一条记录重新new一个vector装填信息
				list.add(rst.getString("flightID"));
				list.add(rst.getString("fromAddr"));
				list.add(rst.getString("fromTime"));
				list.add(rst.getString("toTime"));
				list.add(rst.getString("firm"));
				list.add(rst.getString("ontimeRate"));
				list.add(rst.getString("jingjiNum"));
				list.add(rst.getString("jingjiPrice"));
				list.add(buyTicket);//list添加每条记录的所有信息
				flightInfo.add(list);//flightInfo添加每条list，这样flightInfo就包含所有查询结果信息
				
			}
		}
		}
		 Vector s = new Vector();//装表头
		  s.add("航班号");
		  s.add("起飞机场");
		  s.add("起飞时间");
		  s.add("预计到达");
		  s.add("航空公司");
		  s.add("准点率");
		  s.add("剩余票数");
		  s.add("价格/单");
		  s.add("订票");//添加表头元素
	
		tableModel = new MyTableModel(flightInfo,s);//两个参数分别是航班信息vector和表头vector
		table = new JTable();
		table.setModel(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(690,440));//更改表的默认大小
		table.getColumn( "起飞机场").setMinWidth(120);//修改最小列宽，以显示全部
	 	table.setRowHeight(35);//设置行高
	 	 table.addMouseListener(new MouseAdapter(){
             public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                //得到选中的行列的索引值
              r= table.getSelectedRow();
               int c= table.getSelectedColumn();
               if(c==8)//订票那一列
               {
            	   //得到选中的单元格的值，表格中都是字符串
                   p= (String)table.getValueAt(r, 7);//单价
                   int price = Integer.parseInt(p);
                   int num = Integer.parseInt((String)TickitQuery.c2.getSelectedItem());
                   allPrice =price*num;
                   date1=(String)table.getValueAt(r, 2);
                   date2=(String)table.getValueAt(r, 2);
                   jichang=(String)table.getValueAt(r, 1);
                   int m = JOptionPane.showConfirmDialog(null, "共计"+allPrice+"元"+"  是否支付?");
                  
   					if(m==JOptionPane.YES_OPTION){//确认支付
   					//退出系统
   						String n = JOptionPane.showInputDialog(null,"请输入密码");//输入支付密码
   						if(n.equals(Login.passPwd))
   						{
   							int leftMoney =SqlOperation.moneySearch(Login.userPassenger);//剩下的钱
   							
   							if(leftMoney-allPrice>=0)
   							{
   								SqlOperation.moneyUpdata(Login.userPassenger,leftMoney-allPrice);
   								Passenger.personInfo.removeAll();//先清除面板所有组件
   	   							Passenger.personInfo.currentInfo();//刷新生成账单
   	   	   						Passenger.ifBuy=true;//已购买状态
   	   	   						int leftTickit =SqlOperation.tickitNumSearch((String)table.getValueAt(r, 0));//剩下的钱
   	   	   						if(leftTickit==0)
   	   	   						{
   	   	 							JOptionPane.showMessageDialog(null, "机票售完");
   	   	   						}if(leftTickit==-1)
   	   	   						{
   	   	   							JOptionPane.showMessageDialog(null, "数据库异常");
   	   	   								System.exit(1);
   	   	   						}
   	   	   						int mm =Integer.parseInt(Passenger.tickitQueryPanel.c2.getSelectedItem().toString());//购买的票数
   	   	   						SqlOperation.tickitNumUpdata((String)table.getValueAt(r, 0),leftTickit-mm);
   	   	   						Passenger.card.show(Passenger.mainPanel, "p3");
   							}else//钱不够
   							{
   								JOptionPane.showMessageDialog(null, "余额不足");
   							}
   							
   						}else {
   							JOptionPane.showMessageDialog(null, "密码错误(默认是登录密码)");
   						}
  				}
               }
             }
         }); 
		table.getColumn( "航空公司").setMinWidth(120);
		jsp = new JScrollPane(); 
		jsp.setViewportView(table);//为了显示表头  或者直接JScrollPane jsp = new JScrollPane(table); 
		add(jsp);//jsp装有table,将jsp添加到主面板
	}
}
