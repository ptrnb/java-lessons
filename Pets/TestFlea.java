//
//  TestFlea.java
//  Pets
//
//  Created by Peter Brown on Fri Dec 20 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class TestFlea {

    public static void main(String[] args) {
        
        try {
            PetDog myPet = new PetDog("Fang", "Chihuahua");
            PetDog yourPet = (PetDog)myPet.clone();
            yourPet.setName("Gnasher");
            yourPet.getFlea().setName("Atlas");
            System.out.println("\nYour pet details:\n" + yourPet);
            System.out.println("\nMy pet details:\n" + myPet);
        } catch(CloneNotSupportedException e) {
            System.out.println(e);
        }
        
    }

}
