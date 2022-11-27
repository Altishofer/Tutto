package Board;

import Roll.Roll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private Player aPlayer = new Player("PlayerName");

    @Test
    void getPlayerName() { assertEquals("PlayerName", aPlayer.getPlayerName()); }

    @Test
    void getPlayerInitial() { assertEquals('P', aPlayer.getPlayerInitial()); }

    @Test
    void addPoints() {
        Player mPlayer = new Player("PlayerName");
        int pointsBefore = mPlayer.getPoints();
        mPlayer.addPoints(1000);
        assertEquals(1000, mPlayer.getPoints() - pointsBefore);
    }

    @Test
    void getPoints() {
        Player mPlayer = new Player("PlayerName");
        assertEquals(0, mPlayer.getPoints());
        mPlayer.addPoints(500);
        assertEquals(500, mPlayer.getPoints());
    }

    @Test
    void compareTo_Null() { assertEquals(0, aPlayer.compareTo(null)); }

    @Test
    void compareTo_ObjectOfOtherClass() { assertEquals(0, aPlayer.compareTo(new Roll())); }

    @Test
    void compareTo_greaterPlayerInitial() {
        Player mPlayer = new Player("A_PlayerName");
        Player other = new Player("B_PlayerName");
        assertEquals(-1, mPlayer.compareTo(other));
    }

    @Test
    void compareTo_smallerPlayerInitial() {
        Player mPlayer = new Player("B_PlayerName");
        Player other = new Player("A_PlayerName");
        assertEquals(1, mPlayer.compareTo(other));
    }

    @Test
    void compareTo_samePlayerInitial() {
        Player mPlayer = new Player("PlayerName");
        Player other = new Player("PlayerName");
        assertEquals(0, mPlayer.compareTo(other));
    }
}