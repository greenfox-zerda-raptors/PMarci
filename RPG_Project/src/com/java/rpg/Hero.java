package com.java.rpg;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Hero extends Character {


    String setObjectImage(String facing) {

        return dir + "\\Images\\" + "hero-" + facing + ".png";

    }

    Hero(GridPoint gridPoint) {
        super(gridPoint);
        setObjectImage(Character.directionList.get(2));

    }

    void move(int direction) {
        super.move(direction);
        changeImage(setObjectImage(Character.directionList.get(direction)));

    }
}
