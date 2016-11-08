/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop23 {
    public static void main(String[] args) {
        PrintValues(new String[]{"first", "second", "third"});
        System.out.println();

        PrintValues(new int[]{3, 4, 5, 6, 7});
    }

    public static void PrintValues(String[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }
    public static void PrintValues(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }
}
