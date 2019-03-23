package flight.Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import flight.manage.*;
import flight.query.*;
import flight.ticketbook.*;
import flight.ticketrefund.*;
/**
 * 程序主界面
 */
class Interface
    extends JPanel
    implements ActionListener {
  private TicketRefund ticketRefund;
  private TicketBook ticketBook;

  private JButton jbQuery = new JButton("查询");
  private JButton jbManager = new JButton("管理");
  private JButton jbTicketBook = new JButton("订票");
  private JButton jbTicketRefund = new JButton("退票");
  private JButton jbAbout = new JButton("关于");

  public Interface() {
    this.setLayout(null);
    this.add(jbQuery);
    this.add(jbTicketBook);
    this.add(jbTicketRefund);
    this.add(jbManager);
    this.add(jbAbout);

    jbQuery.setFont(new Font("Times", Font.PLAIN, 12));
    jbTicketBook.setFont(new Font("Times", Font.PLAIN, 12));
    jbTicketRefund.setFont(new Font("Times", Font.PLAIN, 12));
    jbManager.setFont(new Font("Times", Font.PLAIN, 12));
    jbAbout.setFont(new Font("Times", Font.PLAIN, 12));

    jbQuery.setBounds(90, 280, 80, 30);
    jbTicketBook.setBounds(190, 280, 80, 30);
    jbTicketRefund.setBounds(290, 280, 80, 30);
    jbManager.setBounds(390, 280, 80, 30);
    jbAbout.setBounds(430, 350, 80, 30);

    jbQuery.addActionListener(this);
    jbManager.addActionListener(this);
    jbTicketBook.addActionListener(this);
    jbTicketRefund.addActionListener(this);
    jbAbout.addActionListener(this);
  }

  public void paintComponent(Graphics g) {
    ImageIcon imageIcon = new ImageIcon("backgrond.gif");
    Image image = imageIcon.getImage();
    g.drawImage(image, 0, 0, this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbQuery) {//查询
      Query query = new Query();
      showSubFrame(query);
    }

    else if (e.getSource() == jbManager) {//管理
      String id = JOptionPane.showInputDialog(null, "请输入你的帐号:",
                                              "帐号验证", JOptionPane.PLAIN_MESSAGE);
      if (id == null)
        return;
      if (!id.equals("manage")) {
        JOptionPane.showMessageDialog(null, "对不起!你的帐号不正确!",
                                      "帐号错误", JOptionPane.ERROR_MESSAGE);
        return;
      }

      String password = JOptionPane.showInputDialog(null, "请输入你的密码:",
          "密码验证", JOptionPane.PLAIN_MESSAGE);
      if (password == null)
        return;
      if (!password.equals("manage")) {
        JOptionPane.showMessageDialog(null, "对不起!你的密码不正确!",
                                      "帐号错误", JOptionPane.ERROR_MESSAGE);
        return;
      }

      Management manager = new Management();
      showSubFrame(manager);
    }

    else if (e.getSource() == jbTicketBook) {//订票
      ticketBook = new TicketBook();
      showSubFrame(ticketBook);
    }

    else if (e.getSource() == jbTicketRefund) {//退票
      ticketRefund = new TicketRefund();
      showSubFrame(ticketRefund);
    }

    else if (e.getSource() == jbAbout) {//关于
      String information = "本系统原版本由吴海贤、陈振、孟磊、余菁开发\n" +
         "本书作者在原版本的基础上做了较大修改\n";
      JOptionPane.showMessageDialog(null, information, "关于",
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private void showSubFrame(JFrame subFrame){//设置子窗口的显示位置
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //屏幕大小
    subFrame.setLocation( (d.width - subFrame.getSize().width) / 2,
                             (d.height - subFrame.getSize().height) / 2);
    subFrame.show();

  }
}
