package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import oracle.net.aso.s;

import otcyan.java.bean.Bank;
import otcyan.java.bean.FlightAddr;
import otcyan.java.bean.FlightInfo;
import otcyan.java.bean.Seat;
import otcyan.java.bean.User;
import otcyan.java.model.CheckInfo;
import otcyan.java.model.DataHandle;
import otcyan.java.model.FileOperation;
import otcyan.java.model.MyButtonRenderer;
import otcyan.java.model.SearchTableModel;
import otcyan.java.tools.DBHelp;
import otcyan.java.tools.ImagePanel;
import otcyan.java.tools.Tookit;

public class TicketSearchPanel extends JPanel implements ActionListener,MouseListener{

	private ImagePanel ticketSearchPanel = null ;
	private HashMap<String, Bank> map= null ;//һ��ƱId����ʲô �����˺���� 
	private CardLayout card = null ;
	private JButton queryButton = null ;
	private JButton resetButton = null ;
	private JButton order ;
	private JTextField jtf1,jtf2,jtf3,jtf1_1,jtf2_1,jtf3_1, idField,priceField;
	private JComboBox jcBox,jcBox_1, boxType ;
	private JLabel jl1 ,jl2,jl3,jl4,jlTop;
	private JTable jTable ;
	private DataHandle dataHandle ;
	private Vector<FlightInfo> fInfos  ;
	private Vector<Vector<Seat>> seats ;
	private FlightInfo selectFlightInfo = null ; 
	private Vector<String> remainType = null ;
	private Vector<Seat> selectSeat =  null ; 
	private SearchTableModel stmModel ;
	private boolean isGoing  = false ;
	private JScrollPane jsp ;
	private String currenTime ,bankName;
	private User user ;
	private JPanel c ;
	private CheckInfo checkInfo ;
	public TicketSearchPanel(User user){
		checkInfo = new CheckInfo() ;
		map = new HashMap<String, Bank>() ;
		dataHandle = new DataHandle() ;
		this.user = user ;
		UIManager.put("Label.font", Tookit.getFont1()) ;
		UIManager.put("Button.font", Tookit.getFont1()) ;
		UIManager.put("ComboBox.font", Tookit.getFont1()) ;
		UIManager.put("CheckBox.font", Tookit.getFont1()) ;
		remainType = new Vector<String>() ;
		currenTime = Tookit.getDateFormat("yyyy-MM-dd").format(new Date()) ;
		card = new CardLayout() ;
		this.init();
	}
	/**
	 * ��һ�����
	 * @return
	 */
	public JPanel onePanel(){
		JPanel jPanel = new JPanel(new BorderLayout()) ;
		jPanel.setOpaque(false) ;
		
		//���Ʊ���
		JPanel north = new JPanel() ;
		north.setPreferredSize(new Dimension(1028,145)) ;
		north.setOpaque(false) ;
		jPanel.add(north,BorderLayout.NORTH) ;
		
		JPanel center = new JPanel(null) ;
		center.setOpaque(false) ;
		
		 jl1= new JLabel("�������У�");
		jl1.setBounds(200, 20, 74, 20) ;
		jl1.setFont(Tookit.getFont1()) ;
		 jtf1= new JTextField(12) ;
		jtf1.setBounds(275, 20, 130, 20) ;
	     jl2 = new JLabel("������У�");
		jl2.setBounds(200, 70, 74, 20) ;
		jl2.setFont(Tookit.getFont1()) ;
	    jtf2 = new JTextField() ;
		jtf2.setBounds(275, 70, 130, 20) ;
		 jl3 = new JLabel("�������ڣ�",JLabel.RIGHT);
		jl3.setFont(Tookit.getFont1()) ;
		jl3.setBounds(200, 120, 74, 20) ;
		 jtf3 = new JTextField(currenTime) ;
		jtf3.setBounds(275, 120, 130, 20) ;
		 jl4 = new JLabel("����ʱ�䣺",JLabel.RIGHT);
		jl4.setBounds(200, 175, 74, 20) ;
		jl4.setFont(Tookit.getFont1()) ;
		jcBox = new JComboBox(new String[]{"ȫ��ʱ���","00:00-06��00","06:00-12:00","12:00-18:00","18:00-24:00"}) ;
		jcBox.setFont(Tookit.getFont1()) ;
		jcBox.setBounds(275, 170, 100, 30) ;

		queryButton = new JButton("��ʼ��ѯ");
		queryButton.addActionListener(this) ;
		queryButton.setFont(Tookit.getFont1()) ;
		queryButton.setBounds(180, 220, 120, 30) ;
		queryButton.setBackground(new Color(0xA9CAF3)) ;
		resetButton = new JButton("���²�ѯ") ;
		resetButton.addActionListener(this) ;
		resetButton.setBackground(new Color(0xA9CAF3)) ;
		resetButton.setFont(Tookit.getFont1()) ;
		resetButton.setBounds(320, 220, 120, 30) ;
		
		center.add(jl1) ;
		center.add(jtf1) ;
		center.add(jl2) ;
		center.add(jtf2) ;
		center.add(jl3) ;
		center.add(jtf3) ;
		center.add(jl4) ;
		center.add(jcBox) ;
		center.add(queryButton) ;
		center.add(resetButton) ;
		
		jPanel.add(center) ;
		//�����ϱ�
		JPanel south = new JPanel() ;
		south.setPreferredSize(new Dimension(1028,200)) ;
		south.setOpaque(false) ;
		jPanel.add(south,BorderLayout.SOUTH) ;
		
		return jPanel ;
	}
	
