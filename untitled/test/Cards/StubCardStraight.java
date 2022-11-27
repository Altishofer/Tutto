package Cards;

import Dice.DiceValues;
import Roll.RollStraight;

import java.util.ArrayList;

public class StubCardStraight extends Straight{

    public static class StubStraightRoll extends RollStraight {

        private String command;
        public void setCommand(String pCommand){command = pCommand;}
        public String getCommand(){return command;}
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
        public void startOverRoll(){
            aDicesLeft = DiceValues.values().length;
            aPoints = 0;
            this.rollDices();
        }
    }

    private int stops = 0;
    public StubCardStraight(){
        aRoll = new StubStraightRoll();
    }
    public void setStubNr(String command){((StubStraightRoll) aRoll).setCommand(command);}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}
