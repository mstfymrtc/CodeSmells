import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Game_Should {
    private Game game;

    @BeforeEach
    public void InitializeGame() {
        game = new Game();
    }

    @Test
    void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.Play(Symbol.O, 0, 0));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () -> {
            game.Play(Symbol.X, 0, 0);
            game.Play(Symbol.X, 1, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () -> {
            game.Play(Symbol.X, 0, 0);
            game.Play(Symbol.O, 0, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () -> {
            game.Play(Symbol.X, 0, 0);
            game.Play(Symbol.O, 1, 0);
            game.Play(Symbol.X, 0, 0);
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception {
        game.Play(Symbol.X, 0, 0);
        game.Play(Symbol.O, 1, 0);
        game.Play(Symbol.X, 0, 1);
        game.Play(Symbol.O, 1, 1);
        game.Play(Symbol.X, 0, 2);

        Symbol winner = game.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception {
        game.Play(Symbol.X, 2, 2);
        game.Play(Symbol.O, 0, 0);
        game.Play(Symbol.X, 1, 0);
        game.Play(Symbol.O, 0, 1);
        game.Play(Symbol.X, 1, 1);
        game.Play(Symbol.O, 0, 2);

        Symbol winner = game.Winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.Play(Symbol.X, 1, 0);
        game.Play(Symbol.O, 0, 0);
        game.Play(Symbol.X, 1, 1);
        game.Play(Symbol.O, 0, 1);
        game.Play(Symbol.X, 1, 2);

        Symbol winner = game.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.Play(Symbol.X, 0, 0);
        game.Play(Symbol.O, 1, 0);
        game.Play(Symbol.X, 2, 0);
        game.Play(Symbol.O, 1, 1);
        game.Play(Symbol.X, 2, 1);
        game.Play(Symbol.O, 1, 2);

        Symbol winner = game.Winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception {
        game.Play(Symbol.X, 2, 0);
        game.Play(Symbol.O, 0, 0);
        game.Play(Symbol.X, 2, 1);
        game.Play(Symbol.O, 0, 1);
        game.Play(Symbol.X, 2, 2);

        Symbol winner = game.Winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception {
        game.Play(Symbol.X, 0, 0);
        game.Play(Symbol.O, 2, 0);
        game.Play(Symbol.X, 1, 0);
        game.Play(Symbol.O, 2, 1);
        game.Play(Symbol.X, 1, 1);
        game.Play(Symbol.O, 2, 2);

        Symbol winner = game.Winner();

        assertEquals(Symbol.O, winner);
    }
}
