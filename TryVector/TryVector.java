//
//  TryVector.java
//  TryVector
//
//  Created by Peter Brown on Mon Apr 14 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;
import java.io.*;

public class TryVector {

    public static void main (String args[]) {

        Person aPerson;						// A person object
        Crowd filmCast = new Crowd();

        // Populate the crowd
        for ( ; ; ) {
            aPerson = readPerson();
            if (aPerson == null) {
                break;
            }
            filmCast.add(aPerson);
        }

        int count = filmCast.size();
        System.out.println("\nYou added " + count + (count == 1 ? " person" : " persons") + " to the cast.\n");

        // Show who is in the cast
        filmCast.sort();
        Iterator castList = filmCast.iterator();
        while (castList.hasNext()) {
            System.out.println(castList.next());
        }
        
    }

    // Read a person from the keyboard
    static public Person readPerson() {

        FormattedInput in = new FormattedInput();

        // Read in the firstname and strip blanks
        System.out.println("\nEnter first name or ! to end:");
        String firstName = in.stringRead().trim();		// Read and trim a string

        if (firstName.charAt(0) == '!') {
            return null;
        }

        // Read in surname and strip blanks
        System.out.println("\nEnter last name:");
        String lastName = in.stringRead().trim();		// Read and trim a string

        return new Person(firstName, lastName);

    }

}
