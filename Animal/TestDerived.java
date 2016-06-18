//
//  TestDerived.java
//  Animal
//
//  Created by Peter Brown on Wed Dec 18 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//

public class TestDerived {

    public static void main(String[] args) {
        Dog aDog = new Dog("Fido", "Chiuahua");
        Dog starDog = new Dog("Lassie");
        System.out.println(aDog);
        System.out.println(starDog);
    }
}
