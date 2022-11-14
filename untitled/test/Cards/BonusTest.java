package Cards;

import Utils.Roll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    Bonus card = new Bonus(100);
    Roll roll = new Roll();

    @Test
    void testToString() {
        assertEquals(card.toString(), "Bonus-Card");
    }

    @Test
    void testConstructor(){
        try{
            Field bonusValue = card.getClass().getDeclaredField("BONUS_VALUE");
            bonusValue.setAccessible(true);
            assertEquals(bonusValue.get(card), 100);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testRollIsTuttoStop() {
        try{
            Field intermediatePoints = Bonus.class.getSuperclass().getDeclaredField("intermediatePoints");
            intermediatePoints.setAccessible(true);
            intermediatePoints.set(card, 0);

            Field roll = Bonus.class.getSuperclass().getDeclaredField("roll");
            roll.setAccessible(true);
            roll.set(card, new Roll());

            Field points = Roll.class.getDeclaredField("points");
            points.setAccessible(true);
            points.set(this.roll, 0);

            InputStream sysInBackup = System.in;
            ByteArrayInputStream in = new ByteArrayInputStream("E".getBytes());
            System.setIn(in);

            int out = card.rollIsTutto();

            assertEquals(out, 100);
            System.setIn(sysInBackup);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


/*


 */