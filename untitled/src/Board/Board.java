package Board;

import Cards.Card;
import Cards.FlyWeightDeck;
import Cards.PlusMinus;
import Utils.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Board {

    private int aCurrentPlayerIndex;
    protected ArrayList<Player> aPlayers;
    protected static Integer MAX_POINTS;
    protected Scanner aScanner;

    public Board(Integer pMaxPoints, Integer pNumberOfPlayers){
        MAX_POINTS = pMaxPoints;
        aCurrentPlayerIndex = 0;
        aPlayers = new ArrayList<Player>();
        setUpPlayers(pNumberOfPlayers);
        aScanner = new Scanner(System.in);
    }

    public boolean playerWon(){
        for (Player player : aPlayers){
            if (player.getPoints() >= MAX_POINTS){
                Board.printDelimiter();
                Board.printDelimiter();
                System.out.print("THE WINNER IS -> " + player.getPlayerName().toUpperCase()+"\n");
                Board.printDelimiter();
                return true;
            }
        }
        return false;
    }

    public static void printDelimiter(){
        System.out.print("-------------------------------------------------\n");
    }

    public void displayChart(){
        Board.printDelimiter();
        System.out.print("Player" + "\t\t" + "Points\n");
        for (Player playerIter : aPlayers) {
            if (playerIter.getPoints() == Integer.MAX_VALUE){
                System.out.print(playerIter.getPlayerName() + "\t\t\t" + "Maximum" +"\n");
            }
            else {
                System.out.print(playerIter.getPlayerName() + "\t\t\t" + playerIter.getPoints()+"\n");
            }
        }
    }

    protected Card getRandomCard(){
        return FlyWeightDeck.getRandomCard();
    }

    public void nextPlayerMove(int intermediatePoints, boolean plusMinus){
        Card card = getRandomCard();
        Player player;
        if (intermediatePoints > 0  || plusMinus){
            if (aCurrentPlayerIndex == 0){
                player = aPlayers.get(aPlayers.size()-1);
            }
            else {
                player = aPlayers.get(aCurrentPlayerIndex -1);
            }
        }
        else {
            player = aPlayers.get(aCurrentPlayerIndex);
            aCurrentPlayerIndex = (aCurrentPlayerIndex + 1) % aPlayers.size();
        }

        printNameDelimiter(player);
        while (true) {
            System.out.print("Do you want to display the charts (D) or roll (R) the dice? ");
            String seeOrRoll = aScanner.nextLine();
            if (seeOrRoll.equalsIgnoreCase("d")) {
                displayChart();
                Board.printDelimiter();
            }
            if (seeOrRoll.equalsIgnoreCase("r")) {
                Board.printDelimiter();
                System.out.print(player.getPlayerName().toUpperCase() + " -> you have drawn a " + card.toString()+"\n");
                Board.printDelimiter();
                card.addIntermediatePoints(intermediatePoints);
                Tuple result = card.makeMove();
                if (card.getClass() == PlusMinus.class && result.getFirst() > 0){
                    ArrayList<Player> bestPlayers = getBestPlayer(player);
                    for (Player bestPlayer : bestPlayers){
                        bestPlayer.addPoints(-1000);
                    }
                }
                if (result.getSecond()){
                    printDelimiter();
                    if (card.getClass() == PlusMinus.class){
                        nextPlayerMove(0, true);
                    }
                    else {
                        nextPlayerMove(result.getFirst(), false);
                    }
                    return;
                }
                player.addPoints(result.getFirst());
                return;
            }
        }
    }

    protected void setUpPlayers(Integer numberOfPlayer){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<numberOfPlayer; i++){
            System.out.print("Player " + i + " set your name: ");
            aPlayers.add(new Player(scanner.nextLine()));
        }
        Collections.sort(aPlayers);
    }

    private static void printNameDelimiter(Player player) {
        System.out.print("\n#################### current player: " + player.getPlayerName().toUpperCase() + " ####################\n");
    }

    private ArrayList<Player> getBestPlayer(Player currentPlayer){
        ArrayList<Player> bestPlayers = new ArrayList<>();
        int maxPoints = Integer.MIN_VALUE;
        for (Player player : aPlayers){
            if (player.getPoints() > maxPoints){
                maxPoints = player.getPoints();
            }
        }
        for (Player player : aPlayers){
            if (player.getPoints() >= maxPoints && player.getPlayerName() != currentPlayer.getPlayerName() ){
                bestPlayers.add(player);
            }
        }
        return bestPlayers;
    }
}
