package week7;

import java.util.Scanner;

public class ThreeCardPoker {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final double CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;
    private static final int TIE = 3;
    private static final int STRAIGHT_FLUSH = 6;
    private static final int FLUSH = 5;
    private static final int STRAIGHT = 4;
    private static final int THREE_OF_A_KIND = 3;
    private static final int PAIR = 2;
    private static final int HIGH_CARD = 1;

   public static void main(String[] args) {
      // 7H AC KD
      Scanner in = new Scanner(System.in);
      int minBet = 50, maxBet = 100;
      int wallet = 500;

      boolean playAgain = true;
      while (playAgain) {
         wallet = playPokerHand(in, wallet, minBet, maxBet);
         if (wallet >= 100)
            playAgain = playAgain(in);
         else {
            System.out.println("You don't have enough money to play again!");
            playAgain = false;
         }
      }
   }

   private static boolean playAgain(Scanner in) {
      boolean validInput = false;

      while (!validInput) {
         System.out.println("Do you want to play again ([Y]es / [N]o)");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("YES") || answer.equals("Y"))
            return true;
         else if (answer.equals("NO") || answer.equals("N")) {
            return false;
         } else {
            System.out.println("Invalid Input: Yes or No only!");
         }
      }

      return false;
   }

   private static int playPokerHand(Scanner in, int wallet, int i, int j) {
      int bet = getWager(in, 50, 100, wallet);

      String playerHand = "";
      String dealerHand = "";

      playerHand = getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";

      dealerHand = getCard(playerHand + dealerHand) + " ";
      dealerHand += getCard(playerHand + dealerHand) + " ";
      dealerHand += getCard(playerHand + dealerHand) + " ";

      System.out.println(playerHand);
      System.out.println("XX XX XX");

      if(fold(in)){
          wallet -= bet;
          return wallet;
      }
    
      bet += getWager(in, 50, 100, wallet);
      playerHand = discard(in, playerHand);
      System.out.println("Player: " + playerHand);
      System.out.println("Dealer: " + dealerHand);

    if(getWinner(playerHand, dealerHand) == PLAYER_WINS){
        System.out.println("Player Wins!");
        wallet += bet;
    }
    else if(getWinner(playerHand, dealerHand) == DEALER_WINS){
        System.out.println("Dealer Wins!");
        wallet -= bet;
    }
    else{
        System.out.println("Tie!");
    }

    return wallet;

}

   private static int getWinner(String playerHand, String dealerHand) {
    if(getHandValue(playerHand) > getHandValue(dealerHand)){
        return PLAYER_WINS;
      }
      else if(getHandValue(dealerHand) > getHandValue(playerHand)){
        return DEALER_WINS;
      }
      else if(getHighCard(playerHand) > getHighCard(dealerHand)){
        return PLAYER_WINS;
      }
      else if(getHighCard(dealerHand) > getHighCard(playerHand)){
        return DEALER_WINS;
      }
      else{
          return TIE;
      }
}

private static int getHighCard(String cards) {
    return 0;
}

private static int getHandValue(String cards) {
    if(isFlush(cards) && isStraight(cards)){
        return STRAIGHT_FLUSH;
    }
    else if(isFlush(cards)) {
        return FLUSH;
    }
    else if(isStraight(cards)){
        return STRAIGHT;
    }
    else if(isThreeOfAKind(cards)){
        return THREE_OF_A_KIND;
    }
    else if(isPair(cards)){
        return PAIR;
    }
    else{
        return HIGH_CARD;
    }
}

private static boolean isFlush(String cards) {
    String card1 = cards.substring(1, 2);
    String card2 = cards.substring(4, 5);
    String card3 = cards.substring(7, 8);
    if(card1.equals(card2) && card1.equals(card3)){
        return true;
    }
    return false;
}

