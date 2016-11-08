import java.util.*;
/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop06 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.remove(3);

        System.out.println(arrayList);
    }
}
