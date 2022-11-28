package Roll;

import Board.Board;
import Dice.Dice;
import Dice.DiceValues;
import Utils.InputOutputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Roll{
    protected int aPoints;
    protected ArrayList<DiceValues> aRolledDices;
    protected int[] aFrequencyOfValues;
    protected int aDicesLeft;
    protected int[] userFreq;

    public Roll(){
        aPoints = 0;
        aDicesLeft = 6;
        rollDices();
    }

    public int getPoints(){
        return aPoints;
    }

    public void whichToPutAside(){
        Scanner scanner = new Scanner(System.in);
        boolean valid;
        boolean allZero;
        while (true) {
            valid = true;
            allZero = true;
            calculateFrequencies();
            System.out.print("Which dice-values do you want to put aside (comma separated): ");
            String answer = scanner.nextLine();
            Board.printDelimiter();
            userFreq = InputOutputUtils.cleanUpUserInput(answer);
            for (int i=0; i<userFreq.length; i++){
                if (userFreq[i] != 0){allZero = false;}
                if (userFreq[i] > aFrequencyOfValues[i]){valid = false;}
                if (i==1 || i==2 || i==3 || i==5){
                    if (userFreq[i]!=0 && userFreq[i] != 3 && userFreq[i] != 6){valid = false;}
                }
            }
            if (valid & !allZero){return;}
            System.out.println("The given input is not valid for the current roll");
            Board.printDelimiter();
        }
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
        if (!isValid()){aPoints = 0;}
        else {
            whichToPutAside();
            putAsideDice();
        }
        aRolledDices = Dice.rollDice(aDicesLeft);
        aFrequencyOfValues = calculateFrequencies();
    }

    public ArrayList<Integer> getRolledDices() {
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (DiceValues dice : aRolledDices){
            copy.add(dice.getInteger());
        }
        return copy;
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

    public boolean isTutto(){return aDicesLeft == 0;}

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

    public void putAsideDice(){
        for(int i = 0; i< userFreq.length; i++){
            if (userFreq[i] >= 3){
                // We assume we can take out 3 OR 6, but not 4 or 5 dices of a value
                if (i+1 == 1){
                    aPoints += (userFreq[i]/3) * 1000;
                }
                else {
                    aPoints += (userFreq[i]/3) * (i+1) * 100;
                }
                aDicesLeft -= (userFreq[i]/3) * 3;
                userFreq[i] -= (userFreq[i]/3) * 3;
            }
        }
        aDicesLeft -= userFreq[4];
        aPoints += userFreq[4] * 50;
        userFreq[4] = 0;

        aDicesLeft -= userFreq[0];
        aPoints += userFreq[0] * 100;
        userFreq[0] = 0;
    }
}







