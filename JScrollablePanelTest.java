import javax.swing.*;
import java.awt.*;

public class JScrollablePanelTest extends JFrame {
    public JScrollablePanelTest() {
        setTitle("JScrollablePanel Test");
        setLayout(new BorderLayout());
        JPanel panel = createPanel();
        JScrollPane pane=new JScrollPane();
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(BorderLayout.CENTER,pane);
        setSize(375, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 4, 10, 10));
//        for (int i=0; i < 10; i++) {
//            for (int j=0; j < 4; j++) {
//                JLabel label = new JLabel("label " + i + ", " + j);
//                label.setFont(new Font("Arial", Font.PLAIN, 20));
//                panel.add(label);
//            }
//        }
        return panel;
    }
}
