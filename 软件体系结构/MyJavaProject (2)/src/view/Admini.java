package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import system.SqlOperation;

public class Admini extends JFrame{
	JButton btn1 =new JButton("���");
	JButton btn2 =new JButton("�˳�");
	JButton btn3 =new JButton("�޸�");
	JButton btn4 =new JButton("ɾ��");
	
	JLabel l1=new JLabel("�����"),l2=new JLabel("����ʱ��"),l3=new JLabel("Ԥ�Ƶ���"),
			l4=new JLabel("����"),l5=new JLabel("������"),l6=new JLabel("�յ����"),
			l7=new JLabel("���չ�˾"),l8=new JLabel("���òռ۸�"),l9=new JLabel("ͷ�Ȳռ۸�"),
			l10=new JLabel("���ò�����"),l11=new JLabel("ͷ�Ȳ�����"),l12=new JLabel("׼����"),
			l13=new JLabel("ʼ������"),l14=new JLabel("�������"),
			e1=new JLabel(" "),
			e2=new JLabel(" "),
			e3=new JLabel(" "),
			e4=new JLabel(" "),
			e5=new JLabel("  "),
			e6=new JLabel(" "),
			e7=new JLabel(" "),
			e8=new JLabel(" "),
			e9=new JLabel(" "),
			e10=new JLabel(" "),
			e11=new JLabel(" "),
			e12=new JLabel(" "),
			e13=new JLabel(" "),
			e14=new JLabel(" "),
			e15=new JLabel(" "),
			e16=new JLabel(" "),
			e17=new JLabel(" "),
			e18=new JLabel("  "),
			e19=new JLabel(" "),
			e20=new JLabel(" "),
			e21=new JLabel(" "),
			e22=new JLabel(" "),
			e23=new JLabel(" "),
			e24=new JLabel(" "),
			e25=new JLabel(" "),
			e26=new JLabel(""),
			e27=new JLabel(" "),
			e28=new JLabel(" "),
			e29=new JLabel("   "),
			e30=new JLabel(" "),
			a1=new JLabel(" "),
			a2=new JLabel(" "),
			a3=new JLabel(" "),
			a4=new JLabel(" "),
			a5=new JLabel(" "),
			a6=new JLabel(" "),
			a7=new JLabel(" "),
			a8=new JLabel(" "),
			a9=new JLabel(" "),
			a10=new JLabel(" "),
			a11=new JLabel(" "),
			a12=new JLabel(" "),
			a13=new JLabel(" "),
			a14=new JLabel(" "),
			a15=new JLabel(" "),
			a16=new JLabel(" "),
			a17=new JLabel(" "),
			a18=new JLabel(" "),
			a19=new JLabel(" "),
			a20=new JLabel(" "),
			a21=new JLabel(" "),
			a22=new JLabel(" "),
			a23=new JLabel(" "),
			a24=new JLabel(" "),
			a25=new JLabel(" "),
			a26=new JLabel("  "),
			a27=new JLabel(" "),
			a28=new JLabel(" "),
			a29=new JLabel(" "),
			a30=new JLabel(" "),
			a31=new JLabel(" "),
			a32=new JLabel(" "),
			a33=new JLabel(" "),
			a34=new JLabel(" "),
			a35=new JLabel(" "),
			a36=new JLabel(" ");
				
