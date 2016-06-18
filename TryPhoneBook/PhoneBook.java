//
//  PhoneBook.java
//  TryPhoneBook
//
//  Created by Peter Brown on Thu Apr 17 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class PhoneBook implements Serializable {

    // private members
    private HashMap phonebook = new HashMap();

    // public methods
    public void addEntry(BookEntry entry) {
        phonebook.put(entry);
    }

    public BookEntry getEntry(Person key) {
        return (BookEntry)phonebook.get(key);
    }

    public PhoneNumber getNumber(Person key) {
        return getEntry(key).getNumber();
    }

    
}
