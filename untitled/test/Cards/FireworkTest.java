package Cards;

import Utils.Roll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FireworkTest {

    Firework card = new Firework();
    Class<Roll> roll = Roll.class;
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
            Field rollPoints = roll.getDeclaredField("points");
            int check = rollPoints.getInt(roll);
            assertEquals(result,check+inter);
        } catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }

    @Test
    void testMakeMoveNotValid() {
        boolean branchTutto = false;
        boolean branchNotValid = false;

        int result = card.makeMove();
        try{
            Method isValid = roll.getDeclaredMethod("isValid");
            boolean valid = (boolean)isValid.invoke(roll);
            if(valid){
                branchTutto = true;
                assertEquals(card.rollIsTutto(),result);
            }else{
                branchNotValid = true;
                assertEquals(card.rollNotValid(),result);
            }
        }catch(ReflectiveOperationException e){
            e.printStackTrace();
        }
    }
}