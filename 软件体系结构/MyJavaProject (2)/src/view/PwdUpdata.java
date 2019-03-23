package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import system.MyTool;
import system.SqlOperation;

public class PwdUpdata extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,title=null;
	JTextField t1,t2,t0;
	Button btn = new Button("OK");
	public PwdUpdata()
	{
		setLayout(null);
		title = new JLabel("密码修改");
		title.setFont(MyTool.getFontB(15));
		title.setOpaque(true);
		title.setForeground(Color.BLUE);
		title.setBounds(140,20,80,30);
		l0=new JLabel("手机号");
		l0.setBounds(50,80,50,30);
		l1=new JLabel("原密码");
		l1.setBounds(50,120,50,30);
		l2=new JLabel("新密码");
		l2.setBounds(50,160,150,30);
		t0=new JTextField();
		t0.setBounds(110,80,150,27);
		t1=new JTextField();
		t1.setBounds(110,120,150,27);
		t2=new JTextField();
		t2.setBounds(110,160,150,27);
		btn.setBounds(130, 200, 80, 30);
		add(l0);
		add(l1);
		add(l2);
		add(t0);
		add(t1);
		add(t2);
		
		add(title);
		add(btn);
		setVisible(true);
		setSize(300,300);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				Login.login.show();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				Login.login.dispose();
			}
			
		});
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
				String regExcetion2 = "[0-9a-zA-Z]{2,12}";; //正则表达式手机号，1到多12个
				int newMoney;
				boolean result1 =  t0.getText().trim().matches(regExcetion); //用户名匹配
				boolean result2 =  t1.getText().trim().matches(regExcetion2); //密码匹配
				boolean result3 =  t2.getText().trim().matches(regExcetion2); //新密码匹配
				String phone=t0.getText();
				String pwd=t1.getText();
				String newPwd=t2.getText();
				if(result1)
				{
					
					if(SqlOperation.checkPassenger(phone))//如果有该乘客
					{
						if(result2&&result3)
						{
							if(SqlOperation.login_check(phone,pwd))//原密码正确
							{
								if(!pwd.trim().equals(newPwd.trim()))
								{
									if(SqlOperation.pwdUpdata(phone, newPwd))
									{
										JOptionPane.showMessageDialog(null, "新密码: "+newPwd);
										Login.login.show();
									}else {
										JOptionPane.showMessageDialog(null, "密码修改失败");
									}
								}else
								{
									JOptionPane.showMessageDialog(null, "与原密码相同");
								}
								
							}else {
								JOptionPane.showMessageDialog(null, "原密码错误");
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "请检查密码格式是否有误");
						}
					}else {
						JOptionPane.showMessageDialog(null, "账号不存在");
					}
					
				
				}else 
				{
					
						JOptionPane.showMessageDialog(null, "请填写正确的手机号");
						
				}
					
				
					
		}});
		
		
	}
}
