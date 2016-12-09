package com.java.rpg;

import java.awt.*;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Tile extends GameObject {
    static String floor = dir + "\\Images\\" + "floor.png";
    static String wall = dir + "\\Images\\" + "wall.png";

    Tile(String filename, GridPoint gridPoint) {
        super(filename, gridPoint);
    }

    void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, position.getX(), position.getY(), null);
        }
    }
}

