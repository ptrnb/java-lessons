//
//  FormattedInput.java
//  FormattedInput
//
//  Created by Peter Brown on Sat Apr 12 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class FormattedInput {

    // Method to read a string
    public String stringRead() {

        try {

            for (int i = 0; i < 5; i++) {

                int tokenType = tokenizer.nextToken();		// Read a token

                if (tokenType == tokenizer.TT_WORD ||
                    tokenType == '\"') {			// Type is a string
                    return tokenizer.sval;
                } else if (tokenType == '!') {			// non-alpha type
                    return "!";
                } else {
                    System.out.println("Incorrect input. Re-enter a string between double quotes");
                    continue;
                }
                
            }

            System.out.println("Five failures reading a string" + " - program terminated");
            System.exit(1);
            return null;

        } catch (IOException e) {

            System.out.println(e);				// Output error
            System.exit(1);					// Exit
            return null;

        }
    }
                    

    // Method to read an int value...
    public int intRead() {

        try {
            for (int i = 0; i < 5; i++) {
                if (tokenizer.nextToken() == tokenizer.TT_NUMBER) {
                    return (int)tokenizer.nval;			// Value is numeric, so return as int
                } else {
                    System.out.println("Incorrect input: " + tokenizer.sval + " Re-enter an integer");
                    continue;
                }
            }

            System.out.println("Five failures reading an int value" + " - program terminated");

            System.exit(1);
            return 0;

        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
            return 0;
        }
    }
                
    
    // Method to read various other data types...


    // Object to tokenize input from the standard input stream

    private StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));

    
    public static void main (String args[]) {
        

    }
}
