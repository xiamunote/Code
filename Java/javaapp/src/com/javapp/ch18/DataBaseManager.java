package com.javapp.ch18;

import java.io.*;
import java.sql.*;

/**
 * Description:���ݿ�������

 */
public class DataBaseManager {
	private Connection conn = null;
	private ResultSet rs = null;
	// �������ݿ�
	public Connection getDb() {
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="
				+ this.getClass().getResource("./").getPath().substring(1)
				+ "/flight.mdb";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "", "");
		} catch (SQLException ex1) {
			ex1.printStackTrace();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		}
		return conn;
	}

	// ��ѯ����
	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			conn = getDb();
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	// �������
	public int executeInsert(String sql) {
		int num = 0;
		try {
			conn = getDb();
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException ex) {ex.printStackTrace();
		}

		return num;
	}

	// ɾ������
	public int executeDelete(String sql) {
		int num = 0;
		try {
			conn = getDb();
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();
		}

		return num;
	}

	//��������
	public int executeUpdate(String sql) {
		int num = 0;
		try {
			conn = getDb();
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();
		}

		return num;
	}

	// �ر�����
	public void CloseDataBase() {
		try {
			conn.close();
		} catch (Exception e) {e.printStackTrace();
		}
	}
}