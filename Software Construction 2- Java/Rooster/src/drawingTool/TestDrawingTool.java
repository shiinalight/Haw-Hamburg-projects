package drawingTool;

import javax.swing.JFrame;

public class TestDrawingTool {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rooster Drawing Area");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        DrawingArea area = new DrawingArea();
        frame.setContentPane(area);

        frame.setVisible(true);
    }
}
