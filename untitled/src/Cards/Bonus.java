package Cards;

import Board.Board;
import Utils.Tuple;

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
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        aIntermediatePoints = finalSum;
        return new Tuple(finalSum, !stopOrRoll());
    }
}
