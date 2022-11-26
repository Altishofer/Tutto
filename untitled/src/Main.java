import Board.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> roll = new ArrayList<Integer>();
        boolean tutto = false;

        System.out.print("How many players want to play? ");
        String countPlayerAnswer = scanner.nextLine();
        int countPlayer = Integer.valueOf(countPlayerAnswer);

        System.out.print("How many points are necessary to win? ");
        String numberOfPointsAnswer = scanner.nextLine();
        int countPoints = Integer.valueOf(numberOfPointsAnswer);

        Board board = new Board(countPoints, countPlayer);

        while (!board.playerWon()){
            board.nextPlayerMove(0);
        }
        board.displayChart();
        Board.printDelimiter();
    }
}