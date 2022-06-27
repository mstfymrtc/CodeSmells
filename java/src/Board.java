import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(new Location(i, j));
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(Location location) {
        for (Tile t : _plays) {
            if (t.isLocatedAt(location)) {
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Location location) {
        Tile newTile = new Tile(location);
        newTile.Symbol = symbol;

        TileAt(location).Symbol = symbol;
    }
}