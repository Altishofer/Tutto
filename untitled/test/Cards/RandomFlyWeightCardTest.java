package Cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomFlyWeightCardTest {

    // TODO: Pädi, add asserts, create all cards and count them

    @Test
    void getRandomCard() {
        var card = new FlyWeightDeck();
        card.getRandomCard();
    }
}