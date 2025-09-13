package drawingTool;

import javax.swing.JPanel;
import java.awt.Graphics;


public class DrawingArea extends JPanel {
    private static final long serialVersionUID = 1L;
    private Scene scene = new Scene(3);

    public DrawingArea() {
        scene = new Scene(3);
    }
    
    public Scene getScene() {
        return scene;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scene.draw(g);
    }
}
