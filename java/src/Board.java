import enums.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(new Location(i, j), Symbol.EMPTY);
                _plays.add(tile);
            }
        }
    }

    public Tile tileAt(Location location) {
        for (Tile t : _plays) {
            if (t.isLocatedAt(location)) {
                return t;
            }
        }
        return null;
    }

    public void addTileAt(Symbol symbol, Location location) {
        tileAt(location).symbol = symbol;
    }

}