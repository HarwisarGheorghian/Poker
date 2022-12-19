package src2;
import src2.*;
import java.util.*;
public class Deck{
    ArrayList<Card> deck = new ArrayList<Card>(52);
    public Deck(){ //makes deck from cards
        for(int i = 0; i < 52; i++){
            deck.add(new Card());
            deck.get(i).setRank(i % 13 + 1);
            deck.get(i).setSuit(i % 4 + 1);
        }
        shuffle();
    }

    public void shuffle(){ //shuffles the deck
        Random rand = new Random();
        for(int i = 0; i < 52; i++){
            int randIndex1 = rand.nextInt(52);
            Card temp = deck.get(i);
            deck.set(i, deck.get(randIndex1));
            deck.set(randIndex1, temp);
        }
    }

    public Card[] drawCards(){ //Used mostly for Player. 
        Card[] hand = new Card[2];
        //remove first two cards
        hand[0] = deck.get(0);
        hand[1] = deck.get(1);
        deck.remove(0);
        deck.remove(1);
        return hand;
    }
}