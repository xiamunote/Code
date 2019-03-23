package flightSeat;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import DB.DataBaseManager;
import flightTicket.WriteInformation;
import flightView.JTextFieldHintListener;

public class SeatView extends JFrame implements  MouseListener
{
	JTable table;
	String flightNumber;
	String seat;
	public SeatView(String flightNumber)
	{
		this.flightNumber = flightNumber;
		JFrame f = new JFrame("机票预订系统");
		f.setLocation(300,80);
		f.setSize(300, 400);
		f.setLayout(new BorderLayout());
	    JPanel jp= new JPanel(null);
//	    jp.setBounds(100, 60, 600, 180);
//	    jp.setLayout(new BorderLayout());
	    ResultSet rs = null;
	    String sqlString = ("select 座位号,座位是否被预订  from 座位信息表  where 航班号 ='" + flightNumber + "'");
	    rs = DataBaseManager.executeQuery(sqlString);
	    AbstractTableModel tm;
		final String[] title = { "座位号","座位类别" ,"座位是否被预订"};
		JScrollPane jsp;
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Vector<Vector<String>> vect = new Vector();// 实例化向量
		tm = new AbstractTableModel() {// 实现AbstractTableModel的抽象方法

			private static final long serialVersionUID = 1L;
 
			public int getColumnCount() {
				return title.length;
			}
 
			public int getRowCount() {
				// TODO 自动生成的方法存根
				return vect.size();
			}
 
			public Object getValueAt(int row, int column) {
				// TODO 自动生成的方法存根
				if (!vect.isEmpty())
					return (((Vector<?>) vect.elementAt(row)).elementAt(column));
				else
					return null;
			}
 
			public String getColumnName(int column) {
				return title[column];// 设置表格列名
			}
 
			public void setValueAt(Object value, int row, int column) {
			}
 
			public Class<? extends Object> getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}// 取得所属对象类
 
			public boolean isCellEditable(int row, int column) {
 
				return false;
			}// 设置单元格不可编辑
		};
		table = new JTable(tm);
        table.addMouseListener(this);
		table.setToolTipText("显示所有的数据");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 设置表格调整尺寸模式
		table.setCellSelectionEnabled(false);// 设置单元格选择方式
		table.setShowVerticalLines(true);// 设置是否显示单元格间的分割线
		table.setShowHorizontalLines(true);
 
		jsp = new JScrollPane(table);
	    
	    jp.setVisible(true);
	    f.add(jsp,BorderLayout.WEST);
	    f.add(jp, BorderLayout.EAST);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//设置右上角XX关闭窗口
		vect.removeAllElements();// 初始化向量对象
		tm.fireTableStructureChanged();// 更新表格内容
		try {
			int i=0;
			while (rs.next()) {
				@SuppressWarnings("rawtypes")
//				Vector<Comparable> v = new Vector<Comparable>();

				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				if(i < 8)
				{
					v.add("头等舱");
				}
				else
				{
					v.add("经济舱");
				}
				i++;
				v.add(rs.getString(2));
				vect.add(v);
				tm.fireTableStructureChanged();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
	    // TODO Auto-generated method stub
	    int row = table.getSelectedRow();
	    String value = "您选择的座位号是"+(String) table.getValueAt(row, 0);
	    JOptionPane.showMessageDialog(null, value);
	    seat = (String) table.getValueAt(row, 0);
	    WriteInformation wf = new WriteInformation(seat,flightNumber);
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO 自动生成的方法存根
		
	}
	
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO 自动生成的方法存根
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO 自动生成的方法存根
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO 自动生成的方法存根
		
	}
	
	public String getSeat()
	{
		return this.seat;
	}
	
	public String getFlightNumber()
	{
		return this.flightNumber;
	}
}
