package Cards;

import Board.Board;
import Roll.RollFirework;
import Utils.Tuple;

public class Firework extends Card {

    public Firework(){
        aRoll = new RollFirework();
    }

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
    
    @Override
    protected Tuple rollIsTutto(){
        aSleeper.doSleep();
        aIntermediatePoints += aRoll.getPoints();
        System.out.println("TUTTO!! -> you earned already " + aIntermediatePoints + " points ");
        Board.printDelimiter();
        return new Tuple(makeMove().getFirst(), false);
    }
}
