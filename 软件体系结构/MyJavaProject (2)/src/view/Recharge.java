package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import system.MyTool;
import system.SqlOperation;

public class Recharge extends JPanel{
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,title=null;
	JTextField t1,t2,t3;
	JButton btn = new JButton("ȥ��ֵ");
	private JRadioButton b1 = new JRadioButton("100"), 
			b2 =  new JRadioButton("500"),b3 =  new JRadioButton("1000"),
	b4 =  new JRadioButton("2000"),b5 =  new JRadioButton("5000"),
	b6 =  new JRadioButton(" ȡ��");
	private ButtonGroup btnGroup = new ButtonGroup();
	public Recharge()
	{
		setLayout(null);
		title = new JLabel("��ֵ����");
		title.setFont(MyTool.getFontB(15));
		title.setOpaque(true);
		title.setForeground(Color.BLUE);
		title.setBounds(320,50,180,30);
		l0=new JLabel("��ֵ�˺�");
		l0.setBounds(200,100,100,30);
		l1=new JLabel("��ֵ���");
		l1.setBounds(200,150,100,30);
		t1=new JTextField();
		t1.setBounds(300,150,150,27);
		t2=new JTextField();
		t2.setBounds(300,100,150,27);
		l2=new JLabel("��Ҫ����");
		l2.setBounds(200,200,100,30);
		
		b1.setBounds(300,200,50,30);
		b2.setBounds(360,200,50,30);
		b3.setBounds(410,200,50,30);
		b4.setBounds(300,250,50,30);
		b5.setBounds(360,250,50,30);
		b6.setBounds(410,250,50,30);
		btnGroup.add(b1);
		btnGroup.add(b2);
		btnGroup.add(b3);
		btnGroup.add(b4);
		btnGroup.add(b5);
		btnGroup.add(b6);
		btn.setBounds(310, 330, 100, 30);
		add(l0);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(title);
		add(btn);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //������ʽ�ֻ���
				String regExcetion2 ="[0-9]+"; //������ʽ����
				int newMoney;
				boolean result =  t2.getText().matches(regExcetion); //�û���ƥ��
				boolean result2 =  t1.getText().matches(regExcetion2); 
				if(result)
				{
					String phone=t2.getText();
					if(SqlOperation.checkPassenger(phone))//����иó˿�
					{
						if(b1.isSelected())
						{
							newMoney = SqlOperation.moneySearch(phone)+100;
						}else if(b2.isSelected())
						{
							newMoney = SqlOperation.moneySearch(phone)+500;
						
					}else if(b3.isSelected())
					{
						newMoney = SqlOperation.moneySearch(phone)+1000;
					
				}else if(b4.isSelected())
				{
					newMoney = SqlOperation.moneySearch(phone)+2000;
				
				}else if(b5.isSelected())
				{
					newMoney = SqlOperation.moneySearch(phone)+5000;
				
				}else 
				{
					if(result2)
					{
						newMoney = SqlOperation.moneySearch(phone)+Integer.valueOf(t1.getText());
					}else {
						JOptionPane.showMessageDialog(null, "��ȷ�����ĳ�ֵ���");
						return;
					}
					
				}
					SqlOperation.moneyUpdata(phone, newMoney);
					JOptionPane.showMessageDialog(null, "��ϲ��!��ֵ�ɹ�");
					}
					
				}else {//�����ڸ��û�
					JOptionPane.showMessageDialog(null, "�����ڸ��û�");
				}
		}});
		
		
	}
}
