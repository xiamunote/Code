package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.synth.Region;

import otcyan.java.bean.User;
import otcyan.java.dao.DbHandle;
import otcyan.java.model.CheckInfo;
import otcyan.java.model.DataHandle;
import otcyan.java.model.FileOperation;
import otcyan.java.tools.MyLoginPanel;
import otcyan.java.tools.Tookit;

public class LoginView extends JFrame implements MouseListener{
	
	private JTextField userNameField = null;
	private JPasswordField userPasswdField = null ;
    private  JPanel jp ;
    private FileOperation fileOperation  ;
    private Vector<String> loginNames ;
   // private JScrollPane autoTipPane ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LoginView().setVisible(true);
	}
	
	public LoginView(){
		UIManager.put("TextField.font", Tookit.getFont1()) ;
		UIManager.put("Label.font", Tookit.getFont1()) ;
		UIManager.put("Button.font", Tookit.getFont1()) ;
		fileOperation = new FileOperation();
		//���ļ��м����û�������
		loginNames = fileOperation.loading("path/loginName") ;
		this.init();
	}

	private void init() {
		//���� ��panel
		JPanel top = new JPanel() ;
		JLabel jTop = new JLabel(new ImageIcon("image/logo.gif")) ;
		top.add(jTop) ;
		this.add(top,BorderLayout.NORTH) ;
		//�����panel
		JPanel buttom = new JPanel(new BorderLayout()) ;
		//���
		buttom.add(this.leftPanel()) ;
		//�ұ�
		buttom.add(this.rightPanel(),BorderLayout.EAST);
		 
		this.add(buttom) ;
		this.setSize(823, 500) ;
		this.setLocationRelativeTo(null) ;
		this.setResizable(false) ;
		this.setIconImage(new ImageIcon("image/1.png").getImage()) ;
		this.setTitle("�ɻ���Ʊϵͳ") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	}
	/**
	 * ������ߵ�¼���
	 * @return
	 */
	public JPanel leftPanel(){
		JPanel jPanel = new JPanel(new BorderLayout()) ;
		//����
		JLabel jLogin = new JLabel(new ImageIcon("image/enter_font1.jpg"),JLabel.CENTER) ;
		jPanel.add(jLogin,BorderLayout.NORTH) ;//��һ��jlable
		//�м�
		MyLoginPanel myPanel = new MyLoginPanel() ;
		myPanel.setLayout(null) ;
	
		final JLabel userName = new JLabel("��¼����",JLabel.CENTER) ;
		userName.setBounds(135, 70, 65, 15) ;
		userName.setFont(Tookit.getFont1()) ;
		myPanel.add(userName) ;
		//��һ�����   ���� ������jlabel
		jp = new JPanel() ;
		jp.setOpaque(false) ;
		//jp.setPreferredSize(new Dimension(140, 200)) ;
		//autoTipPane = new JScrollPane(jp) ;
		jp.setBounds(200, 89, 140, 200) ;
		//autoTipPane.setOpaque(false) ;
		//autoTipPane.getViewport().setOpaque(false) ;
		myPanel.add(jp) ;
		userNameField = new JTextField(12) ;
		userNameField.setBounds(200, 68, 140, 21) ;
		
		userNameField.getDocument().addDocumentListener(new DocumentListener() {
			
			//����һ������ jlabel�ļ���
			//Vector<JLabel> jLabels = new Vector<JLabel>() ;
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				//ÿɾ��һ�� ��ĸ
				LoginView.this.autoTip() ;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				LoginView.this.autoTip() ;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
					
			}
		}) ;
		
		myPanel.add(userNameField) ;
		if(userNameField.getText().trim().equals("")){
			
		}
