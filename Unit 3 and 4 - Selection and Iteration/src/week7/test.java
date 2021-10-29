package week7;

public class test {
    public static void main(String[] args) {
        String points = "";
        int numCards = 0;
        String playerPoints = "";
        String playerHand = "7H 5D 10S 8C 2C";
        String c1Points = "";
        String c2Points = "";
        if(playerHand.length() > 0){
            numCards = countOccurrences(playerHand, " ") + 1;
            int space = playerHand.indexOf(" ");
            for(int i = 0; i < numCards; i++){
                if(i == 0){
                    playerPoints += playerHand.substring(0, space - 1);
                }
                else if(i == 4){
                    playerPoints += playerHand.substring(space + 1, playerHand.length() - 1);
                }
                else{
                    int nextSpace = playerHand.indexOf(" ", space + 1);
                    playerPoints += playerHand.substring(space + 1, playerHand.indexOf(" ", nextSpace) - 1);
                    space = nextSpace;
                }
            }
        }
    }

    private static int countOccurrences(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            String substr = str1.substring(i, i + str2.length());
            if (str2.equals(substr))
               count++;
         }
         return count;
    }
}