private static boolean isStraight(String cards) {
    int ace = 0;
    int jack = 11;
    int queen = 12;
    int king = 13;
    String card1 = cards.substring(0, 2);
    String card2 = cards.substring(4, 6);
    String card3 = cards.substring(8, cards.length() - 1);
    int numCard1 = 0, numCard2 = 0, numCard3 = 0;
    if(card1.indexOf("10") < 0){
        card1 = cards.substring(0, 1);
        if(card1.indexOf("J") < 0){
            numCard1 = jack;
        }
        else if(card1.indexOf("Q") < 0){
            numCard1 = queen;
        }
        else if(card1.indexOf("K") < 0){
            numCard1 = king;
        }
        else if(card1.indexOf("A") < 0){
            numCard1 = ace;
        }
        else{
            numCard1 = Integer.parseInt(card1);
        }
    }
    if(card2.indexOf("10") < 0){
        card2 = cards.substring(3, 4);
        if(card2.indexOf("J") < 0){
            numCard2 = jack;
        }
        else if(card2.indexOf("Q") < 0){
            numCard2 = queen;
        }
        else if(card2.indexOf("K") < 0){
            numCard2 = king;
        }
        else if(card2.indexOf("A") < 0){
            numCard2 = ace;
        }
        else{
            numCard2 = Integer.parseInt(card2);
        }
    }
    if(card3.indexOf("10") < 0){
        card3 = cards.substring(6, 7);
        if(card3.indexOf("J") < 0){
            numCard3 = jack;
        }
        else if(card3.indexOf("Q") < 0){
            numCard3 = queen;
        }
        else if(card2.indexOf("K") < 0){
            numCard3 = king;
        }
        else if(card2.indexOf("A") < 0){
            numCard3 = ace;
        }
        else{
            numCard3 = Integer.parseInt(card3);
        }
    }

    if(numCard1 - 1 == numCard2){
        if(numCard1 + 1 == numCard3){
            return true;
        }
        else if(numCard2 - 1 == numCard3){
            return true;
        }   
    }
    else if(numCard1 - 1 == numCard3){
        if(numCard1 + 1 == numCard2){
            return true;
        }
        else if(numCard3 - 1 == numCard2){
            return true;
        }
    }
    return false;
}

private static boolean isThreeOfAKind(String cards) {
    String card1 = cards.substring(0, 2);
    String card2 = cards.substring(4, 6);
    String card3 = cards.substring(8, cards.length() - 1);
    if(card1.indexOf("10") < 0){
        card1 = cards.substring(0, 1);
    }
    if(card2.indexOf("10") < 0){
        card2 = cards.substring(3, 4);
    }
    if(card3.indexOf("10") < 0){
        card3 = cards.substring(6, 7);
    }

    if(card1.equals(card2) && card1.equals(card3)){
        return true;
    }
    return false;
}

private static boolean isPair(String cards) {
    String card1 = cards.substring(0, 2);
    String card2 = cards.substring(4, 6);
    String card3 = cards.substring(8, cards.length() - 1);
    if(card1.indexOf("10") < 0){
        card1 = cards.substring(0, 1);
    }
    if(card2.indexOf("10") < 0){
        card2 = cards.substring(3, 4);
    }
    if(card3.indexOf("10") < 0){
        card3 = cards.substring(6, 7);
    }

    if(card1.equals(card2) || card1.equals(card3) || card2.equals(card3)){
        return true;
    }
    return false;
}

private static boolean fold(Scanner in) {
    boolean validInput = false;

      while (!validInput) {
         System.out.println("[F]old or [D]iscard");
         String answer = in.nextLine().toUpperCase();
         if (answer.equals("FOLD") || answer.equals("F"))
            return true;
         else if (answer.equals("DISCARD") || answer.equals("D")) {
            return false;
         } else {
            System.out.println("Invalid Input: Fold or Discard Only!");
         }
      }

      return false;
}

