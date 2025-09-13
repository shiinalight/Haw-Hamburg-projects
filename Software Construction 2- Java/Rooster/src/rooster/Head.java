package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Head extends BodyPart {
    public static final int HEAD_WIDTH = 40;
    public static final int HEAD_HEIGHT = 40;
    private static final Color DEFAULT_HEAD_COLOR = new Color(204, 102, 0);

    private final Eye eye;
    private final Comb comb;
    private final BeakTop beakTop;
    private final BeakBottom beakBottom;

    public Head() {
        super(HEAD_WIDTH, HEAD_HEIGHT);
        this.eye = new Eye();
        this.comb = new Comb();
        this.beakTop = new BeakTop();
        this.beakBottom = new BeakBottom();
    }

    // Legacy (for compatibility)
    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        drawAt(g, left, bottom, DEFAULT_HEAD_COLOR, 1.0, true, false);
    }

    // New, flexible method
    public void drawAt(Graphics g, int left, int bottom, Color color, double size, boolean showComb, boolean hasHat) {
        int scaledWidth = (int)(width * size);
        int scaledHeight = (int)(height * size);
        g.setColor(color);
        g.fillOval(left, bottom, scaledWidth, scaledHeight);
        g.setColor(Color.BLACK);
        g.drawOval(left, bottom, scaledWidth, scaledHeight);

        // Eye at center
        eye.drawAt(g, left + (int)(scaledWidth * 0.4), bottom + (int)(scaledHeight * 0.4));

        // Comb (if shown)
        if (showComb) {
            comb.drawAt(g, left + (int)(scaledWidth * 0.13), bottom - (int)(10 * size));
        }

        // Beaks
        beakTop.drawAt(g, left + scaledWidth - (int)(4 * size), bottom + (int)(10 * size));
        beakBottom.drawAt(g, left + scaledWidth - (int)(4 * size), bottom + (int)(15 * size));

        // Hat (if hasHat)
        if (hasHat) {
            g.setColor(Color.BLACK);
            int hatWidth = (int)(scaledWidth * 0.7);
            int hatHeight = (int)(scaledHeight * 0.25);
            g.fillRect(left + (scaledWidth - hatWidth) / 2, bottom - hatHeight, hatWidth, hatHeight);
        }
    }
}
