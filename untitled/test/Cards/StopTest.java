package Cards;

import Utils.Tuple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopTest {

    Stop card = new Stop();

    @Test
    void testMakeMove() {
         Tuple result = card.makeMove();
         Tuple check = new Tuple(0,false);
        assertEquals(check, result);
    }

    @Test
    void testToString() {
        String result = card.toString();
        assertEquals("Stop-Card", result);
    }
}