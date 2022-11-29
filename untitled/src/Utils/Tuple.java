package Utils;

import java.util.Objects;

public class Tuple{

    private int aFirst;
    private boolean aSecond;

    public Tuple(int first, boolean second){
            this.aFirst = first;
            this.aSecond = second;
    }

    public int getFirst(){return aFirst;}
    public boolean getSecond(){return aSecond;}

    @Override
    public String toString() {
        return "first: "+ aFirst +", second: "+ aSecond;
    }

    @Override
    public boolean equals(Object otherTuple) {
        return (((Tuple)otherTuple).aFirst == this.aFirst &&
                ((Tuple)otherTuple).aSecond == this.aSecond);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hashCode(aFirst) + Objects.hashCode(aSecond);
    }
}
