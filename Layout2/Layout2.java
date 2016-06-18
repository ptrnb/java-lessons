//
//  Layout2.java
//  Layout2
//
//  Created by Peter Brown on 5/03/05.
//  Copyright (c) 2005 __MyCompanyName__. All rights reserved.
//
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Layout2 {

    public static void main (String args[]) {
        Layout2 gui = new Layout2();
        gui.go();
    }
    
    public void go() {
        JFrame frame = new JFrame();

        JButton east = new JButton("East");
        JButton west = new JButton("West");
        JButton north = new JButton("North");
        JButton south = new JButton("South");
        JButton centre = new JButton("Centre");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, centre);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
