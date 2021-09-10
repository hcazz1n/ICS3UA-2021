package week1;
    /**
     * variables - used to store data
     * primitive data types - int(numbers)/double(decimals)/char(letters)/boolean(T/F)
     * assignment/assignment operator - Used to store values/data in variables
     */
public class example4 {
    public static void main(String[] args) {
        int mark1, mark2, mark3; //declared 3 integer variables

        mark1 = 75; //mark1 is assigned 75
        mark2 = 80; //mark2 is assigned 80
        mark3 = 87; //mark3 is assigned 87

        int average = (mark1 + mark2 + mark3)/3;

        System.out.println(average);
        System.out.println("The average is " + average); //string continuation - joined
    }
}
