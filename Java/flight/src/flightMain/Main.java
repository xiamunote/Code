package flightMain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import flightView.FlightViews;
import flightUnsubscribe.*;

public class Main extends Frame
{

	public static void main(String[] args)
	{
		Frame f = new Frame("��ƱԤ��ϵͳ");
		f.setLocation(300,80);
		f.setSize(800, 600);
		BackgroundPanel bgp=new BackgroundPanel((new ImageIcon("D:/�ļ�/���/Java/flight/image/��ҳ.jpg")).getImage()); //������һ��Image����,
	    bgp.setBounds(0,0,800,600);   
	    JButton jb1=new JButton("��ƱԤ��");  
	    jb1.setBounds(300,200,200,50);
	    jb1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
//	            System.out.println("��ƱԤ��");
	            FlightViews fv = new FlightViews();
	        }
	    });
	    f.add(jb1);
	    JButton jb2=new JButton("ȡ��Ԥ��");
	    jb2.setBounds(300,300,200,50);
	    jb2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	FlightUnsubscribe fu = new FlightUnsubscribe();
	        }
	    });
	    f.add(jb2);
	    f.add(bgp);
		f.setResizable(false);
		f.setVisible(true);
	    f.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
	    });
	}

}
