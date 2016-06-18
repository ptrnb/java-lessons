//
//  ReadZippedPrimes.java
//  ReadZippedPrimes
//
//  Created by Peter Brown on Fri Apr 11 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;
import java.util.zip.*;

public class ReadZippedPrimes {

    public static void main (String args[]) {

        try {
            
            // Create a default formatted character output stream
            int charWidth = 16; 
            FormatWriter out = new FormatWriter(new BufferedWriter(new FileWriter(FileDescriptor.out)), charWidth);

            String dirName = "/tmp/junkdata";								// Dir for zip file
            String fileName = "primes.zip";								// Archive name

            File myPrimesZip = new File(dirName, fileName);						// File object to read

            ZipInputStream myZipFile = new ZipInputStream(new FileInputStream(myPrimesZip));

            ZipEntry myZipEntry = myZipFile.getNextEntry();

            out.println("Compressed file is " + myZipEntry.getName());

            DataInputStream primesIn = new DataInputStream(new BufferedInputStream(myZipFile));		// Create input stream

            long[] primes = new long[6];								// Array to hold primes
            boolean EOF = false;									// End of file flag

            while(! EOF) {

                int index = 0;
                try {
                    // Fill the array with primes from the file
                    for (index = 0; index < primes.length; index++) {
                        primes[index] = primesIn.readLong();
                    }
                } catch (EOFException e) {
                    EOF = true;
                }

                // Output the number of primes in the array
                for (int j = 0; j < index; j++) {
                    out.print(primes[j]);
                }
                out.println();

            }

            out.close();
            primesIn.close();

        // Handle IO and file errors
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return;
        } catch (IOException e) {
            System.err.println("Error reading input file " + e);
            return;
        }

    }
        
}
