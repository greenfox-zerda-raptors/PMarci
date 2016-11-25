import javax.swing.*;
import java.awt.*;

/**
 * Created by posam on 2016-11-24.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ImagePanel extends JPanel {
    Image kep;
    Font legjobb = new Font("Comic Sans MS", Font.PLAIN, 28);

    public ImagePanel() {
        kep = Toolkit.getDefaultToolkit().createImage("image.jpg");
//        kep = new ImageIcon("image.jpg").getImage();
//        this.setPreferredSize(new Dimension(kep.getWidth(null), kep.getHeight(null)));
//        this.setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        requestFocus();
        graphics.drawImage(kep, 7, 25, this);
        graphics.setColor(Color.BLACK);
        graphics.setFont(legjobb);
        graphics.drawString("Mi a bre van", 180, 420);

        graphics.setColor(new Color(200, 196, 0));
        graphics.drawOval(270, 45, 70, 120);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(280, 100, 50, 10);

        graphics.setColor(Color.PINK);
        graphics.fillOval(230, 210, 15, 15);
        graphics.fillOval(290, 210, 15, 15);
    }
}