package Board;

import Cards.Card;
import Cards.FlyWeightDeck;
import Cards.Stop;

public class StubFlyWeightDeck extends FlyWeightDeck{

    @Override
    public Card getRandomCard(){
        return new Stop();
    }
}
