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
		JFrame f = new JFrame("��ƱԤ��ϵͳ");
		f.setLocation(300,80);
		f.setSize(300, 400);
		f.setLayout(new BorderLayout());
	    JPanel jp= new JPanel(null);
//	    jp.setBounds(100, 60, 600, 180);
//	    jp.setLayout(new BorderLayout());
	    ResultSet rs = null;
	    String sqlString = ("select ��λ��,��λ�Ƿ�Ԥ��  from ��λ��Ϣ��  where ����� ='" + flightNumber + "'");
	    rs = DataBaseManager.executeQuery(sqlString);
	    AbstractTableModel tm;
		final String[] title = { "��λ��","��λ���" ,"��λ�Ƿ�Ԥ��"};
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
	    
	    jp.setVisible(true);
	    f.add(jsp,BorderLayout.WEST);
	    f.add(jp, BorderLayout.EAST);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//�������Ͻ�XX�رմ���
		vect.removeAllElements();// ��ʼ����������
		tm.fireTableStructureChanged();// ���±������
		try {
			int i=0;
			while (rs.next()) {
				@SuppressWarnings("rawtypes")
//				Vector<Comparable> v = new Vector<Comparable>();

				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));
				if(i < 8)
				{
					v.add("ͷ�Ȳ�");
				}
				else
				{
					v.add("���ò�");
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
	    String value = "��ѡ�����λ����"+(String) table.getValueAt(row, 0);
	    JOptionPane.showMessageDialog(null, value);
	    seat = (String) table.getValueAt(row, 0);
	    WriteInformation wf = new WriteInformation(seat,flightNumber);
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
	
	public String getSeat()
	{
		return this.seat;
	}
	
	public String getFlightNumber()
	{
		return this.flightNumber;
	}
}
