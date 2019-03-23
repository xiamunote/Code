package view;

import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import system.DatabaseInit;
import system.SqlOperation;
import system.SqlUtil;


public class Login extends JFrame{
	/**
	 * 登录窗口
	 */
	private static final long serialVersionUID = 1L;// default serial version id
	private JPasswordField password ;
	public static String userPassenger,userAdmini,passengerID,admiID,passPwd,admiPwd;
	private Robot robot=null; //用于模拟按键
	public static JPanel panel_usernameError = null, panel_pwdError = null, panel_pwdstate =null;
	public static JTextField username = null;
	private JRadioButton radiobutton_passenger = null, radiobutton_admi = null;
	public static JButton button_Login = null;
	private Font errorFont = new Font("宋体",Font.PLAIN,11);//错误字体设计
	private ImageIcon backImage = new ImageIcon("pic_login\\登录.gif");
	private ImageIcon image_plane = new ImageIcon("pic_login\\航班.png");
	private ImageIcon image_passenger = new ImageIcon("pic_login\\乘客.png");
	private ImageIcon admistrator = new ImageIcon("pic_login\\管理员.png");
	private ImageIcon image_pwdShow = new ImageIcon("pic_login\\显示密码.png");
	private ImageIcon image_pwdClose = new ImageIcon("pic_login\\密码不显示.png");
	private ImageIcon image_warning = new ImageIcon("pic_login\\警告.png");
	private ImageIcon head0 = new ImageIcon("pic_login\\头像0.png");
	private ImageIcon head1 = new ImageIcon("pic_login\\头像1.png");
	private ImageIcon head2 = new ImageIcon("pic_login\\头像2.png");
	private ImageIcon head3 = new ImageIcon("pic_login\\头像3.png");
	private ImageIcon head4 = new ImageIcon("pic_login\\头像4.png");
	private ImageIcon head5 = new ImageIcon("pic_login\\头像5.png");
	private ImageIcon head6 = new ImageIcon("pic_login\\头像6.png");
	private ImageIcon head7 = new ImageIcon("pic_login\\头像7.png");
	private ButtonGroup btnGroup;
	private String regExcetion, trueChar,regExcetion2,trueChar2;
	private JLabel label_pwdopen , label_pwdclose,title_abel , label_register, 
			label_pwd, label_error1 , label_error2, label_error3 ,
			label_error4 , label_error5 , label_error6 ,label_error7,label_warn,label_phone,
			label_pwdlength;
	public static JLabel label,label_containHead;
	private CardLayout cardlayout = new CardLayout();//用于错误提示
	private CardLayout cardlayout2 = new CardLayout();//用于密码显示隐藏
	private int checkflag = 0;//用于判断密码显示状态，为0表示当前不可见
	 static Login login ;
		public Login() {//不允许外界调用
		super("飞机订票");
		Toolkit tool=this.getToolkit(); //得到一个Toolkit对象
		Image myimage=tool.getImage("pic_login//登录图标.png"); //由tool获取图像
		setIconImage(myimage);//设置窗口图标
		setUndecorated(true); //隐藏窗框
		//采用指定的窗口装饰风格
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);//改变窗体修饰
		setBounds(0, 0, 450, 300);
		setLayout(null);

		title_abel = new JLabel();
		title_abel.setBounds(0,0,450,80);
		title_abel.setIcon(backImage);
		title_abel.setOpaque(false);
		add(title_abel);
		
		//添加组件
		label_containHead = new JLabel();//注意head先定义在label前，登陆成功时才能显示头像
		label_containHead.setBackground(Color.YELLOW);
		label_containHead.setBounds(30,120,100,100);
		label_containHead.setIcon(image_plane);
		label_containHead.setBorder(BorderFactory.createLineBorder(new Color(144,119,119),2));//设置边框
		label_containHead.setOpaque(true);
		
		add(label_containHead);
		
