package otcyan.java.tools;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyLoginPanel extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//�����Դ 
		ImageIcon iIcon = new ImageIcon("image/bg0104.jpg") ;
		//��һ������ͼ
		g.drawImage(iIcon.getImage(), 0, 0, 823, 350, null) ;
	}

	
}
