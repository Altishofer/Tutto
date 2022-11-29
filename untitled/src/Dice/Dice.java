package Dice;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dice {

    public static ArrayList<DiceValues> rollDice(Integer pNumberOfDice) {
        ArrayList<DiceValues> roll = new ArrayList<DiceValues>();
        for (int i = 0; i < pNumberOfDice; i++) {
            roll.add(DiceValues.values()[new Random().nextInt(DiceValues.values().length)]);
        }
        return roll;
    }
}
