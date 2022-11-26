package Cards.CloverLeafTests;

import Cards.CloverLeaf;

public class StubCloverLeafSuccess extends CloverLeaf {
    @Override
    public int makeMove() {
        roll = new Cards.CloverLeaf.StubRollValid();
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