/**
 * Created by Marci on 2016.11.03..
 */
public class Challenge02 {
    public static void main(String[] args) {
        int l = 2;
        int m;
        do {
//            System.out.println(String.format("az l most %d", l));
            m = 2;
            do {
//                System.out.println(String.format("az m most %d", m));
                if (l % m == 0 && l != m) {
                    m++;
//                    System.out.println("egy");
                    break;
                }
                else if (m == l) {
                    System.out.println(l);
//                    System.out.println("ketto");
                    break;
                }
                else
//                    System.out.println("harom");
                    m++;
            } while (m <= l);
            l++;
        } while (l <= 100);
    }
}
