import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class RoundComboBoxUI extends BasicComboBoxUI
{
    ImageIcon icon=new ImageIcon("C:\\Users\\kauve\\IdeaProjects\\Reminder\\src\\icons8-drop-down-16.png");

    Color bgColor = new Color( 0,0,0,220 );

    protected void installDefaults()
    {
        super.installDefaults();
        comboBox.setOpaque(true );
        comboBox.setBackground( bgColor );
        comboBox.setForeground( Color.white );
        comboBox.setBorder(new SimpleRoundBorder());
    }

    protected JButton createArrowButton()
    {
        JButton button = new BasicArrowButton(BasicArrowButton.SOUTH, Color.DARK_GRAY, Color.DARK_GRAY, Color.white, Color.DARK_GRAY );

        button.setUI( null);
        return button;
    }

    class SimpleRoundBorder extends AbstractBorder
    {
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
        {
            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            ((Graphics2D)g).setColor( Color.white );
            ((Graphics2D)g).drawRoundRect(x, y, width-2, height-2, 12, 12);
        }

        public Insets getBorderInsets(Component c)
        {
            return new Insets(3, 6, 3, 3);
        }

        public Insets getBorderInsets(Component c, Insets insets)
        {
            insets.top = insets.left = insets.bottom = insets.right = 3;
            return insets;
        }
    }
}
