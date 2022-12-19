package src;
import src.*;
import java.util.*;
import java.util.stream.Stream;
enum Tokens{
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);

    private int value;
    Tokens(int value){
        this.value = value;
    }

    public static Stream<Tokens> stream() {
        return Stream.of(Tokens.values());
    }
}

public class Player{

    private int money;
    private String name;
    private ArrayList<String> hand = new ArrayList<String>();
    private EnumMap<Tokens,Integer> tokensCounter = new EnumMap<Tokens,Integer>(Tokens.class);
    
    public Player(String names){
        this.money = 200;
        this.name = names;
        tokensCounter.put(Tokens.ONE, 10);
        tokensCounter.put(Tokens.FIVE, 8);
        tokensCounter.put(Tokens.TEN, 5);
        tokensCounter.put(Tokens.FIFTY, 2);
    }

    public EnumMap<Tokens,Integer> getTokenCounter(){
        return this.tokensCounter;
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int mon){
        money = mon;
    }

    public int getKeyValue(Tokens token){
        return tokensCounter.get(token);
    }

    public ArrayList<String> getHand(){
        return hand;
    }



    public String toString(){
        String stats = "STATS:\n" 
        + "Single Tokens: " + tokensCounter.get(Tokens.ONE) + "\n" 
        + "Five Tokens: " + tokensCounter.get(Tokens.FIVE) + "\n" 
        + "Ten Tokens: " + tokensCounter.get(Tokens.TEN) + "\n" 
        + "Fifty Tokens: " + tokensCounter.get(Tokens.FIFTY);
        return stats; 
    }
}