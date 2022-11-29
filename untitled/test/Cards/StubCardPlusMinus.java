package Cards;

public class StubCardPlusMinus extends PlusMinus{

    private int stops = 0;
    public StubCardPlusMinus() {
        super();
        aRoll = new StubRoll();
    }

    public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}
