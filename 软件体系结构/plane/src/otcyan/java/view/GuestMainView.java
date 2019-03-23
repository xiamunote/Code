package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.tools.Tool;

import otcyan.java.bean.User;
import otcyan.java.tools.ImagePanel;
import otcyan.java.tools.Tookit;

public class GuestMainView extends JFrame implements Runnable,MouseListener,ActionListener{
	
	private JMenuBar jmBar = null ;
	private JLabel timeLabel = null ;
	private CardLayout card = null ;
	private JSplitPane jsp = null;
	private JPanel rightPanel = null ;
	private JLabel[] jLabels = null;
	private User user = null ;
//	public static void main(String[] args) {
//		GuestMainView mainView = new GuestMainView();
//		mainView.setVisible(true) ;
//		//mainView.run() ;
//	}
	public GuestMainView(User user){
		this.user = user ;
		this.init() ;
		
	}
	
	public void initTi(){
		 try {  
            // �жϵ�ǰƽ̨�Ƿ�֧��ϵͳ����  
            if (SystemTray.isSupported()) {  
                    // ���ϵͳ����  
                    SystemTray st = SystemTray.getSystemTray();  

                    // �½�һ��ϵͳ���̰�ť���ƶ�ͼƬ  
                    Image image = Toolkit.getDefaultToolkit().getImage("image/1.png") ;// ��������ͼ���ͼƬ  
                    TrayIcon ti = new TrayIcon(image);  

                    // ��������½������̰�ť  
                    ti.setToolTip("��ϵͳ");  
                    ti.addMouseListener(new MouseAdapter() {  
                            public void mouseClicked(MouseEvent e) {  
                                    if (e.getButton() == MouseEvent.BUTTON1)// �������������򿪴���  
                                    	GuestMainView.this.setVisible(true);  
                                    GuestMainView.this.setExtendedState(JFrame.NORMAL);  
                            }  
                    });  
                    PopupMenu p = new PopupMenu("OK");  

                    MenuItem m1 = new MenuItem("��");  
                    m1.addActionListener(new ActionListener() {  
                            public void actionPerformed(ActionEvent e) {  
                                   GuestMainView.this.setVisible(true);  
                                   GuestMainView.this.setExtendedState(JFrame.NORMAL);   
                            }  
                    });  
                    p.add(m1);  
                    p.addSeparator();  
                    MenuItem m = new MenuItem("�˳�");  
                    m.addActionListener(new ActionListener() {  
                            public void actionPerformed(ActionEvent e) {  
                                    System.exit(0);  
                            }  
                    });  
                    p.add(m);  
                    ti.setPopupMenu(p); // Ϊ��������Ҽ��˵�  

                    // ������õ����̰�ť�󶨵�ϵͳͼ����  
                    st.add(ti);  
            }  
    } catch (Exception e) {  
            e.printStackTrace();  
    }  
	}
	public void init(){
		//�޸�Ĭ������ 
		UIManager.put("Menu.font", Tookit.getFont1()) ;
		UIManager.put("MenuItem.font", Tookit.getFont1()) ;
		UIManager.put("MenuBar.background", new Color(0x498DF8)) ;
		//�Ӳ˵���
		this.setJMenuBar(this.initMenu()) ;
		//�м����
		this.add(this.initCenterPanel()) ;
		this.setIconImage(new ImageIcon("image/1.png").getImage()) ;
		//������� 
		this.add(this.buttonPanel(),BorderLayout.SOUTH) ;
		//this.setLocationRelativeTo(null) ;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize() ;
		this.setSize(dimension.width-80, dimension.height-30) ;
		this.setTitle("���ն�Ʊϵͳ") ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		//����
		this.initTi() ;
	}
	/**
	 * ��ʼ���м�����
	 * @return
	 */
	public JSplitPane initCenterPanel(){
		card = new CardLayout() ;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		ImagePanel leftPanel = null;
		
		try {
			leftPanel = new ImagePanel(ImageIO.read(new File("image/171go.jpg")),dimension);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//�������
		leftPanel.setLayout(new GridLayout(7, 1, 10, 10)) ;//���Ϊ��񲼾�
		String info[] ={"ϵ ͳ �� ��","�� Ʊ �� ѯ","�� ǩ  �� ��","�� �� �� ̬","�� Ʊ �� ��","��       ��","�� �� ϵ ͳ"};
		jLabels = new JLabel[7] ;
		for (int i = 0; i < info.length; i++) {
			JLabel jLabel = new JLabel(info[i],JLabel.CENTER);
			jLabels[i] = jLabel ;
			jLabel.setForeground(Tookit.getColor()) ;
			jLabel.setEnabled(false) ;
			jLabel.addMouseListener(this) ;
			jLabel.setFont(Tookit.getFont6()) ;
			leftPanel.add(jLabel) ;
		}
		
		rightPanel = new JPanel(card) ;//�ұ�����Ϊ��Ƭ����
		//����һ����Ʊ��ѯ���
		TicketSearchPanel tsPanel = new TicketSearchPanel(user) ;
		rightPanel.add(tsPanel.getJPanel(), "tsPanel") ;
		//����һ��ȡƱ��ѯ���
		ModifyTicketPanel gtqView = new ModifyTicketPanel(user) ;
		rightPanel.add(gtqView.getJPanel(),"gtqPanel") ;
		//����һ�����ද̬
		rightPanel.add(new PlaneStatePanel().getJPanel(),"pqPanel") ;
		//����һ����Ʊ�������
		rightPanel.add(new ReturnTicketPanel(user).getJPanel(),"rtPanel") ;
		//����һ��ϵͳ������� 
		rightPanel.add(new Introduce(),"introduce") ;
		
		//�Ѷ������뵽��� ���
		 jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftPanel,rightPanel) ;
		//������ߴ���Ĵ�С
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		jsp.setDividerLocation(w);
		//���ò�ִ����м��ߵĴ�С
		jsp.setDividerSize(0);
		//jsp.setEnabled(false) ;
		jsp.setOneTouchExpandable(true) ;//����չ��
		return jsp ;
	}
	/**
	 * ��ʼ������ײ����
	 * @return
	 */
	public JPanel buttonPanel(){
		
		JPanel buttomPanel = new JPanel(new BorderLayout()) ;
		
		buttomPanel.setBackground(new Color(0x498DF8)) ;
		
		 timeLabel= new  JLabel() ;//��ǰʱ��
		 //�����߳�
		 new Thread(this).start() ;
		 buttomPanel.add(timeLabel,BorderLayout.EAST) ;
		 JLabel jLabel = new JLabel("�ÿͣ�"+user.getU_name()+"��¼") ;
		 jLabel.setFont(Tookit.getFont1());
		 buttomPanel.add(jLabel,BorderLayout.WEST) ;
		return buttomPanel ;
	}
	/**
	 * ��ʼ���˵�
	 * @return
	 */
	public JMenuBar initMenu(){
		jmBar = new JMenuBar() ;
		//�û��˵�
		JMenu jm1 = new JMenu("�û�") ;
		JMenu jm2 = new JMenu("��������") ;
		JMenu jm3 = new JMenu("�������") ;
		JMenu jm4 = new JMenu("����") ;
		JMenuItem jm1_1 = new JMenuItem("�л��û�") ;
		jm1_1.addActionListener(this);
		JMenuItem jm1_2 = new JMenuItem("�û���Ϣ�޸�");
		jm1_2.addActionListener(this);
		JMenuItem jm1_3 = new JMenuItem("�û��˳�") ;
		jm1_3.addActionListener(this);
		jm1.add(jm1_1) ;
		jm1.add(jm1_2) ;
		jm1.add(jm1_3) ;
		
		JMenuItem jm2_1 = new JMenuItem("��ȡ��Ϣ") ;
		jm2_1.addActionListener(this) ;
		JMenuItem jm2_2 = new JMenuItem("������Ϣ") ;
		jm2_1.addActionListener(this) ;
		jm2.add(jm2_1) ;
		jm2.add(jm2_2) ;
		
		JMenuItem jm3_1 = new JMenuItem("��Ʊ��ѯ") ;
		jm3_1.addActionListener(this) ;
		JMenuItem jm3_2 = new JMenuItem("��ǩ��ѯ") ;
		jm3_2.addActionListener(this) ;
		JMenuItem jm3_3 = new JMenuItem("���ද̬") ;
		jm3_3.addActionListener(this) ;
		JMenuItem jm3_4 = new JMenuItem("��Ʊ����") ;
		jm3_4.addActionListener(this) ;
		jm3.add(jm3_1) ;
		jm3.add(jm3_2) ;
		jm3.add(jm3_3) ;
		jm3.add(jm3_4) ;
		
		JMenuItem jm4_1 = new JMenuItem("ϵͳ���") ;
		jm4_1.addActionListener(this) ;
		JMenuItem jm4_2 = new JMenuItem("����") ;
		jm4_2.addActionListener(this) ;
		jm4.add(jm4_1) ;
		jm4.add(jm4_2) ;
		
		jmBar.add(jm1) ;
		jmBar.add(jm2) ;
		jmBar.add(jm3) ;
		jmBar.add(jm4) ;
		return jmBar ;
	}

