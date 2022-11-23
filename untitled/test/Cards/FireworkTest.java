package Cards;

import Utils.Roll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FireworkTest {

    StubFirework card = new StubFirework();

    Class<Roll> roll = Roll.class;
    Roll Roll = new Roll();

    //Roll roll = card.getRoll();

    @Test
    void testToString() {
        String result = card.toString();
        assertEquals("Firework-Card",result);
    }

    @Test
    void testRollNotValid() {
        int result = card.rollNotValid();
        int inter = card.intermediatePoints;

        try{
            Field field = roll.getDeclaredField("points");
            field.setAccessible(true);
            int check = field.getInt(Roll);
            assertEquals(result,check+inter);
        } catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    @Test
    void testMakeMoveTutto() {
        int result = card.makeMove();
        int check = card.rollIsTutto();
        assertEquals(check,result);
    }

    @Test
    void testMakeMoveNotValid(){
        int result = card.makeMove();
        int check = card.rollNotValid();
        assertEquals(check,result);
    }
}