package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import otcyan.java.tools.Tookit;

public class Introduce extends JPanel{

	JPanel jPanel = null ;
	public Introduce(){
		this.init();
	}

	private void init() {
		
		JPanel jPanel = new JPanel(new BorderLayout()) ;
		JLabel jLabel = new JLabel("�ɻ���Ʊϵͳ");
		jLabel.setFont(new Font("΢���ź�", Font.BOLD, 24)) ;
		jPanel.add(jLabel,BorderLayout.NORTH) ;
		
		JPanel center = new JPanel(new BorderLayout()) ;
		JLabel picture = new JLabel(new ImageIcon("image/jianjie.jpg")) ;
		//center.setPreferredSize(new Dimension(315,155)) ;
		JLabel text = new JLabel("<html>���չ�˾(Airlines)���Ը��ֺ��շ�����Ϊ���乤��Ϊ�˿ͺͻ���<br>�ṩ���ú��շ������ҵ������һ����Ҫ<br>һ���ٷ��Ͽɵ�����֤�����׼�����չ�˾ʹ�õķ����������������Լ�<br>ӵ�еģ�Ҳ�����������ģ����ǿ��Զ���<br>�ṩ���񣬻������������չ�˾�ϻ����������ˡ�<br>���չ�˾�Ĺ�ģ���Դ�ֻ��һ�������ʼ������ķɻ���ӵ�����ټܷɻ�<br>�ṩ����ȫ���Է���Ĺ��ʺ��չ�˾�����չ�˾�ķ���<br>��Χ���Է��޼ʵġ����ڵġ����ڵģ�Ҳ���Էֺ�<br>�����Ͱ�������</html>");
		text.setFont(Tookit.getFont1());
		center.add(picture,BorderLayout.WEST) ;
		center.add(text) ;
		
		center.setOpaque(false) ;
		jPanel.add(center) ;
		jPanel.setOpaque(false) ;
		//this.setOpaque(false) ;
		this.add(jPanel) ;
		this.setSize(1008,680) ;
		this.setBackground(new Color(0x498DF8)) ;
	
	}

	public JPanel getjPanel() {
		return jPanel;
	}
	
}