	public JPanel twoPanel(){
		JPanel jPanel = new JPanel(new BorderLayout()) ;
		jPanel.setOpaque(false) ;
		JPanel north = new JPanel() ;
		north.setOpaque(false) ;
		//�õ����� TextFieldֵ
		//���뵽���������
		jl1= new JLabel("�������У�");
		jl1.setFont(Tookit.getFont1()) ;
		  jtf1_1 = new JTextField(12) ;
	     jl2 = new JLabel("������У�");
		jl2.setFont(Tookit.getFont1()) ;
		 jtf2_1 = new JTextField(12) ;
		 jl3 = new JLabel("�������ڣ�",JLabel.RIGHT);
		jl3.setFont(Tookit.getFont1()) ;
		 jtf3_1 = new JTextField() ;
		 jtf3_1.setPreferredSize(new Dimension(137, 23)) ;
		 jl4 = new JLabel("����ʱ�䣺",JLabel.RIGHT);
		jl4.setFont(Tookit.getFont1()) ;
		  jcBox_1 = new JComboBox(new String[]{"ȫ��ʱ���","00:00-06:00","06:00-12:00","12:00-18:00","18:00-24:00"}) ;
		 jcBox_1.setFont(Tookit.getFont1()) ;

		queryButton = new JButton("��ʼ��ѯ");
		queryButton.addActionListener(this) ;
		queryButton.setFont(Tookit.getFont1()) ;
		queryButton.setBackground(new Color(0xA9CAF3)) ;
		
		order = new JButton("Ԥ��");
		order.addActionListener(this) ;
		order.setFont(Tookit.getFont1()) ;
		order.setBounds(180, 220, 120, 30) ;
		order.setBackground(new Color(0xA9CAF3)) ;
		
		north.add(jl1) ;
		north.add(jtf1_1) ;
		north.add(jl2) ;
		north.add(jtf2_1) ;
		north.add(jl3) ;
		north.add(jtf3_1) ;
		north.add(jl4) ;
		north.add(jcBox_1) ;
		north.add(queryButton) ;
		north.add(order) ;
		JPanel bank = new JPanel() ;//�����
		bank.setOpaque(false) ;
		bank.setPreferredSize(new Dimension(1028,96)) ;
		JPanel top = new JPanel(new GridLayout(2,1)) ;
		top.setOpaque(false) ;
		top.add(bank)  ;
		top.add(north) ;
		jPanel.add(top,BorderLayout.NORTH) ;
	
		jsp = new JScrollPane() ;
		//jScrollPane����͸��
		jsp.setOpaque(false) ;
		jsp.getViewport().setOpaque(false) ;
		jPanel.add(jsp) ;
		return jPanel ;
	}
	
