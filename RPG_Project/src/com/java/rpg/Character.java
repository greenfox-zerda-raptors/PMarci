package com.java.rpg;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
abstract class Character extends GameObject {
    final static HashMap<Integer, String> directionList = new HashMap<Integer, String>() {{
        put(0, "up");
        put(1, "right");
        put(2, "down");
        put(3, "left");
    }};

    private double maxHealthPoints;
    private double currentHealthPoints;
    private double defensePoints;
    private double strikePoints;

    Character(GridPoint gridPoint) {
        super(gridPoint);
    }

    @Override
    void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, super.getX(), super.getY(), null);
        }
    }

    abstract String getObjectImageString(String facing);

    void move(int direction) {
        if ((Area.lookAtNeighbors(this.position)[direction] == 0)) {
            switch (direction) {
                case 0:
                    if ((this.position).getGridY() > 0)
                        this.position = new GridPoint(this.position.getGridX(), this.position.getGridY() - 1);
                    break;
                case 1:
                    if ((this.position).getGridX() < 10)
                        this.position = new GridPoint(this.position.getGridX() + 1, this.position.getGridY());
                    break;
                case 2:
                    if ((this.position).getGridY() < 10)
                        this.position = new GridPoint(this.position.getGridX(), this.position.getGridY() + 1);
                    break;
                case 3:
                    if ((this.position).getGridX() > 0)
                        this.position = new GridPoint(this.position.getGridX() - 1, this.position.getGridY());
                    break;
            }
        }
    }
}
