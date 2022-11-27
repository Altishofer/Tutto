package Cards;

import Board.Board;

import java.util.Scanner;

public class StubCardX2Stop extends X2 {
    public StubCardX2Stop() {
        roll = new StubRoll();
    }

    @Override
    public boolean stopOrRoll(){
        return true; // assume user inputs "e" or "E"
    }
}
