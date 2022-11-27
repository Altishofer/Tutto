package Utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InputOutputUtils {

    // TODO: pädi -> check user inputs mainly used by player
    private final int aSecond;
    
    public InputOutputUtils(){
        aSecond = 0;
    }

    public void doSleep(){
        try{
            TimeUnit.SECONDS.sleep(this.aSecond);
        }catch (InterruptedException e){
            System.out.println("Please do not interrupt!");
        }
    }

    public static int getIntegerInput(String consoleText) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        while (true) {
            System.out.print(consoleText);
            String answer = scanner.nextLine();
            check = Utils.InputOutputUtils.checkNumeric(answer);
            if (check) {
                int count = Integer.valueOf(answer);
                if (count > 0) {
                    return count;
                }
            }
        }
    }

    private static boolean checkNumeric(String input) {
        if (input == null){return false;}
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
