import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    // @Test
    // public void expectReturnHeuristicWhenDepth0() {
    // Game game = new Game();
    // State s = State.first_state();
    // Node n = new Node("max", null, s, 0);
    // int value = game.expectIMinMax(n, 0);
    // System.out.println(n.heuristic());
    // assertEquals(value, n.heuristic());
    // }

    // @Test
    // public void expectReturnHeuristicWhenNodeFinish() {
    // System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    // Game game = new Game();
    // State s = State.first_state();
    // s.getplayer1().getStone1().setPosition(84);
    // s.getplayer1().getStone2().setPosition(84);
    // s.getplayer1().getStone3().setPosition(84);
    // s.getplayer1().getStone4().setPosition(84);
    // System.out.println(s.isfinished(1));
    // Node n = new Node("computer", null, s, 0);
    // int value = game.expectIMinMax(n, 1);
    // System.out.println(n.heuristic());
    // assertEquals(value, n.heuristic());
    // }
}
