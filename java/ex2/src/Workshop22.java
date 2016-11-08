import java.util.Arrays;

/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop22 {
    public static void main(String[] args) {
    lst ("mi", "van", "zsenikém");
}
    public static void lst (String... args) {
        System.out.println(Arrays.toString(args));
    }
}
