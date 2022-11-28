package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusTest{

    PlusMinus card = new StubCardPlusMinus();

    public static class StubCardPlusMinus extends PlusMinus{

        private int stops = 0;
        public StubCardPlusMinus() {
            super();
            aRoll = new StubRoll();
        }

        public void setStubNr(String command){((StubRoll) aRoll).setCommand(command);}

        @Override
        public boolean stopOrRoll() {
            if (stops >= 1) { return true;}
            stops++;
            return false;
        }
    }

    @Test
    void makeMoveTuttoOnesOnce() {
        ((PlusMinusTest.StubCardPlusMinus)card).setStubNr("tuttoOnes");
        int result = card.makeMove().getFirst();
        assertEquals(2000, result);
    }

    @Test
    void makeMoveInvalid() {
        ((PlusMinusTest.StubCardPlusMinus)card).setStubNr("invalid");
        int result = card.makeMove().getFirst();
        assertEquals(0, result);
    }
}