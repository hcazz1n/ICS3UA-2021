package week6;

public class ComparingObjects {
    public static void main(String[] args) {
        //to compare Strings (ANY Object) we should use the equals method (.equals)

        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = "hello"; //case-sensitive
        String str4 = str1;

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));

        //equals method defines how a class compares two instances of an object for equality

        String s1 = "ABCD";
        String s2 = "BCD";
        String s3 = "AACD";

        System.out.println("a".compareTo("a"));

    }
}
