import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public void isFinish() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        State s = State.first_state();
        Node n = new Node("computer", null, s, 0);
        assertFalse(n.isFinish());

        n.getState().getplayer1().getStone1().setPosition(84);
        n.getState().getplayer1().getStone2().setPosition(84);
        n.getState().getplayer1().getStone3().setPosition(84);
        n.getState().getplayer1().getStone4().setPosition(84);
        assertTrue(n.isFinish());

        n.getState().getplayer1().getStone1().setPosition(83);
        n.getState().getplayer2().getStone1().setPosition(84);
        n.getState().getplayer2().getStone2().setPosition(84);
        n.getState().getplayer2().getStone3().setPosition(84);
        n.getState().getplayer2().getStone4().setPosition(84);
        assertTrue(n.isFinish());
    }

    @Test
    public void heuristicReturnsMaxValue() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        State s = State.first_state();
        s.getplayer2().getStone1().setPosition(84);
        s.getplayer2().getStone2().setPosition(84);
        s.getplayer2().getStone3().setPosition(84);
        s.getplayer2().getStone4().setPosition(84);
        Node n = new Node("computer", null, s, 0);
        System.out.println("the value of the heurestic is " + n.heuristic());
        assertEquals(Integer.MAX_VALUE, n.heuristic());

        n.getState().getplayer2().getStone4().setPosition(81);
        assertNotEquals(Integer.MAX_VALUE, n.heuristic());
    }

    @Test
    public void heuristicReturnsMinValue() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        State s = State.first_state();
        s.getplayer1().getStone1().setPosition(84);
        s.getplayer1().getStone2().setPosition(84);
        s.getplayer1().getStone3().setPosition(84);
        s.getplayer1().getStone4().setPosition(84);
        Node n = new Node("humman", null, s, 0);
        System.out.println("the value of the heurestic is " + n.heuristic());
        assertEquals(Integer.MIN_VALUE, n.heuristic());

        n.getState().getplayer1().getStone4().setPosition(81);
        assertNotEquals(Integer.MIN_VALUE, n.heuristic());
    }
}
