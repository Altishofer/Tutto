package Cards;

import Utils.Tuple;

public class PlusMinus extends Card {

    @Override
    public String toString(){
        return "Plus/Minus-Card";
    }

    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){return rollIsTutto();}
            else {
                aRoll.rollDices();}
        }
    }
}
