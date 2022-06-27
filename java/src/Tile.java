import enums.Symbol;

public class Tile {
    public Location location;
    public Symbol symbol;

    public Tile(Location location, Symbol symbol) {
        this.location = location;
        this.symbol = symbol;
    }

    public boolean isLocatedAt(Location location) {
        return location.equals(this.location);
    }
}