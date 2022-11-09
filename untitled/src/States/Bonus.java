package States;

import Board.Board;
import Board.Player;
import Utils.Roll;

import java.util.Scanner;

public class Bonus extends Card {
    private static int BONUS_VALUE = 1;

    public Bonus(Integer bonus){
        BONUS_VALUE = bonus;
    }

    @Override
    public String toString(){
        return "Bonus-Card";
    }

    @Override
    protected int rollIsTutto(){
        int finalSum = intermediatePoints + roll.getPoints() + BONUS_VALUE;
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        intermediatePoints = finalSum;
        if (stopOrRoll()){return finalSum;}
        else {return makeMove();}
    }
}
