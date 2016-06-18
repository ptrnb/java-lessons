//
//  PrimeCharacters.java
//  PrimeCharacters
//
//  Created by Peter Brown on Tue Apr 08 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class PrimeCharacters {

    public static void main (String args[]) {

        long[] primes = new long[20];		// Array to store primes
        primes[0] = 2;				// Seed the first prime
        primes[1] = 3;				// and the second
        int count = 2;				// Count for primes found - up to now
        long number = 5;			// Next integer to be tested

outer:
            for ( ; count < primes.length; number += 2) {
                long limit = (long)Math.ceil(Math.sqrt((double)number));

                for (int i = 1; i < count && primes[i] <= limit; i++) {
                    if (number % primes[i] == 0) {
                        continue outer;
                    }
                }
                primes[count++] = number;
            }

        FormatWriter out = new FormatWriter(new BufferedWriter(new FileWriter(FileDescriptor.out)), 5);

        for (int i = 0; i < primes.length; i++) {
            if (i % 5 == 0) {
                out.println();
            }
            
            out.print(primes[i]);
        }
        out.close();
    }
}
