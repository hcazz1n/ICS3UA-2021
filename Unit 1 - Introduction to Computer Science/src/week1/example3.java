package week1;
        /**
         * escape sequences
         */
public class example3 {
    public static void main(String[] args) {
        //System.out.println("This is "very" important"); //compile error because double quotes encapsulate a string literal and we added extra quotes
        System.out.println("This is \"very\" important"); //escape the quote by creating an escape sequence using \
        //System.out.println("This is \very important"); //AP cares about \" \n \\; cannot escape v
        System.out.println("This is \\very important");
        System.out.println("This\nis\nvery\nimportant"); // \n is new line
    }
}
