//
//  Animal.java
//  Animal
//
//  Created by Peter Brown on Wed Dec 18 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class Animal implements Cloneable {

    public Animal(String aType) {
        type = new String(aType);
    }

    public String toString() {
        return "This is a " + type;
    }

    //Dummy method to be implemented in derived classes
    public void sound() {}

    private String type;

}
