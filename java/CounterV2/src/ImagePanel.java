import javax.swing.*;
import java.awt.*;

/**
 * Created by posam on 2016-11-24.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ImagePanel extends JPanel {
    Image kep;

    public ImagePanel() {
//        kep = Toolkit.getDefaultToolkit().createImage("image.jpg");
        kep = new ImageIcon("image.jpg").getImage();
        this.setPreferredSize(new Dimension(kep.getWidth(null), kep.getHeight(null)));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        requestFocus();
        graphics.drawImage(kep, 0, 25, this);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.drawString("Mi a bre van", 110, 420);

        graphics.setColor(new Color(200, 0, 15));
        graphics.drawOval(270, 45, 70, 120);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(280, 100, 50, 10);

        graphics.setColor(Color.PINK);
        graphics.fillOval(230, 210, 15, 15);
        graphics.fillOval(290, 210, 15, 15);
    }
}