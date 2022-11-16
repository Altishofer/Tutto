package Board;

import Cards.Card;
import Cards.PlusMinus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    private ArrayList<Player> getBestPlayer(){
        ArrayList<Player> bestPlayers = new ArrayList<>();
        int maxPoints = aPlayers.get(currentPlayerIndex).getPoints() + 1;
        for (Player player : aPlayers){
            if (player.getPoints() >= maxPoints){
                maxPoints = player.getPoints();
            }
        }
        for (Player player : aPlayers){
            if (player.getPoints() >= maxPoints){
                bestPlayers.add(player);
            }
        }
        return bestPlayers;
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
                int result = card.makeMove();
                if (card.getClass() == PlusMinus.class){
                    ArrayList<Player> bestPlayers = getBestPlayer();
                    for (Player bestPlayer : bestPlayers){
                        bestPlayer.addPoints(-1000);
                    }
                }
                player.addPoints(result);
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

    protected static void printLineDelay(){
        try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e)
        {
            System.out.println("Please do not interrupt!");
        }
    }

}
