package week2;
/**
 * Write a program that can calculate the volume of a sphere.
 */
public class hw6 {
    public static void main(String[] args) {
        final double pi = 3.14159;
        int radius = 2;

        double volume = (double)4/3 * pi * (radius * radius * radius);

        System.out.println(volume);
    }
}
