package Roll;

import Dice.Dice;
import Dice.DiceValues;

import java.util.ArrayList;

public class Roll{
    protected int aPoints;
    protected ArrayList<DiceValues> aRolledDices;
    protected int[] aFrequencyOfValues;
    protected int aDicesLeft;

    public Roll(){
        aPoints = 0;
        aDicesLeft = 6;
        rollDices();
    }

    public int getPoints(){
        return aPoints;
    }

    public void startOverRoll(){
        aDicesLeft = DiceValues.values().length;
        aPoints = 0;
        rollDices();
    }

    public void rollDices(){
        aRolledDices = Dice.rollDice(aDicesLeft);
        aFrequencyOfValues = calculateFrequencies();
    }

    public void putAside(){
        if (!isValid()){
            aPoints = 0;}
        else {putAsideDices();}
    }

    public ArrayList<Integer> getRolledDices() {
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (DiceValues dice : aRolledDices){
            copy.add(dice.getInteger());
        }
        return copy;
    }

    public boolean isValid(){
        for(int i = 0; i< aFrequencyOfValues.length; i++) {
            if (aFrequencyOfValues[i] >= 3) {
                return true;
            }
            if (aFrequencyOfValues[4] != 0 || aFrequencyOfValues[0] != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isTutto(){return aDicesLeft == 0;}

    public void putAsideDices(){
        for(int i = 0; i< aFrequencyOfValues.length; i++){
            if (aFrequencyOfValues[i] >= 3){
                // We assume we can take out 3 OR 6, but not 4 or 5 dices of a value
                if (i+1 == 1){
                    aPoints += (aFrequencyOfValues[i]/3) * 1000;
                }
                else {
                    aPoints += (aFrequencyOfValues[i]/3) * (i+1) * 100;
                }
                aDicesLeft -= (aFrequencyOfValues[i]/3) * 3;
                aFrequencyOfValues[i] -= (aFrequencyOfValues[i]/3) * 3;
            }
        }
        aDicesLeft -= aFrequencyOfValues[4];
        aPoints += aFrequencyOfValues[4] * 50;
        aFrequencyOfValues[4] = 0;

        aDicesLeft -= aFrequencyOfValues[0];
        aPoints += aFrequencyOfValues[0] * 100;
        aFrequencyOfValues[0] = 0;
    }

    protected int[] calculateFrequencies(){
        int[] cnt = new int[DiceValues.values().length];
        for(int i=0; i<cnt.length; i++){
            cnt[i] = 0;
        }
        for (DiceValues dice : aRolledDices){
            cnt[dice.aValue - 1]++;
        }
        return cnt;
    }
}







