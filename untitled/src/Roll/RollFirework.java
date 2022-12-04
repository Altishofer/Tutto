package Roll;

import Board.Board;
import Dice.Dice;

public class RollFirework extends Roll{

    @Override
    public void putAside(){
        if (!isValid()){aPoints = 0;}
        else {
            whichToPutAside();
            putAsideDice();
        }
        aRolledDices = Dice.rollDice(aDicesLeft);
        aFrequencyOfValues = calculateFrequencies();
    }

    @Override
    public void whichToPutAside(){
        aFrequencyOfValues = calculateFrequencies();
        aUserFreq = new int[6];
        for(int i = 0; i< aUserFreq.length; i++){
            aUserFreq[i] = aFrequencyOfValues[i];}
    }
}
