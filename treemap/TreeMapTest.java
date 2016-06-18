
import java.util.*;

public class TreeMapTest {

    public static void main( String[] args ) {
        TreeMap m = new TreeMap();
        
        ArrayList l = new ArrayList();
        l.add("http://www.nextbyte.com.au/");
        l.add("http://www.apple.com/");

        ArrayList k = new ArrayList();
        k.add("http://www.welovebill.com.au/");
        k.add("http://www.microsoft.com/");

        m.put("Microsoft", k);
        m.put("Apple", l);

        Set s = m.entrySet();

        System.out.println(s);
    }
}
