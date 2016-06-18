//
//  TryNewPolyline.java
//  TryNewPolyline
//
//  Created by Peter Brown on Wed Apr 16 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;
import java.io.*;

public class TryNewPolyline {

    public static void main(String[] args) {

        // Create an array of coord pairs

        double[][] coords = { {1.,1.}, {1., 2.}, {2., 3.},
        {-3., 5.}, {-5, 1}, {0., 0.} };

        PolyLine polygon = new PolyLine(coords);

        System.out.println(polygon);

        polygon.addPoint(10., 10.);

        System.out.println(polygon);

        Point[] points = new Point[coords.length];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(coords[i][0], coords[i][1]);
        }

        PolyLine newPoly = new PolyLine(points);
        System.out.println(newPoly);

        // Write polyline objects to file
        try {

            // Create the output stream
            ObjectOutputStream objectOut =
            new ObjectOutputStream(
                                   new BufferedOutputStream(
                                                            new FileOutputStream("/tmp/junkdata/poly.bin")));

            objectOut.writeObject(polygon);
            objectOut.writeObject(newPoly);
            objectOut.close();

        } catch (NotSerializableException e) {
            System.err.println(e);
        } catch (InvalidClassException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

        // Read the objects back from file

        System.out.println("\nReading objects from file: ");

        try {

            // Open object stream
            ObjectInputStream objectIn =
            new ObjectInputStream(
                                  new BufferedInputStream(
                                                          new FileInputStream("/tmp/junkdata/poly.bin")));

            PolyLine theLine = (PolyLine)objectIn.readObject();
            System.out.println(theLine);
            theLine = (PolyLine)objectIn.readObject();
            System.out.println(theLine);
            objectIn.close();

        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }


    }
}
