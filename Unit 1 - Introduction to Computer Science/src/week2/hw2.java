package week2;
/**
 * Create a program that obtains two integers, one for the amount a test 
 * is out of and another indicating what a student received. 
 * Display what percentage the student received on the test.
 */
public class hw2 {
    public static void main(String[] args) {
        int maxMark = 104;
        int studentMark = 68;
        double calculation = (double)studentMark / maxMark * 100;
        int percentage = (int)(calculation + 0.5);
        System.out.println("The student got " + percentage + "%");
    }
}
