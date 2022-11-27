package Roll;

public class RollStraight extends Roll {

    protected boolean[] asideDices;

    public RollStraight(){
        asideDices = new boolean[6];
    }

    @Override
    public boolean isValid(){
        for(int i = 0; i< rollFreq.length; i++) {
            if (rollFreq[i] != 0 && !asideDices[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void putAsideDice(){
        for(int i = 0; i< rollFreq.length; i++){
            if (rollFreq[i] != 0 && !asideDices[i]){
                asideDices[i] = true;
                dicesLeft--;
            }
        }
    }
}
