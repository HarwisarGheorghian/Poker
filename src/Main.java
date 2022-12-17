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
        ArrayList<Player> players = new ArrayList<Player>(playerCount);
        Game game = new Game(players);
        for(int i = 0; i < playerCount; i++){
            System.out.println("What will you name yourself Player 1?");
            String name = sc.next();
            players.add(new Player(name));
            System.out.println("Welcome " + name + "!\n");
        }
        //System.out.println("Make your bets!");


        int bet = 0;
        for(int i = 0; i < playerCount; i++){ // Initial Stage
            System.out.println("Make your bets!");
            System.out.print("Player " + i + ": ");
            bet = sc.nextInt();
            game.makeBet(i, bet, Stages.START);
        }

        //Step 2: Dealer deals 2 cards
        Random rand = new Random();
        ArrayList<Integer> indices = new ArrayList<Integer>();

        for(int i = 0; i < playerCount; i++){
            int cardIndex = 0;
            for(int j = 0; j < 2; j++){
                cardIndex = rand.nextInt(52);
                while(!indices.contains(cardIndex)){
                    cardIndex = rand.nextInt(52);
                }
                indices.add(cardIndex);
                players.get(i).getHand().add(cards[cardIndex]);
                indices.remove(cardIndex);
            }
        }

        //Step 3: Bet, Check, or Fold
        Stages[] validStages= {Stages.BET, Stages.CHECK, Stages.FOLD};
        for(int i = 0; i < playerCount; i++){
            System.out.println("You can bet, check, or fold here. What would you like to do?");
            String choice = sc.next();

            do {
                System.out.println("You did not choose a valid option");
                choice = sc.next();
            } while(!game.isValidOption(validStages, choice));

            if(choice.equals(Stages.BET.getDescription())){
                System.out.println("How much do you want to bet?");
                int betAmt = sc.nextInt();
                game.makeBet(i, betAmt, Stages.BET);
            } else if (choice.equals(Stages.CHECK.getDescription())){
                game.check(i);
            } else if(choice.equals(Stages.FOLD.getDescription())){
                game.fold(i);
            }
        }

        //Step 4: Dealer places 5 cards
        
    }
}