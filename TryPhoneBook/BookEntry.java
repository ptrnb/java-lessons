//
//  BookEntry.java
//  TryPhoneBook
//
//  Created by Peter Brown on Thu Apr 17 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class BookEntry implements Serializable {

    // Private members
    private Person person;
    private PhoneNumber number;
    
    // Public methods

    // Constructor
    public BookEntry(Person person, PhoneNumber number) {
        this.person = person;
        this.number = number;
    }

    // Get a person
    public Person getPerson() {
        return person;
    }

    // Get  number
    public PhoneNumber getNumber() {
        return number;
    }

    // Print entry
    public String toString() {
        return person.toString() + '\n' + number.toString();
    }

    // Read entry from keyboard
    public static BookEntry readEntry() {
        return new BookEntry(Person.readPerson(), PhoneNumber.readNumber());
    }
    
}
