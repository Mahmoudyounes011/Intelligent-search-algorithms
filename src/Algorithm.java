import java.util.ArrayList;
import java.util.HashSet;

public class Algorithm {

    public Node expectIMinMax(Node n, int depth) {
        return expectIMinMax(n, depth, null);
    }

    public Node expectIMinMax(Node n, int depth, ArrayList<String> dices) {

        HashSet<ArrayList<String>> toThrowDices = new HashSet<>();

        ArrayList<Node> childrenNodes = new ArrayList<>();
        if (n.getType() == "max") {
            Node maxNode = new Node(n);
            if (dices.isEmpty()) {
                toThrowDices = Throws.getThrows();
            } else {
                toThrowDices = new HashSet<>(Throws.getPermutations(dices));

            }
            for (ArrayList<String> t : toThrowDices) {
                Node tempNode = new Node("chance", n.getParent(), n.getState(), depth - 1);
                childrenNodes.add(tempNode);
                tempNode.setThrownDice(t);
            }
            double value = Double.MIN_VALUE;
            for (Node node : childrenNodes) {
                value = Double.max(value, chance(node, depth - 1, node.getThrownDice()));
                maxNode = new Node(node);
                maxNode.setChance(value);
            }
            return maxNode;
        } else {
            Node minNode = new Node(n);
            if (dices.isEmpty()) {
                toThrowDices = Throws.getThrows();
            } else {
                toThrowDices = new HashSet<>(Throws.getPermutations(dices));

            }
            for (ArrayList<String> t : toThrowDices) {
                Node tempNode = new Node("chance", n.getParent(), n.getState(), depth - 1);
                childrenNodes.add(tempNode);
                tempNode.setThrownDice(t);
            }
            double value = Double.MAX_VALUE;
            for (Node node : childrenNodes) {
                value = Double.min(value, chance(node, depth - 1, n.getThrownDice()));
                minNode = new Node(node);
                minNode.setChance(value);
            }
            return minNode;
        }
    }

    private double chance(Node n, int depth, ArrayList<String> dices) {

        if (depth == 0 || n.isFinish()) {
            return n.heuristic();
        }
        ArrayList<State> states = new ArrayList<>();
        ArrayList<Node> childrenNodes = new ArrayList<>();

        states = State.nextstate(n.getState(), n.getThrownDice(), n.getParent().getType() == "min" ? 1 : 2);
        for (State state : states) {
            childrenNodes.add(new Node(n.getParent().getType() == "min" ? "max" : "min", n, state, depth - 1));
        }
        double value = 0;
        double prob = Dice.getDiceProbability(dices);
        for (Node node : childrenNodes) {
            value += prob * expectIMinMax(node, depth - 1).getChance();
            node.setChance(value);
        }
        return value;
    }

}
