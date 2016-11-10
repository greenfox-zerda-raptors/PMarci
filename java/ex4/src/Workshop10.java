/**************************************************************************************************
 * Workshop: Practice Exceptions: There are many types of exceptions, in the code that follows
 * look through what the problem is, and then figure out how to trap and continue
 *
 * Try first as a single Try/Catch, then write this as 3 separate Try/Catch
 *
 * SAMPLE RUN
 Hurdle 01
 nope

 ---- Change to 3 Try/Catch
 Hurdle 01
 nope
 Hurdle 02: Setup
 42
 Char 0 = T
 Hurdle 02: Catch
 nope
 Hurdle 03
 nope
 :::: FINISH LINE ::::
 **************************************************************************************************/

public class Workshop10{

    public static void main(String  args[]) {

        // you'll be putting these in try/catch and looking at the exception message; then figuring
        // out how to trap for that specific exception to continue through the code.
        String strTest = null;
        try {
            System.out.println("Hurdle 01");
            System.out.println(strTest.length());
        } catch (NullPointerException e) {
            System.out.println(e + " :(");
        }
            strTest = "The quick brown fox jump over the lazy dog";
            System.out.println("Hurdle 02: Setup");
            System.out.println(strTest.length());

            char c = strTest.charAt(0);
            System.out.println("Char 0 = " + c);
            try {
                System.out.println("Hurdle 02: Catch");
                c = strTest.charAt(strTest.length()); // I'm numerically challenged here
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e + " :(");
            }
            try {
                System.out.println("Hurdle 03");
                int num = Integer.parseInt(strTest);
            } catch (NumberFormatException e) {
                System.out.println(e + " :(");
            }
        System.out.println(":::: FINISH LINE ::::");
    }

}