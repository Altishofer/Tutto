import Board.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> roll = new ArrayList<Integer>();
        boolean tutto = false;

        int countPlayer = Utils.InputOutputUtils.getIntegerInput("How many players want to play? ");
        int countPoints = Utils.InputOutputUtils.getIntegerInput("How many points are necessary to win? ");
        Board board = new Board(countPoints, countPlayer);

        while (!board.playerWon()){
            board.nextPlayerMove(0);
        }
        board.displayChart();
        Board.printDelimiter();
    }
}