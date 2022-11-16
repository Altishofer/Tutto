import Board.Board;
import Cards.Card;
import Cards.RandomFlyWeightCard;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> roll = new ArrayList<Integer>();

        System.out.print("How many players want to play? ");
        String countPlayerAnswer = scanner.nextLine();
        int countPlayer = Integer.valueOf(countPlayerAnswer);

        System.out.print("How many points are necessary to win? ");
        String numberOfPointsAnswer = scanner.nextLine();
        int countPoints = Integer.valueOf(numberOfPointsAnswer);

        Board board = new Board(countPoints, countPlayer);
        RandomFlyWeightCard randomCardFactory = new RandomFlyWeightCard();

        while (!board.playerWon()){
            Card card = randomCardFactory.getRandomCard();
            board.nextPlayerMove(card);
        }
        board.displayChart();
        Board.printDelimiter();
    }
}