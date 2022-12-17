package src;
import src.*;
import java.util.*;
public class Deck{
    private String[] suit = {"S", "D", "C", "H"};
    private String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private ArrayList<String> deck = new ArrayList<String>(52);
    private ArrayList<String> dealerDeck = new ArrayList<String>();
    public Deck(){
        for(int i = 0; i < deck.size(); i++){
            deck.add(suit[i % 4] + rank[i % 13]);
        }
    }

    public ArrayList<String> getDeck(){
        return deck;
    }

    public ArrayList<String> getDealerDick(){
        return dealerDeck;
    }
}