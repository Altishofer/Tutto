package Cards;

import Board.Board;
import Utils.Roll;

public class PlusMinus extends Card {

    //TODO: Cedi

    protected int rollIsTutto(){
        System.out.println("TUTTO!! -> you earned " + 1000 + " points ");
        Board.printDelimiter();
        return 1000;
    }

    @Override
    public String toString(){
        return "Plus/Minus-Card";
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
