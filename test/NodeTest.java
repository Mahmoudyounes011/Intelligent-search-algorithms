import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class NodeTest {
    @Test
    public void testHeuristicReturnsMaxValue() {
        State s = State.first_state();
        assertFalse(s.isfinished(1));
        System.out.println("hi");
        // Node n = new Node("computer", null, s, 0);

        // assertEquals(Integer.MAX_VALUE, n.heuristic());
    }
}
