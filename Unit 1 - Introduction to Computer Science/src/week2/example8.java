package week2;
/**
 * Type casting
 */
public class example8 {
    public static void main(String[] args) {
        final int NUM_MARKS = 5;
        int markOne = 69, markTwo = 85, markThree = 80, markFour = 90, markFive = 95;

        double average = (double)(markOne + markTwo + markThree + markFour + markFive)/NUM_MARKS; //useful situation

        System.out.println("The average is: " + average);

        int x = (int)3.7; //narrowing conversion (losing precision) becomes 3 and truncates decimal
        //wihtout int type casting, this would be an errord

        double y = (double)3;
        double z = 3; //line 17 and 18 same thing
        
    }
}
