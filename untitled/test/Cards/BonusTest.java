package Cards;

import Utils.Roll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    Bonus card = new StubCardBonus(100);

    public static class StubCardBonus extends Bonus{

        private int stops = 0;
        public StubCardBonus(Integer bonus) {
            super(bonus);
            roll = new StubRoll();
        }

        public void setStubNr(String command){((StubRoll) roll).setCommand(command);}
        public String getStubNr(){return ((StubRoll) roll).getCommand();}

        @Override
        public boolean stopOrRoll() {
            if (stops >= 1) { return true;}
            stops++;
            return false;
        }
    }

    @Test
    void makeMoveTuttoOnesTwice() {
        ((StubCardBonus)card).setStubNr("tuttoOnes");
        int result = card.makeMove();
        assertEquals(4200, result);
    }

    @Test
    void makeMoveInvalid() {
        ((StubCardBonus)card).setStubNr("invalid");
        int result = card.makeMove();
        assertEquals(0, result);
    }


}