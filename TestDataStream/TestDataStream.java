//
//  TestDataStream.java
//  TestDataStream
//
//  Created by Peter Brown on Fri Apr 04 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;
import java.util.Date;

public class TestDataStream {

    public static void main (String args[]) {
        String myStr = new String("Garbage in, more garbage in");
        String dirName = "/Users/pbrown/Documents/Programming/java/TestDataStream/temp";

        try {
            File dir = new File(dirName);
            if (!dir.exists()) {
                dir.mkdir();
            } else {
                if (!dir.isDirectory()) {
                    System.out.println(dirName + " is not a directory");
                    return;
                }
            }

            File aFile = new File(dir, "data.txt");

            // Create a new file if necessary
            aFile.createNewFile();

            // Create byte output stream
            DataOutputStream myStream = new DataOutputStream(new FileOutputStream(aFile));

            // Write chars to stream
            myStream.writeChars(myStr);
        } catch (IOException e) {
            System.out.println("An IO error occured: " + e);
        }
    }
}
