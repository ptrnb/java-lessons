//
//  spaniel.java
//  Animal
//
//  Created by Peter Brown on Fri Dec 20 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class Spaniel extends Dog{

    public Spaniel(String aName) {

        super(aName, "Spaniel");

    }

    public String toString() {

        return super.toString() + "\nIt's a spaniel";
    }
    
}
