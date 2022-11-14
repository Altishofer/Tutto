package Cards;

import Utils.Dice;
import Utils.DiceValues;
import Utils.Roll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StubCardTest {
    StubCard card = new StubCard();
    public class StubRoll extends Roll{
        private DiceValues stubNr = DiceValues.TWO;
        public void setStubNr(DiceValues nr){stubNr = nr;}
        public DiceValues getStubNr(){return stubNr;}
        @Override
        public void rollDices(){
            if (stubNr == null){stubNr = DiceValues.TWO;}
            rolledDices = new ArrayList<DiceValues>();
            for (int i=0;i<dicesLeft;i++){rolledDices.add(stubNr);}
            frequencyOfValues = calculateFrequencies();
        }

        @Override
        public void startOverRoll(){
            dicesLeft = DiceValues.values().length;
            this.rollDices();
        }
    }

    public class StubCard extends Card {

        StubRoll roll;
        public StubCard(){
            roll = new StubRoll();
            roll.getStubNr();
        }
        public String toString(){return "StandardCard";}
        public void setStubNr(DiceValues nr){roll.setStubNr(nr);}
        public DiceValues getStubNr(){return roll.getStubNr();}
    }

    @Test
    void testToString() {
        assertEquals(card.toString(), "StandardCard");
    }

    @Test
    void rollIsTutto() {
        card.setStubNr(DiceValues.TWO);
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("R".getBytes());
        System.setIn(in);
        int result = card.rollIsTutto();
        assertEquals(result, 0);
    }
    /*

    @Test
    void rollNotValid() {
    }

    @Test
    void stopOrRoll() {
    }

    @Test
    void makeMove() {
    }

     */
}