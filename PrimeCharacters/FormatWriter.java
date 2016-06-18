//
//  FormatWriter.java
//  PrimeCharacters
//
//  Created by Peter Brown on Tue Apr 08 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;


public class FormatWriter extends PrintWriter {

    private int width = 10;			// Field width for output

    // Basic constructor
    public FormatWriter(Writer output) {
        super(output);				// Call printstream constructor
    }

    // Constructor with specified width
    public FormatWriter(Writer output, int width) {
        super(output);				// Call printstream constructor
        this.width = width;			// Set field width
    }

    // Constructor with autoflush option
    public FormatWriter(Writer output, boolean autoflush) {
        super(output, autoflush);		// Call printstream constructor
    }

    // Constructor with specified width and autoflush
    public FormatWriter(Writer output, int width, boolean autoflush) {
        super(output, autoflush);		// Call printstream constructor
        this.width = width;			// Set field width
    }

    // Helper method for output
    private void output(String str) {

        int blanks = width - str.length();	// Number of blanks needed

        // If the length is less than width, add blanks
        for (int i = 0; i < blanks; i++) {
            super.print(' ');
        }
        super.print(str);
    }

    // Output type long formatted to a given width
    public void print(long value) {
        output(String.valueOf(value));
    }

    // Output type double formatted to a given width
    public void print(double value) {
        output(String.valueOf(value));
    }

    // Output type int formatted to a given width
    public void print(int value) {
        output(String.valueOf(value));
    }

    // Output type long and append newline
    public void println(long value) {
        this.print(value);
        super.println();
    }

    // Output type double and append newline
    public void println(double value) {
        this.print(value);
        super.println();
    }

    // Set width
    public void setWidth(int width) {
        this.width = width > 0 ? width : 1;
    }

    // Get width
    public int getWidth() {
        return this.width;
    }
    
}
