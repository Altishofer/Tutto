package Utils;

import Cards.StubCardStraight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RollStraightTest {

    //TODO: Pädi & Sandrin

    StubCardStraight.StubStraightRoll roll = new StubCardStraight.StubStraightRoll();


    @Test
    void testNotValid() {
        ((StubCardStraight.StubStraightRoll) roll).setCommand("invalid");
        roll.rollDices();

    }

    @Test
    void putAsideDices() {
    }

    @Test
    void isValid() {
    }

    @Test
    void testPutAsideDices() {
    }
}