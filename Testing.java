import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Testing {
    @Test
    @DisplayName("STUDENT TEST CASE - Win Condition")
    public void firstCaseTest() {
        AbstractStrategyGame g = new ConnectFour();
        g.makeMove("1");
        g.makeMove("1");
        g.makeMove("2");
        g.makeMove("2");
        g.makeMove("3");
        g.makeMove("3");
        g.makeMove("4");
        assertEquals(1, g.getWinner());
    }

    @Test
    @DisplayName("STUDENT TEST CASE - Illegal Move")
    public void secondCaseTest() {
        AbstractStrategyGame g = new ConnectFour();
        assertThrows(IllegalArgumentException.class, () ->{
            g.makeMove("20");
        });

    }
}
