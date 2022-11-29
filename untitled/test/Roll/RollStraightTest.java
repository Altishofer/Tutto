package Roll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollStraightTest {

    StubRoll stubRoll = new StubRoll();

    @Test
    void cleanEmptyInput(){
        Roll roll = new Roll();
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
        Roll roll = new Roll();
        String input = "1, 2";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {1, 1, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanInvalidInput(){
        Roll roll = new Roll();
        String input = "7, 211";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanInvalidInput_2(){
        Roll roll = new Roll();
        String input = "1, 211";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanInvalidInput_3(){
        Roll roll = new Roll();
        String input = "7, 1";
        int[] result = roll.cleanUpUserInput(input);
        int[] expected = {0, 0, 0, 0, 0, 0};
        for (int i=0; i<expected.length; i++){
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    void cleanNullInput(){
        Roll roll = new Roll();
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
        assertEquals(stubRoll.getPoints(), 200);
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
        assertEquals(stubRoll.getPoints(), 2000);
    }
}