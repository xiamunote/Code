package flight.assist;

import java.sql.*;
/**
 * 数据库访问辅助类，使用了Singleton软件设计模式
 */
public class DataBaseManager {
  private static DataBaseManager instance;
  private Connection con;
  private ResultSet rs;
  private Statement stmt;

  public static DataBaseManager getInstance() {
    if (instance == null) {
      instance = new DataBaseManager();
    }
    return instance;
  }

  private DataBaseManager() {
    try {
      String url = "jdbc:odbc:flight";
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      con = DriverManager.getConnection(url);
      stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                 ResultSet.CONCUR_UPDATABLE);
    }
    catch (SQLException sqle) {
      System.out.println(sqle.toString());
    }
    catch (ClassNotFoundException cnfex) {
      cnfex.printStackTrace();
    }
  }

  public ResultSet getResult(String strSQL) {
    try {
      rs = stmt.executeQuery(strSQL);
      return rs;
    }
    catch (SQLException sqle) {
      System.out.println(sqle.toString());
      return null;
    }

  }

  public int updateSql(String strSQL) {
    try {
      int i = stmt.executeUpdate(strSQL);
      con.commit();
      return i;
    }
    catch (SQLException sqle) {
      System.out.println(sqle.toString());
      return -1;
    }
  }

  public void closeConnection() {
    try {
      con.close();
      this.instance=null;
    }
    catch (SQLException sqle) {
      System.out.println(sqle.toString());
    }
  }
}
