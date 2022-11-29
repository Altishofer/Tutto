package Utils;

import Cards.StubCardStraight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollStraightTest {

    StubCardStraight.StubStraightRoll roll = new StubCardStraight.StubStraightRoll();

    @Test
    void testNotValid() {
        ((StubCardStraight.StubStraightRoll) roll).setCommand("invalid");
        roll.rollDices();
        assertEquals(roll.getPoints(), 0);
    }
}