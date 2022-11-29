package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyWeightCardTest {

    private int getCardCount(String type) {
        FlyWeightDeck cardFactory = new FlyWeightDeck();
        Card card;
        int res = 0;

        for (int i = 0; i < 56; i++) {
            card = cardFactory.getRandomCard();
            if (type.equals(card.toString())) {
                res += 1;
            }
        }
        return res;
    }

    private int getCardCount(Class type) {
        FlyWeightDeck cardFactory = new FlyWeightDeck();
        Card card;
        int res = 0;

        for (int i = 0; i < 56; i++) {
            card = cardFactory.getRandomCard();
            if (card.getClass() == type) {
                res += 1;
            }
        }
        return res;
    }

    @Test
    void numberOfBonus200() {
        assertEquals(5, getCardCount("200 Points Bonus Card"));
        assertEquals(25, getCardCount(Bonus.class));
    }

    @Test
    void numberOfBonus300() {
        assertEquals(5, getCardCount("300 Points Bonus Card"));
        assertEquals(25, getCardCount(Bonus.class));
    }

    @Test
    void numberOfBonus400() {
        assertEquals(5, getCardCount("400 Points Bonus Card"));
        assertEquals(25, getCardCount(Bonus.class));
    }

    @Test
    void numberOfBonus500() {
        assertEquals(5, getCardCount("500 Points Bonus Card"));
        assertEquals(25, getCardCount(Bonus.class));
    }

    @Test
    void numberOfBonus600() {
        assertEquals(5, getCardCount("600 Points Bonus Card"));
        assertEquals(25, getCardCount(Bonus.class));
    }

    @Test
    void numberOfCloverleaf() {
        assertEquals(1, getCardCount(CloverLeaf.class));
    }

    @Test
    void numberOfFirework() {
        assertEquals(5, getCardCount(Firework.class));
    }

    @Test
    void numberOfPlusMinus() {
        assertEquals(5, getCardCount(PlusMinus.class));
    }

    @Test
    void numberOfStop() {
        assertEquals(10, getCardCount(Stop.class));
    }

    @Test
    void numberOfStraight() {
        assertEquals(5, getCardCount(Straight.class));
    }

    @Test
    void numberOfX2() {
        assertEquals(5, getCardCount(X2.class));
    }
}