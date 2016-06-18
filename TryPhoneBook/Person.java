//
//  Person.java
//  TryVector
//
//  Created by Peter Brown on Mon Apr 14 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class Person implements Comparable, Serializable {

    // Private members
    private String firstName;				// First name of person
    private String lastName;				// Last name of person

    // Static methods
    
    // Read a person from the keyboard
    public static Person readPerson() {

        FormattedInput in = new FormattedInput();

        // Read the first name and strip
        System.out.println("/nEnter the first name:");
        String firstName = in.stringRead().trim();

        // Read the last name and strip
        System.out.println("/nEnter the last name:");
        String lastName = in.stringRead().trim();

        return new Person(firstName, lastName);

    }

    // Public methods 

    // Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }



    // Sorting algorithm
    public int compareTo(Object aPerson) {

        int result = lastName.compareTo(((Person)aPerson).lastName);
        return result == 0 ? firstName.compareTo(((Person)aPerson).firstName) : result;

    }

    // For hashcode
    public boolean equals(Object person) {
        return compareTo(person) == 0;
    }

    // Hashcode
    public int hashCode() {
        return 7 * firstName.hashCode() + 13 * lastName.hashCode();
    }


}
