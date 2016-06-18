//
//  PetDog.java
//  Animal
//
//  Created by Peter Brown on Fri Dec 20 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class PetDog extends Animal implements Cloneable {

    public PetDog(String name, String breed) {
        super("Dog");
        petFlea = new Flea("Max", "circus flea");
        this.name = name;
        this.breed = breed;
    }

    // Rename dog
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Flea getFlea() {
        return petFlea;
    }

    public void sound() {
        System.out.println("Woof");
    }

    public String toString() {
        return super.toString() + "\nIt's " + name + " the " + breed + " & \n"  + petFlea;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Flea petFlea;
    private String name;
    private String breed;

}
