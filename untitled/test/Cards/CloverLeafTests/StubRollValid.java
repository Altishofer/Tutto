
package Cards.CloverLeafTests;

import Utils.Roll;

public class StubRollValid extends Roll {
    @Override
    public void rollDices(){
        rolledDices = Cards.Cloverleaf.StubDiceValid.rollDice(dicesLeft);
        frequencyOfValues = calculateFrequencies();
    }
}