package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import otcyan.java.bean.Bank;
import otcyan.java.bean.FlightInfo;
import otcyan.java.bean.Seat;
import otcyan.java.bean.User;
import otcyan.java.model.DataHandle;
import otcyan.java.model.ReturnTicketModel;
import otcyan.java.tools.ImagePanel;
import otcyan.java.tools.Tookit;

public class ModifyTicketPanel extends JPanel implements ActionListener{
	


	private ImagePanel iPanel = null ;
	private CardLayout card = null ;
	private JButton queryButton, unButton ,backButton= null ;
	private JScrollPane jsp ;
	private DataHandle dataHandle ;
	private JTable jTable ;
	//private JButton resetButton  = null ;
	private User user  ;
	public ModifyTicketPanel(User user){
		dataHandle = new DataHandle() ;
		this.user = user ;
		this.init();
	}
	
	public JPanel onePanel(){
		JPanel jp = new JPanel(null) ;//�ղ���
		jp.setOpaque(false) ;
		
		JLabel jl1 = new JLabel("��    ����",JLabel.RIGHT) ;
		jl1.setBounds(230, 217, 84, 18) ;
		jl1.setFont(Tookit.getFont1()) ;
		JTextField jtf1 = new JTextField(user.getU_name()) ;
		jtf1.setEditable(false) ;
		jtf1.setBounds(320, 217, 174, 22) ;
		
		JLabel jl2 = new JLabel("���֤���룺",JLabel.RIGHT) ;
		jl2.setBounds(230, 260, 84, 18) ;
		jl2.setFont(Tookit.getFont1()) ;
		JTextField jtf2 = new JTextField(user.getU_idcard()) ;
		jtf2.setEditable(false) ;
		jtf2.setBounds(320, 260, 174, 22) ;
		
		
		queryButton = new JButton("��ʼ��ѯ");
		queryButton.addActionListener(this) ;
		queryButton.setFont(Tookit.getFont1()) ;
		queryButton.setBounds(230,300,120,30) ;
		queryButton.setBackground(new Color(0xA9CAF3)) ;
//		resetButton = new JButton("����") ;
//		resetButton.addActionListener(this) ;
//		resetButton.setBackground(new Color(0xA9CAF3)) ;
//		resetButton.setFont(Tookit.getFont1()) ;
//		resetButton.setBounds(380, 300, 120, 30) ;
		
		jp.add(jl1) ;
		jp.add(jtf1);
		jp.add(jl2) ;
		jp.add(jtf2);
		jp.add(queryButton) ;
//		jp.add(resetButton) ;
		
		return jp ;
	}
	private void init() {
		try {
			card = new CardLayout() ;
			iPanel = new ImagePanel(ImageIO.read(new File("image/returnticket.jpg")),new Dimension(1280,800)) ;
			iPanel.setLayout(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iPanel.add(this.onePanel(),"one") ;
		iPanel.add(this.twoPanel(),"two") ;
		
	}
	public JPanel getJPanel() {
		
		return iPanel;
	}
	
	public JPanel twoPanel(){	
		
		JPanel jp = new JPanel(new BorderLayout());
		jp.setOpaque(false) ;
		//����
		JPanel north = new JPanel() ;
		north.setOpaque(false) ;
		north.setPreferredSize(new Dimension(Tookit.getScreen().width,94)) ;
		jp.add(north,BorderLayout.NORTH) ;
		
		
		//�м�
		JPanel center = new JPanel(new BorderLayout());
		center.setOpaque(false) ;
		JLabel jlName = new JLabel("�û���"+user.getU_name()+"�Ķ�Ʊ��Ϣ",JLabel.CENTER);
		jlName.setFont(Tookit.getFont5()) ;
		jlName.setBackground(Color.red) ;
		center.add(jlName,BorderLayout.NORTH) ;
		
		 jsp = new JScrollPane() ;
		//jScrollPane����͸��
		jsp.setOpaque(false) ;
		jsp.getViewport().setOpaque(false) ;
		center.add(jsp) ;
		jp.add(center) ;
		
		JPanel jpBottom = new JPanel() ;
		jpBottom.setOpaque(false) ;
		 unButton = new JButton("��  ǩ");
		unButton.addActionListener(this) ;
		unButton.setFont(Tookit.getFont1()) ;
		unButton.setBackground(new Color(0xA9CAF3)) ;
		 backButton = new JButton("��   ��") ;
		backButton.addActionListener(this) ;
		backButton.setBackground(new Color(0xA9CAF3)) ;
		backButton.setFont(Tookit.getFont1()) ;
		jpBottom.add(unButton) ;
		jpBottom.add(backButton) ;
		jp.add(jpBottom,BorderLayout.SOUTH) ;
		
		return jp ;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("��ʼ��ѯ")){
			this.query() ;
		}
		if(e.getSource()==backButton){
			card.show(iPanel, "one") ;
		}
		
		if(e.getSource()==unButton){
			//����˶�
			//�õ� ѡ�е���
			int selectedRow = jTable.getSelectedRow() ;
			if(selectedRow==-1){
				JOptionPane.showMessageDialog(null, "��ѡ ��һ�н��и�ǩ") ;
				return ;
			}
		
			String ticketId = (String)jTable.getValueAt(selectedRow, 0) ;
			JOptionPane.showMessageDialog(null, ticketId) ;
			
			//����һ����ǩ�ĶԻ���
			String modifyDate = JOptionPane.showInputDialog(null, "��������Ҫ��ǩ�����ڣ�") ;
			String sql = "select t_seatId from tickets where t_date=? and t_f_number =? and t_type=?" ;
			//�õ��������������λ��
			//System.out.println(jtf3_1.getText().trim()+selectFlightInfo.getF_number()+(String)boxType.getSelectedItem());
			Vector<String> seatIds = dataHandle.queryStringVector(sql, new String[]{modifyDate,(String)jTable.getValueAt(selectedRow, 1),(String)jTable.getValueAt(selectedRow, 4)}) ;
			//������λ 
			//�õ� ѡ���λ������ 
			String seatTotalNumString = dataHandle.queryOneString("select s_number from seat where f_number=? and s_type=?", new String[]{(String)jTable.getValueAt(selectedRow, 1),(String)jTable.getValueAt(selectedRow, 4)}) ;
		     System.out.println("��λ����Ϊ��"+seatTotalNumString);
		     int seatTotalNum = Integer.parseInt(seatTotalNumString) ;
		     //���� ����λ��
		     int sellSeatNum = -1 ;
		     System.out.println("��λ������"+seatTotalNum+"��������"+seatIds);
		     
		     for (int i = 1; i <=seatTotalNum; i++) {
		    	 if(!seatIds.contains(i+"")){
		    		 sellSeatNum = i ;
		    		 break ;
		    	 }
			}
		     if(sellSeatNum==-1){
		    	 JOptionPane.showMessageDialog(null, "�Բ���"+modifyDate+"Ʊ�Ѿ�����") ;
		    	 return ;
		     }
		     
		     //����  ����  ����λ��
		     boolean b = dataHandle.update("update tickets set t_seatId=?,t_date=? where t_id=?", new String[]{sellSeatNum+"",modifyDate,ticketId}) ;
			if(b){
				JOptionPane.showMessageDialog(null, "<html>�޸ĳɹ���<br>��λ��Ϊ�� "+(String)jTable.getValueAt(selectedRow, 4)+"ZX "+sellSeatNum+"<br>���ڣ� "+modifyDate+"</html>") ;
				this.query() ;//����
			}else {
				JOptionPane.showMessageDialog(null, "��ǩʧ�ܣ�") ;
				return ;
			}
		}
	}

	public void query(){

		//����һ��jtable
		jTable = new JTable() ;
		jTable.setRowHeight(50) ;
		jTable.setBackground(new Color(0xA9CAF3)) ;
		//����Ʊ��id�������ĳ���ʱ�� 
		unButton.setEnabled(true) ;
		Vector<String> flightIds= dataHandle.queryStringVector("select t_f_number from tickets where t_uid=?", new String[]{user.getU_id()}) ;
		if(flightIds.size()==0){
			//��ʾ���Id��û��Ʊ
			//��ʾû��ֱ��ķɻ�
			JLabel jLabel = new JLabel("�Բ��𣡣�����û�ж��κ�Ʊ",JLabel.CENTER) ;
			jLabel.setFont(Tookit.getFont5()) ;
			jLabel.setFont(Tookit.getFont2()) ;
			jsp.setViewportView(jLabel) ;
			//Ԥ����ť���ɼ�
			unButton.setEnabled(false) ;
			card.show(iPanel, "two") ;
			return ;
		}
		//������� ��ΪFlihtInfo��Ϣ-----------------------------
		Vector<String> startTimes = new Vector<String>() ;
		for(String flightId:flightIds){
			String startTime = dataHandle.queryOneString("select f_start_time from flight_info where f_number=?", new String[]{flightId}) ;
			startTimes.add(startTime) ;
		}
		ReturnTicketModel returnTicketModel = new ReturnTicketModel("select * from tickets where t_uid=?",new String[]{user.getU_id()},user,startTimes) ;
		jTable.setModel(returnTicketModel) ;
		jsp.setViewportView(jTable) ;
		card.show(iPanel, "two") ;
	
	}


}
