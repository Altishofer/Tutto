package Cards;

import java.util.ArrayList;
import java.util.Collections;

public class FlyWeightDeck {
    private final static ArrayList<Card> CARD_FLY_WEIGHT_STORE = new ArrayList<Card>();

    protected FlyWeightDeck(){prepareCardsNew();}

    public static Card getRandomCard(){
        if (CARD_FLY_WEIGHT_STORE.isEmpty()){prepareCardsNew();}
        return CARD_FLY_WEIGHT_STORE.remove(0);
    }

    private static void prepareCardsNew(){
        CARD_FLY_WEIGHT_STORE.add(SingletonCloverLeaf.getInstance());
        for (int i=0; i<5; i++){
            CARD_FLY_WEIGHT_STORE.add(new Straight());
            CARD_FLY_WEIGHT_STORE.add(new Firework());
            CARD_FLY_WEIGHT_STORE.add(new PlusMinus());
            CARD_FLY_WEIGHT_STORE.add(new X2());
            for (int j=2; j<7; j++){
                CARD_FLY_WEIGHT_STORE.add(new Bonus(j*100));
            }
            for (int j=0; j<2; j++){
                CARD_FLY_WEIGHT_STORE.add(new Stop());
            }
        }
        Collections.shuffle(CARD_FLY_WEIGHT_STORE);
    }
}
