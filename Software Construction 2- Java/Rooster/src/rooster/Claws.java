package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Claws extends BodyPart {
    private static final int CLAW_LENGTH = 8;

    public Claws() {
        super(0, 0); // width/height not used for simple lines
    }

    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        g.setColor(Color.ORANGE);
        // Three toes
        g.drawLine(left, bottom, left - CLAW_LENGTH, bottom + CLAW_LENGTH);
        g.drawLine(left, bottom, left + CLAW_LENGTH, bottom + CLAW_LENGTH);
        g.drawLine(left, bottom, left, bottom + CLAW_LENGTH);
    }
}
