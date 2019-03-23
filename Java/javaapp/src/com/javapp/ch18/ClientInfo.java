package com.javapp.ch18;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
/**
 * Description:定票客户信息类
 */
public class ClientInfo extends JFrame implements ActionListener {
	// 定义组件标识
	DataBaseManager DbBean = new DataBaseManager();
	private JLabel name = new JLabel("真实姓名* :");
	private JLabel id = new JLabel("身份证号*:");
	private JLabel start = new JLabel("出发地点:");
	private JLabel end = new JLabel("到达地点:");
	private JLabel starttime = new JLabel("出发时间:");
	private JLabel returntime = new JLabel("返回时间:");
	private JLabel flight = new JLabel("航 班 号:");
	private JLabel telephone = new JLabel("联系电话*:");
	private JLabel email = new JLabel("E-Mail:");
	private JLabel ps = new JLabel(" 简短附言:");
	private JLabel returnflight = new JLabel("返回航班号:");
	private JLabel adultticketnumber = new JLabel("成人票数:");
	private JLabel childticketnumber = new JLabel(" 儿童票数:");
	private JLabel airfirm = new JLabel(" 航空公司:");
	private JLabel style = new JLabel(" 机票类型:");
	static JTextField jbtname = new JTextField(" ", 12);
	static JTextField jbtid = new JTextField(" ", 20);
	private JTextField jbtstart = new JTextField(" ", 12);
	private JTextField jbtend = new JTextField(" ", 12);
	private JTextField jbtstarttime = new JTextField(" ", 12);
	private JTextField jbtreturntime = new JTextField(" ", 12);
	static JTextField jbtadultticketnumber = new JTextField("1", 12);
	static JTextField jbtchildticketnumber = new JTextField("1", 12);
	private JTextField jbtstyle = new JTextField(12);
	private JTextField jbtreturnflight = new JTextField(12);
	private JTextField jbtairfirm = new JTextField(12);
	static JTextField jbttelephone = new JTextField(12);
	static JTextField jbtemail = new JTextField(12);
	private JTextField jbtflight = new JTextField(12);
	static JTextArea jbtps = new JTextArea(10, 3);
	private JButton handin = new JButton("提交");
	private JButton rewrite = new JButton("重新输入");
	private JButton return1 = new JButton("返回订票");
	private JPanel p10 = new JPanel();
	private String[] string = new String[22];
	private FlightSeatInfo seatinformation = new FlightSeatInfo();
	public ClientInfo() {
		jbtstarttime.setEditable(false);
		jbtreturntime.setEditable(false);
		jbtstart.setEditable(false);
		jbtend.setEditable(false);
		jbtflight.setEditable(false);
		jbtairfirm.setEditable(false);
		jbtreturnflight.setEditable(false);
		jbtstyle.setEditable(false);
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(name);
		p1.add(jbtname);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(id);
		p2.add(jbtid);
		jbtid.setPreferredSize(new java.awt.Dimension(244, 22));
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(start);
		p3.add(jbtstart);
		p3.add(style);
		p3.add(jbtstyle);
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(end);
		p4.add(jbtend);
		p4.add(airfirm);
		p4.add(jbtairfirm);
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.add(starttime);
		p5.add(jbtstarttime);
		p5.add(returntime);
		p5.add(jbtreturntime);
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		p6.add(adultticketnumber);
		adultticketnumber.setPreferredSize(new java.awt.Dimension(63, 15));
		p6.add(jbtadultticketnumber);
		jbtadultticketnumber.setPreferredSize(new java.awt.Dimension(67, 22));
		p6.add(childticketnumber);
		childticketnumber.setPreferredSize(new java.awt.Dimension(71, 15));
		p6.add(jbtchildticketnumber);
		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		p7.add(telephone);
		p7.add(jbttelephone);
		p7.add(email);
		email.setPreferredSize(new java.awt.Dimension(74, 15));
		p7.add(jbtemail);
		JPanel p9 = new JPanel();
		jbtps.setLineWrap(true);
		jbtps.setBorder(new LineBorder(new Color(220, 220, 255), 2));
		jbtps.setPreferredSize(new java.awt.Dimension(244, 8));
		p9.setLayout(new BorderLayout());
		ps.setPreferredSize(new java.awt.Dimension(70, 34));
		p9.add(ps, BorderLayout.WEST);
		{
			JScrollPane scrollPane = new JScrollPane(jbtps);
			p9.add(scrollPane, BorderLayout.CENTER);
		}
		JPanel p11 = new JPanel();
		p11.setLayout(new FlowLayout(FlowLayout.CENTER));
		p11.add(handin);
		handin.setPreferredSize(new java.awt.Dimension(103, 22));
		p11.add(rewrite);
		rewrite.setPreferredSize(new java.awt.Dimension(93, 22));
		p11.add(return1);
		return1.setPreferredSize(new java.awt.Dimension(104, 22));
		JPanel p12 = new JPanel();
		p12.setLayout(new FlowLayout(FlowLayout.LEFT));
		p12.add(flight);
		flight.setPreferredSize(new java.awt.Dimension(95, 15));
		p12.add(jbtflight);
		p12.add(returnflight);
		p12.add(jbtreturnflight);
		p10.setBorder(new MatteBorder(new ImageIcon("f.gif")));
		p10.setLayout(null);
		p10.setPreferredSize(new java.awt.Dimension(403, 314));
		JLabel title = new JLabel("(带*的必须填写)", JLabel.LEFT);
		p10.add(title);
		p10.add(p1);
		p1.setBounds(0, 0, 236, 30);
		p10.add(p2);
		p2.setBounds(0, 36, 372, 31);
		p10.add(p3);
		p3.setBounds(0, 67, 426, 30);
		p10.add(p4);
		p4.setBounds(-1, 97, 416, 32);
		p10.add(p5);
		p5.setBounds(0, 129, 379, 32);
		p10.add(p6);
		p6.setBounds(-1, 161, 471, 32);
		p10.add(p7);
		p7.setBounds(0, 193, 470, 30);
		p10.add(p9);
		p9.setBounds(0, 229, 332, 34);
		p10.add(p11);
		p11.setBounds(0, 269, 555, 36);
		p10.add(p12);
		p12.setBounds(236, 0, 279, 30);
		rewrite.addActionListener(this);
		handin.addActionListener(this);
		return1.addActionListener(this);
		initGUI();
	}

