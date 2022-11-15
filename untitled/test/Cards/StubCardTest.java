package Cards;

import Utils.DiceValues;
import Utils.Roll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StubCardTest {
    StubCard card = new StubCard();
    public class StubRoll extends Roll{
        private String command;
        public void setCommand(String pCommand){command = pCommand;}
        public String getCommand(){return command;}
        @Override
        public void rollDices(){
            rolledDices = new ArrayList<>(){};
            if (command == null || command == "invalid"){
                List<DiceValues> invalid = Arrays.asList(DiceValues.TWO, DiceValues.THREE, DiceValues.FOUR);
                for (int i=0;i<dicesLeft;i++){rolledDices.add(invalid.get(i%3));}
            }
            if (command == "validNotTutto"){
                List<DiceValues> invalid = Arrays.asList(DiceValues.ONE, DiceValues.THREE, DiceValues.FOUR);
                for (int i=0;i<dicesLeft;i++){rolledDices.add(invalid.get(i%3));}
            }
            if (command == "tuttoOnes"){
                for (int i=0;i<dicesLeft;i++){rolledDices.add(DiceValues.ONE);}
            }
            frequencyOfValues = calculateFrequencies();
        }

        @Override
        public void startOverRoll(){
            dicesLeft = DiceValues.values().length;
            points = 0;
            this.rollDices();
        }
    }

    public class StubCard extends Card {
        private int stops = 0;
        public StubCard(){
            roll = new StubRoll();
            ((StubRoll) roll).getCommand();
        }
        public String toString(){return "StandardCard";}
        public void setStubNr(String command){((StubRoll) roll).setCommand(command);}
        public String getStubNr(){return ((StubRoll) roll).getCommand();}
        public boolean stopOrRoll() {
            if (stops >= 1) { return true;}
            stops++;
            return false;
        }
    }

    @Test
    void rollIsTuttoTrue() {
        int result = card.rollIsTutto();
        assertEquals(result, 0);
    }

    @Test
    void rollNotValid() {
        assertEquals(card.rollNotValid(), 0);
    }

    @Test
    void makeMoveTuttoOnesTwice() {
        card.setStubNr("tuttoOnes");
        int result = card.makeMove();
        assertEquals(4000, result);
    }

    @Test
    void makeMoveInvalid() {
        card.setStubNr("invalid");
        int result = card.makeMove();
        assertEquals(0, result);
    }

    @Test
    void makeMoveValidNotTuttoTwice() {
        card.setStubNr("validNotTutto");
        int result = card.makeMove();
        assertEquals(100, result);
    }
}