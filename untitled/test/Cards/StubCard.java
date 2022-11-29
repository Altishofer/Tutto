package Cards;

<<<<<<< HEAD
import Roll.StubRoll;

public class StubCard extends Card{
=======
public class StubCard extends Card {
>>>>>>> 6fa581ac848e43c4c9afa4fd62ad22b214b28c29
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