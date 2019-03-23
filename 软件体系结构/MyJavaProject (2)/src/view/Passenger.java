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
	public static BackTickit bt;//退票面板
	public static Recharge r;//充值面板
	public static QueryResult a;//查询面板
	public static PersonInfo personInfo;
	public static boolean ifBuy=false;//是否购票
	private static final long serialVersionUID = 1L;
	private JLabel timeLabel = new JLabel() ;//显示时间
	public static CardLayout card = new CardLayout() ;
	private BorderLayout borderlayout = new BorderLayout() ;
	private JSplitPane jsplitpane = null;
	private JPanel leftPanel = null ;
	public static  JPanel mainPanel = null ;
	private JPanel bottomPanel = null ;
	private JLabel[] jLabels = null;//标签组
	public static TickitQuery tickitQueryPanel =null;
	private JMenuBar jmBar = null;
	public static Passenger passenger;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Passenger() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
		setUndecorated(true); //隐藏窗框
		//采用指定的窗口装饰风格
		getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);//改变窗体修饰
		//修改菜单默认字体和背景 
		UIManager.put("Menu.font", MyTool.getFontB(18)) ;
		UIManager.put("Label.font", MyTool.getFontP(15)) ;
		//UIManager.put("Label.foreground", Color.RED) ;
		//UIManager.put("MenuBar.background", new Color(200,190,255)) ;
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//设置窗口外观
		setLayout(borderlayout);
		//初始化菜单
		jmBar = new JMenuBar() ;
		//用户菜单
		setJMenuBar(jmBar) ;//添加菜单
		
		
		//左面板
		leftPanel = new JPanel();
		leftPanel.setOpaque(true);
		leftPanel.setBackground(new Color(0x665568));
		leftPanel.setLayout(new GridLayout(7, 1, 10, 10)) ;
		String info[] ={"机票预订","充值中心","申请退票","我的订票","帮      助","退      出"};
		jLabels = new JLabel[6] ;
		for (int i = 0; i < info.length; i++) {
			JLabel jLabel = new JLabel(info[i],JLabel.CENTER);
			jLabels[i] = jLabel ;
			jLabel.setForeground(new Color(0xFFFFFF)) ;//白色
			jLabel.setEnabled(false) ;
			jLabel.addMouseListener(this) ;
			jLabel.setFont(MyTool.getFontB(20)) ;
			leftPanel.add(jLabel) ;                         
		}
		mainPanel = new JPanel(card) ;//右边设置为卡片布局
		tickitQueryPanel = new TickitQuery();
		
		
		
		mainPanel.add(tickitQueryPanel,"p1");
		a =new QueryResult();
		mainPanel.add(a,"p2");
		personInfo = new  PersonInfo();
		mainPanel.add(personInfo,"p3");
		JPanel empty = new JPanel();
		empty.setLayout(null);
		JLabel l = new JLabel("您还没有订票账单哦");
		l.setBounds(250,200,200,20);
		l.setOpaque(true);
		l.setForeground(Color.BLUE);
		empty.add(l);
		mainPanel.add(empty,"p4");
		r=new Recharge();
		mainPanel.add(r,"p7");
		bt=new 	BackTickit();
		mainPanel.add(bt,"p5");
	
		//把二个加入到拆分 面板
		jsplitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftPanel,mainPanel) ;//创建一个配置为水平方向，可重汇的新 jsplitpanelitPane。包含两块面板
		jsplitpane.setDividerLocation(150);//设置分隔条位置
		jsplitpane.setDividerSize(5);//分割线大小
		jsplitpane.setEnabled(true) ;//可拖动
		jsplitpane.setOneTouchExpandable(false) ;//不可伸弹
		add(jsplitpane);
		
		
		
		JPanel buttomPanel = new JPanel(new BorderLayout()) ;
		buttomPanel.setBackground(new Color(0xEEEEFFF)) ;
		buttomPanel.add(timeLabel,BorderLayout.EAST) ;
		add(buttomPanel,BorderLayout.SOUTH) ;	
		setIconImage(new ImageIcon("pic_login/航班.png").getImage()) ;//图标 
		setSize(MyTool.getScreen().width-500, MyTool.getScreen().height-200) ;
		setTitle("订票中心") ;
		setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		setVisible(true) ;
		setLocationRelativeTo(null) ;
		
		
		 new Thread(this).start() ;//启动时间线程
		
		
		
	
	}
	
	

		
		
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof JLabel){
			//表示 是标签
			if(((JLabel)e.getSource()).getText().trim().equals("机票预订")){
				card.show(mainPanel, "p1") ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("充值中心")){
				card.show(mainPanel, "p7") ;
			}
			if(e.getSource()==jLabels[4]){
				Help helpDialog = new Help(this) ;
				helpDialog.setTitle("帮助") ;
			}
			if(((JLabel)e.getSource()).getText().trim().equals("申请退票")){
				if(Passenger.ifBuy)
				{
					card.show(mainPanel, "p5") ;
				}else {
					card.show(mainPanel, "p4") ;//没有购票，显示空
				
				}
			}
			if(((JLabel)e.getSource()).getText().trim().equals("我的订票")){
				if(Passenger.ifBuy)
				{
					Passenger.personInfo.removeAll();//先清除面板所有组件
					Passenger.personInfo.currentInfo();//刷新账单
					card.show(mainPanel, "p3") ;
				}else {
					card.show(mainPanel, "p4") ;//没有购票，显示空
				
				}
				
			}
			if((e.getSource())==jLabels[5]){
				//退出系统
				Object[] options= {"确定","取消","切换用户"};
				int num=JOptionPane.showOptionDialog(null, "确认退出?", "系统提示", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				//int num = JOptionPane.showConfirmDialog(this, "确定退出?") ;
				if(num==0){
					//退出系统 
					System.exit(0) ;
				}
				if(num==2)
				{
					dispose();
					//恢复原状
					Login.login.button_Login.setEnabled(true);
					Login.login.button_Login.setText("登录");
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
		//将label变为可见
		for (int i = 0; i < jLabels.length; i++) {
			if(e.getSource()==jLabels[i]){
				//表示 点击到了哪一个
				jLabels[i].setEnabled(true) ;//可编辑
				jLabels[i].setCursor(new Cursor(Cursor.HAND_CURSOR)) ;//鼠标指针变为手
				return ;
			}
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

		for (int i = 0; i < jLabels.length; i++) {
			if(e.getSource()==jLabels[i]){
				//表示 点击到了哪一个
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
		while(true) {//无限循环
			timeLabel.setText(MyTool.getCurrentTime()) ;		
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

