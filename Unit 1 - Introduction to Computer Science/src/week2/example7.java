package week2;

/**
 * final modifier - modifies the variable so that it becomes a constant
 */

public class example7 {
    public static void main(String[] args) {
        final int x=7;
        //x=8; //cannot change a final variable

        final int y;
        y=8;
        //y=2; //cannot change a final variable
        final int NUMBER_OF_VARIABLES = 15; //naming convention for final variable/constants, all uppercase with underscore separation
    }
}
