package Cards;

import Board.Board;
import Utils.InputOutputUtils;
import Roll.Roll;
import Utils.Tuple;

import java.util.Scanner;

public abstract class Card {

    protected int aIntermediatePoints = 0;
    protected Roll aRoll;
    protected InputOutputUtils aSleeper;

    protected Card(){
        aSleeper = new InputOutputUtils();
        aRoll = new Roll();
    }

    @Override
    public abstract String toString();

    public void addIntermediatePoints(int pPoints){
        aIntermediatePoints += pPoints;}

    public Tuple makeMove() {
        aRoll.startOverRoll();
        while (true){
            printRoll();
            if (!aRoll.isValid()){return new Tuple(rollNotValid(), false);}
            aRoll.putAside();
            if (aRoll.isTutto()){return rollIsTutto();}
            if (stopOrRoll()){return new Tuple(aRoll.getPoints() + aIntermediatePoints, false);}
            else {
                aRoll.rollDices();}
        }
    }

    protected Tuple rollIsTutto(){
        aSleeper.doSleep();
        int finalSum = aIntermediatePoints + aRoll.getPoints();
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        return new Tuple(finalSum, !stopOrRoll());
    }

    protected int rollNotValid(){
        aSleeper.doSleep();
        System.out.println("The combination is invalid and results in 0 points");
        Board.printDelimiter();
        return 0;
    }

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

    protected void printRoll(){
        aSleeper.doSleep();
        String listString = String.join(", ", String.valueOf(aRoll.getRolledDices()));
        System.out.println("You have rolled the combination: " + listString);
        Board.printDelimiter();
    }
}
