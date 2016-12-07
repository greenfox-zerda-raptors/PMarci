package com.java.rpg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by posam on 2016-12-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Main extends JFrame {
    private Main() {
        Board area = new Board();
        this.add(area);
        area.setPreferredSize(new Dimension(792, 792));
        area.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        pack();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }

}
