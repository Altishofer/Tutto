package Cards;

import Board.Board;
import Roll.RollStraight;
import Utils.Tuple;

public class Straight extends Card {

    public Straight(){
        aRoll = new RollStraight();
    }

    @Override
    public String toString(){
        return "Straight-Card";
    }

    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){return rollIsTutto();}
            else {
                aRoll.rollDices();}
        }
    }

    protected Tuple rollIsTutto(){
        System.out.println("TUTTO!! -> you earned " + 2000 + " points ");
        Board.printDelimiter();
        aIntermediatePoints += 2000;
        return new Tuple(aIntermediatePoints, !stopOrRoll());
    }
}
