package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class TailFeathers extends BodyPart {
    private static final int TAIL_WIDTH = 32;
    private static final int TAIL_HEIGHT = 18;
    private static final Color[] COLORS = {Color.BLUE, Color.GREEN, Color.MAGENTA};

    public TailFeathers() {
        super(TAIL_WIDTH, TAIL_HEIGHT);
    }

    // Overloaded for compatibility if needed
    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        drawAt(g, left, bottom, COLORS[0], 1.0); // default: first color, normal size
    }

    // New method with color and size
    public void drawAt(Graphics g, int left, int bottom, Color color, double size) {
        // You can either use one color or keep the rainbow style, scaled:
        for (int i = 0; i < COLORS.length; i++) {
            g.setColor(COLORS[i]); // use COLORS[i], or use just `color` if you want only one
            g.drawArc(
                left + (int)(i * 3 * size), 
                bottom - (int)(i * 4 * size),
                (int)(width * size + i * 8 * size), 
                (int)(height * size + i * 6 * size),
                110, 90
            );
        }
    }
}
