package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Body extends BodyPart {
    public Body() {
        super(100, 70); // Or whatever your base size is
    }

    // Accept color and size as parameters
    public void drawAt(Graphics g, int left, int bottom, Color color, double size) {
        int scaledWidth = (int) (width * size);
        int scaledHeight = (int) (height * size);
        g.setColor(color);
        g.fillOval(left, bottom, scaledWidth, scaledHeight);
        g.setColor(Color.BLACK);
        g.drawOval(left, bottom, scaledWidth, scaledHeight);
    }

	@Override
	public void drawAt(Graphics g, int left, int bottom) {
		// TODO Auto-generated method stub
		
	}
}
