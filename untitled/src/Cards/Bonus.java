package Cards;

import Board.Board;
import Utils.RollStraight;

public class Bonus extends Card {
    private static int BONUS_VALUE;

    public Bonus(Integer bonus){
        BONUS_VALUE = bonus;
    }

    /*
    Changing return to "Bonus-Card that gives " + String(BONUS_VALUE) + " points in case of a Tutto"
    or String(BONUS_VALUE) + " Points Bonus-Card"
    */
    @Override
    public String toString(){
        return String.valueOf(BONUS_VALUE) + " Points Bonus Card";
    }

    @Override
    protected int rollIsTutto(){
        int finalSum = intermediatePoints + roll.getPoints() + BONUS_VALUE;
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        intermediatePoints = finalSum;
        if (stopOrRoll()){return finalSum;}
        else {return makeMove();}
    }
}
