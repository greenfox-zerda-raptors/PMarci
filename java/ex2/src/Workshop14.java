/**
 * Created by Marci on 2016.11.04..
 */
public class Workshop14 {
    public static void main(String[] args) {
        int[] ah = new int[]  { 3, 4, 5, 6, 7 };
        int[] ai = new int[ah.length];
        for(int i=0;i < ah.length;i++) {
            ai[i] = ah[i*-1+(ah.length-1)];
            System.out.print(String.format(ai[i] + " "));
        }
    }
}
