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
abstract class GameObject extends JComponent{
    private String dirPath = System.getProperty("user.dir");
    private File dir = new File(dirPath);
    String floor = dir + "\\Images\\" + "floor.png";
    String wall = dir + "\\Images\\" + "wall.png";
    String heroDown = dir + "\\Images\\" + "hero-down.png";

    private BufferedImage image;
    private int posX,  posY;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


    GameObject() {
        setVisible(true);
    }

    GameObject(String filename, GridPoint gridPoint) {
        this.posX = gridPoint.getX();
        this.posY = gridPoint.getY();
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

    }

    abstract void draw(Graphics graphics);
    void draw(Graphics graphics, GridPoint gridPoint) {
        if (image != null) {
            graphics.drawImage(image, gridPoint.getX(), gridPoint.getY(), null);
        }
    }
    void moveAndDraw(int direction) {
        switch (direction) {
            case 0:
                this.setPosY(this.getPosY()-1);
                break;
            case 1:
                this.setPosX(this.getPosX()+1);
                break;
            case 2:
                this.setPosY(this.getPosY()+1);
                break;
            case 3:
                this.setPosX(this.getPosX()-1);
                break;
        }
//        this.draw(graphics);
    }
}
