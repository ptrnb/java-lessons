//
//  Duck.java
//  Animal
//
//  Created by Peter Brown on Wed Dec 18 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class Duck extends Animal {

    public Duck(String aName) {
        super("Duck");
        name = aName;
        breed = "Unknown";
    }

    public Duck(String aName, String aBreed) {
        super("Duck");
        name = aName;
        breed = aBreed;
    }

    public String toString() {
        return super.toString() + "\nIts " + name + " the " + breed;
    }

    // A quack method
    public void sound() {
        System.out.println("Quack quack quack");
    }

    private String name;
    private String breed;
}
