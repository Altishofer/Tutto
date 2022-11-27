package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class X2Test {
    X2 aX2 = new X2();
    //TODO: Adrian

<<<<<<< HEAD
    @Test
    void testToString() {
        //assertEquals("x2-Card", aX2.toString());
    }

    @Test
    void rollIsTutto() {
        for (int i = 0; i < 20; i++){
            X2 x2_temp = new X2();
            // not yet correct
            //assertTrue(x2_temp.rollIsTutto() == (x2_temp.intermediatePoints + x2_temp.roll.getPoints()) * 2
                            // || x2_temp.rollIsTutto() == 0
                            // || x2_temp.rollIsTutto() > (x2_temp.intermediatePoints + x2_temp.roll.getPoints()) * 2);
        }
=======
    X2 aX2 = new X2();

    @Test
    void testToString() { assertEquals("X2-Card", aX2.toString()); }

    @Test
    void rollIsTutto_checkDoubling() {
        // Card.intermediatePoints = 0 at initialization
        StubCardX2Stop mX2 = new StubCardX2Stop();
        int rollPoints = mX2.roll.getPoints();
        assertEquals(rollPoints * 2, mX2.rollIsTutto().getFirst());
    }

    @Test // made intermediatePoints public for this
    void rollIsTutto_intermediatePointsIncrease() {
        StubCardX2Stop mX2 = new StubCardX2Stop();
        int intermediatePointsbefore = mX2.intermediatePoints;
        mX2.rollIsTutto();
        assertEquals(intermediatePointsbefore + 2*mX2.roll.getPoints(), aX2.intermediatePoints);
    }

    @Test
    void rollIsTutto_stop() {
        StubCardX2Stop mX2 = new StubCardX2Stop();
        ((StubRoll) mX2.roll).setCommand("tuttoOnes");
        ((StubRoll) mX2.roll).startOverRoll();
        ((StubRoll) mX2.roll).putAside();
        assertTrue(((X2) mX2).rollIsTutto().getFirst() > 0);
        assertTrue(((X2) mX2).rollIsTutto().getSecond() == false);
    }

    @Test // StubCardX2Roll should inherit from StubCard for setCommand
    void rollIsTutto_roll() {
        StubCardX2Roll mX2 = new StubCardX2Roll();
        ((StubRoll) mX2.roll).setCommand("tuttoOnes");
        ((StubRoll) mX2.roll).startOverRoll();
        ((StubRoll) mX2.roll).putAside();
        assertTrue(((X2) mX2).rollIsTutto().getFirst() > 0);
        assertTrue(((X2) mX2).rollIsTutto().getSecond() == true);
>>>>>>> adi
    }
}
