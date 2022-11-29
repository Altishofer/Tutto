package Roll;

import java.util.ArrayList;

public class StubStraightRoll2 extends RollStraight{

    public void setUserInput(int[] user){userFreq = user;}
    public void setFreqOfValues(int[] user){aFrequencyOfValues = user;}
    public int[] getFrequencyOfvalues(){return aFrequencyOfValues.clone();}
    @Override
    public int[] cleanUpUserInput(String input) {
        return userFreq;
    }
}
