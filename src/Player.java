enum Tokens{
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);

    private int value;
    Tokens(int value){
        this.value = value;
    }
}

public class Player{

    private int money;
    private Tokens tokens;
    EnumMap<Tokens,Integer> tokensCounter = new EnumMap<Tokens,Integer>(Tokens.class);
    public Player(){
        money = 200;
    }
}