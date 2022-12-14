import Game.java;
public class Game{
    Players[] thePlayers;
    private Stages stage; 
    public enum Stages{
        START,
        DEALCARDS,
        BET,
        PLACECARDS,
        END;
    }

    public Game(){

    }

    public Stages getStage(){
        return stage;
    }

    public void setStage(Stages set){
        stage = set;
    }

    //Allows player the specify the amount of tokens used. Changes per stage
    public int maxBet(){
        if(this.stage == Stages.START){ // You can't use any tokens above 5

        }
    }
}