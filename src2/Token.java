package src2;
import src2.*;
public enum Token{ // enum for each token value
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);

    private int value;
    Token(int value){ // constructor
        this.value = value;
    }
}