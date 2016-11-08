/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop18 {
    public static void main(String[] args) {
        System.out.println(nsum (100));
    }
    public static int nsum (int limit) {
        int s = 0;
        for (int i = 0; i <= limit; i++)
            s+=i;
        return s;
    }
}
