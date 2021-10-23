package week7;

import java.util.Scanner;

public class CrazyEights {
    private static final int SUITS = 4;
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    public static void main(String[] args) {
        int playerPoints = 0, c1Points = 0, c2Points = 0;
        Scanner in = new Scanner(System.in);

        while(!gameOver(playerPoints, c1Points, c2Points)){
            String result = playRound(in);
            int firstDash = result.indexOf("-");
            int secondDash = result.indexOf("-", firstDash + 1);
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            System.out.println("Current Score: " + playerPoints + "-" + c1Points + "-" + c2Points);
        }
    }

    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >=100;
    }

    private static String getCard() {
        String card = getFace() + getSuit();
        return card;
    }

    private static String getSuit() {
        int suit = (int)(Math.random() * SUITS);
        if(suit == 0){
            return DIAMONDS;
        }
        else if(suit == 1){
            return SPADES;
        }
        else if(suit == 2){
            return HEARTS;
        }
        else{
            return CLUBS;
        }
    }

    private static String getFace() {
        int face = (int)(Math.random() * CARDS_PER_SUIT);
        if(face >= 2 && face <= 10){
            return face + "";
        }
        else if(face == 1){
            return ACE;
        }
        else if(face == 11){
            return JACK;
        }
        else if(face == 12){
            return QUEEN;
        }
        else{
            return KING;
        }
    }

    private static String playRound(Scanner in) {
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";
        String topCard = "";

        for(int i=0; i < 4; i++){
            playerHand += getCard() + " ";
            c1Hand += getCard() + " ";
            c2Hand += getCard() + " ";
        }
        //5th card outside for formatting
        playerHand += getCard();
        c1Hand += getCard();
        c2Hand += getCard();

        topCard = getCard();

        System.out.println("Your Hand: [" + playerHand + "]");
        System.out.println("Computer 1 Hand: [XX XX XX XX XX]");
        System.out.println("Computer 2 Hand: [XX XX XX XX XX]");
        System.out.println("Top Card: [" + topCard + "]");

        //"7H 5D AC JS-9D"
        String temp = playerMove(in, playerHand, topCard);
        playerHand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
        /*
        computerMove(c1Hand, topCard);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
        computerMove(c2Hand, topCard);
        c2Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);
*/
        return null;
    }

    private static String computerMove(String hand, String topCard) {

        return null;
    }

    private static String playerMove(Scanner in, String hand, String topCard) {
        boolean validInput = false;
        String newHand = "";
        int draws = 0;
        /*
        while(!(canPlay(hand, topCard)) || draws < 5){
            hand += getCard() + " ";
            draws++;
        }
        */
        while(!validInput){
            System.out.print("Select a card to play: ");
            String card = in.nextLine();
            if(hand.indexOf(card) < 0){
                System.out.println("Invalid Card!");
            }
            else{
                if(card.indexOf(topCard.substring(0, 1)) > 0 || card.indexOf(topCard.substring(1, 2)) > 0){
                    String beforeDash = hand.substring(0, hand.indexOf(card));
                    String afterDash = hand.substring(hand.indexOf(card) + 3);
                    newHand = beforeDash + afterDash + "-" + card;
                    validInput = true;
                }
                else{
                    System.out.println("You can't play that card!");
                }
            }
        }
        return newHand;
    }

    private static boolean canPlay(String hand, String topCard) {
        if(hand.indexOf(topCard) > 0){
            return true;
        }
        return false;
    }

}
