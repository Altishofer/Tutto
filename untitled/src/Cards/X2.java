
package Cards;

import Board.Board;
import Utils.Tuple;

public class X2 extends Card {

    @Override
    public String toString(){
        return "X2-Card";
    }

    @Override
    protected Tuple rollIsTutto(){
        int finalSum = (intermediatePoints + roll.getPoints())*2;
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        intermediatePoints = finalSum;
        return new Tuple(finalSum, !stopOrRoll());
    }
}
