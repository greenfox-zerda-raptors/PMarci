package com.java.rpg;

import java.awt.geom.Point2D;

/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class GridPoint implements Comparable<GridPoint> {
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

    @Override
    public int compareTo(GridPoint o) {
        if ((this.getGridX() == o.getGridX()) && (this.getGridY() == o.getGridY()))
            return 0;
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!GridPoint.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final GridPoint other = (GridPoint) obj;
        if (this.getGridX() != other.getGridX()) {
            return false;
        }
        if (this.getGridY() != other.getGridY()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.getGridX();
        hash = 53 * hash + this.getGridY();
        return hash;
    }
}
