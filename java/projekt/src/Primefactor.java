import java.util.*;

/**
 * Created by posam on 2016-11-11.
 */
public class Primefactor {

    public static ArrayList<Integer> factoru (Integer num) {
        ArrayList<Integer> prlist = new ArrayList<Integer>();
        int j;
        for (int i = 2; i <= Math.sqrt(num) / 2; i++) {
            if (num % i == 0) {
                if (prlist.isEmpty()) {
                    prlist.add(i);
                }
                for (ListIterator<Integer> iterator = prlist.listIterator(); iterator.hasNext(); ) {
                    j = iterator.next();
                    if (i % j == 0) {
                        break;
                    } else if (!iterator.hasNext()) {
                        iterator.add(i);
                    } else if (i == j) {
                        iterator.add(i);
                    }
                }
            }
        }
            return prlist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter a number to test, or 0 to Quit: ");
            try {
                Integer input = sc.nextInt();
                if (input == 0) {
                    System.out.println("Bye!");
                    break;
                }
                ArrayList<Integer> o = factoru(input);
                if (o.isEmpty()) {
                    System.out.printf("\"%d\" is a prime number \n", input);
                } else {
                System.out.printf("%d has the following unique prime factors: ", input);
                    int i;
                for (i = 0; i < o.size()-1; i++) {
                    System.out.print(o.get(i) + ",  ");
                }
                    System.out.print(o.get(i));
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid value\n" + e);
                sc.next();
            }
        }
    }
}
