//
//  TryInitialization.java
//  Geometry
//
//  Created by Peter Brown on Sun May 12 2002.
//  Copyright (c) 2001 __MyCompanyName__. All rights reserved.
//

public class TryInitialization {

    static int[] values = new int[10];

    //Initialization block

    
    static
    {
        System.out.println("Running initialization block");
        for (int i=0; i<values.length; i++)
            values[i] = (int)(100.0*Math.random());
    }

    void listValues()
    {
        System.out.println();
        for (int i=0; i<values.length; i++)
            System.out.print(" "  + values[i]);
        System.out.println();
    }

    public static void main(String[] args)
    {
        TryInitialization example = new TryInitialization();
        System.out.println("\nFirst object:");
        example.listValues();

        TryInitialization nextExample = new TryInitialization();
        System.out.println("\nSecond object:");
        nextExample.listValues();

        example.listValues();
    }

}
