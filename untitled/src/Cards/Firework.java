package Cards;

import Board.Board;
import Utils.Roll;

public class Firework extends Card {

    @Override
    public String toString(){
        return "Firework-Card";
    }

    @Override
    protected int rollNotValid(){
        int finalSum = intermediatePoints + roll.getPoints();
        System.out.println("The combination is invalid but you get " + finalSum + " points ");
        Board.printDelimiter();
        return finalSum;
    }

    // TODO: does it really make a copy, not reference
    public Roll getRoll(){
        Roll copy = roll;
        return copy;
    }

    @Override
    public int makeMove() {
        roll = new Roll();
        while (true){
            printRoll();
            if (!roll.isValid()){return rollNotValid();}
            roll.putAside();
            if (roll.isTutto()){return rollIsTutto();}
            roll.rollDices();
        }
    }
}
