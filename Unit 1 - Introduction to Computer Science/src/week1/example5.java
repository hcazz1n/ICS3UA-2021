package week1;
    /** 
     * more of the same
     * integer vs. double math
     * modulous operator (getting the remainder)
    */
public class example5 {
    public static void main(String[] args) {
        int mark1 = 75, mark2 = 80, mark3 = 87; //declared and initialized on the same line

        double average = (mark1 + mark2 + mark3)/3.0; //use double to divide (3.0) to get 80.67 instead of 80
        //without the 3 being 3.0, although average is a double, it will NOT give you a decimal number

        //However, if one of the marks were a double, even if it was written without .0, you would
        //still obtain a decimal number
        
        System.out.println("The average is " + average);

        System.out.println(4/3); //1
        System.out.println(4/3.0); //1.3333333
        System.out.println(3/4); //0
        System.out.println(3.0/4); //0.75

    }
}
