package Board;

import Cards.*;

public class StubFlyWeightDeck extends FlyWeightDeck{

    private String command;
    private final Card plusMinus = new StubCardPlusMinus();

    public void setCommand(String command){
        this.command = command;
    }

    public void setStubNr(String command) {
        ((StubCardPlusMinus) plusMinus).setStubNr(command);
    }

    @Override
    public Card getRandomCard() {
        if (this.command == null || this.command == "stop") {
            return new Stop();
        }
        if (this.command == "plusminus") {
            return plusMinus;
        }
        if (this.command == "bonus") {
            return new Bonus(100);
        }
        return new Stop();
    }
}
