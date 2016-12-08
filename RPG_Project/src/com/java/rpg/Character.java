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
    private int maxHealthPoints = 0;
    private Double currentHealthPoints;
    private Double defensePoints = 10.;
    private int strikePoints = 0;
    private int charLevel;
    private boolean hasKey;
    private String charName;
    private String keyString = "";

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
        return String.format("%s (Level %d) HP %.1f/%d | DP: %d | SP: %d %s", charName, charLevel, currentHealthPoints, maxHealthPoints, defensePoints.intValue(), strikePoints, keyString);
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public Double getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(Double currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public Double getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(Double defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getStrikePoints() {
        return strikePoints;
    }

    public void setStrikePoints(int strikePoints) {
        this.strikePoints = strikePoints;
    }

    public int getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(int charLevel) {
        this.charLevel = charLevel;
    }

    public boolean getHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
        keyString = (hasKey) ? "(He has the Key!)" : "";
    }

    public String getKeyString() {
        return keyString;
    }
}
