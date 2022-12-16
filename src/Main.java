package src;
import src.*;
import src.Game.Stages;

import java.util.*;
public class Main{
    public static String[] cards = {"C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJack", "CQueen", "CKing", "CAce",
    "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJack", "DQueen", "DKing", "DAce",
    "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJack", "HQueen", "HKing", "HAce",
    "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJack", "SQueen", "SKing", "SAce"};
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Poker! How many players are playing?");
        int playerCount = sc.nextInt();
        Player[] players = new Player[playerCount];
        Game game = new Game(players);
        for(int i = 0; i < playerCount; i++){
            players[i] = new Player();
        }
        //System.out.println("Make your bets!");


        int bet = 0;
        for(int i = 0; i < playerCount; i++){ // Initial Stage
            System.out.println("Make your bets!");
            bet = sc.nextInt();
            game.makeBet(i, bet, Stages.START);
        }

        //Step 2: Dealer deals 2 cards
        Random rand = new Random();
        ArrayList<Integer> indices = new ArrayList<Integer>(
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52));

        for(int i = 0; i < playerCount; i++){
            int cardIndex = 0;
            for(int j = 0; j < 2; j++){
                cardIndex = rand.nextInt(52);
                while(indices.indexOf(cardIndex) == -1){
                    cardIndex = rand.nextInt(52);
                }
                players[i].getHand().add(cards[cardIndex]);
                indices.remove(cardIndex);
            }
        }

        //Step 3: Bet, Check, or Fold
    }
}