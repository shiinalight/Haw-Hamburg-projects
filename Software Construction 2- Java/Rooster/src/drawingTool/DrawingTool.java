package drawingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingTool extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	private DrawingArea drawing;
    private Buttons buttons = new Buttons();

    public DrawingTool(String title) {
        super(title);
        setLayout(new BorderLayout());

        constructButtonMenu();
        constructDrawingArea();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setVisible(true);
    }

    private void constructButtonMenu() {
        buttons.addButtonsToAPanel(this);
        buttons.addActionListener(this);
    }

    private void constructDrawingArea() {
        drawing = new DrawingArea();
        add(drawing, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons.getRandomizeButton()) {
            drawing.getScene().randomizeRoosters();
            drawing.repaint();
        } else if (e.getSource() == buttons.getShowCombButton()) {
            drawing.getScene().toggleCombs();
            drawing.repaint();
        } else if (e.getSource() == buttons.getColorButton()) {
            drawing.getScene().randomizeColors();
            drawing.repaint();
        }
    }

    public static void main(String[] args) {
        new DrawingTool("Rooster Drawing Area");
    }
}
