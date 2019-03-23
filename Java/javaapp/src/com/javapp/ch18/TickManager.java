package com.javapp.ch18;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
/**
 * Description:��Ʊ������

 */
public class TickManager extends JFrame implements ActionListener {
	private String[] string = new String[22];
	private JComboBox boxyear = new JComboBox();
	private JComboBox boxyear1 = new JComboBox();
	private JComboBox boxyear2 = new JComboBox();
	private JComboBox boxmonth = new JComboBox();
	private JComboBox boxmonth1 = new JComboBox();
	private JComboBox boxmonth2 = new JComboBox();
	private JComboBox boxday1 = new JComboBox();
	private JComboBox boxday2 = new JComboBox();
	private JComboBox boxday = new JComboBox();
    //��������
	private String[] year = { " 2008", " 2009"," 2010" };
	private String[] adult = { " ���� ", " ��ͯ ", " ѧ�� " };
	private String[] month = { "01", "02", "03", "04", "05", "06", "07", "08",
			"09", "10", "11", "12" };
	private String[] day = { "01", "02", "03", "04", "05", "06", "07", "08",
			"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
			"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" ,"31"};
	private JTextField jbtflight = new JTextField(10);
	private JTextField jbtflight1 = new JTextField(10);
	private JTextField jbtflight2 = new JTextField(10);
	private JRadioButton jbrsingle, jbrdouble, jbrmultiple, jbradult, jbrchild;
	private ButtonGroup jbr = new ButtonGroup();
	private ButtonGroup jbr1 = new ButtonGroup();
	private JButton jbtbutton = new JButton("�� Ʊ Ԥ ��");
	private JButton jbtreturn = new JButton("������ҳ��");
	Color color = new Color(230, 230, 255);
	public static JFrame clientFrame = new JFrame();
	static TickManager frame;
	private ClientInfo client = new ClientInfo();
	public static boolean open = false;
	private JPanel s1, s2;
	private JLabel jblsecondflight = new JLabel("�ڶ������");
	private JLabel jblreturnflight = new JLabel("���غ���");
	private FlightSeatInfo seatinformation = new FlightSeatInfo();
	int flag = 0;
	int pflag = 0;
	public TickManager() {
		frame = this;
		string[5] = "����";
		for (int i = 0; i < year.length; i++)
			boxyear.addItem(year[i]);
		for (int i = 0; i < year.length; i++)
			boxyear1.addItem(year[i]);
		for (int i = 0; i < year.length; i++)
			boxyear2.addItem(year[i]);
		for (int i = 0; i < month.length; i++)
			boxmonth.addItem(month[i]);
		for (int i = 0; i < month.length; i++)
			boxmonth1.addItem(month[i]);
		for (int i = 0; i < month.length; i++)
			boxmonth2.addItem(month[i]);
		for (int i = 0; i < month.length; i++)
			boxday.addItem(day[i]);
		for (int i = 0; i < month.length; i++)
			boxday1.addItem(day[i]);
		for (int i = 0; i < month.length; i++)
			boxday2.addItem(day[i]);
		JPanel p0 = new JPanel();
		p0.setVisible(false);
		display(p0);
		p0.setLayout(new FlowLayout(FlowLayout.LEFT));
		p0.add(new JLabel("��������"));
		p0.add(boxyear1);
		p0.add(new JLabel("��"));
		p0.add(boxmonth1);
		p0.add(new JLabel("��"));
		p0.add(boxday1);
		p0.add(new JLabel("��"));
		// �������
		JPanel p1 = new JPanel();
		p1.setVisible(false);
		display1(p1);
		jLabel_IL4 = new JLabel("�ڶ���������:");
		p1.add(jLabel_IL4);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(boxyear2);
		p1.add(new JLabel("��"));
		p1.add(boxmonth2);
		p1.add(new JLabel("��"));
		p1.add(boxday2);
		p1.add(new JLabel("��"));
		//�������
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("��һ��������:"));
		p3.add(boxyear);
		p3.add(new JLabel("��"));
		p3.add(boxmonth);
		p3.add(new JLabel("��"));
		p3.add(boxday);
		p3.add(new JLabel("��"));
		// ��Ʊ�������
		JPanel p5 = new JPanel();
		jLabel_IL12 = new JLabel("��Ʊ����:");
		p5.add(jLabel_IL12);
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.add(jbrsingle = new JRadioButton("����", true));
		p5.add(jbrdouble = new JRadioButton("����", false));
		p5.add(jbrmultiple = new JRadioButton("��Ʊ   ", false));
		jbr.add(jbrsingle);
		jbr.add(jbrdouble);
		jbr.add(jbrmultiple);
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		p6.add(jbtbutton);
		p6.add(jbtreturn);
		JPanel p8 = new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.LEFT));
		p8.add(new JLabel("��һ�����:   "));
		p8.add(jbtflight);
		jbtflight.setPreferredSize(new java.awt.Dimension(67, 22));
		p8.add(jblreturnflight);
		p8.add(jbtflight1);
		p8.add(jblsecondflight);
		p8.add(jbtflight2);
		jblsecondflight.setVisible(false);
		jblsecondflight.setPreferredSize(new java.awt.Dimension(67, 17));
		jbtflight1.setVisible(false);
		jbtflight1.setPreferredSize(new java.awt.Dimension(66, 22));
		jbtflight2.setVisible(false);
		jbtflight2.setPreferredSize(new java.awt.Dimension(66, 19));
		jblreturnflight.setVisible(false);
		jblreturnflight.setPreferredSize(new java.awt.Dimension(55, 20));
		JPanel p7 = new JPanel();
		p7.setLayout(null);
		p7.add(p0);
		p0.setBounds(0, 0, 355, 33);
		p7.add(p1);
		p7.add(p3);
		p3.setBounds(0, 65, 317, 36);
		p1.setBounds(-1, 33, 409, 32);
		p7.add(p5);
		p5.setBounds(0, 107, 355, 29);
		p7.add(p6);
		p6.setBounds(69, 213, 286, 32);
		p7.add(p8);
		p8.setBounds(6, 142, 431, 37);
		boxyear.setBounds(6, 72, 27, 22);
		getContentPane().add(p7, BorderLayout.CENTER);
		p7.setPreferredSize(new java.awt.Dimension(367, 215));
		getContentPane().setBackground(new Color(255, 255, 230));
		this.setPreferredSize(new java.awt.Dimension(456, 293));
		this.setSize(456, 293);
		//��Ӱ�ť�¼�
		jbtbutton.addActionListener(this);
		jbtreturn.addActionListener(this);
		jbrsingle.addActionListener(this);
		jbrdouble.addActionListener(this);
		jbrmultiple.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				TickManager.this.setVisible(false);
				TickManager.this.dispose();
			}
		});
	}
	public void display(JPanel p) {
		s1 = p;

	}
	public void display1(JPanel p) {
		s2 = p;
	}
	String otherchoice = new String(" ");
	String dotherchoice = new String(" ");
	String motherchoice = new String(" ");
	boolean isFull = false;//��λ�Ƿ������
	public void actionPerformed(ActionEvent e) {//����ť�¼�
		String year1 = new String(boxyear.getSelectedItem().toString().trim());
		String month1 = new String(boxmonth.getSelectedItem().toString().trim());
		String day1 = new String(boxday.getSelectedItem().toString().trim());
		String year2 = new String(boxyear1.getSelectedItem().toString().trim());
		String month2 = new String(boxmonth1.getSelectedItem().toString().trim());
		String day2 = new String(boxday1.getSelectedItem().toString().trim());
		string[2] = year1 + "-" + month1 + "-" + day1 ;
		string[3] = year1 + "-" + month1 + "-" + day1;
		string[4] = jbtflight.getText().trim();
		string[9] = year2 + "-" + month2 + "-" + day2 ;
		string[10] = year2 + "-" + month2 + "-" + day2;
		string[11] = jbtflight1.getText().trim();
		string[16] = jbtflight2.getText().trim();
		String year3 = new String(boxyear2.getSelectedItem().toString().trim());
		String month3 = new String(boxmonth2.getSelectedItem().toString().trim());
		String day3 = new String(boxday2.getSelectedItem().toString().trim());
		string[17] = year3 + "-" + month3 + "-" + day3;
		string[18] = year3 + "-" + month3 + "-" + day3 ;
		// Ԥ��Ʊ
		if (e.getSource() == jbtbutton) {
			otherchoice = " ";
			dotherchoice = " ";
			isFull = seatinformation.isFull(string[4], string[3]);//�ж���λ�Ƿ���
			int sflight = singleflight();//��ȡ���̺�����Ϣ��־
			int dflight = 0;
			int mflight = 0;
			String year = string[3].substring(0, 4);
			String month = string[3].substring(5, 7);
			String day = string[3].substring(8, 10);
			boolean before = isTimeValid(year, month, day);//�ж������Ƿ����
			if (before) {
				if (jbrsingle.isSelected()) {//ѡ�񵥳�Ԥ����ʽ
					if (sflight == 1) {
						JOptionPane.showMessageDialog(this, "����Ų���Ϊ��!", "������Ϣ",
								JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");
					} else if (sflight == 2) {
						JOptionPane.showMessageDialog(this,
								"��ҪԤ���ĺ����Ѿ�����!\n�����ԸĶ�ͬһ��ĺ���:\n" + otherchoice,
								"�ͻ���Ϣ", JOptionPane.INFORMATION_MESSAGE);
						jbtflight.setText("");
					} else if (sflight == 3) {
						JOptionPane.showMessageDialog(this,
								"��ҪԤ���ĺ����Ѿ�������!\n���ҵ�����������Ҳ����Ʊ��!\n����������ѡ�񺽰�����",
								"������Ϣ", JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");
					} else if (sflight == 4) {
						JOptionPane.showMessageDialog(this, "û�д˴κ��࣬�������²��ģ�",
								"������Ϣ", JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");
					} else {
						clientFrame.getContentPane().add(client.panel(string));
						clientFrame.setTitle("�ͻ�����");
						clientFrame.setSize(450, 460);
						clientFrame.setVisible(true);
						this.setVisible(false);
						client.jbtname.setText("");
						client.jbtid.setText("");
						client.jbtps.setText("");
						client.jbttelephone.setText("");
						client.jbtadultticketnumber.setText("1");
						client.jbtchildticketnumber.setText("0");
					}
				} else if (jbrdouble.isSelected()) {//ѡ������Ԥ����ʽ
					isFull = seatinformation.isFull(string[11], string[10]);
					dflight = doubleflight();
					if (sflight == 1) {
						JOptionPane.showMessageDialog(this, "��һ����Ų���Ϊ��!",
								"������Ϣ", JOptionPane.ERROR_MESSAGE);
					} else if (sflight == 2) {
						JOptionPane
								.showMessageDialog(this,
										"��ҪԤ���ĵ�һ������Ѿ�����!\n�����ԸĶ�ͬһ��ĺ���:\n"
												+ otherchoice, "�ͻ���Ϣ",
										JOptionPane.INFORMATION_MESSAGE);
						jbtflight.setText("");
					} else if (sflight == 3) {
						JOptionPane
								.showMessageDialog(
										this,
										"��ҪԤ���ĵ�һ�����Ѿ�������!\n���ҵ�����������Ҳ����Ʊ��!\n����������ѡ���һ��������",
										"������Ϣ", JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");

					} else if (sflight == 4) {
						JOptionPane.showMessageDialog(this, "û�е�һ����ţ��������²��ģ�",
								"������Ϣ", JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");
					} else {
						if (dflight == 1) {
							JOptionPane.showMessageDialog(this, "���غ���Ų���Ϊ��!",
									"������Ϣ", JOptionPane.ERROR_MESSAGE);

						} else if (dflight == 2) {
							JOptionPane.showMessageDialog(this,
									"��ҪԤ���ķ��غ�����Ѿ�����!\n�����ԸĶ�ͬһ��ĺ���:\n"
											+ otherchoice, "�ͻ���Ϣ",
									JOptionPane.INFORMATION_MESSAGE);
							jbtflight1.setText("");
						} else if (dflight == 3) {
							JOptionPane
									.showMessageDialog(
											this,
											"��ҪԤ���ķ��غ�����Ѿ�������!\n���ҵ�����������Ҳ����Ʊ��!\n����������ѡ�񷵻�����",
											"������Ϣ", JOptionPane.ERROR_MESSAGE);
							jbtflight1.setText("");
						} else if (dflight == 4) {
							JOptionPane.showMessageDialog(this,
									"��������ҪԤ���ķ��ذ�ţ��������²��ģ�", "������Ϣ",
									JOptionPane.ERROR_MESSAGE);
							jbtflight1.setText("");
						} else if (dflight == 5) {
							JOptionPane.showMessageDialog(this,
									"���غ�������һ����Ų�ƥ��\n���������뷵�غ���ţ�", "������Ϣ",
									JOptionPane.ERROR_MESSAGE);
							jbtflight1.setText("");
						} else {
							clientFrame.getContentPane().add(
									client.panel(string));
							clientFrame.pack();
							clientFrame.setTitle("�ͻ�����");
							clientFrame.setVisible(true);
							this.setVisible(false);
						}
					}
				} else if (jbrmultiple.isSelected()) {//ѡ������Ԥ����ʽ
					isFull = seatinformation.isFull(string[11], string[10]);
					mflight = multipleflight();
					if (sflight == 1) {
						JOptionPane.showMessageDialog(this, "��һ����Ų���Ϊ��!",
								"������Ϣ", JOptionPane.ERROR_MESSAGE);
					} else if (sflight == 2) {
						JOptionPane
								.showMessageDialog(this,
										"��ҪԤ���ĵ�һ������Ѿ�����!\n�����ԸĶ�ͬһ��ĺ���:\n"
												+ otherchoice, "�ͻ���Ϣ",
										JOptionPane.INFORMATION_MESSAGE);
						jbtflight.setText("");
					} else if (sflight == 3) {
						JOptionPane
								.showMessageDialog(
										this,
										"��ҪԤ���ĵ�һ�����Ѿ�������!\n���ҵ�����������Ҳ����Ʊ��!\n����������ѡ���һ��������",
										"������Ϣ", JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");
					} else if (sflight == 4) {
						JOptionPane.showMessageDialog(this, "û�е�һ����ţ��������²��ģ�",
								"������Ϣ", JOptionPane.ERROR_MESSAGE);
						jbtflight.setText("");
					} else {
						if (mflight == 1) {
							JOptionPane.showMessageDialog(this, "�ڶ�����Ų���Ϊ��!",
									"������Ϣ", JOptionPane.ERROR_MESSAGE);

						} else if (mflight == 2) {
							JOptionPane.showMessageDialog(this,
									"��ҪԤ���ĵڶ�������Ѿ�����!\n�����ԸĶ�ͬһ��ĺ���:\n"
											+ otherchoice, "�ͻ���Ϣ",
									JOptionPane.INFORMATION_MESSAGE);
							jbtflight1.setText("");
						} else if (mflight == 3) {
							JOptionPane
									.showMessageDialog(
											this,
											"��ҪԤ���ĵڶ�������Ѿ�������!\n���ҵ�����������Ҳ����Ʊ��!\n����������ѡ��ڶ���������",
											"������Ϣ", JOptionPane.ERROR_MESSAGE);
							jbtflight1.setText("");
						} else if (mflight == 4) {
							JOptionPane.showMessageDialog(this,
									"��������ҪԤ���ĵڶ�����ţ��������²��ģ�", "������Ϣ",
									JOptionPane.ERROR_MESSAGE);
							jbtflight1.setText("");
						} else if (mflight == 5) {
							JOptionPane.showMessageDialog(this,
									"�ڶ���������һ����Ų�ƥ��\n���������뷵�غ���ţ�", "������Ϣ",
									JOptionPane.ERROR_MESSAGE);
							jbtflight1.setText("");
						} else {
							clientFrame.getContentPane().add(
									client.panel(string));
							clientFrame.setTitle("�ͻ�����");
							clientFrame.setSize(450, 460);
							clientFrame.setVisible(true);
							this.setVisible(false);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "�Բ��𣬲���Ԥ����ǰ��Ʊ��", "�ͻ���Ϣ",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == jbtreturn) {//����������
			this.setVisible(false);
			this.dispose();
		}
		if (e.getSource() == jbrsingle) {
			string[11] = jbtflight1.getText().trim();
			// string[12]="single";
			string[5] = "����";
			s1.setVisible(false);
			s2.setVisible(false);
			jblsecondflight.setVisible(false);
			jbtflight1.setVisible(false);
			jblreturnflight.setVisible(false);
			jbtflight2.setVisible(false);
		}
		if (e.getSource() == jbrdouble) {
			// string[12]="double";
			string[5] = "����";
			s2.setVisible(false);
			s1.setVisible(true);
			jblreturnflight.setVisible(true);
			jbtflight1.setVisible(true);
			jblsecondflight.setVisible(false);
			jbtflight2.setVisible(false);
		}
		if (e.getSource() == jbrmultiple) {
			// string[12]="multiple";
			string[5] = "����";
			s1.setVisible(false);
			jblreturnflight.setVisible(false);
			jbtflight1.setVisible(false);
			s2.setVisible(true);
			jblsecondflight.setVisible(true);
			jbtflight2.setVisible(true);
		}
	}

	String startplace = new String();
	String endplace = new String();
	private JLabel jLabel_IL4;
	private JLabel jLabel_IL12;

	public int singleflight() {//��ȡ������Ϣ
		if (jbtflight.getText().trim().length() == 0)
			return 1;
		else {
			try {
				DataBaseManager DbBean = new DataBaseManager();
				Connection con = DbBean.getDb();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from flightTick");
				while (rs.next())
					if (rs.getString(1).trim().equals(string[4]))//�����
						flag = 1;
				if (flag == 1) {
					String airfirm1 = new String();
					String sql = "select start,destination,airFirm from flightTick where flight='"
							+ string[4] + "'";
					ResultSet rs1 = stmt.executeQuery(sql);
					while (rs1.next()) {
						startplace = rs1.getString(1).trim();
						endplace = rs1.getString(2).trim();
						airfirm1 = rs1.getString(3).trim();
					}
					if (!isFull) {
						string[0] = startplace;
						string[1] = endplace;
						string[6] = airfirm1;
						string[8] = string[5] + "Ʊ";
					} else {
						String[] flightcode = new String[50];
						int i = 0;
						for (i = 0; i < 50; i++)
							flightcode[i] = new String("null");
						i = 0;
						sql = "select flight from flightTick where start='"
								+ startplace + "' AND destination='" + endplace
								+ "'";
						ResultSet rs2 = stmt.executeQuery(sql);
						while (rs2.next()) {
							flightcode[i] = rs2.getString(1);
							i++;
						}
						stmt.close();
						con.close();
						i = 0;
						while (!(flightcode[i].equals("null"))) {
							if (!(flightcode[i].equals(string[4])))
							
							{
								isFull = seatinformation.isFull(flightcode[i],
										string[3]);//�ж���λ�Ƿ���
								if (!isFull) {
									otherchoice = otherchoice + flightcode[i];
								}
							}
							i++;
						}

						if (!(otherchoice.equals(" ")))
							return 2;

						else
							return 3;

					}
				}
				if (flag == 0)
					return 4;

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return 0;
	}

	public int doubleflight() {//��ȡ������Ϣ
		if (jbtflight1.getText().trim().length() == 0)
			return 1;
		else {
			try {
				DataBaseManager DbBean = new DataBaseManager();
				Connection con = DbBean.getDb();
				Statement stmt = con.createStatement();
				ResultSet drs = stmt.executeQuery("select * from flightTick");
				while (drs.next()) {
					if (drs.getString(1).trim().equals(string[11])) {
						flag = 1;
					}
				}
				if (flag == 1) {
					String dstartplace = new String();
					String dendplace = new String();
					String sql = "select start,destination from flightTick where flight='"
							+ string[11] + "'";
					ResultSet drs1 = stmt.executeQuery(sql);
					while (drs1.next()) {
						dstartplace = drs1.getString(1).trim();
						dendplace = drs1.getString(2).trim();
					}
					if (dstartplace.equals(endplace)
							&& dendplace.equals(startplace)) {
						if (isFull) {
							String[] dflightcode = new String[50];
							int i = 0;
							for (i = 0; i < 50; i++)
								dflightcode[i] = new String("null");
							i = 0;
							sql = "select flight from flightTick where start='"
									+ startplace + "' AND destination='"
									+ endplace + "'";
							ResultSet drs2 = stmt.executeQuery(sql);
							while (drs2.next()) {
								dflightcode[i] = drs2.getString(1);
								i++;
							}
							stmt.close();
							con.close();
							i = 0;
							while (!(dflightcode[i].equals("null"))) {
								if (!(dflightcode[i].equals(string[11])))
									;
								{
									isFull = seatinformation.isFull(
											dflightcode[i], string[3]);
									if (!isFull) {
										dotherchoice = dotherchoice
												+ dflightcode[i];
									}
								}
								i++;
							}
							if (!(dotherchoice.equals(" ")))
								return 2;
							else
								return 3;
						}
					} else
						return 5;
				}
				if (flag == 0)
					return 4;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}

	public int multipleflight() {//��ȡ������Ϣ
		if (jbtflight2.getText().trim().length() == 0)
			return 1;
		else {
			try {
				DataBaseManager DbBean = new DataBaseManager();

				Connection con = DbBean.getDb();
				Statement stmt = con.createStatement();
				ResultSet mrs = stmt.executeQuery("select * from flightTick");
				while (mrs.next()) {
					if (mrs.getString(1).trim().equals(string[16])) {
						flag = 1;
					}
				}
				string[11] = string[16];
				if (flag == 1) {
					String mstartplace = new String();
					String mendplace = new String();
					String sql = "select start,destination from flightTick where flight='"
							+ string[16] + "'";
					ResultSet mrs1 = stmt.executeQuery(sql);
					while (mrs1.next()) {
						mstartplace = mrs1.getString(1).trim();
						mendplace = mrs1.getString(2).trim();
					}
					if (mstartplace.equals(endplace)) {
						if (isFull) {
							String[] mflightcode = new String[50];
							int i = 0;
							for (i = 0; i < 50; i++)
								mflightcode[i] = new String("null");
							i = 0;
							sql = "select flight from flightTick where start='"
									+ startplace + "' AND destination='"
									+ endplace + "'";
							ResultSet mrs2 = stmt.executeQuery(sql);
							while (mrs2.next()) {
								mflightcode[i] = mrs2.getString(1);
								i++;
							}
							stmt.close();
							con.close();
							i = 0;
							while (!(mflightcode[i].equals("null"))) {
								if (!(mflightcode[i].equals(string[16])))
									;
								{
									isFull = seatinformation.isFull(
											mflightcode[i], string[17]);
									if (!isFull) {
										motherchoice = motherchoice
												+ mflightcode[i];
									}
								}
								i++;
							}
							if (!(motherchoice.equals(" ")))
								return 2;
							else
								return 3;
						}
					} else
						return 5;
				}
				if (flag == 0)
					return 4;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}
//Ԥ��Ʊ���ڲ���С�ڵ�ǰ����
	private boolean isTimeValid(String year, String month, String day) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int py = cal.get(Calendar.YEAR);
		int pm = cal.get(Calendar.MONTH) + 1;
		int pd = cal.get(Calendar.DAY_OF_MONTH);
		if (y == py) {
			if (m < pm)
				return false;
			else if (d < pd)
				return false;
		}
		return true;
	}
}