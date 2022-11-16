package Cards;

import Board.Board;
import Utils.Roll;
import Utils.RollStraight;

public class Straight extends Card {

    protected int rollIsTutto(){
        System.out.println("TUTTO!! -> you earned " + 2000 + " points ");
        Board.printDelimiter();
        intermediatePoints += 2000;
        if (stopOrRoll()){return intermediatePoints;}
        else {return makeMove();}
    }

    @Override
    public String toString(){
        return "Straight-Card";
    }

    @Override
    public int makeMove() {
        roll = new RollStraight();
        while (true){
            printRoll();
            if (!roll.isValid()){return rollNotValid();}
            roll.putAside();
            if (roll.isTutto()){return rollIsTutto();}
            roll.rollDices();
        }
    }
}
