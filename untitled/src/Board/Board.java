package Board;

import States.Bonus;
import States.CardInterface;

import java.util.ArrayList;
import java.util.Collection;
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

    public void nextPlayerMove(){
        Player player = aPlayers.get(currentPlayerIndex);
        currentPlayerIndex = (currentPlayerIndex + 1) % 3;
        CardInterface bonus = new Bonus(player);

        printNameDelimiter(player);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to display the charts (D) or roll (R) the dice? ");
            String seeOrRoll = scanner.nextLine();
            if (seeOrRoll.equalsIgnoreCase("d")) {
                Board.printDelimiter();
                System.out.println("Player" + "\t\t\t" + "Points");
                for (Player playerIter : aPlayers) {
                    System.out.println(playerIter.getPlayerName() + "\t\t\t" + playerIter.getPoints());
                }
                Board.printDelimiter();
            }
            if (seeOrRoll.equalsIgnoreCase("r")) {
                player.addPoints(bonus.makeMove());
                return;
            }
        }
    }

    private static void printNameDelimiter(Player player){
        System.out.println("#################### current player: " + player.getPlayerName().toUpperCase() + " ####################");
    }

    public static void printDelimiter(){
        System.out.println("-------------------------------------------------");
    }
}
