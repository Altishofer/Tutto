package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireworkTest {

    //TODO: CEDI

    Firework card = new Firework();

    @Test
    void testToString() {
        String result = card.toString();
        assertEquals("Firework-Card",result);
    }

    @Test
    void testRollNotValid() {
        int result = card.rollNotValid();
        assertEquals(100,result);
    }

    @Test
    void testMakeMoveNotValid() {
        int result = card.makeMove();
        assertEquals(100,result);
    }

    @Test
    void testMakeMoveTutto() {
        int result = card.makeMove();
        assertEquals(100,result);
    }
}