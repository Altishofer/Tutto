package Cards;

import Roll.StubRoll;
import Utils.InputOutputUtils;

public class StubCardPlusMinus extends PlusMinus{

    private int stops = 0;
    public StubCardPlusMinus() {
        aRoll = new StubRoll();
        aSleeper = new InputOutputUtils(0);
    }

    public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}
