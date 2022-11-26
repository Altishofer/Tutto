package CloverLeafTests;

import Cards.CloverLeaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloverLeafTest {
    CloverLeaf cloverLeaf = new CloverLeaf();

    @Test
    void testToString() {assertEquals("Cloverleaf-Card", cloverLeaf.toString());}

    //
    @Test
    void rollIsTutto() { // made CloverLeaf.rollIsTutto() public for this test: bad design?
        CloverLeaf cloverLeaf_1 = new CloverLeaf();
        cloverLeaf_1.rollIsTutto();
        assertEquals(true, cloverLeaf_1.alreadyTutto);
        // test positive return: possibly bad design
        assertTrue(new CloverLeaf().rollIsTutto() >= 0);
    }

    @Test
    void rollNotValid() { // made CloverLeaf.rollNotValid() public for this test: bad design?
        CloverLeaf cloverLeaf_1 = new CloverLeaf();
        assertEquals(0, cloverLeaf_1.rollNotValid());
    }

    @Test
    void makeMove() {
        // test positive return
        assertTrue(new CloverLeaf().makeMove() >= 0);
        // test double Tutto: only valid dice allowed
        assertEquals(Integer.MAX_VALUE, new Cards.CloverLeaf.StubCloverLeafSuccess().makeMove());
        // test no double Tutto:
        assertNotEquals(Integer.MAX_VALUE, new Cards.CloverLeaf.StubCloverLeafFailure().makeMove());
    }
}