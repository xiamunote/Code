package otcyan.java.model;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import oracle.net.aso.e;

import otcyan.java.bean.FlightInfo;
import otcyan.java.bean.Seat;
import otcyan.java.tools.DBHelp;
import otcyan.java.tools.Tookit;
/**
 * ��ѯ������ �� ������Ϣ ���ŵ�table����
 * @author Administrator
 *
 */
public class SearchTableModel extends AbstractTableModel{

	//�е���
	private Vector<String> col  ;
	//�е���
	private Vector<Vector> rows ; 
	private DataHandle dataHandle = null ;
	private String[] types={"���ò�","�����","ͷ�Ȳ�"};
	private int count = 0 ;
	
	public SearchTableModel(Vector<Vector<Seat>> seats,String startDate){
		dataHandle = new DataHandle() ;
		col = new Vector<String>() ;
		rows = new Vector<Vector>() ;
		this.initData(seats,startDate) ;
	}
	
	@SuppressWarnings("unchecked")
	public void initData(Vector<Vector<Seat>> seats,String startDate){
		
		//�õ� �ܹ��ж����е�����
		//Ϊ�и�ֵ
		col.add("�����") ;
		col.add("�������") ;
		col.add("������") ;
		col.add("Ŀ�ĵ�") ;
		col.add("ʼ������") ;
		col.add("�������") ;
		col.add("����ʱ�� ") ;
		col.add("�ﵽʱ��") ;
		col.add("���ò�") ;
		col.add("�����") ;
		col.add("ͷ�Ȳ�") ;
		col.add("���չ�˾") ;
		col.add("��Ʊ") ;
			
		//Ϊÿ�и�ֵ
		for(Vector<Seat> v: seats) {
			System.out.println(v.size());
			 FlightInfo fInfo = v.get(1).getfInfo() ;
			 Vector row = new Vector() ;
			 row.add(fInfo.getF_number()) ;
			 row.add(fInfo.getF_type())  ;
			 row.add(fInfo.getF_start().getA_city()) ;
			 row.add(fInfo.getF_end().getA_city()) ;
			 row.add(fInfo.getF_start().getA_air()) ;
			 row.add(fInfo.getF_end().getA_air()) ;
			 row.add(fInfo.getF_start_time()) ;
			 row.add(fInfo.getF_end_time()) ;
			 //��λ����
			 
			 for(Seat seat:v){
				 System.out.println(seat);
				// row.add(seat.getS_number()) ;//ÿһ�е��� ���ò�,����գ�ͷ�Ȳյ���λ����
				 String type = types[count++] ;
				 System.out.println(type);
				 String paras[] = {startDate,fInfo.getF_number(),type}; //
				 //��ѯ������ ����λ��Id
				 Vector<String> seatIds = dataHandle.queryStringVector("select t_seatId from tickets where t_date=? and t_f_number =? and t_type=?", paras) ;
				 
				 if(seat.getS_number().matches("\\d+")){
					 System.out.println("===========");
					 //��ʾ�д���λ ����  --
					 row.add(Integer.parseInt(seat.getS_number())-seatIds.size()+"") ;
				 }else{
					 row.add(seat.getS_number()) ;
				 }
				 
			 }
			 count=0 ;//count����
			 row.add(fInfo.getF_company()) ;
			 row.add("Ԥ��") ;
			 rows.add(row) ;
		}
		
	}
	
	@Override
	public int getColumnCount() {
		return col.size();
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)rows.get(rowIndex)).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		//String[] name = {"�����","����","����ʱ��","�ﵽʱ��","ʼ������","Ŀ�ĵ�","���չ�˾"};
		return col.get(column) ;
	}

}
