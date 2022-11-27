package Utils;

import java.util.Objects;

public class Tuple{

    private int first;
    private boolean second;

    public Tuple(int first, boolean second){
            this.first = first;
            this.second = second;
    }

    public int getFirst(){return first;}
    public boolean getSecond(){return second;}

    @Override
    public String toString() {
        return "first: "+first+", second: "+second;
    }

    @Override
    public boolean equals(Object otherTuple) {
        return (((Tuple)otherTuple).first == this.first &&
                ((Tuple)otherTuple).second == this.second);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hashCode(first) + Objects.hashCode(second);
    }
}
