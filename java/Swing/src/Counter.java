import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by posam on 2016-11-23.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Counter extends JFrame {
    Dimension buttonDimension = new Dimension(150, 80);
    Toolkit tk;
    Dimension dim;
    JPanel jp;
    JLabel cl, bl, rl;
    JButton jb, rb;
    private int clicks = 0;

    public Counter () {
        tk = Toolkit.getDefaultToolkit();
        this.setSize(400, 400);
        dim = tk.getScreenSize();
        this.setLocationRelativeTo(null);
        setTitle("My Counter App");
        setDefaultCloseOperation(3);

//        jp = new JPanel();
        this.setLayout(new FlowLayout());
        cl = new JLabel("Clicked " + clicks + " times");
        jb = new JButton();
        rb = new JButton();
        bl = new JLabel("Press me!");
        rl = new JLabel("Reset");
        bl.setPreferredSize(buttonDimension);
        rl.setPreferredSize(buttonDimension);
        jb.addActionListener(
                new CounterActionListener()
        );
        rb.addActionListener(
                new resetActionListener()
        );
        bl.setAlignmentX(JButton.CENTER_ALIGNMENT);
        rl.setAlignmentX(JButton.CENTER_ALIGNMENT);
        cl.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        bl.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        rl.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));

//        this.add(jp);
        jb.add(bl);
        rb.add(rl);
        this.add(jb);
        this.add(cl);
        this.add(rb);
        pack();
        this.setVisible(true);
    }
        private void updateCounter() {
            cl.setText("Clicked " + clicks + " times");
            pack();
        }

    private class CounterActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clicks++;
            updateCounter();
        }
    }
    private class resetActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clicks = 0;
            updateCounter();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Counter();
            }
        });
    }
}
