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
	 * �������
	 */
	private static final long serialVersionUID = 1L;

	public Help(JFrame owner){
		this.init() ;
	}
	
	public void init(){
		 
		 
		 JPanel jPanel = new JPanel() ;
		jPanel.setBackground(new Color(0xB9CAF3)) ;
		 
		 JLabel picture = new JLabel(new ImageIcon("pic_login/��¼.png"));
		 JLabel text = new JLabel() ;
		 text.setFont(MyTool.getFontP(12)) ;
		 text.setText("<html>��ӭʹ�÷ɻ���Ʊ�ͻ���,������Ҫ��Ϊ�ĸ����ܣ�<br>1.��ƱԤ�����ӱ����Ϻ�,�ϲ�����������϶�,������������<br>  ÿ���˺��޹�10��<br>2.ȡƱ��ѯ���ÿ͸����ҵ��˵���ȡ�˵��Ż�ƾ���֤ǰ��<br>3.��ֵ���ģ�ͨ���ֻ��Ű󶨵Ŀ���ֱ��ѡ�����ֵ<br>4.��Ʊ�������붩�������֤����ǰ̨��Ʊ</html>") ;
		 jPanel.add(picture) ;
		 jPanel.add(text) ;
		 this.add(jPanel) ;
		 
		 setSize(500,200);
		 setTitle("����");
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setModal(true) ;
		 this.setVisible(true) ;
	}
}
