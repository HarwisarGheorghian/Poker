package src2;
import src2.*;
import java.util.*;
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
                players[i].convertTokens(betAmt);
                
            }
        }

    }
}