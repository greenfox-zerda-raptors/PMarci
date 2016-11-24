import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by posam on 2016-11-24.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class WrapperApp extends JFrame implements ActionListener {
    JMenuBar bar;
    JMenu file;
    JMenuItem exit;
    ImagePanel img;
    Font legjobb = new Font("Comic Sans MS", Font.PLAIN, 28);


    public WrapperApp() throws HeadlessException {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        bar = new JMenuBar();
        file = new JMenu("File");
        exit = new JMenuItem("Exit");
        img = new ImagePanel();
        file.setFont(legjobb);
        exit.setFont(legjobb);
        exit.addActionListener(this);
        setResizable(false);
        setJMenuBar(bar);
        bar.add(file);
        file.add(exit);
        this.add(img);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WrapperApp();
            }
        });
    }

}
