package com.java.rpg;

/**
 * Created by posam on 2016-12-08.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Boss extends Character {
    Boss(GridPoint gridPoint) {
        super(gridPoint);
        changeImage(getObjectImageString(""));
    }

    @Override
    String getObjectImageString(String facing) {
        return dir + "\\Images\\" + "boss" + facing + ".png";
    }
}
