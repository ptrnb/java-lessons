//
//  Crowd.java
//  TryVector
//
//  Created by Peter Brown on Mon Apr 14 2003.
//  Copyright (c) 2003 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class Crowd {

    // Constructors
    public Crowd() {
        // Create default vector
        people = new Vector();
    }

    public Crowd(int numPersons) {
        people = new Vector(numPersons);
    }

    // Add people to crowd
    public boolean add(Person someone) {
        return people.add(someone);
    }

    // Get the person at a given index
    public Person get(int index) {
        return (Person)people.get(index);
    }

    // Get number of people in crowd
    public int size() {
        return people.size();
    }

    // Get crowd capacity
    public int capacity() {
        return people.capacity();
    }

    // Get an iterator
    public Iterator iterator() {
        return people.iterator();
    }

    // Sort crowd
    public void sort() {
        Collections.sort(people);
    }

    // Store for people
    private Vector people;

}
