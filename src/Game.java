import java.util.ArrayList;

public class Game {
    public void start() {

    }

    public int expectIMinMax(Node n, int depth, String player_sending) {
        return expectIMinMax(n, depth, player_sending, null);
    }

    public int expectIMinMax(Node n, int depth, String player_sending, ArrayList<String> dices) {
        if (depth == 0 || n.isFinish()) {
            return n.heuristic();
        }

        ArrayList<String> toThrowDices = new ArrayList<>();

        // add the possible throw
        if (dices != null) {
            toThrowDices = dices;
        }

        // ArrayList<State> states = n.getState().nextstate(n.getState(), toThrowDices);
        ArrayList<State> states = new ArrayList<>();
        ArrayList<Node> childrenNodes = new ArrayList<>();
        if (n.getType() == "max") {
            for (State state : states) {
                // add chance to node
                childrenNodes.add(new Node("chance", n, state, depth - 1));
            }
            int value = 0;
            for (Node node : childrenNodes) {
                value = Integer.max(value, expectIMinMax(node, depth - 1, "max"));
            }
            return value;
        } else if (n.getType() == "min") {
            for (State state : states) {
                childrenNodes.add(new Node("chance", n, state, depth - 1));
            }
            int value = 0;
            for (Node node : childrenNodes) {
                value = Integer.min(value, expectIMinMax(node, depth - 1, "min"));
            }
            return value;
        } else if (n.getType() == "chance") {
            for (State state : states) {
                childrenNodes.add(new Node("chance", n, state, depth - 1));
            }
            int value = 0;
            for (Node node : childrenNodes) {
                // value += node.chance * expectIMinMax(node, depth - 1, player_sending == "min"
                // ? "max" : "min")
            }
            return value;
        }
        return 0;
    }
}
