//
//  WeatherFan.java
//
import java.util.*;

public class WeatherFan {

    public static void main (String args[]) {
        // insert code here...
        float[][] temperature = new float[10][365];

        for ( int i = 0; i < temperature.length; i++ )
            for ( int j = 0; j < temperature[i].length; j++)
                temperature[i][j] = (float)(45.0 * Math.random() - 10.0);

        for ( int i = 0; i < temperature.length; i++ )
        {
            float average = 0.0f;

            for ( int j = 0; j < temperature[0].length; j++ )
                average += temperature[i][j];

            System.out.println("Average temperature at location " + (i + 1) + " = " + average/(float)temperature.length);
        }
    }
}
