package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InputOutputUtils {

    private final int aSecond;
    public InputOutputUtils(int sleep){
        aSecond = sleep;
    }

    public void doSleep(){
        try{
            TimeUnit.SECONDS.sleep(this.aSecond);
        }catch (InterruptedException e){
            System.out.print("Please do not interrupt!\n");
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
            System.out.print("Please enter an integer number greater than 0.\n");
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
