import java.util.Arrays;

/**
 * Created by Marci on 2016.11.04..
 */
public class Workshop12 {
    public static void main(String[] args) {
        String[] abc = new String[] { "first", "second", "third" };
        String a = abc[1];
        abc[1] = abc[0];
        abc[0] = a;
        System.out.println(Arrays.toString(abc));
    }
}
