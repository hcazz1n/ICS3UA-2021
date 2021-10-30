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
    private static final String VALID_CARDS = "AH 2H 3H 4H 5H 6H 7H 8H 9H 10H JH QH KH AS 2S 3S 4S 5S 6S 7S 8S 9S 10S JS QS KS AC 2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC KC AD 2D 3D 4D 5D 6D 7D 8D 9D 10D JD QD KD";

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
        
        boolean changeMove = false;

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
        while(topCard.indexOf("8") >= 0){
            topCard = getCard();
        }

        while(!emptyHand(playerHand) || !emptyHand(c1Hand) || !emptyHand(c2Hand)){
            System.out.println("---------------------------------------------------------");
            System.out.println("Your Hand: [" + playerHand + "]");
            System.out.println("Computer 1 Hand: [" + c1Hand + "]");
            System.out.println("Computer 2 Hand: [" + c2Hand + "]");
            System.out.println("Top Card: [" + topCard + "]");

            //"7H 5D AC JS-9D"
            String temp = playerMove(in, playerHand, topCard);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            if(isLastCard(playerHand)){
                changeMove = true;
            }
            if(emptyHand(playerHand)){
                break;
            }

            temp = computerMove(c1Hand, topCard, changeMove);
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            if(isLastCard(c1Hand)){
                changeMove = true;
            }
            if(emptyHand(c1Hand)){
                break;
            }

            temp = computerMove(c2Hand, topCard, changeMove);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            if(isLastCard(c2Hand)){
                changeMove = true;
            }
            if(emptyHand(c2Hand)){
                break;
            }
        }
        
        String currPoints = calculatePoints(playerHand, c1Hand, c2Hand);
        return currPoints;
    }
    

    private static String calculatePoints(String playerHand, String c1Hand, String c2Hand) {
        String playerPointsStr = "";
        String c1PointsStr = "";
        String c2PointsStr = "";
        int playerPoints = 0;
        int c1Points = 0;
        int c2Points = 0;
        if(playerHand.length() > 0){
            playerPointsStr = pointString(playerHand);
            playerPoints = pointInt(playerPointsStr);
        }
        if(c1Hand.length() > 0){
            c1PointsStr = pointString(c1Hand);
            c1Points = pointInt(c1PointsStr);
        }
        if(c2Hand.length() > 0){
            c2PointsStr = pointString(c2Hand);
            c2Points = pointInt(c2PointsStr);
        }
        return Integer.toString(playerPoints) + "-" + Integer.toString(c1Points) + "-" + Integer.toString(c2Points);
    }

    private static int pointInt(String pointStr) {
        int points = 0;
        for(int i = 0; i < pointStr.length(); i++){
            if(pointStr.substring(i, i + 1).equals("A")){
                points += 1;
            }
            //As I am checking each index individually, for 10's, the 1 will be given a value of 1, and the 0 will be given a value of 9, making 10
            else if(pointStr.substring(i, i + 1).equals("0")){
                points += 9;            
            }
            else if(pointStr.substring(i, i + 1).equals("J")){
                points += 11;
            }
            else if(pointStr.substring(i, i + 1).equals("Q")){
                points += 12;
            }
            else if(pointStr.substring(i, i + 1).equals("K")){
                points += 13;
            }
            else if(pointStr.substring(i, i + 1).equals("8")){
                points += 50;
            }
            else{
                points += Integer.parseInt(pointStr.substring(i, i + 1));
            }
        }
        return points;
    }

    private static String pointString(String hand) {
        int numCards = countOccurrences(hand, " ") + 1;
        int space = hand.indexOf(" ");
        int nextSpace = 0;
        String points = "";
        for(int i = 1; i <= numCards; i++){
            if(i == 1){
                points += hand.substring(0, space - 1);
            }
            else{
                if(space + 3 < hand.length()){
                    nextSpace = hand.indexOf(" ", space + 1);
                    points += hand.substring(space + 1, hand.indexOf(" ", nextSpace) - 1);
                }
                else{
                    points += hand.substring(space + 1, hand.length() - 1);
                }
                space = nextSpace;
            }
        }
        return points;
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

    private static boolean emptyHand(String hand) {
        if(hand.length() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean isLastCard(String hand) {
        if(hand.length() <= 3){
            return true;
        }
        else{
            return false;
        }
    }

    private static String computerMove(String hand, String topCard, boolean changeMove) {
        String newHand = "";
        int indexCardPlayed = 0;
        int draws = 0;
        while(!canPlay(hand, topCard)){
            hand += " " + getCard();
            draws++;
            if(draws == 5){
                break;
            }
        }
        if(changeMove){
            String currentSuit = "";
            if(hand.indexOf(topCard.substring(0, 1)) >= 0 && topCard.indexOf("10") < 0){
                currentSuit = hand.substring(hand.indexOf(topCard.substring(0, 1)) + 1, hand.indexOf(topCard.substring(0, 1)) + 2);
                if(!(currentSuit.equals(topCard.substring(1, 2)))){
                    indexCardPlayed = hand.indexOf(topCard.substring(0, 1));
                    newHand = getHand(indexCardPlayed, hand, false, false);
                }
            }
            else if(hand.indexOf("10") >= 0 && topCard.indexOf("10") >= 0){
                currentSuit = hand.substring(hand.indexOf(topCard.substring(0, 2)) + 2, hand.indexOf(topCard.substring(0, 2)) + 3);
                if(currentSuit.equals(topCard.substring(2))){
                    if(hand.substring(hand.lastIndexOf(topCard.substring(0, 2)) + 2, hand.lastIndexOf(topCard.substring(0, 2)) + 3) != currentSuit){
                        indexCardPlayed = hand.lastIndexOf(topCard.substring(0, 1));
                        newHand = getHand(indexCardPlayed, hand, true, false);
                    }
                }
                else{
                    indexCardPlayed = hand.indexOf(topCard.substring(0, 1));
                    newHand = getHand(indexCardPlayed, hand, true, false);
                }
            }
            else if(hand.indexOf("8") >= 0){
                indexCardPlayed = hand.indexOf("8");
                newHand = getHand(indexCardPlayed, hand, false, true);
            }
            else if(hand.indexOf(topCard.substring(1, 2)) >= 0 && topCard.indexOf("10") < 0){
                indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 1;
                newHand = getHand(indexCardPlayed, hand, false, false);
            }
            else if(hand.indexOf(topCard.substring(2)) >= 0 && topCard.indexOf("10") >= 0){
                indexCardPlayed = hand.indexOf(topCard.substring(2, 3)) - 2;
                newHand = getHand(indexCardPlayed, hand, true, false);
            }
        }
        else if(hand.indexOf(topCard.substring(1, 2)) >= 0 && topCard.indexOf("10") < 0){
            if(topCard.substring(1, 2) == "0"){
                indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 2;
            }
            else{
                indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 1;
            }
            newHand = getHand(indexCardPlayed, hand, false, false);
        }
        else if(hand.indexOf(topCard.substring(2)) >= 0 && topCard.indexOf("10") >= 0){
            indexCardPlayed = hand.indexOf(topCard.substring(2, 3)) - 2;
            newHand = getHand(indexCardPlayed, hand, true, false);
        }
        else if(hand.indexOf(topCard.substring(0, 1)) >= 0){
            indexCardPlayed = hand.indexOf(topCard.substring(0, 1));
            newHand = getHand(indexCardPlayed, hand, false, false);
        }
        else if(hand.indexOf("8") >= 0){
            indexCardPlayed = hand.indexOf("8");
            newHand = getHand(indexCardPlayed, hand, false, true);
        }
        return newHand;
    }

    private static String getHand(int indexCardPlayed, String hand, boolean is10, boolean is8) {
        String front = hand.substring(0, indexCardPlayed);
        String back = "";
        String card = "";
        if(!is10){
            if(indexCardPlayed > hand.lastIndexOf(" ")){
                front = hand.substring(0, indexCardPlayed - 1);
            }
            else{
                back = hand.substring(indexCardPlayed + 3);
            }
            card = hand.substring(indexCardPlayed, indexCardPlayed + 2);
        }
        else if(is8){
            if(indexCardPlayed > hand.lastIndexOf(" ")){
                front = hand.substring(0, indexCardPlayed - 1);
            }
            else{
                back = hand.substring(indexCardPlayed + 3);
            }
            card = is8(hand);
        }
        else{
            if(indexCardPlayed > hand.lastIndexOf(" ")){
                front = hand.substring(0, indexCardPlayed - 1);
            }
            else{
                back = hand.substring(indexCardPlayed + 4);
            }
            card = hand.substring(indexCardPlayed, indexCardPlayed + 3);
        }
        return front + back + "-" + card;
    }

    private static String is8(String hand) {
        String card = "";
        int roll = (int)(Math.random() * 4);
            if(roll == 0 && hand.indexOf("D") > 0 && hand.indexOf("8D") < 0){
                card = "8D";
            }
            else if(roll == 1 && hand.indexOf("S") > 0 && hand.indexOf("8D") < 0){
                card = "8S";
            }
            else if(roll == 2 && hand.indexOf("H") > 0 && hand.indexOf("8D") < 0){
                card = "8H";
            }
            else if(roll == 3 && hand.indexOf("C") > 0 && hand.indexOf("8D") < 0){
                card = "8C";
            }
        return card;
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
            if(VALID_CARDS.indexOf(card) < 0){
                System.out.println("Invalid card!");
            }
            else if(hand.indexOf(card) < 0){
                System.out.println("You don't have that card!");
            }
            else{
                if(card.substring(0, 1).equals("8")){
                    if(hand.indexOf(card) <= hand.length() - 2){
                        front = hand.substring(0, hand.indexOf(card));
                        if(hand.length() > 2){
                            back = hand.substring(hand.indexOf(card) + 3);
                        }
                    }
                    else{
                        front = hand.substring(0, hand.indexOf(card) - 1);
                    }
                    card = card.replace(card, changeSuit(in, card));
                    newHand = front + back + "-" + card;
                    validInput = true;
                }
                else if(card.indexOf("10") >= 0 || topCard.indexOf("10") >= 0){
                    if(card.indexOf("10") < 0 && topCard.indexOf("10") >= 0){
                        if(card.indexOf(topCard.substring(1, 2)) > 0){   
                            if(hand.indexOf(card) <= hand.length() - 3){
                                front = hand.substring(0, hand.indexOf(card));
                                if(hand.length() > 3){
                                    back = hand.substring(hand.indexOf(card) + 3);
                                }
                            }
                            else{
                                front = hand.substring(0, hand.indexOf(card) - 1);
                            }
                        }
                    }
                    else{
                        if(hand.indexOf(card) <= hand.length() - 3){
                            front = hand.substring(0, hand.indexOf(card));
                            if(hand.length() > 3){
                                back = hand.substring(hand.indexOf(card) + 4);
                            }
                        }
                        else{
                            front = hand.substring(0, hand.indexOf(card) - 1);
                        }
                        
                    }
                    newHand = front + back + "-" + card;
                    validInput = true;
                }
                else if(card.indexOf(topCard.substring(0, 1)) >= 0 || card.indexOf(topCard.substring(1, 2)) >= 0){
                    if(hand.indexOf(card) <= hand.length() - 2){
                        front = hand.substring(0, hand.indexOf(card));
                        if(hand.length() > 2){
                            back = hand.substring(hand.indexOf(card) + 3);
                        }
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
