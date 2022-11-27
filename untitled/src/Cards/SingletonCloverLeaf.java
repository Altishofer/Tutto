package Cards;

import Board.Board;
import Utils.Tuple;

public class SingletonCloverLeaf extends Card {
    public boolean alreadyTutto;

    protected static SingletonCloverLeaf INSTANCE;

    protected SingletonCloverLeaf() {
        alreadyTutto = false;
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
        System.out.println("TUTTO!! -> you are one step closer to the WIN!");
        Board.printDelimiter();
        alreadyTutto = true;
        return new Tuple(makeMove().getFirst(), false);
    }

    @Override
    public int rollNotValid(){
        System.out.println("You had no luck, the Cloverleaf is gone");
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
