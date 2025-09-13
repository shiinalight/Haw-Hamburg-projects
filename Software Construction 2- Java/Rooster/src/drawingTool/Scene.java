package drawingTool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import rooster.Rooster;

public class Scene {
    private final ArrayList<Rooster> roosters;
    private final int margin = 10; // margin between roosters`

    // Simple constructor (just for compatibility)
    public Scene(int numRoosters) {
        this(numRoosters, 800, 600); // default panel size
    }

    // Main constructor
    public Scene(int numRoosters, int panelWidth, int panelHeight) {
        roosters = new ArrayList<>();

        if (panelWidth <= Rooster.ROOSTER_WIDTH + margin * 2 || panelHeight <= Rooster.ROOSTER_HEIGHT + margin * 2) {
            throw new IllegalArgumentException("Panel size is too small for rooster size and margin!");
        }

        Random rand = new Random();
        Color[] colors = { Color.RED, Color.YELLOW, Color.ORANGE, Color.BLUE, Color.GREEN };
        for (int i = 0; i < numRoosters; i++) {
            boolean placed = false;
            int attempts = 0;
            Rooster rooster = new Rooster();

            // Step 5: Assign variations here!
            rooster.setBodyColor(colors[rand.nextInt(colors.length)]);
            rooster.setWingColor(colors[rand.nextInt(colors.length)]);
            rooster.setTailColor(colors[rand.nextInt(colors.length)]);
            rooster.setHasHat(rand.nextBoolean());
            rooster.setSize(0.8 + rand.nextDouble() * 0.8); // scale between 0.8 and 1.6

            // Try to place without overlapping others
            while (!placed && attempts < 200) {
                int x = margin + rand.nextInt(panelWidth - Rooster.ROOSTER_WIDTH - margin * 2);
                int y = margin + rand.nextInt(panelHeight - Rooster.ROOSTER_HEIGHT - margin * 2);
                rooster.setPosition(x, y);

                boolean intersects = false;
                for (Rooster other : roosters) {
                    if (rooster.intersects(other, margin)) {
                        intersects = true;
                        break;
                    }
                }
                if (!intersects) {
                    placed = true;
                    roosters.add(rooster);
                }
                attempts++;
            }
        }
    }
    
 // Scene.java
    public void randomizeRoosters() {
        for (Rooster rooster : roosters) {
            // Randomize colors, position, comb, etc. as per your requirements
            rooster.setRandomAttributes();
        }
    }
    
 // Toggle combs on all roosters
    public void toggleCombs() {
        for (Rooster rooster : roosters) {
            rooster.setShowComb(!rooster.getShowComb());
        }
    }

    // Randomize colors for all roosters
    public void randomizeColors() {
        java.awt.Color[] palette = {
            java.awt.Color.RED, java.awt.Color.YELLOW, java.awt.Color.ORANGE,
            java.awt.Color.BLUE, java.awt.Color.GREEN, java.awt.Color.MAGENTA
        };
        java.util.Random rand = new java.util.Random();

        for (Rooster rooster : roosters) {
            rooster.setBodyColor(palette[rand.nextInt(palette.length)]);
            rooster.setWingColor(palette[rand.nextInt(palette.length)]);
            rooster.setTailColor(palette[rand.nextInt(palette.length)]);
        }
    }


    // Draw all roosters in the scene
    public void draw(Graphics g) {
        for (Rooster rooster : roosters) {
            Point pos = rooster.address();
            rooster.drawAt(g, pos.x, pos.y);
        }
    }

    // Getter for roosters (if needed for later steps)
    public ArrayList<Rooster> getRoosters() {
        return roosters;

    }
}
