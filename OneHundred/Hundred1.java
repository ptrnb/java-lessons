
public class Hundred1 {

    public static void main( String[] args ) {

        int consoleWidth = 80;
        int lineWidth = 0;
        String out = "";

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < 100; j++) {
                out += args[i];
                lineWidth += args[i].length() + 1;
                if ( lineWidth < consoleWidth ) {
                    out += " ";
                } else {
                    out += "\n";
                    lineWidth = 0;
                }
            }
        }
        System.out.println(out);
    }
}
