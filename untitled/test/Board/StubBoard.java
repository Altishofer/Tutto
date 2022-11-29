package Board;

import java.io.InputStream;
import java.util.Scanner;

public class StubBoard extends Board{

    public StubBoard(Integer pMaxPoints, Integer pNumberOfPlayers, InputStream inputStream) {
        super(pMaxPoints,pNumberOfPlayers);
        super.aRandomCardFactory = new StubFlyWeightDeck();
        super.aScanner = new Scanner(inputStream);
    }

    public void setCommand(String command) {
        ((StubFlyWeightDeck) aRandomCardFactory).setCommand(command);
    }
    public void setStubNr(String command) {
        ((StubFlyWeightDeck) aRandomCardFactory).setStubNr(command);
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
