package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyWeightCardTest {

    //TODO: Pädi

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

    @Test
    void numberOfBonus200() {
        assertEquals(5, getCardCount("200 Points Bonus Card"));
    }

    @Test
    void numberOfBonus300() {
        assertEquals(5, getCardCount("300 Points Bonus Card"));
    }

    @Test
    void numberOfBonus400() {
        assertEquals(5, getCardCount("400 Points Bonus Card"));
    }

    @Test
    void numberOfBonus500() {
        assertEquals(5, getCardCount("500 Points Bonus Card"));
    }

    @Test
    void numberOfBonus600() {
        assertEquals(5, getCardCount("600 Points Bonus Card"));
    }

    @Test
    void numberOfCloverleaf() {
        assertEquals(1, getCardCount("Cloverleaf-Card"));
    }

    @Test
    void numberOfFirework() {
        assertEquals(5, getCardCount("Firework-Card"));
    }

    @Test
    void numberOfPlusMinus() {
        assertEquals(5, getCardCount("Plus/Minus-Card"));
    }

    @Test
    void numberOfStop() {
        assertEquals(10, getCardCount("Stop-Card"));
    }

    @Test
    void numberOfStraight() {
        assertEquals(5, getCardCount("Straight-Card"));
    }

    @Test
    void numberOfX2() {
        assertEquals(5, getCardCount("X2-Card"));
    }
}