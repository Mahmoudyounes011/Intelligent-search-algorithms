
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Game {
    public void start() {

    }

    public int expectIMinMax(Node n, int depth) {
        return expectIMinMax(n, depth, null);
    }

    public int expectIMinMax(Node n, int depth, ArrayList<String> dices) {
        if (depth == 0 || n.isFinish()) {
            return n.heuristic();
        }

        HashSet<ArrayList<String>> toThrowDices = new HashSet<>();

        ArrayList<State> states = new ArrayList<>();
        ArrayList<Node> childrenNodes = new ArrayList<>();
        if (n.getType() == "max") {
            if (dices.isEmpty()) {
                toThrowDices = Throws.getThrows();
            } else {
                toThrowDices = new HashSet<>(Throws.getPermutations(dices));

            }
            for (ArrayList<String> t : toThrowDices) {
                childrenNodes.add(new Node("chance", n.getParent(), n.getState(), depth - 1));
                n.setThrownDice(t);
            }
            int value = Integer.MIN_VALUE;
            for (Node node : childrenNodes) {
                value = Integer.max(value, expectIMinMax(node, depth - 1, n.getThrownDice()));
            }
            return value;
        } else if (n.getType() == "min") {
            if (dices.isEmpty()) {
                toThrowDices = Throws.getThrows();
            } else {
                toThrowDices = new HashSet<>(Throws.getPermutations(dices));

            }
            for (ArrayList<String> t : toThrowDices) {
                childrenNodes.add(new Node("chance", n.getParent(), n.getState(), depth - 1));
                n.setThrownDice(t);
            }
            int value = Integer.MAX_VALUE;
            for (Node node : childrenNodes) {
                value = Integer.min(value, expectIMinMax(node, depth - 1, n.getThrownDice()));
            }
            return value;
        } else if (n.getType() == "chance") {
            // states = State.nextState(n.getThrownDice());
            for (State state : states) {
                childrenNodes.add(new Node(n.getParent().getType() == "min" ? "max" : "min", n, state, depth - 1));
            }
            int value = 0;

            for (Node node : childrenNodes) {
                value += node.getChance() * expectIMinMax(node, depth - 1);
            }
            return value;
        }
        return 0;
    }

}
