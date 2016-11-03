/**
 * Created by Marci on 2016.11.03..
 */
public class Challenge02 {
    public static void main(String[] args) {
        for (int l = 2; l <= 100; l++) {
                for (int m = 2; m < l; m++) {
                    if (l % m == 0) {
                        break;
                    }
                }
                System.out.println(l);
        }
    }
}