package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

import otcyan.java.bean.User;
import otcyan.java.model.CheckInfo;
import otcyan.java.model.DataHandle;
import otcyan.java.tools.ImagePanel;
import otcyan.java.tools.Tookit;

public class Userinformodification extends JDialog implements MouseListener{
	private ImagePanel ip;
	JLabel userId;
	JLabel userPasswd1;
	JLabel userPasswd ;
	JLabel userName;
	JLabel userSex;
	JRadioButton boy;
	JRadioButton girl;
	JLabel tel;
	JLabel addr;
	JLabel email;
	JLabel identity;
	private User user ;
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	public Userinformodification(JFrame jFrame,User user){
		this.user= user ;
		this.init();
	}
	public void init(){	
		
		this.setSize(600, 700) ;
		this.setModal(true);
		this.setLocationRelativeTo(null) ;
		this.setResizable(false) ;
		this.setTitle("�û���Ϣ�޸�") ;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
		ImagePanel jPanel = null;
		try {
			jPanel = new ImagePanel(ImageIO.read(new File("image/171go.jpg")), dimension);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel jpAll=new JPanel();
		jpAll.setLayout(new BorderLayout());
		jpAll.setOpaque(false) ;
		JPanel jopJPanel=new JPanel();
		JLabel jluser=new JLabel("�û���Ϣ�޸�");
//		jluser.setForeground(new Color(0xC4C43B));
		jluser.setFont(Tookit.getFont2());
		jopJPanel.add(jluser);
		jpAll.add(jopJPanel,BorderLayout.NORTH);
		jPanel.add(jpAll);
		jopJPanel.setOpaque(false);
		
		JPanel infoPanel = new JPanel(new GridLayout(9, 2,2,20)) ;
		infoPanel.setOpaque(false) ;
		infoPanel.setPreferredSize(new Dimension(450, 500)) ;
		userId = new JLabel("�û�����",JLabel.CENTER);
		
		userId.setFont(Tookit.getFont1()) ;
		infoPanel.add(userId) ;
		final JTextField userIdField = new JTextField(user.getU_id()) ;
		userIdField .setEnabled(false) ;
		infoPanel.add(userIdField) ;
		userPasswd = new JLabel("���룺",JLabel.CENTER);
		userPasswd.setFont(Tookit.getFont1()) ;
		infoPanel.add(userPasswd) ;
		final JPasswordField userPasswdField = new JPasswordField(user.getU_password()) ;
		infoPanel.add(userPasswdField) ;
		userName = new JLabel("������",JLabel.CENTER);
		userName.setFont(Tookit.getFont1()) ;
		infoPanel.add(userName) ;
		final JTextField userNameField = new JTextField(user.getU_name()) ;
		infoPanel.add(userNameField) ;
		userSex = new JLabel("�Ա�",JLabel.CENTER) ;
		userSex.setFont(Tookit.getFont1()) ;
		JPanel jSex = new JPanel() ;
		jSex.setOpaque(false) ;
		boy = new JRadioButton("��") ;
		boy.setOpaque(false) ;
		boy.setFont(Tookit.getFont1()) ;
		girl = new JRadioButton("Ů") ;
		girl.setOpaque(false) ;
		girl.setFont(Tookit.getFont1()) ;
		ButtonGroup gbGroup = new ButtonGroup();
		gbGroup.add(boy) ;
		gbGroup.add(girl) ;
		jSex.add(boy) ;
		jSex.add(girl) ;
		if(user.getU_sex().equals("��")){
			boy.setSelected(true) ;
		}
		if (user.getU_sex().equals("Ů")) {
			girl.setSelected(true);
		}
		infoPanel.add(userSex);
		infoPanel.add(jSex) ;
		tel = new JLabel("�绰����:",JLabel.CENTER);
		tel.setFont(Tookit.getFont1()) ;
		infoPanel.add(tel) ;
		final JTextField telField = new JTextField(user.getU_telephone()) ;
		infoPanel.add(telField) ;
		addr = new JLabel("��ַ��",JLabel.CENTER);
		addr.setFont(Tookit.getFont1()) ;
		infoPanel.add(addr) ;
		final JTextField addrField = new JTextField(user.getU_address()) ;
		infoPanel.add(addrField) ;
		email = new JLabel("�����ʼ���",JLabel.CENTER);
		email.setFont(Tookit.getFont1()) ;
		infoPanel.add(email) ;
		final JTextField emailField = new JTextField(user.getU_email()) ;
		infoPanel.add(emailField) ;
		identity = new JLabel("���֤�ţ�",JLabel.CENTER);
		identity.setFont(Tookit.getFont1()) ;
		infoPanel.add(identity) ;
		final JTextField identityField = new JTextField(user.getU_idcard()) ;
		infoPanel.add(identityField) ;
		jpAll.add(infoPanel,BorderLayout.CENTER);
		
		JPanel jButtom =new JPanel();
		JButton affirm = new JButton("ȷ��") ;
		affirm.setFont(Tookit.getFont1()) ;
		jButtom.add(affirm);
		JButton cancel = new JButton("ȡ��") ;
		cancel.setFont(Tookit.getFont1()) ;
		jButtom.add(cancel);
		jpAll.add(jButtom,BorderLayout.SOUTH);
		jButtom.setOpaque(false);
//		jPanel.add(Box.createRigidArea(new Dimension(dimension.width, 50))) ;
		jPanel.add(jpAll) ;
		this.add(jPanel) ;	
		affirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				if(uId.isEmpty()||uPassword.isEmpty()||uName.isEmpty()||uSex.isEmpty()||uTelephone.isEmpty()||uAddress.isEmpty()||uEmail.isEmpty()||uIdcard.isEmpty()){
					JOptionPane.showMessageDialog(null, "�������Ϊ�գ�");
					return;
				}
				//����һ��User
				User user = new User(uId, uPassword, uName, uSex, uTelephone, uAddress, uEmail, uIdcard, "0");
				CheckInfo checkInfo =new CheckInfo() ;
				boolean b = checkInfo.check(user) ;
				System.out.println(b);
				if(b==true){
					//��ʾ ���� ��ʽ �� ��ȷ��  ��ʱ�������ݿ����
					String sql="update users set u_password=?,u_name=?,u_sex=?,u_telephone=?,u_address=?,u_email=?,u_idcard=?  where u_id=?";
					String[] ss={ uPassword, uName, uSex, uTelephone, uAddress, uEmail, uIdcard,uId};
					
					DataHandle dataHandle=new DataHandle();
					boolean iss=dataHandle.update(sql, ss);
					if(iss){
						JOptionPane.showMessageDialog(null, "�޸ĳɹ��������µ�¼");
						Userinformodification.this.dispose() ;
						new LoginView().setVisible(true) ;
					}else{
						JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
						return;
					}					
				}
				
			}
		});
		cancel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Userinformodification.this.dispose() ;
//				userIdField.setText("") ;
//				userNameField.setText("") ;
//				userPasswdField.setText("") ;
//				telField.setText("") ;
//				addrField.setText("") ;
//				emailField.setText("") ;
//				identityField.setText("") ;
			}
		});
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
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