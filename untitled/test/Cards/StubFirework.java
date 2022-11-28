package Cards;


public class StubFirework extends Firework{

    public StubFirework(){
        aRoll = new StubRoll();
    }

    private boolean stopOrRollReturn = false;

    @Override
    protected boolean stopOrRoll(){
        return stopOrRollReturn;
    }

    public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}
}
