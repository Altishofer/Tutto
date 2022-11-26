package Cards.Cloverleaf;

import Utils.DiceValues;

import java.util.ArrayList;
import java.util.Random;

public class StubDiceValid {
    // returns valid results only
    public static ArrayList<DiceValues> rollDice(Integer pNumberOfDice) {
        ArrayList<DiceValues> roll = new ArrayList<DiceValues>();
        for (int i = 0; i < pNumberOfDice - 1; i++) { // one die is left out
            roll.add(DiceValues.values()[new Random().nextInt(DiceValues.values().length)]);
        }
        if (new Random().nextInt(2) == 1){roll.add(DiceValues.ONE);} // last die is 1
        else {roll.add(DiceValues.FIVE);} // last die is 5
        return roll;
    }
}