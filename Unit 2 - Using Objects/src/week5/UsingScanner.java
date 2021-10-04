package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        exampleOne(in);
        exampleTwo(in);
        in.close();
    }

    private static void exampleOne(Scanner input) {
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello " + name + "!");
    }

    private static void exampleTwo(Scanner input) {
        System.out.print("Please enter a number: ");
        //double num = input.nextDouble();

        //use next line always and parse into the required type
        double num = Double.parseDouble(input.nextLine());

        double result = Math.pow(num, 2);
        System.out.println(result);
    }


}