//		center.add(userName) ;
//		center.add(userNameField) ;
		JLabel userPasswd = new JLabel("��    �룺",JLabel.CENTER) ;
		userPasswd.setFont(Tookit.getFont1()) ;
		userPasswd.setBounds(135, 124, 65, 15) ;
		userPasswdField = new JPasswordField(12) ;
		userPasswdField.setBounds(200, 124, 140, 21) ;
		myPanel.add(userPasswd) ;
		myPanel.add(userPasswdField) ;
		
		JLabel userGrade = new JLabel("��    �ݣ�",JLabel.CENTER) ;
		userGrade.setFont(Tookit.getFont1()) ;
		userGrade.setBounds(135, 166, 65, 15) ;
		final JComboBox jcb = new JComboBox(new String[]{"�ÿ�","����Ա"}) ;
		jcb.setBounds(200, 163, 71, 27) ;
		myPanel.add(userGrade) ;
		jcb.setFont(Tookit.getFont1()) ;
		myPanel.add(jcb) ;

		JButton login = new JButton("��¼");
		login.setBounds(151, 215, 81, 30) ;
		myPanel.add(login) ;
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//ȡ���û����������Լ���ɫ
				if(userName.getText().trim().equals("") ||String.valueOf(userPasswdField.getPassword()).trim().equals("")){
					JOptionPane.showMessageDialog(LoginView.this, "�û��������벻��Ϊ�գ���") ;
					return ;
				}
				//�������ݵ����ݿ���֤  ���ݿ⴦��   
				DataHandle loginHandle = new DataHandle() ;
				//Ȩ��
				String power = ((String)jcb.getSelectedItem()).equals("�ÿ�")?"0":"1" ;
				//�û���
				String userId = userNameField.getText().trim() ;
				//����
				String userPasswd = String.valueOf(userPasswdField.getPassword()) ;
				User user = loginHandle.getUser(
						"select * from users where u_id=?",
						new String[] { userId });
				if(user!=null && user.getU_password().equals(userPasswd) && user.getU_power().equals(power)){
					//��ʾ��֤�ɹ�
					//�õ��û�����
					String userName = user.getU_name() ;
					String userSex = user.getU_sex() ;
					String userCall = userSex.equals("��")?"����":"Ůʿ" ;
					if(power.equals("0")){
						//��ʾ�ÿ�
						JOptionPane.showMessageDialog(LoginView.this, "��ӭ�ÿ�"+userName+userCall+"��¼") ;
						new GuestMainView(user).setVisible(true) ;
					}else {
						JOptionPane.showMessageDialog(LoginView.this, "��ӭ����Ա"+userName+userCall+"��¼") ;
						new MangerMainView(user).setVisible(true) ;
					}
					//��¼�ɹ�  ���û������뵽������  
					if(!loginNames.contains(userId)){
						//��ʾ�ļ����Id������
						loginNames.add(userId) ;
					}
					//���е��ļ�
					boolean b = fileOperation.save("path/loginName", loginNames) ;
					if(!b){
						JOptionPane.showMessageDialog(LoginView.this, "���л��ļ�ʧ��");
						return ;
					}
					LoginView.this.dispose() ;
					
				}else{
					//��֤���ɹ�
					JOptionPane.showMessageDialog(LoginView.this, "�û�������������ݲ�ƥ�䣡��") ;
					userPasswdField.setText("") ;
				}
				
			}
		}) ;
		login.setPreferredSize(new Dimension(80, 30)) ;
		login.setBackground(new Color(0x71B8EC)) ;
		JButton exit = new JButton("�˳�");
		exit.setBounds(265, 215, 81, 30) ;
		myPanel.add(exit) ;
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�����������һ��������  ����
				System.exit(0) ;
			}
		}) ;
		exit.setPreferredSize(new Dimension(80, 30)) ;
		exit.setBackground(new Color(46,116,188)) ;
		jPanel.add(myPanel) ;
		return jPanel ;
	}
