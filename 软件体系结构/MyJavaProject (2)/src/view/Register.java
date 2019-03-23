package view;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Random;

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
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import system.SqlOperation;
import system.SqlUtil;

public class Register extends JFrame {
	/**
	 * 注册窗口
	 */
	
	private static final long serialVersionUID = 1L;//序列化的版本号
	private int compenontMove = 0;
	private Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包  
	private Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸  
	private int screenWidth = screenSize.width; //获取屏幕的宽  
	private int screenHeight = screenSize.height; //获取屏幕的高  
	private int reg_startX = (screenWidth-440) / 2;//注册窗口的左上角坐标x
	private int reg_startY = (screenHeight-385) / 2;//注册窗口的左上角坐标y
	
	private boolean checkLeftButton,checkRightButton,checkUsername,checkPassword,
			checkReConfirmPwd,checkNickname,checkEmail,
			checkIDCard,checkVerificationCode;//记录各框填写情况，方便注册按钮监视,默认false
	StringBuilder string_pwdContent,string_checkPwdContent;//记录密码框，确认框字符串,默认null
	String string_verificationCode = "";//用于验证码
	public boolean headWindowHasOpen = false;//判断头像窗口是否打开
	private boolean right_pwd;//用于标志密码和确认密码框正确性，作为if语句参考,默认false
	private GridLayout gridlayout;
	public static Button button_head=new Button("head");
	private JPanel panel_radiobutton = new JPanel(),panel_haveAccountToLogin = new JPanel(),
	panel_usernameError = new JPanel(),panel_pwdError = new JPanel(),panel_reCheckPwdError = new JPanel(),
	panel_nicknameError = new JPanel(),panel_emailError = new JPanel(),panel_IDcardError = new JPanel(),
	panel_NotFinishError = new JPanel();
		
	private JTextField username = new JTextField(),
			email=new JTextField(),idcard= new JTextField(),nickname = new JTextField(),
			verificationCode = new JTextField();
	private JPasswordField password =new JPasswordField(),checkpwd=new JPasswordField();
	private JRadioButton radiobutton_passenger = new JRadioButton("乘客"), 
			radiobutton_admini =  new JRadioButton("管理");
	private ButtonGroup btnGroup = new ButtonGroup();
	private JButton button_submit=new JButton("注册");
	private Font errorFont = new Font("宋体",Font.PLAIN,12);//错误字体设计
	private Robot robot; //用于模拟按键
	private ImageIcon rightFlag = new ImageIcon("pic_login\\正确.png");
	private String regExcetion,charTrue;
	private JLabel label_AccountKind = new JLabel("账号类型"),label_username = new JLabel("用户名"),
			label_pwd = new JLabel("请填写您的的密码"),label_pwd1 = new JLabel("密码"),label_checkpwd = new JLabel("确认密码"),
			label_email = new JLabel("电子邮箱"),label_IDcard = new JLabel("身份证"),
	label_nickname = new JLabel("设置昵称"),label_sethead = new JLabel("设置头像"),
	label_code = new JLabel("验证码"),
	label_usernameEmpty = new JLabel("用户名为空!"),label_formatError = new JLabel("格式不正确"),
	label_pwdEmpty = new JLabel("密码为空！"),label_pwdLenthError = new JLabel("5-10个字母或数字"),
	label_CheckPwd = new JLabel("请确认密码"),label_pwdDiffer = new JLabel("与原密码不一致"),label_firstFillPwd = new JLabel("请先填完密码框"),
	label_nicknameLenthError = new JLabel("长度2-10字符"),
	label_emailEmpty = new JLabel("邮箱为空!"),label_emailFormatError = new JLabel("格式不正确"),label_supportQQEmail = new JLabel("仅支持QQ邮箱等"),
	label_IDcardEmpty = new JLabel("身份证为空!"),label_IDcardFormatErrot = new JLabel("格式不正确"),
	label_selectRegKind = new JLabel("请选择注册类型"),label_fillAll = new JLabel("请将信息填写完善"),
	label_empty1 = new JLabel(""),label_empty2=new JLabel(""),label1_empty3=new JLabel(""),label_reg = new JLabel("注册"),
	label_empty4=new JLabel(""),label_empty5=new JLabel(""),label_haveAccount = new JLabel("已有账号,"),
	label_denglu = new JLabel("登录"),label_checkYourPwd=new JLabel("核实您的密码"),
	label_unableChangeHead=new JLabel("头像设置后不能更改"),
	label_fillPatient = new JLabel("耐心点儿吧"),label_right1=new JLabel(),label_right2=new JLabel(),label_right3=new JLabel(),
	label_ContainRightFlag4=new JLabel(),label_ContainRightFlag5=new JLabel(),label_ContainRightFlag6=new JLabel(),label_fillPhone = new JLabel("请填写手机号码"),
	label_setNickname = new JLabel("请设置你的昵称"),label_fillYourIDcard = new JLabel("请填写您的身份证");
	private CardLayout cardlayout = new CardLayout();
	public static Head head=null;

