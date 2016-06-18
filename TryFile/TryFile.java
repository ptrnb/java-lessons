//
//  TryFile.java
//  TryFile
//
//  Created by Peter Brown on Wed Apr 02 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;
import java.io.*;


public class TryFile {

    public static void main (String args[]) {
        // insert code here...
        File myDir = new File("/Users/pbrown/Documents/Programming/java/TryFile");
        System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not") + " a directory.");

        //Create a file object
        File myFile = new File(myDir, "TryFile.java");
        System.out.println(myFile + (myFile.exists() ? " does" : " does not") + " exist");
        System.out.println("You can" + (myFile.canRead() ? " " : " not") + " read " + myFile);
        System.out.println("You can" + (myFile.canWrite() ? " " : " not") + " write to " + myFile);

    }
}
