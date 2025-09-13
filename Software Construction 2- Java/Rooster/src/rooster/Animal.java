package rooster;

import java.awt.Graphics;

public abstract class Animal {
    protected final String species;

    public Animal(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public abstract void drawAt(Graphics g, int left, int bottom); // <-- Add this!
}
