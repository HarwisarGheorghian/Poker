package src;
import src.*;
import java.util.*;
public class Game{
    Player[] thePlayers;
    private Stages stage; 
    public enum Stages{
        START("Start"),
        DEALCARDS("Deal"),
        BET("Bet"),
        FOLD("Fold"),
        CHECK("Check"),
        PLACECARDS("Place cards"),
        END("End");

        private String desc;

        Stages(String description){
            this.desc = description;
        }

        public String getDescription(){
            return this.desc;
        }
    }

    //private String getStageDesc = stage.getDescription(); Useless

    public Game(Player[] player){
        this.thePlayers = player;
    }

    public Stages getStage(){
        return stage;
    }

    public void setStage(Stages set){
        stage = set;
    }

    /*public String getStageDescription(){
        return this.getStageDesc;
    }*/

    //makeBet uses a class made (Game made) stage value. Since that value is dependent on the user and not the game,
    // we need to add a parameter

    //Allows player the specify the amount of tokens used. Changes per stage
    public void makeBet(int index, int amount, Stages s){ //need to specify the index of the player
        Scanner sc = new Scanner(System.in);

        if(this.stage == s.START){ // You can't use any tokens above 5
            while(amount > 5){ // repeat until they choose a value less than 5
                System.out.println("You cant bet more than 5 dollars during the start phase.");
                amount = sc.nextInt();
            }
            this.thePlayers[index].getTokenCounter().put(Tokens.ONE, this.thePlayers[index].getKeyValue(Tokens.ONE) - 5);
            this.thePlayers[index].setMoney(this.thePlayers[index].getMoney() - amount);
        } else if(this.stage == s.BET){
            while(amount > this.thePlayers[index].getMoney()){
                System.out.println("You don't have that amount of money. Please choose a different bet");
                amount = sc.nextInt();
            }
            int[] tokenChange = moneyToTokens(index, amount);
        
            //Im just gonna brute force it
            this.thePlayers[index].getTokenCounter().put(Tokens.FIFTY, this.thePlayers[index].getKeyValue(Tokens.FIFTY) - tokenChange[0]);
            this.thePlayers[index].getTokenCounter().put(Tokens.TEN, this.thePlayers[index].getKeyValue(Tokens.TEN) - tokenChange[0]);
            this.thePlayers[index].getTokenCounter().put(Tokens.FIVE, this.thePlayers[index].getKeyValue(Tokens.FIVE) - tokenChange[0]);
            this.thePlayers[index].getTokenCounter().put(Tokens.ONE, this.thePlayers[index].getKeyValue(Tokens.ONE) - tokenChange[0]);

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

            /*int j = 0;
            final Integer innerJ = j; //index to iterate through moneyToTokens returned array
            Consumer<Map.Entry<Tokens, Integer>> action = entry ->
            {
                int innerinnerj = innerJ;
                this.thePlayers[index].getTokenCounter().put(entry.getKey(), this.thePlayers[index].getKeyValue(entry.getKey()) - tokenChange[innerinnerj]);
                innerinnerj++;
                innerJ = innerinnerj;
            };
            this.thePlayers[index].getTokenCounter().entrySet().forEach(action);*/
