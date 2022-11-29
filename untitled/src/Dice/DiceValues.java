package Dice;

public enum DiceValues {
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1);

    public final int aValue;
    DiceValues(int value){
        this.aValue = value;
    }

    @Override
    public String toString(){return this.name().toLowerCase();}

    public int getInteger(){
        return this.aValue;
    }
}
