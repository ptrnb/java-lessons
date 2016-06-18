//
//  ReadCharacters.java
//  ReadCharacters
//
//  Created by Peter Brown on Fri Apr 11 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;


public class ReadCharacters {

    public static void main (String args[]) {

        try {

            String dirName = "/tmp/junkdata";
            String fileName = "proverbs.txt";

            File input = new File(dirName, fileName);

            PushbackReader in = new PushbackReader(new BufferedReader(new FileReader(input)));

            int c;					// Character store

            while (true) {
                String number = "";			// String length as characters

                // Get the characters for the length
                while (Character.isDigit((char)(c = in.read()))) {
                    number += (char)c;
                }

                if (c == -1) {				// Test for EOF
                    break;				// End
                } else {				// If not eof
                    in.unread(c);			// Pushback the last character
                }

                char[] proverb = new char[Integer.parseInt(number) + 3];

                in.read(proverb);
                System.out.println(proverb);

            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
            return;
        } catch (IOException e) {
            System.err.println("A problem occured reading the input file " + e);
            return;
        }

    }
}
