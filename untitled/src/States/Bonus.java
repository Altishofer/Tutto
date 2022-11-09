package States;

import Board.Board;
import Board.Player;
import Utils.Roll;

import java.util.Scanner;

public class Bonus implements CardInterface {

    private final Player PLAYER;
    private Roll roll;
    private static final int BONUS_VALUE = 1;

    public Bonus(Player player){
        PLAYER = player;
    }

    @Override
    public int makeMove() {
        Scanner scanner;
        roll = new Roll();

        while (true){

            Board.printDelimiter();
            String listString = String.join(", ", String.valueOf(roll.getRolledDices()));
            System.out.println("you have rolled the combination: " + listString);
            Board.printDelimiter();
            if (!roll.isValid()){
                System.out.println("The combination is invalid and results in 0 points");
                Board.printDelimiter();
                return 0;
            }

            roll.putAside();
            if (roll.isTutto()){
                System.out.print("TUTTO!! -> you earned " + roll.getPoints() + " * " + BONUS_VALUE + " = " + BONUS_VALUE * roll.getPoints() + " points ");
                return BONUS_VALUE * roll.getPoints();
            }
            
            while (true)
            {
                System.out.print("Do you want to roll again (R) or end the move (E) and earn the " + roll.getPoints() +" points? ");
                scanner = new Scanner(System.in);
                String playOrStop = scanner.nextLine();

                if (playOrStop.equalsIgnoreCase("e")){
                    Board.printDelimiter();
                    return roll.getPoints();
                }
                if (playOrStop.equalsIgnoreCase("r")){
                    roll.rollDices();
                    break;
                }
            }
        }
    }


}
