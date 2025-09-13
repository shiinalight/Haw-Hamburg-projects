package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Eye extends BodyPart {
    private static final int EYE_WIDTH = 8;
    private static final int EYE_HEIGHT = 8;
    private static final Color EYE_COLOR = Color.WHITE;

    public Eye() {
        super(EYE_WIDTH, EYE_HEIGHT);
    }

    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        g.setColor(EYE_COLOR);
        g.fillOval(left, bottom, width, height);
        g.setColor(Color.BLACK);
        g.fillOval(left + 2, bottom + 2, 3, 3); // Pupil
    }
}
