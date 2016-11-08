import java.util.Arrays;

/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop21 {
    public static void main(String[] args) {
        System.out.println(fact (4));
    }
    public static int fact (int number) {
        if (number ==1) {
            return 1;
        } else {
            return fact (number-1) * number;
        }
    }
}
