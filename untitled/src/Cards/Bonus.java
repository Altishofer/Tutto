package Cards;

import Board.Board;
import Utils.Tuple;

import java.util.Scanner;

public class Bonus extends Card {
    private final int BONUS_VALUE;

    public Bonus(Integer bonus){
        BONUS_VALUE = bonus;
    }

    @Override
    public String toString(){
        return String.valueOf(BONUS_VALUE) + " Points Bonus Card";
    }

    @Override
    protected Tuple rollIsTutto(){
        int finalSum = aIntermediatePoints + aRoll.getPoints() + BONUS_VALUE;
        System.out.print("TUTTO!! -> you earned already " + finalSum + " points \n");
        Board.printDelimiter();
        aIntermediatePoints += BONUS_VALUE;
        return new Tuple(finalSum, !stopOrRoll());
    }

    @Override
    protected boolean stopOrRoll(){
        Scanner scanner;
        while (true){
            aSleeper.doSleep();
            int sum = aIntermediatePoints + aRoll.getPoints();
            System.out.print("Do you want to roll again (R) or end the move (E) and earn the " + sum +" points? ");
            scanner = new Scanner(System.in);
            String playOrStop = scanner.nextLine();
            Board.printDelimiter();
            if (playOrStop.equalsIgnoreCase("e")){return true;}
            if (playOrStop.equalsIgnoreCase("r")){return false;}
        }
    }
}
