package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInit {
	Connection db ;
	public DatabaseInit()
	{
		String sql1 = "create table if not exists register ("
				+ "id int(4) not null auto_increment, username char(20) not null ,"
				+ "password char(15) not null, email char(30) not null,nickname char(10)  not null,"
				+ "idcard char(20) not null,submission_date DATE,head char(10) not null,state char(10) not null,money int(10) not null default 2000, primary key(id))";
		
		String sql2 = "create table if not exists register2 ("
				+ "id int(4) not null auto_increment, username char(20) not null ,"
				+ "password char(15) not null, email char(30) not null,nickname char(10)  not null,"
				+ "idcard char(20) not null,submission_date DATE,head char(10) not null,state char(10) not null,primary key(id))";
		String sql3= "create table if not exists flight("
				+ "id int(4) not null auto_increment, primary key(id),flightID char(10) not null ,"
				+ "fromTime char(20) not null,toTime char(20)  not null,date char(20) not null,"
				+ "fromAddr char(30) not null,toAddr char(30) not null,firm char(20) not null,jingjiPrice char(10) not null,"
				+ "toudengPrice char(10) not null,jingjiNum int(10) not null,toudengNum int(10) not null,ontimeRate char(10) not null,"
				+ "beginPlace char(10) not null,destePlace char(10) not null,count int(6) not null)";

		//�����ڲŲ���
		String sql4 = "insert ignore into flight values(3,'MR5678','10:00','18:10','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','�Ϸ�����','800','1000',250,150,'90%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql5 = "insert ignore into flight values(4,'KF7654','06:00','17:00','2018-1-11������','������̫ƽ���ʻ���','�����������ʻ��� ','���麽��','450','100',180,120,'99%','������','����',1) on duplicate key update count=count+1";
		String sql6 = "insert ignore into flight values(5,'SN6789','07:00','16:00','2018-1-10������','������ɽ����','����ңǽ���� ','��������','789','1087',200,100,'88%','����','����',1) on duplicate key update count=count+1";
		String sql7 = "insert ignore into flight values(6,'SR5543','09:00','15:00','2018-1-10������','����������','���ͺ��ذ������� ','���麽��','345','567',240,160,'95%','���','���ͺ���',1) on duplicate key update count=count+1";
		String sql8 = "insert ignore into flight values(7,'SB7765','10:00','18:50','2018-1-10������','�����Ӷ����� ','�������׻��� ','�Ϸ�����','245','500',300,100,'98%','����','����',1) on duplicate key update count=count+1";
		String sql9 = "insert ignore into flight values(8,'SJ9965','11:00','19:50','2018-1-10������','�����׶����� ','�Ϻ��ֶ����� ','�Ϸ�����','245','500',300,100,'98%','����','�Ϻ�',1) on duplicate key update count=count+1";
		String sql10 = "insert ignore into flight values(9,'SV8900','12:00','19:23','2018-1-10������','�����׼Ұӻ���','�ɶ�˫������ ','�й�����','234','345',150,150,'92%','����','�ɶ�',1) on duplicate key update count=count+1";
		String sql11 = "insert ignore into flight values(10,'XC7765','11:00','18:00','2018-1-10������','���콭������','������������ ','�Ϸ�����','356','788',300,50,'99%','����','����',1) on duplicate key update count=count+1";
		String sql12 = "insert ignore into flight values(11,'IJ8874','06:00','19:10','2018-1-10������','�Ϻ��ֶ�����','�ϲ��������ʻ��� ','�Ϻ�����','358','890',200,100,'100%','�Ϻ�','�ϲ�',1) on duplicate key update count=count+1";
		String sql13 = "insert ignore into flight values(12,'KI0018','09:00','18:20','2018-1-10������','�ϲ��������ʻ���','�����������ʻ��� ','��������','456','550',200,20,'95%','�ϲ�','����',1) on duplicate key update count=count+1";
		String sql14 = "insert ignore into flight values(13,'HG7729','07:00','18:30','2018-1-10������','�ϲ��������ʻ���','����ңǽ���� ','�Ϸ�����','789','1087',200,100,'88%','�ϲ�','����',1) on duplicate key update count=count+1"; 
		String sql15 = "insert ignore into flight values(14,'HB5428','05:00','23:10','2018-1-10������','�ϲ��������ʻ���','�����׶����� ','��������','345','500',560,280,'99%','�ϲ�','����',1) on duplicate key update count=count+1";
		String sql16 = "insert ignore into flight values(15,'BC5822','10:00','18:10','2018-1-10������','�����׶�����','�Ϻ��ֶ����� ','�й�����','890','1000',400,100,'94%','����','�Ϻ�',1) on duplicate key update count=count+1";
		String sql17 = "insert ignore into flight values(16,'OL0183','09:00','17:50','2018-1-10������','�����׶�����','�ϲ��������ʻ���','�Ϸ�����','560','890',250,50,'97%','����','�ϲ�',1) on duplicate key update count=count+1";
		String sql18 = "insert ignore into flight values(17,'BV6720','07:00','14:40','2018-1-10������','�Ϻ��ֶ�����','����ңǽ���� ','��������','900','1200',300,50,'99%','�Ϻ�','����',1) on duplicate key update count=count+1";
		String sql19 = "insert ignore into flight values(18,'AS7633','08:00','19:50','2018-1-10������','�Ϻ��ֶ�����','�ϲ��������ʻ��� ','��������','999','1299',230,70,'90%','�Ϻ�','�ϲ�',1) on duplicate key update count=count+1";
		String sql20 = "insert ignore into flight values(19,'VC6722','06:00','13:40','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','��������','1000','1200',250,100,'90%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql21 = "insert ignore into flight values(20,'VD7633','06:00','14:30','2018-1-10������','�����׶�����','�Ϻ��ֶ����� ','��������','578','890',350,150,'87%','����','�Ϻ�',1) on duplicate key update count=count+1";
		String sql22 = "insert ignore into flight values(21,'MN9272','07:00','22:30','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','�Ϸ�����','789','900',200,100,'89%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql23 = "insert ignore into flight values(22,'KL9252','10:00','23:30','2018-1-10������','�����׶�����','�Ϻ��ֶ����� ','�Ϻ�����','345','700',200,100,'98%','����','�Ϻ�',1) on duplicate key update count=count+1";
		String sql24 = "insert ignore into flight values(23,'SV6293','04:00','19:20','2018-1-10������','�����׶�����','�Ϻ��ֶ����� ','���麽��','233','456',240,100,'92%','����','�Ϻ�',1) on duplicate key update count=count+1";
		String sql25 = "insert ignore into flight values(24,'MO0353','08:00','23:10','2018-1-10������','�Ϻ��ֶ�����','�ϲ��������ʻ��� ','�й�����','899','999',140,60,'92%','�Ϻ�','�ϲ�',1) on duplicate key update count=count+1";
		String sql26 = "insert ignore into flight values(25,'AF5678','05:00','18:50','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','��������','234','456',200,150,'94%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql27 = "insert ignore into flight values(26,'YF6306','09:00','12:30','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','�й�����','444','788',250,150,'95%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql28 = "insert ignore into flight values(27,'CX5638','14:00','21:40','2018-1-10������','�����׶�����','�Ϻ��ֶ����� ','�Ϻ�����','667','987',250,150,'99%','����','�Ϻ�',1) on duplicate key update count=count+1";
		String sql29 = "insert ignore into flight values(28,'GB6205','13:00','22:50','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','�Ϻ�����','900','1223',250,150,'88%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql30 = "insert ignore into flight values(29,'JN7729','12:00','20:00','2018-1-10������','�ϲ��������ʻ���','�����׶����� ','���麽��','899','1000',50,150,'91%','�ϲ�','����',1) on duplicate key update count=count+1";
		String sql31 = "insert ignore into flight values(30,'LK9346','11:00','21:30','2018-1-10������','�Ϻ��ֶ�����','�����׶����� ','��������','800','1000',250,150,'98%','�Ϻ�','����',1) on duplicate key update count=count+1";
		String sql32 = "insert ignore into flight values(31,'MQ9184','10:00','17:20','2018-1-10������','�ϲ��������ʻ���','�Ϻ��ֶ����� ','�Ϻ�����','567','800',250,150,'97%','�ϲ�','�Ϻ�',1) on duplicate key update count=count+1";
		String sql33 = "insert ignore into flight values(32,'SR5543','09:00','15:00','2018-1-10������','����������','���ͺ��ذ��� ','���麽��','700','888',240,160,'96%','���','���ͺ���',1) on duplicate key update count=count+1";
		String sql34 = "insert ignore into flight values(33,'SR5543','09:00','16:00','2018-1-10������','�����׶�����','�ϲ��������ʻ��� ','���麽��','800','888',240,160,'96%','����','�ϲ�',1) on duplicate key update count=count+1";
		
		
		
		PreparedStatement pstmt1,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7,pstmt8,pstmt9,pstmt10,pstmt11,pstmt12,pstmt13,pstmt14,pstmt15,pstmt16,pstmt17,pstmt18,pstmt19,pstmt20,pstmt21,pstmt22,pstmt23,pstmt24,pstmt25,pstmt26,pstmt27,
		pstmt28,pstmt29,pstmt30,pstmt31,pstmt32,pstmt33,pstmt34=null;	
				try {
				db= SqlUtil.open();
				pstmt1 = db.prepareStatement(sql1);
				pstmt1.executeUpdate();
				pstmt2 = db.prepareStatement(sql2);
				pstmt2.executeUpdate();
				pstmt3 = db.prepareStatement(sql3);
				pstmt3.executeUpdate();
				pstmt4 = db.prepareStatement(sql4);
				pstmt4.executeUpdate();
				pstmt5 = db.prepareStatement(sql5);
				pstmt5.executeUpdate();
				pstmt6 = db.prepareStatement(sql6);
				pstmt6.executeUpdate();
				pstmt7 = db.prepareStatement(sql7);
				pstmt7.executeUpdate();
				pstmt8 = db.prepareStatement(sql8);
				pstmt8.executeUpdate();
				pstmt9 = db.prepareStatement(sql9);
				pstmt9.executeUpdate();
				pstmt10 = db.prepareStatement(sql10);
				pstmt10.executeUpdate();
				pstmt11= db.prepareStatement(sql11);
				pstmt11.executeUpdate();
				pstmt12 = db.prepareStatement(sql12);
				pstmt12.executeUpdate();
				pstmt13 = db.prepareStatement(sql13);
				pstmt13.executeUpdate();
				pstmt14 = db.prepareStatement(sql14);
				pstmt14.executeUpdate();
				pstmt15 = db.prepareStatement(sql15);
				pstmt15.executeUpdate();
				pstmt16 = db.prepareStatement(sql16);
				pstmt16.executeUpdate();
				pstmt17 = db.prepareStatement(sql17);
				pstmt17.executeUpdate();
				pstmt18 = db.prepareStatement(sql18);
				pstmt18.executeUpdate();
				pstmt19 = db.prepareStatement(sql19);
				pstmt19.executeUpdate();
				pstmt20 = db.prepareStatement(sql20);
				pstmt20.executeUpdate();
				pstmt21 = db.prepareStatement(sql21);
				pstmt21.executeUpdate();
				pstmt22 = db.prepareStatement(sql22);
				pstmt22.executeUpdate();
				pstmt23 = db.prepareStatement(sql23);
				pstmt23.executeUpdate();
				pstmt24 = db.prepareStatement(sql24);
				pstmt24.executeUpdate();
				pstmt25 = db.prepareStatement(sql25);
				pstmt25.executeUpdate();
				pstmt26 = db.prepareStatement(sql26);
				pstmt26.executeUpdate();
				pstmt27 = db.prepareStatement(sql27);
				pstmt27.executeUpdate();
				pstmt28 = db.prepareStatement(sql28);
				pstmt28.executeUpdate();
				pstmt29 = db.prepareStatement(sql29);
				pstmt29.executeUpdate();
				pstmt30 = db.prepareStatement(sql30);
				pstmt30.executeUpdate();
				pstmt31 = db.prepareStatement(sql31);
				pstmt31.executeUpdate();
				pstmt32 = db.prepareStatement(sql32);
				pstmt32.executeUpdate();
				pstmt33 = db.prepareStatement(sql33);
				pstmt33.executeUpdate();
				pstmt34 = db.prepareStatement(sql34);
				pstmt34.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					SqlUtil.close(db);
				}
	}

}
