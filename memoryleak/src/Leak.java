/*
 * Leak.java
 *
 * Created on 2005/01/06, 11:00
 */

package memoryleak;

import java.util.*;
import java.io.*;

/**
 *
 * @author root
 */
public class Leak {
    Hashtable hashtable = new Hashtable();
    Square sq[] = new Square[10];

    /** Creates a new instance of Leak */
    public Leak() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Leak testhash = new Leak();
        for(int i=0; i<100000; i++) {
            testhash.create(i);
            testhash.use(i);
            testhash.release();
        }
    }

    // Create Square objects.
    void create(int i) {
        for(int j=0; j<10; j++) {
            long index = j+i*10;
            sq[j] = new Square(index);
            hashtable.put(sq[j].num, sq[j]);
        }
    }

    // Use Square objects.
    void use(int i) {
        for(int j=0; j<10; j++) {
            System.out.print(((Square)(hashtable.get(sq[j].num))).square + " ");
        }
        System.out.println();
    }

    void release() {
        for(int j=0; j<10; j++) {
            sq[j] = null;
        }
    }

}

class Square {
    String num;
    String square;
    public Square(long num) {
        this.num = new Long(num).toString();
        this.square = new Long(num*num).toString();
    }
}
