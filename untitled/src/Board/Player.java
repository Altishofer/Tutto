package Board;

public class Player implements Comparable{

    // TODO: adrian

    private static String PLAYER_NAME;
    private int aPoints;

    public Player (String pName){
        aPoints = 0;
        PLAYER_NAME = pName;
    }

    public String getPlayerName(){return PLAYER_NAME;}

    public Character getPlayerInitial(){return PLAYER_NAME.charAt(0);}

    public void addPoints(int pPoints){
        aPoints += pPoints;
        System.out.println(PLAYER_NAME.toUpperCase() + " -> you currently have a score of "  + aPoints + " points");
    }

    public int getPoints(){
        return aPoints;
    }

    @Override
    public int compareTo(Object other) {
        if (other == null){return 0;}
        if (this.getClass() != other.getClass()){return 0;}
        Player otherPlayer = (Player) other;
        if (this.getPlayerInitial() < otherPlayer.getPlayerInitial()){return -1;}
        if (this.getPlayerInitial() > otherPlayer.getPlayerInitial()){return 1;}
        return 0;
    }
}
