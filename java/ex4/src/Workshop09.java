/**************************************************************************************************
 * Workshop: Practice Exceptions: I have to have it my way.  When an exception occurs, I want a
 * special error message, namely "7's are cannibals!" printed.
 *
 *
 * So, I'm looking for the following output:
 * try - first statement
 * start - myMethod
 * An Exception Occurred
 * 7's are cannibals
 * Finally I did this instead
 * ::::FINISH LINE:::: out of the try/catch/finally statement
 *
 * Refer to Workshop07
 **************************************************************************************************/
import java.util.*;

public class Workshop09{

    static void myMethod(int inNumber) throws Workshop07.MySevenException// something should appear here before
    {
        System.out.println("start - myMethod");
        if (inNumber == 7) {// do that thing that chucks the reprobate out
            throw new Workshop07.MySevenException("7's are cannibals");
        }
        System.out.println("Nice number");
        return;
    }

    public static void main(String  args[]) // see Workshop07
    {
        try {
            System.out.println("try - first statement");
            myMethod(7);
        }
        catch (Workshop07.MySevenException e) {
            System.out.println("An Exception Occurred");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Finally I did this instead");
        }
        System.out.println("::::FINISH LINE:::: out of the try/catch/finally statement");

    }
}
