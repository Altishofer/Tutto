package Cards.CloverLeafTests;

import Utils.Roll;

public class StubRollInvalid extends Roll {
    @Override
    public void rollDices(){
        rolledDices = Cards.Cloverleaf.StubDiceInvalid.rollDice(dicesLeft);
        frequencyOfValues = calculateFrequencies();
    }
}