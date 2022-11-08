package Board;

import States.Bonus;
import States.CardInterface;

import javax.swing.*;
import java.util.ArrayList;
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
        nextPlayerMove();
    }

    private void addPlayer(String pName){
        Player newPlayer = new Player(pName);
        aPlayers.add(newPlayer);
    }

    private void setUpPlayers(Integer numberOfPlayer){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<numberOfPlayer; i++){
            System.out.print("Player " + i + " set your name: ");
            String playerName = scanner.nextLine();
            addPlayer(playerName);
        }
        aPlayers.sort(Player::compareTo);
    }

    public void nextPlayerMove(){
        Player player = aPlayers.get(currentPlayerIndex);
        currentPlayerIndex= (currentPlayerIndex + 1) % 4;
        CardInterface bonus = new Bonus();
        bonus.makeMove();
    }
}