	public Register(){
		super("注册中心");
		setUndecorated(true); //隐藏窗框
		//采用指定的窗口装饰风格
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);//改变窗体修饰
		ImageIcon iIcon = new ImageIcon("pic_login/背景") ;
		//new ImgPanel(iIcon.getImage(),this.getSize());
		Toolkit tool=this.getToolkit(); //得到一个Toolkit对象
		Image myimage=tool.getImage("pic_login//注册图标.png"); //由tool获取图像
		setIconImage(myimage);//设置窗口图标
		setBounds(reg_startX,reg_startY,440,385);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		//setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		 gridlayout = new GridLayout(12,3,20,2);
		 setLayout(gridlayout);
		//窗口监听
			this.addWindowListener(new WindowAdapter(){//窗口打开就让头像获得焦点，否则会在radiobutton1获得，影响美观
			       public void windowOpened(WindowEvent e) {
			    	   panel_haveAccountToLogin.requestFocus();
			    	   button_head.setLabel("head");//因为头像情况是全局变量
			    	   SqlUtil.hasselect= false;//标记头像已选否
			    	   SqlUtil.hasOpen= false;//标记头像窗是否打开
			       }
			       public void windowClosing(WindowEvent e) {
			    	   if(SqlUtil.hasOpen) {//头像窗口打开了就一同关闭
							head.dispose();
						}
			       }
			});
			
			//添加组件监听
			 this.addComponentListener(new ComponentAdapter(){
	              public void componentMoved(ComponentEvent e) {//组件移动(实质是窗口移动)
	                	compenontMove++;
	                	if(compenontMove>3 && SqlUtil.hasOpen) {
	                		
	                		int reg_moveX = (int)e.getComponent().getLocationOnScreen().getX();//获取移动后原窗口左上角的x坐标
	                		int reg_moveY = (int)e.getComponent().getLocationOnScreen().getY();//获取移动后原窗口左上角的y坐标
	                		head.setBounds(reg_moveX + 290,reg_moveY +90,130,290);//头像框相对原窗口位置永远不变
	                		
	                	}
	                }
	            }); 
		 //第一行
		
