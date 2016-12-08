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
    private int[][] currentArea = Area.areaMatrix;
    private Double maxHealthPoints = 10.;
    private Double currentHealthPoints;
    private Double defensePoints = 10.;
    private Double strikePoints = 10.;
    private int charLevel;
    private Double hasKey;

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

    public String toString() {
        return String.format("Hero (Level %d) HP %.1f / %d | DP %d | SP: %d", charLevel, currentHealthPoints, maxHealthPoints.intValue(), defensePoints.intValue(), strikePoints.intValue());
    }

    void move(int direction) {
        if (lookAtNeighbors(currentArea, this.position)[direction] == 0) {
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
