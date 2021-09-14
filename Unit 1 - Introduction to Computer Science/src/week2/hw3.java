package week2;
/**
 * Write a program that uses a five digit number and calculates the product of the 2nd and 4th digit. 
 * Use the modulus and and division operators.
 */
public class hw3 {
    public static void main(String[] args) {
        int num = 15874;
        int num2 = num / 1000 % 10;
        int num4 = num / 10 % 10;
        System.out.println(num);
        System.out.println(num2);
        System.out.println(num4);
    }
}
