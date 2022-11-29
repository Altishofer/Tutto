package Cards;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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

    @Test
    void stopOrRollStop() {
        card = new PlusMinus();
        String input = "e\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertEquals(true, card.stopOrRoll());
    }
}