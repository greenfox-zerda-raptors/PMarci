import javax.swing.*;
import java.awt.*;

/**
 * Created by posam on 2016-11-23.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ImageApp extends JFrame {

    public ImageApp() throws HeadlessException {
        setDefaultCloseOperation(3);
//        Image kep = Toolkit.getDefaultToolkit().createImage("C:/Users/posam/Desktop/Untitled.png");
        Image kep = new ImageIcon("C:/Users/posam/Desktop/Untitled.png").getImage();
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                requestFocus();
                graphics.drawImage(kep, 0,0, this);
            }
        };
        panel.setPreferredSize(new Dimension(kep.getWidth(null), kep.getHeight(null)));
        this.add(panel);
        pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageApp();
            }
        });

    }
}
