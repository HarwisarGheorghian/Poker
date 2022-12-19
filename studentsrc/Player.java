package studentsrc;
import java.util.*;

import studentsrc.*;

public class Player{
    //Make the attribute money(int), totalRankValue(int), and name(string)
    private Card[] hand = new Card[2]; //Creates a hand of size two
    private String[] displayingHand = new String[2]; //Creates a string based hand
    private EnumMap<Token, Integer> tokenCounter = new EnumMap<Token, Integer>(Token.class);

    //Define the player constructor
        //Assign money to 100
        tokenCounter.put(Token.ONE, 10);
        tokenCounter.put(Token.FIVE, 2);
        tokenCounter.put(Token.TEN, 3);
        tokenCounter.put(Token.FIFTY, 1);
    

    //make money getter
        //return money
    
    
    //make moeny setter
        //set money
    

    public EnumMap<Token, Integer> getTokenCounter(){ //Getter
        return tokenCounter;
    }

    public void setTokenCounter(Token t1, int x){ //Setter
        tokenCounter.put(t1, x);
    }

    //Make getters and setters for name

    public int getTotalRankValue(){ //Getter
        return totalRankValue;
    }
 
    public String[] getDisplayHand(){ //Getter
        displayingHand[0] = hand[0].displayCard();
        displayingHand[1] = hand[1].displayCard();
        return displayingHand;
    }

    public Card[] draw(Deck deck){ //Draws 2 cards from top deck
       hand = deck.drawCards();
       totalRankValue = hand[0].getRank() + hand[1].getRank();
       return hand;
    }

    public EnumMap<Token, Integer> convertTokens(int bet){ //Coverts money into tokens
        EnumMap<Token, Integer> convertedTokens = new EnumMap<Token, Integer>(Token.class); 
        int remainder = 0;
        remainder = bet / 50;
        remainder = Math.min(remainder, tokenCounter.get(Token.FIFTY));
        convertedTokens.put(Token.FIFTY, remainder);
        bet -= remainder * 50;
        remainder = bet / 10;
        remainder = Math.min(remainder, tokenCounter.get(Token.TEN));
        convertedTokens.put(Token.TEN, remainder);
        bet -= remainder * 10;
        remainder = bet / 5;
        remainder = Math.min(remainder, tokenCounter.get(Token.FIVE));
        convertedTokens.put(Token.FIVE, remainder);
        bet -= remainder * 5;
        remainder = bet / 1;
        convertedTokens.put(Token.ONE, remainder);
        return convertedTokens;
    }

    public int TokensToMoney(){ //converts tokens back into money
        return 50 * tokenCounter.get(Token.FIFTY) + 10 * tokenCounter.get(Token.TEN) + 5 * tokenCounter.get(Token.FIVE) + tokenCounter.get(Token.ONE);
    }

    public String tokenStats(){ //Generates token stats. Sort of like toString
        return "Player " + name + ":\n" + "50 Token: " + tokenCounter.get(Token.FIFTY) + "\n" + "10 Token: " + tokenCounter.get(Token.TEN)
        + "\n" + "5 Token: " + tokenCounter.get(Token.FIVE) + "\n" + "1 Token: " + tokenCounter.get(Token.ONE);
    }
}