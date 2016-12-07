package com.java.rpg;

import java.awt.*;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Area extends GameObject{
    @Override
    void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX, posY, null);
        }
    }
}
