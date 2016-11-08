import java.util.*;
/**
 * Created by Marci on 2016.11.07..
 */
public class Workshop04 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("first");
        arrayList.add(2);
        arrayList.add("third");
        arrayList.add(false);
        arrayList.set(1, "second");
        arrayList.set(3, "fourth");

        System.out.println(arrayList);

    }
}
