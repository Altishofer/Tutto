package Roll;

import Board.Board;
import Dice.Dice;
import Dice.DiceValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Roll{
    protected int aPoints;
    protected ArrayList<DiceValues> aRolledDices;
    protected int[] aFrequencyOfValues;
    protected int aDicesLeft;
    protected int[] aUserFreq;

    public Roll(){
        aPoints = 0;
        aDicesLeft = 6;
        rollDices();
    }

    public int[] cleanUpUserInput(String input) {
        ArrayList<String> values;
        int[] clean = new int[6];
        for (int i=0; i<clean.length; i++){clean[i] = 0;}
        if (input == null || input.isEmpty()){return clean;}
        input = input.replaceAll("\\s+","");
        values = new ArrayList<String>(List.of(input.split(",")));
        for (String str : values){
            if (str.length() > 1 || !str.matches("[1-6]")){return clean;}
        }
        for (String str : values){clean[Integer.valueOf(str) - 1]++;}
        return clean;
    }

    public int getPoints(){
        return aPoints;
    }

    public boolean validUserInput(){
        boolean valid = true;
        boolean allZero = true;
        for (int i = 0; i< aUserFreq.length; i++){
            if (aUserFreq[i] != 0){allZero = false;}
            if (aUserFreq[i] > aFrequencyOfValues[i]){valid = false;}
            if (i==1 || i==2 || i==3 || i==5){
                if (aUserFreq[i]!=0 && aUserFreq[i] != 3 && aUserFreq[i] != 6){valid = false;}
            }
        }
        return valid && !allZero;
    }

    public void whichToPutAside(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            calculateFrequencies();
            System.out.print("Which dice-values do you want to put aside (comma separated): ");
            String answer = scanner.nextLine();
            Board.printDelimiter();
            aUserFreq = cleanUpUserInput(answer);
            if (validUserInput()){return;}
            System.out.print("The given input is not valid for the current roll\n");
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
        for(int i = 0; i< aUserFreq.length; i++){
            if (aUserFreq[i] >= 3){
                // We assume we can take out 3 OR 6, but not 4 or 5 dices of a value
                if (i+1 == 1){
                    aPoints += (aUserFreq[i]/3) * 1000;
                }
                else {
                    aPoints += (aUserFreq[i]/3) * (i+1) * 100;
                }
                aDicesLeft -= (aUserFreq[i]/3) * 3;
                aUserFreq[i] -= (aUserFreq[i]/3) * 3;
            }
        }
        aDicesLeft -= aUserFreq[4];
        aPoints += aUserFreq[4] * 50;
        aUserFreq[4] = 0;

        aDicesLeft -= aUserFreq[0];
        aPoints += aUserFreq[0] * 100;
        aUserFreq[0] = 0;
    }
}







