package Roll;

public class StubStraightRoll2 extends RollStraight{

    public void setUserInput(int[] user){
        aUserFreq = user;}
    public void setFreqOfValues(int[] user){aFrequencyOfValues = user;}
    public int[] getFrequencyOfvalues(){return aFrequencyOfValues.clone();}
    @Override
    public int[] cleanUpUserInput(String input) {
        return aUserFreq;
    }
}
