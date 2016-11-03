/**
 * Created by Marci on 2016.11.03..
 */
public class Workshop29 {
    public static void main(String[] args) {
        int ab = 123;
        int credits = 100;
        Boolean is_bonus = true;

        if ((credits >= 50) && is_bonus==false)
            ab -= 2;
        if ((credits < 50) && is_bonus==false)
            ab -= 1;

        System.out.println(ab);
    }
}
