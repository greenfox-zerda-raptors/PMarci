/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop17 {
    public static void main(String[] args) {
        String ag = "kuty";
        ag = append (ag);
        System.out.println(ag);
    }
    public static String append (String string) {
        string += "a";
        return string;
    }
}
