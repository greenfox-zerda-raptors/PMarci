import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by posam on 2016-11-23.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class Counter extends JFrame {
    Dimension buttonDimension = new Dimension(150, 80);
    Toolkit tk;
    Dimension dim;
    JPanel bp, kp, mp, wp, cp;
    JLabel cl, bl, rl, ml, kl, wl;
    JButton cb, rb;
    JTextField tf;
    private int clicks = 0;
    private int keyEvents = 0;
    private int mouseEvents = 0;
    private int windowEvents = 0;

    public Counter () {
        bp = new JPanel(new GridBagLayout());
        kp = new JPanel(new BorderLayout());
        mp = new JPanel(new BorderLayout());
        wp = new JPanel(new BorderLayout());
        cp = new JPanel(new GridBagLayout());
        tk = Toolkit.getDefaultToolkit();
        this.setSize(400, 400);
        dim = tk.getScreenSize();
        this.setLocationRelativeTo(null);
        setTitle("My Counter App");
        setDefaultCloseOperation(3);

        cb = new JButton();
        rb = new JButton();
        tf = new JTextField(10);
        bl = new JLabel("Press me!");
        rl = new JLabel("Reset");
        cl = new JLabel("Actions performed: " + clicks);
        kl = new JLabel("Actions performed: " + keyEvents);
        ml = new JLabel("Actions performed: " + mouseEvents);
        wl = new JLabel("Actions performed: " + windowEvents);
        bl.setPreferredSize(buttonDimension);
        rl.setPreferredSize(new Dimension(90, 80));
        cb.addActionListener(
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
        kl.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        ml.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        wl.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        tf.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
        tf.addKeyListener(new listenForKeys());
        this.addMouseListener(new listenForMouse());
        this.addWindowListener(new lsitenForWindow());
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbp = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbp.gridx = 0;
        gbp.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        cb.add(bl, gbc);
        rb.add(rl, gbc);
        gbp.anchor = GridBagConstraints.WEST;
        bp.add(cb, gbp);
        gbp.gridx++;
        bp.add(rb, gbp);
        gbp.gridx++;
        gbp.anchor = GridBagConstraints.EAST;
        gbp.weightx = 1;
        bp.add(cl, gbp);
        gbc.anchor = GridBagConstraints.WEST;
        mp.add(ml, BorderLayout.LINE_END);
        wp.add(wl, BorderLayout.LINE_END);
        gbc.anchor = GridBagConstraints.WEST;
        kp.add(tf, BorderLayout.LINE_START);
        kp.add(kl, BorderLayout.LINE_END);
        gbc.anchor = GridBagConstraints.WEST;
        cp.add(bp, gbc);
        gbc.gridy++;

        cp.add(kp, gbc);
        gbc.gridy++;
//        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipady = 40;
        cp.add(mp, gbc);
        gbc.gridy++;
        cp.add(wp, gbc);
        cp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(cp);
        pack();
        this.setVisible(true);
    }
        private void updateCounter(JLabel label, int counter) {
            label.setText("Actions performed: " + counter);
            pack();
        }

    private class CounterActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clicks++;
            updateCounter(cl, clicks);
        }
    }
    private class resetActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clicks = 0;
            keyEvents = 0;
            mouseEvents = 0;
            windowEvents = 0;
            tf.setText("");
            updateCounter(cl, clicks);
            updateCounter(kl, keyEvents);
            updateCounter(ml, mouseEvents);
            updateCounter(wl, windowEvents);
        }
    }
    private class listenForMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouseEvents++;
            updateCounter(ml, mouseEvents);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class listenForKeys implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            keyEvents++;
            updateCounter(kl, keyEvents);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            keyEvents++;
            updateCounter(kl, keyEvents);

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

    private class lsitenForWindow implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
            windowEvents++;
            updateCounter(wl, windowEvents);
        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {
            windowEvents++;
            updateCounter(wl, windowEvents);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            windowEvents++;
            updateCounter(wl, windowEvents);

        }

        @Override
        public void windowActivated(WindowEvent e) {
            windowEvents++;
            updateCounter(wl, windowEvents);

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            windowEvents++;
            updateCounter(wl, windowEvents);

        }
    }
}
