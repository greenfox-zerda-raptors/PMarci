package com.java.rpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Board extends JPanel {
    private ArrayList<GameObject> presentObjects = new ArrayList<>();
    private Hero theHero;
    private Boss boss;
    Area area;


    Board() {
        area = new Area();
        this.add(area);
        setPreferredSize(new Dimension(792, 792));
        this.addKeyListener(new moveKeyListener());
        this.setFocusable(true);
        theHero = new Hero(new GridPoint(0, 0));
        boss = generateBoss();
        presentObjects.add(boss);
        presentObjects.addAll(generateEnemies());
        presentObjects.add(theHero);
    }

    void draw(ArrayList<GameObject> presentObjects, Graphics graphics) {
        for (GameObject gameObject : presentObjects) {
            Image image = gameObject.image;
            if (image != null) {
                graphics.drawImage(image, gameObject.getPosition().getX(), gameObject.getPosition().getY(), null);
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        draw(presentObjects, graphics);
    }

    private class moveKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            final int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                theHero.move(0);
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                theHero.move(1);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                theHero.move(2);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                theHero.move(3);
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    GridPoint getAValidGridPoint() {
        Random random = new Random();
        GridPoint validGridPoint = null;
        while (validGridPoint == null) {
            GridPoint triedGridPoint = new GridPoint(random.nextInt(11), random.nextInt(11));
            if (Area.areaMatrix[triedGridPoint.getGridX()][triedGridPoint.getGridY()] == 0 && isGridPointOccupied(triedGridPoint)) {
                validGridPoint = triedGridPoint;
            }
        }
        return validGridPoint;
    }

    ArrayList<GameObject> generateEnemies() {
        Random random = new Random();
        int number = 3 + random.nextInt(4);
        ArrayList<GridPoint> validGridPoints = new ArrayList<>();
        ArrayList<GameObject> enemies = new ArrayList<>();
        while (validGridPoints.size() < number) {
            validGridPoints.add(getAValidGridPoint());
        }
        for (GridPoint gridPoint : validGridPoints) {
            enemies.add(new Enemy(gridPoint));
        }
        return enemies;
    }

    Boss generateBoss() {
        Boss boss = new Boss(getAValidGridPoint());
        return boss;
    }

    boolean isGridPointOccupied(GridPoint gridPointToTest) {
        for (GameObject gameObject : presentObjects) {
            GridPoint presentGridPoint = gameObject.getPosition();
            if ((gridPointToTest.getGridX() == presentGridPoint.getGridX()) && (gridPointToTest.getGridY() == presentGridPoint.getGridY()) || (gridPointToTest.getGridX() == 0 && gridPointToTest.getGridY() == 0)) {
                return false;
            }
        }
        return true;
    }
}
