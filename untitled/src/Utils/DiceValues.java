package Utils;

public enum DiceValues {
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1);

    public final int value;
    DiceValues(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        String name = this.name();
        return name.toLowerCase();
    }
}
