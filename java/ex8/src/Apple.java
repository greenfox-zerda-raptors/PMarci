import java.util.ArrayList;

/**
 * Created by posam on 2016-11-21.
 */
public class Apple {
    String name = "apple";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int sum(ArrayList<Integer> arr) {
        int s = 0;
        for (Integer i : arr) {
            s+=i;
        }
        return s;
    }
    public static int fibo(int number) {
        if (number < 1) {
            return 0;
        }else if (number < 3) {
            return 1;
        }
        return (fibo(number-2)+fibo(number-1));
    }


}
