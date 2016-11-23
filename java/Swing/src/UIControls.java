import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by posam on 2016-11-23.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class UIControls extends JFrame {
    JPanel panel;
    JTextField textField;
    JLabel labelActual;
    JLabel labelClear;
    JLabel labelMemory;
    JButton clear;
    Font legjobb = new Font("Comic Sans MS", Font.PLAIN, 32);

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    String actual;

    public UIControls() throws HeadlessException {
        setDefaultCloseOperation(3);
        panel = new JPanel();
        LayoutManager boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.setBorder(BorderFactory.createMatteBorder(40, 40, 40, 40, panel.getBackground()));
        panel.setSize(400,400);
        textField = new JTextField(10);
        textField.setFont(legjobb);
        labelActual = new JLabel("Text entered: ");
        labelActual.setFont(legjobb);
        labelMemory = new JLabel("Memory: ");
        labelMemory.setFont(legjobb);
        labelClear = new JLabel("Clear memory");
        labelClear.setFont(legjobb);
        clear = new JButton();
        textField.addActionListener(new TextActionListener());
        clear.addActionListener(new memoryClearListener());
        panel.add(textField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(labelActual);
        panel.add(labelMemory);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        clear.add(labelClear);
        panel.add(clear);
        this.add(panel);
        pack();
        this.setVisible(true);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UIControls();
            }
        });

    }

    private class TextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labelMemory.setText("Memory: " + getActual());
            setActual(textField.getText());
            labelActual.setText("Text entered: " + getActual());
            textField.setText("");
            pack();
        }
    }

    private class memoryClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labelMemory.setText("Memory: ");
        }
    }
}
