package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import system.MyTool;



public class Passenger extends JFrame implements MouseListener,ActionListener,Runnable{
	
	/**
	 * 
	 */
	public static BackTickit bt;//��Ʊ���
	public static Recharge r;//��ֵ���
	public static QueryResult a;//��ѯ���
	public static PersonInfo personInfo;
	public static boolean ifBuy=false;//�Ƿ�Ʊ
	private static final long serialVersionUID = 1L;
	private JLabel timeLabel = new JLabel() ;//��ʾʱ��
	public static CardLayout card = new CardLayout() ;
	private BorderLayout borderlayout = new BorderLayout() ;
	private JSplitPane jsplitpane = null;
	private JPanel leftPanel = null ;
	public static  JPanel mainPanel = null ;
	private JPanel bottomPanel = null ;
	private JLabel[] jLabels = null;//��ǩ��
	public static TickitQuery tickitQueryPanel =null;
	private JMenuBar jmBar = null;
	public static Passenger passenger;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Passenger() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
		setUndecorated(true); //���ش���
		//����ָ���Ĵ���װ�η��
		getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);//�ı䴰������
		//�޸Ĳ˵�Ĭ������ͱ��� 
		UIManager.put("Menu.font", MyTool.getFontB(18)) ;
		UIManager.put("Label.font", MyTool.getFontP(15)) ;
		//UIManager.put("Label.foreground", Color.RED) ;
		//UIManager.put("MenuBar.background", new Color(200,190,255)) ;
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//���ô������
		setLayout(borderlayout);
		//��ʼ���˵�
		jmBar = new JMenuBar() ;
		//�û��˵�
		setJMenuBar(jmBar) ;//��Ӳ˵�
		
		
		//�����
		leftPanel = new JPanel();
		leftPanel.setOpaque(true);
		leftPanel.setBackground(new Color(0x665568));
		leftPanel.setLayout(new GridLayout(7, 1, 10, 10)) ;
		String info[] ={"��ƱԤ��","��ֵ����","������Ʊ","�ҵĶ�Ʊ","��      ��","��      ��"};
		jLabels = new JLabel[6] ;
		for (int i = 0; i < info.length; i++) {
			JLabel jLabel = new JLabel(info[i],JLabel.CENTER);
			jLabels[i] = jLabel ;
			jLabel.setForeground(new Color(0xFFFFFF)) ;//��ɫ
			jLabel.setEnabled(false) ;
			jLabel.addMouseListener(this) ;
			jLabel.setFont(MyTool.getFontB(20)) ;
			leftPanel.add(jLabel) ;                         
		}
		mainPanel = new JPanel(card) ;//�ұ�����Ϊ��Ƭ����
		tickitQueryPanel = new TickitQuery();
		
		
		
		mainPanel.add(tickitQueryPanel,"p1");
		a =new QueryResult();
		mainPanel.add(a,"p2");
		personInfo = new  PersonInfo();
		mainPanel.add(personInfo,"p3");
		JPanel empty = new JPanel();
		empty.setLayout(null);
		JLabel l = new JLabel("����û�ж�Ʊ�˵�Ŷ");
		l.setBounds(250,200,200,20);
		l.setOpaque(true);
		l.setForeground(Color.BLUE);
		empty.add(l);
		mainPanel.add(empty,"p4");
		r=new Recharge();
		mainPanel.add(r,"p7");
		bt=new 	BackTickit();
		mainPanel.add(bt,"p5");
	
		//�Ѷ������뵽��� ���
		jsplitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftPanel,mainPanel) ;//����һ������Ϊˮƽ���򣬿��ػ���� jsplitpanelitPane�������������
		jsplitpane.setDividerLocation(150);//���÷ָ���λ��
		jsplitpane.setDividerSize(5);//�ָ��ߴ�С
		jsplitpane.setEnabled(true) ;//���϶�
		jsplitpane.setOneTouchExpandable(false) ;//�����쵯
		add(jsplitpane);
		
		
		
		JPanel buttomPanel = new JPanel(new BorderLayout()) ;
		buttomPanel.setBackground(new Color(0xEEEEFFF)) ;
		buttomPanel.add(timeLabel,BorderLayout.EAST) ;
		add(buttomPanel,BorderLayout.SOUTH) ;	
		setIconImage(new ImageIcon("pic_login/����.png").getImage()) ;//ͼ�� 
		setSize(MyTool.getScreen().width-500, MyTool.getScreen().height-200) ;
		setTitle("��Ʊ����") ;
		setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		setVisible(true) ;
		setLocationRelativeTo(null) ;
		
		
		 new Thread(this).start() ;//����ʱ���߳�
		
		
		
	
	}
	
	

		
		
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof JLabel){
			//��ʾ �Ǳ�ǩ
			if(((JLabel)e.getSource()).getText().trim().equals("��ƱԤ��")){
				card.show(mainPanel, "p1") ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("��ֵ����")){
				card.show(mainPanel, "p7") ;
			}
			if(e.getSource()==jLabels[4]){
				Help helpDialog = new Help(this) ;
				helpDialog.setTitle("����") ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("������Ʊ")){
				if(Passenger.ifBuy)
				{
					card.show(mainPanel, "p5") ;
				}else {
					card.show(mainPanel, "p4") ;//û�й�Ʊ����ʾ��
				
				}
			}
			if(((JLabel)e.getSource()).getText().trim().equals("�ҵĶ�Ʊ")){
				if(Passenger.ifBuy)
				{
					Passenger.personInfo.removeAll();//���������������
					Passenger.personInfo.currentInfo();//ˢ���˵�
					card.show(mainPanel, "p3") ;
				}else {
					card.show(mainPanel, "p4") ;//û�й�Ʊ����ʾ��
				
				}
				
			}
			if((e.getSource())==jLabels[5]){
				//�˳�ϵͳ
				Object[] options= {"ȷ��","ȡ��","�л��û�"};
				int num=JOptionPane.showOptionDialog(null, "ȷ���˳�?", "ϵͳ��ʾ", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				//int num = JOptionPane.showConfirmDialog(this, "ȷ���˳�?") ;
				if(num==0){
					//�˳�ϵͳ 
					System.exit(0) ;
				}
				if(num==2)
				{
					dispose();
					//�ָ�ԭ״
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
			}
			
		}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//��label��Ϊ�ɼ�
		for (int i = 0; i < jLabels.length; i++) {
			if(e.getSource()==jLabels[i]){
				//��ʾ ���������һ��
				jLabels[i].setEnabled(true) ;//�ɱ༭
				jLabels[i].setCursor(new Cursor(Cursor.HAND_CURSOR)) ;//���ָ���Ϊ��
				return ;
			}
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

		for (int i = 0; i < jLabels.length; i++) {
			if(e.getSource()==jLabels[i]){
				//��ʾ ���������һ��
				jLabels[i].setEnabled(false) ;
				return ;
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		while(true) {//����ѭ��
			timeLabel.setText(MyTool.getCurrentTime()) ;		
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

