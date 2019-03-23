package com.javapp.ch18;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

/**
 * Description:���������
 * 

 */
public class FlightManager extends JFrame {
	private JTextField[] Filght = new JTextField[12];
	private JLabel[] label = new JLabel[12];
	private JButton[] button = new JButton[3];
	private JComboBox week, hour1, hour2, min1, min2;
	private String[] sunday = { "1", "2", "3", "4", "5", "6", "7" };
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public FlightManager() {
		week = new JComboBox();
		for (int i = 0; i < sunday.length; i++)
			week.addItem(sunday[i]);
		hour1 = new JComboBox();
		hour2 = new JComboBox();
		min1 = new JComboBox();
		min2 = new JComboBox();
		for (int i = 1; i <= 24; i++) {
			if (i < 10) {
				hour1.addItem("" + 0 + i);
				hour2.addItem("" + 0 + i);
			} else {
				hour1.addItem("" + i);
				hour2.addItem("" + i);
			}
		}
		for (int i = 0; i <= 59; i++) {
			if (i < 10) {
				min1.addItem("" + 0 + i);
				min2.addItem("" + 0 + i);
			} else {
				min1.addItem("" + i);
				min2.addItem("" + i);
			}
		}
		JPanel p3 = new JPanel();
		p3.add(hour1);
		p3.add(new JLabel("ʱ"));
		p3.add(min1);
		p3.add(new JLabel("��"));
		JPanel p4 = new JPanel();
		p4.add(hour2);
		p4.add(new JLabel("ʱ"));
		p4.add(min2);
		p4.add(new JLabel("��"));
		JPanel p1 = new JPanel();
		p1.setBorder(new TitledBorder("������Ϣ"));
		p1.setLayout(new GridLayout(6, 4, 5, 5));
		p1.add(label[0] = new JLabel("�����"));
		p1.add(Filght[0] = new JTextField(10));
		p1.add(label[1] = new JLabel("����"));
		p1.add(Filght[1] = new JTextField(10));
		p1.add(label[0] = new JLabel("���չ�˾"));
		p1.add(Filght[2] = new JTextField(10));
		p1.add(label[0] = new JLabel("��λ"));
		p1.add(Filght[3] = new JTextField(10));
		p1.add(label[0] = new JLabel("��ɵ�"));
		p1.add(Filght[4] = new JTextField(10));
		p1.add(label[0] = new JLabel("�ִ��"));
		p1.add(Filght[5] = new JTextField(10));
		p1.add(label[0] = new JLabel("���ʱ��"));
		p1.add(p3);
		p1.add(label[0] = new JLabel("�ִ�ʱ��"));
		p1.add(p4);
		p1.add(label[0] = new JLabel("��ͯƱ��"));
		p1.add(Filght[8] = new JTextField(10));
		p1.add(label[0] = new JLabel("����Ʊ��"));
		p1.add(Filght[9] = new JTextField(10));
		p1.add(label[0] = new JLabel("��ǰ�ۿ�"));
		p1.add(Filght[10] = new JTextField(10));
		p1.add(label[0] = new JLabel("��Ʊ��"));
		p1.add(Filght[11] = new JTextField(10));
		JPanel p2 = new JPanel();
		p2.setBorder(new TitledBorder("����"));
		p2.add(button[0] = new JButton("��������"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(429, 364);
		this.add(p1, BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FlightManager.this.dispose();
			}
		});
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataBaseManager sqlBean = new DataBaseManager();
					con = sqlBean.getDb();
					stmt = con.createStatement();
					if (Filght[0].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "����Ų���Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[2].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "���չ�˾����Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[3].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��λ����Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[4].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "���еز���Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[5].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�ִ�ز���Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[8].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[9].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "����Ʊ�۲���Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[10].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��ǰ�ۿ۲���Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (Filght[11].getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��Ʊ�ʲ���Ϊ��", "ϵͳ��ʾ",
								JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						int maxremark = 1;
						rs = stmt.executeQuery("select remark from flightTick");
						int remark = 0;
						while (rs.next()) {
							remark = rs.getInt(1);
							if (remark > maxremark)
								maxremark = remark;
						}
						String time1 = (String) hour1.getSelectedItem()
								+ (String) min1.getSelectedItem();
						String time2 = (String) hour2.getSelectedItem()
								+ (String) min2.getSelectedItem();
						maxremark = maxremark + 1;
						String sql = "insert into flightTick values('"
								+ Filght[0].getText() + "','" + Filght[2].getText()
								+ "','" + Filght[4].getText() + "','"
								+ Filght[5].getText() + "','" + time1 + "','"
								+ time2 + "',"
								+ Float.parseFloat(Filght[8].getText().trim())
								+ ","
								+ Float.parseFloat(Filght[9].getText().trim())
								+ ","
								+ Float.parseFloat(Filght[10].getText().trim())
								+ ","
								+ Float.parseFloat(Filght[11].getText().trim())
								+ ","
								+ Integer.parseInt(Filght[3].getText().trim())
								+ ",'" + Filght[1].getText() + "'," + maxremark
								+ ")";
						stmt.executeUpdate(sql);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null, "�������ݳɹ�!", "ϵͳ��ʾ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "��������ʧ��,ԭ��"+ex.toString(), "ϵͳ��ʾ",
							JOptionPane.ERROR_MESSAGE);
				}
				finally{
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}