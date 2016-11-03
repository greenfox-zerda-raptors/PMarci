/**
 * Created by Marci on 2016.11.03..
 */
public class Workshop27 {
    public static void main(String[] args) {
        String y = "seasons";
        int out = 6;
        if (y.charAt(0)==y.charAt(y.length()-1))
            out*=2;
        else out/=2;
        System.out.println(out);
    }
}
