package Cards;

import Board.Board;
import Utils.Tuple;

import java.util.Scanner;

public class Bonus extends Card {
    private final int BONUS_VALUE;

    public Bonus(Integer bonus){
        BONUS_VALUE = bonus;
    }

    @Override
    public String toString(){
        return String.valueOf(BONUS_VALUE) + " Points Bonus Card";
    }

    @Override
    protected Tuple rollIsTutto(){
        int finalSum = aIntermediatePoints + aRoll.getPoints() + BONUS_VALUE;
        System.out.print("TUTTO!! -> you earned already " + finalSum + " points \n");
        Board.printDelimiter();
        aIntermediatePoints += BONUS_VALUE;
        return new Tuple(finalSum, !stopOrRoll());
    }
}
