package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonCloverLeafTest {
    SingletonCloverLeaf cloverLeaf = SingletonCloverLeaf.getInstance();

    @Test
    void testToString() {
        assertEquals("Cloverleaf-Card", cloverLeaf.toString());
    }

    @Test
    void rollIsTutto_alreadyTuttoTrue() { // made CloverLeaf.rollIsTutto() and ".alreadyTutto public: bad design?
        SingletonCloverLeaf mCloverLeaf = SingletonCloverLeaf.getInstance();
        mCloverLeaf.rollIsTutto();
        assertEquals(true, mCloverLeaf.aAlreadyTutto);
    }

    @Test
    void rollIsTutto_nonNegativeFirst() {
        assertTrue(SingletonCloverLeaf.getInstance().rollIsTutto().getFirst() >= 0);
    }

    @Test
    void rollIsTutto_falseSecondReturn() {
        assertFalse(SingletonCloverLeaf.getInstance().rollIsTutto().getSecond());
    }

    @Test // made CloverLeaf.rollNotValid() public: bad design?
    void rollNotValid() {
        assertEquals(0, SingletonCloverLeaf.getInstance().rollNotValid());
    }

    @Test
    void makeMove_nonNegativeReturn() {
        assertTrue(SingletonCloverLeaf.getInstance().makeMove().getFirst() >= 0);
    }

    @Test // made CloverLeaf.roll public: bad design?
    void makeMove_firstRollInvalid() {
        SingletonCloverLeaf mCloverLeaf = SingletonCloverLeaf.getInstance();
        mCloverLeaf.aRoll = new StubRoll();
        ((StubRoll) mCloverLeaf.aRoll).setCommand("invalid");
        assertEquals(0, mCloverLeaf.makeMove().getFirst());
        assertEquals(false, mCloverLeaf.makeMove().getSecond());
    }

    @Test
    void makeMove_invalidAfterAlreadyTutto() {
        SingletonCloverLeaf mCloverLeaf = SingletonCloverLeaf.getInstance();
        mCloverLeaf.aRoll = new StubRoll();
        mCloverLeaf.aAlreadyTutto = true;
        ((StubRoll) mCloverLeaf.aRoll).setCommand("invalid");
        assertEquals(0, mCloverLeaf.makeMove().getFirst());
    }

    @Test
    void makeMove_tuttoThenInvalid() {
        StubCloverLeafOneTutto mCloverLeaf = new StubCloverLeafOneTutto();
        mCloverLeaf.aRoll = new StubRoll();
        ((StubRoll) mCloverLeaf.aRoll).setCommand("tuttoOnes");
        assertEquals(0, mCloverLeaf.makeMove().getFirst());
    }

    @Test
    void makeMove_secondTutto() {
        SingletonCloverLeaf mCloverLeaf = SingletonCloverLeaf.getInstance();
        mCloverLeaf.aRoll = new StubRoll();
        mCloverLeaf.aAlreadyTutto = true;
        ((StubRoll) mCloverLeaf.aRoll).setCommand("tuttoOnes");
        assertEquals(Integer.MAX_VALUE, mCloverLeaf.makeMove().getFirst());
        assertEquals(false, mCloverLeaf.makeMove().getSecond());
    }
}


