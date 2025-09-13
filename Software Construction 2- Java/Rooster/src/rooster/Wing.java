package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Wing extends BodyPart {
    public static final int WING_WIDTH = 45;
    public static final int WING_HEIGHT = 30;
    private static final Color DEFAULT_WING_COLOR = new Color(160, 82, 45);

    public Wing() {
        super(WING_WIDTH, WING_HEIGHT);
    }

    // Overloaded for compatibility
    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        drawAt(g, left, bottom, DEFAULT_WING_COLOR, 1.0);
    }

    // New method with color and scaling
    public void drawAt(Graphics g, int left, int bottom, Color color, double size) {
        int scaledWidth = (int)(width * size);
        int scaledHeight = (int)(height * size);

        g.setColor(color);
        g.fillOval(left, bottom, scaledWidth, scaledHeight);
        g.setColor(Color.BLACK);
        g.drawOval(left, bottom, scaledWidth, scaledHeight);
    }
}
