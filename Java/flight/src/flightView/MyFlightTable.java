package flightView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DB.DataBaseManager;
import flightSeat.SeatView;

public class MyFlightTable extends JFrame implements  MouseListener
{
	private JFrame J;
	private DefaultTableModel model;
	private JTable table;
	String flightNumber;

	MyFlightTable(int n,String sqlString){
 
		J = new JFrame();
		J.setTitle("航班信息");
		J.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//设置右上角XX关闭窗口
		J.setVisible(true);
		J.setBounds(390, 320, 620, 330);
		AbstractTableModel tm;
		final String[] title = { "航班号","公司ID",  "出发地", "目的地","起飞日期","起飞时间 ", "票价","余票数"};
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
	    J.add(jsp);
		ResultSet rs = null;
		if(n == 1)
		{
//			String sqlString = ("select 航班号,公司ID,起飞地,目的地,起飞时间,票价,余票数 from 航班信息表 ");
			rs = DataBaseManager.executeQuery(sqlString);
			
		}
		else
		{
//			String sqlString = ("select 航班号,公司ID,起飞地,目的地,起飞时间,票价,余票数 from 航班信息表");
			rs = DataBaseManager.executeQuery(sqlString);
		}
		vect.removeAllElements();// 初始化向量对象
		tm.fireTableStructureChanged();// 更新表格内容
		try {
			while (rs.next()) {
				@SuppressWarnings("rawtypes")
//				Vector<Comparable> v = new Vector<Comparable>();
				int i = 0 ;
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				v.add(rs.getString(8));
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
	    String value = "您选择的是"+(String) table.getValueAt(row, 0)+"号航班！";
	    JOptionPane.showMessageDialog(null, value);
	    flightNumber = (String)table.getValueAt(row, 0);
		SeatView st = new SeatView(flightNumber);
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
}
