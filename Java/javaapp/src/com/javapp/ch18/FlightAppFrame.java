package com.javapp.ch18;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.net.URL;

/**
 * Description:航空电子票务管理类

 */
class FlightAppFrame extends JPanel implements ActionListener {
	private Query query;

	private Refundticket tuiPiao;

	private TickManager dingPiao;

	private JButton jbQuery = new JButton("航班信息查询");

	private JButton jbManager = new JButton("航班信息管理");

	private JButton jbDingPiao = new JButton("客户订票管理");

	private JButton jbTuiPiao = new JButton("客户退票管理");
	private JButton FindClient = new JButton("查询己订票客户信息");
	ImageIcon log = new ImageIcon(this.getClass().getResource("MA60.jpg"));
	JLabel jLabel2 = new JLabel();
	public FlightAppFrame() {
		this.setLayout(null);
		this.setPreferredSize(new java.awt.Dimension(811, 345));
		this.add(FindClient);
		FindClient.setBounds(567, 303, 162, 26);

		jLabel2.setIcon(log);
		jLabel2.setBounds(0, 0, 811, 291);
		jLabel2.setVisible(true);

		jLabel2.setText("[629, 291]");
		this.add(jLabel2);
		this.add(jbQuery);
		this.add(jbDingPiao);
		this.add(jbTuiPiao);
		this.add(jbManager);

		jbQuery.setBounds(6, 303, 134, 30);
		jbDingPiao.setBounds(294, 303, 125, 30);
		jbTuiPiao.setBounds(152, 303, 130, 30);
		jbManager.setBounds(438, 303, 117, 30);

		jbQuery.addActionListener(this);
		jbManager.addActionListener(this);
		jbDingPiao.addActionListener(this);
		jbTuiPiao.addActionListener(this);
		FindClient.addActionListener(this);
	}

	public void paintComponent(Graphics g) {
		ImageIcon imageIcon = new ImageIcon("jiemian.gif");
		Image image = imageIcon.getImage();

		g.drawImage(image, 0, 0, this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbQuery) {
			query = new Query();

			query.pack();
			query.setTitle("航班查询系统");
			query.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			query.setVisible(true);
		}

		else if (e.getSource() == jbManager) {
			FlightManager insertPanel = new FlightManager();

			insertPanel.pack();
			insertPanel.setResizable(false);
			insertPanel.setTitle("航班信息管理");
			insertPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			insertPanel.setVisible(true);

		}

		else if (e.getSource() == jbDingPiao) {
			dingPiao = new TickManager();
			dingPiao.pack();

			dingPiao.setResizable(false);
			dingPiao.setTitle("电子机票预定管理");
			dingPiao.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			dingPiao.setVisible(true);
		}

		else if (e.getSource() == jbTuiPiao) {
			tuiPiao = new Refundticket();

			tuiPiao.pack();
			tuiPiao.setResizable(false);
			tuiPiao.setTitle("电子机票退票系统");
			tuiPiao.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			tuiPiao.setVisible(true);
		}
		else if (e.getSource() == FindClient) {
			
			FrameTable frame = new FrameTable();
			frame.pack();
			frame.setVisible(true);
			
		}
	}
}