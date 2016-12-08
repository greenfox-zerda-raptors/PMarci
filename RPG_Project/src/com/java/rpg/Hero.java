package com.java.rpg;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
class Hero extends Character {


    String getObjectImageString(String facing) {

        return dir + "\\Images\\" + "hero-" + facing + ".png";

    }

    Hero(GridPoint gridPoint) {
        super(gridPoint);
        getObjectImageString(Character.directionList.get(2));
        setCharName("Hero");
        setMaxHealthPoints(20 + BattleLogic.d6(3));

    }

    void move(int direction) {
        super.move(direction);
        changeImage(getObjectImageString(Character.directionList.get(direction)));

    }
}
