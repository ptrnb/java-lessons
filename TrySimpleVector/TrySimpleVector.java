//
//  TrySimpleVector.java
//  TrySimpleVector
//
//  Created by Peter Brown on Mon Apr 14 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class TrySimpleVector {

    public static void main (String args[]) {

        Vector names = new Vector();
        Vector names2 = new Vector();

        String[] firstnames = { "Jack", "Jill", "John", "Joan", "Jeremiah", "Josephine"};

        for (int i = 0; i < firstnames.length; i++) {
            names.add(firstnames[i]);
        }

        Iterator theData = names.iterator();

        while(theData.hasNext()) {
            System.out.println(theData.next());
        }

    }
}
