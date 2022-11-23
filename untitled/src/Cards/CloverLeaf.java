package Cards;

import Board.Board;
import Utils.Roll;
import Utils.Tuple;

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
    protected Tuple rollIsTutto(){
        System.out.println("TUTTO!! -> you are one step closer to the WIN!");
        Board.printDelimiter();
        alreadyTutto = true;
        return new Tuple(makeMove().getFirst(), false);
    }

    @Override
    protected int rollNotValid(){
        System.out.println("No had no luck, the Cloverleaf is gone");
        Board.printDelimiter();
        return 0;
    }

    @Override
    public Tuple makeMove() {
        roll.startOverRoll();
        while (true){
            printRoll();
            if (!roll.isValid()){return new Tuple(rollNotValid(), false);}
            roll.putAside();
            if (roll.isTutto()){
                if (alreadyTutto){return new Tuple(Integer.MAX_VALUE, false);}
                return rollIsTutto();
            }
            roll.rollDices();
        }
    }
}
