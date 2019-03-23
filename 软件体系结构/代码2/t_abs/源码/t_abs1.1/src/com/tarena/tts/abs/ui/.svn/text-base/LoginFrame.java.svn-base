package com.tarena.tts.abs.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tarena.tts.abs.entity.User;

/**
 * 系统登录界面, 采用绝对位置布局
 * 
 * @author Robin
 * 
 */
public class LoginFrame extends JFrame {

	private static final long serialVersionUID = -7025285328934251122L;

	// UI
	private ClientContext context;
	private JTextField nameFiled;
	private JPasswordField pwdFiled;
	private JButton loginButton;
	private JButton cancelButton;

	// Entity
	User user;

	public LoginFrame(ClientContext context) {
		this.context = context;
		init();
	}

	public LoginFrame() {
		init();
	}

	/**
	 * 初始化登录界面
	 */
	private void init() {
		setTitle("登录系统");
		setResizable(false);
		setSize(508, 386);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);
		
		//点击"关闭"按钮时，弹出提示框
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				context.exit(LoginFrame.this);
			}
		});
	}

	private JPanel createContentPane() {
		// 使用自定义布局
		JPanel pane = new JPanel(null);

		pane.add(ceateNameField());
		pane.add(ceatePwdField());
		pane.add(ceateLoginButton());
		pane.add(ceateCancelButton());
		pane.add(createBackground());
		return pane;
	}

	private JLabel createBackground() {
		ImageIcon img = new ImageIcon(getClass().getResource("login.png"));
		JLabel l = new JLabel(img);
		l.setSize(img.getIconWidth(), img.getIconHeight());
		l.setLocation(0, 0);
		// l.setBorder(new LineBorder(Color.red));
		return l;
	}

	private JButton ceateCancelButton() {
		cancelButton = new JButton("注册");
		cancelButton.setLocation(271, 244);
		cancelButton.setSize(124, 40);
		return cancelButton;
	}

	private JButton ceateLoginButton() {
		loginButton = new JButton("登录");
		loginButton.setLocation(123, 244);
		loginButton.setSize(124, 40);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user = context.login();
			}
		});
		getRootPane().setDefaultButton(loginButton);
		return loginButton;
	}

	private JPasswordField ceatePwdField() {
		pwdFiled = new JPasswordField("123");
		pwdFiled.setLocation(165, 185);
		pwdFiled.setSize(236, 33);
		return pwdFiled;
	}

	private JTextField ceateNameField() {
		nameFiled = new JTextField("tangliang");
		nameFiled.setLocation(165, 138);
		nameFiled.setSize(236, 33);
		return nameFiled;
	}

	/**
	 * 获得姓名文本框内容
	 * 
	 * @return
	 */
	public String getName() {
		return nameFiled.getText();
	}

	/**
	 * 获得密码文本框内容
	 * 
	 * @return
	 */
	public String getPassword() {
		char[] pwd = pwdFiled.getPassword();
		return new String(pwd);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LoginFrame frame = new LoginFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
