package Cards;

import java.util.ArrayList;
import java.util.Collections;

public class FlyWeightDeck {
    private ArrayList<Card> CardFlyWeightStore;

    public FlyWeightDeck(){
        prepareCardsNew();
    }

    private void prepareCardsNew(){
        CardFlyWeightStore = new ArrayList<Card>();
        CardFlyWeightStore.add(new CloverLeaf());
        for (int i=0; i<5; i++){
            CardFlyWeightStore.add(new Straight());

            CardFlyWeightStore.add(new Firework());
            CardFlyWeightStore.add(new PlusMinus());
            CardFlyWeightStore.add(new X2());
            for (int j=2; j<7; j++){
                CardFlyWeightStore.add(new Bonus(j*100));
            }
            for (int j=0; j<2; j++){
                CardFlyWeightStore.add(new Stop());
            }
        }
        Collections.shuffle(CardFlyWeightStore);
    }

    public Card getRandomCard(){
        if (CardFlyWeightStore.isEmpty()){prepareCardsNew();}
        return CardFlyWeightStore.remove(0);
    }
}
