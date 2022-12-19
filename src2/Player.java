package src2;
import java.util.*;

import src2.*;

public class Player{
    private int money;
    private int totalRankValue;
    private String name;
    private Card[] hand = new Card[2];
    private String[] displayingHand = new String[2];
    private EnumMap<Token, Integer> tokenCounter = new EnumMap<Token, Integer>(Token.class);

    public Player(){
        this.money = 100;
        tokenCounter.put(Token.ONE, 10);
        tokenCounter.put(Token.FIVE, 2);
        tokenCounter.put(Token.TEN, 3);
        tokenCounter.put(Token.FIFTY, 1);
    }

    public EnumMap<Token, Integer> getTokenCounter(){
        return tokenCounter;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getTotalRankValue(){
        return totalRankValue;
    }

    public String[] getDisplayHand(){
        displayingHand[0] = hand[0].displayCard();
        displayingHand[1] = hand[1].displayCard();
        return displayingHand;
    }

    public Card[] draw(Deck deck){
       hand = deck.drawCards();
       totalRankValue = hand[0].getRank() + hand[1].getRank();
       return hand;
    }

    public EnumMap<Token, Integer> convertTokens(int bet){
        EnumMap<Token, Integer> convertedTokens = new EnumMap<Token, Integer>(Token.class); 
        int remainder = 0;
        remainder = bet / 50;
        convertedTokens.put(Token.FIFTY, remainder);
        bet -= remainder * 50;
        remainder = bet / 10;
        convertedTokens.put(Token.TEN, remainder);
        bet -= remainder * 10;
        remainder = bet / 5;
        convertedTokens.put(Token.FIVE, remainder);
        bet -= remainder * 5;
        remainder = bet / 1;
        convertedTokens.put(Token.ONE, remainder);
        return convertedTokens;
    }

    public String tokenStats(){
        return name + "\n" + "50 Token: " + tokenCounter.get(Token.FIFTY) + "\n" + "10 Token: " + tokenCounter.get(Token.TEN)
        + "\n" + "5 Token: " + tokenCounter.get(Token.FIVE) + "\n" + "1 Token: " + tokenCounter.get(Token.ONE);
    }
}