		 add(label_reg);
		 label_reg.setHorizontalAlignment(SwingConstants.RIGHT);//文字右对齐
		 add(panel_haveAccountToLogin);
		 panel_haveAccountToLogin.add(label_haveAccount);
		 panel_haveAccountToLogin.setBackground(Color.white);
		 label_haveAccount.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_haveAccountToLogin.add(label_denglu);
		 label_denglu.setForeground(Color.BLUE);
		 label_denglu.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {//鼠标点击
					dispose();
					new Login();//注册界面
					if(SqlUtil.hasOpen) {//头像窗口打开了就一同关闭
						head.dispose();
					}
					
				}
				public void mouseEntered(MouseEvent e) {
					label_denglu.setForeground(new Color(100,80,255));// 处理鼠标移入
				}
				public void mouseExited(MouseEvent e) {
					label_denglu.setForeground(Color.blue);// 处理鼠标离开
				}
				});
		 add(label1_empty3);
		
		
		
		 
		//第二行
		 add(label_AccountKind);
		 label_AccountKind.setHorizontalAlignment(SwingConstants.RIGHT);
		 btnGroup.add(radiobutton_passenger);
		 btnGroup.add(radiobutton_admini);
		 add(panel_radiobutton);
		 panel_radiobutton.add(radiobutton_passenger);
		 panel_radiobutton.add(radiobutton_admini);
		 radiobutton_passenger.setBackground(Color.white);
		 radiobutton_admini.setBackground(Color.white);
		 panel_radiobutton.setBackground(Color.white);
		 radiobutton_passenger.addActionListener(new ActionListener() {//两个按钮有一个被点下，按钮组都被算选中
				public void actionPerformed(ActionEvent e) {
					if(radiobutton_passenger.isSelected()) {
						checkLeftButton=true;
					}
				}
			});
		 radiobutton_admini.addActionListener(new ActionListener() {//两个按钮有一个被点下，按钮组都被算选中
			 public void actionPerformed(ActionEvent e) {
				 if(radiobutton_admini.isSelected()) {
					 checkRightButton=true;
				 }
			 }
		 });
		 add(panel_NotFinishError);
		 label_fillPatient.setOpaque(false);//设置透明
		 label_fillPatient.setBackground(Color.white);
		 label_fillPatient.setForeground(Color.gray);
		 label_fillPatient.setFont(new Font("宋体",Font.PLAIN,12));
		 panel_NotFinishError.setBackground(Color.WHITE);
		 panel_NotFinishError.setLayout(cardlayout);
		 panel_NotFinishError.add(label_fillPatient,"final");
		 panel_NotFinishError.add(label_selectRegKind,"error14");
		 panel_NotFinishError.add(label_fillAll,"error15");
		 panel_NotFinishError.add(label_empty1,"error16");
		 label_selectRegKind.setFont(errorFont);
		label_selectRegKind.setForeground(Color.RED);
		label_fillAll.setFont(errorFont);
		label_fillAll.setForeground(Color.RED);
		label_empty1.setFont(errorFont);
		label_empty1.setForeground(Color.RED);
		
		
		
		
		
		
		 //第三行，用户名
		 add(label_username);
		 label_username.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(username);
		 username.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框
		 label_fillPhone.setOpaque(false);//设置透明
		 label_fillPhone.setBackground(Color.white);
		 label_fillPhone.setForeground(Color.gray);
		 label_fillPhone.setFont(new Font("宋体",Font.PLAIN,12));
		 label_right1.setIcon(rightFlag);
		 label_right1.setOpaque(false);//设置透明
		 label_right1.setBackground(Color.white);
		 add(panel_usernameError);
		 panel_usernameError.setBackground(Color.WHITE);
		 panel_usernameError.setLayout(cardlayout);
		 panel_usernameError.add(label_fillPhone,"phone");
		 panel_usernameError.add(label_usernameEmpty,"error1");
		 panel_usernameError.add(label_formatError,"error2");
		 panel_usernameError.add(label_right1,"right1");
		 label_usernameEmpty.setFont(errorFont);
		label_usernameEmpty.setForeground(Color.RED);
		label_formatError.setFont(errorFont);
		label_formatError.setForeground(Color.RED);
		 
		 //添加监听
		 username.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					username.enableInputMethods(false); //禁用掉输入法
					username.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
				}
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					username.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
					regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
					charTrue = "[0-9]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  username.getText().matches(regExcetion); //用户名匹配
					if(!result1 &&  username.getText().length()!=0) {
						cardlayout.show(panel_usernameError,"error2");
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
					int len =username.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=12)  //不允许空格 ,第二条主要是处理一个bug,
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
					regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
					charTrue = "[0-9]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  username.getText().matches(regExcetion); //用户名匹配
					boolean result2 =  username.getText().matches(charTrue); //用户名字符正确
					if(!result2 || (result2 && (!result1 && username.getText().length()>=11)))//出现非法字符
																				//或者 超过最大字符长度还没匹配
					{
						checkUsername=false;
						cardlayout.show(panel_usernameError,"error2");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					if(result2 && username.getText().length() <11)
					{
						checkUsername=false;
						cardlayout.show(panel_usernameError,"phone");
					}
					if(result1)
					{
						checkUsername=true;
						cardlayout.show(panel_usernameError,"right1");
					}
					
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					//regExcetion ="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//正则表达式邮箱
					regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //正则表达式手机号
					charTrue = "[0-9]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  username.getText().matches(regExcetion); //用户名匹配
					boolean result2 =  username.getText().matches(charTrue); //用户名字符正确
					if(username.getText().length()==0) {
						cardlayout.show(panel_usernameError,"phone");
						checkUsername=false;
						return;
					}
					if(!result2 || (result2 && (!result1 && username.getText().length()>=11)))//出现非法字符
																				//或者 超过qq最大字符长度还没匹配
					{
						checkUsername=false;
						cardlayout.show(panel_usernameError,"error2");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					
					if(result2 && username.getText().length() < 11)
					{
						checkUsername=false;
						cardlayout.show(panel_usernameError,"phone");
					}
					if(result1)
					{
						checkUsername=true;
						cardlayout.show(panel_usernameError,"right1");
					}
				}
				
			});
		
		 
			
		 add(label_pwd1);
		 label_pwd1.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(password);
		 password.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框
		 password.setEchoChar('*');
		 password.setFont(new Font("宋体",Font.PLAIN,18));
		 label_pwd.setOpaque(false);//设置透明
		 label_pwd.setBackground(Color.white);
		 label_pwd.setForeground(Color.gray);
		 label_pwd.setFont(new Font("宋体",Font.PLAIN,12));
		 label_right2.setIcon(rightFlag);
		 label_right2.setOpaque(false);//设置透明
		 label_right2.setBackground(Color.white);
		 add(panel_pwdError);
		 panel_pwdError.setBackground(Color.WHITE);
		 panel_pwdError.setLayout(cardlayout);
		 panel_pwdError.add(label_pwd,"pwd");
		 panel_pwdError.add(label_pwdEmpty,"erro3");
		 panel_pwdError.add(label_pwdLenthError,"error4");
		 panel_pwdError.add(label_right2,"right2");
		 label_pwdEmpty.setFont(errorFont);
		label_pwdEmpty.setForeground(Color.RED);
		label_pwdLenthError.setFont(errorFont);
		label_pwdLenthError.setForeground(Color.RED);
		 //添加监听
		password.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					password.enableInputMethods(false); //禁用掉输入法
					password.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
					
				}
				@SuppressWarnings("deprecation")
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					password.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
					regExcetion ="[a-zA-Z0-9]{5,10}";//正则表达式密码(5到10个字符或数字大小)
					charTrue = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  password.getText().matches(regExcetion); //密码匹配
					if(!result1 && password.getText().length()!=0) {//不匹配提示，密码还不正确，不能进行其他操作
						cardlayout.show(panel_pwdError,"error4");
					}
				}
				
			});
		password.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，typed和press有区别
				@SuppressWarnings("deprecation")
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( password.getText().length()>11) {
						e.consume();
					}
				}

				@SuppressWarnings("deprecation")
				@Override
				public void keyPressed(KeyEvent e) {
					int len =password.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=12)  //不允许空格 ,第二条主要是处理一个bug,
					 {	 //当输入到达上限,按下空格会自动删掉一个字符
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
		password.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@SuppressWarnings("deprecation")
				@Override
				public void insertUpdate(DocumentEvent e) {
					regExcetion ="[a-zA-Z0-9]{5,10}";//正则表达式密码(5到10个字符或数字大小)
					charTrue = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  password.getText().matches(regExcetion); //用户名匹配
					boolean result2 =  password.getText().matches(charTrue); //用户名字符正确
					if(!result2 || (result2 && (!result1 && password.getText().length()>=5)))//出现非法字符
																				//或者 超过最大字符长度还没匹配
					{
						
						cardlayout.show(panel_pwdError,"error4");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						right_pwd = false;
						checkPassword=false;//和上面那条是一样的，但是为了避免繁杂就没去改
						return;
						
					}
					if(result2 && password.getText().length() <5)
					{
						checkPassword=false;
						cardlayout.show(panel_pwdError,"pwd");
						right_pwd = false;
					}
					if(result1)
					{
						checkPassword=true;
						cardlayout.show(panel_pwdError,"right2");
						right_pwd = true;
					}
					
					
				}

				@SuppressWarnings("deprecation")
				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					//regExcetion ="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//正则表达式邮箱
					regExcetion ="[a-zA-Z0-9]{5,10}";//正则表达式密码(5到10个字符或数字大小)
					charTrue = "[0-9a-zA-Z]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  password.getText().matches(regExcetion); //用户名匹配
					boolean result2 =  password.getText().matches(charTrue); //用户名字符正确
					if(password.getText().length()==0) {
						cardlayout.show(panel_pwdError,"pwd");
						right_pwd = false;
						checkPassword=false;
						return;
					}
					if(!result2 || (result2 && (!result1 && password.getText().length()>=5)))//出现非法字符
																				//或者 超过qq最大字符长度还没匹配
					{
						checkPassword=false;
						cardlayout.show(panel_pwdError,"error4");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						right_pwd = false;
						return;
						
					}
					
					if(result2 && password.getText().length() < 5)
					{
						checkPassword=false;
						cardlayout.show(panel_pwdError,"pwd");
						right_pwd = false;
					}
					if(result1)
					{
						checkPassword=true;
						cardlayout.show(panel_pwdError,"right2");
						right_pwd = true;
					}
				}
				
			});
		 
		 add(label_checkpwd);
		 label_checkpwd.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(checkpwd);
		 checkpwd.setEchoChar('*');
		 checkpwd.setFont(new Font("宋体",Font.PLAIN,18));
		 add(panel_reCheckPwdError);
		 panel_emailError.setLayout(cardlayout);		
		 checkpwd.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框
		 label_checkYourPwd.setOpaque(false);//设置透明
		 label_checkYourPwd.setBackground(Color.white);
		 label_checkYourPwd.setForeground(Color.gray);
		 label_checkYourPwd.setFont(new Font("宋体",Font.PLAIN,12));
		 label_right3.setIcon(rightFlag);
		 label_right3.setOpaque(false);//设置透明
		 label_right3.setBackground(Color.white);
		 add(panel_reCheckPwdError);
		 panel_reCheckPwdError.setBackground(Color.WHITE);
		 panel_reCheckPwdError.setLayout(cardlayout);
		 panel_reCheckPwdError.add(label_checkYourPwd,"null3");
		 panel_reCheckPwdError.add(label_CheckPwd,"error5");
		 panel_reCheckPwdError.add(label_pwdDiffer,"error6");
		 panel_reCheckPwdError.add(label_firstFillPwd,"error7");
		 panel_reCheckPwdError.add(label_right3,"right3");
		 label_CheckPwd.setFont(errorFont);
		label_CheckPwd.setForeground(Color.RED);
		label_pwdDiffer.setFont(errorFont);
		label_pwdDiffer.setForeground(Color.RED);
		label_firstFillPwd.setFont(errorFont);
		label_firstFillPwd.setForeground(Color.RED);
		 
		 //添加监听
		checkpwd.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					checkpwd.enableInputMethods(false); //禁用掉输入法
					checkpwd.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
					if(right_pwd==false) {
						cardlayout.show(panel_reCheckPwdError,"error7");
					}
				}
				@SuppressWarnings("deprecation")
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					checkpwd.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
					if(checkpwd.getText().length()==0) {
						cardlayout.show(panel_reCheckPwdError,"null3");
					}
					
					//没确认完密码，给出提示,要满足如下三种情况,长度在之间,写完不提示
					if(checkpwd.getText().length()!=0 && checkpwd.getText().length()!=password.getText().length() 
							&& password.getText()!=checkpwd.getText()) {
						cardlayout.show(panel_reCheckPwdError,"error5");
					}
					
				}
				
			});
		checkpwd.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，
			//typed和press有区别
				@SuppressWarnings("deprecation")
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					if(!right_pwd || len2==len1) {//密码不正确该框不可填,密码不能比原密码长，否则会发生异常，
						//StringBuilder的subString()索引越界
						e.consume();
					}
				}

				@SuppressWarnings("deprecation")
				@Override
				public void keyPressed(KeyEvent e) {
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len2!=len1)  //不允许空格 ,第二条主要是处理一个bug,
						 //当输入到达上限,按下空格会自动删掉一个字符
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
		checkpwd.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@SuppressWarnings("deprecation")
				@Override
				public void insertUpdate(DocumentEvent e) {
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					string_pwdContent = new StringBuilder( password.getText());
					string_checkPwdContent = new StringBuilder( checkpwd.getText());
					if(!right_pwd) {
						checkReConfirmPwd=false;
						cardlayout.show(panel_reCheckPwdError,"error7");
						return;//不用判断
					}
					if(!string_pwdContent.substring(0, len2).equals(string_checkPwdContent.substring(0, len2))) {//与原密码不一致
						checkReConfirmPwd=false;
						cardlayout.show(panel_reCheckPwdError,"error6");
						return;
					}
					if( string_pwdContent.substring(0, len2).equals(string_checkPwdContent.substring(0, len2)) ) {
						checkReConfirmPwd=false;
						cardlayout.show(panel_reCheckPwdError,"null3");
					}
					if(len1==len2 && string_pwdContent.substring(0, len1).equals(string_checkPwdContent.substring(0, len2))) {
						checkReConfirmPwd=true;
						cardlayout.show(panel_reCheckPwdError,"right3");
					}
				}

				@SuppressWarnings("deprecation")
				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					string_pwdContent = new StringBuilder( password.getText());
					string_checkPwdContent = new StringBuilder( checkpwd.getText());
					if(!right_pwd) {
						checkReConfirmPwd=false;
						cardlayout.show(panel_reCheckPwdError,"error7");
						return;//不用判断
					}
					if(!string_pwdContent.substring(0, len2).equals(string_checkPwdContent.substring(0, len2))) {//与原密码不一致
						cardlayout.show(panel_reCheckPwdError,"error6");
						checkReConfirmPwd=false;
						return;
					}
					if( string_pwdContent.substring(0, len2).equals(string_checkPwdContent.substring(0, len2)) ) {
						cardlayout.show(panel_reCheckPwdError,"null3");
						checkReConfirmPwd=false;
					}
					if(len1==len2 && string_pwdContent.substring(0, len1).equals(string_checkPwdContent.substring(0, len2))) {
						cardlayout.show(panel_reCheckPwdError,"right3");
						checkReConfirmPwd=true;
					}
				}
				
			});
		
		 
		 add(label_nickname);
		 label_nickname.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(nickname);
		 add(panel_nicknameError);
		 panel_nicknameError.setLayout(cardlayout);		
		 nickname.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框
		 label_setNickname.setOpaque(false);//设置透明
		 label_setNickname.setBackground(Color.white);
		 label_setNickname.setForeground(Color.gray);
		 label_setNickname.setFont(new Font("宋体",Font.PLAIN,12));
		 label_ContainRightFlag4.setIcon(rightFlag);
		 label_ContainRightFlag4.setOpaque(false);//设置透明
		 label_ContainRightFlag4.setBackground(Color.white);
		 add(panel_nicknameError);
		 panel_nicknameError.setBackground(Color.WHITE);
		 panel_nicknameError.setLayout(cardlayout);
		 panel_nicknameError.add(label_setNickname,"setNickname");
		 panel_nicknameError.add(label_nicknameLenthError,"error9");
		 panel_nicknameError.add(label_emailEmpty,"error10");
		 panel_nicknameError.add(label_ContainRightFlag4,"right4");
		 label_nicknameLenthError.setFont(errorFont);
		label_nicknameLenthError.setForeground(Color.RED);
		label_emailEmpty.setFont(errorFont);
		label_emailEmpty.setForeground(Color.RED);
		 
		 //添加监听
		nickname.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					nickname.enableInputMethods(false); //禁用掉输入法
					nickname.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
				}
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					nickname.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
					if(nickname.getText().length() == 1) {
						cardlayout.show(panel_nicknameError,"error9");
					}
				}
				
			});
		nickname.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，typed和press有区别
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( nickname.getText().length()>11) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =nickname.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=12)  //不允许空格 ,第二条主要是处理一个bug,
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
		nickname.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					if( nickname.getText().length()  > 10)//过长
																			
					{
						checkNickname=false;
						cardlayout.show(panel_nicknameError,"error9");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					if(nickname.getText().length() < 2)
					{
						checkNickname=false;
						cardlayout.show(panel_nicknameError,"setNickname");
					}
					if(nickname.getText().length() <11 && nickname.getText().length() >= 2)
					{
						checkNickname=true;
						cardlayout.show(panel_nicknameError,"right4");
					}
					
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					if( nickname.getText().length()  > 10)//过长
						
					{
						checkNickname=false;
						cardlayout.show(panel_nicknameError,"error9");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					if(nickname.getText().length() < 2)
					{
						checkNickname=false;
						cardlayout.show(panel_nicknameError,"setNickname");
					}
					if(nickname.getText().length() <11 && nickname.getText().length() >= 2)
					{
						cardlayout.show(panel_nicknameError,"right4");
						checkNickname=true;
					}
				}
				
			});
		
		 
		 
		 add(label_email);
		 label_email.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(email);
		 add(panel_emailError);
		 panel_emailError.setLayout(cardlayout);	
		 email.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框
		 label_supportQQEmail.setOpaque(false);//设置透明
		 label_supportQQEmail.setBackground(Color.white);
		 label_supportQQEmail.setForeground(Color.gray);
		 label_supportQQEmail.setFont(new Font("宋体",Font.PLAIN,12));
		 label_ContainRightFlag5.setIcon(rightFlag);
		 label_ContainRightFlag5.setOpaque(false);//设置透明
		 label_ContainRightFlag5.setBackground(Color.white);
		 add(panel_emailError);
		 panel_emailError.setBackground(Color.WHITE);
		 panel_emailError.add(label_supportQQEmail,"emil_examp");
		 panel_emailError.add(label_emailEmpty,"error10");
		 panel_emailError.add(label_emailFormatError,"error11");
		 panel_emailError.add(label_ContainRightFlag5,"right5");
		 label_emailEmpty.setFont(errorFont);
		label_emailEmpty.setForeground(Color.RED);
		label_emailFormatError.setFont(errorFont);
		label_emailFormatError.setForeground(Color.RED);
		 
		 //添加监听
		email.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					email.enableInputMethods(false); //禁用掉输入法
					email.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
				}
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					email.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
					regExcetion ="[0-9a-zA-Z][0-9a-zA-Z_-]{3,10}@(qq|QQ).com";//正则表达式QQ邮箱(自定义的)
					charTrue = "[0-9a-zA-Z@.-_]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  email.getText().matches(regExcetion); //邮箱匹配
					if(!result1 &&  email.getText().length()!=0) {
						cardlayout.show(panel_emailError,"error11");
					}
				}
				
			});
		email.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，typed和press有区别
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( email.getText().length()>17) {//只允许输入最大18个字符
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =email.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=18)  //不允许空格 ,第二条主要是处理一个bug,
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
			email.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					regExcetion ="[0-9a-zA-Z][0-9a-zA-Z_-]{3,10}@(qq|QQ).com";//正则表达式QQ邮箱(自定义的)
					charTrue = "[0-9a-zA-Z@.-_]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  email.getText().matches(regExcetion); //邮箱匹配
					boolean result2 =  email.getText().matches(charTrue); //邮箱字符正确
					if(!result2)//出现非法字符
																			
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"error11");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					if(result2 && email.getText().length() <18)
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"emil_examp");
					}
					if(result1)
					{
						checkEmail=true;
						cardlayout.show(panel_emailError,"right5");
					}
					
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					regExcetion ="[0-9a-zA-Z][0-9a-zA-Z_-]{3,10}@(qq|QQ).com";//正则表达式QQ邮箱(自定义的)
					charTrue = "[0-9a-zA-Z@.]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  email.getText().matches(regExcetion); //邮箱匹配
					boolean result2 =  email.getText().matches(charTrue); //邮箱字符正确
					if(email.getText().length()==0) {
						checkEmail=false;
						cardlayout.show(panel_emailError,"emil_examp");
						return;
					}
					if(!result2)//出现非法字符
																			
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"error11");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					
					if(result2 && email.getText().length() < 18)
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"label_emil_examp");
					}
					if(result1)
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"right5");
					}
				}
				
			});
			
		 
			
			
		 add(label_IDcard);
		 label_IDcard.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(idcard);
		 idcard.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框
		 label_fillYourIDcard.setOpaque(false);//设置透明
		 label_fillYourIDcard.setBackground(Color.white);
		 label_fillYourIDcard.setForeground(Color.gray);
		 label_fillYourIDcard.setFont(new Font("宋体",Font.PLAIN,12));
		 label_ContainRightFlag6.setIcon(rightFlag);
		 label_ContainRightFlag6.setOpaque(false);//设置透明
		 label_ContainRightFlag6.setBackground(Color.white);
		 add(panel_IDcardError);
		 panel_IDcardError.setBackground(Color.WHITE);
		 panel_IDcardError.setLayout(cardlayout);
		 panel_IDcardError.add(label_fillYourIDcard,"set_idcard");
		 panel_IDcardError.add(label_IDcardEmpty,"error12");
		 panel_IDcardError.add(label_IDcardFormatErrot,"error13");
		 panel_IDcardError.add(label_ContainRightFlag6,"right6");
		 label_IDcardEmpty.setFont(errorFont);
		label_IDcardEmpty.setForeground(Color.RED);
		label_IDcardFormatErrot.setFont(errorFont);
		label_IDcardFormatErrot.setForeground(Color.RED);
		 
		 //添加监听
		idcard.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					idcard.enableInputMethods(false); //禁用掉输入法
					idcard.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
				}
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					idcard.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
					regExcetion ="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]"; //正则表达式18位身份证
					charTrue = "[0-9xX]+";//正则表达式非法字符,若不在0-9 a-z A-Z的字符出现1次到多次
					boolean result1 =  idcard.getText().matches(regExcetion); 
					if(!result1 &&  idcard.getText().length()!=0) {
						cardlayout.show(panel_IDcardError,"error13");
					}
				}
				
			});
		idcard.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，typed和press有区别
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( idcard.getText().length()>17) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =idcard.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=18)  //不允许空格 ,第二条主要是处理一个bug,
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
		idcard.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					regExcetion ="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]"; //正则表达式18位身份证
					charTrue = "[0-9xX]+";
					boolean result1 =  idcard.getText().matches(regExcetion); 
					boolean result2 =  idcard.getText().matches(charTrue); 
					if(!result2 || (result2 && (!result1 && idcard.getText().length()>=18)))//出现非法字符
																				//或者 超过最大字符长度还没匹配
					{
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"error13");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					if(result2 && idcard.getText().length() <18)
					{
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"set_idcard");
					}
					if(result1)
					{
						checkIDCard=true;
						cardlayout.show(panel_IDcardError,"right6");
					}
					
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					regExcetion ="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]"; //正则表达式18位身份证
					charTrue = "[0-9xX]+";
					boolean result1 =  idcard.getText().matches(regExcetion); 
					boolean result2 =  idcard.getText().matches(charTrue); 
					if(idcard.getText().length()==0) {
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"set_idcard");
						return;
					}
					if(!result2 || (result2 && (!result1 && idcard.getText().length()>=18)))//出现非法字符
																				//或者 超过qq最大字符长度还没匹配
					{
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"error13");//两个参数依次是父容器组件，
						//该card的名字(不是label_error1也不是所谓的"用户名不合法",而是添加组件时候的自定义名)
						return;
						
					}
					
					if(result2 && idcard.getText().length() < 18)
					{
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"set_idcard");
					}
					if(result1)
					{
						checkIDCard=true;
						cardlayout.show(panel_IDcardError,"right6");
					}
				}
				
			});
		 add(label_sethead);
		 label_sethead.setHorizontalAlignment(SwingConstants.RIGHT);
		 button_head.setForeground(Color.GRAY);
		 button_head.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
				
				if(SqlUtil.hasselect) {//头像窗口只能打开一次，这样做避免了bug
					JOptionPane.showMessageDialog(null, "头像这么少,再不让你选了", "系统提示", 
							 JOptionPane.INFORMATION_MESSAGE);
					 return;
				}
				if(!SqlUtil.hasselect &&SqlUtil.hasOpen){
					return;
					
				}
				head = new Head();
				SqlUtil.hasOpen=true;
				if(SqlUtil.hasOpen) {
					int x = getContentPane().getLocationOnScreen().x;
	       		 	int y = getContentPane().getLocationOnScreen().y;
	       		 	head.setBounds(x + 290,y +60,130,290);
				}
				
				
			}
		 });
		 add(button_head);
		 add(label_unableChangeHead);
		 label_unableChangeHead.setOpaque(false);//设置透明
		 label_unableChangeHead.setBackground(Color.white);
		 label_unableChangeHead.setForeground(Color.gray);
		 label_unableChangeHead.setFont(new Font("宋体",Font.PLAIN,12));
		
		 
		 
		 add(label_code);
		 label_code.setHorizontalAlignment(SwingConstants.RIGHT);
		 verificationCode.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));
		 add(verificationCode);
		 Random random = new Random();
		string_verificationCode="";
		 for (int i = 0; i < 4; i++) {
			 char c =0;
			 int k = random.nextInt(3);
			 switch (k) {
			 case 0:
				 c = (char) (random.nextInt(10) + 48);//获取0-9，a-z A-Z任意字符
				 	break;
			 case 1:
				 	c = (char) (random.nextInt(26) + 65);
				 	break;
			 case 2:
				 	c = (char) (random.nextInt(26) + 97);
				 	break;
			 }
			 string_verificationCode += c;
		 }
		 label_empty2.setText(string_verificationCode);
		 add(label_empty2);
		 label_empty2.setForeground(new Color(230,22,199));
 label_empty2.addMouseListener(new MouseAdapter() {//因为只需要用到鼠标click监听，故选用适配器
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	 Random random = new Random();
	 string_verificationCode = "";//为空，避免点击后验证码越来越长
	 for (int i = 0; i < 4; i++) {
		char c='\u0000';//任意给一个初值，避免str+=c空指针异常,这里用字符默认值空'\u0000'(unicode)
		int k = random.nextInt(3);//获取0到2的随机数，用于switch语句
		switch (k) {
			case 0:
				c = (char) (random.nextInt(10) + '0');//返回字符'0'-'9'
						 	break;
			case 1:
				c = (char) (random.nextInt(26) + 'a');//返回字符'a'-'z'
				break;
			case 2:
				c = (char) (random.nextInt(26) + 'A');//返回字符'A'-'Z'
				break;
			 }
			 string_verificationCode += c;//字符串拼接为一个四位验证码
		}
	 label_empty2.setText(string_verificationCode);//验证码lable设置内容为该随机字符串
	}
});
		 verificationCode.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					if( verificationCode.getText().equals(label_empty2.getText()))//验证码正确
																			
					{
						checkVerificationCode=true;
					}
					else {
						checkVerificationCode=false;
					}
				}

				@Override
				public void removeUpdate(DocumentEvent e) {//光标删除操作
					if( verificationCode.getText().equals(label_empty2.getText()))
						
					{
						checkVerificationCode=true;
					}
					else {
						checkVerificationCode=false;
					}
				}
				
			});
		 verificationCode.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//获得focus
					 label_empty2.setText(string_verificationCode);//恢复
					cardlayout.show(panel_NotFinishError,"final");//耐心填写吧
					verificationCode.enableInputMethods(false); //禁用掉输入法
					verificationCode.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//变蓝色框
				}
				public void focusLost(FocusEvent e) {//失去focus
					// TODO Auto-generated method stub
					verificationCode.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//边框复原
				}
				
			});
		 verificationCode.addKeyListener(new KeyAdapter() {//限制输入长度,这里要注意不能重写KeyPress方法,达不到效果，typed和press有区别
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( nickname.getText().length()>5) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =verificationCode.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=5)  //不允许空格 ,第二条主要是处理一个bug,
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
		
		 add(label_empty4);
		 add(button_submit);
		 button_submit.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Date utilDate  =new Date();//java.util.date
			     java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			     if(radiobutton_passenger.isSelected()) {
			    	 if((checkLeftButton||checkRightButton) && checkUsername && checkPassword && checkReConfirmPwd && checkNickname && checkEmail
			    			 && checkIDCard &&  SqlUtil.hasselect && checkVerificationCode){//信息都填写完毕才能注册
			    		 String str3 = SqlOperation.addUser(username.getText(), password.getText(), email.getText(),
									nickname.getText(), idcard.getText(),sqlDate,"头像"+String.valueOf(SqlUtil.headkind),SqlUtil.userState);
				    	 label_empty1.setText(str3);
				    	 label_empty1.setForeground(Color.BLUE);
				    	 cardlayout.show(panel_NotFinishError,"error16");//将返回错误信息提示(账号信息重复问题)
			    	 }else {
			    		 if(!checkVerificationCode && verificationCode.getText().length()!=0) {
			    			 label_empty2.setText("验证码不正确");//验证码不正确
			    			 return;
			    		 }
			    		 cardlayout.show(panel_NotFinishError,"error15");//信息填写不完善
			    	 }
			    	
			     }else if(radiobutton_admini.isSelected()) {
			    	 if((checkLeftButton||checkRightButton) && checkUsername && checkPassword && checkReConfirmPwd && checkNickname && checkEmail
			    			 && checkIDCard &&  SqlUtil.hasselect && checkVerificationCode){//信息都填写完毕才能注册
			    	 String str3 = SqlOperation.addAdmi(username.getText(), password.getText(), email.getText(),
					nickname.getText(), idcard.getText(),sqlDate,"头像"+String.valueOf(SqlUtil.headkind),SqlUtil.userState);
			    	 label_empty1.setText(str3);
			    	 cardlayout.show(panel_NotFinishError,"error16");//将返回错误信息提示(账号信息重复问题)
			    	 }else {
			    		 if(!checkVerificationCode && verificationCode.getText().length()!=0) {
			    			 label_empty2.setText("验证码不正确");//验证码不正确
			    			 return;
			    		 }
			    		 cardlayout.show(panel_NotFinishError,"error15");//信息填写不完善
			    	 }
			     }else {
			    	 cardlayout.show(panel_NotFinishError,"error14");//请选择注册类型
			     }
			     
			}
			 
		 });
		 add(label_empty5);
			
			
			
			
	}
	
	
	static class Head extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包  
		private Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸  
		private int screenWidth = screenSize.width; //获取屏幕的宽  
		private int screenHeight = screenSize.height; //获取屏幕的高  
		private int reg_startX = (screenWidth-440) / 2;//注册窗口的左上角坐标x
		private int reg_startY = (screenHeight-385) / 2;//注册窗口的左上角坐标y
		private ImageIcon head0 = new ImageIcon("pic_reg\\头像0.png");
		private ImageIcon head1 = new ImageIcon("pic_reg\\头像1.png");
		private ImageIcon head2 = new ImageIcon("pic_reg\\头像2.png");
		private ImageIcon head3 = new ImageIcon("pic_reg\\头像3.png");
		private ImageIcon head4 = new ImageIcon("pic_reg\\头像4.png");
		private ImageIcon head5 = new ImageIcon("pic_reg\\头像5.png");
		private ImageIcon head6 = new ImageIcon("pic_reg\\头像6.png");
		private ImageIcon head7 = new ImageIcon("pic_reg\\头像7.png");
		private JLabel label0 = new JLabel();
		private JLabel label1 = new JLabel();
		private JLabel label2 = new JLabel();
		private JLabel label3 = new JLabel();
		private JLabel label4 = new JLabel();
		private JLabel label5 = new JLabel();
		private JLabel label6 = new JLabel();
		private JLabel label7 = new JLabel();
		private JPanel panel0 = new JPanel();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
		private JPanel panel3 = new JPanel();
		private JPanel panel4 = new JPanel();
		private JPanel panel5 = new JPanel();
		private JPanel panel6 = new JPanel();
		private JPanel panel7 = new JPanel();

		public Head() {
			Toolkit tool=this.getToolkit(); //得到一个Toolkit对象
			Image myimage=tool.getImage("pic_reg//注册图标.png"); //由tool获取图像
			setIconImage(myimage);//设置窗口图标
			this.setUndecorated(true); //隐藏窗框
			setAlwaysOnTop(true);//不容易发现是一个窗口而像是注册界面的面板
			setLayout(new GridLayout(4,2,5,5));
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			//setBounds(reg_startX + 300,reg_startY + 80,130,290);
			setVisible(true);
			setResizable(false);
			
			add(panel0);
			panel0.add(label0);
			label0.setIcon(head0);
			panel0.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel0.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head0");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=0;
					dispose();
				}
			});
			add(panel1);
			panel1.add(label1);
			label1.setIcon(head1);
			panel1.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head1");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=1;
					dispose();
				}
			});
			
			add(panel2);
			panel2.add(label2);
			label2.setIcon(head2);
			panel2.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head2");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=2;
					dispose();
				}
			});
			
			add(panel3);
			panel3.add(label3);
			label3.setIcon(head3);
			panel3.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head3");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=3;
					dispose();
				}
			});
			
			add(panel4);
			panel4.add(label4);
			label4.setIcon(head4);
			panel4.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head4");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=4;
					dispose();
				}
			});
			
			add(panel5);
			panel5.add(label5);
			label5.setIcon(head5);
			panel5.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head5");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=5;
					dispose();
				}
			});
			
			add(panel6);
			panel6.add(label6);
			label6.setIcon(head6);
			panel6.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head6");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=6;
					dispose();
				}
			});
			
			add(panel7);
			panel7.add(label7);
			label7.setIcon(head7);
			panel7.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
			panel7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Register.button_head.setLabel("head7");
					SqlUtil.hasselect=true;
					SqlUtil.headkind=7;
					dispose();
					
				}
			});
			
			
			
		}
	}
}



