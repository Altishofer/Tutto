package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopTest {

    Stop card = new Stop();

    @Test
    void testMakeMove() {
        int result = card.makeMove().getFirst();
        assertEquals(0, result);
    }

    @Test
    void testToString() {
        String result = card.toString();
        assertEquals("Stop-Card", result);
    }
}