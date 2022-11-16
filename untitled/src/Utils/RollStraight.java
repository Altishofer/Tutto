package Utils;

public class RollStraight extends Roll {

    private boolean[] asideDices;

    public RollStraight(){
        asideDices = new boolean[6];
    }

    public boolean isValid(){
        for(int i=0; i<frequencyOfValues.length; i++) {
            if (frequencyOfValues[i] != 0 && !asideDices[i]) {
                return true;
            }
        }
        return false;
    }

    public void putAsideDices(){

        for(int i=0; i<frequencyOfValues.length; i++){
            if (frequencyOfValues[i] != 0 && !asideDices[i]){
                asideDices[i] = true;
                dicesLeft--;
            }
        }
    }
}
