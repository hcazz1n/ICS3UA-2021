package week11;

public class TokenPass {
   private int[] tokens;
   private int currentPlayer;

   // Part (A)
   public TokenPass(int playerCount) {
    tokens = new int[playerCount];
    for(int i = 0; i < playerCount; i++){
        tokens[i] = (int)(Math.random() * 10) + 1;
    }
    currentPlayer = (int)(Math.random() * playerCount);
   }

   // Part (B)
   public void distributeCurrentPlayerTokens() {
      int numTokens = tokens[currentPlayer];
      int nextPlayer = currentPlayer + 1;
      while(numTokens > 0){
          if(nextPlayer == tokens.length){
              nextPlayer = 0;
          }
          tokens[nextPlayer]++;
          numTokens--;
          nextPlayer++;
      }
   }

}
