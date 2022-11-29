package Board;

import Cards.*;

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
        if(this.command == "bonus"){
            return new Bonus(100);
        }
        return new Stop();
    }
}
