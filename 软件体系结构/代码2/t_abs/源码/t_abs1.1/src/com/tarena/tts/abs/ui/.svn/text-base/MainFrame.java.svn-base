package com.tarena.tts.abs.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.tarena.tts.abs.entity.City;
import com.tarena.tts.abs.vo.Flight01;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3512700162380082726L;

	// 属性(UI)
	private ClientContext context;
	private JPanel centerPane;
	private JComboBox deptBox; // 出发城市
	private JComboBox destBox; // 目的城市
	private JDatePickerImpl datePicker; // 出发时间
	
	
	// get&set方法
	public JComboBox getDeptBox() {return deptBox;}
	public JComboBox getDestBox() {return destBox;}
	public JDatePickerImpl getDatePicker() {return datePicker;}
	
	
	
	// 构造方法
	public MainFrame() {
		init();
	}
	public MainFrame(ClientContext context) {
		this.context = context;
		init();
	}
	private void init() {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setTitle("T-ABS 在线购票系统");
		setContentPane(createContentPane());

		// 点击"关闭"按钮时，弹出提示框
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				context.exit(MainFrame.this);
			}
		});
	}
	
	
	private JPanel createContentPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.NORTH, createToolBar());

		pane.add(BorderLayout.WEST, createLeftPane());
		pane.add(BorderLayout.CENTER, createCenterPane());
		return pane;
	}

	/**
	 * 中部的布局面板
	 * 
	 * @return
	 */
	private JPanel createCenterPane() {
		JPanel pane = new JPanel(new BorderLayout());
		centerPane = pane;
		pane.setBorder(LineBorder.createGrayLineBorder());
		pane.add(BorderLayout.NORTH, createNavPane());// 购票导航栏面板
		pane.add(BorderLayout.CENTER, createSearchReaultPane());// 票务查询列表面板
		pane.add(BorderLayout.SOUTH, createSelectTicketPane());// 选择票数量和下一步面板
		return pane;
	}
	
	private JPanel navPane;
	private JLabel cityLabel;
	private JLabel flightDateLabel;
	public void setCityLabel(JLabel cityLabel) {this.cityLabel = cityLabel;}
	/**
	 * 购票导航栏面板navPane
	 * 
	 * @return
	 */
	private Component createNavPane() {
		navPane = new JPanel(new SpringLayout());
		navPane.add(new JLabel("航线查询 >> 选择航班 >> 填写资料 >> 支付 >> 出票",JLabel.LEADING));
		//JPanel p = createDateIndexPane(new Date());// 创建日期索引
		//pane.add(p);
		
		cityLabel = new JLabel(" 广州白云机场 >>>>>北京首都国际机场 ",JLabel.CENTER);
		flightDateLabel = new JLabel("2011-08-24");
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.WEST, new JLabel("直飞航班>>"));
		p.add(BorderLayout.CENTER, cityLabel);
		p.add(BorderLayout.EAST, flightDateLabel);
		navPane.add(p);

		SpringUtilities.layoutVertical(navPane);
		return navPane;
	}
	
	/**
	 * 更新购票导航栏面板navPane
	 * @param list
	 * @return
	 */
	private Component createNavPane(List<Flight01> list) {
		
		String fromAirport = "";
		String toAirport = "";
		String flDate = "";
		if(!list.isEmpty()){
			fromAirport = ((Flight01)list.get(0)).getFromAirportFullName();
			toAirport = ((Flight01)list.get(0)).getToAirportFullName();
			flDate = ((Flight01)list.get(0)).getFlDate();
		}
			
		navPane = new JPanel(new SpringLayout());
		navPane.add(new JLabel("航线查询 >> 选择航班 >> 填写资料 >> 支付 >> 出票",JLabel.LEADING));
		//JPanel p = createDateIndexPane(new Date());// 创建日期索引
		//pane.add(p);
		
		cityLabel = new JLabel(fromAirport+" >>>>> "+toAirport , JLabel.CENTER);
		flightDateLabel = new JLabel(flDate);
		
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.WEST, new JLabel("直飞航班>>"));
		p.add(BorderLayout.CENTER, cityLabel);
		p.add(BorderLayout.EAST, flightDateLabel);
		navPane.add(p);

		SpringUtilities.layoutVertical(navPane);
		return navPane;
		
	}
	
	/*
	private JPanel createDateIndexPane(Date date) {
		JPanel pane = new JPanel(new FlowLayout(FlowLayout.LEADING));
		long oneday = 1000L * 60 * 60 * 24;
		long start = date.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 1; i < 7; i++) {
			JButton b = new JButton(fmt.format(start + i * oneday));
			b.setContentAreaFilled(false);
			pane.add(b);
		}
		return pane;
	}
	*/
	
	
	
	/**
	 * 更新页面
	 * 
	 * @param list
	 */
	public void updateSearchReault(List<Flight01> list) {
		
		//更新购票导航栏面板navPane中的cityLabel和flightDateLabel
		centerPane.remove(navPane);
		centerPane.add(BorderLayout.NORTH, createNavPane(list));
		
		//更新searchReaultPane
		centerPane.remove(searchReaultPane);
		centerPane.add(BorderLayout.CENTER, createSearchReaultPane(list));
		
		centerPane.updateUI();
	}
	
	

	private JScrollPane searchReaultPane;
	/**
	 * 票务查询列表面板
	 * 
	 * @return
	 */
	private Component createSearchReaultPane() {
		JScrollPane scrollPane = new JScrollPane();
		searchReaultPane = scrollPane;
		flightItemPane = new JPanel();
		BoxLayout l = new BoxLayout(flightItemPane, BoxLayout.Y_AXIS);
		flightItemPane.setLayout(l);

		scrollPane.getViewport().add(flightItemPane);

		// 初识化(测试页面)
		flightItemPane.add(createFlightPane());
		flightItemPane.add(createFlightPane());
		flightItemPane.add(createFlightPane());
		flightItemPane.add(createFlightPane());

		scrollPane.setAutoscrolls(true);

		return scrollPane;
	}
	
	private JPanel flightItemPane; // 票务查询列表面板
	/**
	 * 创建航班项(flightItemPane)面板
	 * @param list
	 * @return
	 */
	private Component createSearchReaultPane(List<Flight01> list) {
		JScrollPane scrollPane = new JScrollPane();
		searchReaultPane = scrollPane;
		flightItemPane = new JPanel();
		BoxLayout l = new BoxLayout(flightItemPane, BoxLayout.Y_AXIS);
		flightItemPane.setLayout(l);

		scrollPane.getViewport().add(flightItemPane);

		for (int i = 0; i < list.size(); i++) {
			flightItemPane.add(createFlightPane(list.get(i)));
		}

		scrollPane.setAutoscrolls(true);

		return scrollPane;
	}

	/*
	 * 航班号 航班日期 起飞时间 到达时间 机型 飞行里程 TL1201 2012-05-03 10:25 12:15 B737-800 1088KM
	 * 产品名称 剩余座位 票价 优惠价 机建燃油费 选择按钮 头等舱 无 1836.0 1836.0 50.0+40.0 公务舱 无 1530.0
	 * 1530.0 50.0+40.0 经济舱 100 1020.0 1020.0 50.0+40.0 *
	 * 
	 */
	/**
	 * 创建航班信息面板(测试信息面板)
	 * 
	 * @return
	 */
	private Component createFlightPane() {
		JPanel pane = new JPanel(new GridLayout(6, 6));

		pane.setBorder(LineBorder.createGrayLineBorder());

		// 准备收音机按钮
		JRadioButton btn1 = new JRadioButton("button1");
		JRadioButton btn2 = new JRadioButton("button2");
		JRadioButton btn3 = new JRadioButton("button3"); 
		// 将收音机按钮放入组中
		ButtonGroup bg = new ButtonGroup();
		bg.add(btn1);
		bg.add(btn2);
		bg.add(btn3);

		// 头部 航班号 航班日期 起飞时间 到达时间 机型 飞行里程
		pane.add(createBoldLabel("【航班号】"));
		pane.add(createBoldLabel("【航班日期】"));
		pane.add(createBoldLabel("【起飞时间】"));
		pane.add(createBoldLabel("【到达时间】"));
		pane.add(createBoldLabel("【机型】"));
		pane.add(createBoldLabel("【飞行里程】"));

		pane.add(createPlainLabel("TL1203"));
		pane.add(createPlainLabel("2012-05-03"));
		pane.add(createPlainLabel("13:00"));
		pane.add(createPlainLabel("15:05"));
		pane.add(createPlainLabel("B737-800"));
		pane.add(createPlainLabel("1088KM"));

		pane.add(createBoldLabel("【产品名称】"));
		pane.add(createBoldLabel("【剩余座位】"));
		pane.add(createBoldLabel("【票价】"));
		pane.add(createBoldLabel("【优惠价】"));
		pane.add(createBoldLabel("【机建燃油费】"));
		pane.add(createBoldLabel("【选择】"));

		pane.add(createPlainLabel("头等舱"));
		pane.add(createPlainLabel("无"));
		pane.add(createPlainLabel("1836.0(X)"));
		pane.add(createPlainLabel("1836.0"));
		pane.add(createPlainLabel("50.0+40.0"));
		pane.add(btn1);

		pane.add(createBoldLabel("公务舱"));
		pane.add(createBoldLabel("无"));
		pane.add(createBoldLabel("1530.0(X)"));
		pane.add(createBoldLabel("1530.0"));
		pane.add(createBoldLabel("50.0+40.0"));
		pane.add(btn2);

		pane.add(createPlainLabel("经济舱"));
		pane.add(createPlainLabel("100"));
		pane.add(createPlainLabel("1020.0(X)"));
		pane.add(createPlainLabel("1020.0"));
		pane.add(createPlainLabel("50.0+40.0"));
		pane.add(btn3);

		// 舱位
		return pane;
	}

	/**
	 * 创建航班信息面板(用于更新航班信息)
	 * 
	 * @param list
	 * @return
	 */
	private Component createFlightPane(Flight01 f) {
		JPanel pane = new JPanel(new GridLayout(6, 6));

		pane.setBorder(LineBorder.createGrayLineBorder());

		// 准备收音机按钮
		JRadioButton btn1 = new JRadioButton("button1");
		JRadioButton btn2 = new JRadioButton("button2");
		JRadioButton btn3 = new JRadioButton("button3", true); // 默认选项
		// 将收音机按钮放入组中
		ButtonGroup bg = new ButtonGroup();
		bg.add(btn1);
		bg.add(btn2);
		bg.add(btn3);

		// 头部 航班号 航班日期 起飞时间 到达时间 机型 飞行里程
		pane.add(createBoldLabel("【航班号】"));
		pane.add(createBoldLabel("【航班日期】"));
		pane.add(createBoldLabel("【起飞时间】"));
		pane.add(createBoldLabel("【到达时间】"));
		pane.add(createBoldLabel("【机型】"));
		pane.add(createBoldLabel("【飞行里程】"));

		pane.add(createPlainLabel(f.getFlightNum()));
		pane.add(createPlainLabel(f.getFlDate()));
		pane.add(createPlainLabel(f.getFlDepartureTime()));
		pane.add(createPlainLabel(f.getFlArrivalTime()));
		pane.add(createPlainLabel(f.getPlaneModel()));
		pane.add(createPlainLabel(f.getRouteDistance() + ""));

		pane.add(createBoldLabel("【产品名称】"));
		pane.add(createBoldLabel("【剩余座位】"));
		pane.add(createBoldLabel("【票价】"));
		pane.add(createBoldLabel("【优惠价】"));
		pane.add(createBoldLabel("【机建燃油费】"));
		pane.add(createBoldLabel("【选择】"));

		pane.add(createPlainLabel("头等舱"));
		pane.add(createPlainLabel(f.getFseatsRemain() == 0 ? "无" : f
				.getFseatsRemain().toString()));
		pane.add(createPlainLabel(f.getFullPrice() * 1.8 + "")); // 规定:头等舱价格为基准价的1.8倍
		pane.add(createPlainLabel(f.getFullPrice() * f.getCurrentDiscount()
				* 1.8 + ""));
		pane.add(createPlainLabel(f.getTax1Price() + "+" + f.getTax2Price()));
		pane.add(btn1);

		pane.add(createBoldLabel("公务舱"));
		pane.add(createPlainLabel(f.getFseatsRemain() == 0 ? "无" : f
				.getFseatsRemain().toString()));
		pane.add(createPlainLabel(f.getFullPrice() * 1.5 + "")); // 规定:公务舱价格为基准价的1.5倍
		pane.add(createPlainLabel(f.getFullPrice() * f.getCurrentDiscount()
				* 1.5 + ""));
		pane.add(createPlainLabel(f.getTax1Price() + "+" + f.getTax2Price()));
		pane.add(btn2);

		pane.add(createPlainLabel("经济舱"));
		pane.add(createPlainLabel("100"));
		pane.add(createPlainLabel("1020.0(X)"));
		pane.add(createPlainLabel("1020.0"));
		pane.add(createPlainLabel("50.0+40.0"));
		pane.add(btn3);
		// 舱位
		return pane;
	}

	private JLabel createBoldLabel(String text) {
		JLabel l = new JLabel(text, JLabel.CENTER);
		Font font = l.getFont();
		Font f = font.deriveFont(Font.BOLD);
		l.setFont(f);
		return l;
	}
	private JLabel createPlainLabel(String text) {
		JLabel l = new JLabel(text, JLabel.CENTER);
		Font font = l.getFont();
		Font f = font.deriveFont(Font.PLAIN);
		l.setFont(f);
		return l;
	}
	
	
	private JComboBox passengerNum;
	private JPanel selectTicketPane;
	public JComboBox getPassengerNum() {return passengerNum;}
	/**
	 * 选择票数量和下一步面板
	 * @return
	 */
	private Component createSelectTicketPane() {
		selectTicketPane = new JPanel(new SpringLayout());

		JPanel p = new JPanel();
		
		p.add(new JLabel("请选择旅客人数："));
		
		//p.add(new JLabel("成人"));
		passengerNum = new JComboBox(new Integer[] { 1, 2, 3});
		p.add(passengerNum);
		
		/*
		p.add(new JLabel("儿童"));
		JComboBox child = new JComboBox(new Integer[] { 0, 1, 2, 3, 4, 5 });
		p.add(child);
		p.add(new JLabel("婴儿"));
		JComboBox kid = new JComboBox(new Integer[] { 0, 1, 2, 3, 4, 5 });
		p.add(kid);
		 */
		selectTicketPane.add(p);
		
		JPanel btn = new JPanel();
		JButton next = new JButton("下一步");
		
		next.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//跳转到PreorderFrame页面
				context.preorder();
			}
		});
		
		btn.add(next);
		selectTicketPane.add(btn); // SpringUtilities.layoutHorizontal(p);
		SpringUtilities.layoutVertical(selectTicketPane);
		return selectTicketPane;
	}

	/**
	 * 创建右面布局面板
	 * 
	 * @return
	 */
	private JPanel createLeftPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(BorderLayout.NORTH, createSearchPane());
		// pane.setBorder(LineBorder.createGrayLineBorder());
		JTextPane readme = new JTextPane();
		String txt = "儿童: 指年龄满两周岁（含）但不满十二周岁的人。" + "儿童旅客需持有户口簿或其他有效身份证件办理乘机手续。"
				+ "无成人陪伴儿童不支持网站购票，" + "请旅客前往当地海航直属售票处购票。 \n\n"
				+ "婴儿: 是指年龄在两周（含）以上但不满两周岁的人。"
				+ "婴儿旅客需持有户口簿、出生证或其他有效身份证件办理乘机手续。";
		readme.setText(txt);
		readme.setOpaque(false);
		readme.setPreferredSize(new Dimension(200, 50));
		readme.setEditable(false);
		readme.setBorder(new TitledBorder("说明"));
		pane.add(BorderLayout.CENTER, readme);
		pane.setBorder(new EmptyBorder(6, 6, 6, 6));
		return pane;
	}

	/**
	 * 创建搜索面板
	 * 
	 * @return
	 */
	private JPanel createSearchPane() {
		JPanel pane = new JPanel(new SpringLayout());
		// pane.setPreferredSize(new Dimension(240, 350));
		pane.setBorder(new TitledBorder("搜索航班"));

		/*
		 * 创建行程按钮面板 JPanel tripPane = createTripPane(); pane.add(new
		 * JLabel("行程:", JLabel.RIGHT)); pane.add(tripPane);
		 */

		// 出发地 departure
		deptBox = new JComboBox();
		pane.add(new JLabel("出发地:", JLabel.RIGHT));
		pane.add(deptBox);

		// 目的地 destination
		destBox = new JComboBox();
		pane.add(new JLabel("目的地:", JLabel.RIGHT));
		pane.add(destBox);
		// 出发时间
		datePicker = (JDatePickerImpl) JDateComponentFactory
				.createJDatePicker();
		pane.add(new JLabel("出发时间:", JLabel.RIGHT));
		pane.add(datePicker);

		// 搜索按钮
		JButton searchButton = new JButton("查询航班");

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 查询航班信息
				context.search();

			}
		});

		pane.add(new JLabel());
		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
		btnPane.add(searchButton);
		pane.add(btnPane);

		SpringUtilities.layoutForm(pane);

		return pane;
	}

	/*
	 * private JPanel createTripPane() { JPanel p = new JPanel(new
	 * FlowLayout(FlowLayout.LEADING)); JRadioButton oneway = new
	 * JRadioButton("单程"); JRadioButton roundTrip = new JRadioButton("往返");
	 * ButtonGroup group = new ButtonGroup(); group.add(oneway);
	 * group.add(roundTrip); p.add(oneway); p.add(roundTrip); return p; }
	 */

	private JToolBar createToolBar() {
		JToolBar bar = new JToolBar();
		JButton orders = new JButton("在线购票");
		bar.add(orders);
		JButton branch = new JButton("营业网点");
		bar.add(branch);
		JButton help = new JButton("购票帮助");
		bar.add(help);
		JButton about = new JButton("关于我们");
		bar.add(about);
		return bar;
	}


	/**
	 * 更新JComboBox中的City信息
	 * 
	 * @param city
	 */
	public void updateCity(List<City> cities) {

		for (City c : cities) {
			deptBox.addItem(c.getCityName());
			destBox.addItem(c.getCityName());
		}

	}
	
	/**
	 * 订单信息页面
	 */
	public void updateCenterPane_Preorder(int passengerNum) {
		
//		pane.add(BorderLayout.NORTH, createNavPane());// 购票导航栏面板
//		pane.add(BorderLayout.CENTER, createSearchReaultPane());// 票务查询列表面板
//		pane.add(BorderLayout.SOUTH, createSelectTicketPane());// 选择票数量和下一步面板
			
		//1. 更新navPane
		centerPane.remove(navPane);
		centerPane.add(BorderLayout.NORTH, createNavPane_Preorder());
		
		//2. 更新searchReaultPane为preorderPane
		centerPane.remove(searchReaultPane);
		centerPane.add(BorderLayout.CENTER, createPreorderPane(passengerNum));
		
		//3. 更新
		centerPane.remove(selectTicketPane);
		centerPane.add(BorderLayout.SOUTH , createButtonPane());
		
		centerPane.updateUI();
		
	}
	
	private Component createNavPane_Preorder() {
		
		navPane = new JPanel(new SpringLayout());
		navPane.add(new JLabel(
				"航线查询 >> 选择航班 >> 填写资料 >> 支付 >> 出票",JLabel.LEADING));

		SpringUtilities.layoutVertical(navPane);
		return navPane;
		
	}
	private Component createPreorderPane(int passengerNum) {
		JPanel preorderPane = new JPanel(new BorderLayout());
		
		//1. 创建旅客信息面板
		preorderPane.add(BorderLayout.NORTH , createPassengerPane(passengerNum));
		
		//2. 创建航班信息面板
		preorderPane.add(BorderLayout.CENTER , createFlightInfoPane());
		
		//3. 创建票价信息面板
		preorderPane.add(BorderLayout.SOUTH , createTicketInfoPane());
		
		return preorderPane;
	}

	
	private Component createFlightInfoPane() {
		JPanel pane = new JPanel(new GridLayout());
		JLabel l = new JLabel("FlightInfoPane");
		pane.add(l);
		return pane;
	}
	
	private Component createTicketInfoPane() {
		JPanel pane = new JPanel(new GridLayout());
		JLabel l = new JLabel("TicketInfoPane");
		pane.add(l);
		return pane;
	}
	
	private Component createPassengerPane(int passengerNum) {
		JPanel passengerPane = new JPanel(new GridLayout(5, passengerNum));
		JLabel l = new JLabel("PassengerPane");
		passengerPane.add(l);
		return passengerPane;
	}
	
	private Component createButtonPane() {
		JPanel pane = new JPanel(new GridLayout());
		JLabel l = new JLabel("ButtonPane");
		pane.add(l);
		return pane;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
