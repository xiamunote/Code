/*
 * ����һ�����Զ�̬����ͼƬ��JPanel�ı���
 */
package otcyan.java.tools;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
public class ImagePanel extends JPanel{
	Image im;
	Dimension dimension ;
	public ImagePanel(Image im,Dimension dimension)
	{
		this.im=im;
		this.dimension = dimension ;
		//����Ҫ����Panel��С
		//����Ӧ��Ļ
		this.setSize(dimension);
	}
	//�����������Զ�����
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im,0,0,dimension.width,dimension.height,this);
	}
}
