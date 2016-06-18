//
//  Geometry.java
//
import java.util.*;

public class Geometry {

    public static void main (String args[]) {
        // insert code here...
        System.out.println("Number of spheres is " + Sphere.getCount());

        Sphere ball = new Sphere(4.0, 0.0, 0.0, 0.0);
        System.out.println("Number of balls is " + ball.getCount());

        Sphere globe = new Sphere(12.0, 1.0, 1.0, 1.0);
        System.out.println("Number of globes is " + Sphere.getCount());

        Sphere eightBall = new Sphere(10.0, 10.0, 0.0);
        Sphere oddBall = new Sphere();
        System.out.println("Number of globes is " + Sphere.getCount());

        // Output the volume of each sphere...
        System.out.println("ball volume = " + ball.volume());
        System.out.println("globe volume = " + globe.volume());
        System.out.println("eightBall volume = " + eightBall.volume());
        System.out.println("oddBall volume = " + oddBall.volume());

    }
}
