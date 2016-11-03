/**
 * Created by Marci on 2016.11.03..
 */
public class Nvm {
    public static void main(String[] args) {
        int m;
        int l = 2;
        k: while (l <= 100) {
            l: while (l <= 100) {
                System.out.println(String.format("az l most %d", l));
                m = 2;
                m: while (m < l) {
                    System.out.println(String.format("az mmm most %d", m));
                    if (l % m == 0) {

                    }
                    else {
                        m++;
                        continue l;
                    }
                }
                l++;

            }
            System.out.println(l);
            l++;
        }
    }
}