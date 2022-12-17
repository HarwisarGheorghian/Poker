package src;
import java.util.*;
import src.*;

public class Hands{
    private ArrayList<String> Deck = new ArrayList<String>();
    private HashMap<ArrayList<String>, Integer> hands = new HashMap<ArrayList<String>, Integer>();
    private Deck deck2;
    public Hands(){
        hands.put(new ArrayList<String>(Arrays.asList("SA", "SK", "SQ", "SJ", "S10")), 5);
        hands.put(new ArrayList<String>(Arrays.asList("DA", "DK", "DQ", "DJ", "D10")), 5);
        hands.put(new ArrayList<String>(Arrays.asList("CA", "CK", "CQ", "CJ", "C10")), 5);
        hands.put(new ArrayList<String>(Arrays.asList("HA", "HK", "HQ", "HJ", "H10")), 5);
        hands.put(new ArrayList<String>(Arrays.asList("SA", "SK", "SQ", "SJ", "S10")), 5);


    }

    public void royalflush(){
        
    }
    
}