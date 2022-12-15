package src;
import src.*;
import java.util.*;
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
    public int maxBet(int index){ //need to specify the index of the player
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
                
            }
        }
        return 1;
    }
}