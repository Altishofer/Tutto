package Cards;

import Board.Board;
import Utils.Tuple;

public class SingletonCloverLeaf extends Card {
    public boolean aAlreadyTutto;
    protected static SingletonCloverLeaf INSTANCE;

    protected SingletonCloverLeaf() {
        aAlreadyTutto = false;
    }

    public static synchronized SingletonCloverLeaf getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SingletonCloverLeaf();
        }
        return INSTANCE;
    }

    @Override
    public String toString(){
        return "Cloverleaf-Card";
    }

    @Override
    public Tuple rollIsTutto(){
        System.out.print("TUTTO!! -> you are one step closer to the WIN!\n");
        Board.printDelimiter();
        aAlreadyTutto = true;
        return new Tuple(makeMove().getFirst(), false);
    }

    @Override
    public int rollNotValid(){
        System.out.print("You had no luck, the Cloverleaf is gone\n");
        Board.printDelimiter();
        return 0;
    }

    @Override
    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){
                if (aAlreadyTutto){return new Tuple(Integer.MAX_VALUE, false);}
                return rollIsTutto();
            }
            aRoll.rollDices();
        }
    }
}
