package Cards;

import Roll.StubRoll;
import Utils.InputOutputUtils;

public class StubCardX2Stop extends X2 {
    public StubCardX2Stop() {
        aRoll = new StubRoll();
        aSleeper = new InputOutputUtils(0);
    }

    @Override
    public boolean stopOrRoll(){
        return true; // assume user inputs "e" or "E"
    }
}
