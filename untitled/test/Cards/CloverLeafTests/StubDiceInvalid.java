package Cards.Cloverleaf;

import Utils.DiceValues;

import java.util.ArrayList;

public class StubDiceInvalid {
    // returns invalid results only
    public static ArrayList<DiceValues> rollDice(Integer pNumberOfDice) {
        ArrayList<DiceValues> roll = new ArrayList<DiceValues>();
        for (int i = 0; i < pNumberOfDice; i++) {
            if (i % 3 == 0) {roll.add(DiceValues.TWO);}
            if (i % 3 == 1) {roll.add(DiceValues.THREE);}
            if (i % 3 == 0) {roll.add(DiceValues.FOUR);}
        }

        return roll;
    }
}