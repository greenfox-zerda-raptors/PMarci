/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop19 {
    public static void main(String[] args) {
        System.out.println(fact (7));
    }
    public static int fact (int number) {
        int s = number;
        for (int i = number; i > 1; i--) {
            s *= (i - 1);
        }
            return s;
    }
}
