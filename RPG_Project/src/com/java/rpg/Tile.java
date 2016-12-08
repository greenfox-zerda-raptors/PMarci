package com.java.rpg;

import java.awt.*;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Tile extends GameObject {

    public Tile(String filename, GridPoint gridPoint) {
        super(filename, gridPoint);
    }

    void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, position.getX(), position.getY(), null);
        }
    }
}

