package src2;
import src2.*;
import java.util.*;

import javafx.stage.Stage;
public class Main{
    static EnumMap<Token, Integer> TotalAmount = new EnumMap<Token, Integer>(Token.class);
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int playerCount;
        System.out.println("Welcome to broken poker! How many players are playing?");
        playerCount = sc.nextInt();
        Player[] players = new Player[playerCount];
        System.out.println("There are " + playerCount + " players playing. Please state your names.");
        //Initial step
        for(int i = 0; i < playerCount; i++){
            System.out.println("What is your name?");
            String name = sc.next();
            players[i].setName(name);
            System.out.println("Ok " + players[i].getName() + ". Now choose to either bet, check, or fold!");
            String choice = sc.next();
            if(choice.equals(Stage.BET.getDescription())){
                System.out.println("How much are you betting?");
                int betAmt = sc.nextInt();
                EnumMap<Token, Integer> playerBetMap = players[i].convertTokens(betAmt);
                TotalAmount.put(Token.FIFTY, TotalAmount.get(Token.FIFTY) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.TEN, TotalAmount.get(Token.TEN) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.FIVE, TotalAmount.get(Token.FIVE) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.ONE, TotalAmount.get(Token.ONE) + playerBetMap.get(Token.FIFTY));

                players[i].getTokenCounter().put(Token.FIFTY, players[i].getTokenCounter().get(Token.FIFTY) - playerBetMap.get(Token.FIFTY));
                players[i].getTokenCounter().put(Token.TEN, players[i].getTokenCounter().get(Token.TEN) - playerBetMap.get(Token.TEN));
                players[i].getTokenCounter().put(Token.FIVE, players[i].getTokenCounter().get(Token.FIVE) - playerBetMap.get(Token.FIVE));
                players[i].getTokenCounter().put(Token.ONE, players[i].getTokenCounter().get(Token.ONE) - playerBetMap.get(Token.ONE));
            } else if (choice.equals(Stage.CHECK.getDescription())){
                System.out.println("You stay in the game but don't bet anything.");
            } else if(choice.equals(Stage.FOLD.getDescription())){
                
            }
        }

    }
}