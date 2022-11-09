package Board;

import Cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Board {
    private ArrayList<Player> aPlayers;
    private static Integer MAX_POINTS;
    private int currentPlayerIndex;

    public Board(Integer pMaxPoints, Integer pNumberOfPlayers){
        MAX_POINTS = pMaxPoints;
        currentPlayerIndex = 0;
        aPlayers = new ArrayList<Player>();
        setUpPlayers(pNumberOfPlayers);
    }

    private void addPlayer(String pName){
        Player newPlayer = new Player(pName);
        aPlayers.add(newPlayer);
    }

    public boolean playerWon(){
        for (Player player : aPlayers){
            if (player.getPoints() >= MAX_POINTS){
                Board.printDelimiter();
                Board.printDelimiter();
                System.out.println("THE WINNER IS -> " + player.getPlayerName().toUpperCase());
                Board.printDelimiter();
                return true;
            }
        }
        return false;
    }

    private void setUpPlayers(Integer numberOfPlayer){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<numberOfPlayer; i++){
            System.out.print("Player " + i + " set your name: ");
            String playerName = scanner.nextLine();
            addPlayer(playerName);
        }
        Collections.sort(aPlayers);
    }

    public void displayChart(){
        Board.printDelimiter();
        System.out.println("Player" + "\t\t" + "Points");
        for (Player playerIter : aPlayers) {
            System.out.println(playerIter.getPlayerName() + "\t\t\t" + playerIter.getPoints());
        }
    }

    public void nextPlayerMove(Card card){
        Player player = aPlayers.get(currentPlayerIndex);
        currentPlayerIndex = (currentPlayerIndex + 1) % aPlayers.size();
        printNameDelimiter(player);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to display the charts (D) or roll (R) the dice? ");
            String seeOrRoll = scanner.nextLine();
            if (seeOrRoll.equalsIgnoreCase("d")) {
                displayChart();
                Board.printDelimiter();
            }
            if (seeOrRoll.equalsIgnoreCase("r")) {
                Board.printDelimiter();
                System.out.println(player.getPlayerName().toUpperCase() + " has drawn a " + card.toString());
                Board.printDelimiter();
                player.addPoints(card.makeMove());
                return;
            }
        }
    }

    private static void printNameDelimiter(Player player){
        System.out.println("\n#################### current player: " + player.getPlayerName().toUpperCase() + " ####################");
    }

    public static void printDelimiter(){
        System.out.println("-------------------------------------------------");
    }
}
