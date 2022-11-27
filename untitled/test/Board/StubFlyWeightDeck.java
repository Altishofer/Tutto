package Board;

import Cards.AbstractCard;
import Cards.FlyWeightDeck;
import Cards.Stop;

public class StubFlyWeightDeck extends FlyWeightDeck{

    @Override
    public AbstractCard getRandomCard(){
        return new Stop();
    }
}
