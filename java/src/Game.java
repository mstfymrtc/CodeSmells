public class Game {
    private Symbol _lastSymbol = Symbol.EMPTY;
    private Board _board = new Board();

    public void Play(Symbol symbol, int x, int y) throws Exception {
        //if first move
        if (Symbol.EMPTY == _lastSymbol) {
            //if player is X
            if (Symbol.O == symbol) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(new Location(x, y)).symbol != Symbol.EMPTY) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, new Location(x, y));
    }

    public Symbol Winner() {
        //if the positions in first row are taken
        if (_board.TileAt(new Location(0, 0)).symbol != Symbol.EMPTY &&
                _board.TileAt(new Location(0, 1)).symbol != Symbol.EMPTY &&
                _board.TileAt(new Location(0, 2)).symbol != Symbol.EMPTY) {
            //if first row is full with same symbol
            if (_board.TileAt(new Location(0, 0)).symbol ==
                    _board.TileAt(new Location(0, 1)).symbol &&
                    _board.TileAt(new Location(0, 2)).symbol == _board.TileAt(new Location(0, 1)).symbol) {
                return _board.TileAt(new Location(0, 0)).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(new Location(1, 0)).symbol != Symbol.EMPTY &&
                _board.TileAt(new Location(1, 1)).symbol != Symbol.EMPTY &&
                _board.TileAt(new Location(1, 2)).symbol != Symbol.EMPTY) {
            //if middle row is full with same symbol
            if (_board.TileAt(new Location(1, 0)).symbol ==
                    _board.TileAt(new Location(1, 1)).symbol &&
                    _board.TileAt(new Location(1, 2)).symbol ==
                            _board.TileAt(new Location(1, 1)).symbol) {
                return _board.TileAt(new Location(1, 0)).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(new Location(2, 0)).symbol != Symbol.EMPTY &&
                _board.TileAt(new Location(2, 1)).symbol != Symbol.EMPTY &&
                _board.TileAt(new Location(2, 2)).symbol != Symbol.EMPTY) {
            //if middle row is full with same symbol
            if (_board.TileAt(new Location(2, 0)).symbol ==
                    _board.TileAt(new Location(2, 1)).symbol &&
                    _board.TileAt(new Location(2, 2)).symbol ==
                            _board.TileAt(new Location(2, 1)).symbol) {
                return _board.TileAt(new Location(2, 0)).symbol;
            }
        }

        return Symbol.EMPTY;
    }
}

