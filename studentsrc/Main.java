package studentsrc;
import studentsrc.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        EnumMap<Token, Integer> TotalAmount = new EnumMap<>(Map.of(Token.FIFTY, 0, Token.TEN, 0, Token.FIVE, 0, Token.ONE, 0));
        Scanner sc = new Scanner(System.in);
        int playerCount;
        System.out.println("Welcome to broken poker! How many players are playing?");
        playerCount = sc.nextInt();
        ArrayList<Player> players = new ArrayList<Player>(playerCount);
        Deck deck = new Deck();
        System.out.println("There are " + playerCount + " players playing. Please state their names.");
        //Initial step
        for(int i = 0; i < playerCount; i++){
            System.out.println("What is your name?");
            String name = sc.next();
            players.add(new Player());
            players.get(i).setName(name);

            System.out.println(players.get(i).tokenStats());
        }
        int counter = 0;
        while(players.size() > counter){
            System.out.println("Ok " + players.get(counter).getName() + ". Now choose to either bet, check, or fold!");
            String choice = sc.next();

            while(!(choice.equals(Stage.BET.getDescription()) || choice.equals(Stage.CHECK.getDescription()) || choice.equals(Stage.FOLD.getDescription())))
            {
                System.out.println("You did not make a valid choice. Please only choose Bet, Check, or Fold");
                choice = sc.next();
            }
            if(choice.equals(Stage.BET.getDescription())){
                System.out.println("How much are you betting?");
                int betAmt = sc.nextInt();
                EnumMap<Token, Integer> playerBetMap = players.get(counter).convertTokens(betAmt);
                

                players.get(counter).setTokenCounter(Token.FIFTY, players.get(counter).getTokenCounter().get(Token.FIFTY) - playerBetMap.get(Token.FIFTY));
                players.get(counter).setTokenCounter(Token.TEN, players.get(counter).getTokenCounter().get(Token.TEN) - playerBetMap.get(Token.TEN));
                players.get(counter).setTokenCounter(Token.FIVE, players.get(counter).getTokenCounter().get(Token.FIVE) - playerBetMap.get(Token.FIVE));
                players.get(counter).setTokenCounter(Token.ONE, players.get(counter).getTokenCounter().get(Token.ONE) - playerBetMap.get(Token.ONE));

                TotalAmount.put(Token.FIFTY, TotalAmount.get(Token.FIFTY) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.TEN, TotalAmount.get(Token.TEN) + playerBetMap.get(Token.TEN));
                TotalAmount.put(Token.FIVE, TotalAmount.get(Token.FIVE) + playerBetMap.get(Token.FIVE));
                TotalAmount.put(Token.ONE, TotalAmount.get(Token.ONE) + playerBetMap.get(Token.ONE));


                System.out.println("Here are your current tokens.");
                System.out.println(players.get(counter).tokenStats());
                counter++;
            } else if (choice.equals(Stage.CHECK.getDescription())){
                System.out.println("You stay in the game but don't bet anything.");
                System.out.println("Here are your current tokens.");
                System.out.println(players.get(counter).tokenStats());
                counter++;
            } else if(choice.equals(Stage.FOLD.getDescription())){
                System.out.println("Player " + players.get(counter).getName() + " has quit.");
                players.remove(counter);
            }


        }

        if(players.size() == 0){
            System.out.println("Everyone has quit. The game is over...");
            System.exit(0);
        }

        //Each player gets two cards
        for(int i = 0; i < players.size(); i++){
            players.get(i).draw(deck);
            System.out.println("Here is you set of cards");
            System.out.println("Card 1: " + players.get(i).getDisplayHand()[0] + "\n" + "Card 2: " + players.get(i).getDisplayHand()[1]);
        }

        //Compare
        int maxVal = 0;
        Player correctPlayer = new Player();
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getTotalRankValue() >= maxVal){
                maxVal = players.get(i).getTotalRankValue();
                correctPlayer = players.get(i);
            }
        }
        System.out.println("The player who won was " + correctPlayer.getName() + "!");

        correctPlayer.setTokenCounter(Token.FIFTY, correctPlayer.getTokenCounter().get(Token.FIFTY) + TotalAmount.get(Token.FIFTY));
        correctPlayer.setTokenCounter(Token.TEN, correctPlayer.getTokenCounter().get(Token.TEN) + TotalAmount.get(Token.TEN));
        correctPlayer.setTokenCounter(Token.FIVE, correctPlayer.getTokenCounter().get(Token.FIVE) + TotalAmount.get(Token.FIVE));
        correctPlayer.setTokenCounter(Token.ONE, correctPlayer.getTokenCounter().get(Token.ONE) + TotalAmount.get(Token.ONE));

        System.out.println("Their stats:");
        System.out.println(correctPlayer.tokenStats());
        
        System.out.println("They won " + correctPlayer.TokensToMoney());

        System.out.println(correctPlayer.getTokenCounter().get(Token.FIFTY) + TotalAmount.get(Token.FIFTY));
        
    }
}