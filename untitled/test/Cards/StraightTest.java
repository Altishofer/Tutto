package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

    //TODO: Pädi & Sandrin

    StubCardStraight card = new StubCardStraight();

    @Test
    void rollIsTutto() {
        card.setStubNr("tutto");
        int result = card.makeMove();
        assertEquals(4000, result);
    }

    //TODO: Check if correct amount of points is returned for Straight (Pädi)
    /*@Test
    void rollIsStraight() {

    }*/

    @Test
    void rollIsInvalid() {
        card.setStubNr("invalid");
        int result = card.makeMove();
        assertEquals(0, result);
    }

    @Test
    void rollIsValidNotTutto() {
        card.setStubNr("validNotTutto");
        int result = card.makeMove();
        assertEquals(4000, result);
    }
}