	private void init() {
		try {
			ticketSearchPanel = new ImagePanel(ImageIO.read(new File("image/ticketsearch.jpg")),new Dimension(Tookit.getScreen().width-100,Tookit.getScreen().height-100)) ;
			ticketSearchPanel.setLayout(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ticketSearchPanel.add(this.onePanel(),"one") ;
		ticketSearchPanel.add(this.twoPanel(),"two") ;
		ticketSearchPanel.add(this.threePanel(),"three") ;
		ticketSearchPanel.add(this.fourPanel(),"four") ;
	}
	public JPanel getJPanel() {
		return ticketSearchPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("��ʼ��ѯ")){
			if(!isGoing){
				jtf3_1.setText(jtf3.getText().trim()) ;
				jtf2_1.setText(jtf2.getText().trim());
				jtf1_1.setText(jtf1.getText().trim()) ;
			}
			this.query() ;
		}
		
		if(e.getActionCommand().equals("���²�ѯ")){
			this.clear() ;
		}
		if(e.getActionCommand().equals("Ԥ��")){
			this.order();
		}
		if(e.getActionCommand().equals("����ѡ��")){
			card.show(ticketSearchPanel, "two") ;
		}
		if(e.getActionCommand().equals("ȡ������")){
			card.show(ticketSearchPanel, "two") ;
		}
		if(e.getActionCommand().equals("�ύ����")){
			
			//��ֵ
			jlTop.setText("<html>Ӧ����<font color=#FF0000 size=7>"+priceField.getText().trim()+"</font>Ԫ</html>") ;
			
			//�õ����� ������û���������Ϣ
			Vector<String> v = dataHandle.queryStringVector("select b_name from bank where b_u_name=? and b_u_card=?", new String[]{user.getU_name(),user.getU_idcard()}) ;
			//�ж� ��û�и��˺�
			if(v.size()==0){
				//��ʾ ���û�û����������
				JOptionPane.showMessageDialog(null, "û����������,��ע�ᣡ") ;
				//��ת
				card.show(ticketSearchPanel, "two") ;
				return ;
			}
			System.out.println(v);
			c.removeAll() ;//�������������
			
			for(String bankNames:v){	
				Box box = Box.createVerticalBox() ;
				JLabel jl_bank =  new JLabel(bankNames,JLabel.CENTER);
				jl_bank.setFont(Tookit.getFont3()) ;
				box.add(jl_bank) ;
				jl_bank.addMouseListener(TicketSearchPanel.this) ;
				jl_bank.setEnabled(false) ;
				JLabel jl_picture = new JLabel(new ImageIcon("image/"+bankNames+".jpg")) ;
				box.add(jl_picture) ;
				c.add(box) ;
			}
			//��������ҳ��
			card.show(ticketSearchPanel, "four") ;
		}
		if(e.getActionCommand().equals("����֧��")){
			//�ж�Ǯ�ǲ����㹻��
			String sql = "select b_balance from bank where b_u_name=? and b_u_card=? and b_name=?" ;
			String balanceString = dataHandle.queryOneString(sql, new String[]{user.getU_name(),user.getU_idcard(),bankName}) ;
			sql = "select b_account from bank where b_u_name=? and b_u_card=? and b_name=?" ;
			String account = dataHandle.queryOneString(sql, new String[]{user.getU_name(),user.getU_idcard(),bankName}) ;
			
			System.out.println(balanceString);	
			if(balanceString==null){
					JOptionPane.showMessageDialog(null, "��ѡ����������") ;
					return ;
				}
			double balance = Double.parseDouble(balanceString) ;
			//�õ� ��ǰƱ��
			double currentPrice = Double.parseDouble(priceField.getText().trim());
			if(balance<currentPrice){
				JOptionPane.showMessageDialog(TicketSearchPanel.this, "���㣬�޷�֧��!") ;
				//��ת
				card.show(ticketSearchPanel, "four") ;
				return ;
			}
			sql = "select t_seatId from tickets where t_date=? and t_f_number =? and t_type=?" ;
			//�õ�������λ��
			System.out.println(jtf3_1.getText().trim()+selectFlightInfo.getF_number()+(String)boxType.getSelectedItem());
			Vector<String> seatIds = dataHandle.queryStringVector(sql, new String[]{jtf3_1.getText().trim(),selectFlightInfo.getF_number(),(String)boxType.getSelectedItem()}) ;
			//������λ 
			//�õ� ѡ���λ������ 
			int seatTotalNum = 0 ;
		     for(Seat seat : selectSeat){
		    	 if(seat.getS_type().equals((String)boxType.getSelectedItem())){
		    		 seatTotalNum = Integer.parseInt(seat.getS_number()) ;
		    		 break ;
		    	 }
		     }
		     //���� ����λ��
		     int sellSeatNum = -1 ;
		     System.out.println("��λ������"+seatTotalNum+"��������"+seatIds);
		     
		     for (int i = 1; i <=seatTotalNum; i++) {
				
		    	 if(!seatIds.contains(i+"")){
		    		 sellSeatNum = i ;
		    		 break ;
		    	 }
			}	    
		    System.out.println(sellSeatNum);
		    System.out.println(selectFlightInfo.getF_number());
			//����һ��Ʊ���
			sql = "insert into tickets values(?||seq_tickets.nextval,?,?,?,?,?)" ;
			boolean b1 = dataHandle.update(sql, new String[]{"e",selectFlightInfo.getF_number(),user.getU_id(),sellSeatNum+"",(String)boxType.getSelectedItem(),jtf3_1.getText().trim()}) ;
			//����һ��������
			sql = "select t_id from tickets where t_date=? and t_seatId=? and t_type=?" ;
		    String sellTicketId = dataHandle.queryOneString(sql, new String[]{jtf3_1.getText().trim(),sellSeatNum+"",(String)boxType.getSelectedItem()}) ;
			System.out.println("������Ʊ��id:"+sellTicketId);
		    boolean b2 = dataHandle.update("insert into orders values(?||seq_orders.nextval,?,?,?)", new String[]{"O",user.getU_id(),sellTicketId,currenTime}) ;
			//����  bank��
			String remainBalance = (balance-currentPrice)+"" ;
			boolean b3 = dataHandle.update("update bank set b_balance=? where b_name=? and b_u_name=? and b_u_card=?", new String[]{remainBalance,bankName,user.getU_name(),user.getU_idcard()}) ;
		    System.out.println(b1+"  "+b2+"  "+b3+" ");
			if(b1 && b2 && b3){
				JOptionPane.showMessageDialog(null, "<html>��ϲ"+user.getU_name()+"��Ʊ�ɹ�"+"<br>Ʊ��Ϊ:"+sellTicketId+"<br>��λ�ţ�"+(String)boxType.getSelectedItem()+"   ZX"+sellSeatNum+"<br>�ǻ�ʱ�䣺"+jtf3_1.getText().trim()+"   "+selectFlightInfo.getF_start_time()+"<br>Ʊ�� ��"+priceField.getText()+"</html>") ;
				//����һ��Ʊ
				FileOperation fileOperation = new FileOperation() ;
				boolean b4 = fileOperation.saveTickets(selectSeat.get(0), user, "   ZX"+sellSeatNum, (String)boxType.getSelectedItem(), jtf3_1.getText().trim(),sellTicketId) ;
				if(b4){
					JOptionPane.showMessageDialog(null, "Ʊ�ѱ�����path/"+sellTicketId+"��") ;
				}else {
					JOptionPane.showMessageDialog(null, "Ʊ����ʧ�ܣ���") ;
				}
				//��   ��� Ʊ��id ��  ���п��ż��뵽һ��hashMap��������Ժ� ��Ʊ
				Bank bank = dataHandle.queryOneBank("select * from bank where b_u_name=? and b_u_card=? and b_name=?", new String[]{user.getU_name(),user.getU_idcard(),bankName},user) ;
				//����map��Ϣ
				HashMap<String, Bank> map = fileOperation.loadBank() ;
				if(map==null){
					map = new HashMap<String, Bank>() ;//��ֹ ��һ�ε�ʱ�� û��ֵ 
				}
				map.put(sellTicketId, bank) ;//��һ��ֵ 
				//���浽�ļ� ��
				fileOperation.saveBank(map) ;
				
			}else{
				JOptionPane.showMessageDialog(null, "��Ʊʧ��") ;
			}
			card.show(ticketSearchPanel, "two") ;
			this.query() ;
		}
	}
	
	public void clear(){
		this.jtf1.setText("") ;
		this.jtf2.setText("") ;
		this.jtf3.setText("") ;
		this.jcBox.setSelectedIndex(0) ;
	}
	
	public JPanel threePanel(){
		
		JPanel jPanel = new JPanel(new BorderLayout()) ;
		jPanel.setOpaque(false) ;
		//������һ����panel
		JPanel blankTop = new JPanel() ;
		blankTop.setOpaque(false) ;
		blankTop.setPreferredSize(new Dimension(Tookit.getScreen().width,103)) ;
		jPanel.add(blankTop,BorderLayout.NORTH) ;
		
		JPanel center = new JPanel(new BorderLayout()) ;
		center.setOpaque(false) ;
		JPanel top = new JPanel(new GridLayout(2, 7, 63, 30)) ;
		top.setOpaque(false) ;
		JLabel id = new JLabel("�����",JLabel.CENTER) ;
		JLabel type = new JLabel("��λ",JLabel.CENTER) ;
		JLabel price = new JLabel("�۸�",JLabel.CENTER) ;
		JLabel name = new JLabel("����",JLabel.CENTER);
		JLabel cardType = new JLabel("֤������",JLabel.CENTER) ;
		JLabel cardNum = new JLabel("֤������") ;
		JLabel telNum = new JLabel("�ֻ�����") ;
		
		idField = new JTextField() ;
		idField.setEditable(false) ;
		boxType = new JComboBox(remainType) ;//¼������
	    priceField = new JTextField() ;
		priceField.setEditable(false) ;
		JTextField nameField = new JTextField(user.getU_name()) ;
		nameField.setEditable(false) ;
		JComboBox boxCardType = new JComboBox(new String[]{"���֤","ѧ��֤","����֤"}) ;
		JTextField cardNumField = new JTextField(user.getU_idcard()) ;
		cardNumField.setEditable(false) ;
		JTextField telNumField = new JTextField(user.getU_telephone()) ;
		telNumField.setEditable(false) ;
		top.add(id) ;
		top.add(type) ;
		top.add(price) ;
		top.add(name) ;
		top.add(cardType) ;
		top.add(cardNum) ;
		top.add(telNum) ;
		
		top.add(idField) ;
		top.add(boxType) ;
		top.add(priceField) ;
		top.add(nameField) ;
		top.add(boxCardType) ;
		top.add(cardNumField) ;
		top.add(telNumField) ;
		//top.setOpaque(false) ;
		center.add(top,BorderLayout.NORTH) ;
		//���� 
		boxType.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(remainType.size()!=0){
					//�в�λ
					String string = (String)boxType.getSelectedItem() ;
					for(Seat seat :selectSeat){
						if(seat.getS_type().equals(string)){
							priceField.setText(seat.getS_price()+"") ;
							break ;
						}
					}
				}
			}
		}) ;
		
		//�м���һ��
		//JPanel c = new JPanel() ;
		String s = "<html>1.һ����Ч���֤��ͬһ�˳�����ͬһ����ֻ�ܹ���һ�ų�Ʊ�� <br>2.��Ʊʱ��ʹ�õ���Ч���֤���������л����񹲺͹��������֤���۰ľ��������ڵ�ͨ��֤��̨�����������½ͨ��֤�Ͱ��涨��ʹ�õ���Ч���ա�<br>3. �����ͯƱʱ���˳���ͯ����Ч���֤���ģ�����д������Ч���֤����Ϣ���˳���ͯû����Ч���֤���ģ�Ӧʹ��ͬ�г����˵���Ч���֤����Ϣ����Ʊʱ����ǰ�����ƣ�<br>4.����Ʊ�󡢿���ǰ�����Ʊ�������ɽ�վ�˳��� <br>5.����ѧ��Ʊʱ�������ҵĳ�����ϵ���еǼǳ˳��˵�ѧ����ϸ��Ϣ��ѧ��Ʊ�˳�ʱ����Ϊÿ������6��1����9��30�ա�����12��1����3��31�ա���Ʊ�󡢿���ǰ�������Ʊ�������ɽ�վ�˳�����Ʊʱ������ƾ¼ȡ֪ͨ�飬��ҵ��ƾѧУ����֤��������ƾѧ���Żݿ��� <br>����м����ˣ��˲о��죩�Ŵ�Ʊ�ģ����ڹ�Ʊ�󡢿���ǰ����Ʊ�������ɽ�վ�˳�����Ʊʱ�������Ϲ涨�ļ����Ŵ�������û����Ч�л����񹲺͹��м�����֤���л�<br>���񹲺͹��˲����񾯲�֤�ģ����軻Ʊ��������Ʊ���涨������Ʊ������</html>";
		JLabel text = new JLabel(s) ;
		center.add(text) ;
		
		JPanel bottom = new JPanel() ;
		bottom.setOpaque(false) ;
		JButton reSelect = new JButton("����ѡ��");
		reSelect.addActionListener(this) ;
		reSelect.setFont(Tookit.getFont1()) ;
		reSelect.setBackground(new Color(0xA9CAF3)) ;
		JButton cancelSelect = new JButton("ȡ������");
		cancelSelect.addActionListener(this) ;
		cancelSelect.setFont(Tookit.getFont1()) ;
		cancelSelect.setBackground(new Color(0xA9CAF3)) ;
		JButton subSelect = new JButton("�ύ����");
		subSelect.addActionListener(this) ;
		subSelect.setFont(Tookit.getFont1()) ;
		subSelect.setBounds(180, 220, 120, 30) ;
		subSelect.setBackground(new Color(0xA9CAF3)) ;
		bottom.add(reSelect) ;
		bottom.add(cancelSelect) ;
		bottom.add(subSelect) ;
		center.add(bottom,BorderLayout.SOUTH) ;
		jPanel.add(center) ;
		//������һ����panel
		JPanel blankbottom = new JPanel() ;
		blankbottom.setOpaque(false) ;
		blankbottom.setPreferredSize(new Dimension(Tookit.getScreen().width,103)) ;
		jPanel.add(blankbottom,BorderLayout.SOUTH) ;
		return jPanel ;
	}
	
	public JPanel fourPanel(){
		
		JPanel jPanel = new JPanel(new BorderLayout()) ;
		jPanel.setOpaque(false) ;
		//������һ����panel
		JPanel blankTop = new JPanel() ;
		blankTop.setOpaque(false) ;
		blankTop.setPreferredSize(new Dimension(Tookit.getScreen().width,103)) ;
		jPanel.add(blankTop,BorderLayout.NORTH) ;
		
		JPanel center = new JPanel(new BorderLayout()) ;
		center.setOpaque(false) ;
		 jlTop = new JLabel() ;
		jlTop.setOpaque(false) ;
		
		center.add(jlTop,BorderLayout.NORTH) ;//�м䱱��
		
		//�м���һ��janel
		//����
		 c = new JPanel() ;
		 c.setOpaque(false) ;
		 center.add(c) ;//�м���м�
		 //�м���ϲ�
		 JPanel jPanel3 = new JPanel(new GridLayout(2, 1)) ;
		  jPanel3.setOpaque(false) ;
		  
		 JLabel jlBottom = new JLabel("<html>1.����ѡ��֧�����С�����ʹ���й��������С��й�ũҵ���С��й����С��������С��й��������е����п���֧����ֱ�ӵ����Ӧ���е�<br>��ť�������ʹ���������е����п����������й���������ť��<br>2.�����֧�����к󣬽���������ҳ�档������������й涨���в�������������ҳ���Ͻ��е��κβ�������������κη��ɺ����������<br>��������֮��ǩ���ĺ�ͬ��������վ���е��κ����Ρ�</html>") ;
		 jPanel3.add(jlBottom) ;
		 
	 	JPanel jPanel2 = new JPanel() ;
	 	jPanel2.setOpaque(false) ;
		JButton reSelect1 = new JButton("����ѡ��");
		reSelect1.addActionListener(this) ;
		reSelect1.setFont(Tookit.getFont1()) ;
		reSelect1.setBackground(new Color(0xA9CAF3)) ;
		
		JButton onLine = new JButton("����֧��");
		onLine.addActionListener(this) ;
		onLine.setFont(Tookit.getFont1()) ;
		onLine.setBounds(180, 220, 120, 30) ;
		onLine.setBackground(new Color(0xA9CAF3)) ;
		jPanel2.add(reSelect1) ;
		jPanel2.add(onLine) ;
		jPanel3.add(jPanel2) ;
		
		//jPanel3.add(jlBottom) 
		center.add(jPanel3,BorderLayout.SOUTH) ;
		
		jPanel.add(center) ;
		//������һ����panel
		JPanel blankbottom = new JPanel() ;
		blankbottom.setOpaque(false) ;
		blankbottom.setPreferredSize(new Dimension(Tookit.getScreen().width,103)) ;
		jPanel.add(blankbottom,BorderLayout.SOUTH) ;
		return jPanel ;
	}
	/**
	 * ��ʼ��ѯ
	 */
	public void query (){
		
		String startCity = null ,endCity = null,startDate = null,startTime ;
		if(!isGoing){
			//��ʾ �ǵ�һ��ҳ�����
			System.out.println("-------");
			startCity = this.jtf1.getText().trim() ;
			 endCity = this.jtf2.getText().trim();
			 startDate = this.jtf3.getText().trim() ;//��Ҫ�� �ж�
			 startTime  = (String)this.jcBox.getSelectedItem() ;
			
		}else {
			startCity = this.jtf1_1.getText().trim() ;
			 endCity = this.jtf2_1.getText().trim();
			 startDate = this.jtf3_1.getText().trim() ;//��Ҫ�� �ж�
			 startTime  = (String)this.jcBox_1.getSelectedItem() ;
		}
		//���
		System.out.println(startTime);
		String str[] = startTime.split("-") ;
		//�ж� �ǲ���ȫΪ��
		if(startCity.equals("") || endCity.equals("") || startDate.equals("")){
			JOptionPane.showMessageDialog(TicketSearchPanel.this, "���������ݣ���") ;
			return ;
		}
		//��������ǲ�������
		if(!checkInfo.isTrue(startDate)){
			JOptionPane.showMessageDialog(null, "���ڲ���ȷ�����������룡") ;
			return ;
		}
		isGoing = true ;
		card.show(ticketSearchPanel, "two") ;

		//���ȸ��� �������и�������� ������� ���·�ߵĺ���ص���Id
	
		String sql = "select * from flight_addr where a_city=?" ;
		String[] paraStartCity = {startCity} ;
		String[] paraEndCity = {endCity};
		//������� �������еĺ���ص�Id��
		Vector<FlightAddr> startCityIds = dataHandle.quertyMulInfo(sql, paraStartCity) ;
		//���Ϊ��null������ʾ û�и������� ����������������Ҫת�С�������
		//������� ������еĺ���ص�Id��
		Vector<FlightAddr> endCityIds = dataHandle.quertyMulInfo(sql, paraEndCity) ;
		
		//������� ��  �ӳ������е�������� ���� �ɻ���Ϣ
		fInfos = dataHandle.queryMulFlightInfo(startCityIds, endCityIds,str) ;
		
		if(fInfos.size()==0){
			//��ʾû��ֱ��ķɻ�
			JLabel jLabel = new JLabel("<html>û��ֱ��ɻ����Ƿ�<font color=#FF0000 size=7>ת��</font></html>",JLabel.CENTER) ;
			
			jLabel.setFont(Tookit.getFont2()) ;
			jsp.setViewportView(jLabel) ;
			//Ԥ����ť���ɼ�
			order.setEnabled(false) ;
		}else {
			order.setEnabled(true) ;
			//������� �������ɻ�����λ��ϸ��Ϣ
			seats = new Vector<Vector<Seat>>() ;
			for(FlightInfo fInfo:fInfos){
				Vector<Seat> seat = dataHandle.querySeatsInfo("select * from seat where f_number=?", new String[]{fInfo.getF_number()},fInfo) ;
				seats.add(seat) ;
//				System.out.println(fInfo.getF_number()+"   "+fInfo.getF_start().getA_city()+"    "+fInfo.getF_start().getA_air()+"   "+fInfo.getF_end().getA_city()+"   " +fInfo.getF_end().getA_air()+"   "+fInfo.getF_start_time()+"  "+fInfo.getF_end_time());
			}
			//����һ������ģ��
			//��һ��jtable 
			jTable = new JTable();
			stmModel = new SearchTableModel(seats,startDate) ;
			this.jTable.setModel(stmModel) ;
			//MyButtonRenderer   buttonRenderer= new MyButtonRenderer(jTable, 12) ;
			
			//jTable.getColumn("��Ʊ").setCellRenderer(buttonRenderer) ;//���� һ��button ��Jtable��
			jTable.setRowHeight(60) ;
			jTable.setBackground(new Color(0xA9CAF3)) ;
			jsp.setViewportView(jTable);
		}	
	}
	
	public void order(){
		

		//�õ� ѡ�е���
		int selectedRow = jTable.getSelectedRow() ;
		if(selectedRow==-1){
			JOptionPane.showMessageDialog(null, "����ѡ ��һ�н���Ԥ��") ;
			return ;
		}
	
		//������������� ��
		//�õ�User��Ϣ 
		//�õ� Seat��Ϣ
		String selectFlightId = (String)stmModel.getValueAt(selectedRow, 0) ;
		//�ж����jtf3_1.getText().trim()����  �Ƿ��к��ද̬ 
		String state =dataHandle.queryOneString("select fs_state from state where fs_date=? and fs_number=?", new String[]{jtf3_1.getText().trim(),selectFlightId}) ;
		System.out.println(state);
		if(state!=null){
			if(state.matches(".*ȡ��.*|.*�ӳ�.*|.*�Ƴ�.*")){
				JOptionPane.showMessageDialog(null, "�˺�����"+jtf3_1.getText().trim()+"�ѱ�ȡ��,���ע���ද̬��Ϣ") ;
				return ;
			}
		}
		for(FlightInfo fInfo: fInfos){
			if(fInfo.getF_number().equals(selectFlightId)){
				selectFlightInfo = fInfo ;
				break;
			}
		}
		for (Vector<Seat> v : seats) {
			for(Seat seat:v){
				if(seat.getfInfo().equals(selectFlightInfo)){
					selectSeat = v ;
					break ;
				}
			}
		}
		if(selectFlightInfo==null || selectSeat==null){
			JOptionPane.showMessageDialog(null, "���ݳ�����") ;
			return ;
		}
		//ѡ�������  ���ò�  �����  ͷ�Ȳ�
		String num1 = (String)stmModel.getValueAt(selectedRow, 8) ;
		String num2 = (String)stmModel.getValueAt(selectedRow, 9) ;
		String num3 = (String)stmModel.getValueAt(selectedRow, 10) ;
		//JOptionPane.showMessageDialog(null,jTable.getColumnName(8) ) ;
		//System.out.println(num1+"  "+num2+"  "+num3);
		remainType.removeAllElements() ;//�Ƴ����� ��Ԫ ��  ��ֹ �����ٴε���
		if(num1.matches("[1-9][0-9]*")){
			//��ʾ ���ò���Ʊ
			System.out.println(num1);
			remainType.add(jTable.getColumnName(8)) ;
		}
		if(num2.matches("[1-9][0-9]*")){
			//��ʾ ���ò���Ʊ
			remainType.add(jTable.getColumnName(9)) ;
		}
		if(num3.matches("[1-9][0-9]*")){
			//��ʾ ���ò���Ʊ
			remainType.add(jTable.getColumnName(10)) ;
		}
		System.out.println(remainType.size());
		boxType.setSelectedIndex(0) ;
		idField.setText(selectFlightId)  ;
		
		card.show(ticketSearchPanel, "three") ;
		//�õ� 
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() instanceof JLabel){
			
			bankName = ((JLabel)e.getSource()).getText().trim() ; 
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource() instanceof JLabel){
			JLabel mjlJLabel = ((JLabel)e.getSource()) ;
			mjlJLabel.setEnabled(true) ;
			mjlJLabel.setForeground(Tookit.getColor()) ;
			mjlJLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JLabel){
			JLabel mjlJLabel = ((JLabel)e.getSource()) ;
			mjlJLabel.setEnabled(false) ;
			mjlJLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)) ;
		}
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
