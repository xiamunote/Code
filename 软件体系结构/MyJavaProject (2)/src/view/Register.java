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
	 * ע�ᴰ��
	 */
	
	private static final long serialVersionUID = 1L;//���л��İ汾��
	private int compenontMove = 0;
	private Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�  
	private Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�  
	private int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�  
	private int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�  
	private int reg_startX = (screenWidth-440) / 2;//ע�ᴰ�ڵ����Ͻ�����x
	private int reg_startY = (screenHeight-385) / 2;//ע�ᴰ�ڵ����Ͻ�����y
	
	private boolean checkLeftButton,checkRightButton,checkUsername,checkPassword,
			checkReConfirmPwd,checkNickname,checkEmail,
			checkIDCard,checkVerificationCode;//��¼������д���������ע�ᰴť����,Ĭ��false
	StringBuilder string_pwdContent,string_checkPwdContent;//��¼�����ȷ�Ͽ��ַ���,Ĭ��null
	String string_verificationCode = "";//������֤��
	public boolean headWindowHasOpen = false;//�ж�ͷ�񴰿��Ƿ��
	private boolean right_pwd;//���ڱ�־�����ȷ���������ȷ�ԣ���Ϊif���ο�,Ĭ��false
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
	private JRadioButton radiobutton_passenger = new JRadioButton("�˿�"), 
			radiobutton_admini =  new JRadioButton("����");
	private ButtonGroup btnGroup = new ButtonGroup();
	private JButton button_submit=new JButton("ע��");
	private Font errorFont = new Font("����",Font.PLAIN,12);//�����������
	private Robot robot; //����ģ�ⰴ��
	private ImageIcon rightFlag = new ImageIcon("pic_login\\��ȷ.png");
	private String regExcetion,charTrue;
	private JLabel label_AccountKind = new JLabel("�˺�����"),label_username = new JLabel("�û���"),
			label_pwd = new JLabel("����д���ĵ�����"),label_pwd1 = new JLabel("����"),label_checkpwd = new JLabel("ȷ������"),
			label_email = new JLabel("��������"),label_IDcard = new JLabel("���֤"),
	label_nickname = new JLabel("�����ǳ�"),label_sethead = new JLabel("����ͷ��"),
	label_code = new JLabel("��֤��"),
	label_usernameEmpty = new JLabel("�û���Ϊ��!"),label_formatError = new JLabel("��ʽ����ȷ"),
	label_pwdEmpty = new JLabel("����Ϊ�գ�"),label_pwdLenthError = new JLabel("5-10����ĸ������"),
	label_CheckPwd = new JLabel("��ȷ������"),label_pwdDiffer = new JLabel("��ԭ���벻һ��"),label_firstFillPwd = new JLabel("�������������"),
	label_nicknameLenthError = new JLabel("����2-10�ַ�"),
	label_emailEmpty = new JLabel("����Ϊ��!"),label_emailFormatError = new JLabel("��ʽ����ȷ"),label_supportQQEmail = new JLabel("��֧��QQ�����"),
	label_IDcardEmpty = new JLabel("���֤Ϊ��!"),label_IDcardFormatErrot = new JLabel("��ʽ����ȷ"),
	label_selectRegKind = new JLabel("��ѡ��ע������"),label_fillAll = new JLabel("�뽫��Ϣ��д����"),
	label_empty1 = new JLabel(""),label_empty2=new JLabel(""),label1_empty3=new JLabel(""),label_reg = new JLabel("ע��"),
	label_empty4=new JLabel(""),label_empty5=new JLabel(""),label_haveAccount = new JLabel("�����˺�,"),
	label_denglu = new JLabel("��¼"),label_checkYourPwd=new JLabel("��ʵ��������"),
	label_unableChangeHead=new JLabel("ͷ�����ú��ܸ���"),
	label_fillPatient = new JLabel("���ĵ����"),label_right1=new JLabel(),label_right2=new JLabel(),label_right3=new JLabel(),
	label_ContainRightFlag4=new JLabel(),label_ContainRightFlag5=new JLabel(),label_ContainRightFlag6=new JLabel(),label_fillPhone = new JLabel("����д�ֻ�����"),
	label_setNickname = new JLabel("����������ǳ�"),label_fillYourIDcard = new JLabel("����д�������֤");
	private CardLayout cardlayout = new CardLayout();
	public static Head head=null;

	public Register(){
		super("ע������");
		setUndecorated(true); //���ش���
		//����ָ���Ĵ���װ�η��
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);//�ı䴰������
		ImageIcon iIcon = new ImageIcon("pic_login/����") ;
		//new ImgPanel(iIcon.getImage(),this.getSize());
		Toolkit tool=this.getToolkit(); //�õ�һ��Toolkit����
		Image myimage=tool.getImage("pic_login//ע��ͼ��.png"); //��tool��ȡͼ��
		setIconImage(myimage);//���ô���ͼ��
		setBounds(reg_startX,reg_startY,440,385);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		//setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		 gridlayout = new GridLayout(12,3,20,2);
		 setLayout(gridlayout);
		//���ڼ���
			this.addWindowListener(new WindowAdapter(){//���ڴ򿪾���ͷ���ý��㣬�������radiobutton1��ã�Ӱ������
			       public void windowOpened(WindowEvent e) {
			    	   panel_haveAccountToLogin.requestFocus();
			    	   button_head.setLabel("head");//��Ϊͷ�������ȫ�ֱ���
			    	   SqlUtil.hasselect= false;//���ͷ����ѡ��
			    	   SqlUtil.hasOpen= false;//���ͷ���Ƿ��
			       }
			       public void windowClosing(WindowEvent e) {
			    	   if(SqlUtil.hasOpen) {//ͷ�񴰿ڴ��˾�һͬ�ر�
							head.dispose();
						}
			       }
			});
			
			//����������
			 this.addComponentListener(new ComponentAdapter(){
	              public void componentMoved(ComponentEvent e) {//����ƶ�(ʵ���Ǵ����ƶ�)
	                	compenontMove++;
	                	if(compenontMove>3 && SqlUtil.hasOpen) {
	                		
	                		int reg_moveX = (int)e.getComponent().getLocationOnScreen().getX();//��ȡ�ƶ���ԭ�������Ͻǵ�x����
	                		int reg_moveY = (int)e.getComponent().getLocationOnScreen().getY();//��ȡ�ƶ���ԭ�������Ͻǵ�y����
	                		head.setBounds(reg_moveX + 290,reg_moveY +90,130,290);//ͷ������ԭ����λ����Զ����
	                		
	                	}
	                }
	            }); 
		 //��һ��
		
		 add(label_reg);
		 label_reg.setHorizontalAlignment(SwingConstants.RIGHT);//�����Ҷ���
		 add(panel_haveAccountToLogin);
		 panel_haveAccountToLogin.add(label_haveAccount);
		 panel_haveAccountToLogin.setBackground(Color.white);
		 label_haveAccount.setHorizontalAlignment(SwingConstants.CENTER);
		 panel_haveAccountToLogin.add(label_denglu);
		 label_denglu.setForeground(Color.BLUE);
		 label_denglu.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {//�����
					dispose();
					new Login();//ע�����
					if(SqlUtil.hasOpen) {//ͷ�񴰿ڴ��˾�һͬ�ر�
						head.dispose();
					}
					
				}
				public void mouseEntered(MouseEvent e) {
					label_denglu.setForeground(new Color(100,80,255));// �����������
				}
				public void mouseExited(MouseEvent e) {
					label_denglu.setForeground(Color.blue);// ��������뿪
				}
				});
		 add(label1_empty3);
		
		
		
		 
		//�ڶ���
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
		 radiobutton_passenger.addActionListener(new ActionListener() {//������ť��һ�������£���ť�鶼����ѡ��
				public void actionPerformed(ActionEvent e) {
					if(radiobutton_passenger.isSelected()) {
						checkLeftButton=true;
					}
				}
			});
		 radiobutton_admini.addActionListener(new ActionListener() {//������ť��һ�������£���ť�鶼����ѡ��
			 public void actionPerformed(ActionEvent e) {
				 if(radiobutton_admini.isSelected()) {
					 checkRightButton=true;
				 }
			 }
		 });
		 add(panel_NotFinishError);
		 label_fillPatient.setOpaque(false);//����͸��
		 label_fillPatient.setBackground(Color.white);
		 label_fillPatient.setForeground(Color.gray);
		 label_fillPatient.setFont(new Font("����",Font.PLAIN,12));
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
		
		
		
		
		
		
		 //�����У��û���
		 add(label_username);
		 label_username.setHorizontalAlignment(SwingConstants.RIGHT);
		 add(username);
		 username.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�
		 label_fillPhone.setOpaque(false);//����͸��
		 label_fillPhone.setBackground(Color.white);
		 label_fillPhone.setForeground(Color.gray);
		 label_fillPhone.setFont(new Font("����",Font.PLAIN,12));
		 label_right1.setIcon(rightFlag);
		 label_right1.setOpaque(false);//����͸��
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
		 
		 //��Ӽ���
		 username.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//���focus
					cardlayout.show(panel_NotFinishError,"final");//������д��
					username.enableInputMethods(false); //���õ����뷨
					username.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
				}
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					username.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
					regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //������ʽ�ֻ���
					charTrue = "[0-9]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  username.getText().matches(regExcetion); //�û���ƥ��
					if(!result1 &&  username.getText().length()!=0) {
						cardlayout.show(panel_usernameError,"error2");
					}
				}
				
			});
			username.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����typed��press������
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( username.getText().length()>11) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =username.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=12)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
				        { 
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
					regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //������ʽ�ֻ���
					charTrue = "[0-9]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  username.getText().matches(regExcetion); //�û���ƥ��
					boolean result2 =  username.getText().matches(charTrue); //�û����ַ���ȷ
					if(!result2 || (result2 && (!result1 && username.getText().length()>=11)))//���ַǷ��ַ�
																				//���� ��������ַ����Ȼ�ûƥ��
					{
						checkUsername=false;
						cardlayout.show(panel_usernameError,"error2");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
				public void removeUpdate(DocumentEvent e) {//���ɾ������
					//regExcetion ="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//������ʽ����
					regExcetion ="1[3|4|5|8][0-9]\\d{8}"; //������ʽ�ֻ���
					charTrue = "[0-9]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  username.getText().matches(regExcetion); //�û���ƥ��
					boolean result2 =  username.getText().matches(charTrue); //�û����ַ���ȷ
					if(username.getText().length()==0) {
						cardlayout.show(panel_usernameError,"phone");
						checkUsername=false;
						return;
					}
					if(!result2 || (result2 && (!result1 && username.getText().length()>=11)))//���ַǷ��ַ�
																				//���� ����qq����ַ����Ȼ�ûƥ��
					{
						checkUsername=false;
						cardlayout.show(panel_usernameError,"error2");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
		 password.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�
		 password.setEchoChar('*');
		 password.setFont(new Font("����",Font.PLAIN,18));
		 label_pwd.setOpaque(false);//����͸��
		 label_pwd.setBackground(Color.white);
		 label_pwd.setForeground(Color.gray);
		 label_pwd.setFont(new Font("����",Font.PLAIN,12));
		 label_right2.setIcon(rightFlag);
		 label_right2.setOpaque(false);//����͸��
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
		 //��Ӽ���
		password.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//���focus
					cardlayout.show(panel_NotFinishError,"final");//������д��
					password.enableInputMethods(false); //���õ����뷨
					password.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
					
				}
				@SuppressWarnings("deprecation")
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					password.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
					regExcetion ="[a-zA-Z0-9]{5,10}";//������ʽ����(5��10���ַ������ִ�С)
					charTrue = "[0-9a-zA-Z]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  password.getText().matches(regExcetion); //����ƥ��
					if(!result1 && password.getText().length()!=0) {//��ƥ����ʾ�����뻹����ȷ�����ܽ�����������
						cardlayout.show(panel_pwdError,"error4");
					}
				}
				
			});
		password.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����typed��press������
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
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=12)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
					 {	 //�����뵽������,���¿ո���Զ�ɾ��һ���ַ�
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
					regExcetion ="[a-zA-Z0-9]{5,10}";//������ʽ����(5��10���ַ������ִ�С)
					charTrue = "[0-9a-zA-Z]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  password.getText().matches(regExcetion); //�û���ƥ��
					boolean result2 =  password.getText().matches(charTrue); //�û����ַ���ȷ
					if(!result2 || (result2 && (!result1 && password.getText().length()>=5)))//���ַǷ��ַ�
																				//���� ��������ַ����Ȼ�ûƥ��
					{
						
						cardlayout.show(panel_pwdError,"error4");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
						right_pwd = false;
						checkPassword=false;//������������һ���ģ�����Ϊ�˱��ⷱ�Ӿ�ûȥ��
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
				public void removeUpdate(DocumentEvent e) {//���ɾ������
					//regExcetion ="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";//������ʽ����
					regExcetion ="[a-zA-Z0-9]{5,10}";//������ʽ����(5��10���ַ������ִ�С)
					charTrue = "[0-9a-zA-Z]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  password.getText().matches(regExcetion); //�û���ƥ��
					boolean result2 =  password.getText().matches(charTrue); //�û����ַ���ȷ
					if(password.getText().length()==0) {
						cardlayout.show(panel_pwdError,"pwd");
						right_pwd = false;
						checkPassword=false;
						return;
					}
					if(!result2 || (result2 && (!result1 && password.getText().length()>=5)))//���ַǷ��ַ�
																				//���� ����qq����ַ����Ȼ�ûƥ��
					{
						checkPassword=false;
						cardlayout.show(panel_pwdError,"error4");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
		 checkpwd.setFont(new Font("����",Font.PLAIN,18));
		 add(panel_reCheckPwdError);
		 panel_emailError.setLayout(cardlayout);		
		 checkpwd.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�
		 label_checkYourPwd.setOpaque(false);//����͸��
		 label_checkYourPwd.setBackground(Color.white);
		 label_checkYourPwd.setForeground(Color.gray);
		 label_checkYourPwd.setFont(new Font("����",Font.PLAIN,12));
		 label_right3.setIcon(rightFlag);
		 label_right3.setOpaque(false);//����͸��
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
		 
		 //��Ӽ���
		checkpwd.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//���focus
					cardlayout.show(panel_NotFinishError,"final");//������д��
					checkpwd.enableInputMethods(false); //���õ����뷨
					checkpwd.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
					if(right_pwd==false) {
						cardlayout.show(panel_reCheckPwdError,"error7");
					}
				}
				@SuppressWarnings("deprecation")
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					checkpwd.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
					if(checkpwd.getText().length()==0) {
						cardlayout.show(panel_reCheckPwdError,"null3");
					}
					
					//ûȷ�������룬������ʾ,Ҫ���������������,������֮��,д�겻��ʾ
					if(checkpwd.getText().length()!=0 && checkpwd.getText().length()!=password.getText().length() 
							&& password.getText()!=checkpwd.getText()) {
						cardlayout.show(panel_reCheckPwdError,"error5");
					}
					
				}
				
			});
		checkpwd.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����
			//typed��press������
				@SuppressWarnings("deprecation")
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					if(!right_pwd || len2==len1) {//���벻��ȷ�ÿ򲻿���,���벻�ܱ�ԭ���볤������ᷢ���쳣��
						//StringBuilder��subString()����Խ��
						e.consume();
					}
				}

				@SuppressWarnings("deprecation")
				@Override
				public void keyPressed(KeyEvent e) {
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len2!=len1)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
						 //�����뵽������,���¿ո���Զ�ɾ��һ���ַ�
				        { 
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
						return;//�����ж�
					}
					if(!string_pwdContent.substring(0, len2).equals(string_checkPwdContent.substring(0, len2))) {//��ԭ���벻һ��
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
				public void removeUpdate(DocumentEvent e) {//���ɾ������
					int len1 =  password.getText().length();
					int len2 =  checkpwd.getText().length();
					string_pwdContent = new StringBuilder( password.getText());
					string_checkPwdContent = new StringBuilder( checkpwd.getText());
					if(!right_pwd) {
						checkReConfirmPwd=false;
						cardlayout.show(panel_reCheckPwdError,"error7");
						return;//�����ж�
					}
					if(!string_pwdContent.substring(0, len2).equals(string_checkPwdContent.substring(0, len2))) {//��ԭ���벻һ��
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
		 nickname.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�
		 label_setNickname.setOpaque(false);//����͸��
		 label_setNickname.setBackground(Color.white);
		 label_setNickname.setForeground(Color.gray);
		 label_setNickname.setFont(new Font("����",Font.PLAIN,12));
		 label_ContainRightFlag4.setIcon(rightFlag);
		 label_ContainRightFlag4.setOpaque(false);//����͸��
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
		 
		 //��Ӽ���
		nickname.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//���focus
					cardlayout.show(panel_NotFinishError,"final");//������д��
					nickname.enableInputMethods(false); //���õ����뷨
					nickname.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
				}
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					nickname.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
					if(nickname.getText().length() == 1) {
						cardlayout.show(panel_nicknameError,"error9");
					}
				}
				
			});
		nickname.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����typed��press������
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( nickname.getText().length()>11) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =nickname.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=12)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
				        { 
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
					if( nickname.getText().length()  > 10)//����
																			
					{
						checkNickname=false;
						cardlayout.show(panel_nicknameError,"error9");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
				public void removeUpdate(DocumentEvent e) {//���ɾ������
					if( nickname.getText().length()  > 10)//����
						
					{
						checkNickname=false;
						cardlayout.show(panel_nicknameError,"error9");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
		 email.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�
		 label_supportQQEmail.setOpaque(false);//����͸��
		 label_supportQQEmail.setBackground(Color.white);
		 label_supportQQEmail.setForeground(Color.gray);
		 label_supportQQEmail.setFont(new Font("����",Font.PLAIN,12));
		 label_ContainRightFlag5.setIcon(rightFlag);
		 label_ContainRightFlag5.setOpaque(false);//����͸��
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
		 
		 //��Ӽ���
		email.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//���focus
					cardlayout.show(panel_NotFinishError,"final");//������д��
					email.enableInputMethods(false); //���õ����뷨
					email.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
				}
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					email.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
					regExcetion ="[0-9a-zA-Z][0-9a-zA-Z_-]{3,10}@(qq|QQ).com";//������ʽQQ����(�Զ����)
					charTrue = "[0-9a-zA-Z@.-_]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  email.getText().matches(regExcetion); //����ƥ��
					if(!result1 &&  email.getText().length()!=0) {
						cardlayout.show(panel_emailError,"error11");
					}
				}
				
			});
		email.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����typed��press������
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( email.getText().length()>17) {//ֻ�����������18���ַ�
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =email.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=18)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
				        { 
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
					regExcetion ="[0-9a-zA-Z][0-9a-zA-Z_-]{3,10}@(qq|QQ).com";//������ʽQQ����(�Զ����)
					charTrue = "[0-9a-zA-Z@.-_]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  email.getText().matches(regExcetion); //����ƥ��
					boolean result2 =  email.getText().matches(charTrue); //�����ַ���ȷ
					if(!result2)//���ַǷ��ַ�
																			
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"error11");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
				public void removeUpdate(DocumentEvent e) {//���ɾ������
					regExcetion ="[0-9a-zA-Z][0-9a-zA-Z_-]{3,10}@(qq|QQ).com";//������ʽQQ����(�Զ����)
					charTrue = "[0-9a-zA-Z@.]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  email.getText().matches(regExcetion); //����ƥ��
					boolean result2 =  email.getText().matches(charTrue); //�����ַ���ȷ
					if(email.getText().length()==0) {
						checkEmail=false;
						cardlayout.show(panel_emailError,"emil_examp");
						return;
					}
					if(!result2)//���ַǷ��ַ�
																			
					{
						checkEmail=false;
						cardlayout.show(panel_emailError,"error11");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
		 idcard.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�
		 label_fillYourIDcard.setOpaque(false);//����͸��
		 label_fillYourIDcard.setBackground(Color.white);
		 label_fillYourIDcard.setForeground(Color.gray);
		 label_fillYourIDcard.setFont(new Font("����",Font.PLAIN,12));
		 label_ContainRightFlag6.setIcon(rightFlag);
		 label_ContainRightFlag6.setOpaque(false);//����͸��
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
		 
		 //��Ӽ���
		idcard.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {//���focus
					cardlayout.show(panel_NotFinishError,"final");//������д��
					idcard.enableInputMethods(false); //���õ����뷨
					idcard.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
				}
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					idcard.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
					regExcetion ="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]"; //������ʽ18λ���֤
					charTrue = "[0-9xX]+";//������ʽ�Ƿ��ַ�,������0-9 a-z A-Z���ַ�����1�ε����
					boolean result1 =  idcard.getText().matches(regExcetion); 
					if(!result1 &&  idcard.getText().length()!=0) {
						cardlayout.show(panel_IDcardError,"error13");
					}
				}
				
			});
		idcard.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����typed��press������
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( idcard.getText().length()>17) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =idcard.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=18)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
				        { 
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
					regExcetion ="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]"; //������ʽ18λ���֤
					charTrue = "[0-9xX]+";
					boolean result1 =  idcard.getText().matches(regExcetion); 
					boolean result2 =  idcard.getText().matches(charTrue); 
					if(!result2 || (result2 && (!result1 && idcard.getText().length()>=18)))//���ַǷ��ַ�
																				//���� ��������ַ����Ȼ�ûƥ��
					{
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"error13");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
				public void removeUpdate(DocumentEvent e) {//���ɾ������
					regExcetion ="^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]"; //������ʽ18λ���֤
					charTrue = "[0-9xX]+";
					boolean result1 =  idcard.getText().matches(regExcetion); 
					boolean result2 =  idcard.getText().matches(charTrue); 
					if(idcard.getText().length()==0) {
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"set_idcard");
						return;
					}
					if(!result2 || (result2 && (!result1 && idcard.getText().length()>=18)))//���ַǷ��ַ�
																				//���� ����qq����ַ����Ȼ�ûƥ��
					{
						checkIDCard=false;
						cardlayout.show(panel_IDcardError,"error13");//�������������Ǹ����������
						//��card������(����label_error1Ҳ������ν��"�û������Ϸ�",����������ʱ����Զ�����)
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
				cardlayout.show(panel_NotFinishError,"final");//������д��
				
				if(SqlUtil.hasselect) {//ͷ�񴰿�ֻ�ܴ�һ�Σ�������������bug
					JOptionPane.showMessageDialog(null, "ͷ����ô��,�ٲ�����ѡ��", "ϵͳ��ʾ", 
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
		 label_unableChangeHead.setOpaque(false);//����͸��
		 label_unableChangeHead.setBackground(Color.white);
		 label_unableChangeHead.setForeground(Color.gray);
		 label_unableChangeHead.setFont(new Font("����",Font.PLAIN,12));
		
		 
		 
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
				 c = (char) (random.nextInt(10) + 48);//��ȡ0-9��a-z A-Z�����ַ�
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
 label_empty2.addMouseListener(new MouseAdapter() {//��Ϊֻ��Ҫ�õ����click��������ѡ��������
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	 Random random = new Random();
	 string_verificationCode = "";//Ϊ�գ�����������֤��Խ��Խ��
	 for (int i = 0; i < 4; i++) {
		char c='\u0000';//�����һ����ֵ������str+=c��ָ���쳣,�������ַ�Ĭ��ֵ��'\u0000'(unicode)
		int k = random.nextInt(3);//��ȡ0��2�������������switch���
		switch (k) {
			case 0:
				c = (char) (random.nextInt(10) + '0');//�����ַ�'0'-'9'
						 	break;
			case 1:
				c = (char) (random.nextInt(26) + 'a');//�����ַ�'a'-'z'
				break;
			case 2:
				c = (char) (random.nextInt(26) + 'A');//�����ַ�'A'-'Z'
				break;
			 }
			 string_verificationCode += c;//�ַ���ƴ��Ϊһ����λ��֤��
		}
	 label_empty2.setText(string_verificationCode);//��֤��lable��������Ϊ������ַ���
	}
});
		 verificationCode.getDocument().addDocumentListener (new DocumentListener() {

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					if( verificationCode.getText().equals(label_empty2.getText()))//��֤����ȷ
																			
					{
						checkVerificationCode=true;
					}
					else {
						checkVerificationCode=false;
					}
				}

				@Override
				public void removeUpdate(DocumentEvent e) {//���ɾ������
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
				public void focusGained(FocusEvent e) {//���focus
					 label_empty2.setText(string_verificationCode);//�ָ�
					cardlayout.show(panel_NotFinishError,"final");//������д��
					verificationCode.enableInputMethods(false); //���õ����뷨
					verificationCode.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));//����ɫ��
				}
				public void focusLost(FocusEvent e) {//ʧȥfocus
					// TODO Auto-generated method stub
					verificationCode.setBorder(BorderFactory.createLineBorder(new Color(144,119,119)));//�߿�ԭ
				}
				
			});
		 verificationCode.addKeyListener(new KeyAdapter() {//�������볤��,����Ҫע�ⲻ����дKeyPress����,�ﲻ��Ч����typed��press������
				public void keyTyped(KeyEvent e){
					// TODO Auto-generated method stub
					if( nickname.getText().length()>5) {
						e.consume();
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					int len =verificationCode.getText().length();
					 if(e.getKeyChar()==KeyEvent.VK_SPACE && len!=5)  //������ո� ,�ڶ�����Ҫ�Ǵ���һ��bug,
				        { 
						 try {
								robot = new Robot();
							} catch (AWTException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							robot.keyPress(8);//ģ�ⰴ��BackSpace�˸�
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
			    			 && checkIDCard &&  SqlUtil.hasselect && checkVerificationCode){//��Ϣ����д��ϲ���ע��
			    		 String str3 = SqlOperation.addUser(username.getText(), password.getText(), email.getText(),
									nickname.getText(), idcard.getText(),sqlDate,"ͷ��"+String.valueOf(SqlUtil.headkind),SqlUtil.userState);
				    	 label_empty1.setText(str3);
				    	 label_empty1.setForeground(Color.BLUE);
				    	 cardlayout.show(panel_NotFinishError,"error16");//�����ش�����Ϣ��ʾ(�˺���Ϣ�ظ�����)
			    	 }else {
			    		 if(!checkVerificationCode && verificationCode.getText().length()!=0) {
			    			 label_empty2.setText("��֤�벻��ȷ");//��֤�벻��ȷ
			    			 return;
			    		 }
			    		 cardlayout.show(panel_NotFinishError,"error15");//��Ϣ��д������
			    	 }
			    	
			     }else if(radiobutton_admini.isSelected()) {
			    	 if((checkLeftButton||checkRightButton) && checkUsername && checkPassword && checkReConfirmPwd && checkNickname && checkEmail
			    			 && checkIDCard &&  SqlUtil.hasselect && checkVerificationCode){//��Ϣ����д��ϲ���ע��
			    	 String str3 = SqlOperation.addAdmi(username.getText(), password.getText(), email.getText(),
					nickname.getText(), idcard.getText(),sqlDate,"ͷ��"+String.valueOf(SqlUtil.headkind),SqlUtil.userState);
			    	 label_empty1.setText(str3);
			    	 cardlayout.show(panel_NotFinishError,"error16");//�����ش�����Ϣ��ʾ(�˺���Ϣ�ظ�����)
			    	 }else {
			    		 if(!checkVerificationCode && verificationCode.getText().length()!=0) {
			    			 label_empty2.setText("��֤�벻��ȷ");//��֤�벻��ȷ
			    			 return;
			    		 }
			    		 cardlayout.show(panel_NotFinishError,"error15");//��Ϣ��д������
			    	 }
			     }else {
			    	 cardlayout.show(panel_NotFinishError,"error14");//��ѡ��ע������
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
		private Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�  
		private Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�  
		private int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�  
		private int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�  
		private int reg_startX = (screenWidth-440) / 2;//ע�ᴰ�ڵ����Ͻ�����x
		private int reg_startY = (screenHeight-385) / 2;//ע�ᴰ�ڵ����Ͻ�����y
		private ImageIcon head0 = new ImageIcon("pic_reg\\ͷ��0.png");
		private ImageIcon head1 = new ImageIcon("pic_reg\\ͷ��1.png");
		private ImageIcon head2 = new ImageIcon("pic_reg\\ͷ��2.png");
		private ImageIcon head3 = new ImageIcon("pic_reg\\ͷ��3.png");
		private ImageIcon head4 = new ImageIcon("pic_reg\\ͷ��4.png");
		private ImageIcon head5 = new ImageIcon("pic_reg\\ͷ��5.png");
		private ImageIcon head6 = new ImageIcon("pic_reg\\ͷ��6.png");
		private ImageIcon head7 = new ImageIcon("pic_reg\\ͷ��7.png");
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
			Toolkit tool=this.getToolkit(); //�õ�һ��Toolkit����
			Image myimage=tool.getImage("pic_reg//ע��ͼ��.png"); //��tool��ȡͼ��
			setIconImage(myimage);//���ô���ͼ��
			this.setUndecorated(true); //���ش���
			setAlwaysOnTop(true);//�����׷�����һ�����ڶ�����ע���������
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



