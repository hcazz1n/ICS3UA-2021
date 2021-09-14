package week2;
/**
 * Math.sqrt(x), where x is a value can be used to calculate the square root. 
 * Given an equation in the format from question 7. 
 * Obtain the two roots. Given a, b, and c.
 */
public class hw10 {
    public static void main(String[] args) {
        int a = 5;
        int b = 20;
        int c = 8;
        int discriminant = (b * b) - 4 * a * c;
        double root1 = (-b + Math.sqrt(discriminant)) / 2 * a;
        double root2 = (-b - Math.sqrt(discriminant)) / 2 * a;

        System.out.println("The two roots are " + root1 + " and " + root2);
    }
}
