package Cards;

import Board.Board;

public class x2 extends Card {

    @Override
    public String toString(){
        return "x2-Card";
    }

    @Override
    protected int rollIsTutto(){
        int finalSum = (intermediatePoints + roll.getPoints())*2;
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        intermediatePoints = finalSum;
        if (stopOrRoll()){return finalSum;}
        else {return makeMove();}
    }
}
