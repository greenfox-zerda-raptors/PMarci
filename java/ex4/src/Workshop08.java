/**************************************************************************************************
 * Workshop: Practice Exceptions: Having raised exceptions, then what?  I'm looking to get some
 * closure here.  "Finally" would do... whatever else, this is what I need if something goes
 * wrong...
 *
 *
 *
 * So, I'm looking for the following output:
 * try - first statement
 * start - myMethod
 * An Exception Occurred
 * Finally I did this instead
 * ::::FINISH LINE:::: out of the try/catch/finally statement
 *
 **************************************************************************************************/
import java.util.*;

public class Workshop08 {

    public static void main(String args[]) // see Workshop07
    {
        try {
            System.out.println("try - first statement");
            System.out.println("start - myMethod");
            Workshop07.myMethod(7);
        }
        catch (Workshop07.MySevenException e) {
            System.out.println("An Exception Occurred: " + e.getMessage());
        }
        finally {
            System.out.println("Finally I did this instead");
        }
        System.out.println("::::FINISH LINE:::: out of the try/catch/finally statement");
    }
}