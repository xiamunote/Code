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

public class BackTickit extends JPanel{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JButton btn = new JButton("��Ҫ��Ʊ");
	JRadioButton b1 = new JRadioButton("��Ʊ����"), 
			b2 =  new JRadioButton("�۸�����"),b3 =  new JRadioButton("����ԭ��");
	ButtonGroup btnGroup = new ButtonGroup();
	public BackTickit()
	{
		setLayout(null);
		l1=new JLabel("��Ʊ����");
		l1.setFont(MyTool.getFontB(15));
		l1.setOpaque(true);
		l1.setForeground(Color.BLUE);
		l1.setBounds(320,50,180,30);
		l2=new JLabel("�ֻ���");
		l2.setBounds(200,100,100,30);
		l3=new JLabel("��Ʊ����");
		l3.setBounds(200,150,100,30);
		t1=new JTextField();
		t1.setBounds(300,100,150,27);
		
		b1.setBounds(300,150,100,30);
		b2.setBounds(300,200,100,30);
		b3.setBounds(300,250,100,30);
		btnGroup.add(b1);
		btnGroup.add(b2);
		btnGroup.add(b3);
		btn.setBounds(300, 330, 100, 30);
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //������ʽ�ֻ���
				boolean result =  t1.getText().matches(regExcetion); //�û���ƥ��
				if(result)
				{
					String phone=t1.getText();
					if(SqlOperation.checkPassenger(phone))//����иó˿�
					{
						if(b1.isSelected()||b2.isSelected()||b3.isSelected())
						{	int newMoney = SqlOperation.moneySearch(phone)+QueryResult.allPrice;
							SqlOperation.moneyUpdata(phone, newMoney);//��Ǯ
							int leftTickit =SqlOperation.tickitNumSearch((String)Passenger.a.table.getValueAt(Passenger.a.r, 0));//ʣ�µ�Ǯ
	   	   						if(leftTickit==-1)
	   	   						{
	   	   							JOptionPane.showMessageDialog(null, "���ݿ��쳣");
	   	   								System.exit(1);
	   	   						}
	   	   						int mm =Integer.parseInt(Passenger.tickitQueryPanel.c2.getSelectedItem().toString());//�����Ʊ��
	   	   						SqlOperation.tickitNumUpdata((String)Passenger.a.table.getValueAt(Passenger.a.r, 0),leftTickit+mm);
							JOptionPane.showMessageDialog(null, "��Ʊ�ɹ�,�Է���"+QueryResult.allPrice+"Ԫ,"+"��ע�����");
							Passenger.card.show(Passenger.mainPanel, "p4") ;//û���˵���
							Passenger.ifBuy=false;
						}else {
							JOptionPane.showMessageDialog(null, "��ѡ����Ʊ�����أ���");
						}
					}else {
						JOptionPane.showMessageDialog(null, "���˺Ų�����");

					}
				}else {
					JOptionPane.showMessageDialog(null, "����д��ȷ���ֻ���");

				}
			}
		});
		add(l1);
		add(l2);
		add(l3);
		add(t1);
		add(b1);
		add(b2);
		add(b3);
		add(btn);
	}
}
