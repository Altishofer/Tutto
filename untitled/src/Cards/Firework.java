package Cards;

import Board.Board;
import Utils.Roll;
import Utils.Tuple;

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

    @Override
    public Tuple makeMove() {
        roll = new Roll();
        while (true){
            printRoll();
            if (!roll.isValid()){return new Tuple(rollNotValid(), false);}
            roll.putAside();
            if (roll.isTutto()){return rollIsTutto();}
            roll.rollDices();
        }
    }
}