private static String getCard(String usedCards) {
      String card = getFace() + getSuit();

      while (usedCards.indexOf(card) >= 0) {
         card = getFace() + getSuit();
      }
      return card;
   }

   private static String getSuit() {
      int suit = (int) (Math.random() * NUM_SUITS);

      if (suit == 0)
         return HEARTS;
      else if (suit == 1)
         return DIAMONDS;
      else if (suit == 2)
         return CLUBS;
      else
         return SPADES;

   }

   private static String getFace() {
      int suit = (int) (Math.random() * CARDS_PER_SUIT);
      if (suit >= 2 && suit <= 10)
         return suit + "";
      else if (suit == 1)
         return ACE;
      else if (suit == 11)
         return JACK;
      else if (suit == 12)
         return QUEEN;
      else
         return KING;

   }

   private static int getWager(Scanner in, int minBet, int maxBet, int wallet) {
      boolean validBet = false;
      int bet = 0;
      while (!validBet) {
         System.out.print("Please enter your bet [$" + minBet + " - $" + maxBet + "]: ");
         try {
            bet = Integer.parseInt(in.nextLine());

            if (bet > maxBet || bet < minBet) {
               System.out.println("Your bet must be between [$" + minBet + " - $" + maxBet + "]");
            } else if (bet > wallet) {
               System.out.println("You only have $" + wallet);
            } else {
               validBet = true;
            }
         } catch (Exception ex) {
            System.out.println("Invalid Input!");
         }
      }

      return bet;
   }

   private static String discard(Scanner in, String playerHand) {
      int numCardsToReplace = getNumberToDiscard(in);
      String temp = playerHand;
      if (numCardsToReplace == 0)
         return playerHand;
      else if (numCardsToReplace == 3) {
         playerHand = getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
         playerHand += getCard(playerHand + temp) + " ";
      } else {
         String cardsToReplace = getCardsToDiscard(in, numCardsToReplace, playerHand);
         int space = cardsToReplace.indexOf(" ");
         String card1 = "";
         if (space == -1)
            card1 = cardsToReplace;
         else
            card1 = cardsToReplace.substring(0, space);

         String card = getCard(playerHand + temp);
         playerHand = playerHand.replace(card1, card);
         if (numCardsToReplace == 2) {
            String card2 = cardsToReplace.substring(space + 1);
            card = getCard(playerHand + cardsToReplace + temp);
            playerHand = playerHand.replace(card2, card);
         }
      }
      return playerHand;
   }

   private static int getNumberToDiscard(Scanner in) {
      boolean validInput = false;
      int val = 0;
      while (!validInput) {
         System.out.print("How many cards to discard [0,3]: ");
         try {
            val = Integer.parseInt(in.nextLine());

            if (val < 0 || val > 3) {
               System.out.println("Invalid input!");
            } else {
               validInput = true;
            }
         } catch (Exception ex) {
            System.out.println("Invalid input!");
         }
      }
      return val;
   }

   private static String getCardsToDiscard(Scanner in, int numCardsToReplace, String playerHand) {
      final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
      boolean validInput = false;
      String cards = "";
      while (!validInput) {
         System.out.println("Please enter the cards to replace: (ex. 7H KD): ");
         cards = in.nextLine().toUpperCase();
         if (countOccurences(cards, " ") != numCardsToReplace - 1) {
            System.out.println("You must choose " + numCardsToReplace + " cards.");
         } else if ((numCardsToReplace == 1) && VALID_CARDS.indexOf(cards) < 0) {
            System.out.println("Not a valid card: " + cards);
         } else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) < 0))
            System.out.println("You don't have a " + cards);
         else if ((numCardsToReplace == 1) && (playerHand.indexOf(cards) >= 0)) {
            validInput = true;
         } else if (numCardsToReplace == 2) {
            int space = cards.indexOf(" ");

            String card1 = cards.substring(0, space);
            String card2 = cards.substring(space + 1);
            if (VALID_CARDS.indexOf(card1) < 0)
               System.out.println("Not a valid card: " + card1);
            else if (VALID_CARDS.indexOf(card2) < 0)
               System.out.println("Not a valid card: " + card2);
            else if (playerHand.indexOf(card1) < 0)
               System.out.println("You don't have a " + card1);
            else if (playerHand.indexOf(card2) < 0)
               System.out.println("You don't have a " + card2);
            else if (card1.equals(card2))
               System.out.println("You cannot discard the same card.");
            else
               validInput = true;
         }

      }

      return cards;

   }

   private static int countOccurences(String str, String str2) {
      int count = 0;
      if (str2.length() > str.length())
         return 0;

      for (int i = 0; i < str.length(); i++) {
         String substr = str.substring(i, i + str2.length());
         if (str2.equals(substr))
            count++;
      }
      return count;

   }
}