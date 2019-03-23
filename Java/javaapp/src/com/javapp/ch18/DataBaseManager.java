package com.javapp.ch18;

import java.io.*;
import java.sql.*;

/**
 * Description:数据库连接类

 */
public class DataBaseManager {
	private Connection conn = null;
	private ResultSet rs = null;
	// 连接数据库
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

	// 查询数据
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

	// 添加数据
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

	// 删除数据
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

	//更新数据
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

	// 关闭连接
	public void CloseDataBase() {
		try {
			conn.close();
		} catch (Exception e) {e.printStackTrace();
		}
	}
}