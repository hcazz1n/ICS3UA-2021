package week2;
/**
 * 	Create a program that can be used to calculate the final velocity 
 * of a car given the initial velocity, 
 * the acceleration of the car and the time that has elapsed using the following equation:
 * v = u + at
 */
public class hw4 {
    public static void main(String[] args) {
        int u = 0;
        double v;
        double a = 200.5;
        double t = 11.8;

        v = u + (a * t);

        System.out.println(v + " m/s");

    }
}