		label = new JLabel();//用于登录时覆盖隐藏其他控件
		label.setOpaque(true);//不清楚为什么是true,false显示不出颜色
		label.setBounds(180,25,270,190);
		label.setBackground(new Color(232,238,238));//这个颜色能隐藏的不露痕迹
		label.setVisible(false);//遮挡物，默认不可见
		add(label);
		
		label_warn = new JLabel("请先选择登录对象");
		label_warn.setBounds(210,76,150,30);
		label_warn.setIcon(image_warning);
		label_warn.setForeground(Color.RED);
		label_warn.setVisible(false);
		label_warn.setFont(errorFont);
		add(label_warn);
		
		
	
		//窗口监听
		this.addWindowListener(new WindowAdapter(){//窗口打开就让头像获得焦点，否则会在radiobutton1获得，影响美观
		       public void windowOpened(WindowEvent e) {
		    	   label_containHead.requestFocus();
		       }
		       public void windowClosing(WindowEvent e) {
		       }
		});
		
		btnGroup = new ButtonGroup();
		radiobutton_passenger= new JRadioButton("普通乘客");
		radiobutton_admi= new JRadioButton("终端管理");
		radiobutton_passenger.setBounds(190,100,80,50);
		radiobutton_passenger.setOpaque(false);//设置透明主要是为了登录时的头像移到中间优先显示头像
		radiobutton_admi.setBounds(270,100,80,50);
		radiobutton_admi.setOpaque(false);
		add(radiobutton_passenger);
		add(radiobutton_admi);
		btnGroup.add(radiobutton_passenger);
		btnGroup.add(radiobutton_admi);
		radiobutton_passenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_containHead.setIcon(image_passenger);
				label_warn.setVisible(false);
			}
		});
		radiobutton_admi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_containHead.setIcon(admistrator);
				label_warn.setVisible(false);
			}
		});
		
		username = new JTextField();
		username.setFont(new Font("宋体",Font.BOLD,16));//设置字体
		username.setBounds(180,150,150,25);
		username.setOpaque(false);
		username.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//设置密码边框,1像素（默认）
		add(username);
		label_phone = new JLabel("手机号");//在用户名框显示该提示
		label_phone.setOpaque(false);
		label_phone.setBounds(185,150,100,25);
		label_phone.setBackground(Color.white);
		label_phone.setForeground(Color.gray);
		label_phone.setFont(new Font("宋体",Font.PLAIN,11));
		add(label_phone);
		
		//添加监听
		
		username.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {//获得focus
				username.enableInputMethods(false); //禁用掉输入法
				username.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
				if(username.getText().length()==0){
				label_phone.setVisible(false);//隐藏手机提示
				}
			}
			public void focusLost(FocusEvent e) {//失去focus
				// TODO Auto-generated method stub
				username.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
				if(username.getText().length()==0) {//手机规范重新可见
				label_phone.setVisible(true);
				}
			}
			
		});
		username.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，typed和press有区别
			public void keyTyped(KeyEvent e){
				// TODO Auto-generated method stub
				if( username.getText().length()>11) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				 if(e.getKeyChar()==KeyEvent.VK_ENTER )   
			        { 
			          button_Login.doClick();//回车键触发登录按钮点击
			        } 
				 if(e.getKeyChar()==KeyEvent.VK_SPACE && username.getText().length()>0  && username.getText().length()!=12)  //开头不允许出现空格,之所以不让在一开始就限制空格仅仅是给用户一个人好的键盘感受体验 
			        { 
					 try {
							robot = new Robot();
						} catch (AWTException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						robot.keyPress(8);//模拟按键BackSpace退格
					 } 
					
			      
				 
			}
		
		});
		username.getDocument().addDocumentListener (new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				
				label_phone.setVisible(false);//关闭密码规范提示
					
				int flag = 0;//用于判断最后一条if语句
				regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
				trueChar = "[0-9]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
				boolean result1 =  username.getText().matches(regExcetion); 
				boolean result2 =  username.getText().matches(trueChar); 
				if(!result2 || (result2 && (!result1 && username.getText().length()>=11)))//出现非法字符
																			//或者 超过qq最大字符长度还没匹配
				{
					flag=1;
					cardlayout.show(panel_usernameError,"error2");//两个参数依次是父容器组件，
					//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
					
				}
				if( username.getText().length()>11)//长度不合
				{
					flag=1;
					cardlayout.show(panel_usernameError,"error3");
					
				}
				if(flag==0)
				{
					cardlayout.show(panel_usernameError,"register");
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {//光标删除操作
				if(username.getText().length()==0) {//手机规范重新可见
					label_phone.setVisible(true);
				}
				int flag = 0;
				//regExcetion ="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//正则表达式邮箱
				regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
				trueChar = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
				boolean result1 =  username.getText().matches(regExcetion); 
				boolean result2 =  username.getText().matches(trueChar); 
				if(!result2 || (result2 && (!result1 && username.getText().length()>=11)))//出现非法字符
																			//或者 超过qq最大字符长度还没匹配
				{
					flag=1;
					cardlayout.show(panel_usernameError,"error2");//两个参数依次是父容器组件，
					//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
					
				}
				if( username.getText().length()>11)//,超过11位，长度不合
				{
					flag=1;
					cardlayout.show(panel_usernameError,"error3");
				}
				if(flag==0||username.getText().length()==0)
				{
					cardlayout.show(panel_usernameError,"register");
				}
			}
			
		});
		password = new JPasswordField();
		password.setOpaque(false);
		password.setBounds(180,180,150,25);
		password.setEchoChar('*');//设置隐藏密码样式
		password.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//设置密码边框,1像素（默认）
		
		label_pwdlength = new JLabel("5-10个字母或数字");
		label_pwdlength.setOpaque(false);
		label_pwdlength.setBounds(185,180,120,25);
		label_pwdlength.setForeground(Color.GRAY);
		label_pwdlength.setFont(new Font("宋体",Font.PLAIN,11));
		add(label_pwdlength);
		//设计密码的显示与隐藏
		panel_pwdstate= new JPanel();
		panel_pwdstate.setBounds(309,185,15,15);
		
		label_pwdclose = new JLabel();
		label_pwdclose.setIcon(image_pwdClose);
		label_pwdopen = new JLabel();
		label_pwdopen.setIcon(image_pwdShow);
		panel_pwdstate.setLayout(cardlayout2);
		panel_pwdstate.add(label_pwdclose,"pwdclose");//cardlayout默认第一层
		panel_pwdstate.add(label_pwdopen,"pwdopen");
		
		//添加监听
		panel_pwdstate.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//鼠标指针变为手
				if(checkflag == 0) {
					cardlayout2.next(panel_pwdstate);
					password.setEchoChar('\0');//让密码可见
					checkflag = 1;//重新置1
				}
				else if(checkflag == 1) {
					cardlayout2.next(panel_pwdstate);
					password.setEchoChar('*');//让密码可见
					checkflag = 0;//重新置1
				}
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));//鼠标指针复原
				if(checkflag == 0) {
					cardlayout2.next(panel_pwdstate);
					password.setEchoChar('\0');//让密码可见
					checkflag = 1;//重新置1
				}
				else if(checkflag == 1) {
					cardlayout2.next(panel_pwdstate);
					password.setEchoChar('*');//让密码可见
					checkflag = 0;//重新置1
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

		});
		add(panel_pwdstate);
		password.setFont(new Font("宋体",Font.BOLD,18));
		add(password);
		
	
		
		
		
		//添加监听
		password.addKeyListener(new KeyAdapter() {//限制输入长度,KeyPress无效果
			@SuppressWarnings("deprecation")
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if( password.getText().length()>10) {
					e.consume();//停止输入
				}
			}
			
			@SuppressWarnings("deprecation")
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				 if(e.getKeyChar()==KeyEvent.VK_ENTER )   
			        { 
			          button_Login.doClick();//回车键触发登录按钮点击
			        } 
				 if(e.getKeyChar()==KeyEvent.VK_SPACE && password.getText().length()>0 &&  password.getText().length()!=11) 
					 //开头不允许出现空格,之所以不让在一开始就限制空格仅仅是给用户一个人好的键盘感受体验 
			        { 
					 try {
							robot = new Robot();
						} catch (AWTException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						robot.keyPress(8);//模拟按键BackSpace退格
					 } 
			}
			
		});
		password.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			public void focusGained(FocusEvent e) {//获得focus
				password.enableInputMethods(false); //禁用掉输入法
				password.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//蓝色边框
				if(password.getText().length()==0) {
				label_pwdlength.setVisible(false);//关闭密码规范提示
				}
			}
			@SuppressWarnings("deprecation")
			public void focusLost(FocusEvent e) {//失去focus
				// TODO Auto-generated method stub
				password.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//复原
				if(password.getText().length()==0) {//当还有字时不能让密码规范提示复原
				label_pwdlength.setVisible(true);//重新密码规范提示
				}
			}
			
		});
		password.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));//鼠标指针改变
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));//鼠标指针改变
			}

		
			
		});
		password.getDocument().addDocumentListener (new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

			@SuppressWarnings("deprecation")
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				label_pwdlength.setVisible(false);//关闭密码规范提示
				
				int flag = 0;//用于判断最后一条语句
				regExcetion ="[a-zA-Z0-9]{5,10}";//正则表达式密码(5到10个字符或数字大小)
				trueChar = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
				boolean result1 =  password.getText().matches(regExcetion); 
				boolean result2 =  password.getText().matches(trueChar); 
				if(!result2 || (result2 && (!result1 && (password.getText().length()>=5 && password.getText().length()<=5))))//出现非法字符
																			//或者 超过qq最大字符长度还没匹配
																			//输入5个字符开始匹配
				{
					flag=1;
					cardlayout.show(panel_pwdError,"error5");//两个参数依次是父容器组件，
					//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
					
				}
				if( password.getText().length()>10)//密码过长
				{
					flag=1;
					cardlayout.show(panel_pwdError,"error6");
					
				}
				if(flag==0)
				{
					cardlayout.show(panel_pwdError,"pwd");
				}
				
			}

			@SuppressWarnings("deprecation")
			@Override
			public void removeUpdate(DocumentEvent e) {//光标删除操作
				if(password.getText().length()==0) {
					label_pwdlength.setVisible(false);//关闭密码规范提示
					}
				int flag = 0;
				regExcetion ="[a-zA-Z0-9]{5,10}";//正则表达式密码(5到10个字符大小)
				trueChar = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
				boolean result1 =  password.getText().matches(regExcetion); 
				boolean result2 =  password.getText().matches(trueChar); 
				if(!result2 || (result2 && (!result1 && password.getText().length()>=5)))//出现非法字符
																			//或者 超过qq最大字符长度还没匹配
				{
					flag=1;
					cardlayout.show(panel_pwdError,"error5");//两个参数依次是父容器组件，
					//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
					
				}
				if( password.getText().length()>10)//长度不合
				{
					flag=1;
					cardlayout.show(panel_pwdError,"error6");
				}
				
				if(flag==0||password.getText().length()==0)
				{
					cardlayout.show(panel_pwdError,"pwd");
				}
			}
			
		});
		
		label_register = new JLabel("注册账号");
		label_register.setOpaque(false);
		//label_register.setBounds(340,148,52,25);
		label_register.setForeground(Color.blue);
		label_register.setFont(new Font("宋体", Font.PLAIN, 12));
		//add(label_register);
		label_register.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {//鼠标点击
				dispose();
				new Register();//注册界面
			}
			public void mouseEntered(MouseEvent e) {
				label_register.setForeground(new Color(100,80,255));// 处理鼠标移入
			}
			public void mouseExited(MouseEvent e) {
				label_register.setForeground(Color.blue);// 处理鼠标离开
			}
			});
		label_pwd = new JLabel("修改密码");
		label_pwd.setOpaque(false);
		//label_pwd.setBounds(340,178,52,25);
		label_pwd.setOpaque(false);
		label_pwd.setForeground(Color.blue);
		label_pwd.setFont(new Font("宋体", Font.PLAIN, 12));
		//add(label_pwd);
		label_pwd.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {//鼠标点击
				PwdUpdata pwdUpdata = new PwdUpdata();//JOptionPane.showInternalInputDialog(this,"修改");
				
			}
			public void mouseEntered(MouseEvent e) {
				label_pwd.setForeground(new Color(100,80,255));// 处理鼠标移入
			}
			public void mouseExited(MouseEvent e) {
				label_pwd.setForeground(Color.blue);// 处理鼠标离开
			}
			});
		
		
		button_Login =new JButton("登录");
		button_Login.setOpaque(false);
		button_Login.setBounds(195,220,120,35);
		add(button_Login);
		button_Login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
			{
				
				if(radiobutton_passenger.isSelected()||radiobutton_admi.isSelected()) //有一个按钮被选
				{
				int flag = 0;
				regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号    用户名
				trueChar = "[0-9]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次  用户名
				regExcetion2 ="[a-zA-Z0-9]{5,10}";//正则表达式密码(5到10个字符大小)  密码
				trueChar2 = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次     密码
				boolean result1 =  password.getText().matches(regExcetion2); //密码匹配
				boolean result2 =  password.getText().matches(trueChar2); //密码无非法字符
				boolean result3 =  username.getText().matches(regExcetion); //用户名匹配
				boolean result4 =  username.getText().matches(trueChar); //用户名无非法字符
				boolean res1 = !result2 || (result2 && (!result1 && username.getText().length()>=11));
				boolean res2 = username.getText().length()>11;
				boolean res3 = !result4 || (result4 && (!result3 && password.getText().length()>=5));
				boolean res4 = password.getText().length()>10;
				if(username.getText().length()==0)//用户名为空
				{
					flag = 1;
					cardlayout.show(panel_usernameError,"error1");
				}
				else if(!result3) {//用户名不匹配,不存在/用户名长度不合，长度不合一定不匹配
					cardlayout.show(panel_usernameError,"error2");//用户名不合法
				}else {
					
				}
				
				
				if(password.getText().length()>10) {//用于处理bug,发现有一种情况密码长度不合，密码含非法字符同时提示，可以用return屏蔽
					cardlayout.show(panel_pwdError,"error6");
					return;
				}
				if(password.getText().length()==0)
				{
					flag = 1;
					cardlayout.show(panel_pwdError,"error4");
				}
				
				else if(!result2) {//密码含非法字符
					cardlayout.show(panel_usernameError,"error5");
				}
				else if(password.getText().length()<5) {//密码长度不合
					cardlayout.show(panel_pwdError,"error6");
				}
				
				else {
					
				}
				
				if(flag==0 && !res1 && !res2 && !res3 && !res4)//一切正确才登陆
				{
					if(radiobutton_passenger.isSelected()) {//如果是乘客登录
					Boolean check = SqlOperation.login_check(username.getText(),password.getText());
					if(check) {
							if(SqlOperation.head(username.getText()).equals("头像0")) {//一共就8张头像
								label_containHead.setIcon(head0);
							}
							else if(SqlOperation.head(username.getText()).equals("头像1")) {
								label_containHead.setIcon(head1);
							}else if(SqlOperation.head(username.getText()).equals("头像2")) {
								label_containHead.setIcon(head2);
							}else if(SqlOperation.head(username.getText()).equals("头像3")) {
								label_containHead.setIcon(head3);
							}else if(SqlOperation.head(username.getText()).equals("头像4")) {
								label_containHead.setIcon(head4);
							}else if(SqlOperation.head(username.getText()).equals("头像5")) {
								label_containHead.setIcon(head5);
							}else if(SqlOperation.head(username.getText()).equals("头像6")) {
								label_containHead.setIcon(head6);
							}else if(SqlOperation.head(username.getText()).equals("头像7")) {
								label_containHead.setIcon(head7);
							}else {
								try {
									throw new Exception();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(null, "你还没有设置头像", "系统提示", 
											 JOptionPane.INFORMATION_MESSAGE);
									dispose();
									e1.printStackTrace();
									
								}
							}
							cardlayout.show(panel_pwdError,"pwd");//把错误提示全部关闭
							cardlayout.show(panel_usernameError,"register");
							label.setVisible(true);//起覆盖效果,如果有需要也需要还原为不可见
							panel_usernameError.setVisible(false);//cardlayout布局当鼠标移入，会把子件显示出来，所以给他设置不可见，注意注册成功后再登录要把它们还原
							panel_pwdError.setVisible(false);
							panel_pwdstate.setVisible(false);
						     setAlwaysOnTop(true);//最上面
						     passPwd=password.getText();
						     passengerID=SqlOperation.IDsearch(username.getText(),"passenger");
						     userPassenger=username.getText();
							button_Login.setText("正在登录");
							 int heady = label_containHead.getY();
							 int btnLoginY = button_Login.getY();
							 int headwidth = label_containHead.getWidth();
							 int headheight = label_containHead.getHeight();
							 int btnLoginWidth = button_Login.getWidth();
							 int btnLoginHeight = button_Login.getHeight();
							 int windowWidth = 450;//JFrame宽度
						     label_containHead.setBounds((windowWidth - headwidth)/2,heady - 15,headwidth,headheight);//宽度差除以2，即新位置的x坐标,减15是为了更居中
						     button_Login.setBounds((windowWidth - btnLoginWidth)/2,btnLoginY,btnLoginWidth,btnLoginHeight);
							
						     new Thread(new Runnable() {
						         
						          @Override
						          public void run() {
						        	  int i=1;
						        	while(i!=0) {
						                  
						                  try {
						                      Thread.sleep(2000);
						                      new Passenger();
						                      
						                  } catch (InterruptedException e) {
						                      e.printStackTrace();
						                  } catch (ClassNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InstantiationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IllegalAccessException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (UnsupportedLookAndFeelException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}finally {
											login.dispose();
										}
						                  i--;
						        	}
						             
						          }
						      }).start();
							
							 SqlUtil.userState= "在线";//在线
							 button_Login.setEnabled(false);//不允许再点击移动
							 SqlUtil.headkind=0;//设置回去
							
						    
							
						
					}else {
						cardlayout.show(panel_usernameError, "error7");
					}
				}
					else {//管理者登录
						Boolean check = SqlOperation.login_check2(username.getText(),password.getText());
						if(check) {
							if(SqlOperation.head2(username.getText()).equals("头像0")) {//一共就8张头像
								label_containHead.setIcon(head0);
							}
							else if(SqlOperation.head2(username.getText()).equals("头像1")) {
								label_containHead.setIcon(head1);
							}else if(SqlOperation.head2(username.getText()).equals("头像2")) {
								label_containHead.setIcon(head2);
							}else if(SqlOperation.head2(username.getText()).equals("头像3")) {
								label_containHead.setIcon(head3);
							}else if(SqlOperation.head2(username.getText()).equals("头像4")) {
								label_containHead.setIcon(head4);
							}else if(SqlOperation.head2(username.getText()).equals("头像5")) {
								label_containHead.setIcon(head5);
							}else if(SqlOperation.head2(username.getText()).equals("头像6")) {
								label_containHead.setIcon(head6);
							}else if(SqlOperation.head2(username.getText()).equals("头像7")) {
								label_containHead.setIcon(head7);
							}else {
								try {
									throw new Exception();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							//passengerID=;
							cardlayout.show(panel_pwdError,"pwd");//把错误提示全部关闭
							cardlayout.show(panel_usernameError,"register");
							label.setVisible(true);//起覆盖效果,如果有需要也需要还原为不可见
							panel_usernameError.setVisible(false);//cardlayout布局当鼠标移入，会把子件显示出来，所以给他设置不可见，注意注册成功后再登录要把它们还原
							panel_pwdError.setVisible(false);
							panel_pwdstate.setVisible(false);
							 admiPwd=password.getText();
							 admiID=SqlOperation.IDsearch(username.getText(),"admini");
							button_Login.setText("正在登录");
							 	setAlwaysOnTop(true);//最上面
								 int heady = label_containHead.getY();
								 int btnLoginY = button_Login.getY();
								 int headwidth = label_containHead.getWidth();
								 int headheight = label_containHead.getHeight();
								 int btnLoginWidth = button_Login.getWidth();
								 int btnLoginHeight = button_Login.getHeight();
								 int windowWidth = 450;//JFrame宽度
							     label_containHead.setBounds((windowWidth - headwidth)/2,heady - 15,headwidth,headheight);//宽度差除以2，即新位置的x坐标,JFrame(0,0) 减15是为了更居中
							     button_Login.setBounds((windowWidth - btnLoginWidth)/2,btnLoginY,btnLoginWidth,btnLoginHeight);
							     button_Login.setEnabled(false);//不允许再点击移动
							     
							     //想让程序暂停1秒保持移动后的界面,未完成
							     
								new Thread(new Runnable() {// 使用Runable接口匿名内部类作Thread的参数

									@Override
									public void run() {// Runnable接口的方法
										int i = 1;
										while (i != 0) {// 循环一次

											try {
												Thread.sleep(2000);// 该线程睡眠2秒
												new Admini();// 显示管理员界面窗口
											} catch (InterruptedException e) {// 可能出现的异常
												e.printStackTrace();
											} catch (ClassNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (InstantiationException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalAccessException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (UnsupportedLookAndFeelException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} finally {
												login.dispose();// 不管有无异常都把登录窗口隐藏
											}
											i--;
										}

									}
								}).start();// Thread的方法，其底层会调用run()方法
								 SqlUtil.userState= "在线";//设计标志在线
								 SqlUtil.headkind=-1;//设置回去
							    
							    
						}else {
							cardlayout.show(panel_usernameError, "error7");
						}
					
					}
				}
			
			}
			else {
					label_warn.setVisible(true);//提示选择登录对象
				}
			}
		});
		
		
		
		panel_usernameError = new JPanel();
		//errorpanel1.setBackground(Color.BLUE);
		panel_usernameError.setLayout(cardlayout);
		panel_usernameError.setBounds(340,148,95,25);
		label_error1 = new JLabel("用户名为空!");
		label_error1.setFont(errorFont);
		label_error1.setForeground(Color.RED);
		label_error2 = new JLabel("用户名不合法");
		label_error2.setFont(errorFont);
		label_error2.setForeground(Color.RED);
		label_error3 = new JLabel("长度不合");
		label_error3.setFont(errorFont);
		label_error3.setForeground(Color.RED);
		label_error7 = new JLabel("用户名或密码错误");
		label_error7.setFont(errorFont);
		label_error7.setForeground(Color.RED);
		
		
		panel_usernameError.add(label_register,"register");
		panel_usernameError.add(label_error1,"error1");
		panel_usernameError.add(label_error2,"error2");
		panel_usernameError.add(label_error3,"error3");
		panel_usernameError.add(label_error7,"error7");
		
		add(panel_usernameError);
	
		panel_pwdError = new JPanel();
		//errorpanel2.setBackground(Color.YELLOW);
		panel_pwdError.setLayout(cardlayout);
		panel_pwdError.setBounds(340,178,95,25);
		label_error4 = new JLabel("密码为空！");
		label_error4.setFont(errorFont);
		label_error4.setForeground(Color.RED);
		label_error5 = new JLabel("密码含非法字符");
		label_error5.setFont(errorFont);
		label_error5.setForeground(Color.RED);
		label_error6 = new JLabel("密码长度不合");
		label_error6.setFont(errorFont);
		label_error6.setForeground(Color.RED);
		
		panel_pwdError.add(label_pwd,"pwd");
		panel_pwdError.add(label_error4,"error4");
		panel_pwdError.add(label_error5,"error5");
		panel_pwdError.add(label_error6,"error6");
		add(panel_pwdError);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		/*
		 * java的GUI都是的单线程 应该使用事件调度线程去执行， 如果没使用事件调度线程的话， 可能造成死锁。
		 */
		new DatabaseInit();//MySql数据初始化
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 login = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	





	
}
