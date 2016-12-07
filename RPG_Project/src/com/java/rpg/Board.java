package com.java.rpg;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Board extends GameObject {
    private  HardCodedMaps maplist = new HardCodedMaps();
    private int[][] areaMatrix = maplist.get(0);
    ArrayList<GameObject> presentObjects = new ArrayList<>();
    GameObject theHero;
    Board() {
        setPreferredSize(new Dimension(792, 792));
        this.addKeyListener(new moveKeyListener());
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        GameObject tiles = new Tile(floor, new GridPoint(0, 0));
        for (int j = 0; j < 11; j++){
            for (int i = 0; i < 11; i++){
                if (areaMatrix[j][i] == 0 || (i == 0 && j == 0)) {
                    tiles = new Tile(floor, new GridPoint(i, j));
                } else if (areaMatrix[j][i] == 1) {
                    tiles = new Tile(wall, new GridPoint(i, j));
                }
                tiles.draw(graphics);
                theHero = new Hero(heroDown, new GridPoint(0, 0));
                theHero.draw(graphics, new GridPoint(0, 0));
            }
        }
    }
    private class moveKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            final int source = e.getKeyCode();
            if (source == KeyEvent.VK_UP) {
                theHero.moveAndDraw(0);
            } else if (source == KeyEvent.VK_RIGHT) {
                theHero.moveAndDraw(1);
            } else if (source == KeyEvent.VK_DOWN) {
                theHero.moveAndDraw(2);
            } else if (source == KeyEvent.VK_LEFT) {
                theHero.moveAndDraw(3);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

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
            for (int j = 0; j < blockedArray[0].length; j++) {
                if (blockedArray[i][j] == 1) {
                    toBeUnblocked.add(new GridPoint(i, j));
                }
            }
        }
        for (GridPoint gridpoint : toBeUnblocked) {
            int[] neighbors = lookAtNeighbors(gridpoint);
            for (int i = 0; i < 5; i++) {
                if (neighbors[i] == 1) {
                    switch (i) {
                        case 0:
                             int[] secondDegreeNeighbors = lookAtNeighbors(new GridPoint(gridpoint.getGridX(), gridpoint.getGridY() - 1));
                            if (secondDegreeNeighbors[i] == 1) {
//                                nWallswithNSpaces.add()
                            }
                    }
                }
            }
        }
        return nWallswithNSpaces;
    }
    private int[][] lookAtNeighborsRecursive(GridPoint gridpoint, int limit, int[] lookFor) {
        lookAtNeighborsRecursiveWorker(gridpoint, 0, limit, lookFor);
        return null; //foundTileArray;
    }
    private int[] lookAtNeighborsRecursiveWorker(GridPoint gridpoint, int depth, int limit, int[] lookFor) {
        if (depth < limit) {
            int[] neighbors = lookAtNeighbors(gridpoint);
            for (int i = 0; i < 4; i++) {
                if (neighbors[i] == lookFor[depth]) {
                    switch (i) {
                        case 0:
                            int[] upper = lookAtNeighborsRecursiveWorker(new GridPoint(gridpoint.getGridX(), gridpoint.getGridY() - 1), ++depth, 2, lookFor);
                            break;
                        case 1:
                            int[] right = lookAtNeighborsRecursiveWorker(new GridPoint(gridpoint.getGridX() + 1, gridpoint.getGridY()), ++depth, 2, lookFor);
                            break;
                        case 2:
                            int[] down = lookAtNeighborsRecursiveWorker(new GridPoint(gridpoint.getGridX(), gridpoint.getGridY() + 1), ++depth, 2, lookFor);
                            break;
                        case 3:
                            int[] left = lookAtNeighborsRecursiveWorker(new GridPoint(gridpoint.getGridX() - 1, gridpoint.getGridY()), ++depth, 2, lookFor);
                            break;
                        default:
                            System.out.println("what's happeninnnnnnggg"); //insert future cases here
                    }
                }
            }
        }
        return null;
    }
    private int[] lookAtNeighbors(GridPoint point) {
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
