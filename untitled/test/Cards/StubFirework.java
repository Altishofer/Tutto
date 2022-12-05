package Cards;


import Roll.StubRoll;
import Utils.InputOutputUtils;

public class StubFirework extends Firework{

    public StubFirework(){
        aRoll = new StubRoll();
        aSleeper = new InputOutputUtils(0);
    }

    private boolean stopOrRollReturn = false;

    @Override
    protected boolean stopOrRoll(){
        return stopOrRollReturn;
    }

    public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}
}
