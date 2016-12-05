package com.java.rpg;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Area extends JComponent {
        String dirPath = System.getProperty("user.dir");
        File dir = new File(dirPath);
        String floor = dir + "\\Images\\" + "floor.png";
        String wall = dir + "\\Images\\" + "wall.png";
        int[][] areaMatrix = generateRandomArea();
    public Area() {


        setPreferredSize(new Dimension(792, 792));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        PositionedImage image = new PositionedImage(floor, new GridPoint(0, 0));
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (areaMatrix[i][j] == 0 || (i == 0 && j == 0)) {
                    image = new PositionedImage(floor, new GridPoint(i, j));
                } else if (areaMatrix[i][j] == 1) {
                    image = new PositionedImage(wall, new GridPoint(i, j));
                }
                    image.draw(graphics);
            }
        }
    }

//    public Point2D gridify(int posx, int posy) {
//        Point2D gridPosition = new Point2D.Double(posx * 72, posy * 72);
//        return gridPosition;
//    }
//    public Point2D gridify(Point2D point) {
//        Point2D gridPosition = new Point2D.Double(point.getX() * 75, point.getY() * 75);
//        return gridPosition;
//    }

    private static int[][] generateRandomArea(){
        int[][] array = new int[11][11];
        Random random = new Random();
        for (int[] i : array) {
            for (int j = 0; j < i.length; j++){
                i[j] = random.nextInt(2);
            }
        }
        return array;
    }
    private static int[][] findSingleClosedSpaces(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int[][] singleClosedSpaces = new int[row][col];
        ArrayList<Integer> multiplicands = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int product = 1;
                multiplicands.clear();
                if (-1 < i - 1) {
                    multiplicands.add(array[i - 1][j]);
                }
                if (i + 1 < row) {
                    multiplicands.add(array[i + 1][j]);
                }
                if (-1 < j - 1) {
                    multiplicands.add(array[i][j - 1]);
                }
                if (j + 1 < col) {
                    multiplicands.add(array[i][j + 1]);
                }
                for (Integer integer : multiplicands) {
                    product *= integer;
                }
                if (product == 1) {
                    singleClosedSpaces[i][j] = 1;
                }
            }
        }
        return singleClosedSpaces;
    }
    private ArrayList<GridPoint> findNWallsWithNSpaces(int[][] blockedArray) {
        ArrayList<GridPoint> toBeUnblocked = new ArrayList<GridPoint>();
        ArrayList<GridPoint> nWallswithNSpaces = new ArrayList<GridPoint>();
        for (int i = 0; i < blockedArray.length; i++) {
            for (int j = 0; j < blockedArray[0].length; j++ ) {
                if (blockedArray[i][j] == 1) {
                    toBeUnblocked.add(new GridPoint(i, j));
                }
            }
        }
        for (GridPoint gridpoint : toBeUnblocked) {
            lookAtNeighbors(gridpoint);
        }
        return null;
    }
    private int[] lookAtNeighbors(GridPoint point) {
        int[] neighbors = new int[4];
        int row = areaMatrix.length;
        int col = areaMatrix[0].length;

        if (-1 < point.getGridX() - 1) {
            neighbors[3] = areaMatrix[point.getGridX() - 1][point.getGridY()];
        }
        if (point.getGridX() + 1 < row) {
            neighbors[1] = areaMatrix[point.getGridX() + 1][point.getGridY()];

        }
        if (-1 < point.getGridY() - 1) {
            neighbors[0] = areaMatrix[point.getGridX()][point.getGridY() - 1];

        }
        if (point.getGridY() + 1 < col) {
            neighbors[2] = areaMatrix[point.getGridX()][point.getGridY() + 1];
        }
    return neighbors;
    }
}
