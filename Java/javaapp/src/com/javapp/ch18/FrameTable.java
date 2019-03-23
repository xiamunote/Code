package com.javapp.ch18;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.*;

/**
 * @Description:��ѯ�ͻ�����Ʊ��Ϣ 


 */
public class FrameTable extends JFrame {
	private boolean DEBUG = true;

	public FrameTable() {
		// ʵ�ֹ��췽��
		super("�ͻ�����Ʊ��Ϣ��ѯ"); // ���ȵ��ø���JFrame�Ĺ��췽������һ������
		MyTableModel myModel = new MyTableModel(); // myModel��ű�������
		JTable table = new JTable(myModel); // ������table��������Դ��myModel����
		table.setPreferredScrollableViewportSize(new Dimension(400, 100));
		// ������ʾ�ߴ�
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);// �����Զ��������
		TableColumnModel md7 = (TableColumnModel) table.getColumnModel();
		md7.getColumn(0).setMinWidth(30);// �����еĿ��
		md7.getColumn(1).setMaxWidth(150);
		md7.getColumn(2).setMaxWidth(60);
		JScrollPane scrollPane = new JScrollPane(table);// ����һ���������������
		table.setRowMargin(2);// ���ñ���ߵĿ��
		table.setRowHeight(20);// �����еĸ߶�
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		// �������������������봰����
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)// ע�ᴰ�ڼ�����
			{
				
			}
		});
	}

	// ��Ҫ��ʾ�ڱ���е����ݴ����ַ��������Object������
	class MyTableModel extends AbstractTableModel {
		// ����е�һ����Ҫ��ʾ�����ݴ�����ַ�������columnNames��
		final String[] columnNames = { "����", "���֤", "������", "����� ", "����ʱ��", "��ϵ�绰","�����","���չ�˾","����Ʊ��" };
		// ����и��е����ݱ����ڶ�ά����data��
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

		// ������������дAbstractTableModel�еķ���������Ҫ��;�Ǳ�JTable������ã��Ա��ڱ������ȷ����ʾ����������Ա������ݲ��õ��������ͼ���ǡ��ʵ�֡�
		// ����е���Ŀ
		public int getColumnCount() {
			return columnNames.length;
		}

		// ����е���Ŀ
		public int getRowCount() {
			return data.length;
		}

		// ���ĳ�е����֣���Ŀǰ���е����ֱ������ַ�������columnNames��
		public String getColumnName(int col) {
			return columnNames[col];
		}

		// ���ĳ��ĳ�е����ݣ������ݱ����ڶ�������data��
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		// �ж�ÿ����Ԫ�������
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// ���������Ϊ�ɱ༭��
		public boolean isCellEditable(int row, int col) {
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		// �ı�ĳ�����ݵ�ֵ
		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("����ֵ�� " + row + "��  " + col + " to " + value
						+ " (an instance of " + value.getClass() + ")");
			}
			if (data[0][col] instanceof Integer && !(value instanceof Integer)) {
				try {
					data[row][col] = new Integer(value.toString());
					fireTableCellUpdated(row, col);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(FrameTable.this, "The \""
							+ getColumnName(col) + "\" ��ֻ������������.");
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
