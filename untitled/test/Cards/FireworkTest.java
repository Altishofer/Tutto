package Cards;

import Utils.Roll;
import Utils.Tuple;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FireworkTest {


    StubFirework card = new StubFirework();
    Class<Roll> roll = Roll.class;
    Class<StubFirework> firework = StubFirework.class;
    Roll Roll = new Roll();
    StubFirework Firework = new StubFirework();

    //TODO: Cedric


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
        Tuple result = card.makeMove();
        Tuple check = card.rollIsTutto();
        System.out.println(result);
        System.out.println(check);
        assertEquals(result,check);

    }

    @Test
    void testMakeMoveNotValidStopOrRollFalse(){
        Tuple result = card.makeMove();
        int check = card.rollNotValid();
        assertEquals(result, new Tuple(check,false));
    }
}