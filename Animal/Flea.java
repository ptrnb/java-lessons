//
//  Flea.java
//  Animal
//
//  Created by Peter Brown on Fri Dec 20 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class Flea extends Animal implements Cloneable {

    public Flea(String aName, String aSpecies) {
        super("Flea");
        name = aName;
        species = aSpecies;
    }

    public void setName(String aName) {
        name = aName;
    }

    // Return name
    public String getName() {
        return name;
    }
    
    // Return species
    public String getSpecies() {
        return species;
    }

    public void sound() {
        System.out.println("Psst");
    }

    // Present a flea's details as a string
    public String toString() {
        return super.toString() + "\nIt's " + name + " the " + species;
    }

    // Override inherited clone to make it public
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String name;
    private String species;
}
