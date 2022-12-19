package src2;
import src2.*;
public enum Stage{
    BET("Bet"), //Creates the enums for each kind of option
    FOLD("Fold"),
    CHECK("Check");

    private String desc;

    Stage(String description){ //constructor
        this.desc = description;
    }

    public String getDescription(){ //Getter
        return this.desc;
    }
}