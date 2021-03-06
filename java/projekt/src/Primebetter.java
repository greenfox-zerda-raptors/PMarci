import java.util.*;

/**
 * Created by posam on 2016-11-11.
 */
public class Primebetter {

    public static ArrayList<Integer> factor(Integer num) {
        ArrayList<Integer> prlist = new ArrayList<Integer>();
        for (int i = 2; i <= num; i++) {
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
                if (o.size() == 1) {
                    System.out.printf("\"%d\" is a prime number \n", input);
                } else {
                    System.out.printf("\"%d\" has the following factors: ", input);
                    for (int i = 0; i < o.size(); i++) {
                        System.out.print(o.get(i));
                        if (!(i + 1 == o.size())) {
                            System.out.print(" x ");
                        }
                    }
                    System.out.println("\nOr by count:");
                    HashSet<Integer> uniqueo = new HashSet<Integer>(o); //magic
                    for (int i = 0; i < uniqueo.size(); i++) {
                        System.out.print(uniqueo.toArray()[i] + " ");
                        String numString;
                        switch (Collections.frequency(o, uniqueo.toArray()[i])) {
                            case 1:
                                numString = "once";
                                break;
                            case 2:
                                numString = "twice";
                                break;
                            case 3:
                                numString = "thrice";
                                break;
                            default:
                                numString = String.format("%d times", Collections.frequency(o, o.get(i)));
                                break;
                        }
                        System.out.print(numString + "\n");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value\n" + e);
                sc.next();
            }
        }
    }
}
