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

    private static void processRunner(Scanner input) {
        String firstName, lastName;
        String mileOne, mileTwo, finishTime;
        String splitTwo, splitThree;

        System.out.print("Please enter your first and last name: ");
        String name = input.nextLine();
        System.out.print("Please enter the time of the first mile (Minutes:Seconds.Milliseconds): ");
        String m1 = input.nextLine();
        System.out.print("Please enter the time at the end of the second mile (Minutes:Seconds.Milliseconds): ");
        String m2 = input.nextLine();
        System.out.print("Please enter your total time (Minutes:Seconds.Milliseconds): ");
        String fT = input.nextLine();
        System.out.println("Name: " + name);
        System.out.println("Mile 1 Time: " + m1);
        System.out.println("Mile 2 Time: " + m2);
        System.out.println("Total Time: " + fT);

        splitTwo = subtractTimes(mileTwo, mileOne);
        splitThree = subtractTimes(finishTime, mileTwo);
    }

    /**
     * 
     * @param endTime
     * @param startTime
     * @return
     */
    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertSeconds(endTime);
        double startInSeconds = convertSeconds(startTime);

        double diffSeconds = endInSeconds - startInSeconds;

        return convertTime(diffSeconds);
    }

    private static double convertSeconds(String strTime) {
        String strMins = strTime.substring(0, strTime.indexOf(":"));
        int parsedMins = Integer.parseInt(strMins);
        int minsToSecs = 60 * parsedMins;

        String strSecs = strTime.substring(strTime.indexOf(":") + 1);
        double parsedSecs = Double.parseDouble(strSecs);

        double finalSecs = minsToSecs + parsedSecs;

        return finalSecs;
    }

    private static String convertTime(double totalSeconds) {
        int minutes = (int)totalSeconds / 60;
        double seconds = totalSeconds % 60;

        return minutes + ":" + seconds;
    }

}
