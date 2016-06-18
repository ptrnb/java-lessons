//
//  TryPrimesOut.java
//  TryPrimesOut
//
//  Created by Peter Brown on Fri Apr 04 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//

import java.io.*;
import java.util.zip.*;

public class TryPrimesOut {

    public static void main (String args[]) {

        long[] primes = new long[200];
        primes[0] = 2;
        primes[1] = 3;
        int count = 2;

        long number = 5;

outer:
            for ( ;  count < primes.length; number += 2L) {

                // The max div we need to try is square root of number
                long limit = (long)Math.ceil(Math.sqrt((double)number));

                // Divide by all the primes up to limit
                for (int i = 1; i < count && primes[i] <= limit; i++) {
                    if (number % primes[i] == 0) {
                        continue outer;
                    }
                }

                primes[count++] = number;
            }

        try {
            String dirName = "/Users/pbrown/Documents/Programming/java/TryPrimesOut/temp";
            String fileName = "primes.bin";
            String zipName = "primes.zip";

            File aDir = new File(dirName);

            if (!aDir.exists()) {
                aDir.mkdir();
            } else {
                if (!aDir.isDirectory()) {
                    System.err.println(aDir + " is not a directory");
                    return;
                }
            }

            // Create file object

            File primesZip = new File(aDir, zipName);
            primesZip.createNewFile();

            // Create zip output stream
            ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(primesZip));

            // Create the zip entry for the file and write to the output stream
            ZipEntry myZipEntry = new ZipEntry(fileName);
            zipFile.putNextEntry(myZipEntry);

            // Create the output stream to the zip output stream
            DataOutputStream primeStream = new DataOutputStream(
                                           new BufferedOutputStream(zipFile));

            // Write primes to file
            for (int i = 0; i < primes.length; i++) {
                primeStream.writeLong(primes[i]);
            }

            primeStream.flush();
            zipFile.closeEntry();
            primeStream.close();

            System.out.println("File size = " + primeStream.size());
            System.out.println("Compressed file size = " + myZipEntry.getCompressedSize());

        } catch (IOException e) {
            System.out.println("An IO error occured: " + e);
        }

            

    }
}
