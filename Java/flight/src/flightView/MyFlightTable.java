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
		J.setTitle("������Ϣ");
		J.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//�������Ͻ�XX�رմ���
		J.setVisible(true);
		J.setBounds(390, 320, 620, 330);
		AbstractTableModel tm;
		final String[] title = { "�����","��˾ID",  "������", "Ŀ�ĵ�","�������","���ʱ�� ", "Ʊ��","��Ʊ��"};
		JScrollPane jsp;
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Vector<Vector<String>> vect = new Vector();// ʵ��������
		tm = new AbstractTableModel() {// ʵ��AbstractTableModel�ĳ��󷽷�

			private static final long serialVersionUID = 1L;
 
			public int getColumnCount() {
				return title.length;
			}
 
			public int getRowCount() {
				// TODO �Զ����ɵķ������
				return vect.size();
			}
 
			public Object getValueAt(int row, int column) {
				// TODO �Զ����ɵķ������
				if (!vect.isEmpty())
					return (((Vector<?>) vect.elementAt(row)).elementAt(column));
				else
					return null;
			}
 
			public String getColumnName(int column) {
				return title[column];// ���ñ������
			}
 
			public void setValueAt(Object value, int row, int column) {
			}
 
			public Class<? extends Object> getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}// ȡ������������
 
			public boolean isCellEditable(int row, int column) {
 
				return false;
			}// ���õ�Ԫ�񲻿ɱ༭
		};
		table = new JTable(tm);
        table.addMouseListener(this);
		table.setToolTipText("��ʾ���е�����");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ���ñ������ߴ�ģʽ
		table.setCellSelectionEnabled(false);// ���õ�Ԫ��ѡ��ʽ
		table.setShowVerticalLines(true);// �����Ƿ���ʾ��Ԫ���ķָ���
		table.setShowHorizontalLines(true);
 
		jsp = new JScrollPane(table);
	    J.add(jsp);
		ResultSet rs = null;
		if(n == 1)
		{
//			String sqlString = ("select �����,��˾ID,��ɵ�,Ŀ�ĵ�,���ʱ��,Ʊ��,��Ʊ�� from ������Ϣ�� ");
			rs = DataBaseManager.executeQuery(sqlString);
			
		}
		else
		{
//			String sqlString = ("select �����,��˾ID,��ɵ�,Ŀ�ĵ�,���ʱ��,Ʊ��,��Ʊ�� from ������Ϣ��");
			rs = DataBaseManager.executeQuery(sqlString);
		}
		vect.removeAllElements();// ��ʼ����������
		tm.fireTableStructureChanged();// ���±������
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
	    String value = "��ѡ�����"+(String) table.getValueAt(row, 0)+"�ź��࣡";
	    JOptionPane.showMessageDialog(null, value);
	    flightNumber = (String)table.getValueAt(row, 0);
		SeatView st = new SeatView(flightNumber);
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO �Զ����ɵķ������
		
	}
	
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO �Զ����ɵķ������
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO �Զ����ɵķ������
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO �Զ����ɵķ������
		
	}
}
