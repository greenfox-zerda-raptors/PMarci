/**
 * Created by Marci on 2016.11.08..
 */
public class fibo {
    public static void main(String[] args) {
        System.out.println(fibo(6));
    }
    public static int fibo (int number) {
        if (number < 3) {
            return 1;
        }
        return (fibo(number-2)+fibo(number-1));
    }
}
