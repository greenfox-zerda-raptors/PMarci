package com.java.rpg;

/**
 * Created by posam on 2016-12-08.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Enemy extends Character {

    Enemy(GridPoint gridPoint) {
        super(gridPoint);
        changeImage(getObjectImageString(""));
        setCharName("Skeleton");
        setObjectID(2);
    }

    Enemy(GridPoint gridPoint, int objectID) {
        this(gridPoint);
        setObjectID(objectID);
    }

    @Override
    String getObjectImageString(String facing) {
        return dir + "\\Images\\" + "skeleton" + facing + ".png";
    }

}
