package com.javapp.ch18;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Description:�����ѯѡ����

 */
public class Query extends JFrame {
	public Query() {
		JTabbedPane jtp = new JTabbedPane();
		jtp.add("�򵥲�ѯ ", new CommonQuery());
		jtp.add("�ۺϲ�ѯ", new ComprehenQuery());
	
		this.getContentPane().add(jtp);
		jtp.setPreferredSize(new java.awt.Dimension(474, 274));
		initGUI();
	this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Query.this.setVisible(false);
				Query.this.dispose();
				
			}
		});
	}

	
	private void initGUI() {
		try {
			{
				this.setSize(506, 214);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
