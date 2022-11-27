package Cards;

import Utils.DiceValues;
import Roll.RollStraight;

import java.util.ArrayList;

public class StubCardStraight extends Straight{

    public static class StubStraightRoll extends RollStraight {

        private String command;
        public void setCommand(String pCommand){command = pCommand;}
        public String getCommand(){return command;}
        @Override
        public void rollDices(){
            asideDices = new boolean[6];
            for (int i=0;i<6;i++){asideDices[i]=false;}
            rolledDices = new ArrayList<>(){};
            if (command == null || command == "invalid"){
                for (int i=0;i<dicesLeft;i++){rolledDices.add(DiceValues.ONE);}
                asideDices[0] = true;
            }
            if (command == "validNotTutto"){
                for (int i=0;i<dicesLeft;i++){rolledDices.add(DiceValues.ONE);}
                asideDices[0] = false;
            }
            if (command == "tutto"){
                for (int i=0;i<dicesLeft;i++){rolledDices.add(DiceValues.values()[i]);}
            }
            frequencyOfValues = calculateFrequencies();
        }

        @Override
        public void startOverRoll(){
            dicesLeft = DiceValues.values().length;
            points = 0;
            this.rollDices();
        }
    }

    private int stops = 0;
    public StubCardStraight(){
        roll = new StubStraightRoll();
    }
    public void setStubNr(String command){((StubStraightRoll) roll).setCommand(command);}

    @Override
    public boolean stopOrRoll() {
        if (stops >= 1) { return true;}
        stops++;
        return false;
    }
}
