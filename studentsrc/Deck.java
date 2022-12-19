package studentsrc;
import studentsrc.*;
import java.util.*;
public class Deck{
    ArrayList<Card> deck = new ArrayList<Card>(52);
    public Deck(){
        for(int i = 0; i < 52; i++){
            deck.add(new Card());
            deck.get(i).set
            //First, get the object of the player at index i. Then set their suti to i % 4 + 1
        }
        shuffle();
    }

    public void shuffle(){ //This method randomly switches an index with the incoming indices in the for loop
        Random rand = new Random();
        for(int i = 0; i < 52; i++){ 
            int randIndex1 = rand.nextInt(52); //
            Card temp = deck.get(i);
            deck.set(i, deck.get(randIndex1));
            deck.set(randIndex1, temp);
        }
    }

    public Card[] drawCards(){
        Card[] hand = new Card[2];
        //remove first two cards
        hand[0] = deck.get(0); // Draws the first card from a shuffled deck
        hand[1] = deck.get(1); // Draws the second card from a shuffled deck
        deck.remove(0); //Removes them from the deck to prevent them from being called agian
        deck.remove(1); // Removes them from the deck to prevent them from being used again
        return hand;
    }
}