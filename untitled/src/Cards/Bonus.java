package Cards;

import Board.Board;
import Utils.Tuple;

public class Bonus extends AbstractCard {
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
        int finalSum = intermediatePoints + roll.getPoints() + BONUS_VALUE;
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        intermediatePoints = finalSum;
        return new Tuple(finalSum, !stopOrRoll());
    }
}
