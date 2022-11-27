package Utils;

import java.util.concurrent.TimeUnit;

public class InputOutputUtils {

    // TODO: pädi -> check user inputs mainly used by player
    private final int seconds;
    
    public InputOutputUtils(){
        seconds = 1;
    }

    public void doSleep(){
        try{
            TimeUnit.SECONDS.sleep(this.seconds);
        }catch (InterruptedException e){
            System.out.println("Please do not interrupt!");
        }
    }
}
