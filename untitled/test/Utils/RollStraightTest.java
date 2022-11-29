package Utils;

import Cards.StubCardStraight;
import Cards.StubRoll;
import Roll.Roll;
import Roll.RollStraight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollStraightTest {



    StubCardStraight.StubStraightRoll stubRoll = new StubCardStraight.StubStraightRoll();

    @Test
    void cleanEmptyInput(){
        Roll roll = new RollStraight();
        String input = "";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = new int[6];
        for (int i=0; i<expected.length; i++){expected[i]=0;}
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanValidInput(){
        Roll roll = new RollStraight();
        String input = "1, 2";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {1, 1, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanInvalidInput(){
        Roll roll = new RollStraight();
        String input = "7, 211";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanInvalidInput_2(){
        Roll roll = new RollStraight();
        String input = "1, 211";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanInvalidInput_3(){
        Roll roll = new RollStraight();
        String input = "7, 1";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanNullInput(){
        Roll roll = new RollStraight();
        String input = new String();
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void userPutAsideValid(){
        stubRoll.setCommand("validNotTutto");
        stubRoll.rollDices();
        stubRoll.whichToPutAside();
        stubRoll.putAsideDice();
        assertEquals(stubRoll.getPoints(), 0);
    }

    @Test
    void userPutAsideInvalid(){
        stubRoll.setCommand("invalid");
        stubRoll.rollDices();
        stubRoll.whichToPutAside();
        stubRoll.putAsideDice();
        assertEquals(stubRoll.getPoints(), 0);
    }

    @Test
    void userPutAsideTutto(){
        stubRoll.setCommand("tuttoOnes");
        stubRoll.rollDices();
        stubRoll.whichToPutAside();
        stubRoll.putAsideDice();
        assertEquals(stubRoll.getPoints(), 0);
    }

    @Test
    void testNotValid() {
        stubRoll.setCommand("invalid");
        stubRoll.rollDices();
        assertEquals(stubRoll.getPoints(), 0);
    }
}