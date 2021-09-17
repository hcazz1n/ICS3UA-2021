package week2;

public class StringExamples {
    public static void main(String[] args) {
        String s1 = "This is a String Literal";
        String s2 = "This is a String Literal";
        String s3 = new String("This is a String Literal"); //not a string literal but string object
        

        System.out.println(s1.length());
        System.out.println(s1.equals(s2));
        System.out.println(s1.indexOf("in")); //returns -1 if not there

        String s4 = "0123456789";
        System.out.println(s4.substring(3)); //starts at index 3, goes to end
        System.out.println(s4.substring(3, 7)); //starts at index 3, goes to index 6


    }
}
