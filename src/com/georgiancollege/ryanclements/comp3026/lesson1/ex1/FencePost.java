package com.georgiancollege.ryanclements.comp3026.lesson1.ex1;

import java.awt.*;

class FencePost {
    private Color color;
    private int radius;

    FencePost() {
        radius = 25;
        color = new Color(155, 145, 120);
    }

    Color getColor() {
        return this.color;
    }

    int getRadius() {
        return this.radius;
    }
}
