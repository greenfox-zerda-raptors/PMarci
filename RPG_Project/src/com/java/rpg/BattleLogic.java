package com.java.rpg;

import java.util.Random;

/**
 * Created by posam on 2016-12-07.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class BattleLogic {
    private static String lastAction;
    private static Random random = new Random();

    static void strike() {

    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        BattleLogic.lastAction = lastAction;
    }

    static int d6(int numberOfThrows) {
        int count = 0;
        int sum = 0;
        while (count < numberOfThrows) {
            sum += 1 + random.nextInt(6);
            count++;
        }
        return sum;
    }
}
