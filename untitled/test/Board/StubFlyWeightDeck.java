package Board;

import Cards.Card;
import Cards.FlyWeightDeck;
import Cards.Stop;
import Cards.*;

public class StubFlyWeightDeck extends FlyWeightDeck{

    private static String command;
    private static final Card plusMinus = new StubCardPlusMinus();

    public static void setCommand(String pCommand){command = pCommand;}

    public static void setStubNr(String command) {
        ((StubCardPlusMinus) plusMinus).setStubNr(command);
    }


    public static Card getRandomCard() {
        if (command == null || command == "stop") {
            return new Stop();
        }
        if (command == "plusminus") {
            return plusMinus;
        }
        if (command == "bonus") {
            return new BonusTest.StubCardBonus(100);
        }
        return new Stop();
    }
}