	public JPanel panel(String[] string) {
		this.string = string;
		jbtstart.setText(string[0]);
		jbtend.setText(string[1]);
		jbtstarttime.setText(string[2]);
		jbtairfirm.setText(string[6]);
		jbtflight.setText(string[4]);
		jbtstyle.setText(string[8]);
		// 单程
		if (string[5].equals("单程")) {
			jbtreturnflight.setVisible(false);
			returnflight.setVisible(false);
			returnflight.setPreferredSize(new java.awt.Dimension(194, -2));
			returntime.setVisible(false);
			returntime.setPreferredSize(new java.awt.Dimension(55, 11));
			jbtreturntime.setVisible(false);
		}
		// 往返
		else if (string[5].equals("往返")) {
			jbtreturnflight.setVisible(true);
			returnflight.setVisible(true);
			returntime.setVisible(true);
			jbtreturntime.setVisible(true);
		}
		// 联程
		else if (string[5].equals("联程")) {
			string[9] = string[18];
			string[10] = string[17];
			string[11] = string[16];
		}
		jbtreturnflight.setText(string[11]);
		jbtreturntime.setText(string[9]);
		jbtreturntime.setPreferredSize(new java.awt.Dimension(104, 20));
		return p10;
	}
	int adultnumber = 0;
	int childnumber = 0;
	int ticketnumber = 0;
	public void actionPerformed(ActionEvent e) {
		int len1 = jbtname.getText().trim().length();
		int len2 = jbtid.getText().trim().length();
		int len3 = jbtadultticketnumber.getText().trim().length();
		int len4 = jbtchildticketnumber.getText().trim().length();
		int len5 = jbttelephone.getText().trim().length();
		float piaojia = 0;
		if (e.getSource() == handin) {
			string[12] = jbtname.getText().trim();
			string[13] = jbtid.getText().trim();
			int i = 0;// 单程定票数量
			int j = 0;// 住返和联程定票数量
			if (len1 == 0 || len2 == 0 || len3 == 0 || len4 == 0 || len5 == 0) {
				String str = getstring(len1, len2, len3, len4, len5);
				JOptionPane.showMessageDialog(this, str, "错误信息！",
						JOptionPane.ERROR_MESSAGE);
			} else {
				adultnumber = Integer.parseInt(jbtadultticketnumber.getText()
						.trim());
				childnumber = Integer.parseInt(jbtchildticketnumber.getText()
						.trim());
				string[14] = String.valueOf(adultnumber);
				string[15] = String.valueOf(childnumber);
				ticketnumber = adultnumber + childnumber;
				// //单程
				if (string[5].toString().trim().equals("单程")) {
					i = seatinformation.dingPiao(string[4], string[3],
							ticketnumber);
					if (i != -2) {
						if (i == -1) {
							float adultfare = 0;
							float childfare = 0;
							
							try {
								Connection con = DbBean.getDb();
								Statement stmt = con.createStatement();
								ResultSet rs = stmt
										.executeQuery("select adultFare,childFare from flightTick where flight='"
												+ string[4] + "'");
								while (rs.next()) {
									adultfare = rs.getFloat(1);
									childfare = rs.getFloat(2);
								}
								rs.close();
								stmt.close();
								con.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							piaojia = adultnumber * adultfare + childnumber
									* childfare;
							String dingdan = string[3]
									+ string[4]
									+ String.valueOf((int) (2000 * Math
											.random()));
							string[16] = dingdan;
							string[21] = "" + piaojia;
							JOptionPane.showMessageDialog(this,
									"   您的定票信息提交成功\n您的定单号是" + dingdan + "\n"
											+ "您应付价钱为" + piaojia, "客户信息",
									JOptionPane.INFORMATION_MESSAGE);
							TickManager.clientFrame.setVisible(false);
							TickManager.clientFrame.dispose();
							TickManager.frame.setVisible(true);
							saveClient(piaojia,dingdan);
						} else {
							JOptionPane.showMessageDialog(this, "非常抱歉！只有" + i
									+ "张航班票剩余\n请您重新选择票数", "客户信息",
									JOptionPane.INFORMATION_MESSAGE);
							jbtadultticketnumber.setText(" ");
							jbtchildticketnumber.setText(" ");
						}
					} else {
						JOptionPane.showMessageDialog(null, "对不起，今天没有这个航班",
								"客户信息", JOptionPane.ERROR_MESSAGE);
					}
				}
				// 往返
				else 
				{
					i = seatinformation.dingPiao(string[4], string[3],
							ticketnumber);
					j = seatinformation.dingPiao(string[11], string[10],
							ticketnumber);
					if (i == -2)
						JOptionPane.showMessageDialog(null, "对不起，今天没有第一个航班",
								"客户信息", JOptionPane.ERROR_MESSAGE);
					else if (j == -2)
						JOptionPane.showMessageDialog(null, "对不起，今天没有第二个航班",
								"客户信息", JOptionPane.ERROR_MESSAGE);
					else {
						if (i == -1 && j == -1) {
							float adultfare = 0;
							float childfare = 0;
							try {
								Connection con = DbBean.getDb();
								Statement stmt = con.createStatement();
								ResultSet rs = stmt
										.executeQuery("select adultFare,childFare from flightTick where flight='"
												+ string[4] + "'");
								while (rs.next()) {
									adultfare = rs.getFloat(1);
									childfare = rs.getFloat(2);
								}
								rs.close();
								stmt.close();
								con.close();

							} catch (Exception ex) {
							}
							piaojia = adultnumber * adultfare + childnumber
									* childfare;
							try {
								Connection con = DbBean.getDb();
								Statement stmt = con.createStatement();
								ResultSet rs = stmt
										.executeQuery("select adultFare,childFare from flightTick where flight='"
												+ string[11] + "'");
								while (rs.next()) {
									adultfare = rs.getFloat(1);
									childfare = rs.getFloat(2);
								}
								rs.close();
								stmt.close();
								con.close();

							} catch (Exception ex) {
							}
							piaojia = piaojia + adultnumber * adultfare
									+ childnumber * childfare;
							String dingdan = string[3]
									+ string[4]
									+ String
											.valueOf((int) (100 * Math.random()));
							string[16] = dingdan;
							string[21] = "" + piaojia;
							JOptionPane.showMessageDialog(this,
									"   恭喜！提交成功\n你的定单号是" + dingdan + "\n"
											+ "你应付价钱为" + piaojia, "客户信息",
									JOptionPane.INFORMATION_MESSAGE);
							saveClient(piaojia,dingdan);
							TickManager.clientFrame.setVisible(false);
							TickManager.clientFrame.dispose();
							TickManager.frame.setVisible(true);

						}
						else {
							if (i != -1) {
								JOptionPane.showMessageDialog(this, "非常抱歉！只有"
										+ i + "张第一航班票剩余\n请您重新选择票数", "客户信息",
										JOptionPane.INFORMATION_MESSAGE);
								jbtadultticketnumber.setText(" ");
								jbtchildticketnumber.setText(" ");
							} else {
								if (j != -1) {
									JOptionPane.showMessageDialog(this,
											"非常抱歉！只有" + j
													+ "张返回航班票剩余\n请您重新选择票数",
											"客户信息",
											JOptionPane.INFORMATION_MESSAGE);
									jbtadultticketnumber.setText(" ");
									jbtchildticketnumber.setText(" ");
								}
							}
						}
					}
				}
			}
		}
		if (e.getSource() == rewrite) {
			jbtname.setText("");
			jbtid.setText("");
			jbtadultticketnumber.setText("");
			jbtchildticketnumber.setText("");
			jbttelephone.setText("");
			jbtemail.setText("");
			jbtps.setText("");
		}
		if (e.getSource() == return1) {
			TickManager.clientFrame.setVisible(false);
			TickManager.clientFrame.dispose();
			TickManager.frame.setVisible(true);
		}
	}
//保存客户定票信息
	public void saveClient(float piaojia,String dingdan) {
		Connection con = DbBean.getDb();
		String sql = "insert into ClientInfo(name,id,start,end,starttime,returntime,flight,telephone,email" +
				",ps,returnflight,adultticketnumber,childticketnumber,airfirm,style,piaojia,po)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.jbtname.getText());
			pstmt.setString(2, this.jbtid.getText());
			pstmt.setString(3, this.jbtstart.getText());
			pstmt.setString(4, this.jbtend.getText());
			pstmt.setString(5, this.jbtstarttime.getText());
			pstmt.setString(6, this.jbtreturntime.getText());
			pstmt.setString(7, this.jbtflight.getText());
			pstmt.setString(8, this.jbttelephone.getText());
			pstmt.setString(9, this.jbtemail.getText());
			pstmt.setString(10, this.jbtps.getText());
			pstmt.setString(11, this.jbtreturnflight.getText());
			pstmt.setInt(12, adultnumber);
			pstmt.setInt(13, childnumber);
			pstmt.setString(14, this.jbtairfirm.getText());
			pstmt.setString(15, this.jbtstyle.getText());
			pstmt.setDouble(16, piaojia);
			pstmt.setString(17,dingdan);
			pstmt.execute();
			con.commit();
			pstmt.close();
			con.close();
		} catch (java.sql.SQLException ex) {
			ex.printStackTrace();

		}
	}
	public String getstring(int i, int j, int r, int s, int l) {
		if (i == 0)
			return "姓名不能为空！";
		else if (j == 0)
			return "证件号不能为空！";
		else if (r == 0)
			return "成人票数不能为空！";
		else if (s == 0)
			return "儿童票数不能为空";
		else if (l == 0)
			return "电话号码不能为空";
		return "ERROR!";
	}
	private void initGUI() {
		try {
			getContentPane().add(p10, BorderLayout.CENTER);
			{
				this.setSize(581, 325);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}