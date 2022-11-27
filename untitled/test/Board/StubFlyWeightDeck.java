package Board;

import Cards.Card;
import Cards.FlyWeightDeck;
import Cards.PlusMinus;
import Cards.Stop;

public class StubFlyWeightDeck extends FlyWeightDeck{

    private String command;

    public void setCommand(String command){
        this.command = command;
    }

    @Override
    public Card getRandomCard(){
        if(this.command == null || this.command == "stop"){
            return new Stop();
        }
        if(this.command == "plusminus"){
            return new PlusMinus();
        }
        return new Stop();
    }
}
