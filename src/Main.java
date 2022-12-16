package src;
import src.*;
import src.Game.Stages;

import java.util.Scanner;
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
        
    }
}