package Board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPlayerWonTrue() {
        StubBoard board = new StubBoard(1000,1);
        boolean result = board.playerWon();
        assertTrue(result);
    }

    @Test
    void testPlayerWonFalse() {
        StubBoard board = new StubBoard(2000,1);
        boolean result = board.playerWon();
        assertFalse(result);
    }

    @Test
    void testPlayerWonPrint(){
        StubBoard board = new StubBoard(1000,1);
        board.playerWon();
        assertEquals(outContent.toString(),"PLAYER1 -> you currently have a score of 1500 points\n" +
                "-------------------------------------------------\n" +
                "-------------------------------------------------\n" +
                "THE WINNER IS -> PLAYER1\n" +
                "-------------------------------------------------\n");
    }

    @Test
    void testDisplayChart() {
        StubBoard board = new StubBoard(1000,1);
        board.displayChart();
        assertEquals(outContent.toString(),"PLAYER1 -> you currently have a score of 1500 points\n" +
                "-------------------------------------------------\n"+
                "Player\t\tPoints\n"+
                "player1\t\t\t1500\n");
    }

    @Test
    void testNextPlayerMoveIntermediatePointsZero() {
        String input = "r\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StubBoard board = new StubBoard(1000,1, inputStream);

        board.nextPlayerMove(0);

        String expected = "PLAYER1 -> you currently have a score of 1500 points\n" +
                "\n" +
                "#################### current player: PLAYER1 ####################\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "PLAYER1 -> you have drawn a Stop-Card\n" +
                "-------------------------------------------------\n" +
                "PLAYER1 -> you currently have a score of 1500 points\n";

        assertEquals(expected, outContent.toString());
    }

    //@Test
    void testNextPlayerMoveSecond() {
        String input = "r\nd\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StubBoard board = new StubBoard(2000,2, inputStream);
        board.setCommand("bonus");
        board.nextPlayerMove(0);

        String expected = "PLAYER1 -> you currently have a score of 1500 points\n" +
                "PLAYER2 -> you currently have a score of 1500 points\n" +
                "\n" +
                "#################### current player: PLAYER1 ####################\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "PLAYER1 -> you have drawn a Stop-Card\n" +
                "-------------------------------------------------\n" +
                "PLAYER1 -> you currently have a score of 1500 points\n";

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testNextPlayerMoveIntermediateDisplay() {
        String input = "d\nr\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StubBoard board = new StubBoard(1000,1, inputStream);

        board.nextPlayerMove(0);

        String expected = "PLAYER1 -> you currently have a score of 1500 points\n" +
                "\n" +
                "#################### current player: PLAYER1 ####################\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "Player\t\tPoints\n" +
                "player1\t\t\t1500\n" +
                "-------------------------------------------------\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "PLAYER1 -> you have drawn a Stop-Card\n" +
                "-------------------------------------------------\n" +
                "PLAYER1 -> you currently have a score of 1500 points\n";

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testNextPlayerMoveIntermediatePoints() {
        String input = "r\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        StubBoard board = new StubBoard(5000,1, inputStream);

        board.nextPlayerMove(500);

        String expected = "PLAYER1 -> you currently have a score of 1500 points\n" +
                "\n" +
                "#################### current player: PLAYER1 ####################\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "PLAYER1 -> you have drawn a Stop-Card\n" +
                "-------------------------------------------------\n" +
                "PLAYER1 -> you currently have a score of 1500 points\n";

        assertEquals(expected, outContent.toString());
    }


    @Test
    void testNextPlayerMovePlusMinus() {
        String input = "r\nr\ne\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        StubBoard board = new StubBoard(5000, 1, inputStream);
        board.setCommand("plusminus");
        board.setStubNr("tuttoOnes");

        board.nextPlayerMove(0);

        String expected = "PLAYER1 -> you currently have a score of 1500 points\n" +
                "\n" +
                "#################### current player: PLAYER1 ####################\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "PLAYER1 -> you have drawn a Plus/Minus-Card\n" +
                "-------------------------------------------------\n" +
                "You have rolled the combination: [1, 1, 1, 1, 1, 1]\n" +
                "-------------------------------------------------\n" +
                "TUTTO!! -> you earned already 2000 points \n" +
                "-------------------------------------------------\n" +
                "-------------------------------------------------\n" +
                "\n" +
                "#################### current player: PLAYER1 ####################\n" +
                "Do you want to display the charts (D) or roll (R) the dice? -------------------------------------------------\n" +
                "PLAYER1 -> you have drawn a Plus/Minus-Card\n" +
                "-------------------------------------------------\n" +
                "You have rolled the combination: [1, 1, 1, 1, 1, 1]\n" +
                "-------------------------------------------------\n" +
                "TUTTO!! -> you earned already 4000 points \n" +
                "-------------------------------------------------\n" +
                "PLAYER1 -> you currently have a score of 5500 points\n";

        assertEquals(expected, outContent.toString());
    }


    //@Test
    void testSetUpPlayer(){
        String input = "player1\nplayer2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int aNumberOfPlayers = 2;
        Board board = new Board(2000,aNumberOfPlayers);

        String expected = "Player 0 set your name: Player 1 set your name: ";
        assertEquals(expected, outContent.toString());
        }

    @Test
    void testPrintDelimiter() {
        Board.printDelimiter();
        assertEquals(outContent.toString(),"-------------------------------------------------\n");
    }
}