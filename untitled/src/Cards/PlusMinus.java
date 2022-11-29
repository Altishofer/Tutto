package Cards;

import Board.Board;
import Utils.Tuple;

import java.util.Scanner;

public class PlusMinus extends Card {

    @Override
    public String toString(){
        return "Plus/Minus-Card";
    }

    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){return rollIsTutto();}
            else {aRoll.rollDices();}
        }
    }

    protected Tuple rollIsTutto(){
        aSleeper.doSleep();
        int finalSum = aIntermediatePoints + 1000;
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        return new Tuple(finalSum, !stopOrRoll());
    }

    @Override
    protected boolean stopOrRoll(){
        Scanner scanner;
        while (true){
            aSleeper.doSleep();
            int sum = aIntermediatePoints + 1000;
            System.out.print("Do you want to roll again (R) or end the move (E) and earn the " + sum +" points? ");
            scanner = new Scanner(System.in);
            String playOrStop = scanner.nextLine();
            Board.printDelimiter();
            if (playOrStop.equalsIgnoreCase("e")){return true;}
            if (playOrStop.equalsIgnoreCase("r")){return false;}
        }
    }
}
