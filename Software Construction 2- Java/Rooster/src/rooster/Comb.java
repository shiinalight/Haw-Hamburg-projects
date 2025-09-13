package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Comb extends BodyPart {
    private static final int COMB_WIDTH = 18;
    private static final int COMB_HEIGHT = 10;
    private static final Color COMB_COLOR = Color.RED;

    public Comb() {
        super(COMB_WIDTH, COMB_HEIGHT);
    }

    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        g.setColor(COMB_COLOR);
        g.fillOval(left, bottom, 8, 8);
        g.fillOval(left + 6, bottom - 4, 10, 10);
        g.fillOval(left + 10, bottom, 8, 8);
    }
}
