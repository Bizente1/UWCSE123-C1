import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Testing {
    @Test
    @DisplayName("STUDENT TEST CASE - Win Condition")
    public void firstCaseTest() {
        AbstractStrategyGame g = new ConnectFour();
        assertEquals(ConnectFour.PLAYER_1, g.getNextPlayer(), "Player 1 not next player after construction");
        assertEquals(ConnectFour.GAME_NOT_OVER, g.getWinner(), "Winner incorrectly declared after construction");
        assertFalse(g.isGameOver(), "Game over immediately after construction");

        g.makeMove("1");

        assertEquals(ConnectFour.PLAYER_2, g.getNextPlayer(), "Player 2 not next player after a single move");
        assertEquals(ConnectFour.GAME_NOT_OVER, g.getWinner(), "Winner incorrectly declared after a single move");
        assertFalse(g.isGameOver(), "Game over immediately after construction");
    }

    @Test
    @DisplayName("STUDENT TEST CASE - Illegal Move")
    public void secondCaseTest() {
        AbstractStrategyGame g = new ConnectFour();
        assertTrue("**Illegal move: The number was not in the acceptiable range", g.makeMove("20"));

    }
}
