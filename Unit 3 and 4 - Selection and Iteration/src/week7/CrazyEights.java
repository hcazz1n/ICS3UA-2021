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
        
        boolean playerLastCard = false;
        boolean c1LastCard = false;
        boolean c2LastCard = false;

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

        computerMove(c1Hand, topCard);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);

        computerMove(c2Hand, topCard);
        c2Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);

        return null;
    }

    private static String computerMove(String hand, String topCard) {
        String newHand = "";
        String front = "";
        String back = "";
        String card = "";
        int indexCardPlayed = 0;
        int draws = 0;
        while(!canPlay(hand, topCard)){
            hand += " " + getCard();
            draws++;
            if(draws == 5){
                break;
            }
        }
        if()
        if(hand.indexOf(topCard.substring(1, 2)) > 0){
            indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 1;
            front = hand.substring(0, indexCardPlayed);
            back = hand.substring((indexCardPlayed + 3));
            card = hand.substring(indexCardPlayed, indexCardPlayed + 2);
            newHand = front + back + "-" + card;
        }
        else if(hand.indexOf(topCard.substring(0, 1)) > 0){
            indexCardPlayed = hand.indexOf(topCard.substring(0, 1));
            front = hand.substring(0, indexCardPlayed);
            back = hand.substring((indexCardPlayed + 3));
            card = hand.substring(indexCardPlayed, indexCardPlayed + 2);
            newHand = front + back + "-" + card;
        }
        else if(hand.indexOf("8") > 0){
            if(hand.indexOf("D") > 0){
                card = "8D";
            }
            else if(hand.indexOf("S") > 0){
                card = "8S";
            }
            else if(hand.indexOf("H") > 0){
                card = "8H";
            }
            else if(hand.indexOf("C") > 0){
                card = "8C";
            }
        }


        return newHand;
    }

    private static String playerMove(Scanner in, String hand, String topCard) {
        boolean validInput = false;
        String newHand = "";
        String front = "";
        String back = "";
        int draws = 0;
        while(!canPlay(hand, topCard)){
            hand += " " + getCard();
            draws++;
            System.out.println("This is your new hand: [" + hand + "]");
            if(draws == 5){
                break;
            }
        }
        while(!validInput){
            System.out.print("Select a card to play: ");
            String card = in.nextLine();
            if(hand.indexOf(card) < 0){
                System.out.println("Invalid Card!");
            }
            else{
                if(card.substring(0, 1).equals("8")){
                    if(hand.indexOf(card) < hand.length() - 2){
                        front = hand.substring(0, hand.indexOf(card));
                        back = hand.substring(hand.indexOf(card) + 3);
                    }
                    else{
                        front = hand.substring(0, hand.indexOf(card) - 1);
                    }
                    card = card.replace(card, changeSuit(in, card));
                    newHand = front + back + "-" + card;
                    validInput = true;
                }
                else if(card.indexOf("10") >= 0 || topCard.indexOf("10") >= 0){
                    if(card.indexOf(topCard.substring(0, 2)) >= 0 || card.indexOf(topCard.substring(0, 1)) >= 0 || card.indexOf(topCard.substring(2)) >= 0 || card.indexOf(topCard.substring(1, 2)) >= 0){
                        if(hand.indexOf(card) < hand.length() - 3){
                            front = hand.substring(0, hand.indexOf(card));
                            back = hand.substring(hand.indexOf(card) + 4);
                        }
                        else{
                            front = hand.substring(0, hand.indexOf(card) - 1);
                        }
                        newHand = front + back + "-" + card;
                        validInput = true;
                    }
                }
                else if(card.indexOf(topCard.substring(0, 1)) >= 0 || card.indexOf(topCard.substring(1, 2)) >= 0){
                    if(hand.indexOf(card) < hand.length() - 2){
                        front = hand.substring(0, hand.indexOf(card));
                        back = hand.substring(hand.indexOf(card) + 3);
                    }
                    else{
                        front = hand.substring(0, hand.indexOf(card) - 1);
                    }
                    newHand = front + back + "-" + card;
                    validInput = true;
                }
                else{
                    System.out.println("You can't play that card!");
                }
            }
        }
        return newHand;
    }

    private static String changeSuit(Scanner in, String card) {
        boolean validSuit = false;
        while(!validSuit){
            System.out.print("Please change the suit to [H]earts, [C]lubs, [D]iamonds, or [S]pades: ");
            String answer = in.nextLine().toUpperCase();
            if(answer.equals("H") || answer.equals("HEARTS")){
                card = "8H";
                validSuit = true;
            }
            else if(answer.equals("C") || answer.equals("CLUBS")){
                card = "8C";
                validSuit = true;
            }
            else if(answer.equals("D") || answer.equals("DIAMONDS")){
                card = "8D";
                validSuit = true;
            }
            else if(answer.equals("S") || answer.equals("SPADES")){
                card = "8S";
                validSuit = true;
            }
            else{
                System.out.println("That's not a valid suit!");
            }
        }
        return card;
    }

    private static boolean canPlay(String hand, String topCard) {
        if(topCard.indexOf("10") >= 0){
            if(hand.indexOf(topCard.substring(0, 2)) >= 0 || hand.indexOf(topCard.substring(2, 3)) >= 0 || hand.indexOf("8") >= 0){
                return true;
            }
        }
        else{
            if(hand.indexOf(topCard.substring(0, 1)) >= 0 || hand.indexOf(topCard.substring(1, 2)) >= 0 || hand.indexOf("8") >= 0){
                return true;
            }
        }   
        return false;
    }

}