	@Override
	public void run() {
		
		while(true){
			timeLabel.setText(Tookit.getCurrentTime()) ;
			try {
				Thread.sleep(1000) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//˯һ��
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("-----");
		if(e.getSource() instanceof JLabel){
			//��ʾ �Ǳ�ǩ
			if(((JLabel)e.getSource()).getText().trim().equals("�� Ʊ �� ѯ")){
				card.show(rightPanel, "tsPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("�� ǩ  �� ��")){
				card.show(rightPanel, "gtqPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("�� �� �� ̬")){
				card.show(rightPanel, "pqPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("�� Ʊ �� ��")){
				card.show(rightPanel, "rtPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("�� �� ϵ ͳ")){
				//�˳�ϵͳ 
				int num = JOptionPane.showConfirmDialog(this, "�Ƿ�����˳�ϵͳ?") ;
				if(num==JOptionPane.YES_OPTION){
					//�˳�ϵͳ 
					System.exit(0) ;
				}
			}
			if(((JLabel)e.getSource()).getText().trim().equals("��       ��")){
				//�˳�ϵͳ 
				HelpDialog helpDialog = new HelpDialog(this) ;
				helpDialog.setTitle("����") ;
			}
		}
		if(((JLabel)e.getSource()).getText().trim().equals("ϵ ͳ �� ��")){
			card.show(rightPanel, "introduce") ;
			jsp.setDividerSize(10);
			jsp.setDividerLocation(200) ;
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		//��label��Ϊ�ɼ�
		for (int i = 0; i < jLabels.length; i++) {
			if(e.getSource()==jLabels[i]){
				//��ʾ ���������һ��
				jLabels[i].setEnabled(true) ;
				jLabels[i].setCursor(new Cursor(Cursor.HAND_CURSOR)) ;//Ϊʲôû��Ч��
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
			//	jLabels[i].setCursor(new Cursor(Cursor.MOVE_CURSOR)) ;
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
	public void actionPerformed(ActionEvent e) {

			//��ʾ �Ǳ�ǩ
			if(e.getActionCommand().trim().equals("��Ʊ��ѯ")){
				card.show(rightPanel, "tsPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(e.getActionCommand().trim().equals("��ǩ��ѯ")){
				card.show(rightPanel, "gtqPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(e.getActionCommand().trim().equals("���ද̬")){
				card.show(rightPanel, "pqPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(e.getActionCommand().trim().equals("��Ʊ����")){
				System.out.println("tuipaio");
				card.show(rightPanel, "rtPanel") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
			if(e.getActionCommand().trim().equals("�û��˳�")){
				//�˳�ϵͳ 
				int num = JOptionPane.showConfirmDialog(this, "�Ƿ�����˳�ϵͳ?") ;
				if(num==JOptionPane.YES_OPTION){
					//�˳�ϵͳ 
					System.exit(0) ;
				}
			}
			if(e.getActionCommand().trim().equals("����")){
				//�˳�ϵͳ 
				HelpDialog helpDialog = new HelpDialog(this) ;
				helpDialog.setTitle("����") ;
			}
			if(e.getActionCommand().trim().equals("�л��û�")){
				//������¼ҳ��
				System.out.println("====");
				new LoginView().setVisible(true) ;
				this.dispose() ;
			}
			if (e.getActionCommand().trim().equals("�û���Ϣ�޸�")) {
				//�����û��޸Ľ���
				new Userinformodification(GuestMainView.this,user).setVisible(true) ;
				GuestMainView.this.dispose() ;
			}
			if(e.getActionCommand().trim().equals("ϵͳ���")){
				card.show(rightPanel, "introduce") ;
				jsp.setDividerSize(10);
				jsp.setDividerLocation(200) ;
			}
		}	
}
