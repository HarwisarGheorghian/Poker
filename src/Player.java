import java.util.*;
enum Tokens{
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);

    private int value;
    Tokens(int value){
        this.value = value;
    }
}

public class Player{

    private int money;
    EnumMap<Tokens,Integer> tokensCounter = new EnumMap<Tokens,Integer>(Tokens.class);
    public Player(){
        this.money = 200;
        tokensCounter.put(Tokens.ONE, 10);
        tokensCounter.put(Tokens.FIVE, 8);
        tokensCounter.put(Tokens.TEN, 5);
        tokensCounter.put(Tokens.FIFTY, 2);
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int mon){
        money = mon;
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