import java.util.*;
/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop05 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(12, 1, 532, 23, 0, 7, 54, 32));
//        Integer[] numarr;
//        numarr = numList.toArray(new Integer[0]);
//        System.out.println(Arrays.ToString(numarr));
        int[] numarr = new int[numList.size()];
        for (int i /*: numList*/= 0; i < numList.size(); i++) {
            numarr[i] = numList.get(i);
        }
        System.out.println(Arrays.toString(numarr));
    }
}
