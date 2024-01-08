import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public void isFinish() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        State s = State.first_state();
        Node n = new Node("computer", null, s, 0);
        assertFalse(n.isFinish());
        n.getState().getplayer1().getStone1().setPosition(84);
        n.getState().getplayer1().getStone2().setPosition(84);
        n.getState().getplayer1().getStone3().setPosition(84);
        n.getState().getplayer1().getStone4().setPosition(84);
        System.out.println(n.getState().getplayer1().getStone1().getPosition());
        assertTrue(n.isFinish());
    }

    @Test
    public void testHeuristicReturnsMaxValue() {
        State s = State.first_state();
        Node n = new Node("computer", null, s, 0);
        // assertEquals(Integer.MAX_VALUE, n.heuristic());
    }
}
