
public class Tile {
    public Tile(Location location) {
        this.location = location;
    }

    public Location location;
    public char Symbol;

    public boolean isLocatedAt(Location location) {
        return location.equals(this.location);
    }
}