package Cards;

import Roll.StubRoll;
import Utils.InputOutputUtils;

public class StubCardX2Roll extends X2 {
    public StubCardX2Roll() {
        aRoll = new StubRoll();
        aSleeper = new InputOutputUtils(0);
    }

    @Override
    public boolean stopOrRoll() {
        return false; // assume user inputs "r" or "R"
    }
}
