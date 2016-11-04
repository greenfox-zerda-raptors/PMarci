/**
 * Created by Marci on 2016.11.04..
 */
public class Workshop09 {
    public static void main(String[] args) {
        int[] ag = new int[] { 3, 4, 5, 6, 7 };
        for (int i = 0; i < 5; i++)
            ag[i]*=2;
        for (int j : ag)
        System.out.print(j + " ");
    }
}
