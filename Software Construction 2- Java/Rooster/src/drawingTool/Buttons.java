package drawingTool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Buttons {
    private JButton randomizeButton = new JButton("Randomize Roosters");
    private JButton showCombButton = new JButton("Toggle Combs");
    private JButton colorButton = new JButton("Randomize Colors");

    public void addActionListener(ActionListener listener) {
        randomizeButton.addActionListener(listener);
        showCombButton.addActionListener(listener);
        colorButton.addActionListener(listener);
    }

    public void addButtonsToAPanel(JFrame frame) {
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(18, 1, 15, 20));

        menu.add(randomizeButton);
        menu.add(showCombButton);
        menu.add(colorButton);

        menu.setBorder(BorderFactory.createRaisedBevelBorder());
        frame.add(menu, BorderLayout.WEST);
    }

    public JButton getRandomizeButton() { return randomizeButton; }
    public JButton getShowCombButton() { return showCombButton; }
    public JButton getColorButton() { return colorButton; }
}
