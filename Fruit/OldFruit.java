//
//  Fruit.java
//
import java.util.*;
import java.io.IOException;

public class Fruit {

    public static void main (String args[]) {
        // insert code here...
        int numOranges = 5;
        int numApples = 10;
        int numFruit = 0;

        numFruit = numOranges + numApples;
        // Display the result
        System.out.println("A totally fruity program");
        System.out.println("Total fruit is " + numFruit);
            
        //Code to delay ending the program
        System.out.println("press Enter to exit");
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            return;
        }
    }
}
