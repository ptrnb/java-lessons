//
//  Sphere.java
//  Geometry
//
//  Created by Peter Brown on Sun May 12 2002.
//  Copyright (c) 2001 __MyCompanyName__. All rights reserved.
//

public class Sphere {

    static final double PI = 3.14;
    static int count = 0;

    double radius = 5.0;
    double xCenter = 10.0;
    double yCenter = 10.0;
    double zCenter = 10.0;

    // Class constructors

    // First constructor
    Sphere()
    {
        radius = 1.0;
        ++count;
    }

    // Second constructor
    Sphere(double x, double y, double z)
    {
        this();

        // Set the coordinates of the center
        xCenter = x;
        yCenter = y;
        zCenter = z;
    }

    // Third constructor
    Sphere(double theRadius, double x, double y, double z)
    {
        this(x, y, z);
        radius = theRadius;
    }

    
    // Static method to report the number of objects created
    static int getCount()
    {
        return count;
    }

    // Instance method to calculate volume
    double volume()
    {
        return 4.0/3.0*PI*radius*radius*radius;
    }

    void changeRadius(double radius)
    {
        this.radius = radius;
    }
}
