import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class AlgorithmTest {

    @Test
    public void testChanceReturnHeuristicWhenDepth0() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        Algorithm algorithm = new Algorithm();
        State s = State.first_state();
        Node n = new Node("max", null, s, 0);
        double value = algorithm.chance(n, 0, null);
        System.out.println(n.heuristic());
        assertEquals(value, n.heuristic());
    }

    @Test
    public void testChanceReturnHeuristicWhenNodeFinish() {
        System.out.println("*".repeat(10));
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        Algorithm algorithm = new Algorithm();
        State s = State.first_state();
        s.getplayer1().getStone1().setPosition(84);
        s.getplayer1().getStone2().setPosition(84);
        s.getplayer1().getStone3().setPosition(84);
        s.getplayer1().getStone4().setPosition(84);
        System.out.println(s.isfinished(1));
        Node n = new Node("max", null, s, 0);
        double value = algorithm.chance(n, 1, null);
        System.out.println(n.heuristic());
        assertEquals(value, n.heuristic());
    }

    @Test
    public void testChance() {
        // System.out.println("*".repeat(10));
        // System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        // Algorithm algorithm = new Algorithm();
        // State s = State.first_state();
        // Node n = new Node("max", null, s, 1);
        // ArrayList<String> dices = new ArrayList<>();
        // dices.add(Dice.KHAL);
        // n.setThrownDice(dices);
        // double value = algorithm.chance(n, 2, dices);

    }
}
