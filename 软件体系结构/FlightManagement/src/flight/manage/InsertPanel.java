package flight.manage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import flight.assist.DataBaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ���뺽����Ϣ
 */
public class InsertPanel
    extends JPanel {
  DataBaseManager dbManager = DataBaseManager.getInstance();
  private JTextField[] textFields = new JTextField[12];
  private JLabel[] labels = new JLabel[12];
  private JButton[] buttons = new JButton[3];
  private JComboBox hourComboBox1, hourComboBox2, minComboBox1, minComboBox2;

  public InsertPanel() {
    hourComboBox1 = new JComboBox();
    hourComboBox2 = new JComboBox();
    minComboBox1 = new JComboBox();
    minComboBox2 = new JComboBox();
    for (int i = 1; i <= 24; i++) {
      if (i < 10) {
        hourComboBox1.addItem("" + 0 + i);
        hourComboBox2.addItem("" + 0 + i);
      }
      else {
        hourComboBox1.addItem("" + i);
        hourComboBox2.addItem("" + i);
      }
    }
    for (int i = 0; i <= 59; i++) {
      if (i < 10) {
        minComboBox1.addItem("" + 0 + i);
        minComboBox2.addItem("" + 0 + i);
      }
      else {
        minComboBox1.addItem("" + i);
        minComboBox2.addItem("" + i);
      }
    }

    JPanel p3 = new JPanel();
    p3.add(hourComboBox1);
    p3.add(new JLabel("ʱ"));
    p3.add(minComboBox1);
    p3.add(new JLabel("��"));

    JPanel p4 = new JPanel();
    p4.add(hourComboBox2);
    p4.add(new JLabel("ʱ"));
    p4.add(minComboBox2);
    p4.add(new JLabel("��"));

    JPanel p1 = new JPanel();
    p1.setBorder(new TitledBorder("������Ϣ"));
    p1.setLayout(new GridLayout(6, 4, 5, 5));
    p1.add(labels[0] = new JLabel("�����"));
    p1.add(textFields[0] = new JTextField(10));
    p1.add(labels[1] = new JLabel("����"));
    p1.add(textFields[1] = new JTextField(10));
    p1.add(labels[0] = new JLabel("��˾"));
    p1.add(textFields[2] = new JTextField(10));
    p1.add(labels[0] = new JLabel("��λ"));
    p1.add(textFields[3] = new JTextField(10));
    p1.add(labels[0] = new JLabel("��ɵ�"));

    p1.add(textFields[4] = new JTextField(10));
    p1.add(labels[0] = new JLabel("�ִ��"));
    p1.add(textFields[5] = new JTextField(10));
    p1.add(labels[0] = new JLabel("���ʱ��"));
    p1.add(p3);
    p1.add(labels[0] = new JLabel("�ִ�ʱ��"));
    p1.add(p4);
    p1.add(labels[0] = new JLabel("��ͯƱ��"));
    p1.add(textFields[8] = new JTextField(10));
    p1.add(labels[0] = new JLabel("����Ʊ��"));
    p1.add(textFields[9] = new JTextField(10));
    p1.add(labels[0] = new JLabel("��ǰ�ۿ�"));
    p1.add(textFields[10] = new JTextField(10));
    textFields[10].setText("1.0");//������
    textFields[10].setEditable(false);
    p1.add(labels[0] = new JLabel("��Ʊ��"));
    p1.add(textFields[11] = new JTextField(10));
    textFields[11].setText("0.7");//������
    textFields[11].setEditable(false);

    JPanel p2 = new JPanel();
    p2.setBorder(new TitledBorder("����"));
    p2.add(buttons[0] = new JButton("����"));
    this.setLayout(new BorderLayout());
    this.add(p1, BorderLayout.CENTER);
    this.add(p2, BorderLayout.SOUTH);

    buttons[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (textFields[0].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "�ؼ��ֲ���Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[2].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "��˾Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[3].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "��λ��Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[4].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "��ɵ�Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[5].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "�ִ��Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[8].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "��ͯƱ����Ϣ����Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[9].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "����Ʊ����Ϣ����Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[10].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "��ǰ�ۿ���Ϣ����Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        if (textFields[11].getText().length() == 0) {
          JOptionPane.showMessageDialog(null, "��Ʊ����Ϣ����Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);
          return;
        }

        else {
          int maxremark = 1;
          String sql = "select remark from flight";
          ResultSet rs = dbManager.getResult(sql);
          int remark = 0;
          try {
            while (rs.next()) {
              remark = rs.getInt(1);
              if (remark > maxremark) maxremark = remark;
            }
          }
          catch (SQLException sqle) {
            System.out.println(sqle.toString());
          }
          catch (Exception ex) {
            System.out.println(ex.toString());
          }
          String time1 = (String) hourComboBox1.getSelectedItem() +
              (String) minComboBox1.getSelectedItem();
          String time2 = (String) hourComboBox2.getSelectedItem() +
              (String) minComboBox2.getSelectedItem();
          maxremark = maxremark + 1; //ID
          sql = "insert into flight values('" + textFields[0].getText() +
              "','" + textFields[2].getText() + "','" +
              textFields[4].getText() + "','" + textFields[5].getText() + "','" + time1 +
              "','" +
              time2 + "'," + Float.parseFloat(textFields[8].getText().trim()) + "," +
              Float.parseFloat(textFields[9].getText().trim()) + ","
              + Float.parseFloat(textFields[10].getText().trim()) + "," +
              Float.parseFloat(textFields[11].getText().trim()) + "," +
              Integer.parseInt(textFields[3].getText().trim())
              + ",'" + textFields[1].getText() + "'," + maxremark + ")";

          int affectedNum=dbManager.updateSql(sql);
          if(affectedNum>0)
             JOptionPane.showMessageDialog(null, "�����¼�ɹ���");
          else
            JOptionPane.showMessageDialog(null, "�����¼ʧ�ܣ�");
        }
      }
    });
  }
}
