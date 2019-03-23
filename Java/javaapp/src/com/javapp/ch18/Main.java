package com.javapp.ch18;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame
{
    private UpdateComboBox update;
    private FlightAppFrame jiemian;
	public Main()
	{
		update = new UpdateComboBox();
		jiemian = new FlightAppFrame();
		this.getContentPane().add(jiemian);		
	}

	public static void main(String args[])
	{
		Main frame = new Main();
		frame.setSize(690,400);
		frame.setResizable(true);
		frame.setTitle("航空电子票务综合管理系统");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}