package rooster;

import java.awt.Graphics;

public abstract class BodyPart {
    protected final int width, height;

    public BodyPart(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void drawAt(Graphics g, int left, int bottom);
}
