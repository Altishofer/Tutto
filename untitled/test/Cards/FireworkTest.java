package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireworkTest {

    Firework card = new Firework();

    @Test
    void testToString() {
        String result = card.toString();
        assertEquals("Firework-Card",result);
    }

    @Test
    void rollNotValid() {
    }

    @Test
    void makeMove() {
    }
}