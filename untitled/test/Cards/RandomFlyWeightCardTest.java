package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomFlyWeightCardTest {

    //TODO: Pädi

    @Test
    void getRandomCard() {
        var card = new FlyWeightDeck();
        card.getRandomCard();
    }
}