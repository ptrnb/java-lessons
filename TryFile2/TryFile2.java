//
//  TryFile2.java
//  TryFile2
//
//  Created by Peter Brown on Wed Apr 02 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
// 
import java.io.*;
import java.util.Date;

public class TryFile2 {

    public static void main (String args[]) {
        // insert code here...
        File myDir = new File("/Users/pbrown/Documents/Programming/Java/TryFile2");
        System.out.println(myDir.getAbsolutePath() + (myDir.isDirectory() ? " is" : " is not") + " a directory" );
        System.out.println("The parent of " + myDir.getName() + " is " + myDir.getParent());

        // Define a filename filter
        FilenameFilter select = new FileListFilter("T", "java");
        
        
        // Get contents of directory
        File[] contents = myDir.listFiles(select);

        // List contents
        if (contents != null) {
            System.out.println("\nThe " + contents.length + " items in the directory " + myDir.getName() + " are: ");
            for (int i = 0; i < contents.length; i++) {
                System.out.println( contents[i] + " is a " + (contents[i].isDirectory() ? " directory " : " file ")
                                    + " last modified " + new Date(contents[i].lastModified()));
            }
        } else {
            System.out.println(myDir.getName() + " is not a directory");
        }
        
        return;
    }
}