/**
 * ���ұ�����Ϊ��Ƭ����
 * @return
 */
	public JPanel rightPanel(){
		
		final CardLayout card = new CardLayout() ;
		final JPanel right = new JPanel(card) ;
		right.setBorder(new TitledBorder(new EtchedBorder(), "���û�ע��")) ;
		right.setPreferredSize(new Dimension(269, 363)) ;
		//right.setBackground(new Color(0xFFFFCC)) ;
		
		Box box = Box.createVerticalBox() ;
		box.add(Box.createHorizontalStrut(32)) ;
		
		JLabel jLabel = new JLabel() ;
		jLabel.setText("<html>" +"<h2>���û�ע��</h2><hr>"+
				"1�����ע��<br> 2��ʵ��ע�� <br>3��ע���û������ܸ��Ի�����<br><br> " +
				"</html>") ;
		box.add(jLabel) ;
		
		JButton regist = new JButton("ע��") ;
		regist.setPreferredSize(new Dimension(100, 30)) ;
		regist.setBackground(new Color(0xFFFFCC)) ;
		box.add(regist) ;
		JPanel jpOne = new JPanel() ;
		jpOne.setOpaque(false) ;
		jpOne.add(box) ;
		right.add(jpOne,"one") ;
		//�ڶ���panel
		JPanel jpTwo = new JPanel() ;
		jpTwo.setOpaque(false) ;
		jpTwo.setLayout(new BorderLayout()) ;
		String info ="<html>1�����������ȷ��<br>�������������ҳ���µġ���ͬ�⡱��ť��<br>����Ϊ�����Ķ����˽Ⲣ��ȫͬ���������<br>�еĸ������ݣ���������վ�Է���������<br>�����κ��޸ġ���������ȷ�����⣬����վ<br>�κη���Χ���ܵı仯���ܷ�������Լ����<br>2������������޸�<br>����վ�ڱ�Ҫʱ���޸ķ������������վ<br>���й��棬һ�����棬������Ч����������<br>ʹ�÷�������Ϊ���ѽ����޶��ķ������<br>3���û�ע��<br>���ǵ�����վ�û��������Ҫ�ԣ���ͬ����<br>ע��ʱ�ṩ��ʵ��������׼ȷ�ĸ������ϣ�<br>����ʱ���¡� �����ṩ�����ϲ�׼ȷ����<br>����վ�к����������Ϊ�����ϲ���ʵ����<br>��������׼ȷ������վ��Ȩ��ͣ����ֹ����<br>ע����ݼ����ϣ����ܾ���<br>ʹ�ñ���վ�ķ���4���û����ϼ�����<br>ע��ʱ������ѡ����д�û��������룬<br>����ҳ����ʾ�ύ�����Ϣ�������ж��û�<br>�������뱣�ܵ����񣬲��Ը��û�������<br>���·��������л�е����Ρ���ͬ���ʼ�<br>�����ʹ�������Լ��е����ա�����վ��<br>��������ʹ�÷������漰��ط�֮�������<br>��������͸¶���ĸ������ϣ����ɷ���涨���⡣ <html>" ;
		JLabel jLabel2 = new JLabel(info) ;
		jLabel2.setFont(Tookit.getFont1()) ;
		jpTwo.add(jLabel2) ;
		JPanel jpButton = new JPanel() ;
		jpButton.setOpaque(false) ;
		JButton accept = new JButton("ͬ��") ;
		accept.setPreferredSize(new Dimension(100, 30)) ;
		accept.setBackground(new Color(0xFFFFCC)) ;
		jpButton.add(accept) ;
		JButton unaccept = new JButton("��ͬ��") ;
		unaccept.setPreferredSize(new Dimension(100, 30)) ;
		unaccept.setBackground(new Color(0xFFFFCC)) ;
		jpButton.add(unaccept) ;
		jpTwo.add(jpButton,BorderLayout.SOUTH);
		right.add(new JScrollPane(jpTwo),"two") ;
		//������panel
		JPanel jpThree = new JPanel(new BorderLayout()) ;
		//jpThree.setOpaque(false) ;
		//jpThree.setPreferredSize(new Dimension(269,300)) ;
		JPanel infoPanel = new JPanel(new GridLayout(9, 2)) ;
		JLabel userId = new JLabel("�û�����",JLabel.CENTER);
		userId.setFont(Tookit.getFont1()) ;
		infoPanel.add(userId) ;
		final JTextField userIdField = new JTextField() ;
		infoPanel.add(userIdField) ;
		JLabel userPasswd = new JLabel("���룺",JLabel.CENTER);
		userPasswd.setFont(Tookit.getFont1()) ;
		infoPanel.add(userPasswd) ;
		final JPasswordField userPasswdField = new JPasswordField() ;
		infoPanel.add(userPasswdField) ;
		JLabel userPasswd1 = new JLabel("ȷ�����룺",JLabel.CENTER);
		userPasswd1.setFont(Tookit.getFont1()) ;
		infoPanel.add(userPasswd1) ;
		final JPasswordField userPasswd1Field = new JPasswordField() ;
		infoPanel.add(userPasswd1Field) ;
		JLabel userName = new JLabel("��   ����",JLabel.CENTER);
		userName.setFont(Tookit.getFont1()) ;
		infoPanel.add(userName) ;
		final JTextField userNameField = new JTextField() ;
		infoPanel.add(userNameField) ;
		//�û��Ա�
		JLabel userSex = new JLabel("�Ա�",JLabel.CENTER) ;
		userSex.setFont(Tookit.getFont1()) ;
		JPanel jSex = new JPanel() ;
		jSex.setOpaque(false) ;
		final JRadioButton boy = new JRadioButton("��") ;
		boy.setOpaque(false) ;
		boy.setFont(Tookit.getFont1()) ;
		final JRadioButton girl = new JRadioButton("Ů") ;
		girl.setOpaque(false) ;
		girl.setFont(Tookit.getFont1()) ;
		ButtonGroup gbGroup = new ButtonGroup();
		gbGroup.add(boy) ;
		gbGroup.add(girl) ;
		jSex.add(boy) ;
		jSex.add(girl) ;
		infoPanel.add(userSex);
		infoPanel.add(jSex) ;
		JLabel tel = new JLabel("�绰����:",JLabel.CENTER);
		tel.setFont(Tookit.getFont1()) ;
		infoPanel.add(tel) ;
		final JTextField telField = new JTextField() ;
		infoPanel.add(telField) ;
		JLabel addr = new JLabel("��ַ��",JLabel.CENTER);
		addr.setFont(Tookit.getFont1()) ;
		infoPanel.add(addr) ;
		final JTextField addrField = new JTextField() ;
		infoPanel.add(addrField) ;
		JLabel email = new JLabel("�����ʼ���",JLabel.CENTER);
		email.setFont(Tookit.getFont1()) ;
		infoPanel.add(email) ;
		final JTextField emailField = new JTextField() ;
		infoPanel.add(emailField) ;
		JLabel identity = new JLabel("���֤�ţ�",JLabel.CENTER);
		identity.setFont(Tookit.getFont1()) ;
		infoPanel.add(identity) ;
		final JTextField identityField = new JTextField() ;
		infoPanel.add(identityField) ;
		jpThree.add(infoPanel) ;

		JPanel subMitPanel = new JPanel() ;
		JButton submit = new JButton("�ύע����Ϣ") ;
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�õ����е�����   9������
				String uId=userIdField.getText().trim();
				String uPassword=String.valueOf(userPasswdField.getPassword());
				String uName = userNameField.getText().trim();
				String uSex  = null;
				if(boy.isSelected()){
					uSex=boy.getText().trim();
				}
				if(girl.isSelected()){
					uSex=girl.getText().trim();
				}
				String uTelephone=telField.getText().trim();
				String uAddress  =addrField.getText().trim();
				String uEmail   = emailField.getText().trim();
				String uIdcard = identityField.getText().trim();
				
				//�ж����е��Ƿ�Ϊ��
				if(uId.isEmpty()||uPassword.isEmpty()||userPasswd1Field.getPassword().toString().equals("")||uName.isEmpty()||uSex.isEmpty()||uTelephone.isEmpty()||uAddress.isEmpty()||uEmail.isEmpty()||uIdcard.isEmpty()){
					JOptionPane.showMessageDialog(null, "�������Ϊ�գ�");
					return;
				}
				System.out.println(String.valueOf(userPasswd1Field.getPassword())+"-------"+uPassword);
				//�����ж�   ���������� ����һ��
				if(String.valueOf(userPasswd1Field.getPassword()).equals(uPassword)==false){
					JOptionPane.showMessageDialog(null, "�������벻һ�£�");
					return;
				}
				//����һ��User
				User user = new User(uId, uPassword, uName, uSex, uTelephone, uAddress, uEmail, uIdcard, "0");
				CheckInfo checkInfo =new CheckInfo() ;
				boolean b = checkInfo.checkRegistInfo(user) ;
				System.out.println(b);
				if(b==true){
					//��ʾ ���� ��ʽ �� ��ȷ��  ��ʱ�������ݿ����
					String sql="insert into users values(?,?,?,?,?,?,?,?,?)";
					String[] ss={uId, uPassword, uName, uSex, uTelephone, uAddress, uEmail, uIdcard, 0+""};
					
					DataHandle dataHandle=new DataHandle();
					boolean iss=dataHandle.update(sql, ss);
					if(iss){
						 JOptionPane.showConfirmDialog(null, "ע��ɹ����Ƿ����?");
						card.show(right, "one") ;
					}else{
						JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�");
						return;
					}
				}	
//				}else{
//					JOptionPane.showMessageDialog(null, "��ʽ����ȷ");
//				}
			}
		}) ;
		submit.setFont(Tookit.getFont1()) ;
		//submit.setPreferredSize(new Dimension(100, 30)) ;
		submit.setBackground(new Color(0xFFFFCC)) ;
		subMitPanel.add(submit) ;
		JButton reset = new JButton("����") ;
		reset.setFont(Tookit.getFont1()) ;
		reset.setPreferredSize(new Dimension(100, 30)) ;
		reset.setBackground(new Color(0xFFFFCC)) ;
		subMitPanel.add(reset) ;
		jpThree.add(subMitPanel,BorderLayout.SOUTH) ;
		right.add(jpThree,"three") ;
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userIdField.setText("") ;
				userNameField.setText("") ;
				userPasswdField.setText("") ;
				userPasswd1Field.setText("") ;
				telField.setText("") ;
				addrField.setText("") ;
				emailField.setText("") ;
				identityField.setText("") ;
			}
		}) ;
		regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�����ע�� 
				card.show(right, "two") ;
			}
		}) ;
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(right, "three") ;
			}
		}) ;
		unaccept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(right, "one") ;
			}
		}) ;
		return right ;
	}
	
	public void autoTip(){
		System.out.println("===");
		//���������� �� ���
		jp.removeAll() ;
		//jLabels.removeAllElements() ;
		//�õ� �ı��� ����
		String str = userNameField.getText().trim() ;
		
		for(String loginName :loginNames){
			if(loginName.startsWith(str) && !str.equals("")){
				//����һ��jlabel
				JLabel jLabel = new JLabel(loginName) ;
				jLabel.addMouseListener(LoginView.this) ;
				jLabel.setPreferredSize(new Dimension(140, 20));
				//jLabels.add(jLabel) ;
				jp.add(jLabel) ;	
			}
		}
		jp.repaint() ;
		//autoTipPane.repaint() ;
		jp.validate() ;//ˢ�½���
	//	autoTipPane.validate() ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		userNameField.setText(((JLabel)e.getSource()).getText()) ;
		//�����������	
		jp.removeAll() ;
		this.remove(jp) ;
		this.repaint() ;
		this.validate() ;

		//�������Ŀ��
		//jp.setBackground(Color.red) ;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel jLabel = (JLabel)e.getSource() ;
		jLabel.setForeground(Tookit.getColor()) ;
		jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jLabel = (JLabel)e.getSource() ;
		jLabel.setForeground(Color.black) ;
		jLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)) ;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
