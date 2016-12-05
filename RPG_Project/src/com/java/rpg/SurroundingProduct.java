package com.java.rpg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public final class SurroundingProduct {

    private SurroundingProduct() {
    }

    public static void surroundingProduct(int[][] m) {

        if (m == null) {
            throw new NullPointerException("The input matrix cannot be null");
        }
        int row = m.length;
        int col = m[0].length;
        int[][] singleClosedSpaces = new int[4][4];
        ArrayList<Integer> multiplicants = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int product = 1;
                multiplicants.clear();
                if (-1 < i - 1) {
                    multiplicants.add(m[i - 1][j]);
                }
                if (i + 1 < row) {
                    multiplicants.add(m[i + 1][j]);
                }
                if (-1 < j - 1) {
                    multiplicants.add(m[i][j - 1]);
                }
                if (j + 1 < col) {
                    multiplicants.add(m[i][j + 1]);
                }
                for (Integer integer : multiplicants) {
                    product *= integer;
                }
                if (product == 1) {
                    singleClosedSpaces[i][j] = 1;
                }
                System.out.printf(m[i][j] + " --> %d\n", product);
            }
        }
                System.out.println(Arrays.deepToString(singleClosedSpaces));
    }


    public static void main(String[] args) {

        int[][] m = { {1, 1, 0, 0},
                      {1, 0, 1, 0},
                      {1, 1, 1, 1},
                      {1, 1, 1, 0}, };

        surroundingProduct(m);

    }
}
