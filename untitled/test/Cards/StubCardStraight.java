package Cards;

import Dice.DiceValues;
import Roll.RollStraight;
import Utils.InputOutputUtils;

import java.util.ArrayList;

public class StubCardStraight extends Straight{

    public static class StubStraightRoll extends RollStraight {

        private String command;
        public void setCommand(String pCommand){command = pCommand;}
        @Override
        public void rollDices(){
            aAsideDices = new boolean[6];
            for (int i=0;i<6;i++){
                aAsideDices[i]=false;}
            aRolledDices = new ArrayList<>(){};
            if (command == null || command == "invalid"){
                for (int i = 0; i< aDicesLeft; i++){aRolledDices.add(DiceValues.ONE);}
                aAsideDices[0] = true;
            }
            if (command == "validNotTutto"){
                for (int i = 0; i< aDicesLeft; i++){aRolledDices.add(DiceValues.ONE);}
                aAsideDices[0] = false;
            }
            if (command == "tutto"){
                for (int i = 0; i< aDicesLeft; i++){aRolledDices.add(DiceValues.values()[i]);}
            }
            aFrequencyOfValues = calculateFrequencies();
        }

        @Override
        public void whichToPutAside(){
            aUserFreq = new int[6];
            for(int i = 0; i< aUserFreq.length; i++){
                aUserFreq[i] = aFrequencyOfValues[i];}
            aFrequencyOfValues = calculateFrequencies();
        }

        @Override
        public void startOverRoll(){
            aDicesLeft = DiceValues.values().length;
            aPoints = 0;
            this.rollDices();
        }
    }

    private int stops = 0;
    public StubCardStraight(){
        aRoll = new StubStraightRoll();
        aSleeper = new InputOutputUtils(0);
    }
    public void setStubNr(String command){((StubStraightRoll) aRoll).setCommand(command);}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}
