import javax.swing.*;
import java.awt.*;

/**
 * Created by posam on 2016-11-23.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class HelloWorld extends JFrame {


    HelloWorld() {
        String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
                "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
                "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
                "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
        this.setSize(400, 400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setTitle("HelloWorld");
        setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        for (String s : hellos) {
            JLabel label = new JLabel(s + "!");
            panel.add(label);
            label.setToolTipText(s);
            this.add(panel);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloWorld();
            }
        });
    }
}
