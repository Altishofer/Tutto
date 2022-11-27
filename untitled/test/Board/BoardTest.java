package Board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    //TODO: Pädi, Cedi


    @Test
    void playerWonTrue() {
        StubBoard board = new StubBoard(1000,1);
        boolean result = board.playerWon();
        assertTrue(result);
    }

    @Test
    void playerWonFalse() {
        StubBoard board = new StubBoard(2000,1);
        boolean result = board.playerWon();
        assertFalse(result);
    }


    @Test
    void displayChart() {
        // TODO: Better do this in Player since only output here
    }

    @Test
    void nextPlayerMove() {
    }

    @Test
    void printDelimiter() {
    }
}