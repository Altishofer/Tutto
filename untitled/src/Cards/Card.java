package Cards;

import Board.Board;
import Utils.InputOutputUtils;
import Roll.Roll;
import Utils.Tuple;

import java.util.Scanner;

public abstract class Card {

    public int intermediatePoints = 0;
    public Roll roll;
    protected InputOutputUtils sleeper;

    protected Card(){
        sleeper = new InputOutputUtils();
        roll = new Roll();
    }

    @Override
    public abstract String toString();
    protected void printRoll(){
        sleeper.doSleep();
        String listString = String.join(", ", String.valueOf(roll.getRolledDices()));
        System.out.println("You have rolled the combination: " + listString);
        Board.printDelimiter();
    }

    public void addIntermediatePoints(int pPoints){intermediatePoints += pPoints;}

    protected Tuple rollIsTutto(){
        sleeper.doSleep();
        int finalSum = intermediatePoints + roll.getPoints();
        System.out.println("TUTTO!! -> you earned already " + finalSum + " points ");
        Board.printDelimiter();
        return new Tuple(finalSum, !stopOrRoll());
    }

    protected int rollNotValid(){
        sleeper.doSleep();
        System.out.println("The combination is invalid and results in 0 points");
        Board.printDelimiter();
        return 0;
    }

    protected boolean stopOrRoll(){
        Scanner scanner;
        while (true){
            sleeper.doSleep();
            int sum = intermediatePoints + roll.getPoints();
            System.out.print("Do you want to roll again (R) or end the move (E) and earn the " + sum +" points? ");
            scanner = new Scanner(System.in);
            String playOrStop = scanner.nextLine();
            Board.printDelimiter();
            if (playOrStop.equalsIgnoreCase("e")){return true;}
            if (playOrStop.equalsIgnoreCase("r")){return false;}
        }
    }

    public Tuple makeMove() {
        roll.startOverRoll();
        while (true){
            printRoll();
            if (!roll.isValid()){return new Tuple(rollNotValid(), false);}
            roll.putAside();
            if (roll.isTutto()){return rollIsTutto();}
            if (stopOrRoll()){return new Tuple(roll.getPoints() + intermediatePoints, false);}
            else {roll.rollDices();}
        }
    }
}
