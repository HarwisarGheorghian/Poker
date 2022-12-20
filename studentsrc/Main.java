package studentsrc;
import studentsrc.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        EnumMap<Token, Integer> TotalAmount = new EnumMap<>(Map.of(Token.FIFTY, 0, Token.TEN, 0, Token.FIVE, 0, Token.ONE, 0));
        
        //Create an Scanner Object with input of System.in
        int playerCount;
        System.out.println("Welcome to broken poker! How many players are playing?");
        playerCount = sc.nextInt();
        //Create an ArrayList of type Player with the name players and an initial capacity of playerCount.
        //Create the Deck object
        System.out.println("There are " + playerCount + " players playing. Please state their names.");
        //Initial step
        for(int i = 0; i < playerCount; i++){
            System.out.println("What is your name?");
            String name = sc.next(); // Gets the name of each player
            players.add(new Player());
            // // Sets their name using the setName method (parameter is name)

            System.out.println(players.get(i).tokenStats());
        }
        int counter = 0;
        while(players.size() > counter){
            System.out.println("Ok " + players.get(counter).getName() + ". Now choose to either bet, check, or fold!");
            String choice = sc.next();

            //This while loop repeats until the person types in the correct input
            while(!(choice.equals(Stage.BET.getDescription()) || choice.equals(Stage.CHECK.getDescription()) || choice.equals(Stage.FOLD.getDescription())))
            {
                System.out.println("You did not make a valid choice. Please only choose Bet, Check, or Fold");
                choice = sc.next();
            }
            if(choice.equals(//Get description of BET enum)){
                System.out.println("How much are you betting?");
                int betAmt = sc.nextInt();
                EnumMap<Token, Integer> playerBetMap = players.get(counter).convertTokens(betAmt); //Creates an enum map of the converted token count
                

                players.get(counter).setTokenCounter(Token.FIFTY, players.get(counter).getTokenCounter().get(Token.FIFTY) - playerBetMap.get(Token.FIFTY));
                players.get(counter).setTokenCounter(Token.TEN, players.get(counter).getTokenCounter().get(Token.TEN) - playerBetMap.get(Token.TEN));
                players.get(counter).setTokenCounter(Token.FIVE, players.get(counter).getTokenCounter().get(Token.FIVE) - playerBetMap.get(Token.FIVE));
                players.get(counter).setTokenCounter(Token.ONE, players.get(counter).getTokenCounter().get(Token.ONE) - playerBetMap.get(Token.ONE));

                //Adds it to the total amount
                TotalAmount.put(Token.FIFTY, TotalAmount.get(Token.FIFTY) + playerBetMap.get(Token.FIFTY));
                TotalAmount.put(Token.TEN, TotalAmount.get(Token.TEN) + playerBetMap.get(Token.TEN));
                TotalAmount.put(Token.FIVE, TotalAmount.get(Token.FIVE) + playerBetMap.get(Token.FIVE));
                TotalAmount.put(Token.ONE, TotalAmount.get(Token.ONE) + playerBetMap.get(Token.ONE));


                System.out.println("Here are your current tokens.");
                System.out.println(players.get(counter).tokenStats()); //gets the token stats
                counter++;
            } else if (choice.equals(//Get description of Check enum)){
                System.out.println("You stay in the game but don't bet anything.");
                System.out.println("Here are your current tokens.");
                System.out.println(players.get(counter).tokenStats());
                counter++;
            } else if(choice.equals(//Get description of Fold enum)){
                System.out.println("Player " + players.get(counter).getName() + " has quit.");
                players.remove(counter); //This removes the player from the array and won't include them in further events
            }


        }

        if(players.size() == 0){ //If everyone quit, then the game ends
            System.out.println("Everyone has quit. The game is over...");
            System.exit(0);
        }

        //Each player gets two cards
        for(int i = 0; i < players.size(); i++){
            //Use the player object to draw 2 cards from the desk using the draw method from the player class. Include
            //the deck object as well
            System.out.println("Here is you set of cards\n");
            System.out.println(player.get(i).getName());
            System.out.println("Card 1: " + players.get(i).getDisplayHand()[0] + "\n" + "Card 2: " + players.get(i).getDisplayHand()[1] + "\n");
        }

        //Compare
        int maxVal = 0;
        //Create a new player called correctPlayer
        for(int i = 0; i < players.size(); i++){ //Algorithm to check who has the highest hand
            if(players.get(i).getTotalRankValue() >= maxVal){ 
                maxVal = players.get(i).getTotalRankValue();
                correctPlayer = players.get(i);
            }
        }
        System.out.println("The player who won was " + correctPlayer.getName() + "!");

        //Gives the player the prize pool
        correctPlayer.setTokenCounter(Token.FIFTY, correctPlayer.getTokenCounter().get(Token.FIFTY) + TotalAmount.get(Token.FIFTY));
        correctPlayer.setTokenCounter(Token.TEN, correctPlayer.getTokenCounter().get(Token.TEN) + TotalAmount.get(Token.TEN));
        correctPlayer.setTokenCounter(Token.FIVE, correctPlayer.getTokenCounter().get(Token.FIVE) + TotalAmount.get(Token.FIVE));
        correctPlayer.setTokenCounter(Token.ONE, correctPlayer.getTokenCounter().get(Token.ONE) + TotalAmount.get(Token.ONE));

        System.out.println("Their stats:");
        System.out.println(//Call the method tokenStats);
        
        System.out.println("They won " + correctPlayer.TokensToMoney());
        
    }
}