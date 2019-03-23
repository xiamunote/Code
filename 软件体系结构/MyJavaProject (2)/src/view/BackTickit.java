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
	JButton btn = new JButton("我要退票");
	JRadioButton b1 = new JRadioButton("买票错误"), 
			b2 =  new JRadioButton("价格问题"),b3 =  new JRadioButton("其它原因");
	ButtonGroup btnGroup = new ButtonGroup();
	public BackTickit()
	{
		setLayout(null);
		l1=new JLabel("退票处理");
		l1.setFont(MyTool.getFontB(15));
		l1.setOpaque(true);
		l1.setForeground(Color.BLUE);
		l1.setBounds(320,50,180,30);
		l2=new JLabel("手机号");
		l2.setBounds(200,100,100,30);
		l3=new JLabel("退票理由");
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
				String regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
				boolean result =  t1.getText().matches(regExcetion); //用户名匹配
				if(result)
				{
					String phone=t1.getText();
					if(SqlOperation.checkPassenger(phone))//如果有该乘客
					{
						if(b1.isSelected()||b2.isSelected()||b3.isSelected())
						{	int newMoney = SqlOperation.moneySearch(phone)+QueryResult.allPrice;
							SqlOperation.moneyUpdata(phone, newMoney);//返钱
							int leftTickit =SqlOperation.tickitNumSearch((String)Passenger.a.table.getValueAt(Passenger.a.r, 0));//剩下的钱
	   	   						if(leftTickit==-1)
	   	   						{
	   	   							JOptionPane.showMessageDialog(null, "数据库异常");
	   	   								System.exit(1);
	   	   						}
	   	   						int mm =Integer.parseInt(Passenger.tickitQueryPanel.c2.getSelectedItem().toString());//购买的票数
	   	   						SqlOperation.tickitNumUpdata((String)Passenger.a.table.getValueAt(Passenger.a.r, 0),leftTickit+mm);
							JOptionPane.showMessageDialog(null, "退票成功,以返回"+QueryResult.allPrice+"元,"+"请注意查收");
							Passenger.card.show(Passenger.mainPanel, "p4") ;//没有账单了
							Passenger.ifBuy=false;
						}else {
							JOptionPane.showMessageDialog(null, "请选择退票理由呢，亲");
						}
					}else {
						JOptionPane.showMessageDialog(null, "该账号不存在");

					}
				}else {
					JOptionPane.showMessageDialog(null, "请填写正确的手机号");

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
