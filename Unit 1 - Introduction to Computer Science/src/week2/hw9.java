package week2;
/**
 * Write a program that given the number of pennies, nickles, dimes, quarters, 
 * loonies and toonies calculates how much money the user has.
 */
public class hw9 {
    public static void main(String[] args) {
        int pennies = 20;
        int nickels = 5;
        int dimes = 15;
        int quarters = 3;
        int loonies = 60;
        int toonies = 7;
    
        double totalAmount = pennies * 0.01 + nickels * 0.05 + dimes * 0.1 + quarters * 0.25 + loonies * 1 + toonies * 2;
    
        System.out.println("You Have: $" + totalAmount);
    }
}