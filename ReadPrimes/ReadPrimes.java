//
//  ReadPrimes.java
//  ReadPrimes
//
//  Created by Peter Brown on Wed Apr 09 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class ReadPrimes {

    public static void main (String args[]) {

        // Create a default formatted character output stream
        FormatWriter out = new FormatWriter(new BufferedWriter(new FileWriter(FileDescriptor.out)));

        try {

            // Create a file object and an input stream for the file
            String dirName = "/tmp/junkdata";
            String fileName = "primes.bin";

            File myFile = new File(dirName, fileName);

            DataInputStream primesInfile = new DataInputStream(new FileInputStream(myFile));

            long[] primes = new long[6];
            boolean EOF = false;

            while (! EOF) {

                int index = 0;

                try {

                    // Fill the array with primes
                    for (index = 0; index < primes.length; index++)
                        primes[index] = primesInfile.readLong();

                } catch (EOFException e) {
                    EOF = true;
                }

                // Output the number of primes in the array

                for (int j=0; j < index; j++) {
                    out.print(primes[j]);
                }
                out.println();
            }
            
            out.close();				// Flush and close the output stream
            primesInfile.close();			// Flush and close the input stream

        } catch (FileNotFoundException e) {
            System.err.println(e);
            return;
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e);
            return;
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

            
    }
}
