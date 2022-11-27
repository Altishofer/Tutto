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
            for (int i = 0; i< aDicesLeft; i++){rolledDices.add(invalid.get(i%3));}
        }
        if (command == "validNotTutto"){
            List<DiceValues> invalid;
            invalid = Arrays.asList(DiceValues.ONE, DiceValues.TWO, DiceValues.THREE, DiceValues.FOUR, DiceValues.SIX);
            for (int i = 0; i< aDicesLeft; i++){rolledDices.add(invalid.get(i%5));}
        }
        if (command == "tuttoOnes") {
            for (int i = 0; i < aDicesLeft; i++) {
                rolledDices.add(DiceValues.ONE);
            }
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
