package com.georgiancollege.ryanclements.comp3026.lesson1.ex1;
import java.awt.Color;

class FenceSection {
    private Color color;
    private int height;
    private int width;

    FenceSection() {
        color = new Color(155, 111, 43);
        width = 60;
        height = 10;
    }

    Color getColor() {
        return this.color;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return height;
    }
}
