package Cards;

import Board.Board;
import Roll.RollStraight;
import Utils.Tuple;

public class Straight extends Card {

    public Straight(){
        roll = new RollStraight();
    }

    @Override
    protected Tuple rollIsTutto(){
        System.out.println("TUTTO!! -> you earned " + 2000 + " points ");
        Board.printDelimiter();
        intermediatePoints += 2000;
        return new Tuple(intermediatePoints, !stopOrRoll());
    }

    @Override
    public String toString(){
        return "Straight-Card";
    }

    @Override
    public Tuple makeMove() {
        roll.startOverRoll();
        while (true){
            printRoll();
            if (!roll.isValid()){return new Tuple(rollNotValid(), false);}
            roll.putAside();
            if (roll.isTutto()){return rollIsTutto();}
            else {roll.rollDices();}
        }
    }
}
