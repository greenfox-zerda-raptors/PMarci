package com.java.rpg;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
abstract class GameObject extends JComponent {
    private static String dirPath = System.getProperty("user.dir");
    static File dir = new File(dirPath);
    String floor = dir + "\\Images\\" + "floor.png";
    String wall = dir + "\\Images\\" + "wall.png";

    BufferedImage image;
    GridPoint position;

    public GameObject() {
    }

    public void setPosition(GridPoint gridPoint) {
        this.position = gridPoint;
    }

    public GridPoint getPosition() {
        return position;
    }

    GameObject(GridPoint gridPoint) {
        setPosition(gridPoint);
        changeImage(dir + "\\Images\\" + "hero-down.png");
    }

    GameObject(String filename, GridPoint gridPoint) {
        setPosition(gridPoint);
        try {

            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changeImage(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    abstract void draw(Graphics graphics);

    void draw(Graphics graphics, GridPoint gridPoint) {
        if (image != null) {
            graphics.drawImage(image, gridPoint.getX(), gridPoint.getY(), null);
        }
    }

    int[] lookAtNeighbors(int[][] areaMatrix, GridPoint point) {
        int[] neighbors = new int[4];
        int row = areaMatrix.length;
        int col = areaMatrix[0].length;

        if (-1 < point.getGridY() - 1) {
            neighbors[0] = areaMatrix[point.getGridX()][point.getGridY() - 1];
        }
        if (point.getGridX() + 1 < row) {
            neighbors[1] = areaMatrix[point.getGridX() + 1][point.getGridY()];
        }
        if (point.getGridY() + 1 < col) {
            neighbors[2] = areaMatrix[point.getGridX()][point.getGridY() + 1];
        }
        if (-1 < point.getGridX() - 1) {
            neighbors[3] = areaMatrix[point.getGridX() - 1][point.getGridY()];
        }
        return neighbors;
    }

}
