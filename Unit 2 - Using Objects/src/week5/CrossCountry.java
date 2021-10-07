package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    }

    /**
     * processRunner prompts the user to input their first and last name, as well as the times of the
     * first mile, second mile, and the final time. It then calculates the time of each split and displays
     * the runner's full name, the time of each split, and the finishing time.
     * @param input is a scanner which will check to see what is typed into the console and save it to
     * the variables it is used in
     */
    private static void processRunner(Scanner input) {
        String firstName, lastName;
        String mileOne, mileTwo, finishTime;
        String splitTwo, splitThree;

        System.out.print("Please enter your first name: ");
        firstName = input.nextLine();

        System.out.print("Please enter your last name: ");
        lastName = input.nextLine();

        System.out.print("Please enter the time of the first mile (Minutes:Seconds.Milliseconds): ");
        mileOne = input.nextLine();

        System.out.print("Please enter the time at the end of the second mile (Minutes:Seconds.Milliseconds): ");
        mileTwo = input.nextLine();

        System.out.print("Please enter your total time (Minutes:Seconds.Milliseconds): ");
        finishTime = input.nextLine();

        splitTwo = subtractTimes(mileTwo, mileOne);
        splitThree = subtractTimes(finishTime, mileTwo);

        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Mile 1/Split 1 Time: " + mileOne);
        System.out.println("Split 2 Time: " + splitTwo);
        System.out.println("Split 3 Time: " + splitThree);
        System.out.println("Total Time: " + finishTime);
    }

    /**
     * subtractTimes will take the values of two strings, convert them into doubles,
     * and then subtracts the values
     * @param endTime ending time as the initial string (bigger value)
     * @param startTime starting time as the initial string (smaller values)
     * @return will return the value of the difference converted back into String format
     */
    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertSeconds(endTime);
        double startInSeconds = convertSeconds(startTime);

        double diffSeconds = endInSeconds - startInSeconds;

        return convertTime(diffSeconds);
    }

    /**
     * convertSeconds will convert the value of the time string into a usable double value
     * @param strTime is the time in the String format, which will be later converted
     * @return returns the final converted value of the time in seconds as a double
     */
    private static double convertSeconds(String strTime) {
        String strMins = strTime.substring(0, strTime.indexOf(":"));
        int parsedMins = Integer.parseInt(strMins);
        int minsToSecs = 60 * parsedMins;

        String strSecs = strTime.substring(strTime.indexOf(":") + 1);
        double parsedSecs = Double.parseDouble(strSecs);

        double finalSecs = minsToSecs + parsedSecs;

        return finalSecs;
    }

    /**
     * convertTime takes the double value of the seconds and converts it back into String format
     * @param totalSeconds is the number of seconds that will be converted and formatted
     * @return returns a formatted version of totalSeconds as minutes:seconds.milliseconds as a String
     */
    private static String convertTime(double totalSeconds) {
        int minutes = (int)totalSeconds / 60;
        double seconds = totalSeconds % 60;

        return String.format("%d:%06.3f", minutes, seconds);
    }

}
