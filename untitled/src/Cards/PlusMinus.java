package Cards;

import Board.Board;
import Utils.Roll;
import Utils.Tuple;

public class PlusMinus extends Card {

    protected Tuple rollIsTutto(){
        System.out.println("TUTTO!! -> you earned " + 1000 + " points ");
        Board.printDelimiter();
        return new Tuple(1000, true);
    }

    @Override
    public String toString(){
        return "Plus/Minus-Card";
    }
}
