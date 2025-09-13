package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class BeakTop extends Beak {
    private static final int BEAK_WIDTH = 10;
    private static final int BEAK_HEIGHT = 5;
    private static final Color BEAK_COLOR = Color.YELLOW;

    public BeakTop() {
        super(BEAK_WIDTH, BEAK_HEIGHT);
    }

    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        int[] xPoints = {left, left + width, left};
        int[] yPoints = {bottom, bottom + height/2, bottom + height};
        g.setColor(BEAK_COLOR);
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
