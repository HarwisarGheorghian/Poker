package src2;
import src2.*;
public enum Stage{
    START("Start"),
    DEALCARDS("Deal"),
    BET("Bet"),
    FOLD("Fold"),
    CHECK("Check"),
    PLACECARDS("Place cards"),
    END("End");

    private String desc;

    Stage(String description){
        this.desc = description;
    }

    public String getDescription(){
        return this.desc;
    }
}