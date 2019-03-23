package otcyan.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

import otcyan.java.model.DataHandle;
import otcyan.java.tools.ImagePanel;
import otcyan.java.tools.Tookit;

public class SalesCountPanel{

	private ImagePanel iPanel = null ;
	private JButton queryButton,backButton,queryButton_1;
	private CardLayout card ;
	private DataHandle dataHandle;
	private JComboBox jcbox1 ,jcbox1_1;
	private JPanel c ;
	private String[] year ;
	
	public SalesCountPanel(){
		card = new CardLayout();
		dataHandle = new DataHandle();
		this.init();
	}
	private void init() {
		try {
			iPanel = new ImagePanel(ImageIO.read(new File("image/statistic.jpg")),new Dimension(1008,697)) ;
			iPanel.setLayout(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iPanel.add(this.onePanel(),"one") ;
		iPanel.add(this.twoPanel(),"two") ;
	}
	
	public ImagePanel getiPanel() {
		return iPanel;
	}
	public JPanel onePanel(){
		JPanel jp = new JPanel(null) ;//�ղ���
		jp.setOpaque(false) ;
		
		year = new String[13]  ;
		year[0] = "�� ��";
		for (int i = 2002; i <=2013; i++) {
			year[i-2001] = i+"" ;
		}
//		String[] month = new String[13]  ;
//		month[0] = "�� ��";
//		for (int i = 1; i <=12; i++) {
//			month[i] = i+"�·�" ;
//		}
		
		JLabel jl1 = new JLabel("������ݣ�",JLabel.RIGHT) ;
		jl1.setBounds(230, 217, 84, 18) ;
		jl1.setFont(Tookit.getFont1()) ;
		jcbox1=new JComboBox(year);
		jcbox1.setEditable(false) ;
		jcbox1.setBounds(320, 217, 174, 22) ;
		
		
		queryButton = new JButton("��ʼ��ѯ");
		queryButton.setFont(Tookit.getFont1()) ;
		queryButton.setBounds(230,300,120,30) ;
		queryButton.setBackground(new Color(0xA9CAF3)) ;
		
		jp.add(jl1) ;
		jp.add(jcbox1);
		jp.add(queryButton) ;
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SalesCountPanel.this.query(jcbox1) ;
			}
		});
//		jp.add(resetButton) ;
		
		return jp ;
	}


	public void query(JComboBox jcBox){

		c.removeAll() ;
		String checkYear=(String)(jcBox.getSelectedItem());
		System.out.println(checkYear);
		if(!checkYear.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "��ѡ��һ�����") ;
			return ;
		}
