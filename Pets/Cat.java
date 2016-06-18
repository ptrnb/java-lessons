//
//  Cat.java
//  Animal
//
//  Created by Peter Brown on Wed Dec 18 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class Cat extends Animal {

    // Constructors

    public Cat(String aName) {
        super("Cat");
        name = aName;
        breed = "Unknown";
    }

    public Cat(String aName, String aBreed) {
        super("Cat");
        name = aName;
        breed = aBreed;
    }

    public String toString() {
        return super.toString() + "\nIt's " + name + " the " + breed;
    }

    // A miawing method

    public void sound() {
        System.out.println("Miiaoow");
    }

    private String name;
    private String breed;
}
