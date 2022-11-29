package Cards;

import Roll.StubRoll;

public class StubCard extends Card {

    private int stops = 0;
    public StubCard(){
        aRoll = new StubRoll();
    }
    public String toString(){return "StandardCard";}
    public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}
    public String getStubNr(){return ((StubRoll) aRoll).getCommand();}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}