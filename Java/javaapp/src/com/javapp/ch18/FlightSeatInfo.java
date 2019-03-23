package com.javapp.ch18;

import javax.swing.*;
import java.io.*;
import java.sql.*;

/**
 * Description:������λ��Ϣ
 * 

 */
public class FlightSeatInfo {
	private DataBaseManager sqlBean = new DataBaseManager();
	private final int FLIGHT_PER_DAY = 5;// ÿ���·ɺ�����

	public boolean isFull(String flightNum, String day)// �ж���λ�Ǽ���
	{
		try {
			System.out.println("�ж���λ�Ǽ���");
			long index = cacuIndex(day);
			long address = cacuAddr(flightNum);
			long absoluteAddress = index + address;
			String sql = "select * from seat where seatnumber="
					+ absoluteAddress + "";
			java.sql.Statement st = sqlBean.getDb().createStatement();
			java.sql.ResultSet rs = st.executeQuery(sql);
			int bookedSeats = 0;
			if (rs.next())
				bookedSeats = rs.getInt("bookedSeats");
			st.close();
			String sqlString = "select seat from flightTick where flight='"
					+ flightNum + "'";
			rs = sqlBean.executeQuery(sqlString);
			int totalSeats = 0;
			while (rs.next())
				totalSeats = rs.getInt(1);
			rs.close();

			if (totalSeats == bookedSeats)
				return true;// ����
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}

	public int dingPiao(String flightNum, String day, int seats)// ����Ʊ
	{
		int leftSeats = 0;
		try {
			int index = (int) cacuIndex(day);
			int address = (int) cacuAddr(flightNum);
			int absoluteAddress = index + address;

			String sql = "select * from seat where seatnumber="
					+ absoluteAddress + "";
			java.sql.Statement st = sqlBean.getDb().createStatement();
			java.sql.ResultSet rs = st.executeQuery(sql);
			int bookedSeats = 0;// ������λ��
			if (rs.next())
				bookedSeats = rs.getInt("bookedSeats");
			st.close();

			String sqlString = "select seat,week from flightTick where flight='"
					+ flightNum + "' ";
			rs = sqlBean.executeQuery(sqlString);
			int totalSeats = 0;
			String week = "";//����
			while (rs.next()) {
				totalSeats = rs.getInt(1);
				week = rs.getString(2);
			}

			String c = isAbsence(day);// �Ƿ��ڰ�����
			int flag = 0;
			for (int i = 0; i < week.length(); i++) {
				String w = week.substring(i, i + 1);
				if (c.equals(w)) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				leftSeats = totalSeats - bookedSeats;// ʣ�µ���λ
				if (leftSeats >= seats) {
					String sqls = "insert into seat(seatnumber,bookedSeats) values(?,?)";
					java.sql.Connection con = sqlBean.getDb();
					java.sql.PreparedStatement pst = con.prepareStatement(sqls);
					pst.setInt(1, absoluteAddress);
					pst.setInt(2, bookedSeats + seats);
					pst.execute();
					con.commit();
					pst.close();
					con.close();
					return -1;
				} else
					return leftSeats;// ����
			} else
				return -2;// ���ڰ�����

		} catch (Exception e) {
			e.printStackTrace();
		}
		return leftSeats;
	}

	public void tuiPiao(String flightNum, String day, int seats)// ��Ʊ
	{
		try {
			int index = (int) cacuIndex(day);
			int address = (int) cacuAddr(flightNum);
			int absoluteAddress = index + address;

			String sql = "select * from seat where seatnumber="
					+ absoluteAddress + "";
			java.sql.Statement st = sqlBean.getDb().createStatement();
			java.sql.ResultSet rs = st.executeQuery(sql);
			int bookedSeats = 0;// ������λ��
			if (rs.next())
				bookedSeats = rs.getInt("bookedSeats");
			st.close();
			if (bookedSeats < seats)
				JOptionPane.showMessageDialog(null, "��Ʊ�������Ѷ�Ʊ��!", "������Ϣ",
						JOptionPane.ERROR_MESSAGE);
			else {
				String sqls = "update seat set bookedSeats=? where seatnumber="
					+ absoluteAddress + " ";
				java.sql.Connection con = sqlBean.getDb();
				java.sql.PreparedStatement pst = con.prepareStatement(sqls);
				pst.setInt(1, bookedSeats - seats);
				pst.execute();
			    con.commit();
				pst.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long cacuIndex(String day) {// ����ÿ�յ�����ֵ
		System.out.println(day);
		String d = day.substring(8, 10);
		long index = Long.parseLong(d);// ��
		return (index - 1) * 4 * FLIGHT_PER_DAY;
	}

	public long cacuAddr(String flightNum) {
		long remark = 0;
		try {
			String sqlString = "select remark from flightTick where flight='"
					+ flightNum + "'";
			ResultSet rs = sqlBean.executeQuery(sqlString);
			while (rs.next())
				remark = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (remark - 1) * 4;
	}

	private String timeToWeek(String year, String month, String day) {// ʱ��ת��Ϊ��
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(java.sql.Date.valueOf(year + "-" + month + "-" + day));
		int week = cal.get(java.util.Calendar.DAY_OF_WEEK_IN_MONTH);
		return String.valueOf(week);
	}

	private String isAbsence(String date) {//�������ڻ����
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8, 10);
		String week = timeToWeek(year, month, day);
		return week;

	}
}