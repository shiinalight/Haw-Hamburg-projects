package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class LeftLeg extends Leg {
    public static final int LEG_WIDTH = 8;
    public static final int LEG_HEIGHT = 35;
    private static final Color DEFAULT_LEG_COLOR = new Color(255, 204, 102);
    private final Claws claws;

    public LeftLeg() {
        super(LEG_WIDTH, LEG_HEIGHT);
        this.claws = new Claws();
    }

    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        drawAt(g, left, bottom, DEFAULT_LEG_COLOR, 1.0);
    }

    // New method: allows color and scaling
    public void drawAt(Graphics g, int left, int bottom, Color color, double size) {
        int scaledWidth = (int)(width * size);
        int scaledHeight = (int)(height * size);
        g.setColor(color);
        g.fillRect(left, bottom, scaledWidth, scaledHeight);
        claws.drawAt(g, left, bottom + scaledHeight); // pass scaling to claws!
    }
}
