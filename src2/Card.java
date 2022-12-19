package src2;
import src2.*;
public class Card{
    private int suit;
    private int rank;

    public Card(){
        
    }

    public int getRank(){
        return this.rank;
    }

    public int getSuit(){
        return this.suit;
    }

    public void setRank(int ranks){
        this.rank = ranks;
    }

    public void setSuit(int suits){
        this.suit = suits;
    }

    public String displayCard(){
        String displaySuit = "";
        String displayRank = "";
        switch(this.suit){
            case 1:
                displaySuit = "S";
                break;
            case 2:
                displaySuit = "D";
                break;
            case 3:
                displaySuit = "H";
                break;
            case 4:
                displaySuit = "C";
                break;
            default:
                System.out.println("somethingbrokies");
                break;
        }

        switch(this.rank){
            case 11:
                displayRank = "J";
                break;
            case 12:
                displayRank = "Q";
                break;
            case 13:
                displayRank = "K";
                break;
            case 14:
                displayRank = "A";
                break;
            default:
                displayRank = Integer.toString(this.rank);
                break;
        }
        return new String(displaySuit + displayRank);
    }
}