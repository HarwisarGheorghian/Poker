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
        ArrayList<Player> players = new ArrayList<Player>(playerCount);
        Deck deck = new Deck();
        System.out.println("There are " + playerCount + " players playing. Please state their names.");
        //Initial step
        for(int i = 0; i < players.size(); i++){
            System.out.println("What is your name?");
            String name = sc.next();
            players.get(i).setName(name);

            System.out.println(players.get(i).tokenStats());

            System.out.println("Ok " + players.get(i).getName() + ". Now choose to either bet, check, or fold!");
            String choice = sc.next();
            if(choice.equals(Stage.BET.getDescription())){
                System.out.println("How much are you betting?");
                int betAmt = sc.nextInt();
                EnumMap<Token, Integer> playerBetMap = players.get(i).convertTokens(betAmt);
                TotalAmount.put(Token.FIFTY, TotalAmount.get(Token.FIFTY) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.TEN, TotalAmount.get(Token.TEN) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.FIVE, TotalAmount.get(Token.FIVE) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.ONE, TotalAmount.get(Token.ONE) + playerBetMap.get(Token.FIFTY));

                players.get(i).getTokenCounter().put(Token.FIFTY, players.get(i).getTokenCounter().get(Token.FIFTY) - playerBetMap.get(Token.FIFTY));
                players.get(i).getTokenCounter().put(Token.TEN, players.get(i).getTokenCounter().get(Token.TEN) - playerBetMap.get(Token.TEN));
                players.get(i).getTokenCounter().put(Token.FIVE, players.get(i).getTokenCounter().get(Token.FIVE) - playerBetMap.get(Token.FIVE));
                players.get(i).getTokenCounter().put(Token.ONE, players.get(i).getTokenCounter().get(Token.ONE) - playerBetMap.get(Token.ONE));
            } else if (choice.equals(Stage.CHECK.getDescription())){
                System.out.println("You stay in the game but don't bet anything.");
            } else if(choice.equals(Stage.FOLD.getDescription())){
                System.out.println("Player " + players.get(i).getName() + " has quit.");
                players.remove(i);
            }


        }

        if(players.size() == 0){
            System.out.println("Everyone has quit. The game is over...");
            System.exit(0);
        }

        //Each player gets two cards
        for(int i = 0; i < playerCount; i++){
            players.get(i).draw(deck);
            System.out.println("Here is you set of cards");
            System.out.println("Card 1: " + players.get(i).getDisplayHand()[0] + "\n" + "Card 2: " + players.get(i).getDisplayHand()[1]);
        }

        //Compare
        int maxVal = 0;
        Player correctPlayer = new Player();
        for(int i = 0; i < playerCount; i++){
            if(players.get(i).getTotalRankValue() >= maxVal){
                maxVal = players.get(i).getTotalRankValue();
                correctPlayer = players.get(i);
            }
        }
        System.out.println("The player who won was " + correctPlayer.getName() + "!");
        System.out.println("Their stats:");
        System.out.println(correctPlayer.tokenStats());
        
    }
}