package Board;

import Cards.Card;

import java.io.InputStream;
import java.util.Scanner;

public class StubBoard extends Board{

    public StubBoard(Integer pMaxPoints, Integer pNumberOfPlayers, InputStream inputStream) {
        super(pMaxPoints,pNumberOfPlayers);
        super.aScanner = new Scanner(inputStream);
    }

    public void setCommand(String command) {
        StubFlyWeightDeck.setCommand(command);
    }

    @Override
    protected Card getRandomCard() {
        return StubFlyWeightDeck.getRandomCard();
    }

    public void setStubNr(String command) {
        StubFlyWeightDeck.setStubNr(command);
    }

    public StubBoard(Integer pMaxPoints, Integer pNumberOfPlayers) {
        super(pMaxPoints,pNumberOfPlayers);
    }

    @Override
    protected void setUpPlayers(Integer numberOfPlayer){
        if(numberOfPlayer>1){
            for(int i = 1; i<=numberOfPlayer;i++){
                Player player = new Player("player"+i);
                player.addPoints(1500);
                aPlayers.add(player);
            }
        }else{
            Player player = new Player("player1");
            player.addPoints(1500);
            aPlayers.add(player);
        }
    }
}
