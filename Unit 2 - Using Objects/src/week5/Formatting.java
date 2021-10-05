package week5;

public class Formatting {
    public static void main(String[] args) {
        //5:3.272;
        //5:03.272;

        int minutes = 5;
        double seconds = 3.27269420;

        //What I want is this: 5:03.272;

        //placeholders
        //ints -> %d
        //floating point numbers (doubles) -> %f

        //System.out.printf("blah%dtest %f", minutes, seconds);
        System.out.printf("%d:%06.3f", minutes, seconds);
        //6.3 -> .3 is the number of decimal places, 6 is the amount of padding (5 chars + 1 padding);
    }
}
