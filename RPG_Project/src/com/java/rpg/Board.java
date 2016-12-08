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
        setPreferredSize(new Dimension(792, 950));
        this.addKeyListener(new moveKeyListener());
        this.setFocusable(true);
        theHero = new Hero(new GridPoint(0, 0));
        boss = generateBoss();
        presentObjects.add(boss);
        presentObjects.addAll(generateEnemies());
        presentObjects.add(theHero); //fontos utolsonak
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
        graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        graphics.drawString(theHero.toString(), 20, 850);
        if (isGridPointOccupied(theHero.getPosition()) > -1) {
            graphics.drawString(presentObjects.get(getEnemyID(theHero.getPosition())).toString(), 20, 900);
        }
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
            if (Area.areaMatrix[triedGridPoint.getGridX()][triedGridPoint.getGridY()] == 0 && (isGridPointOccupied(triedGridPoint) == -1) || (presentObjects.isEmpty() && Area.areaMatrix[triedGridPoint.getGridX()][triedGridPoint.getGridY()] == 0)) {
                validGridPoint = triedGridPoint;
            }
        }
        return validGridPoint;
    }

    private ArrayList<GameObject> generateEnemies() {
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

    private Boss generateBoss() {
        return new Boss(getAValidGridPoint());
    }

    private int getEnemyID(GridPoint gridPointToTest) {
        int enemyID;
        enemyID = isGridPointOccupied(theHero.getPosition());
        System.out.println(enemyID);
        return enemyID;
    }

    private int isGridPointOccupied(GridPoint gridPointToTest) {
        if (presentObjects.isEmpty()) {
            return 0;
        }
        for (GameObject gameObject : presentObjects) {
            GridPoint presentGridPoint = gameObject.getPosition();
            if (!(presentObjects.indexOf(gameObject) == presentObjects.size() - 1) && (gridPointToTest.getGridX() == presentGridPoint.getGridX()) && (gridPointToTest.getGridY() == presentGridPoint.getGridY())) {
                return presentObjects.indexOf(gameObject);
            } else if (gridPointToTest.getGridX() == 0 && gridPointToTest.getGridY() == 0) {
                return -1;
            }
        }
        return -1;
    }
}
