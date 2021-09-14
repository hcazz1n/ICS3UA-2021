package week2;
/**
 * Write a program to calculate the slope of a line give (x1, y1) and (x2,y2).
 */
public class hw8 {
    public static void main(String[] args) {
        int x1 = 5, y1 = 8;
        int x2 = 3, y2 = 7;
        double slope = ((double)y2 - y1) / (x2 - x1);

        System.out.println(slope);
    }
}
