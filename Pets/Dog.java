//
//  Dog.java
//  Animal
//
//  Created by Peter Brown on Wed Dec 18 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class Dog extends Animal {

    // Constructors for a Dog object

    public Dog(String aName) {
        super("Dog");
        name = aName;
        breed = "Unknown";
    }

    public Dog(String aName, String aBreed) {
        super("Dog");
        name = aName;
        breed = aBreed;
    }

    // A barking method

    public void sound() {
        System.out.println("Woof Woof");
    }

    
    private String name;
    private String breed;

}
