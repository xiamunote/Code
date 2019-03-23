package otcyan.java.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import otcyan.java.tools.Tookit;

public class HelpDialog extends JDialog{

	public HelpDialog(JFrame owner){
		super(owner) ;
		this.init() ;
	}
	
	public void init(){
		 
		 
		 JPanel jPanel = new JPanel() ;
		jPanel.setBackground(new Color(0xA9CAF3)) ;
		 
		 JLabel picture = new JLabel(new ImageIcon("image/logo.jpg"));
		 JLabel text = new JLabel() ;
		 text.setFont(Tookit.getFont1()) ;
		 text.setText("<html>������ͨ�ÿ͵Ŀͻ��˳�����Ҫ��Ϊ�ĸ����ܣ�<br>1.�����ѯ��Ԥ�����ÿ�����������и�������п��Բ�ѯ<br>�������·�ߵĺ�����Ϣ�����Ԥ������Ԥ��<br>2.ȡƱ��ѯ���ÿ͸������֤�����Ʊ�Ų�ѯ�������ķɻ�Ʊ<br>3.���ද̬���ÿ�����������и�������п��Բ�ѯ�������<br>·�ߵĺ�����Ϣ�������ٶ�̬<br>4.��Ʊ�����������֤�Ÿ�Ʊ�Ž���ǰ̨��Ʊ</html>") ;
		 jPanel.add(picture) ;
		 jPanel.add(text) ;
		 this.add(jPanel) ;
		 
		 setSize(500,300);
		 setTitle("����");
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setResizable(false);
		 this.setModal(true) ;
		 this.setVisible(true) ;
	}
}
