package Cards;

import Utils.Tuple;

public class PlusMinus extends AbstractCard {

    @Override
    public String toString(){
        return "Plus/Minus-Card";
    }

    public Tuple makeMove() {
        roll.startOverRoll();
        while (true){
            printRoll();
            if (!roll.isValid()){return new Tuple(rollNotValid(), false);}
            roll.putAside();
            if (roll.isTutto()){return rollIsTutto();}
            else {roll.rollDices();}
        }
    }
}
