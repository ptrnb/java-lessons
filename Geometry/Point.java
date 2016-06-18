//
//  Point.java
//  Geometry
//
//  Created by Peter Brown on Sun May 12 2002.
//  Copyright (c) 2001 __MyCompanyName__. All rights reserved.
//

public class Point {

    // Coordinates of a point
    double x;
    double y;

    // Create a point from coordinates
    Point(double xVal; double yVal)
    {
        x = xVal;
        y = yVal;
    }

    // Create a point from another point object
    Point(final Point oldPoint)
    {
        x = oldPoint.x;
        y = oldPoint.y;
    }

    // Move a point
    void move(double xDelta, double yDelta)
    {
        x += xDelta;
        y += yDelta;
    }

    // Calculate the distance to another point
    double distance(final Point aPoint)
    {
        return Math.sqrt((x - aPoint.x)*(x - aPoint.x) + (y - aPoint.y)*(y - aPoint.y));
    }

    // Convert to a string
    public String toString()
    {
        return Double.toString(x) + ", " + y;
    }
    
}
