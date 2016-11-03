/**
 * Created by Marci on 2016.11.03..
 */
public class Workshop30 {
    public static void main(String[] args) {
    int ac = 8;
    int time = 120;
        String out = "";
        if (time > 200)
            out = "Time out";
        else if (ac %4== 0 && time <= 200)
            out = "check";
        else
            out = "Run Forest Run!";
        System.out.println(out);
    }
}