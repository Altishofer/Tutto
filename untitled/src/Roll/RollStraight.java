package Roll;

import Board.Board;
import java.util.Scanner;

public class RollStraight extends Roll {

    protected boolean[] aAsideDices;

    public RollStraight(){
        aAsideDices = new boolean[6];
    }

    @Override
    public boolean isValid(){
        for(int i = 0; i< aFrequencyOfValues.length; i++) {
            if (aFrequencyOfValues[i] != 0 && !aAsideDices[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean validUserInput(){
        boolean valid = true;
        boolean allZero = true;
        for (int i=0; i<userFreq.length; i++){
            if (userFreq[i] != 0){allZero = false;}
            if (userFreq[i] > aFrequencyOfValues[i] || userFreq[i] >= 2){valid = false;}
            if (userFreq[i]!=0 && aAsideDices[i]){valid = false;}
        }
        return valid && !allZero;
    }

    @Override
    public void putAsideDice(){
        for(int i = 0; i< userFreq.length; i++){
            if (userFreq[i] != 0 && !aAsideDices[i]) {
                aAsideDices[i] = true;
                aDicesLeft--;
            }
        }
    }
}
