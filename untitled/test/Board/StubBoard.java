package Board;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StubBoard extends Board{

    public StubBoard(Integer pMaxPoints, Integer pNumberOfPlayers) {
        super(pMaxPoints,pNumberOfPlayers);
    }

    @Override
    protected void setUpPlayers(Integer numberOfPlayer){
        int numPlayer = numberOfPlayer;
        Player player1 = new Player("player1");
        player1.addPoints(1500);
        aPlayers.add(player1);
    }

}
