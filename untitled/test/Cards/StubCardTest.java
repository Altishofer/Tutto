package Cards;

import Utils.Dice;
import Utils.DiceValues;
import Utils.Roll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
        private int stops = 0;

        public StubCard(){
            roll = new StubRoll();
            ((StubRoll) roll).getStubNr();
        }
        public String toString(){return "StandardCard";}
        public void setStubNr(DiceValues nr){((StubRoll) roll).setStubNr(nr);}
        public DiceValues getStubNr(){return ((StubRoll) roll).getStubNr();}
        public boolean stopOrRoll() {
            if (stops >= 1) {
                return true;
            }
            stops++;
            return false;
        }
    }

    @Test
    void testToString() {
        assertEquals(card.toString(), "StandardCard");
    }

    @Test
    void rollIsTuttoTrue() {
        int result = card.rollIsTutto();
        assertEquals(result, 200);
    }

    @Test
    void rollNotValid() {
        assertEquals(card.rollNotValid(), 0);
    }

    @Test
    void makeMove() {
        card.makeMove();

    }

}