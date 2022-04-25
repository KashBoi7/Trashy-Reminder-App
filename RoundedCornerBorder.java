import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class RoundedCornerBorder extends AbstractBorder {
    protected static final int ARC = 12;


    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.WHITE;
    private static final Color SELECTIONFOREGROUND = Color.ORANGE;
    private JComponent makeUI() {
        UIManager.put("ComboBox.foreground", FOREGROUND);
        UIManager.put("ComboBox.background", BACKGROUND);
        UIManager.put("ComboBox.selectionForeground", SELECTIONFOREGROUND);
        UIManager.put("ComboBox.selectionBackground", BACKGROUND);

        UIManager.put("ComboBox.buttonDarkShadow", BACKGROUND);
        UIManager.put("ComboBox.buttonBackground", FOREGROUND);
        UIManager.put("ComboBox.buttonHighlight",  FOREGROUND);
        UIManager.put("ComboBox.buttonShadow",     FOREGROUND);

        UIManager.put("ComboBox.border", new RoundedCornerBorder());
        JComboBox<String> combo1 = new JComboBox<>(makeModel());
        combo1.setUI(new BasicComboBoxUI());
        Object o = combo1.getAccessibleContext().getAccessibleChild(0);
        if (o instanceof JComponent) {
            JComponent c = (JComponent) o;
            c.setBorder(new RoundedCornerBorder());
            c.setForeground(FOREGROUND);
            c.setBackground(BACKGROUND);
        }
        combo1.addPopupMenuListener(new HeavyWeightContainerListener());

        UIManager.put("ComboBox.border", new RoundedCornerBorder1());
        JComboBox<String> combo2 = new JComboBox<>(makeModel());
        combo2.setUI(new BasicComboBoxUI());
        o = combo2.getAccessibleContext().getAccessibleChild(0);
        if (o instanceof JComponent) {
            JComponent c = (JComponent) o;
            c.setBorder(new RoundedCornerBorder2());
            c.setForeground(FOREGROUND);
            c.setBackground(BACKGROUND);
        }
        combo2.addPopupMenuListener(new HeavyWeightContainerListener());

        JPanel p = new JPanel();
        p.add(combo1);
        p.add(combo2);
        p.setOpaque(true);
        p.setBackground(Color.GRAY);
        return p;
    }
    private static DefaultComboBoxModel<String> makeModel() {
        DefaultComboBoxModel<String> m = new DefaultComboBoxModel<>();
        m.addElement("1234");
        m.addElement("5555555555555555555555");
        m.addElement("6789000000000");
        return m;
    }
    }
class RoundedCornerBorder1 extends RoundedCornerBorder {
    //http://ateraimemo.com/Swing/RoundedComboBox.html
    @Override public void paintBorder(
            Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int r = ARC;
        int w = width  - 1;
        int h = height - 1;

        Area round = new Area(new RoundRectangle2D.Float(x, y, w, h, r, r));
        Rectangle b = round.getBounds();
        b.setBounds(b.x, b.y + r, b.width, b.height - r);
        round.add(new Area(b));

        Container parent = c.getParent();
        if (Objects.nonNull(parent)) {
            g2.setPaint(parent.getBackground());
            Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
            corner.subtract(round);
            g2.fill(corner);
        }

        g2.setPaint(c.getForeground());
        g2.draw(round);
        g2.dispose();
    }
}

class RoundedCornerBorder2 extends RoundedCornerBorder {
    @Override public void paintBorder(
            Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int r = ARC;
        int w = width  - 1;
        int h = height - 1;

        Path2D.Float p = new Path2D.Float();
        p.moveTo(x, y);
        p.lineTo(x, y + h - r);
        p.quadTo(x, y + h, x + r, y + h);
        p.lineTo(x + w - r, y + h);
        p.quadTo(x + w, y + h, x + w, y + h - r);
        p.lineTo(x + w, y);
        p.closePath();
        Area round = new Area(p);

        g2.setPaint(c.getBackground());
        g2.fill(round);

        g2.setPaint(c.getForeground());
        g2.draw(round);
        g2.setPaint(c.getBackground());
        g2.drawLine(x + 1, y, x + width - 2, y);
        g2.dispose();
    }
}

