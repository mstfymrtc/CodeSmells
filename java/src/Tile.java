
public class Tile {
    public Location location;
    public Symbol symbol;

    public Tile(Location location) {
        this.location = location;
    }

    public boolean isLocatedAt(Location location) {
        return location.equals(this.location);
    }
}