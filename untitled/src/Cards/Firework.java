package Cards;

import Board.Board;
import Roll.Roll;
import Utils.Tuple;

public class Firework extends Card {

    @Override
    public String toString(){
        return "Firework-Card";
    }

    @Override
    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){return rollIsTutto();}
            aRoll.rollDices();
        }
    }

    @Override
    protected int rollNotValid(){
        int finalSum = aIntermediatePoints + aRoll.getPoints();
        System.out.print("The combination is invalid but you get " + finalSum + " points \n");
        Board.printDelimiter();
        return finalSum;
    }
}
