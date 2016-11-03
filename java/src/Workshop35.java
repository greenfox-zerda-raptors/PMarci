/**
 * Created by Marci on 2016.11.03..
 */
public class Workshop35 {
    public static void main(String[] args) {
        String t = "*******";
        for (int l = 1; l < 8; l++) {
            t = t.replaceFirst("\\*", Integer.toString(l));
            System.out.println(t);
        }
    }
}
