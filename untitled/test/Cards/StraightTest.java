package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

    StubCardStraight card = new StubCardStraight();

    @Test
    void rollIsTutto() {
        card.setStubNr("tutto");
        int result = card.makeMove().getFirst();
        assertEquals(2000, result);
    }

    @Test
    void rollIsInvalid() {
        card.setStubNr("invalid");
        int result = card.makeMove().getFirst();
        assertEquals(0, result);
    }

    @Test
    void rollIsValidNotTutto() {
        card.setStubNr("validNotTutto");
        int result = card.makeMove().getFirst();
        assertEquals(2000, result);
    }
}