//		DefaultPieDataset dpd=new DefaultPieDataset(); //����һ��Ĭ�ϵı�ͼ
//		String sql = null ;
//		for (int i = 1; i <=12; i++) {
//			sql="select count(*) from tickets where t_date like ?";
//			String s = dataHandle.queryOneString(sql, new String[]{checkYear+"-0"+i+"%"}) ;
//			System.out.println(s+"======");
//			dpd.setValue(i+"�·�", Integer.parseInt(s));  //��������
//		}
//		
//        JFreeChart chart = ChartFactory.createPieChart3D("���չ�˾����ͳ��", dpd, true, true, false) ;
//       //modify chart
//        PiePlot3D plot = (PiePlot3D)chart.getPlot();
//        
//        plot.setBackgroundAlpha(0f) ;
//        plot.setStartAngle(285.0); //change started Angle
//        //JFreeChart chart=ChartFactory.createPieChart("ĳ��˾��Ա��֯����ͼ",dpd,true,true,false); 
//        //���Բ�����API�ĵ�,��һ�������Ǳ��⣬�ڶ���������һ�����ݼ���������������ʾ�Ƿ���ʾLegend�����ĸ�������ʾ�Ƿ���ʾ��ʾ�������������ʾͼ���Ƿ����URL 
//        ChartPanel chartPanel = new ChartPanel(chart) ;
//        chartPanel.setOpaque(false) ;
        c.add(this.getChartPanel(checkYear)) ;
        c.validate();
        c.repaint() ;
        
        card.show(iPanel, "two") ;
	
	}
	/**
	 * �õ�����ͼ
	 * @param checkYear
	 * @return
	 */
	private ChartPanel getChartPanel(String checkYear) {
		
		TimeSeries ts = new TimeSeries("����",Month.class) ;
	
		TimeSeriesCollection tsCollection = new TimeSeriesCollection() ;
		String sql = null ;
		for (int i = 1; i <=12; i++) {
			sql="select count(*) from tickets where t_date like ?";
			String s ;
			if(i<10){
				 s= dataHandle.queryOneString(sql, new String[]{checkYear+"-0"+i+"%"}) ;
			}else {
				 s= dataHandle.queryOneString(sql, new String[]{checkYear+"-"+i+"%"}) ;
			}
			System.out.println(s+"======");
			ts.add(new Month(i, Integer.parseInt(checkYear)), Integer.parseInt(s));
		}
		tsCollection.addSeries(ts) ;
		JFreeChart chart = ChartFactory.createTimeSeriesChart("��Ʊ������", "�·�", "����", tsCollection, true, true, false) ;
		
		//�����ӱ���
		chart.setTitle(new TextTitle("2013��")) ;
		XYPlot xyPlot = (XYPlot)chart.getPlot() ;//�õ� xy��
		xyPlot.setDomainGridlinePaint(Color.red) ;//���� ������ɫ
		xyPlot.setRangeGridlinePaint(Color.orange) ;//���� 
		//���� ��
		ValueAxis vx = xyPlot.getDomainAxis() ;
		//vx.setRange(0.0D,2000D) ;
		vx.setAutoRange(true) ;
		//�������� 
		XYLineAndShapeRenderer xr=(XYLineAndShapeRenderer)xyPlot.getRenderer();
		xr.setSeriesPaint(0, Color.blue);//�����ߵ���ɫ
		xr.setBaseShapesVisible(true);//��ʾ���ϸ������ݵ�
		//��ʾ���ݵ�������ֵ��
		xr.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator()) ;
		xr.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_RIGHT)) ;
		xr.setBaseItemLabelsVisible(true);
		ChartPanel cp=new ChartPanel(chart);
		return cp ;
	}
	public JPanel twoPanel(){
		
		JPanel twoPanel = new JPanel(new BorderLayout()) ;
		twoPanel.setOpaque(false) ;
		
		JPanel north = new JPanel() ;
		north.setOpaque(false) ;
		north.setPreferredSize(new Dimension(Tookit.getScreen().width,94)) ;
		twoPanel.add(north,BorderLayout.NORTH) ;
		
		//�м�
		JPanel center = new JPanel(new BorderLayout()) ;
		center.setOpaque(false) ;
		//��
		JPanel jpTop = new JPanel() ;
		jpTop.setOpaque(false) ;

		JLabel jl1_1 = new JLabel("������ݣ�",JLabel.RIGHT) ;
		jl1_1.setFont(Tookit.getFont1()) ;
		jcbox1_1=new JComboBox(year);
		jcbox1_1.setPreferredSize(new Dimension(100,30)) ;
		jcbox1_1.setEditable(false) ;
			
		queryButton_1 = new JButton("��ʼ��ѯ");
		queryButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SalesCountPanel.this.query(jcbox1_1) ;
			}
		}) ;
		queryButton_1.setFont(Tookit.getFont1()) ;
		queryButton_1.setBounds(230,300,120,30) ;
		queryButton_1.setBackground(new Color(0xA9CAF3)) ;
		jpTop.add(jl1_1) ;
		jpTop.add(jcbox1_1) ;
		jpTop.add(queryButton_1) ;
		
		//��
		c = new JPanel() ;
		c.setOpaque(false) ;
		center.add(jpTop,BorderLayout.NORTH) ;
		center.add(c) ;
		twoPanel.add(center) ;
		
		JPanel jpBottom = new JPanel() ;
		jpBottom.setOpaque(false) ;
		 backButton = new JButton("��   ��") ;
			backButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					card.show(iPanel, "one") ;
				}
			}) ;
			backButton.setBackground(new Color(0xA9CAF3)) ;
			backButton.setFont(Tookit.getFont1()) ;
			jpBottom.add(backButton) ;
		twoPanel.add(jpBottom,BorderLayout.SOUTH) ;
		
		return twoPanel ;
	}



}
