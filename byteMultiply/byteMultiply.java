//
//  byteMultiply.java
//
import java.util.*;

public class byteMultiply {

    public static void main (String args[]) {
        // multiplies a byte var by a factor of 2, 8 times
        byte result = 1;
        byte totalCount = 8;
        byte count = 1;

        while (count <= totalCount) {
            result *= 2;
            System.out.println("Result is " + result);
            ++count;
        }
            
    }
}
