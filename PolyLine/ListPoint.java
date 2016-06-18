//
//  ListPoint.java
//  PolyLine
//
//  Created by Peter Brown on Sat Dec 21 2002.
//  Copyright (c) 2002 __MyCompanyName__. All rights reserved.
//
import java.io.*;

public class ListPoint implements Serializable {

    // Constructor

    public ListPoint(Point aPoint) {
        this.point = aPoint;
        next = null;
    }

    // Set the pointer to the next point

    public void setNext(ListPoint next) {
        this.next = next;
    }

    public ListPoint getNext() {
        return next;
    }

    public String toString() {
        return "{" + point + "}";
    }

    private Point point;
    private ListPoint next;

}
