package com.javapp.ch18;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.*;

/**
 * @Description:查询客户己订票信息 


 */
public class FrameTable extends JFrame {
	private boolean DEBUG = true;

	public FrameTable() {
		// 实现构造方法
		super("客户己订票信息查询"); // 首先调用父类JFrame的构造方法生成一个窗口
		MyTableModel myModel = new MyTableModel(); // myModel存放表格的数据
		JTable table = new JTable(myModel); // 表格对象table的数据来源是myModel对象
		table.setPreferredScrollableViewportSize(new Dimension(400, 100));
		// 表格的显示尺寸
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// 设置自动横向滚动
		TableColumnModel md7 = (TableColumnModel) table.getColumnModel();
		md7.getColumn(0).setMinWidth(30);// 设置列的宽度
		md7.getColumn(1).setMaxWidth(150);
		md7.getColumn(2).setMaxWidth(60);
		JScrollPane scrollPane = new JScrollPane(table);// 产生一个带滚动条的面板
		table.setRowMargin(2);// 设置表格线的宽度
		table.setRowHeight(20);// 设置行的高度
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		// 将带滚动条的面板添加入窗口中
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)// 注册窗口监听器
			{
				
			}
		});
	}

	// 把要显示在表格中的数据存入字符串数组和Object数组中
	class MyTableModel extends AbstractTableModel {
		// 表格中第一行所要显示的内容存放在字符串数组columnNames中
		final String[] columnNames = { "姓名", "身份证", "出发地", "到达地 ", "出发时间", "联系电话","航班号","航空公司","成人票数" };
		// 表格中各行的内容保存在二维数组data中
		Object[][] data=null;
		{
		try {    
			DataBaseManager DbBean = new DataBaseManager();
			Connection con = DbBean.getDb();
			String sql = "select * from ClientInfo ";
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery(sql);
			int rows=0;
			while(rs.next()) rows++;
			data=new Object[rows][9];
			rs = st.executeQuery(sql);
		    int i=0;
			while (rs.next()) {
       
				data[i][0] = rs.getString("name");
				data[i][1]  = rs.getString("id");
				data[i][6]  = rs.getString("flight");
				data[i][2] =rs.getString("start");
				data[i][3]=rs.getString("end");
				data[i][4]=rs.getString("starttime");
				data[i][5]=rs.getString("telephone");
				data[i][7]=rs.getString("airfirm");
				data[i][8]=rs.getString("adultticketnumber");
				i++;
			}
			rs.close();
			st.close();
			con.close();
		
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		// 下述方法是重写AbstractTableModel中的方法，其主要用途是被JTable对象调用，以便在表格中正确的显示出来。程序员必须根据采用的数据类型加以恰当实现。
		// 获得列的数目
		public int getColumnCount() {
			return columnNames.length;
		}

		// 获得行的数目
		public int getRowCount() {
			return data.length;
		}

		// 获得某列的名字，而目前各列的名字保存在字符串数组columnNames中
		public String getColumnName(int col) {
			return columnNames[col];
		}

		// 获得某行某列的数据，而数据保存在对象数组data中
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		// 判断每个单元格的类型
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// 将表格声明为可编辑的
		public boolean isCellEditable(int row, int col) {
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		// 改变某个数据的值
		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("设置值在 " + row + "，  " + col + " to " + value
						+ " (an instance of " + value.getClass() + ")");
			}
			if (data[0][col] instanceof Integer && !(value instanceof Integer)) {
				try {
					data[row][col] = new Integer(value.toString());
					fireTableCellUpdated(row, col);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(FrameTable.this, "The \""
							+ getColumnName(col) + "\" 列只接受整型数据.");
				}
			} else {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}
			
		}

	}

	public static void main(String[] args) {
		FrameTable frame = new FrameTable();
		frame.pack();
		frame.setVisible(true);
	}
}
