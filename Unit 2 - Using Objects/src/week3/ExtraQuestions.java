package week3;

public class ExtraQuestions {
    public static void main(String[] args) {
        System.out.println(questionSeven("APPLE", "ORANGE"));
    }

    /**
     * Obtains and displays an integer between 1 and 100.
     */

    public static void questionOne() {
        int num = (int)(Math.random() * 100) + 1;
        System.out.println(num);
    }

    /**
      * Obtains and displays an integer between -50 and 50.
      */
    public static void questionTwo() { 
        int num = (int)(Math.random() * 101) - 50;
        System.out.println(num);
    }

    /**
     * Simulate the roll of a die by obtaining and returning an integer from 1 to 6.
     */
    public static int questionThree() {
        int diceRoll = (int)(Math.random() * 6) + 1;
        return diceRoll;
    }

    /**
     * Create a function that accepts 2 ints (smaller and bigger) 
     * and return a random integer between those two numbers inclusive.
     */
    public static int questionFour(int smaller, int bigger) { 
        int num = (int)(Math.random() * bigger) + smaller;
        return num;
    }

    /**
     * Create a function that accepts a String and returns a substring with the first "e" removed.
     */
    public static String questionFive(String str) {
        String firstString = str.substring(0, str.indexOf("e"));
        String endString = str.substring(str.indexOf("e") + 1);
        return firstString + endString;
    }

    /**
     * Create a function that accepts a String and a substring and then returns a 
     * String with the second string removed from the first String.
     */
    public static String questionSix(String str, int subStart, int subEnd) {
        String front = str.substring(0, subStart);
        String back = str.substring(subEnd + 1);
        return front + back;
    }

    /**
     * Create a function that accepts two Strings and returns the length of the two strings added together.
     */
    public static int questionSeven(String str1, String str2) {
        int answer = str1.length() + str2.length();
        return answer;
    }

    /**
     * Create a function that takes 4 integers (x1,y1, x2,y2) 
     * and obtains the slope of the line connecting those two points.
     */
    public static void questionEight(int x1, int y1, int x2, int y2) {
        double slope = (y2 - y1) / (x2 - x1);
        System.out.println(slope);
    }

    /**
     * Create a function that can be used to calculate the volume of a cylinder. 
     * Radius and Height are the parameters for the function.
     */
    public static void questionNine(int radius, int height) {
        final double pi = 3.14159;
        double volume = pi * Math.pow(radius, 2) * height;
        System.out.println(volume);
    }

    /**
     * Create a function that removes a random characters from a String and returns the new string.
     */
    public static String questionTen(String str) {
        int rando = (int)(Math.random() * str.length());
        String front = str.substring(0, rando);
        String back = str.substring(rando + 1);
        return front + back;
    }
}
