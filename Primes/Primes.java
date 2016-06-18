//
//  Primes.java
//
import java.util.*;

public class Primes {

    public static void main (String args[]) {
        // insert code here...
        int nPrimes = 50;
OuterLoop:
        for ( int i = 2; ; i++ )
        {
            for ( int j = 2; j < Math.sqrt(i); j++ )
            {
                if ( i % j == 0 )
                    continue OuterLoop;
            }
        System.out.println("Prime: " + i);
        if ( --nPrimes == 0 )
            break;
        }
    }
}
