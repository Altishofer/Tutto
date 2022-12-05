package Cards;

import Roll.Roll;
import Roll.StubRoll;
import Utils.InputOutputUtils;

public class StubCard extends Card {

    private int stops = 0;
    public StubCard(){
        aRoll = new StubRoll();
        aSleeper = new InputOutputUtils(0);
    }
    public String toString(){return "StandardCard";}
    public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}