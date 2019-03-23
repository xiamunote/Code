package flight.manage;

import javax.swing.*;
import javax.swing.border.*;
/**
 * ��������Ϣ��������
 */
public class Management
    extends JFrame {
  private JTabbedPane tab = new JTabbedPane();

  public Management() {
    tab.add(new InsertPanel(), "    ��   ��    ");
    tab.add(new DeletePanel(), "    ɾ   ��    ");
    tab.add(new UpdatePanel(), "    ��   ��    ");
    tab.add(new FlightList(), "  �� �� �� �� ��  ");
    tab.setBorder(new MatteBorder(new ImageIcon("border.gif")));
    getContentPane().add(tab);
    this.setSize(470, 370);
    this.setResizable(false);
    this.setTitle("�������ϵͳ");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setVisible(true);
  }
}
