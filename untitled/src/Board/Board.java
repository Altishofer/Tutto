package Board;

import Cards.Card;
import Cards.FlyWeightDeck;
import Cards.PlusMinus;
import Utils.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Board {

    // TODO: Cedi (1.prio), Pädi

    // TODO: new card after tutto
    private ArrayList<Player> aPlayers;
    private static Integer MAX_POINTS;
    private int currentPlayerIndex;

    private final FlyWeightDeck rdmCardFactory;

    public Board(Integer pMaxPoints, Integer pNumberOfPlayers){
        MAX_POINTS = pMaxPoints;
        currentPlayerIndex = 0;
        aPlayers = new ArrayList<Player>();
        setUpPlayers(pNumberOfPlayers);
        rdmCardFactory = new FlyWeightDeck();
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
            aPlayers.add(new Player(scanner.nextLine()));
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

    public void nextPlayerMove(int intermediatePoints){
        Card card = rdmCardFactory.getRandomCard();
        Player player;
        if (intermediatePoints > 0){
            if (currentPlayerIndex == 0){
                player = aPlayers.get(aPlayers.size()-1);
            }
            else {
                player = aPlayers.get(currentPlayerIndex -1);
            }
        }
        else {
            player = aPlayers.get(currentPlayerIndex);
            currentPlayerIndex = (currentPlayerIndex + 1) % aPlayers.size();
        }

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
                System.out.println(player.getPlayerName().toUpperCase() + " -> you have drawn a " + card.toString());
                Board.printDelimiter();
                card.addIntermediatePoints(intermediatePoints);
                Tuple result = card.makeMove();
                if (card.getClass() == PlusMinus.class && result.getFirst() > 0){
                    ArrayList<Player> bestPlayers = getBestPlayer();
                    for (Player bestPlayer : bestPlayers){
                        bestPlayer.addPoints(-1000);
                    }
                }
                if (result.getSecond()){
                    printDelimiter();
                    nextPlayerMove(result.getFirst());
                    return;
                }
                player.addPoints(result.getFirst());
                return;
            }
        }
    }

    private static void printNameDelimiter(Player player) {
        System.out.println("\n#################### current player: " + player.getPlayerName().toUpperCase() + " ####################");
    }

    public static void printDelimiter(){
        System.out.println("-------------------------------------------------");
    }
}
