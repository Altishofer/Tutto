package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StubCardTest {
    StubCard card = new StubCard();

    @Test
    void makeMoveTuttoOnesTwice() {
        card.setStubNr("tuttoOnes");
        int result = card.makeMove();
        assertEquals(4000, result);
    }

    @Test
    void makeMoveInvalid() {
        card.setStubNr("invalid");
        int result = card.makeMove();
        assertEquals(0, result);
    }

    @Test
    void makeMoveValidNotTuttoTwice() {
        card.setStubNr("validNotTutto");
        int result = card.makeMove();
        assertEquals(400, result);
    }
}