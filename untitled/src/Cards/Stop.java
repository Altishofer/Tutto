package Cards;

import Utils.Tuple;

public class Stop extends Card {

    @Override
    public Tuple makeMove() {return new Tuple(0, false);}

    @Override
    public String toString(){
        return "Stop-Card";
    }
}
