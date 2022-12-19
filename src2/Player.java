package src2;
import java.util.*;

import src2.*;

public class Player{
    private int money;
    private String name;
    private Card[] hand;
    private EnumMap<Token, Integer> tokenCounter = new EnumMap<Token, Integer>(Token.class);

    public Player(String name){
        this.money = 100;
        this.name = name;
        tokenCounter.put(Token.ONE, 10);
        tokenCounter.put(Token.FIVE, 2);
        tokenCounter.put(Token.TEN, 3);
        tokenCounter.put(Token.FIFTY, 1);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Card[] draw(Deck deck){
       hand = deck.drawCards();
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
}