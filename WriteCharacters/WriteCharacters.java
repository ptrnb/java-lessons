//
//  WriteCharacters.java
//  WriteCharacters
//
//  Created by Peter Brown on Mon Apr 07 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;
import java.util.*;

public class WriteCharacters {

    public static void main (String args[]) {
        try {
            String dirName = "/Users/pbrown/Documents/Programming/java/WriteCharacters";
            String fileName = "proverbs.txt";
            File output = new File(dirName, fileName);
            output.createNewFile();

            if (!output.isFile()) {
                System.out.println("Creating " + output.getPath() + " failed");
                return;
            }

            // Create output stream to append data to file
            BufferedWriter out = new BufferedWriter(
                                       new FileWriter(output.getPath(), true));

            String[] sayings = {
                "Indecision maximises flexibility",
                "Only the mediocre are always at their best",
                "A little knowledge is a dangerous thing",
                "Many a mickle makes a muckle",
                "A wise man sits on the hole in his carpet" };

            // Write the proverbs to the file
            for (int i = 0; i < sayings.length; i++) {
                out.write(sayings[i].length() + " : " + sayings[i]);
                out.newLine();
            }

            out.close();

        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e);
        }
    }
}
