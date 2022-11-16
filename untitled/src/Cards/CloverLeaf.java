package Cards;

import Board.Board;
import Utils.Roll;

public class CloverLeaf extends Card {
    private boolean alreadyTutto;

    public CloverLeaf() {
        alreadyTutto = false;
    }

    @Override
    public String toString(){
        return "Cloverleaf-Card";
    }

    @Override
    protected int rollIsTutto(){
        System.out.println("TUTTO!! -> you are one step closer to the WIN!");
        Board.printDelimiter();
        alreadyTutto = true;
        return makeMove();
    }

    @Override
    protected int rollNotValid(){
        System.out.println("No had no luck, the Cloverleaf is gone");
        Board.printDelimiter();
        return 0;
    }

    @Override
    public int makeMove() {
        roll = new Roll();
        while (true){
            printRoll();
            if (!roll.isValid()){return rollNotValid();}
            roll.putAside();
            if (roll.isTutto()){
                if (alreadyTutto){return Integer.MAX_VALUE;}
                return rollIsTutto();
            }
            roll.rollDices();
        }
    }
}
