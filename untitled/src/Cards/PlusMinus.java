package Cards;

import Board.Board;
import Utils.Tuple;

import java.util.Scanner;

public class PlusMinus extends Card {

    @Override
    public String toString(){
        return "Plus/Minus-Card";
    }

    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){return rollIsTutto();}
            else {aRoll.rollDices();}
        }
    }

    protected Tuple rollIsTutto(){
        aSleeper.doSleep();
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        return new Tuple(1000, false);
    }
}
