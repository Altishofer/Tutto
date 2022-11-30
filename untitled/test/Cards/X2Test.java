package Cards;

import Roll.StubRoll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class X2Test {
    X2 aX2 = new X2();

    @Test
    void testToString() { assertEquals("X2-Card", aX2.toString()); }

    @Test
    void rollIsTutto_checkDoubling() {
        StubCardX2Stop mX2 = new StubCardX2Stop();
        int rollPoints = mX2.aRoll.getPoints();
        assertEquals(rollPoints * 2, mX2.rollIsTutto().getFirst());
    }

    @Test
    void rollIsTutto_intermediatePointsIncrease() {
        StubCardX2Stop mX2 = new StubCardX2Stop();
        int intermediatePointsbefore = mX2.aIntermediatePoints;
        mX2.rollIsTutto();
        assertEquals(intermediatePointsbefore + 2*mX2.aRoll.getPoints(), aX2.aIntermediatePoints);
    }

    @Test
    void rollIsTutto_stop() {
        StubCardX2Stop mX2 = new StubCardX2Stop();
        ((StubRoll) mX2.aRoll).setCommand("tuttoOnes");
         mX2.aRoll.startOverRoll();
         mX2.aRoll.putAside();
        assertTrue((mX2).rollIsTutto().getFirst() > 0);
        assertTrue((mX2).rollIsTutto().getSecond() == false);
    }

    @Test
    void rollIsTutto_roll() {
        StubCardX2Roll mX2 = new StubCardX2Roll();
        ((StubRoll) mX2.aRoll).setCommand("tuttoOnes");
        mX2.aRoll.startOverRoll();
        mX2.aRoll.putAside();
        assertTrue((mX2).rollIsTutto().getFirst() > 0);
        assertTrue((mX2).rollIsTutto().getSecond() == true);
    }
}
