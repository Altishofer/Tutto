package Cards;


public class StubFirework extends Firework{

    private boolean stopOrRollReturn = false;

    @Override
    protected boolean stopOrRoll(){
        return stopOrRollReturn;
    }


}
