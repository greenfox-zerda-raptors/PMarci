package com.java.rpg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Board extends JPanel {
    private ArrayList<GameObject> presentObjects = new ArrayList<>();
    private Hero theHero;
    private Enemy testEnemy;


    Board() {
        Area area = new Area();
        this.add(area);
        setPreferredSize(new Dimension(792, 792));
        this.addKeyListener(new moveKeyListener());
        this.setFocusable(true);
        testEnemy = new Enemy(new GridPoint(4, 2));
        theHero = new Hero(new GridPoint(0, 0));
        presentObjects.add(testEnemy);
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
}
