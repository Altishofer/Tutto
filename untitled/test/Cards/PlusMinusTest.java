package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusTest{

    PlusMinus card = new StubCardPlusMinus();

    @Test
    void makeMoveTuttoOnesOnce() {
        ((StubCardPlusMinus)card).setStubNr("tuttoOnes");
        int result = card.makeMove().getFirst();
        assertEquals(1000, result);
    }

    @Test
    void makeMoveInvalid() {
        ((StubCardPlusMinus)card).setStubNr("invalid");
        int result = card.makeMove().getFirst();
        assertEquals(0, result);
    }
}