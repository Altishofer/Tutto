
package Cards;

import Board.Board;
import Utils.Tuple;

public class X2 extends Card {

    @Override
    public String toString(){ return "X2-Card"; }

    @Override
    protected Tuple rollIsTutto(){
        int finalSum = (aIntermediatePoints + aRoll.getPoints())*2;
        System.out.print("TUTTO!! -> you earned already " + finalSum + " points \n");
        Board.printDelimiter();
        aIntermediatePoints = finalSum - aRoll.getPoints(); // "- aRoll.getPoints()"
        return new Tuple(finalSum, !stopOrRoll());
    }
}
