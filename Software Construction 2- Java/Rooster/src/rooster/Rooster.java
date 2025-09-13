package rooster;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

// Import body constants if BODY_WIDTH and BODY_HEIGHT are public static
// import static rooster.Body.BODY_WIDTH;
// import static rooster.Body.BODY_HEIGHT;



public class Rooster extends Bird implements LocatedRectangle {
    private Point position = new Point(0, 0); // Top-left anchor
    private Color bodyColor;
    private Color wingColor;
    private Color tailColor;
    private boolean hasHat; // example accessory
    private double size;    // e.g., 1.0 = normal, 0.8 = small, 1.2 = large
    private final Head head;    // composite
    private final Body body;    // composite
    private final Wing wing;    // composite
    private final TailFeathers tail; // composite
    private final LeftLeg leftLeg;   // composite
    private final RightLeg rightLeg; // composite
    
    public void setBodyColor(Color c) { this.bodyColor = c; }
    public void setWingColor(Color c) { this.wingColor = c; }
    public void setTailColor(Color c) { this.tailColor = c; }
    public void setHasHat(boolean h) { this.hasHat = h; }
    public void setSize(double s) { this.size = s; }


    // Tune these to match your part classes:
    public static final int BODY_WIDTH = 100;
    public static final int BODY_HEIGHT = 70;
    public static final int HEAD_DIAM = 40;
    public static final int WING_WIDTH = 45;
    public static final int WING_HEIGHT = 30;
    public static final int LEG_WIDTH = 8;
    public static final int LEG_HEIGHT = 35;
    public static final int FEATHER_WIDTH = 40; // adjust to fit your arcs

    public Rooster() {
        super("Rooster");
        this.head = new Head();
        this.body = new Body();
        this.wing = new Wing();
        this.tail = new TailFeathers();
        this.leftLeg = new LeftLeg();
        this.rightLeg = new RightLeg();
    }
    
    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }
   

    public void setRandomAttributes() {
        java.util.Random rand = new java.util.Random();

        // Randomize comb presence
        setShowComb(rand.nextBoolean());

        // Randomize position (assume typical panel size 800x600 for now)
        int panelWidth = 800;
        int panelHeight = 600;
        int x = rand.nextInt(panelWidth - this.width());
        int y = rand.nextInt(panelHeight - this.height());
        setPosition(x, y);

        // Randomize size (between 0.8 and 1.6, for example)
        double minSize = 0.8;
        double maxSize = 1.6;
        double randomSize = minSize + (maxSize - minSize) * rand.nextDouble();
        setSize(randomSize);

        // Randomize colors from a palette
        Color[] colorPalette = {Color.RED, Color.YELLOW, Color.ORANGE, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.PINK};
        setBodyColor(colorPalette[rand.nextInt(colorPalette.length)]);
        setWingColor(colorPalette[rand.nextInt(colorPalette.length)]);
        setTailColor(colorPalette[rand.nextInt(colorPalette.length)]);

        // Randomize accessory (e.g., "hat" if your class supports it)
        setHasHat(rand.nextBoolean());
    }




    @Override
    public void drawAt(Graphics g, int left, int bottom) {
        // Draw body with color/size
        body.drawAt(g, left, bottom, bodyColor, size);

        // TailFeathers: pass color/size
        tail.drawAt(g, 
        	    left - (int)(FEATHER_WIDTH * size / 2), 
        	    bottom + (int)(BODY_HEIGHT * size / 3), 
        	    tailColor, 
        	    size
        	);


        // Wing: pass color/size
        wing.drawAt(
        	    g,
        	    left + (int)(BODY_WIDTH * size / 2 - WING_WIDTH * size / 2),
        	    bottom + (int)(BODY_HEIGHT * size / 2 - WING_HEIGHT * size / 2),
        	    wingColor,
        	    size
        	);
        Color legColor = new Color(255, 204, 102); // or define as property

        // Legs (size optional if you want scalable legs)
        leftLeg.drawAt(
        	    g,
        	    left + (int)(BODY_WIDTH * size / 3 - LeftLeg.LEG_WIDTH * size / 2),
        	    bottom + (int)(BODY_HEIGHT * size - 1),
        	    legColor,
        	    size
        	);
        rightLeg.drawAt(
        	    g,
        	    left + (int)(2 * BODY_WIDTH * size / 3 - RightLeg.LEG_WIDTH * size / 2),
        	    bottom + (int)(BODY_HEIGHT * size - 1),
        	    legColor,
        	    size
        	);

        // Head
        head.drawAt(
        	    g,
        	    left + (int)(BODY_WIDTH * size - Head.HEAD_WIDTH * size / 3),
        	    bottom - (int)(Head.HEAD_HEIGHT * size / 2),
        	    bodyColor,    // or a dedicated headColor property if you add it
        	    size,
        	    showComb,
        	    hasHat
        	);
    }


    // Optional overloaded drawAt with showComb (for randomization)
    public void drawAt(Graphics g, int left, int bottom, boolean showComb) {
        this.showComb = showComb;
        drawAt(g, left, bottom);
    }

    public boolean getShowComb() {
        return this.showComb;
    }

    private boolean showComb = true;

    public void setShowComb(boolean showComb) {
        this.showComb = showComb;
    }

    public static final int ROOSTER_WIDTH = (int)(BODY_WIDTH * 1.5); // adjust as needed!
    public static final int ROOSTER_HEIGHT = (int)(BODY_HEIGHT * 1.7);

    @Override
    public Point address() {
        return position;
    }

    @Override
    public int width() {
        return 120; // full bounding width
    }

    @Override
    public int height() {
        return 120; // full bounding height 
    }

    @Override
    public void draw() {
       
    }

}
