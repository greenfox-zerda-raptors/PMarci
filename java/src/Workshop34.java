/**
 * Created by Marci on 2016.11.03..
 */
public class Workshop34 {
    public static void main(String[] args) {
        for (int l = 0; l <= 100; l+=1) {
            if (l%15==0)
                System.out.println("FizzBuzz");
            else if (l%3==0)
                System.out.println("Fizz");
            else if (l%5==0)
                System.out.println("Buzz");
            else
                System.out.println(l);
        }
    }
}
