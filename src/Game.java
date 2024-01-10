
import java.util.ArrayList;
import java.util.Collections;

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

        ArrayList<ArrayList<String>> toThrowDices = new ArrayList<>();

        ArrayList<State> states = new ArrayList<>();
        ArrayList<Node> childrenNodes = new ArrayList<>();
        if (n.getType() == "max") {
            if (dices.isEmpty()) {
                // toThrowDices= Throws.generateThrows(0,new ArrayList<String>(), new
                // ArrayList<>(), 1);
            } else {
                toThrowDices = Throws.getPermutations(dices);

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
                // toThrowDices= Throws.generateThrows(0,new ArrayList<String>(), new
                // ArrayList<>(), 1);
            } else {
                toThrowDices = Throws.getPermutations(dices);

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
