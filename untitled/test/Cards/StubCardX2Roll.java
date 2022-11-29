package Cards;

import Roll.StubRoll;

public class StubCardX2Roll extends X2 {
    public StubCardX2Roll() {
        aRoll = new StubRoll();
    }

    @Override
    public boolean stopOrRoll() {
        return false; // assume user inputs "r" or "R"
    }
}
