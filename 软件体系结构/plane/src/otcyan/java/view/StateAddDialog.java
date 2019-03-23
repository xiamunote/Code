package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import otcyan.java.bean.FlightAddr;
import otcyan.java.bean.FlightInfo;
import otcyan.java.model.CheckInfo;
import otcyan.java.model.DataHandle;
import otcyan.java.tools.ImagePanel;
import otcyan.java.tools.Tookit;

public class StateAddDialog extends JDialog implements ActionListener{
	private DataHandle dataHandle;
	private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	private JButton jbConfirm,jbCancel;
	private JComboBox cbFlightId;
	private JTextField txtStartCity,txtEndCity,txtDate;
	private JTextArea taStates;
	private JScrollPane jsp;
	private CheckInfo checkInfo ;
	
	public StateAddDialog(){
		checkInfo = new CheckInfo() ;
		dataHandle = new DataHandle();
		init();
	}
	
	public void init(){
		this.setSize(600, 500) ;
		this.setModal(true);
		this.setLocationRelativeTo(null) ;
		this.setResizable(false) ;
		this.setTitle("�������ද̬") ;
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
		
		//����
		JPanel jpInfos=new JPanel();
		jpInfos.setOpaque(false);
		jpInfos.setLayout(new BorderLayout());
		jpInfos.setPreferredSize(new Dimension(250,100));
		JLabel jlCreateState=new JLabel("�������ද̬",JLabel.CENTER);
		jlCreateState.setForeground(Color.yellow);
		jlCreateState.setFont(Tookit.getFont5());
		jpInfos.add(jlCreateState,BorderLayout.CENTER);
		jPanel.add(jpAll);
		jpInfos.setOpaque(false);
		jpAll.add(jpInfos,BorderLayout.NORTH);
		
		//�м�
		JPanel jpCenter=new JPanel();
		jpCenter.setLayout(new GridLayout(5,2,4,15));
		jpCenter.setOpaque(false);
		JLabel jlFlightId = new JLabel("����ţ�");
		jlFlightId.setFont(Tookit.getFont5()) ;
		jlFlightId.setForeground(Color.YELLOW) ;
		jpCenter.add(jlFlightId);
		Vector<String> allFlightId=dataHandle.queryStringVector("select f_number from flight_info where 1=?", new String[]{"1"});
		cbFlightId = new JComboBox(allFlightId);
		cbFlightId.addActionListener(this);
		cbFlightId.setActionCommand("fid");
		jpCenter.add(cbFlightId);
		JLabel jlStartCity = new JLabel("��ʼ���У�");
		jlStartCity.setFont(Tookit.getFont5());
		jlStartCity.setForeground(Color.yellow);
		jpCenter.add(jlStartCity);
		txtStartCity = new JTextField();
		jpCenter.add(txtStartCity);
		JLabel jlEndCity = new JLabel("������У�");
		jlEndCity.setFont(Tookit.getFont5());
		jlEndCity.setForeground(Color.yellow);
		jpCenter.add(jlEndCity);
		txtEndCity = new JTextField();
		jpCenter.add(txtEndCity);
		JLabel jlDate = new JLabel("��̬����:");
		jlDate.setFont(Tookit.getFont5());
		jlDate.setForeground(Color.yellow);
		jpCenter.add(jlDate);
		txtDate = new JTextField();
		jpCenter.add(txtDate);
		JLabel jlStates = new JLabel("���ද̬������");
		jlStates.setFont(Tookit.getFont5());
		jlStates.setForeground(Color.yellow);
		jpCenter.add(jlStates);
		jsp = new JScrollPane();
		taStates = new JTextArea();
		jsp.setViewportView(taStates);
		jpCenter.add(jsp);
		
		jpAll.add(jpCenter,BorderLayout.CENTER);
		
		//�ײ�
		JPanel jpButtom = new JPanel();
		jpButtom.setOpaque(false);
//		jpButtom.setLayout(new BorderLayout());
//		jpButtom.setPreferredSize(new Dimension(250,100));
		jbConfirm = new JButton("ȷ      ��");
		jbConfirm.addActionListener(this);
		jpButtom.add(jbConfirm);
		jbCancel = new JButton("ȡ      ��");
		jbCancel.addActionListener(this);
		jpButtom.add(jbCancel);
		jpAll.add(jpButtom,BorderLayout.SOUTH);
		
		jPanel.add(jpAll);
		this.add(jPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ѡ�к���ź�
		if(e.getActionCommand().equals("fid")){
			String selectFlightId = (String)cbFlightId.getSelectedItem() ;
			//����Id�鵽 ��ʼ����
			String startAirplane = dataHandle.queryOneString("select f_start from flight_info where f_number=?", new String[]{selectFlightId}) ; 
			String endAirplane = dataHandle.queryOneString("select f_end from flight_info where f_number=?", new String[]{selectFlightId}) ; 
			System.out.println("��ʼ����:"+startAirplane+"    end:"+endAirplane);
			
			//�ȵõ�  FlightAddr ----------->>>>?????????
			FlightAddr startAddr=dataHandle.queryOneFlightAddr("select * from flight_addr where a_id=?", new String[]{startAirplane});
			System.out.println("FlightAddr:"+startAddr);
			String startCity=startAddr.getA_city();
			FlightAddr endAddr=dataHandle.queryOneFlightAddr("select * from flight_addr where a_id=?", new String[]{endAirplane});
			String endCity=endAddr.getA_city();
			//System.out.println("��ʼ����:"+startCity+"    end:"+endCity);
			txtStartCity.setText(startCity);
			txtStartCity.setEditable(false);
			txtEndCity.setText(endCity);
			txtEndCity.setEditable(false);
		}
		//�����ͽ�������ӵ����ݿ�
		if(e.getSource()==jbConfirm){
			String flightId = (String)cbFlightId.getSelectedItem() ;
			String fDate = txtDate.getText();
			String fDiscribe = taStates.getText();
			if(fDate.equals("") || fDiscribe.equals("")){
				JOptionPane.showMessageDialog(null, "��̬���ڻ�̬��������Ϊ�գ�");
				return ;
			}
			
			if(!checkInfo.isTrue(fDate)){
				JOptionPane.showMessageDialog(null, "��ʽ����ȷ,���������룡��") ;
				txtDate.setText("") ;
				return ;
			}
			String sql = "insert into state values(?,?,?)";
			boolean b=dataHandle.update(sql, new String[]{flightId,fDate,fDiscribe});
			if(b){
				int num= JOptionPane.showConfirmDialog(null, "�������ද̬�ɹ����Ƿ������");
				if(num==JOptionPane.YES_OPTION){
					taStates.setText("");
				}else{
					taStates.setText("");
					this.dispose();
					return ;
				}
			}else{
				JOptionPane.showMessageDialog(null, "�������ද̬ʧ�ܣ�");
			}
		}
		//ȡ���ͷ����ϼ��˵�
		if(e.getSource()==jbCancel){
			this.dispose();
			return ;
		}
	}
//	public static void main(String[] args) {
//		new StateAddDialog().setVisible(true);
//		
//	}
}
