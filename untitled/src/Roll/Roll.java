package Roll;

import Board.Board;
import Dice.Dice;
import Dice.DiceValues;
import Utils.InputOutputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Roll{
    protected int points;
    protected ArrayList<DiceValues> rolledDices;
    protected int[] rollFreq;
    protected int[] userFreq;

    protected int dicesLeft;

    public Roll(){
        points = 0;
        dicesLeft = 6;
        rollDices();
    }

    public int getPoints(){
        return points;
    }

    public void whichToPutAside(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        boolean allZero = true;
        while (true) {
            calcFreq();
            System.out.print("Which dice-values do you want to put aside (comma separated): ");
            String answer = scanner.nextLine();
            Board.printDelimiter();
            userFreq = InputOutputUtils.cleanUpUserInput(answer);
            for (int i=0; i<userFreq.length; i++){
                if (userFreq[i] != 0){allZero = false;}
                if (userFreq[i] <= rollFreq[i]){
                    rollFreq[i] -= userFreq[i];
                }
                else {valid = false;}
            }
            if (valid & !allZero){return;}
            System.out.println("The given input is not valid for the current roll");
            Board.printDelimiter();
            calcFreq();
        }
    }

    public void startOverRoll(){
        dicesLeft = DiceValues.values().length;
        points = 0;
        rollDices();
    }

    public void rollDices(){
        rolledDices = Dice.rollDice(dicesLeft);
        rollFreq = calcFreq();
    }

    public void putAside(){
        if (!isValid()){points = 0;}
        else {
            whichToPutAside();
            putAsideDice();
        }
    }

    public ArrayList<Integer> getRolledDices() {
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for (DiceValues dice : rolledDices){
            copy.add(dice.getInteger());
        }
        return copy;
    }

    protected int[] calcFreq(){
        int[] cnt = new int[6];
        for(int i=0; i<cnt.length; i++){
            cnt[i] = 0;
        }
        for (DiceValues dice : rolledDices){
            cnt[dice.value - 1]++;
        }
        return cnt;
    }

    public boolean isValid(){
        for(int i = 0; i< rollFreq.length; i++) {
            if (rollFreq[i] >= 3) {
                return true;
            }
            if (rollFreq[4] != 0 || rollFreq[0] != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isTutto(){return dicesLeft == 0;}

    public void putAsideDice(){
        for(int i = 0; i< userFreq.length; i++){
            if (userFreq[i] >= 3){
                // We assume we can take out 3 OR 6, but not 4 or 5 dices of a value
                if (i+1 == 1){
                    points += (userFreq[i]/3) * 1000;
                }
                else {
                    points += (userFreq[i]/3) * (i+1) * 100;
                }
                dicesLeft -= (userFreq[i]/3) * 3;
                userFreq[i] -= (userFreq[i]/3) * 3;
            }
        }
        dicesLeft -= userFreq[4];
        points += userFreq[4] * 50;
        userFreq[4] = 0;

        dicesLeft -= userFreq[0];
        points += userFreq[0] * 100;
        userFreq[0] = 0;
    }
}







