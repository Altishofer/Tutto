package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloverLeafTest {
    CloverLeaf cloverLeaf = CloverLeaf.getInstance();

    @Test
    void testToString() {
        assertEquals("Cloverleaf-Card", cloverLeaf.toString());
    }

    @Test
    void rollIsTutto_alreadyTuttoTrue() { // made CloverLeaf.rollIsTutto() and ".alreadyTutto public: bad design?
        CloverLeaf mCloverLeaf = CloverLeaf.getInstance();
        mCloverLeaf.rollIsTutto();
        assertEquals(true, mCloverLeaf.alreadyTutto);
    }

    @Test
    void rollIsTutto_nonNegativeFirst() {
        assertTrue(CloverLeaf.getInstance().rollIsTutto().getFirst() >= 0);
    }

    @Test
    void rollIsTutto_falseSecondReturn() {
        assertFalse(CloverLeaf.getInstance().rollIsTutto().getSecond());
    }

    @Test // made CloverLeaf.rollNotValid() public: bad design?
    void rollNotValid() {
        assertEquals(0, CloverLeaf.getInstance().rollNotValid());
    }

    @Test
    void makeMove_nonNegativeReturn() {
        assertTrue(CloverLeaf.getInstance().makeMove().getFirst() >= 0);
    }

    @Test // made CloverLeaf.roll public: bad design?
    void makeMove_firstRollInvalid() {
        CloverLeaf mCloverLeaf = CloverLeaf.getInstance();
        mCloverLeaf.roll = new StubRoll();
        ((StubRoll) mCloverLeaf.roll).setCommand("invalid");
        assertEquals(0, mCloverLeaf.makeMove().getFirst());
        assertEquals(false, mCloverLeaf.makeMove().getSecond());
    }

    @Test
    void makeMove_invalidAfterAlreadyTutto() {
        CloverLeaf mCloverLeaf = CloverLeaf.getInstance();
        mCloverLeaf.roll = new StubRoll();
        mCloverLeaf.alreadyTutto = true;
        ((StubRoll) mCloverLeaf.roll).setCommand("invalid");
        assertEquals(0, mCloverLeaf.makeMove().getFirst());
    }

    @Test
    void makeMove_tuttoThenInvalid() {
        StubCloverLeafOneTutto mCloverLeaf = new StubCloverLeafOneTutto();
        mCloverLeaf.roll = new StubRoll();
        ((StubRoll) mCloverLeaf.roll).setCommand("tuttoOnes");
        assertEquals(0, mCloverLeaf.makeMove().getFirst());
    }

    @Test
    void makeMove_secondTutto() {
        CloverLeaf mCloverLeaf = CloverLeaf.getInstance();
        mCloverLeaf.roll = new StubRoll();
        mCloverLeaf.alreadyTutto = true;
        ((StubRoll) mCloverLeaf.roll).setCommand("tuttoOnes");
        assertEquals(Integer.MAX_VALUE, mCloverLeaf.makeMove().getFirst());
        assertEquals(false, mCloverLeaf.makeMove().getSecond());
    }
}


