//
//  PolyLine.java
//  PolyLine
//
//  Created by Peter Brown on Sat Dec 21 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//
import java.util.*;
import java.io.*;

public class PolyLine implements Serializable {

    // Constructor
    
    public PolyLine(Point[] points) {

        if (points != null) {
            // create a one point list
            start = new ListPoint(points[0]);
            end = start;

            // now add other points
            for (int i = 1; i < points.length; i++) {
                addPoint(points[i]);
            }
        }

    }

    // Constructor for list of coords

    public PolyLine(double[][] coords) {

        if (coords != null) {
            start = new ListPoint( new Point(coords[0][0], coords[0][1]));
            end = start;

            for (int i = 1; i < coords.length; i++ ) {
                addPoint(coords[i][0], coords[i][1]);
            }
        }

    }

    // Add a point object to list

    public void addPoint(Point point) {
        
        ListPoint newEnd = new ListPoint(point);
        if (start == null) {
            start = newEnd;
        } else {
            end.setNext(newEnd);
        }
        
    }

    public void addPoint(double x, double y) {
        addPoint( new Point(x, y) );
    }

    // String repr

    public String toString() {

        StringBuffer str = new StringBuffer("Polyline:");
        ListPoint nextPoint = start;
        while(nextPoint != null) {
            str.append(" " + nextPoint);
            nextPoint = nextPoint.getNext();
        }
        return str.toString();

    }

    private ListPoint start;
    private ListPoint end;
    
}
