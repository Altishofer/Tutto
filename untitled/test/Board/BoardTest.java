package Board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        StubBoard board = new StubBoard(1000,1,null,null);

    }

    @Test
    void testPlayerWonTrue() {
        StubBoard board = new StubBoard(1000,1,null,null);
        boolean result = board.playerWon();
        assertTrue(result);
    }

    @Test
    void testPlayerWonFalse() {
        StubBoard board = new StubBoard(2000,1,null,null);
        boolean result = board.playerWon();
        assertFalse(result);
    }

    @Test
    void testPlayerWonPrint(){
        StubBoard board = new StubBoard(2000,1,null,null);
        board.playerWon();
        assertEquals(outContent.toString(),"-------------------------------------------------\n"+
                "-------------------------------------------------\n"+
                "THE WINNER IS -> PLAYER1\n"+
                "-------------------------------------------------\n");
    }

    @Test
    void testDisplayChart() {
        StubBoard board = new StubBoard(1000,1,null,null);
        board.displayChart();
        assertEquals(outContent.toString(),"PLAYER1 -> you currently have a score of 1500 points\n" +
                "-------------------------------------------------\n"+
                "Player\t\tPoints\n"+
                "player1\t\t\t1500\n");
    }

    @Test
    void testNextPlayerMoveIntermediatePointsZero() {
        String input = "d\nr\nr";
        ByteArrayInputStream inputStream = new ByteArrayInputStream("d\n".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);

        StubBoard board = new StubBoard(1000,1,inputStream, ps);
        board.nextPlayerMove(0);

        String outputText = byteArrayOutputStream.toString();
        String key = "output:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        assertEquals(output, "7");
    }

    @Test
    void testPrintDelimiter() {
        Board.printDelimiter();
        assertEquals(outContent.toString(),"-------------------------------------------------\n");
    }
}