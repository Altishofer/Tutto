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

    @Override
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
            userFreq = cleanUpUserInput(answer);
            for (int i=0; i<userFreq.length; i++){
                if (userFreq[i] != 0){allZero = false;}
                if (userFreq[i] > aFrequencyOfValues[i] || userFreq[i] >= 2){valid = false;}
                if (userFreq[i]!=0 && aAsideDices[i]){valid = false;}
            }
            if (valid & !allZero){return;}
            System.out.println("The given input is not valid for the current roll");
            Board.printDelimiter();
        }
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
