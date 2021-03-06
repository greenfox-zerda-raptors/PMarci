package com.java.rpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;


/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Board extends JPanel {
    private ArrayList<Character> objectsPermaList = new ArrayList<>();
    private LinkedHashMap<Integer, GameObject> presentObjectsMap = new LinkedHashMap<>();
    private LinkedHashMap<GridPoint, GameObject> objectsToBeDrawn = new LinkedHashMap<>();


    private GameObject enemyStoodOn;
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
        objectsPermaList.add(boss);
        objectsPermaList.addAll(generateEnemies());
        giveKey(objectsPermaList);
        objectsPermaList.add(theHero);//important to add last
        for (GameObject gameObject : objectsPermaList) {
            presentObjectsMap.put(gameObject.getObjectID(), (Character) gameObject); //TODO when enemy dead, setenemystoodon(null)
        }
        updateObjectsToBeDrawn();
    }

    public GameObject getEnemyStoodOn() {
        return enemyStoodOn;
    }

    public void setEnemyStoodOn(GameObject enemyStoodOn) {
        if (enemyStoodOn == null) {
            this.enemyStoodOn = enemyStoodOn;
        } else if (enemyStoodOn.getObjectID() > 0)
            this.enemyStoodOn = enemyStoodOn;
    }

    private void giveKey(ArrayList<Character> permaListInput) {
        Random random = new Random();
        int keyHolderIndex = 1 + random.nextInt(permaListInput.size() - 1);
        Character keyHolder = permaListInput.get(keyHolderIndex);
        keyHolder.setHasKey(true);
    }

    private void putReverse(HashMap<GridPoint, GameObject> getFrom, HashMap<GameObject, GridPoint> putInto) {
        for (Map.Entry<GridPoint, GameObject> entry : getFrom.entrySet()) {
            GameObject gameObject = entry.getValue();
            GridPoint gridPoint = entry.getKey();
            putInto.put(gameObject, gridPoint);
        }

    }

    void draw(HashMap<GridPoint, GameObject> objectsToBeDrawn, Graphics graphics) {
        for (Map.Entry<GridPoint, GameObject> entry : objectsToBeDrawn.entrySet()) {
            GameObject gameObject = entry.getValue();
            Image image = gameObject.image;
            if (image != null) {
                graphics.drawImage(image, gameObject.getPosition().getX(), gameObject.getPosition().getY(), null);
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        draw(objectsToBeDrawn, graphics);
        graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        graphics.drawString(theHero.toString(), 20, 850);
        if (!isGridPointOccupied(theHero.getPosition())) {
            setEnemyStoodOn(null);
        } else if (isGridPointOccupied(theHero.getPosition()) && (theHero.getPosition().getGridX() != 0 || theHero.getPosition().getGridY() != 0)) {
            GameObject temp = objectsToBeDrawn.get(theHero.getPosition());
            setEnemyStoodOn(temp);
            graphics.drawString(enemyStoodOn.toString(), 20, 900);
            if (!Objects.equals(enemyStoodOn.getKeyString(), ""))
                System.out.println(enemyStoodOn.getKeyString());
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
            } else if (keyCode == KeyEvent.VK_SPACE && (enemyStoodOn != null)) {
                int enemyToStrikeID = getEnemyStoodOn().getObjectID();
                BattleLogic.strike(enemyToStrikeID, (Character) getEnemyStoodOn());
                if (((Character) getEnemyStoodOn()).getCurrentHealthPoints() <= 0) {
                    removeKilledEnemy(enemyToStrikeID);
                    updateObjectsToBeDrawn();
                }
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

    private void updateObjectsToBeDrawn() {
        objectsToBeDrawn.clear();
        for (Map.Entry<Integer, GameObject> entry : presentObjectsMap.entrySet()) {
            objectsToBeDrawn.put(entry.getValue().getPosition(), entry.getValue());
        }

    }

    private GridPoint getAValidGridPoint() {
        Random random = new Random();
        GridPoint validGridPoint = null;
        while (validGridPoint == null) {
            GridPoint triedGridPoint = new GridPoint(random.nextInt(11), random.nextInt(11));
            if (Area.areaMatrix[triedGridPoint.getGridX()][triedGridPoint.getGridY()] == 0 && !isGridPointOccupied(triedGridPoint)) {
                validGridPoint = triedGridPoint;
            }
        }
        return validGridPoint;
    }

    private GridPoint getAValidGridPoint(LinkedHashSet<GridPoint> alreadyTried) {
        Random random = new Random();
        GridPoint validGridPoint = null;
        while (validGridPoint == null) {
            GridPoint triedGridPoint = new GridPoint(random.nextInt(11), random.nextInt(11));
            if (Area.areaMatrix[triedGridPoint.getGridX()][triedGridPoint.getGridY()] == 0 && !isGridPointOccupied(triedGridPoint) && !alreadyTried.contains(triedGridPoint)) {
                validGridPoint = triedGridPoint;
            }
        }
        return validGridPoint;
    }

    private ArrayList<Character> generateEnemies() {
        Random random = new Random();
        int number = Math.min((100 + random.nextInt(3)), area.getNumberOfZeros(Area.areaMatrix) - 2);
        LinkedHashSet<GridPoint> validGridPoints = new LinkedHashSet<>();
        ArrayList<Character> enemies = new ArrayList<>();
        while (validGridPoints.size() < number) {
            validGridPoints.add(getAValidGridPoint(validGridPoints));
        }
        int uniqueID = 2;
        for (GridPoint gridPoint : validGridPoints) {
            enemies.add(new Enemy(gridPoint, uniqueID));
            uniqueID++;
        }
        return enemies;
    }

    private Boss generateBoss() {
        return new Boss(getAValidGridPoint());
    }

    private boolean isGridPointOccupied(GridPoint gridPointToTest) {
        for (GameObject gameObject : objectsPermaList) {
            GridPoint presentGridPoint = gameObject.getPosition();
            if (gridPointToTest.getGridX() == 0 && gridPointToTest.getGridY() == 0) {
                return true;
            } else if (gameObject.getObjectID() > 0 && (gridPointToTest.getGridX() == presentGridPoint.getGridX()) && (gridPointToTest.getGridY() == presentGridPoint.getGridY())) {
                return true;
            }
        }
        return false;
    }

    void removeKilledEnemy(int objectID) {
        presentObjectsMap.remove(objectID);
    }
}