	JTextField t1=new JTextField(),t2=new JTextField(),t3=new JTextField(),
			t4=new JTextField(),t5=new JTextField(),t6=new JTextField(),t7=new JTextField(),
			t8=new JTextField(),t9=new JTextField(),t10=new JTextField(),t11=new JTextField(),
			t12=new JTextField(),t13=new JTextField(),t14=new JTextField();
	@SuppressWarnings("static-access")
	public Admini() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		super("����Ա");
		setUndecorated(true); //���ش���
		//����ָ���Ĵ���װ�η��
		getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);//�ı䴰������
		Toolkit tool=this.getToolkit(); //�õ�һ��Toolkit����
		Image myimage=tool.getImage("pic_login//ע��ͼ��.png"); //��tool��ȡͼ��
		setIconImage(myimage);//���ô���ͼ��
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//���ô������
		setLayout(new GridLayout(16,6));
		setBounds(0,0,600,500);
		this.setLocationRelativeTo(null);
		setVisible(true);
		add(a1);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(a2);
		
		add(a3);
		add(e1);
		add(e2);
		add(e3);
		add(e4);
		add(a4);
		
		add(a5);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(a6);
		
		add(a7);
		add(e5);
		add(e6);
		add(e7);
		add(e8);
		add(a8);
		
		add(a9);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(a10);
		
		add(a11);
		add(e9);
		add(e10);
		add(e11);
		add(e12);
		add(a12);
		
		add(a13);
		add(l7);
		add(t7);
		add(l8);
		add(t8);
		add(a14);
		
		add(a15);
		add(e13);
		add(e14);
		add(e15);
		add(e16);
		add(a16);
		
		add(a17);
		add(l9);
		add(t9);
		add(l10);
		add(t10);
		add(a18);
		
		add(a19);
		add(e17);
		add(e18);
		add(e19);
		add(e20);
		add(a20);
		
		add(a21);
		add(l11);
		add(t11);
		add(l12);
		add(t12);
		add(a22);
		
		add(a23);
		add(e21);
		add(e22);
		add(e23);
		add(e24);
		add(a24);
		
		add(a25);
		add(l13);
		add(t13);
		add(l14);
		add(t14);
		add(a26);
		
		add(a27);
		add(e25);
		add(e26);
		add(e27);
		add(e28);
		add(a28);
		
		add(btn1);
		
		add(a29);
		add(btn3);
		add(btn4);
		add(e30);
		add(btn2);
		
		
		add(a31);
		add(a32);
		add(a33);
		add(a34);
		add(a35);
		add(a36);
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();	//�ָ�ԭ״
				Login.login.button_Login.setEnabled(true);
				Login.login.button_Login.setText("��¼");
				Login.login.button_Login.setBounds(195,220,120,35);
				Login.login.label_containHead.setBounds(30,120,100,100);
				Login.login.label.setVisible(false);
				Login.login.panel_usernameError.setVisible(true);
				Login.login.panel_pwdError.setVisible(true);
				Login.login.panel_pwdstate.setVisible(true);
				Login.login.show();
			
				
			}
		});
		btn3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||
						t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals("")||t9.getText().equals("")||t10.getText().equals("")||
						t11.getText().equals("")||t12.getText().equals("")||t13.getText().equals("")||t14.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "�뽫��Ϣ��д����");
				}
				else {
					if(SqlOperation.flight_check(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),
							t6.getText(), t7.getText(),t8.getText(),t9.getText(),Integer.parseInt(t10.getText()),Integer.parseInt(t11.getText()),
							t12.getText(),t13.getText(),t14.getText())){
						JOptionPane.showMessageDialog(null, "�����Ѵ���");
						return;
					}if(!SqlOperation.searchFlight(t1.getText()))
					{
						JOptionPane.showMessageDialog(null, "���಻����");
						return;
					}
					boolean result=SqlOperation.updateFlight(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),
							t6.getText(), t7.getText(),t8.getText(),t9.getText(),Integer.parseInt(t10.getText()),Integer.parseInt(t11.getText()),
							t12.getText(),t13.getText(),t14.getText())	;	
					if(result)
					{
						JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
					}else {
						JOptionPane.showMessageDialog(null, "���ݿ��쳣���޷��޸�");
					}
					
				}
			}
		});
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||
						t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals("")||t9.getText().equals("")||t10.getText().equals("")||
						t11.getText().equals("")||t12.getText().equals("")||t13.getText().equals("")||t14.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "�뽫��Ϣ��д����");
				}
				else {
					if(SqlOperation.searchFlight(t1.getText())){
						JOptionPane.showMessageDialog(null, "�����Ѵ���");
						return;
					}
					boolean result=SqlOperation.addFlight(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),
							t6.getText(), t7.getText(),t8.getText(),t9.getText(),Integer.parseInt(t10.getText()),Integer.parseInt(t11.getText()),
							t12.getText(),t13.getText(),t14.getText())	;	
					if(result)
					{
						JOptionPane.showMessageDialog(null, "������ӳɹ�");
					}else {
						JOptionPane.showMessageDialog(null, "���ݿ��쳣���޷����");
					}
					
				}
			}
		});
		btn4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String n = JOptionPane.showInputDialog(null, "�����뺽���");
				if(SqlOperation.searchFlight(n))
				{
					if(SqlOperation.delFlight(n))
					{
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}else {
						JOptionPane.showMessageDialog(null, "���ݿ��쳣");
					}
				}else {
					JOptionPane.showMessageDialog(null, "���಻����");
				}
				
		}});
		
	}
}
