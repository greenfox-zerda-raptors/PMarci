/**
 * Created by Marci on 2016.11.04..
 */
public class Workshop08 {
    public static void main(String[] args) {
        int[][] a = new int[4][4];
        for (int h = 0; h < 4; h++) {
            for (int i = 0; i < 4; i++) {
                a[i][i] = 1;
                System.out.print(a[h][i] + " ");
            }
            System.out.println("");
        }
    }
}