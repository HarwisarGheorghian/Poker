package src;
import src.*;
import src.Game.Stages;

import java.util.Scanner;
public class Main{
    public static int totalAmt = 0;
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
        
    }
}