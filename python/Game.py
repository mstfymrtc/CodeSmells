from Board import Board


class Game(object):

    def __init__(self):
        self._lastSymbol = ' '
        self._board = Board()

    def play(self, symbol, x, y):
        # if first move
        if self._lastSymbol == ' ':
            # if player is X
            if symbol == 'O':
                raise Exception('Invalid first player')
        # if not first move but player repeated
        elif symbol == self._lastSymbol:
            raise Exception('Invalid next player')
        # if not first move but play on an already played tile
        elif self._board.TileAt(x, y).enums.Symbol != ' ':
            raise Exception('Invalid position')

        # update game state
        self._lastSymbol = symbol
        self._board.AddTileAt(symbol, x, y)

    def winner(self):
        # if the positions in first row are taken
        if self._board.TileAt(0, 0).enums.Symbol != ' ' \
                and self._board.TileAt(0, 1).enums.Symbol != ' ' \
                and self._board.TileAt(0, 2).enums.Symbol != ' ':
            # if first row is full with same symbol
            if self._board.TileAt(0, 0).enums.Symbol == self._board.TileAt(0, 1).enums.Symbol \
                    and self._board.TileAt(0, 2).enums.Symbol == self._board.TileAt(0, 1).enums.Symbol:
                return self._board.TileAt(0, 0).enums.Symbol

        # if the positions in first row are taken
        if self._board.TileAt(1, 0).enums.Symbol != ' ' \
                and self._board.TileAt(1, 1).enums.Symbol != ' ' \
                and self._board.TileAt(1, 2).enums.Symbol != ' ':
            # if first row is full with same symbol
            if self._board.TileAt(1, 0).enums.Symbol == self._board.TileAt(1, 1).enums.Symbol \
                    and self._board.TileAt(1, 2).enums.Symbol == self._board.TileAt(1, 1).enums.Symbol:
                return self._board.TileAt(1, 0).enums.Symbol

        # if the positions in first row are taken
        if self._board.TileAt(2, 0).enums.Symbol != ' ' \
                and self._board.TileAt(2, 1).enums.Symbol != ' ' \
                and self._board.TileAt(2, 2).enums.Symbol != ' ':
            # if first row is full with same symbol
            if self._board.TileAt(2, 0).enums.Symbol == self._board.TileAt(2, 1).enums.Symbol \
                    and self._board.TileAt(2, 2).enums.Symbol == self._board.TileAt(2, 1).enums.Symbol:
                return self._board.TileAt(2, 0).enums.Symbol

        return ' '
