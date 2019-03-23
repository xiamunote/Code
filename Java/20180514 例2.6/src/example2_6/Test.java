package example2_6;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class Test extends JFrame implements Runnable, MouseListener {
    private DefaultTableModel model = new DefaultTableModel(
            new String[] { "number" }, 0);
    private JTable table = null;
 
    public Test() {
 
        table = new JTable(model);
        table.addMouseListener(this);
        JScrollPane pane = new JScrollPane(table);
 
        add(pane, BorderLayout.CENTER);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        new Thread(this).start();
    }
 
    public static void main(String[] args) {
        new Test();
    }
 
    public void run() {
        Random random = new Random();
        // while (true) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        int r = random.nextInt(20);
        for (int i = 0; i < r; i++) {
            model.addRow(new String[] { random() });
        }
        try {
            repaint();
            Thread.sleep(1000);
        } catch (Exception e) {
 
        }
        // }
    }
 
    private String random() {
        String str = "QWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(str.length());
            buff.append(str.substring(index, index + 1));
        }
        return buff.toString();
    }
 
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        String value = (String) table.getValueAt(row, col);
        JOptionPane.showMessageDialog(null, value);
    }
 
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
 
    }
 
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
 
    }
 
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
 
    }
 
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
 
    }
}