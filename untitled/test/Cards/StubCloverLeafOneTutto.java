package Cards;

import Board.Board;
import Utils.Tuple;

public class StubCloverLeafOneTutto extends SingletonCloverLeaf {

    public StubCloverLeafOneTutto(){
        INSTANCE = SingletonCloverLeaf.getInstance();
    }

    @Override
    public Tuple rollIsTutto(){
        System.out.println("TUTTO!! -> you are one step closer to the WIN!");
        Board.printDelimiter();
        alreadyTutto = true;
        ((StubRoll) roll).setCommand("invalid");
        return new Tuple(makeMove().getFirst(), false);
    }
}
