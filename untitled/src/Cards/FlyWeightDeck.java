package Cards;

import java.util.ArrayList;
import java.util.Collections;

public class FlyWeightDeck {
    private ArrayList<Card> aCardFlyWeightStore;

    public FlyWeightDeck(){
        prepareCardsNew();
    }

    public Card getRandomCard(){
        if (aCardFlyWeightStore.isEmpty()){prepareCardsNew();}
        return aCardFlyWeightStore.remove(0);
    }

    private void prepareCardsNew(){
        aCardFlyWeightStore = new ArrayList<Card>();
        //aCardFlyWeightStore.add(SingletonCloverLeaf.getInstance());
        for (int i=0; i<5; i++){
            //aCardFlyWeightStore.add(new Straight());
            //aCardFlyWeightStore.add(new Firework());
            //aCardFlyWeightStore.add(new PlusMinus());
            //aCardFlyWeightStore.add(new X2());
            for (int j=2; j<7; j++){
                aCardFlyWeightStore.add(new Bonus(j*100));
            }
            for (int j=0; j<2; j++){
                //aCardFlyWeightStore.add(new Stop());
            }
        }
        Collections.shuffle(aCardFlyWeightStore);
    }
}
