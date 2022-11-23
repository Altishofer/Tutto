package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class X2Test {
    X2 aX2 = new X2();
    //TODO: Adrian

    @Test
    void testToString() {
        assertEquals("x2-Card", aX2.toString());
    }

    @Test
    void rollIsTutto() {
        for (int i = 0; i < 20; i++){
            X2 x2_temp = new X2();
            // not yet correct
            assertTrue(x2_temp.rollIsTutto() == (x2_temp.intermediatePoints + x2_temp.roll.getPoints()) * 2
                             || x2_temp.rollIsTutto() == 0
                             || x2_temp.rollIsTutto() > (x2_temp.intermediatePoints + x2_temp.roll.getPoints()) * 2);
        }
    }
}
