package Board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    //TODO: Pädi, Cedi
    Class<Board> boardClass = Board.class;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // TODO: to reach enought coverage test also private
    @Test
    void testGetBestPlayer(){
        StubBoard board = new StubBoard(1000,1);

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
        StubBoard board = new StubBoard(2000,1);
        board.playerWon();
        assertEquals(outContent.toString(),"-------------------------------------------------\n"+
                "-------------------------------------------------\n"+
                "THE WINNER IS -> PLAYER1\n"+
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
        StubBoard board = new StubBoard(1000,1);

        String input = "r" + "\nr" + "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr"+ "\nr";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.nextPlayerMove(0);

        String expected = "Do you want to display the charts (D) or roll (R) the dice? PLAYER1 -> you have drawn a \n#################### current player: PLAYER1####################";

        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPrintDelimiter() {
        Board.printDelimiter();
        assertEquals(outContent.toString(),"-------------------------------------------------\n");
    }
}