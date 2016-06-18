//
//  FileListFilter.java
//  TryFile2
//
//  Created by Peter Brown on Fri Apr 04 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//

import java.io.*;
import java.util.Date;

public class FileListFilter implements FilenameFilter {

    private String name;
    private String extension;

    // Constructor
    public FileListFilter(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public boolean accept(File directory, String filename) {
        boolean fileOK = true;

        // If there is aname filter specified, check the file name
        if (name != null) {
            fileOK &= filename.startsWith(name);
        }

        // If there is an extension filter, check the file extension
        if (extension != null) {
            fileOK &= filename.endsWith('.' + extension);
        }

        return fileOK;
    }
}
