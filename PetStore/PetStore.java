//
//  PetStore.java
//  PetStore
//
//  Created by Peter Brown on 18/03/05.
//  Copyright (c) 2005 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class PetStore {

    String aName = null;
    Int randNum = 0;
    
    public static void main (String args[]) {
        ArrayList theList = new ArrayList();
        HashMap aDict = new HashMap();
        randNum = (Int) (Math.random() * theList.size())
    }
    
    public void setName(String name) {
        aName = name;
    }
    
    public String getName() {
        return aName;
    }
    
}
