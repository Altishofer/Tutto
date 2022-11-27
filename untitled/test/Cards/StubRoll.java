package Cards;

import Dice.DiceValues;
import Roll.Roll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StubRoll extends Roll {

    private String command;
    public void setCommand(String pCommand){command = pCommand;}
    public String getCommand(){return command;}
    @Override
    public void rollDices(){
        rolledDices = new ArrayList<>(){};
        if (command == null || command == "invalid"){
            List<DiceValues> invalid = Arrays.asList(DiceValues.TWO, DiceValues.THREE, DiceValues.FOUR, DiceValues.SIX);
            for (int i=0;i<dicesLeft;i++){rolledDices.add(invalid.get(i%3));}
        }
        if (command == "validNotTutto"){
            List<DiceValues> invalid;
            invalid = Arrays.asList(DiceValues.ONE, DiceValues.TWO, DiceValues.THREE, DiceValues.FOUR, DiceValues.SIX);
            for (int i=0;i<dicesLeft;i++){rolledDices.add(invalid.get(i%5));}
        }
        if (command == "tuttoOnes") {
            for (int i = 0; i < dicesLeft; i++) {
                rolledDices.add(DiceValues.ONE);
            }
        }
        rollFreq = calcFreq();
    }

    @Override
    public void whichToPutAside(){
        userFreq = new int[6];
        for(int i=0; i<userFreq.length; i++){userFreq[i] = rollFreq[i];}
    }

    @Override
    public void startOverRoll(){
        dicesLeft = DiceValues.values().length;
        points = 0;
        this.rollDices();
    }
}
