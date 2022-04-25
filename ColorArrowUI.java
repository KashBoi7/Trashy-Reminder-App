import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

class ColorArrowUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new ColorArrowUI();


    }

    @Override protected JButton createArrowButton() {

        return new BasicArrowButton(

        BasicArrowButton.SOUTH,
                Color.darkGray, Color.darkGray,
               Color.white, Color.darkGray);


    }
}
