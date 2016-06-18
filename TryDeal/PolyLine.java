//
//  PolyLine.java
//  TryNewPolyline
//
//  Created by Peter Brown on Wed Apr 16 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;
import java.io.*;

public class PolyLine implements Serializable {

    // Private variables

    // Storage for points for polyline
    private LinkedList polyline = new LinkedList();

    // Public methods
    
    // Construct a polyline from an array of points
    public PolyLine(Point[] points) {

        // Add the points
        for (int i = 0; i < points.length; i++) {
            polyline.add(points[i]);
        }

    }

    // Construct a polyline from an array of coordinates
    public PolyLine(double[][] coords) {

        // Add the coordinates
        for(int i = 0; i < coords.length; i++) {
            polyline.add(new Point(coords[i][0], coords[i][1]));
        }
    }

    // Add a Point object to the list
    public void addPoint(Point point) {
        polyline.add(point);
    }

    // Add a point to the list
    public void addPoint(double x, double y) {
        polyline.add(new Point(x, y));
    }

    // Print polyline
    public String toString() {

        Iterator theLine = polyline.iterator();

        StringBuffer str = new StringBuffer("PolyLine :");
        
        while(theLine.hasNext()) {
            str.append(" " + (Point)theLine.next());
        }

        return str.toString();

    }

}
