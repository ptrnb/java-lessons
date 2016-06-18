//
//  MathCalc.java
//
import java.util.*;

public class MathCalc {

    public static void main (String args[]) {
        // Calculate the radius of a circle
        // which has an area of 100 square metres
        double radius = 0.0;
        double circleArea = 100.0;
        int feet = 0;
        int inches = 0;
        radius = Math.sqrt(circleArea/Math.PI);
        feet = (int)Math.floor(radius);
        inches = (int)Math.round(12.0 * (radius - feet));
        System.out.println("The radius of the circle with area " + circleArea +
                           " square metres is \n " + feet + " feet " + inches +
                           " inches");
    }
}
