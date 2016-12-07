package com.java.rpg;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
abstract class Character extends GameObject {
    private double maxHealthPoints;
    private double currentHealthPoints;
    private double defensePoints;
    private double strikePoints;
    Character(String filename, GridPoint gridPoint) {
        super(filename, gridPoint);
    }
}
