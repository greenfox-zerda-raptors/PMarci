import java.util.Arrays;

/**
 * Created by Marci on 2016.11.04..
 */
public class Workshop10 {
    public static void main(String[] args) {
        String[][] colors = new String[][] {{"lime", "forest green", "olive", "pale green", "spring green"}, {"orange red", "red", "tomato"}, {"orchid", "violet", "pink", "hot pink"}};
            for (String[] b : colors)
                System.out.println(Arrays.toString(b));
    }
}
