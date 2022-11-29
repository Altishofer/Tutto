package Utils;

import Dice.DiceValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InputOutputUtils {
    private final int aSecond;
    public InputOutputUtils(){
        aSecond = 0;
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

    public static int[] cleanUpUserInput(String input) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> values;
        int[] clean = new int[6];
        for (int i=0; i<clean.length; i++){clean[i] = 0;}

        if (input == null || input.isEmpty()){return clean;}
        input = input.replaceAll("\\s+","");
        values = new ArrayList<String>(List.of(input.split(",")));
        for (String str : values){
            if (str.length() > 1 || !str.matches("[1-6]")){return clean;}
        }
        for (String str : values){clean[Integer.valueOf(str) - 1]++;}
        return clean;
    }
}
