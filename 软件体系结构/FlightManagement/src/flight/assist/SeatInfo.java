package flight.assist;

import java.sql.*;
import javax.swing.*;
/**
 * �������ݿ��orderedSeats�ĸ����࣬�����жϺ����Ƿ�������ˢ�º�����Ԥ����Ʊ��
 */
public class SeatInfo {
  DataBaseManager dbManager = DataBaseManager.getInstance();
  public SeatInfo() {
  }
  /**
   *�жϺ����Ƿ�����
   */
  public boolean isFull(String flightNum, String day) {
    String sqlString = "select orderedSeats from orderedSeats where flight='" +
        flightNum +
        "' and flightdate='" + day + "'";
    ResultSet rs = dbManager.getResult(sqlString);
    try {
      if (!rs.next()) {//��һ�յĺ�����δ¼�룬¼��˺���
        sqlString = "insert into orderedSeats values('" + flightNum + "','" +
            day + "',0)";
        dbManager.updateSql(sqlString);
        return false;
      }
      else {//��ѯ�Ѷ�Ʊ���ͺ����������Ӷ��жϺ����Ƿ�����
        int orderSeats = rs.getInt(1);
        sqlString = "select seat from flight where flight='" + flightNum + "'";
        rs = dbManager.getResult(sqlString);
        int totalSeats = 0;
        if (rs.next())
          totalSeats = rs.getInt(1);
        if (totalSeats == orderSeats)
          return true;
        else
          return false;
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   *��Ʊ�����Ӻ����Ѷ�Ʊ��
   */
  public int bookTicket(String flightNum, String day, int seats) {
    int leftSeats = 0;

    String sql = "select orderedSeats from orderedSeats where flight='" +
        flightNum +
        "' and flightdate='" + day + "'";
    ResultSet rs = dbManager.getResult(sql);
    int bookedSeats = 0;
    try {
      if (rs.next()) {
        bookedSeats = rs.getInt(1);
      }
      else {
        JOptionPane.showMessageDialog(null, "������Ϣ��δ¼��!",
                                      "������Ϣ", JOptionPane.ERROR_MESSAGE);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    String sqlString = "select seat,week from flight where flight='" +
        flightNum + "' ";
    rs = dbManager.getResult(sqlString);
    int totalSeats = 0;
    String week = "";
    try {
      while (rs.next()) {
        totalSeats = rs.getInt(1);
        week = rs.getString(2);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    leftSeats = totalSeats - bookedSeats;

    if (leftSeats >= seats) {
      sql = "update orderedSeats set orderedSeats=" + (bookedSeats + seats) +
          "where flight='" + flightNum +
          "' and flightdate='" + day + "'";
      dbManager.updateSql(sql);
      return -1;
    }
    else
      return leftSeats;
  }

  /**
   *��Ʊ�����ٺ����Ѷ�Ʊ��
  */
  public void refundTicket(String flightNum, String day, int seats) {
    String sql = "select orderedSeats from orderedSeats where flight='" +
        flightNum +
        "' and flightdate='" + day + "'";
    ResultSet rs = dbManager.getResult(sql);
    int bookedSeats = 0;
    try {
      if (rs.next()) {
        bookedSeats = rs.getInt(1);
      }
      else {
        JOptionPane.showMessageDialog(null, "������Ϣ��δ¼��!",
                                      "������Ϣ", JOptionPane.ERROR_MESSAGE);
        return;
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    if (bookedSeats < seats){
      JOptionPane.showMessageDialog(null, "��Ʊ�������Ѷ�Ʊ��!",
                                    "������Ϣ", JOptionPane.ERROR_MESSAGE);
      return;
    }
    else {
      sql = "update orderedSeats set orderedSeats=" + (bookedSeats - seats) +
          "where flight='" + flightNum +
          "' and flightdate='" + day + "'";
      dbManager.updateSql(sql);
    }
  }
}
