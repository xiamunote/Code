package view;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import system.MyTool;

public class Help extends JDialog{

	/**
	 * 帮助面板
	 */
	private static final long serialVersionUID = 1L;

	public Help(JFrame owner){
		this.init() ;
	}
	
	public void init(){
		 
		 
		 JPanel jPanel = new JPanel() ;
		jPanel.setBackground(new Color(0xB9CAF3)) ;
		 
		 JLabel picture = new JLabel(new ImageIcon("pic_login/登录.png"));
		 JLabel text = new JLabel() ;
		 text.setFont(MyTool.getFontP(12)) ;
		 text.setText("<html>欢迎使用飞机订票客户端,程序主要分为四个功能：<br>1.机票预订：从北京上海,南昌的往来航班较多,其他地区较少<br>  每个账号限购10张<br>2.取票查询：旅客根据我的账单获取账单号或凭身份证前往<br>3.充值中心：通过手机号绑定的卡可直接选择金额充值<br>4.退票处理：输入订单和身份证或者前台退票</html>") ;
		 jPanel.add(picture) ;
		 jPanel.add(text) ;
		 this.add(jPanel) ;
		 
		 setSize(500,200);
		 setTitle("帮助");
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setModal(true) ;
		 this.setVisible(true) ;
	}
}
