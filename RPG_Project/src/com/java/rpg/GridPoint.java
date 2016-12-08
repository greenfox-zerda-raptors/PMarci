package com.java.rpg;

import java.awt.geom.Point2D;

/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class GridPoint {
    int gridX;
    int gridY;

    public GridPoint(int gridX, int gridY) {
        this.gridX = gridX * 72;
        this.gridY = gridY * 72;
    }

    public Point2D getPoint2D() {
        Point2D temp = new Point2D.Double((double) this.getGridX(), this.getGridY());
        return temp;
    }

    public int getGridX() {
        return gridX / 72;
    }

    public int getX() {
        return gridX;
    }


    public int getGridY() {
        return gridY / 72;
    }

    public int getY() {
        return gridY;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX * 72;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY * 72;
    }
}
