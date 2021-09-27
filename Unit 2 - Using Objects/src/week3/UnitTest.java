package week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(threeCopies("happy", 1));
        System.out.println(threeCopies("computer", 3));
        System.out.println(removeChars("Computer Science", 3, 4));
    }

    /**
     * Write a function that accepts a string and an int that represents an index. Obtain two characters
     * at that index and return 3 copies of that string. 
     */

     public static String threeCopies(String str, int index) {
        String s = str.substring(index, index + 2); //gets two characters starting at index
        return s + s + s;
     }

     public static String removeChars(String str, int index, int n) {
        String front = str.substring(0, index);
        String back = str.substring(index + n);
        return front + back;
     }

     public static double sqrtSum(int number) { //ex 6384
         int num1 = number / 1000; 
         int num2 = number / 100 % 10;
         int num3 = number / 10 % 10;
         int num4 = number % 10;

         int sum = num1 + num2 + num3 + num4;

         return Math.sqrt(sum);


     }
}
