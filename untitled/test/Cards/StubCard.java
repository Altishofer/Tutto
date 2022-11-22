package Cards;

public class StubCard extends Card{
    private int stops = 0;
    public StubCard(){
        roll = new StubRoll();
    }
    public String toString(){return "StandardCard";}
    public void setStubNr(String command){((StubRoll) roll).setCommand(command);}
    public String getStubNr(){return ((StubRoll) roll).getCommand();}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}
