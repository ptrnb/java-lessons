//
//  doubles.java
//
import java.util.*;

public class doubles {

    public static void main (String args[]) {
        // insert code here...
        double junk = 1234.5678;
        long integral;
        short remainder;

        integral = (long)Math.floor(junk);
        remainder = (short)((junk - integral) * 10000);
        System.out.println("The double value is " + integral + "." + remainder);
    }
}
