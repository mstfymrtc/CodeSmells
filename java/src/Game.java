import enums.Symbol;

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
        else if (_board.tileAt(new Location(x, y)).symbol != Symbol.EMPTY) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.addTileAt(symbol, new Location(x, y));
    }

    public Symbol Winner() {
        if (checkThePositionsInRows(0)) return _board.tileAt(new Location(0, 0)).symbol;
        if (checkThePositionsInRows(1)) return _board.tileAt(new Location(1, 0)).symbol;
        if (checkThePositionsInRows(2)) return _board.tileAt(new Location(2, 0)).symbol;

        return Symbol.EMPTY;
    }

    private boolean checkThePositionsInRows(int row) {
        //if the positions in first row are taken
        if (checkTheEmptyPositionsInCols(row)) {
            //if middle row is full with same symbol
            if (checkTheIdenticalValuesInRow(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTheIdenticalValuesInRow(int row) {
        return _board.tileAt(new Location(row, 0)).symbol ==
                _board.tileAt(new Location(row, 1)).symbol &&
                _board.tileAt(new Location(row, 2)).symbol ==
                        _board.tileAt(new Location(row, 1)).symbol;
    }

    private boolean checkTheEmptyPositionsInCols(int row) {
        return _board.tileAt(new Location(row, 0)).symbol != Symbol.EMPTY &&
                _board.tileAt(new Location(row, 1)).symbol != Symbol.EMPTY &&
                _board.tileAt(new Location(row, 2)).symbol != Symbol.EMPTY;
    }
}

