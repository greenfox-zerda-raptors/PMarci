import java.util.Arrays;

/**
 * Created by Marci on 2016.11.04..
 */
public class Workshop08alt {
    public static void main(String[] args) {
    int[][] a = new int[4][4];
        for (int i = 0; i < 4; i++)
            a[i][i] = 1;
        for (int[] b : a)
        System.out.println(Arrays.toString(b).replace("[", "").replace("]", "").replace(",", ""));
    }
}
