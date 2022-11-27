package Utils;

import java.util.ArrayList;

public class Roll {
    protected int points;
    protected ArrayList<DiceValues> rolledDices;
    protected int[] frequencyOfValues;
    protected int dicesLeft;
    protected int[] aTripletCount = new int[6];


    public Roll(){
        points = 0;
        dicesLeft = 6;
        rollDices();
        for (int i = 0; i < 6; i++) {
            aTripletCount[i] = 0;
        }
    }

    public int getPoints(){
        return points;
    }

    public void startOverRoll(){
        dicesLeft = DiceValues.values().length;
        points = 0;
        rollDices();
    }

    public void rollDices(){
        rolledDices = Dice.rollDice(dicesLeft);
        frequencyOfValues = calculateFrequencies();
    }

    public void putAside(){
        if (!isValid()){points = 0;}
        else {putAsideDices();}
    }

    public ArrayList<Integer> getRolledDices() {
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (DiceValues dice : rolledDices){
            copy.add(dice.getInteger());
        }
        return copy;
    }

    protected int[] calculateFrequencies(){
        int[] cnt = new int[DiceValues.values().length];
        for(int i=0; i<cnt.length; i++){
            cnt[i] = 0;
        }
        for (DiceValues dice : rolledDices){
            cnt[dice.value - 1]++;
        }
        return cnt;
    }

    public boolean isValid(){
        for(int i=0; i<frequencyOfValues.length; i++) {
            if (frequencyOfValues[i] >= 3) {
                return true;
            }
            if (frequencyOfValues[4] != 0 || frequencyOfValues[0] != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isTutto(){return dicesLeft == 0;}

    public void putAsideDices(){
        for(int i=0; i<frequencyOfValues.length; i++){
            if (frequencyOfValues[i] >= 3){
                if (i+1 == 1){
                    points += (frequencyOfValues[i]/3) * 1000;
                }
                else {
                    points += (frequencyOfValues[i]/3) * (i+1) * 100;
                }
                dicesLeft -= (frequencyOfValues[i]/3) * 3;
                frequencyOfValues[i] -= (frequencyOfValues[i]/3) * 3;
            }
        }
        dicesLeft -= frequencyOfValues[4];
        points += frequencyOfValues[4] * 50;
        frequencyOfValues[4] = 0;

        dicesLeft -= frequencyOfValues[0];
        points += frequencyOfValues[0] * 100;
        frequencyOfValues[0] = 0;
    }
}







