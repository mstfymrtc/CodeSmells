import java.util.Objects;

public class Location {
    public int X;
    public int Y;

    public Location(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return X == location.X && Y == location.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
