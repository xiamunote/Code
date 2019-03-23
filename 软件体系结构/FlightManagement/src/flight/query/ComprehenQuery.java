package flight.query;

import flight.assist.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 * ������Ϣ��ѯ���ۺϲ�ѯ
 */
public class ComprehenQuery
    extends JPanel
    implements ActionListener {
  DataBaseManager dbManager = DataBaseManager.getInstance();

  private JComboBox startComboBox = new JComboBox(),
      firstArriveComboBox = new JComboBox(),
      arriveComboBox = new JComboBox(), airFirmComboBox = new JComboBox();
   private JRadioButton jrbSingle = new JRadioButton("����", true),
       jrbDouble = new JRadioButton("����", false),
       jrbMutiple = new JRadioButton("����", false);
  private JLabel jlFirstArriveLabel, jlArriveLabel,jlStartLabel,jlReplaceArriveLabel,jlAirFirmLabel;
  private JPanel jpFirstArrivePanel, jpReplaceArrivePanel, jpArrivePanel1;
  private JButton jbQueryButton = new JButton("��ѯ");

  private String startStr, firstArriveStr, arriveStr, airFirmStr;

  public ComprehenQuery() {
    airFirmComboBox.addItem("����");
    airFirmComboBox.setSelectedItem("����");

    JPanel jp1 = new JPanel();
    jp1.add(jrbSingle);
    JPanel jp2 = new JPanel();
    jp2.add(jrbDouble);
    JPanel jp3 = new JPanel();
    jp3.add(jrbMutiple);

    JPanel jpRadioButton = new JPanel();
    jpRadioButton.setLayout(new GridLayout(5, 1));
    jpRadioButton.add(new JLabel("       "));
    jpRadioButton.add(jp1);
    jpRadioButton.add(jp2);
    jpRadioButton.add(jp3);
    jpRadioButton.add(new JLabel("       "));

    ButtonGroup bg = new ButtonGroup();
    bg.add(jrbSingle);
    bg.add(jrbDouble);
    bg.add(jrbMutiple);


    JPanel jpStart = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    jpStart.add(jlStartLabel = new JLabel("        ��������:"));

    JPanel jpFirstArrive = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    jpFirstArrive.add(jlFirstArriveLabel = new JLabel("                "));

    JPanel jpArrive = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    jpArrive.add(jlArriveLabel = new JLabel("        �������:"));

    JPanel jpAirFirm = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    jpAirFirm.add(jlAirFirmLabel = new JLabel("       ���չ�˾:"));

    JPanel jpLabels = new JPanel();
    jpLabels.setLayout(new GridLayout(7, 1));
    jpLabels.add(jpStart);
    jpLabels.add(jpFirstArrive);
    jpLabels.add(jpArrive);

    jpLabels.add(new JLabel("            "));
    jpLabels.add(jpAirFirm);
    jpLabels.add(new JLabel("            "));

    JPanel jpStartBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpStartBox.add(startComboBox);

    jpReplaceArrivePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpReplaceArrivePanel.add(jlReplaceArriveLabel = new JLabel("            "));

    jpArrivePanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpArrivePanel1.add(firstArriveComboBox);

    jpFirstArrivePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
    jpFirstArrivePanel.add(jpReplaceArrivePanel);

    JPanel jpArriveBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpArriveBox.add(arriveComboBox);

    JPanel jpAirFirmBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpAirFirmBox.add(airFirmComboBox);

    JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
    jpButton.add(jbQueryButton);

    JPanel jpComboBox = new JPanel();
    jpComboBox.setLayout(new GridLayout(7, 1));
    jpComboBox.add(jpStartBox);
    jpComboBox.add(jpFirstArrivePanel);
    jpComboBox.add(jpArriveBox);
    jpComboBox.add(new JLabel("            "));
    jpComboBox.add(jpAirFirmBox);
    jpComboBox.add(jpButton);

    JPanel jpQuery = new JPanel();
    jpQuery.setLayout(new BorderLayout());
    jpQuery.add(jpLabels, BorderLayout.WEST);
    jpQuery.add(jpComboBox, BorderLayout.CENTER);

    JPanel jpDown = new JPanel();
    jpDown.setLayout(new BorderLayout());
    jpDown.add(jpRadioButton, BorderLayout.WEST);
    jpDown.add(jpQuery, BorderLayout.CENTER);

    JLabel jlTitle = new JLabel("�ۺϲ�ѯ");
    jlTitle.setHorizontalAlignment(JLabel.CENTER);
    jlTitle.setFont(new Font("Tims", Font.BOLD, 23));
    this.setLayout(new BorderLayout());
    this.add(jlTitle, BorderLayout.NORTH);
    this.add(jpDown, BorderLayout.CENTER);


    jrbSingle.addActionListener(new RadioListener());
    jrbDouble.addActionListener(new RadioListener());
    jrbMutiple.addActionListener(new RadioListener());

    jbQueryButton.addActionListener(this);
    initComboxes();
  }

  /**
   *��ʼ������Ͽ��ֵ
  */
  private void initComboxes() {
    String sql = "Select DISTINCT start from flight";
    ResultSet rs = dbManager.getResult(sql);
    rs = dbManager.getResult(sql);
    try {
      while (rs.next()) {
        String startCity = rs.getString(1);
        this.startComboBox.addItem(startCity);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    sql = "Select DISTINCT destination from flight";
    rs = dbManager.getResult(sql);
    try {
      while (rs.next()) {
        String destinationCity = rs.getString(1);
        this.arriveComboBox.addItem(destinationCity);
        this.firstArriveComboBox.addItem(destinationCity);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    sql = "Select DISTINCT airfirm from flight";
    rs = dbManager.getResult(sql);
    try {
      while (rs.next()) {
        String firm = rs.getString(1);
        this.airFirmComboBox.addItem(firm);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

  class RadioListener
      implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (jrbSingle.isSelected()) {
        jlFirstArriveLabel.setText("            ");
        jpFirstArrivePanel.removeAll();
        jpFirstArrivePanel.add(jpReplaceArrivePanel);
        jpFirstArrivePanel.repaint();
        jlArriveLabel.setText("    �������:");
      }
      else if (jrbDouble.isSelected()) {
        jlFirstArriveLabel.setText("            ");
        jpFirstArrivePanel.removeAll();
        jpFirstArrivePanel.add(jpReplaceArrivePanel);
        jpFirstArrivePanel.repaint();

        jlArriveLabel.setText("    �������:");
      }
      else if (jrbMutiple.isSelected()) {
        jlFirstArriveLabel.setText("��һ�������:");
        jpFirstArrivePanel.removeAll();
        jpFirstArrivePanel.add(jpArrivePanel1);
        jpFirstArrivePanel.repaint();
        jlArriveLabel.setText("�ڶ��������:");
      }
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (jrbSingle.isSelected()) {//����
      startStr = (String) startComboBox.getSelectedItem();
      startStr = startStr.trim();

      arriveStr = (String) arriveComboBox.getSelectedItem();
      arriveStr = arriveStr.trim();

      airFirmStr = (String) airFirmComboBox.getSelectedItem();
      airFirmStr = airFirmStr.trim();

      executeSingleQuery();
    }
    else if (jrbDouble.isSelected()) {//˫��
      startStr = (String) startComboBox.getSelectedItem();
      startStr = startStr.trim();

      arriveStr = (String) arriveComboBox.getSelectedItem();
      arriveStr = arriveStr.trim();

      airFirmStr = (String) airFirmComboBox.getSelectedItem();
      airFirmStr = airFirmStr.trim();

      executeDoubleQuery();
    }
    else if (jrbMutiple.isSelected()) {//����
      startStr = (String) startComboBox.getSelectedItem();
      startStr = startStr.trim();

      firstArriveStr = (String) firstArriveComboBox.getSelectedItem();
      firstArriveStr = firstArriveStr.trim();

      arriveStr = (String) arriveComboBox.getSelectedItem();
      arriveStr = arriveStr.trim();

      airFirmStr = (String) airFirmComboBox.getSelectedItem();
      airFirmStr = airFirmStr.trim();

      executeMutipleQuery();
    }
  }
  /**
   *ִ�е����ۺϲ�ѯ
  */
  public void executeSingleQuery() {
    String sqlString = formSQLString(startStr, arriveStr);
    ResultSet rs = dbManager.getResult(sqlString);
    showResult("�����ۺϲ�ѯ", rs);
  }

  /**
  *ִ��˫���ۺϲ�ѯ
  */
  public void executeDoubleQuery() {
    String sqlString1 = formSQLString(startStr, arriveStr);
    ResultSet rs1 = dbManager.getResult(sqlString1);
    DefaultTableModel model1=constructTableModel(rs1);
    String sqlString2 = formSQLString(arriveStr, startStr);
    ResultSet rs2 = dbManager.getResult(sqlString2);
    DefaultTableModel model2=constructTableModel(rs2);
    showResult("�����ۺϲ�ѯ", model1, model2);
  }

  /**
  *ִ�������ۺϲ�ѯ
  */
  public void executeMutipleQuery() {
    String sqlString1 = formSQLString(startStr, firstArriveStr);
    ResultSet rs1 = dbManager.getResult(sqlString1);
    DefaultTableModel model1=constructTableModel(rs1);
    String sqlString2 = formSQLString(firstArriveStr, arriveStr);
    ResultSet rs2 = dbManager.getResult(sqlString2);
    DefaultTableModel model2=constructTableModel(rs2);
    showResult("�����ۺϲ�ѯ", model1, model2);
  }

  /**
   *����SQL���
   */
  public String formSQLString(String begin, String end) {
    String sqlString = "SELECT DISTINCT * FROM " + "flight " +
        "WHERE start=" + "\'" + begin + "\'" + " AND " +
        "destination=" + "\'" + end + "\'";
    if (!airFirmStr.equals("����"))
      sqlString += " AND " + "airFirm=" + "\'" + airFirmStr + "\'";
    return sqlString;
  }

  /**
  *�Ե���ʽ��ʾ��ѯ���
  */
  public void showResult(String title, ResultSet rs) {
    ResultTable table = new ResultTable(title, rs);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //��Ļ��С
    table.setLocation( (d.width - table.getSize().width) / 2,
                      (d.height - table.getSize().height) / 2);
    table.show();
  }

  /**
   *��˫��ʽ��ʾ��ѯ���
   */
  public void showResult(String title, DefaultTableModel model1, DefaultTableModel model2) {
    ResultTable table = new ResultTable(title, model1, model2);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //��Ļ��С
    table.setLocation( (d.width - table.getSize().width) / 2,
                      (d.height - table.getSize().height) / 2);
    table.show();
  }

  private DefaultTableModel constructTableModel(ResultSet rs1) {
    String[] name = {
        "�����", "��˾", "��ɵ�", "Ŀ�ĵ�", "���ʱ��", "����ʱ��", "��ͯƱ��", "����Ʊ��", "�ۿ�", "��Ʊ��","����"};
    String[][] data = new String[0][0];
    DefaultTableModel defaultModel = new DefaultTableModel(data, name);

    try{
      while (rs1.next()) {
        Vector vector = new Vector();
        vector.addElement(rs1.getString(1));
        vector.addElement(rs1.getString(2));
        vector.addElement(rs1.getString(3));
        vector.addElement(rs1.getString(4));
        vector.addElement(rs1.getString(5));
        vector.addElement(rs1.getString(6));
        vector.addElement(rs1.getString(7));
        vector.addElement(rs1.getString(8));
        vector.addElement(rs1.getString(9));
        vector.addElement(rs1.getString(10));
        vector.addElement(rs1.getString(12));
        defaultModel.addRow(vector);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    return defaultModel;
  }
} ///:~
