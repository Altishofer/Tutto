package Cards;

import Board.Board;
import Roll.StubRoll;
import Utils.InputOutputUtils;
import Utils.Tuple;

public class StubCloverLeafOneTutto extends SingletonCloverLeaf {

    public StubCloverLeafOneTutto(){
        INSTANCE = SingletonCloverLeaf.getInstance();
        aSleeper = new InputOutputUtils(0);
    }

    @Override
    public Tuple rollIsTutto(){
        System.out.println("TUTTO!! -> you are one step closer to the WIN!");
        Board.printDelimiter();
        aAlreadyTutto = true;
        ((StubRoll) aRoll).setCommand("invalid");
        return new Tuple(makeMove().getFirst(), false);
    }
}
