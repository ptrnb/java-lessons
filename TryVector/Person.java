//
//  Person.java
//  TryVector
//
//  Created by Peter Brown on Mon Apr 14 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//

public class Person implements Comparable {

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

    private String firstName;				// First name of person
    private String lastName;				// Last name of person

}
