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
            System.out.println("---------------------------------------------------------");
            System.out.println("Current Score: " + playerPoints + "-" + c1Points + "-" + c2Points);
        }
        if(playerPoints < c1Points && playerPoints < 100){
            if(playerPoints < c2Points){
                System.out.println("You Win, Congratulations!");
            }
            else{
                System.out.println("You Lose, Better Luck Next Time!");
            }
        }
        else if(playerPoints == c1Points || c1Points == c2Points || playerPoints == c2Points){
            System.out.println("Tie Game!");
        }
        else{
            System.out.println("You Lose, Better Luck Next Time!");
        }
    }

    /**
     * Function to end game
     * @param playerPoints - points player has
     * @param c1Points - points c1 has
     * @param c2Points - points c2 has
     * @return true, if any of the points equal or exceed 100
     */
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >=100;
    }

    /**
     * Generates a card
     * @return card, the generated card
     */
    private static String getCard() {
        String card = getFace() + getSuit();
        return card;
    }

    /**
     * Randomly generates the suit of the card
     * @return the constant assosciated with a letter for the suit (D, S, H, C)
     */
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

    /**
     * Randomly generates the face/number of the card
     * @return the number given or the constant assosciated with a letter for the face (2-10, A, J, Q, K)
     */
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

    /**
     * Plays a round of CrazyEights, which includes drawing the hands
     * @param in - Scanner for player input
     * @return currPoints, which is a string holding the points in this format [PlayerPts-C1Pts-C2Pts]
     */
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
            System.out.println("Computer 1 Hand: [" + XXcomputerCards(c1Hand) + "]");
            System.out.println("Computer 2 Hand: [" + XXcomputerCards(c2Hand) + "]");
            System.out.println("Top Card: [" + topCard + "]");

            //"7H 5D AC JS-9D"
            String temp = playerMove(in, playerHand, topCard);
            if(temp.indexOf("-") >= 0){
                playerHand = temp.substring(0, temp.indexOf("-"));
                topCard = temp.substring(temp.indexOf("-") + 1);
            }
            if(isLastCard(playerHand)){
                changeMove = true;
            }
            if(emptyHand(playerHand)){
                break;
            }

            temp = computerMove(c1Hand, topCard, changeMove);
            if(temp.indexOf("-") >= 0){
                c1Hand = temp.substring(0, temp.indexOf("-"));
                topCard = temp.substring(temp.indexOf("-") + 1);
            }
            if(isLastCard(c1Hand)){
                changeMove = true;
            }
            if(emptyHand(c1Hand)){
                break;
            }

            temp = computerMove(c2Hand, topCard, changeMove);
            if(temp.indexOf("-") >= 0){
                c2Hand = temp.substring(0, temp.indexOf("-"));
                topCard = temp.substring(temp.indexOf("-") + 1);
            }
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

    /**
     * Calculates the points by converting putting them into a string and transforming them into one value through integer addition
     * @param playerHand - cards the player has
     * @param c1Hand - cards c1 has
     * @param c2Hand - cards c2 has
     * @return the integer values of the points as a string in this format [PlayerPts-C1Pts-C2Pts]
     */
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
    
    /**
     * Takes the string of points and calculates the total value of them 
     * Numbers 2-10 excluding 8 worth face value, A worth 1, J worth 11, Q worth 12, K worth 13, 8 worth 50
     * @param pointStr - string of point values soon to become numbers Ex. (5A82J)
     * @return points, the points added up together
     */
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

    /**
     * Takes each card and gets the face value to put in a string
     * @param hand - hand that is being checked
     * @return points, the points written as a string Ex. (Ex. (5A82J))
     */
    private static String pointString(String hand) {
        int numCards = countOccurrences(hand, " ") + 1;
        if(hand.indexOf(" ") >= hand.length() - 2){
            numCards--;
        }
        int space = hand.indexOf(" ");
        int nextSpace = 0;
        String points = "";
        if(numCards == 1){
            points += hand.substring(0, 1);
        }
        else{
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
                        if(space >= hand.length() - 1){
                            points += hand.substring(space - 2, hand.length() - 1);
                        }
                        else{
                            points += hand.substring(space + 1, hand.length() - 1);
                        }
                    }
                    space = nextSpace;
                }
            }
        }
        return points;
    }

    /**
     * Counts the # of times str2 appears in str1
     * @param str1 - longer string
     * @param str2 - shorter string that we are checking if it appears in str1
     * @return count, the number of times str2 appears in str1
     */
    private static int countOccurrences(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            String substr = str1.substring(i, i + str2.length());
            if (str2.equals(substr))
               count++;
         }
         return count;
    }

    /**
     * Prints two XX's for every card in the computer's hand
     * @param hand - hand that is being checked
     * @return x, which holds "XX " multiplied by the # of cards
     */
    private static String XXcomputerCards(String hand) {
        int numCards = countOccurrences(hand, " ") + 1;
            String x = "";
            for(int i = 0; i < numCards - 1; i++){
                x += "XX ";
            }
        //outside of loop for formatting purposes
        x += "XX";
        return x;
    }

    /**
     * Checks if the string is empty (if the length is 0)
     * @param hand - hand that is being checked
     * @return true if the length is 0, false otherwise
     */
    private static boolean emptyHand(String hand) {
        if(hand.length() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Checks if there is one card left (if the length is 3)
     * @param hand - hand that is being checked
     * @return true if the length is <= 3, false otherwise
     */
    private static boolean isLastCard(String hand) {
        if(hand.length() <= 3){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * The way both c1 and c2 play. Quick rundown:
     * The computer draws if it cannot play.
     * The computer checks if it can play a card with the same suit. If it can, it plays.
     * If it can't it will check if it can play a card with the same face. If it can, it plays.
     * If neither work, it will then try to play an 8, changing it to a suit that is in their hand.
     * If any player is on their last card, the computer will attepmt to change the suit before trying to play a card of the same suit.
     * @param hand - hand that is being checked (c1Hand or c2Hand)
     * @param topCard - card at the top of the deck
     * @param changeMove - determines whether it should attempt to change the suit first if any player is on their last move
     * @return newHand, the computer's new hand after playing
     */
    private static String computerMove(String hand, String topCard, boolean changeMove) {
        String newHand = "";
        int indexCardPlayed = 0;
        int draws = 0;
        boolean flag = false;
        while(!canPlay(hand, topCard)){
            hand += " " + getCard();
            draws++;
            if(draws == 5){
                newHand = hand;
                return newHand;
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
                if(hand.substring(hand.indexOf(topCard.substring(1, 2)) - 1, hand.indexOf(topCard.substring(1, 2))).equals("0")){
                    indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 2;
                    newHand = getHand(indexCardPlayed, hand, true, false);
                }
                else{
                    indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 1;
                    newHand = getHand(indexCardPlayed, hand, false, false);
                }
            }
            else if(hand.indexOf(topCard.substring(2)) >= 0 && topCard.indexOf("10") >= 0){
                if(hand.substring(hand.indexOf(topCard.substring(2)) - 1, hand.indexOf(topCard.substring(2))).equals("0")){
                    indexCardPlayed = hand.indexOf(topCard.substring(2, 3)) - 2;
                    newHand = getHand(indexCardPlayed, hand, true, false);
                }
                else if(hand.substring(hand.indexOf(topCard.substring(2)) - 1, hand.indexOf(topCard.substring(2))).equals("8")){
                    if(!(hand.substring(hand.lastIndexOf(topCard.substring(2)) - 1, hand.lastIndexOf(topCard.substring(2))).equals("8"))){
                        if(hand.substring(hand.lastIndexOf(topCard.substring(2)) - 1, hand.lastIndexOf(topCard.substring(2))).equals("0")){
                            indexCardPlayed = hand.lastIndexOf(topCard.substring(2, 3)) - 2;
                            newHand = getHand(indexCardPlayed, hand, true, false);
                        }
                        else{
                            indexCardPlayed = hand.lastIndexOf(topCard.substring(2, 3)) - 1;
                            newHand = getHand(indexCardPlayed, hand, false, false);
                        }
                    }
                }
            }
        }
        else if(hand.indexOf(topCard.substring(1, 2)) >= 0 && topCard.indexOf("10") < 0){
            if(hand.substring(hand.indexOf(topCard.substring(1, 2)) - 1, hand.indexOf(topCard.substring(1, 2))).equals("0")){
                indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 2;
                newHand = getHand(indexCardPlayed, hand, true, false);
            }
            else{
                indexCardPlayed = hand.indexOf(topCard.substring(1, 2)) - 1;
                newHand = getHand(indexCardPlayed, hand, false, false);
            }
        }
        else if(hand.indexOf(topCard.substring(2)) >= 0 && topCard.indexOf("10") >= 0){
            if(hand.substring(hand.indexOf(topCard.substring(2)) - 1, hand.indexOf(topCard.substring(2))).equals("0")){
                indexCardPlayed = hand.indexOf(topCard.substring(2, 3)) - 2;
                newHand = getHand(indexCardPlayed, hand, true, false);
            }
            else if(hand.substring(hand.indexOf(topCard.substring(2)) - 1, hand.indexOf(topCard.substring(2))).equals("8")){
                if(!(hand.substring(hand.lastIndexOf(topCard.substring(2)) - 1, hand.lastIndexOf(topCard.substring(2))).equals("8"))){
                    if(hand.substring(hand.lastIndexOf(topCard.substring(2)) - 1, hand.lastIndexOf(topCard.substring(2))).equals("0")){
                        indexCardPlayed = hand.lastIndexOf(topCard.substring(2, 3)) - 2;
                        newHand = getHand(indexCardPlayed, hand, true, false);
                    }
                    else{
                        indexCardPlayed = hand.lastIndexOf(topCard.substring(2, 3)) - 1;
                        newHand = getHand(indexCardPlayed, hand, false, false);
                    }
                }
            }
            else if(!(hand.substring(hand.indexOf(topCard.substring(2)) - 1, hand.indexOf(topCard.substring(2))).equals("8"))){
                indexCardPlayed = hand.lastIndexOf(topCard.substring(2, 3)) - 1;
                newHand = getHand(indexCardPlayed, hand, false, false);
            }
            else{
                flag = true;
            }  
        }
        flag = true;
        if(hand.indexOf(topCard.substring(0, 1)) >= 0 && flag){
            if(hand.indexOf("10") >= 0 && topCard.indexOf("10") >= 0){
                indexCardPlayed = hand.indexOf(topCard.substring(0, 1));
                newHand = getHand(indexCardPlayed, hand, true, false);
            }
            else{
                indexCardPlayed = hand.indexOf(topCard.substring(0, 1));
                newHand = getHand(indexCardPlayed, hand, false, false);
            }
        }
        else if(hand.indexOf("8") >= 0 && flag){
            indexCardPlayed = hand.indexOf("8");
            newHand = getHand(indexCardPlayed, hand, false, true);
        }
        return newHand;
    }

    /**
     * Selects and plays the card for the computer
     * @param indexCardPlayed - index of the card selected
     * @param hand - hand that is being checked (c1Hand or c2Hand)
     * @param is10 - checks if the number being dealt with is a 10
     * @param is8 - checks if the number being dealh with is an 8
     * @return the computer's new hand after the move, while setting up the played card to be made the top card
     */
    private static String getHand(int indexCardPlayed, String hand, boolean is10, boolean is8) {
        String front = hand.substring(0, indexCardPlayed);
        String back = "";
        String card = "";
        if(!is10){
            if(hand.length() > 2){
                if(indexCardPlayed > hand.lastIndexOf(" ")){
                    front = hand.substring(0, indexCardPlayed - 1);
                }
                else{
                    back = hand.substring(indexCardPlayed + 3);
                }
            }
            card = hand.substring(indexCardPlayed, indexCardPlayed + 2);
        }
        else if(is8){
            if(hand.length() > 2){
                if(indexCardPlayed > hand.lastIndexOf(" ")){
                    front = hand.substring(0, indexCardPlayed - 1);
                }
                else{
                    back = hand.substring(indexCardPlayed + 3);
                }
            }
            card = is8(hand);
        }
        else{
            if(hand.length() > 3){
                if(indexCardPlayed > hand.lastIndexOf(" ")){
                    front = hand.substring(0, indexCardPlayed - 1);
                }
                else{
                    back = hand.substring(indexCardPlayed + 4);
                }
            }
            card = hand.substring(indexCardPlayed, indexCardPlayed + 3);
        }
        return front + back + "-" + card;
    }

    /**
     * Randomly picks a suit in the computer hand. If the suit is not in the hand, it will pick again.
     * @param hand - hand being checked
     * @return card, the changed suit
     */
    private static String is8(String hand) {
        String card = "";
        boolean validRoll = false;
        while(!validRoll){
            int roll = (int)(Math.random() * 4);
            if(roll == 0 && hand.indexOf("D") > 0 && hand.indexOf("8D") < 0){
                card = "8D";
                validRoll = true;
            }
            else if(roll == 1 && hand.indexOf("S") > 0 && hand.indexOf("8D") < 0){
                card = "8S";
                validRoll = true;
            }
            else if(roll == 2 && hand.indexOf("H") > 0 && hand.indexOf("8D") < 0){
                card = "8H";
                validRoll = true;
            }
            else if(roll == 3 && hand.indexOf("C") > 0 && hand.indexOf("8D") < 0){
                card = "8C";
                validRoll = true;
            }
        }
        return card;
    }

    /**
     * How the player moves. Prompts the player to enter a card in their hand, and will then play that card.
     * @param in - scanner for player input
     * @param hand - hand that is being checked. (playerHand)
     * @param topCard - card at the top of the deck
     * @return newHand, the player's new hand after their turn
     */
    private static String playerMove(Scanner in, String hand, String topCard) {
        boolean validInput = false;
        String newHand = "";
        String front = "";
        String back = "";
        int draws = 0;
        while(!canPlay(hand, topCard)){
            hand += " " + getCard();
            draws++;
            if(draws == 5){
                newHand = hand;
                return newHand;
            }
        }
        hand = hand.replaceAll("  ", " ");
        if(hand.substring(hand.length() - 1).equals(" ")){
            int space = hand.lastIndexOf(" ");
            hand = hand.substring(0, space);
        }
        System.out.println("This is your hand: [" + hand + "]");
        System.out.println("Top Card: [" + topCard + "]");
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
                        if(hand.length() >= 2 && hand.indexOf(card) < hand.length() - 2){
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
                            if(hand.indexOf(card) <= hand.length() - 3){
                                front = hand.substring(0, hand.indexOf(card));
                                if(hand.length() >= 2 && hand.indexOf(card) < hand.length() - 2){
                                    back = hand.substring(hand.indexOf(card) + 3);
                                }
                            }
                            else{
                                front = hand.substring(0, hand.indexOf(card));
                            }
                    }
                    else{
                        if(hand.indexOf(card) <= hand.length() - 3){
                            front = hand.substring(0, hand.indexOf(card));
                            if(hand.length() >= 3 && hand.indexOf(card) < hand.length() - 3){
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
                        if(hand.length() >= 2 && hand.indexOf(card) < hand.length() - 2){
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

    /**
     * Prompts the player to enter a suit to change the suit to and changes it.
     * @param in - scanner for player input
     * @param card - the card with the 8, allowing you to change the suit of that 8.
     * @return card, the string value of the 8 depending on the suit chosen.
     */
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

    /**
     * Checks if the computer or player can play with their current hand.
     * @param hand - hand that is being checked
     * @param topCard - top card of the deck
     * @return true if they can play, return false otherwise
     */
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
