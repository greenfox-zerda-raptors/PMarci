import java.util.*;

/**
 * Created by posam on 2016-11-11.
 */
public class Primebetter {

    public static ArrayList<Integer> factor(Integer num) {
        ArrayList<Integer> prlist = new ArrayList<Integer>();
        for (int i = 2; i <= num / 2; i++) {
            while (num % i == 0) {
                num /= i;
                prlist.add(i);
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
                ArrayList<Integer> o = factor(input);
                if (o.isEmpty()) {
                    System.out.printf("\"%d\" is a prime number \n", input);
                } else {
                    System.out.printf("\"%d\" has the following factors: ", input);
                    for (int i = 0; i < o.size(); i++) {
                        System.out.print(o.get(i) + " x ");
                    }
                    System.out.println("\nOr by count:-");
                    HashSet<Integer> uniqueo = new HashSet<Integer>(o);
                    for (int i = 0; i < uniqueo.size(); i++) {
                        System.out.print(uniqueo.toArray()[i] + " ");
                        String monthString;
                        switch (Collections.frequency(o, o.get(i))) {
                            case 1:
                                monthString = "once";
                                break;
                            case 2:
                                monthString = "twice";
                                break;
                            case 3:
                                monthString = "thrice";
                                break;
                            default:
                                monthString = String.format("%d times", Collections.frequency(o, o.get(i)));
                                break;
                        }
                        System.out.print(monthString + "\n");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value\n" + e);
                sc.next();
            }
        }
    }
}
