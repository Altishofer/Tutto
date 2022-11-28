package Cards;

public class StubCardX2Stop extends X2 {
    public StubCardX2Stop() {
        aRoll = new StubRoll();
    }

    @Override
    public boolean stopOrRoll(){
        return true; // assume user inputs "e" or "E"
    }
}
