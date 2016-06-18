//
//  PrimesFile.java
//  PrimesFile
//
//  Created by Peter Brown on Sun Apr 13 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class PrimesFile {

    static RandomAccessFile myFile = null;
    static boolean file = false;
    static long[] primes = new long[10];
    static int current = 0;

    final static int LONGSIZE = 8;
    
    public static void main (String args[]) {

        try {

            // Define file to store primes
            File myPrimes = new File("/tmp/junkdata/primes.bin");
            myFile = new RandomAccessFile(myPrimes, "rw");

            // Read the number of primes required
            FormattedInput in = new FormattedInput(); 		// Keyboard stream

            // Prompt for keyboard input
            System.out.print("Enter the number of primes required: ");
            int numPrimes = in.intRead();			// Number of primes required
            long count = myFile.length()/LONGSIZE;		// Number of primes in file
            long number = 0;					// Next number to be tested

            // Check for file contents
            if (count == 0) {
                file = false;
                primes[0] = 2;					// Seed the first prime
                primes[1] = 3;					// ... and the second
                current = 2;					// Index of next element
                count = 2;					// count of primes found up to now
                number = 5;					// Next integer to be tested
            } else {
                file = true;
                myFile.seek(myFile.length() - LONGSIZE);	// Get the last prime in file
                number = myFile.readLong() + 2;			// Next number to test (last prime + 2)
            }

            // Find additional primes required for total primes requested
            for ( ; count < numPrimes; number += 2) {
                if (primeTest(number)) {			// Test for a prime
                    primes[current++] = number;			// We got one
                    ++count;

                    if (current == primes.length) {		// Check for full array
                        myFile.seek(myFile.length());		// Go to end of file
                        for (int i = 0; i < primes.length; i++) {
                            myFile.writeLong(primes[i]);	// Write prime to file
                        }
                        current = 0;
                        file = true;
                    }
                }
            }

            // Check if there are still primes in the array
            if (current > 0) {					// Write array contents to file
                myFile.seek(myFile.length());			// Go to end of file
                for (int i = 0; i < current; i++) {
                    myFile.writeLong(primes[i]);
                }
                current = 0;
                file = true;
            }

            // Output primes
            outputPrimes(numPrimes);


                
        } catch (IOException e) {

            System.err.println("Error in main()\n" + e);

        }
    }

    // Test whether a number is a prime number
    static boolean primeTest(long number) {

        // The maximum divisor we need to try is the square root of number
        long limit = (long)Math.ceil(Math.sqrt((double)number));

        try {

            if (file) {						// Check whether we have a primes file

                long prime = 0;					// Stores prime from file
                myFile.seek(0);					// Go to start of file
                long primeCount = myFile.length()/LONGSIZE;	// Number of primes on file

                // Check the number using the primes from file
                for (int i = 0; i < primeCount; i++) {

                    prime = myFile.readLong();			// Read a prime

                    if (prime < limit) {			// No exact division - prime found
                        return true;
                    }

                    if (number % prime == 0) {			// Exact division - not a prime
                        return false;
                    }
                }
                
            }							

        } catch (IOException e) {				// Handle read error

            System.err.println("Error in primesTest():\n" + e);
            System.exit(1);

        }

        // Otherwise check for prime in memory
        for (int i = 0; i < current; i++) {

            if (primes[i] > limit) {				// No exact division - prime found
                return true;
            }

            if (number % primes[i] == 0) {			// Exact division - not a prime
                return false;
            }
        }

        return true;

    }

    // Method to display primes
    static void outputPrimes(long numPrimes) throws IOException {

        // Create a buffered formatted output stream
        FormatWriter out = new FormatWriter(new BufferedWriter(new FileWriter(FileDescriptor.out)), 12, true);

        myFile.seek(0);						// Go to start of file

        for (int i = 0; i < numPrimes; i++) {			// Output the primes
            long prime = myFile.readLong();
            if (i % 5 == 0) {
                out.println();
            }
            out.print(prime);
        }

        out.close();
    }

    
}
