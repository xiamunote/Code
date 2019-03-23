package flight.query;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import flight.assist.*;
/**
 * ������Ϣ��ѯ����ͨ��ѯ
 */
public class CommonQuery
    extends JPanel
    implements ActionListener, ItemListener {
  DataBaseManager dbManager = DataBaseManager.getInstance();

  private JTextField flightField = new JTextField(8);
  private JButton flightQueryButton = new JButton("��ѯ");
  private JButton airFirmQueryButton = new JButton("��ѯ");
  private JComboBox flightComboBox = new JComboBox();
  private JComboBox airFirmComboBox = new JComboBox();
  private JComboBox destinationComboBox = new JComboBox();
  private JComboBox startComboBox = new JComboBox();
  private JComboBox arriveComboBox = new JComboBox();
  private JButton placeQueryButton1 = new JButton("��ѯ"),
      placeQueryButton2 = new JButton("��ѯ");

  private String flightNumber;
  private String airfirm;
  private String destination, start, arrive;

  public CommonQuery() {
    JPanel jpFlight = new JPanel();
    jpFlight.setBorder(new TitledBorder("������Ų�ѯ"));
    jpFlight.add(new JLabel("�����뺽��Ż���б�ѡ��:"));
    jpFlight.add(flightField);
    flightComboBox.setSelectedItem(null);
    jpFlight.add(flightComboBox);
    jpFlight.add(flightQueryButton);

    JPanel jpAirFirm = new JPanel();
    jpAirFirm.setBorder(new TitledBorder("�����չ�˾��ѯ"));
    jpAirFirm.add(new JLabel("��ѡ������Ҫ��ѯ�ĺ��չ�˾����:"));
    jpAirFirm.add(airFirmComboBox);
    jpAirFirm.add(airFirmQueryButton);

    JPanel jp1 = new JPanel();
    jp1.add(new JLabel("��ѡ������Ҫ�����Ŀ�ĵ�:"));
    jp1.add(destinationComboBox);
    jp1.add(new JLabel("    "));
    jp1.add(placeQueryButton1);

    JPanel jpPlace1 = new JPanel();
    jpPlace1.setLayout(new BorderLayout());
    jpPlace1.add(new JLabel("��ѯ����һ:"), BorderLayout.NORTH);
    jpPlace1.add(jp1, BorderLayout.CENTER);

    JPanel jp2 = new JPanel();
    jp2.add(new JLabel("��������:"));
    jp2.add(startComboBox);
    jp2.add(new JLabel("�ִ����:"));
    jp2.add(arriveComboBox);
    jp2.add(placeQueryButton2);

    JPanel jpPlace2 = new JPanel();
    jpPlace2.setLayout(new BorderLayout());
    jpPlace2.add(new JLabel("��ѯ������:"), BorderLayout.NORTH);
    jpPlace2.add(new JLabel("��ѡ����ʼ���к͵ִ���н��в�ѯ:"), BorderLayout.CENTER);
    jpPlace2.add(jp2, BorderLayout.SOUTH);

    JPanel jpDestin = new JPanel();
    jpDestin.setBorder(new TitledBorder("��Ŀ�ĵز�ѯ"));
    jpDestin.setLayout(new BorderLayout());
    jpDestin.add(jpPlace1, BorderLayout.NORTH);
    jpDestin.add(jpPlace2, BorderLayout.CENTER);

    this.setLayout(new BorderLayout());
    this.add(jpFlight, BorderLayout.NORTH);
    this.add(jpAirFirm, BorderLayout.CENTER);
    this.add(jpDestin, BorderLayout.SOUTH);

    flightComboBox.addItemListener(this);

    flightQueryButton.addActionListener(this);
    airFirmQueryButton.addActionListener(this);
    placeQueryButton1.addActionListener(this);
    placeQueryButton2.addActionListener(this);
    initComboxes();

  }

  private void initComboxes(){
    String sql="Select DISTINCT flight from flight";
    ResultSet rs=dbManager.getResult(sql);
    try{
      while (rs.next()) {
         String flight=rs.getString(1);
         this.flightComboBox.addItem(flight);
      }
    }catch(Exception e){
      e.printStackTrace();
    }

    sql="Select DISTINCT start from flight";
    rs=dbManager.getResult(sql);
    try{
      while (rs.next()) {
         String startCity=rs.getString(1);
         this.startComboBox.addItem(startCity);
      }
    }catch(Exception e){
      e.printStackTrace();
    }

    sql="Select DISTINCT destination from flight";
    rs=dbManager.getResult(sql);
    try{
      while (rs.next()) {
         String destinationCity=rs.getString(1);
         this.arriveComboBox.addItem(destinationCity);
         this.destinationComboBox.addItem(destinationCity);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    sql="Select DISTINCT airfirm from flight";
    rs=dbManager.getResult(sql);
    try{
      while (rs.next()) {
         String firm=rs.getString(1);
         this.airFirmComboBox.addItem(firm);
      }
    }catch(Exception e){
      e.printStackTrace();
    }

  }


  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == flightComboBox) {
      flightField.setText( (String) flightComboBox.getSelectedItem());
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == flightQueryButton) {
      try{
        this.flightNumber = flightField.getText().trim();

        if (flightNumber.length() == 0) {
          JOptionPane.showMessageDialog(null, "�����뺽��Ż��ߴ��б���ѡ��",
                                        "������Ϣ", JOptionPane.ERROR_MESSAGE);
          return;
        }

        executeFlightQuery();
      }catch(Exception ee){
        ee.printStackTrace();
      }
    }

    else if (e.getSource() == airFirmQueryButton) {
      this.airfirm = (String) airFirmComboBox.getSelectedItem();

      executeAirFirmQuery();
    }

    else if (e.getSource() == placeQueryButton1) {
      destination = (String) destinationComboBox.getSelectedItem();
      destination = destination.trim();
      executeDestinQuery(1);
    }

    else if (e.getSource() == placeQueryButton2) {
      start = (String) startComboBox.getSelectedItem();
      start = start.trim();
      arrive = (String) arriveComboBox.getSelectedItem();
      arrive = arrive.trim();
      executeDestinQuery(2);
    }
  }

  public void executeFlightQuery() {

    String sqlString = "SELECT DISTINCT * FROM " +
        "flight " +
        "WHERE flight=" + "\'" + flightNumber + "\'";
    ResultSet rs = dbManager.getResult(sqlString);
    showResult("�������ѯ",rs);

  }

  public void executeAirFirmQuery() {
    String sqlString = "SELECT DISTINCT * FROM " +
        "flight " +
        "WHERE airfirm=" + "\'" + airfirm + "\'";
    ResultSet rs = dbManager.getResult(sqlString);
    showResult("�����չ�˾��ѯ",rs);
  }

  public void executeDestinQuery(int flag) {
    String sqlString = "SELECT DISTINCT * FROM " + "flight ";
    if (flag == 1)
      sqlString += "WHERE destination=" + "\'" + destination + "\'";
    else
      sqlString += "WHERE start=" + "\'" + start + "\'" + " AND " +
          "destination=" + "\'" + arrive + "\'";

     ResultSet rs = dbManager.getResult(sqlString);
     showResult("��Ŀ�ĵز�ѯ",rs);
  }

  public void showResult(String title,ResultSet rs) {
    ResultTable table = new ResultTable(title,rs);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //��Ļ��С
    table.setLocation( (d.width - table.getSize().width) / 2,
                      (d.height - table.getSize().height) / 2);
    table.show();
  }
}
