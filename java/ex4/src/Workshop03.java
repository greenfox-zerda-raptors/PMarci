/**************************************************************************************************
 * Workshop: Practice With Exceptions: Arithmetic Overflow
 * Write a routine that catches an arithmetic overflow (that is, larger than the Integer.MAX_VALUE)
 * Note that Integer and int are NOT the same thing; and that Integer offers you properties such as
 * MAX_VALUE.
 * Use the Scanner routine to take the input from the keyboard; if the value is okay then
 * print "Yum", and then 1/2 the value entered.  For example:-
 * INPUT or 0 to end?  12334556677723131
 * Invalid value
 * (and the Java exception messages)
 * INPUT or 0 to end?  12345678
 * Yum 1234
 * INPUT or 0 to end?  123456
 * Yum 123
 * INPUT or 0 to end? 0
 * Bye!
 **************************************************************************************************/

import java.util.*;
public class Workshop03{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.print("INPUT or 0 to end? ");
                num = input.nextInt();
                if (num == 0) {
                    break;
                }
                System.out.println("Yum " + Integer.toString(num).substring(0, Integer.toString(num).length() / 2));
            } catch (InputMismatchException e) {
                System.out.println("Invalid value\n" + e);
                input.next();
            }
        }
        System.out.println("Bye!");
    } //main
} //Workshop03
