package src2;
import src2.*;
public enum Stage{
    BET("Bet"),
    FOLD("Fold"),
    CHECK("Check");

    private String desc;

    Stage(String description){
        this.desc = description;
    }

    public String getDescription(){
        return this.desc;
    }
}