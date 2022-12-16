package src;
import src.*;
import java.util.*;
import java.util.function.Consumer;
public class Game{
    Player[] thePlayers;
    private Stages stage; 
    public enum Stages{
        START,
        DEALCARDS,
        BET,
        PLACECARDS,
        END;
    }

    public Game(Player[] players){
        this.thePlayers = players;
    }

    public Stages getStage(){
        return stage;
    }

    public void setStage(Stages set){
        stage = set;
    }

    //Allows player the specify the amount of tokens used. Changes per stage
    public void maxBet(int index){ //need to specify the index of the player
        Scanner sc = new Scanner(System.in);
        int amt = sc.nextInt();
        if(this.stage == Stages.START){ // You can't use any tokens above 5
            while(amt > 5){ // repeat until they choose a value less than 5
                System.out.println("You cant bet more than 5 dollars during the start phase.");
                amt = sc.nextInt();
            }
            this.thePlayers[index].getTokenCounter().put(Tokens.ONE, this.thePlayers[index].getKeyValue(Tokens.ONE) - 5);
            this.thePlayers[index].setMoney(this.thePlayers[index].getMoney() - amt);
        } else if(this.stage == Stages.BET){
            while(amt > this.thePlayers[index].getMoney()){
                System.out.println("You don't have that amount of money. Please choose a different bet");
                amt = sc.nextInt();
            }
            int[] tokenChange = moneyToTokens(index, amt);
            
            int j = 0;
            final Integer innerJ = new Integer(j); //index to iterate through moneyToTokens returned array
            Consumer<Map.Entry<Tokens, Integer>> action = entry ->
            {
                this.thePlayers[index].getTokenCounter().put(entry.getKey(), this.thePlayers[index].getKeyValue(entry.getKey()) - tokenChange[innerJ]);
                innerJ = innerJ + 1;
            };


            this.thePlayers[index].getTokenCounter().entrySet().forEach(action);
        }
        
    }
    public int[] moneyToTokens(int index, int amount){ //need to specify the index of the player
        int remainder = 0;
        int[] tokenCounts = new int[4];
        remainder = amount / 50;
        tokenCounts[0] = remainder;
        amount -= remainder * 50;
        remainder = amount / 10;
        tokenCounts[1] = remainder;
        amount -= remainder * 10;
        remainder = amount / 5;
        tokenCounts[2] = remainder;
        amount -= remainder * 5;
        remainder = amount / 1;
        tokenCounts[3] = remainder;

        return tokenCounts;

    }
}