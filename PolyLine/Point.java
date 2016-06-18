//
//  Point.java
//  PolyLine
//
//  Created by Peter Brown on Sat Dec 21 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class Point implements Serializable {

    // Create a point from coordinates

    public Point(double xVal, double yVal) {
        x = xVal;
        y = yVal;
    }

    // Create a point from another point

    public Point(Point aPoint) {
        x = aPoint.x;
        y = aPoint.y;
    }

    public String toString() {
        return x + ", " + y;
    }

    protected double x;
    protected double y;

}
