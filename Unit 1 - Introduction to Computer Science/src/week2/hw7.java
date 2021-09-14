package week2;
/**
 * Create a program that can solve the equation y = ax2+bx+c given a, b, c and x.
 */
public class hw7 {
    public static void main(String[] args) {
        int a = 4, b = 6, c = 23, x = 8;
        int y = a * (x * x) + b * x + c;

        System.out.println(y);
    }
}
