//
//  PhoneNumber.java
//  TryPhoneBook
//
//  Created by Peter Brown on Thu Apr 17 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class PhoneNumber implements Serializable {

    // Private members
    private String areacode;
    private String number;

    // Static methods

    // Read a number
    public static PhoneNumber readNumber() {

        FormattedInput in = new FormattedInput();

        // Read the areacode
        System.out.println("/nEnter the area code: ");
        String areacode = Integer.toString(in.intRead());
        
        // Read the number
        System.out.println("/nEnter the phone number: ");
        String number = Integer.toString(in.intRead());

        return new PhoneNumber(areacode, number);

    }
    
    // Public methods

    // Constructor
    public PhoneNumber(String areacode, String number) {

        this.areacode = areacode;
        this.number = number;

    }

    // Print number
    public String toString() {

        return areacode + ' ' + number;
        
    }
}

