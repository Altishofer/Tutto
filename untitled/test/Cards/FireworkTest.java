package Cards;

import Roll.Roll;
import Utils.Tuple;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FireworkTest {


    StubFirework card = new StubFirework();
    Class<Roll> roll = Roll.class;
    Roll Roll = new StubRoll();

    @Test
    void testToString() {
        String result = card.toString();
        assertEquals("Firework-Card",result);
    }

    @Test
    void testRollNotValid() {
        card.setStubNr("invalid");
        int result = card.rollNotValid();
        int inter = card.aIntermediatePoints;

        try{
            Field field = roll.getDeclaredField("aPoints");
            field.setAccessible(true);
            int check = field.getInt(Roll);
            assertEquals(result,check+inter);
        } catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    @Test
    void testMakeMoveTutto() {
        card.setStubNr("tuttoOnes");
        Tuple result = card.makeMove();
        System.out.println(result);
        assertEquals(new Tuple(2000,true),result);
    }

    @Test
    void testMakeMoveNotValid(){
        card.setStubNr("invalid");
        Tuple result = card.makeMove();
        int check = card.rollNotValid();
        assertEquals(check,result.getFirst());
    }
}