import java.util.*;
/**
 * Created by Marci on 2016.11.07..
 */
public interface Workshop03 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("first", "second", "fourth"));
        arrayList.add(2, "third");

        System.out.println(arrayList);
    }
}
