package studentsrc;
import studentsrc.*;
public class Card{
    private int suit;
    private int rank;

    public Card(){
        //empty constructor
    }

    public int getRank(){ //Getter
        return this.rank;
    }

    public int getSuit(){ //Getter
        return this.suit;
    }

    public void setRank(int ranks){ //setter
        this.rank = ranks;
    }

    public void setSuit(int suits){ // Setter
        this.suit = suits;
    }

    public //Change this type to the right value displayCard(){
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

        //create a switch statement similar to suit but for rank{
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
        //Return a string combined of displaySuit and displayRank;
    }
}