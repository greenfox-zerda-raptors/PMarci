/**
 * Created by Marci on 2016.11.03..
 */
public class Workshop37 {
    public static void main(String[] args) {
        String c = "#";
        for (int l = 0; l < 7; l++) {
            for (int m = 0; m < 7; m++) {
                if (l%2==0)
                    System.out.print(String.format("%s ", c));
                else
                    System.out.print(String.format(" %s", c));
            }
            System.out.print("\n");
        }

    }
}