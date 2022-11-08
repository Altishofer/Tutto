package States;

import Utils.DiceValues;
import Utils.Roll;

import java.util.Scanner;

public class Bonus implements CardInterface {

    private Roll roll;
    private int bonusValue = 1;

    @Override
    public int makeMove() {
        Scanner scanner;
        roll = new Roll();

        while (true){

            String listString = String.join(", ", String.valueOf(roll.getRolledDices()));
            System.out.println("you have rolled the combination: " + listString);
            if (!roll.isValid()){
                System.out.print("The combination is invalid and results in 0 points :( ");
                return 0;
            }

            roll.putAside();
            if (roll.isTutto()){
                System.out.print("TUTTO -> you earned " + roll.getPoints() + " * " + bonusValue + " = " + bonusValue * roll.getPoints() + " points ");
                return bonusValue * roll.getPoints();
            }
            
            while (true)
            {
                System.out.print("Do you want to proceed (P) or stop (S) and earn the " + roll.getPoints() +" points? ");
                scanner = new Scanner(System.in);
                String playOrStop = scanner.nextLine();

                if (playOrStop.equalsIgnoreCase("s")){
                    return roll.getPoints();
                }
                if (playOrStop.equalsIgnoreCase("p")){
                    roll.rollDices();
                    break;
                }
            }
        }
    }
}
