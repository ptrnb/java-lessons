
import java.net.*;

public class httpping {

    public static void main(String[] args) {
        String addr = args[0];
        try {
            URL u = new URL(addr);
            System.out.println(u.getProtocol());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
