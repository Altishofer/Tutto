package Roll;

public class RollStraight extends Roll {

    protected boolean[] aAsideDices;

    public RollStraight(){
        aAsideDices = new boolean[6];
    }

    @Override
    public boolean isValid(){
        for(int i = 0; i< aFrequencyOfValues.length; i++) {
            if (aFrequencyOfValues[i] != 0 && !aAsideDices[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void putAsideDices(){
        for(int i = 0; i< aFrequencyOfValues.length; i++){
            if (aFrequencyOfValues[i] != 0 && !aAsideDices[i]){
                aAsideDices[i] = true;
                aDicesLeft--;
            }
        }
    }
}
