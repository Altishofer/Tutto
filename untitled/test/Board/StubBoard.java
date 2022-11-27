package Board;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StubBoard extends Board{
    private Scanner scannerTest;
    private PrintStream printStream;

    public StubBoard(Integer pMaxPoints, Integer pNumberOfPlayers, InputStream inputStream, PrintStream printStream) {
        super(pMaxPoints,pNumberOfPlayers);
        super.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    @Override
    protected void setUpPlayers(Integer numberOfPlayer){
        int numPlayer = numberOfPlayer;
        Player player1 = new Player("player1");
        player1.addPoints(1500);
        aPlayers.add(player1);
    }

}
