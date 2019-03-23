package example1_2;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ButtonFrame{
	public static void main(String[] args){
		EventQueue.invokeLater(() -> {
    	JFrame frame= new CreatButtonFrame();
        frame.setTitle("ButtonTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);});	
	}
}
 
class CreatButtonFrame extends JFrame implements ActionListener{
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private Button yellowButton,blueButton,redButton;
	public CreatButtonFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		yellowButton=new Button("yellow");
		blueButton=new Button("blue");
		redButton=new Button("red");
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
	}
	public void actionPerformed(ActionEvent event) {
		Object source=event.getSource();
		if(source==yellowButton) {
			buttonPanel.setBackground(Color.yellow);
		}else if(source==blueButton) {
			buttonPanel.setBackground(Color.blue);
		}else if(source==redButton){
			buttonPanel.setBackground(Color.red);
		}
	}
}