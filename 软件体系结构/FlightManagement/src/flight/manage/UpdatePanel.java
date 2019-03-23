package flight.manage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import flight.assist.DataBaseManager;
/**
 * ���ĺ�����Ϣ
 */
public class UpdatePanel
    extends JPanel
    implements ItemListener, ActionListener {
  DataBaseManager dbManager = DataBaseManager.getInstance();

  private JTextField[] textFields = new JTextField[12];
  private JCheckBox[] radios = new JCheckBox[12];
  private JButton buttons = new JButton("ȷ��");
  private int flag = 1;
  private boolean tag = false;

  public UpdatePanel() {
    JPanel p1 = new JPanel();
    p1.setBorder(new TitledBorder("������Ϣ"));
    p1.setLayout(new GridLayout(6, 4, 5, 5));
    p1.add(radios[0] = new JCheckBox("�����    "));
    p1.add(textFields[0] = new JTextField(10));
    p1.add(radios[1] = new JCheckBox("����      "));
    p1.add(textFields[1] = new JTextField(10));
    p1.add(radios[2] = new JCheckBox("��˾      "));
    p1.add(textFields[2] = new JTextField(10));
    p1.add(radios[3] = new JCheckBox("��λ      "));
    p1.add(textFields[3] = new JTextField(10));
    p1.add(radios[4] = new JCheckBox("��ɵ�    "));
    p1.add(textFields[4] = new JTextField(10));
    p1.add(radios[5] = new JCheckBox("�ִ��    "));
    p1.add(textFields[5] = new JTextField(10));
    p1.add(radios[6] = new JCheckBox("���ʱ��  "));
    p1.add(textFields[6] = new JTextField(10));
    p1.add(radios[7] = new JCheckBox("�ִ�ʱ��  "));
    p1.add(textFields[7] = new JTextField(10));
    p1.add(radios[8] = new JCheckBox("��ͯƱ��  "));
    p1.add(textFields[8] = new JTextField(10));
    p1.add(radios[9] = new JCheckBox("����Ʊ��  "));
    p1.add(textFields[9] = new JTextField(10));
    p1.add(radios[10] = new JCheckBox("��ǰ�ۿ�"));
    p1.add(textFields[10] = new JTextField(10));
    p1.add(radios[11] = new JCheckBox("��Ʊ��"));
    p1.add(textFields[11] = new JTextField(10));

    JPanel p2 = new JPanel();
    p2.setBorder(new TitledBorder("����"));
    p2.add(buttons);

    this.setLayout(new BorderLayout());
    this.add(p1, BorderLayout.CENTER);
    this.add(p2, BorderLayout.SOUTH);

    for (int i = 0; i <= 11; i++)
      textFields[i].setEditable(false);

    for (int i = 0; i <= 11; i++)
      radios[i].addItemListener(this);

    buttons.addActionListener(this);

  }

  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() instanceof JCheckBox) {

      if (radios[1].isSelected() && flag == 1) {
        JOptionPane.showMessageDialog(null, "�����ʽ��135", "��ʾ",
                                      JOptionPane.WARNING_MESSAGE);
        flag = 0;
      }
      for (int i = 0; i <= 11; i++)
        if (radios[i].isSelected()) textFields[i].setEditable(true);
      for (int i = 0; i <= 11; i++)
        if (!radios[i].isSelected()) textFields[i].setEditable(false);
    }
  }

  public void actionPerformed(ActionEvent e) {
    try {
      String sql = "";
      if (e.getSource() instanceof JButton) {
        if (!radios[0].isSelected() ||
            (radios[0].isSelected() && textFields[0].getText().length() == 0))
          JOptionPane.showMessageDialog(null, "�ؼ��ֲ���Ϊ��", "����",
                                        JOptionPane.ERROR_MESSAGE);

        else {
          for (int i = 2; i <= 11; i++)
            if (radios[i].isSelected() && textFields[i].getText().length() == 0) {
              tag = true;
              break;
            }
          if (tag) {
            JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ��", "����",
                                          JOptionPane.ERROR_MESSAGE);
            tag = false;
          }

          else {
            sql = "select flight from flight where flight='" +
                textFields[0].getText().trim() + "'";
            ResultSet rs = dbManager.getResult(sql);

            int flag1 = 0;
            while (rs.next()) {
              flag1 = 1;
            }

            if (flag1 == 0) {
              JOptionPane.showMessageDialog(null, "�Բ���!����Ų�����!",
                                            "������Ϣ", JOptionPane.ERROR_MESSAGE);
              return;
            }

            if (radios[1].isSelected()) {
              sql = "update flight set week='" + textFields[1].getText() +
                  "' where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }


            if (radios[2].isSelected()) {
              sql = "update flight set airFirm='" + textFields[2].getText() +
                  "' where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }

            if (radios[3].isSelected()) {
              sql = "update flight set seat=" +
                  Integer.parseInt(textFields[3].getText().trim()) + " where flight='" +
                  textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }

            if (radios[4].isSelected()) {
              sql = "update flight set start='" + textFields[4].getText() +
                  "' where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[5].isSelected()) {
              sql = "update flight set destination='" + textFields[5].getText() +
                  "' where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[6].isSelected()) {
              sql = "update flight set leaveTime='" + textFields[6].getText() +
                  "' where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[7].isSelected()) {
              sql = "update flight set arriveTime='" + textFields[7].getText() +
                  "' where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[8].isSelected()) {
              sql = "update flight set childFare=" +
                  Float.parseFloat(textFields[8].getText().trim()) + " where flight='" +
                  textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[9].isSelected()) {
              sql = "update flight set adultFare=" +
                  Float.parseFloat(textFields[9].getText().trim()) + " where flight='" +
                  textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[10].isSelected()) {
              sql = "update flight set discount1=" +
                  Float.parseFloat(textFields[10].getText().trim()) +
                  " where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            if (radios[11].isSelected()) {
              sql = "update flight set discount2=" +
                  Float.parseFloat(textFields[11].getText().trim()) +
                  " where flight='" + textFields[0].getText() + "'";
              dbManager.updateSql(sql);
            }
            JOptionPane.showMessageDialog(null, "������Ϣ�Ѿ����³ɹ�!",
                                          "�ɹ���Ϣ",
                                          JOptionPane.INFORMATION_MESSAGE);
          }

        }

      }
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
